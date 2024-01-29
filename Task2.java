package demo;
import java.util.Scanner;

public class Task2 {


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input number of rows and columns
	        System.out.println("Enter the number of rows and columns:");
	        int rows = scanner.nextInt();
	        int columns = scanner.nextInt();

	        // Input matrix elements
	        System.out.println("Enter the matrix elements:");
	        int[][] matrix = new int[rows][columns];
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                matrix[i][j] = scanner.nextInt();
	            }
	        }

	        // Find optimal table coordinates
	        int[] result = findOptimalTable(matrix, rows, columns);

	        // Output result
	        System.out.println("Result: x:" + result[0] + " y:" + result[1] + " " + result[2]);
	    }

	    private static int[] findOptimalTable(int[][] matrix, int rows, int columns) {
	        int maxDishes = 0;
	        int[] result = new int[3]; // x, y, and total dishes

	        // Iterate through each table to find the optimal one
	        for (int i = 1; i < rows - 1; i++) {
	            for (int j = 1; j < columns - 1; j++) {
	                int currentDishes = matrix[i][j] +
	                                    matrix[i - 1][j] +
	                                    matrix[i + 1][j] +
	                                    matrix[i][j - 1] +
	                                    matrix[i][j + 1] +
	                                    matrix[i - 1][j - 1] +
	                                    matrix[i - 1][j + 1] +
	                                    matrix[i + 1][j - 1] +
	                                    matrix[i + 1][j + 1];

	                if (currentDishes > maxDishes) {
	                    maxDishes = currentDishes;
	                    result[0] = i + 1; // x-coordinate
	                    result[1] = j + 1; // y-coordinate
	                    result[2] = maxDishes; // total dishes
	                }
	            }
	        }

	        return result;
	    }
	}
