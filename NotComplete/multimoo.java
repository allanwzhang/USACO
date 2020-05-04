package NotComplete;
/*
//ID: allanwz1
LANG: JAVA
TASK: multimoo
*/

import java.io.*;

public class multimoo {
	
	static int count1 = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("multimoo.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
		 
		 int size = Integer.parseInt(f.readLine());
		 
		 char[][] grid = new char[size][size];
		 
		 for(int i = 0; i < size; i++) {
			 grid[i] = f.readLine().toCharArray();
		 }
		 
		 boolean[][] visited = new boolean[size][size];
		 
		 int max1 = 0;
		 
		 for(int i = 0; i < grid.length; i++) {
			 for(int j = 0; j < grid[0].length; j++) {
				 if(visited[i][j]) continue;
				 floodfill1(i, j, visited, grid, grid[i][j]);
				 max1 = Math.max(count1, max1);
				 count1 = 0;
			 }
		 }
	}
	
	static void floodfill1(int i, int j, boolean[][] visited, char[][] grid, char curr) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid.length || visited[i][j]) return;
		if(grid[i][j] != curr) return;
		count1++;
		visited[i][j] = true;
		floodfill1(i + 1, j, visited, grid, curr);
		floodfill1(i, j + 1, visited, grid, curr);
		floodfill1(i - 1, j, visited, grid, curr);
		floodfill1(i, j - 1, visited, grid, curr);
	}
}
