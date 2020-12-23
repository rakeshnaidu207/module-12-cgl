package cgl;

public class createboard {
 int rows;
 int colums;
 int boardsize;
 

public boolean[][] createBoard(int n, int l[][]) {
    boolean[][] board = new boolean[n][n];
    for (int i = 0; i < l.length; i++) {
        // System.out.print(liveCells[i][0]);//row value
        // System.out.print(liveCells[i][1]);//column value
        int row = l[i][0];
        int col = l[i][1];
        board[row][col] = true;
    }
    // System.out.println("Board");
    // You can call the printBoard that prints the board.

    System.out.println("CurrentGenration");
    printboard boollean[][];
    System.out.println("NextGenration");
    return board;
}
}
