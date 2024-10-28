package com.lld.snakeAndladder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter

public class Player {
    private String name;
    private String id;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}
