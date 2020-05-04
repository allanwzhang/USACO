package USACO_SilverClassWork;
import java.util.Scanner;

public class floodfillPic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array = sc.nextLine().split(" ");
		int m = Integer.parseInt(array[0]);
		int n = Integer.parseInt(array[1]);
		int restrict = Integer.parseInt(array[2]);
		char[][] arr = new char[m][n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine().toCharArray();
		}
		
		for(int i = 0; i < restrict; i++) {
			String[] s = sc.nextLine().split(" ");
			int a = Integer.parseInt(s[0]) - 1;
			int b = Integer.parseInt(s[1]) - 1;
			boolean[][] visited = new boolean[arr.length][arr[0].length];
			System.out.println(floodfill(arr, a, b, visited));
		}
		
		sc.close();
	}
	
	static int floodfill(char[][] arr, int x, int y, boolean[][] visited) {
		if(x >= arr.length || x < 0 || y >= arr[0].length || y < 0 || visited[x][y]) return 0;
		
		if(arr[x][y] == '*') return 1;
		
		visited[x][y] = true;
		
		return floodfill(arr, x + 1, y, visited) + floodfill(arr, x, y + 1, visited) + floodfill(arr, x, y - 1, visited) + floodfill(arr, x - 1, y, visited);
	}
	
}
