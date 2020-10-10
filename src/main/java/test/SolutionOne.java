package test;

import java.io.IOException;

/**
 * Hour glass problem
 * @author vivsharm7
 *
 */
public class SolutionOne {

	static int hourglassSum(int[][] arr) {

		int columns = arr[0].length;
		int rows = arr.length;

		int max = Integer.MIN_VALUE;
		int totalHourGlassCount = 0;
		for (int i = 0; i < rows - 2; i++) {
			System.out.println("First hour glass for row : " + (i + 1));
			for (int j = 0; j < columns - 2; j++) {
				int[][] hourGlass = getHourGlass(arr, i, j);
				printHourGlass(hourGlass);
				int sumOfhourglass = calculateSum(hourGlass);
				System.out.println("Sum of current hour glass is : "+sumOfhourglass);
				max = Math.max(max, sumOfhourglass);
				System.out.println("Max sum for hour glasses so far is: " + max);
				totalHourGlassCount++;
			}
		}
		System.out.println();
		System.out.println("######### Finished calculating hour glasses and their sum.");
		System.out.println("Total number of hour glasses are : " + totalHourGlassCount);
		System.out.println("Maximum sum is: " + max);
		return max;

	}

	private static String printHourGlass(int[][] hourGlass) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i==1 && (j==0 || j==2)) {
					System.out.print("   ");
				}else
				System.out.print(hourGlass[i][j] + ",");
			}
			System.out.println();
		}
		return null;
	}

	private static int calculateSum(int[][] hourGlass) {
		int total = 0;
		int rows = hourGlass.length;
		int columns = hourGlass[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(i==1 && (j == 0 || j==2)) {
					continue;
				}
				total += hourGlass[i][j];
			}
		}
		return total;
	}

	public static int[][] getHourGlass(int[][] arr, int rowStartIndex, int columnStartIndex) {

		int[][] hourglass = new int[3][3];
		int x = rowStartIndex;
		int y = columnStartIndex;
		int maxX = x + 3;
		int maxY = y + 3;
		int m = 0;
		if (rowStartIndex != 4 && columnStartIndex != 4) {
			for (int i = x; i < maxX; i++) {
				int n = 0;
				for (int j = y; j < maxY; j++) {
					hourglass[m][n] = arr[i][j];
					n++;
				}
				m++;
			}
		}
		hourglass[1][0] = hourglass[1][2]=0;
		return hourglass;
	}

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] arr = new int[6][6];
		arr[0] = new int[] { 0, -4, -6, 0, -7, -6 };
		arr[1] = new int[] { -1, -2, -6, -8, -3, -1 };
		arr[2] = new int[] { -8, -4, -2, -8, -8, -6 };
		arr[3] = new int[] { -3, -1, -2, -5, -7, -4 };
		arr[4] = new int[] { -3, -5, -3, -6, -6, -6 };
		arr[5] = new int[] { -3, -6, 0, -8, -6, -7 };
		hourglassSum(arr);

		/*
		 * for (int i = 0; i < 6; i++) { String[] arrRowItems =
		 * scanner.nextLine().split(" ");
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * for (int j = 0; j < 6; j++) { int arrItem = Integer.parseInt(arrRowItems[j]);
		 * arr[i][j] = arrItem; } }
		 * 
		 * int result = hourglassSum(arr);
		 * 
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
	}
}
