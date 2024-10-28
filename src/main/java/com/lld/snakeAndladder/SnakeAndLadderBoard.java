package com.lld.snakeAndladder;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class SnakeAndLadderBoard {

    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<String,Integer> playerPieces;

    public SnakeAndLadderBoard(int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPieces = new HashMap<>();
    }
}
