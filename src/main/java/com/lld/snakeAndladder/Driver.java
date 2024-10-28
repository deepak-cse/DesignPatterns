package com.lld.snakeAndladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\"Enter the number of Snakes\"");
        int numberSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<>();

        for(int i=0;i<numberSnakes;i++) {
            System.out.println("Enter the Position of snake number"+ i);
            snakes.add(new Snake(scanner.nextInt(),scanner.nextInt()));
        }

        System.out.println("\"Enter the number of Ladders\"");
        int numberofLadders = scanner.nextInt();

        List<Ladder> ladders = new ArrayList<>();
        for(int i=0;i<numberofLadders;i++) {
            System.out.println("Enter the Position of ladder number"+ i);
            ladders.add(new Ladder(scanner.nextInt(),scanner.nextInt()));
        }
        System.out.println("\"Enter the number of Players\"");
        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<Player>();
        for(int i=0;i<noOfPlayers;i++) {
            System.out.println("\"Enter the Player Name\"");
            players.add(new Player(scanner.next()));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setLadders(ladders);

        snakeAndLadderService.startGame();


    }


}
