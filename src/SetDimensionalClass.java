import java.io.BufferedReader;
import java.io.FileReader;

public class SetDimensionalClass {
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
//		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++)
			setConfig1D(arr[i], per);
		return per;
	}

	// setconfig 2D
	void setConfig1D(char[] arr1D, float per) {
//		System.out.println(arr1D.length);
		for (int i = 0; i < arr1D.length; i++) {
			if (Math.random() < per)

				arr1D[i] = '*';
			else
				arr1D[i] = '_';
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
