package cgl;
import java.util.Scanner;

public class testdrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);

	        // Reading size of the Board
	        int n = sc.nextInt();

	        // Reading no. of initial live cells
	        int m = sc.nextInt();
	        int[][] l = new int[m][2];
	        int i = 0;

	        // Reading Live cells
	        while (sc.hasNextInt()) {
	            l[i][0] = sc.nextInt();
	            l[i++][1] = sc.nextInt();
	        }

	        // creating instance to CGLVersion2
	        conwaysgameOflife c = new conwaysgameOflife();

	        // creating nextgenratin by calling nextgenration method
	        c.generateNextGeneration(c.createBoard(n, l));
	        sc.close();
	    }
	}


