package com.lld.splitwise;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Group {

    String id;
    String name;
    List<User> users;
    List<Expense> expenses;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        this.users = new CopyOnWriteArrayList<>();
        this.expenses = new CopyOnWriteArrayList<>();
    }


    public void addUser(User user) {
        users.add(user);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
