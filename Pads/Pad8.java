package Pads;

/*
//ID: allanwz1
LANG: JAVA
TASK: maze1
*/

import java.io.*;
import java.util.*;

public class Pad8 {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
		 
		 String[] line = f.readLine().split(" ");
		 
		 int width = Integer.parseInt(line[0]);
		 int height = Integer.parseInt(line[1]);
		 
		 char[][] maze = new char[2 * height + 1][2 * width + 1];
	
		 int x1 = 0;
		 int y1 = 0;
		 int x2 = 0;
		 int y2 = 0;
		 
		 for(int i = 0; i < maze.length; i++) {
			 maze[i] = f.readLine().toCharArray();
			 if(i == 0 || i == maze.length - 1) {
				 for(int j = 0; j < maze[i].length; j++) {
					 if(maze[i][j] == ' ') {
						 if(x1 == 0 && y1 == 0) {
							x1 = i;
						 	y1 = j;
						 } else {
							x2 = i;
							y2 = j;
						 }
					 }
				 }
			 } else if(maze[i][0] == ' ') {
				 if(x1 == 0 && y1 == 0) {
						x1 = i;
					 	y1 = 0;
					 } else {
						x2 = i;
						y2 = 0;
					 }
			 } else if(maze[i][maze[0].length - 1] == ' ') {
				 if(x1 == 0 && y1 == 0) {
						x1 = i;
					 	y1 = maze[0].length - 1;
					 } else {
						x2 = i;
						y2 = maze[0].length - 1;
					 }
			 }
		 }
		 boolean[][] visited = new boolean[100][100];
		 int[][] values = new int[2 * height + 1][2 * width + 1];
		 
		 for(int[] i : values) {
			 Arrays.fill(i, 1000000000);
		 }
		 
		 values[x1][y1] = 0;
		 values[x2][y2] = 0;
		 
		 ff(maze, x1, y1, visited, values);
		 
		 System.out.println();
		 boolean[][] visited2 = new boolean[100][100];
		 ff(maze, x2, y2, visited2, values);
		 
		 int max = 0;
		 
		 for(int[] c : values) {
			 System.out.println(Arrays.toString(c));
			 for(int i : c) {
				 if(i != 1000000000) {
					 max = Math.max(max, i);
				 }
			 }
		 }
		 
		 System.out.println((max + 1) / 2);
		 out.println((max + 1) / 2);
		 
		 out.close();
		 f.close();
	}
	
	static int findMin(char[][] maze, int x, int y, int[][] values) {
		int min = 1000000000;
		if(x != 0 && maze[x - 1][y] == ' ') {
			min = Math.min(min, values[x - 1][y]);
		}
		if(x != maze.length - 1 && maze[x + 1][y] == ' ') {
			min = Math.min(min, values[x + 1][y]);
		}
		if(y != 0 && maze[x][y - 1] == ' ') {
			min = Math.min(min, values[x][y - 1]);
		}
		if(y != maze[0].length - 1 && maze[x][y + 1] == ' ') {
			min = Math.min(min, values[x][y + 1]);
		}
		return min;
	}
	
	static void ff(char[][] maze, int x, int y, boolean[][] visited, int[][] values) {
		
		visited[x][y] = true;
		values[x][y] = findMin(maze, x, y, values) + 1;
		
		if(x != 0 && maze[x - 1][y] == ' ' && !visited[x - 1][y]) {
			ff(maze, x - 1, y, visited, values);
		}
		if(y != maze[0].length - 1 && maze[x][y + 1] == ' ' && !visited[x][y + 1]) {
			ff(maze, x, y + 1, visited, values);
		}
		if(y != 0 && maze[x][y - 1] == ' ' && !visited[x][y - 1]) {
			ff(maze, x, y - 1, visited, values);
		}
		if(x != maze.length - 1 && maze[x + 1][y] == ' ' && !visited[x + 1][y]) {
			ff(maze, x + 1, y, visited, values);
		}
		
	}
}
	
	
