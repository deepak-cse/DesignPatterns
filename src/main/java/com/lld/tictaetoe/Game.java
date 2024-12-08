package com.lld.tictaetoe;

import java.util.Scanner;

public class Game {

    Player player1;
    Player player2;
    Board board;
    Player currentPlayer;

    public Game() {
        player1 = new Player("Player1",'X');
        player2 = new Player("Player2",'0');
        board = new Board();
        currentPlayer=player1;
    }

    public void startGame(){
        //mark the grid
        //switch palyer
        //check who won or draw

        while(!board.isFull()&&!board.hasWinner()){
            //ask to enter the input
            System.out.println("Enter the valid input for "+ currentPlayer.getName());
            int row=validInput("Enter row (0-2)");
            int column = validInput("Enter column(0-2)");
            try {
                board.makeMove( row,column , currentPlayer);
                board.printBoard();
                currentPlayer=switchPlayer();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }

        if(board.hasWinner()){
            switchPlayer();
            System.out.println("Winner is player"+ currentPlayer.getName());
        }else {
            System.out.println("its draw");
        }

    }


    private Player switchPlayer() {
        return currentPlayer==player1?player2:player1;
    }

    private int validInput(String message) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(message);
          if(scanner.hasNext()){
              int input = scanner.nextInt();
              if(input>=0&&input<=2){
                  return input;
              }
          }else{
              scanner.next();
          }

            System.out.println("Enter valid input");

        }


    }


}
