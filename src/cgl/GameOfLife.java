package cgl;


/**CGL version with console based  */

import java.util.Scanner;
import java.io.*;

public class GameOfLife {
    // Set grid size
    int l = 60, b = 60;

    public static void main(String[] args) {

        GameOfLife now = new GameOfLife();
        now.setGame();
    }

    // SetGame
    void setGame() {
        char[][] config = new char[l][b];
        startGame(config, l, b);
    }

    // Start Game method
    void startGame(char[][] mat, int l, int b) {
        Scanner s = new Scanner(System.in);
        String ch = "";
        float per = 0;
        while (!ch.equals("y")) {
            per = setConfig(mat);
            display2D(mat);
            System.out.println((per * 100) + "% of grid filled.Do you want to continue y/n  ");
            ch = s.nextLine();
        }
        while (!ch.equals("x")) // Game loop
        {
            mat = transform(mat, l, b);
            display2D(mat);

            System.out.println("Ctrl+Z to stop.");

            try {
                Thread.sleep(100); // making delay one second
            } catch (Exception e) {
                System.out.println("Something went horribly wrong.");// exception handling
            }

        }
        s.close();
        System.out.println("Game Over"); // exception raised
    }

    // trans form method

    char[][] transform(char[][] mat, int l, int b) {

        char[][] newmat = new char[l][b];
        for (int i = 0; i < l; i++)
            for (int j = 0; j < b; j++)
                newmat[i][j] = flip(mat, i, j);
        return newmat;
    }

    // flip method

    char flip(char[][] mat, int i, int j) {
        int count = around(mat, i, j);
        if (mat[i][j] == '*') {
            if (count < 2 || count > 3)
                return '_';
            return '*';
        } else {
            if (count == 3)
                return '*';
            return '_';
        }
    }

    // around method
    int around(char[][] mat, int i, int j) {
        int count = 0;
        for (int x = i - 1; x <= i + 1; x++)
            for (int y = j - 1; y <= j + 1; y++) {
                if (x == i && y == j)
                    continue;
                count += eval(mat, x, y);
            }
        return count;
    }

    // eval method

    int eval(char[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i == l || j == b)
            return 0;
        if (mat[i][j] == '*')
            return 1;
        return 0;
    }

    // customize setup
    float setCustomConfig(char[][] arr, String infile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(infile));
            String line;
            for (int i = 0; i < arr.length; i++) {
                line = br.readLine();
                for (int j = 0; j < arr[0].length; j++)
                    arr[i][j] = line.charAt(j);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    // set config

    float setConfig(char[][] arr) {
        // Enter percentage of grid to be filled.
        float per = 0.10f;// (float)Math.random();
        for (int i = 0; i < arr.length; i++)
            setConfig1D(arr[i], per);
        return per;
    }

    // setconfig 2D
    void setConfig1D(char[] arr, float per) {
        for (int i = 0; i < arr.length; i++) {
            if (Math.random() < per)
                arr[i] = '*';
            else
                arr[i] = '_';
        }
    }

    // Display logic

    void display2D(char[][] arr) {
        for (int i = 0; i < arr.length; i++)
            display1D(arr[i]);
        System.out.println();
    }

    // display 1D
    void display1D(char[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]);
        System.out.println();
    }
}