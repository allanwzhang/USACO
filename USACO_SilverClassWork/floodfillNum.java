package USACO_SilverClassWork;
import java.util.Arrays;
import java.util.Scanner;

public class floodfillNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array = sc.nextLine().split(" ");
		int m = Integer.parseInt(array[0]);
		int n = Integer.parseInt(array[1]);
		char[][] arr = new char[m][n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine().toCharArray();
		}
		
		int count = 1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] == '.') {
					floodfill(arr, i, j, count);
					count++;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		sc.close();
	}

	static void floodfill(char[][] arr, int x, int y, int i) {
		if(x >= arr.length || x < 0 || y >= arr[0].length || y < 0 || arr[x][y] != '.') return;
		
		arr[x][y] = (char)(i + '0');;
		floodfill(arr, x + 1, y, i);
		floodfill(arr, x, y + 1, i);
		floodfill(arr, x - 1, y, i);
		floodfill(arr, x, y - 1, i);
	}
	
}
