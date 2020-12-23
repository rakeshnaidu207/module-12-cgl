package cgl;

public class printboard {


public void printBoard(boolean board[][]) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            // System.out.print(board[i][j]+" ");
            if (board[i][j])
                sb.append("*");
            else
                sb.append(".");

        }
        sb.append("\n");
    }
    System.out.print(sb.toString());
}
}
