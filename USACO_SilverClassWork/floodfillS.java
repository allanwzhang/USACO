package USACO_SilverClassWork;
import java.util.Arrays;
import java.util.Scanner;

public class floodfillS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array = sc.nextLine().split(" ");
		int m = Integer.parseInt(array[0]);
		int n = Integer.parseInt(array[1]);
		char[][] arr = new char[m][n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine().toCharArray();
		}
		
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 'S') {
					x = i;
					y = j;
				}
			}
		}
		
		floodfill(arr, x, y);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		sc.close();
	}
	
	static void floodfill(char[][] arr, int x, int y) {
		if(x >= arr.length || x < 0 || y >= arr[0].length || y < 0 || arr[x][y] == '*' || arr[x][y] == '!') return;
		
		arr[x][y] = '!';
		floodfill(arr, x + 1, y);
		floodfill(arr, x, y + 1);
		floodfill(arr, x - 1, y);
		floodfill(arr, x, y - 1);
	}
}
