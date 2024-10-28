package com.lld.snakeAndladder;

import java.util.*;

public class SnakeAndLadderService {

    private SnakeAndLadderBoard snakeAndLadderBoard;
    private String isCompleted;
    private Queue<Player> players;
    private int initialNumberOfPlayers;

    private int noOfDices;

    private static final int DEFAULT_BOARD_SIZE=100;
    private static final int DEFAULT_NO_OF_DICES=1;

    public SnakeAndLadderService(int boardSize) {
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
        this.players = new LinkedList<>();
        this.noOfDices = SnakeAndLadderService.DEFAULT_NO_OF_DICES;


    }

    public SnakeAndLadderService() {
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
    }

    //initialize board

    public void setPlayers(List<Player> players){
        this.players = new LinkedList<>();
        this.initialNumberOfPlayers = players.size();
        Map<String,Integer> playerPieces = new HashMap<>();
        for(Player player: players){
            this.players.add(player);
            playerPieces.put(player.getId(),0);
        }

        snakeAndLadderBoard.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes){
        snakeAndLadderBoard.setSnakes(snakes);
    }


    public void setLadders(List<Ladder> ladders) {
        snakeAndLadderBoard.setLadders(ladders);
    }

    //core business logic


    private  int getNewPositionAfterGoingThroughSnakeAndLadders(int newPosition) {
        int previousPosition;

        do {

            previousPosition = newPosition;
            for(Snake snake: snakeAndLadderBoard.getSnakes()){
                if(snake.getStart()==newPosition){
                    newPosition=snake.getEnd();
                }
            }

            for(Ladder ladder: snakeAndLadderBoard.getLadders()) {
                if(ladder.getStart()==newPosition){
                    newPosition=ladder.getEnd();
                }
            }


        } while(previousPosition!=newPosition);

        return newPosition;




    }



    public void movePlayer(Player player, int positions) {

        int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition+positions;

        int boardSize = snakeAndLadderBoard.getSize();
        if(newPosition>boardSize) {
            newPosition=oldPosition;
        }

        else {
            newPosition=getNewPositionAfterGoingThroughSnakeAndLadders(newPosition);
        }
        snakeAndLadderBoard.getPlayerPieces().put(player.getId(), newPosition);
        System.out.println(player.getName()+"rolled a dice and moved from" + oldPosition + "to " + newPosition);

    }


    private int getTotalValueAfterDiceRolls(){
        return DiceService.rollDice();
    }

    private boolean hasPlayerWon(Player player) {
        int playerPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
        int winningPosiiton = snakeAndLadderBoard.getSize();
        return playerPosition==winningPosiiton;

    }


    private boolean isGameCompleted () {
        int currentNumberofPlayer = players.size();
        return currentNumberofPlayer<initialNumberOfPlayers;
    }

    public void startGame(){
        while(!isGameCompleted()){

            int totalDiceValue = getTotalValueAfterDiceRolls();
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer,totalDiceValue);
            if(hasPlayerWon(currentPlayer)) {
                System.out.println("current player won the game"+ currentPlayer.getName());
                snakeAndLadderBoard.getPlayerPieces().remove(currentPlayer.getId());
            }
            else {
                players.add(currentPlayer);
            }

        }

    }

}
