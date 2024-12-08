package com.lld.tictaetoe;

public class Board {

    private static final int size=3;
    private final char grid[][];

    int countMove;

    public Board( ) {
        this.countMove=0;
        this.grid = new char[size][size];
        initializeGrid();
    }

    private void initializeGrid() {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j]='-';
            }
        }
    }

    public synchronized void makeMove(int row, int column, Player player) {
        grid[row][column]= player.getSymbol();
        countMove++;
    }

    public int getCountMove() {
        return countMove;
    }

    public void printBoard() {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

    }

    public boolean isFull() {
        return countMove==9?true:false;
    }

    public boolean hasWinner() {
        //check row
        //check column
        //check diagonal



        // Check rows
        for (int row = 0; row < 3; row++) {
            if (grid[row][0] != '-' && grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2]) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (grid[0][col] != '-' && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]) {
                return true;
            }
        }

        // Check diagonals
        if (grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return true;
        }
        return grid[0][2] != '-' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0];
    }
}
