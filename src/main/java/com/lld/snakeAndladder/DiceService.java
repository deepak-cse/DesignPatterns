package com.lld.snakeAndladder;

import java.util.Random;

public class DiceService {

    public static int rollDice(){
        return new Random().nextInt(6)+1;
    }
}
