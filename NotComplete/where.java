package NotComplete;
/*
//ID: allanwz1
LANG: JAVA
TASK: where
*/

import java.io.*;

public class where {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("where.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
		 
		 int size = Integer.parseInt(f.readLine());
		 
		 char[][] grid = new char[size][size];
		 
		 for(int i = 0; i < size; i++) {
			 grid[i] = f.readLine().toCharArray();
		 }
		 
		 boolean[][] isPCL = new boolean[size][size];
		 
		 int count = 0;
		 
		 for(int i = 0; i < grid.length; i++) {
			 for(int j = 0; j < grid.length; j++) {
				 for(int m = grid.length - 1; m > i; m--) {
					 for(int n = grid.length - 1; n > j; n--) {
						 if(isPCL[i][j] && isPCL[m][n]) continue;
						 if(isPCL(i, j, m, n, grid)) {
							 count++;
							 System.out.println(i + " " + j + " " + m + " " + n);
							 for(int a = i; a <= m; a++) {
								 for(int b = j; b <= n; b++) {
									 isPCL[a][b] = true;
									 System.out.print(grid[a][b]);
								 }
								 System.out.println();
							 }
						 }
					 }
				 }
			 }
		 }
		 
		 
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}

	static boolean isPCL(int i, int j, int m, int n, char[][] grid) {
		boolean[][] visited = new boolean[m - i + 1][n - j + 1];
		char firstChar = '.';
		char secondChar = '.';
		int numFirstChar = 0;
		int numSecondChar = 0;
		for(int a = i; a <= m; a++) {
			for(int b = j; b <= n; b++) {
				if(visited[a - i][b - j]) continue;
				if(firstChar == '.') {
					firstChar = grid[a][b];
					numFirstChar = 1;
				} else if(grid[a][b] == firstChar) {
					numFirstChar++;
				} else if(secondChar == '.') {
					secondChar = grid[a][b];
					numSecondChar = 1;
				} else if(grid[a][b] == secondChar) {
					numSecondChar++;
				} else {
					return false;
				}
				floodfill(i, j, m, n, a, b, grid, visited, grid[a][b]);
			}
		}
		
		if(numFirstChar == 1 && numSecondChar > 1 || numFirstChar > 1 && numSecondChar == 1) return true;
		return false;
	}
	
	static void floodfill(int i, int j, int m, int n, int a, int b, char[][] grid, boolean[][] visited, char currChar) {
		if(a < i || a > m || b < j || b > n || visited[a - i][b - j] || grid[a][b] != currChar) return;
		visited[a - i][b - j] = true;
		floodfill(i, j, m, n, a + 1, b, grid, visited, currChar);
		floodfill(i, j, m, n, a, b + 1, grid, visited, currChar);
		floodfill(i, j, m, n, a - 1, b, grid, visited, currChar);
		floodfill(i, j, m, n, a, b - 1, grid, visited, currChar);
	}
}
