import java.util.Scanner;

public class SetGameClass {
	int l = 30, b = 60;
	SetDimensionalClass sdc = new SetDimensionalClass();
	

	void setGame() { // setGame method is written below
		char[][] config = new char[l][b];
		startGame(config, l, b);
	}

	void startGame(char[][] mat, int l, int b) {
		Scanner s = new Scanner(System.in);
		String ch = "";
		float per = 0;
		while (!ch.equals("y")) {
			per = sdc.setConfig(mat);
//			System.out.println(per);
			sdc.display2D(mat);
			System.out.println((per * 100) + "% of grid filled.Do you want to continue y/n  ");
			ch = s.nextLine();
		}
		while (!ch.equals("x")) // Game loop
		{
			mat = transform(mat, l, b);
			sdc.display2D(mat);

			System.out.println("Ctrl+Z to stop.");

			try {
				Thread.sleep(1000); // making delay one second
			} catch (Exception e) {
				System.out.println("Something went horribly wrong.");// exception handling
			}

		}
		s.close();
		System.out.println("Game Over"); // exception raised
	}

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

}
