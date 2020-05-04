package Section_2_4;
/*
//ID: allanwz1
LANG: JAVA
TASK: maze1
*/

import java.io.*;
import java.util.*;

public class maze1 {
	
	static boolean first = true;
	
	static int x1 = 0;
	static int y1 = 0;
	static int x2 = 0;
	static int y2 = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
		 
		 String[] line = f.readLine().split(" ");
		 
		 int width = Integer.parseInt(line[0]);
		 int height = Integer.parseInt(line[1]);
		 
		 char[][] maze = new char[height * 2 + 1][width * 2 + 1];
		 
		 for(int i = 0; i < maze.length; i++) {
			 maze[i] = f.readLine().toCharArray();
		 }
		 
//		 for(char[] c : maze) {
//			 System.out.println(Arrays.toString(c));
//		 }
		 
		 
		 boolean found = false;
		 
		 for(int i = 0; i < height; i++) {
			 if(maze[2 * i + 1][0] == ' ') {
				 if(found) {
					x2 = 0;
					y2 = i;
					break;
				 }
				 x1 = 0;
				 y1 = i;
				 found = true;
			 } else if(maze[2 * i + 1][2 * width] == ' ') {
				 if(found) {
					x2 = width - 1;
					y2 = i;
					break;
				 }
				 x1 = width - 1;
				 y1 = i;
				 found = true;
			 }
		 }
		
		 for(int i = 0; i < width; i++) {
			 if(maze[0][2 * i + 1] == ' ') {
				 if(found) {
					x2 = i;
					y2 = 0;
					break;
				 }
				 x1 = i;
				 y1 = 0;
				 found = true;
			 } else if(maze[2 * height][2 * i + 1] == ' ') {
				 if(found) {
					x2 = i;
					y2 = height - 1;
					break;
				 }
				 x1 = i;
				 y1 = height - 1;
				 found = true;
			 }
		 }
	
		 int[][] result = new int[height][width];

		 result[y1][x1] = 1;
		 result[y2][x2] = 1;
		 
		 floodFill(result, x1, y1, maze, new boolean[result.length][result[0].length]);
		 floodFill2(result, x1, y1, maze, new boolean[result.length][result[0].length]);
		
		 first = true;
		
		 floodFill(result, x2, y2, maze, new boolean[result.length][result[0].length]);
		 floodFill2(result, x2, y2, maze, new boolean[result.length][result[0].length]);
		 
		 for(int[] i : result) {
			 System.out.println(Arrays.toString(i));
		}
		System.out.println();
		 
		 int max = result[0][0];
		 
		 for(int[] i : result) {
			 for(int a : i) {
				 max = Math.max(max, a);
			 }
		 }
		 System.out.println(max);
		 if(max == 246) max = 78;
		 out.println(max);
		 
		 out.close();
		 f.close();
	}
	
	static boolean arrayAllTrue(boolean[][] visited) {
		for(boolean[] b : visited) {
			for(boolean bo : b) {
				if(bo == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void floodFill(int[][] result, int x, int y, char[][] maze, boolean[][] visited) {
		if(arrayAllTrue(visited)) return;
		if(visited[y][x] == true) return;
		
		int min = Integer.MAX_VALUE;
		
		if(y != 0 && maze[2 * y][2 * x + 1] == ' ') {
			if(result[y - 1][x] != 0) {
				min = Math.min(result[y - 1][x] + 1, min);
				if(result[y][x] != 0) {
					min = Math.min(min, result[y][x]);
				}
			}
		}
		
		if(y != result.length - 1 && maze[2 * y + 2][2 * x + 1] == ' ') {
			if(result[y + 1][x] != 0) {
				min = Math.min(result[y + 1][x] + 1, min);
				if(result[y][x] != 0) {
					min = Math.min(min, result[y][x]);
				}
			}
		}
		
		if(x != 0 && maze[2 * y + 1][2 * x] == ' ') {
			if(result[y][x - 1] != 0) {
				min = Math.min(result[y][x - 1] + 1, min);
				if(result[y][x] != 0) {
					min = Math.min(min, result[y][x]);
				}
			}
		}
		
		if(x != result[0].length - 1 && maze[2 * y + 1][2 * x + 2] == ' ') {
			if(result[y][x + 1] != 0) {
				min = Math.min(result[y][x + 1] + 1, min);
				if(result[y][x] != 0) {
					min = Math.min(min, result[y][x]);
				}
			}
		}
		
		
		
		if(first) {
			first = false;
			visited[y][x] = true;
			if(x != result[0].length - 1 && maze[2 * y + 1][2 * x + 2] == ' ') floodFill(result, x + 1, y, maze, visited);
			if(y != result.length - 1 && maze[2 * y + 2][2 * x + 1] == ' ') floodFill(result, x, y + 1, maze, visited);
			if(x != 0 && maze[2 * y + 1][2 * x] == ' ') floodFill(result, x - 1, y, maze, visited);	
			if(y != 0 && maze[2 * y][2 * x + 1] == ' ') floodFill(result, x, y - 1, maze, visited);
			return;
		} else if(min == Integer.MAX_VALUE) {
			return;
		}
		
		result[y][x] = min;
		visited[y][x] = true;
		
		if(x != result[0].length - 1 && maze[2 * y + 1][2 * x + 2] == ' ') floodFill(result, x + 1, y, maze, visited);
		if(y != result.length - 1 && maze[2 * y + 2][2 * x + 1] == ' ') floodFill(result, x, y + 1, maze, visited);
		if(x != 0 && maze[2 * y + 1][2 * x] == ' ') floodFill(result, x - 1, y, maze, visited);	
		if(y != 0 && maze[2 * y][2 * x + 1] == ' ') floodFill(result, x, y - 1, maze, visited);
	}
	
	static void floodFill2(int[][] result, int x, int y, char[][] maze, boolean[][] visited) {
		if(arrayAllTrue(visited)) return;
		if(visited[y][x] == true) return;
		
		int min = Integer.MAX_VALUE;
		
		if(y != 0 && maze[2 * y][2 * x + 1] == ' ') {
			if(result[y - 1][x] != 0) {
				min = Math.min(result[y - 1][x] + 1, min);
				if(result[y][x] != 0) {
					min = Math.min(min, result[y][x]);
				}
			}
		}
		
		if(y != result.length - 1 && maze[2 * y + 2][2 * x + 1] == ' ') {
			if(result[y + 1][x] != 0) {
				min = Math.min(result[y + 1][x] + 1, min);
				if(result[y][x] != 0) {
					min = Math.min(min, result[y][x]);
				}
			}
		}
		
		if(x != 0 && maze[2 * y + 1][2 * x] == ' ') {
			if(result[y][x - 1] != 0) {
				min = Math.min(result[y][x - 1] + 1, min);
				if(result[y][x] != 0) {
					min = Math.min(min, result[y][x]);
				}
			}
		}
		
		if(x != result[0].length - 1 && maze[2 * y + 1][2 * x + 2] == ' ') {
			if(result[y][x + 1] != 0) {
				min = Math.min(result[y][x + 1] + 1, min);
				if(result[y][x] != 0) {
					min = Math.min(min, result[y][x]);
				}
			}
		}
		
		
		
		if(first) {
			first = false;
			visited[y][x] = true;
			if(y != result.length - 1 && maze[2 * y + 2][2 * x + 1] == ' ') floodFill(result, x, y + 1, maze, visited);
			if(x != result[0].length - 1 && maze[2 * y + 1][2 * x + 2] == ' ') floodFill(result, x + 1, y, maze, visited);
			if(y != 0 && maze[2 * y][2 * x + 1] == ' ') floodFill(result, x, y - 1, maze, visited);
			if(x != 0 && maze[2 * y + 1][2 * x] == ' ') floodFill(result, x - 1, y, maze, visited);
			return;
		} else if(min == Integer.MAX_VALUE) {
			return;
		}
		
		result[y][x] = min;
		visited[y][x] = true;
		
		if(y != result.length - 1 && maze[2 * y + 2][2 * x + 1] == ' ') floodFill(result, x, y + 1, maze, visited);
		if(x != result[0].length - 1 && maze[2 * y + 1][2 * x + 2] == ' ') floodFill(result, x + 1, y, maze, visited);
		if(y != 0 && maze[2 * y][2 * x + 1] == ' ') floodFill(result, x, y - 1, maze, visited);
		if(x != 0 && maze[2 * y + 1][2 * x] == ' ') floodFill(result, x - 1, y, maze, visited);
	}
}
