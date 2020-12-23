package cgl;

public class countlifecells {
    int currentlength;
    int nooflife;

public int countlivecells(boolean[][] current, int p, int q) {
    int n = current.length;
    int lives = 0;
    for (int i = p - 1; i <= p + 1; i++) {
        for (int j = q - 1; j <= q + 1; j++) {
            if (i != p || j != q) {
                if (i >= 0 && i < n && j >= 0 && j < n && current[i][j]) {
                    lives += 1;
                }
            }
        }
    }
    return lives;
}
}