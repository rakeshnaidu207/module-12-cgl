package cgl;

public class nextgeneration {
  int currentstage;
  int previousstage;
  int noofdeadcells;
  int noofbirthcells;

public void generatenextgeneration(boolean current[][]) {
    int n = current.length;
    boolean[][] newBoard = new boolean[n][n];
    // lives = 3;
    // board = createBoard(n,l);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int ilives = countlivecells(current, i, j);

            if (current[i][j]) {
                if (ilives < 2) {
                    newBoard[i][j] = false;
                } else if (ilives <= 3) {
                    newBoard[i][j] = true;
                } else if (ilives > 3) {
                    newBoard[i][j] = false;
                }
            } else {
                if (ilives == 3) {
                    newBoard[i][j] = true;
                }
            }

        }
    }
    printboard bollean[][];
}

private int countlivecells(boolean[][] current, int i, int j) {
	// TODO Auto-generated method stub
	return 0;
}
}

