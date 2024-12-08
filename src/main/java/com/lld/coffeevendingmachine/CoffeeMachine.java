package com.lld.coffeevendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {

    private static CoffeeMachine instance = new CoffeeMachine();

    private final List<Coffee> coffeeMenu;

    private final Map<String, Ingredient> ingredients;

    public CoffeeMachine() {
        this.coffeeMenu = new ArrayList<>();
        this.ingredients = new HashMap<>();

        initializeIngredients();
        initializeCoffeeMenu();
    }
    public static CoffeeMachine getInstance() {
        return instance;
    }
    private void initializeCoffeeMenu() {
        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(ingredients.get("Coffee"),1);
        espressoRecipe.put(ingredients.get("Water"),1);
        espressoRecipe.put(ingredients.get("Milk"),1);
        coffeeMenu.add(new Coffee("espresso",2.5,espressoRecipe));

        Map<Ingredient, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(ingredients.get("Coffee"),1);
        latteRecipe.put(ingredients.get("Water"),1);
        latteRecipe.put(ingredients.get("Milk"),1);
        coffeeMenu.add(new Coffee("latte",4.5,latteRecipe));

        Map<Ingredient, Integer> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(ingredients.get("Coffee"),1);
        cappuccinoRecipe.put(ingredients.get("Water"),1);
        cappuccinoRecipe.put(ingredients.get("Milk"),1);
        coffeeMenu.add(new Coffee("cappuccino",3.5,cappuccinoRecipe));

    }

    private void initializeIngredients() {
        ingredients.put("Coffee",new Ingredient("Coffee",10));
        ingredients.put("Milk",new Ingredient("Milk",10));
        ingredients.put("Water",new Ingredient("Water",10));
    }


    public void displayMenu(){
        System.out.println("Coffee menu:");
        for(Coffee coffee : coffeeMenu){
            System.out.println("Coffee "+coffee.getName() + "-$" + coffee.getPrice());
        }
    }

    public synchronized Coffee selectCoffee(String coffeeName){
        for(Coffee coffee : coffeeMenu){
            if(coffee.getName().equalsIgnoreCase(coffeeName)){
                return coffee;
            }
        }

        return null;
    }

    public synchronized void dispenseCoffee(Coffee coffee, Payment payment){
        if(payment.getAmount()>=coffee.getPrice()){
            if(hasEnoughIngredients(coffee)){
                updateIngredients(coffee);
                System.out.println("Dispensing " + coffee.getName()+ "...");
                double change = payment.getAmount() - coffee.getPrice();
                if(change>0){
                    System.out.println("Please collect your change $ " + change);
                }
            }else {
                System.out.println("Insufficient ingredient to make" + coffee.getName());
            }


        }
        else {
            System.out.println("Please make payment");
        }
    }

    private boolean hasEnoughIngredients(Coffee coffee) {

        for(Map.Entry<Ingredient, Integer> entry: coffee.getRecipe().entrySet()){
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            if(ingredient.getQuantity()<requiredQuantity){
                return false;
            }

        }

        return true;
    }

    private void updateIngredients(Coffee coffee){
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRecipe().entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            ingredient.updateQuantity(-requiredQuantity);
            if (ingredient.getQuantity() < 3) {
                System.out.println("Low inventory alert: " + ingredient.getName());
            }
        }
    }


}
