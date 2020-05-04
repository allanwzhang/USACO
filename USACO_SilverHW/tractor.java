package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: tractor
*/

import java.io.*;

public class tractor {

	static int count = 0;
	static int goal = 0;
	static boolean[][] visited = new boolean[501][501];
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("tractor.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tractor.out")));
		 
		 int size = Integer.parseInt(f.readLine());
		 
		 int[][] field = new int[size][size];
		 
		 for(int i = 0; i < size; i++) {
			 field[i] = toIntArray(f.readLine().split(" "));
		 }
		 
		 goal = (size * size + 1)/ 2;
		 
		 int lo = -1, hi = 1000000;
		 while (hi > lo + 1) {
		    int mid = (lo + hi) / 2;
		    if (is_possible(mid, field)) {
//		    	System.out.println("true: " + mid);
		        hi = mid;
		    } else {
		        lo = mid;
		    }
		 }

		 System.out.println(hi);
		 out.println(hi);
		 
		 out.close();
		 f.close();
	}
	
	static void floodfill(int x, int y, int k, int[][] field) {
		if(x >= field.length || x < 0 || y >= field[0].length || y < 0 || visited[x][y] || count >= goal) return;
		count++;
		visited[x][y] = true;
		if(x < field.length - 1 && Math.abs(field[x + 1][y] - field[x][y]) <= k) {
			floodfill(x + 1, y, k, field);
		}
		if(x > 0 && Math.abs(field[x - 1][y] - field[x][y]) <= k) {
			floodfill(x - 1, y, k, field);
		}
		if(y < field[0].length - 1 && Math.abs(field[x][y + 1] - field[x][y]) <= k) {
			floodfill(x, y + 1, k, field);
		}
		if(y > 0 && Math.abs(field[x][y - 1] - field[x][y]) <= k) {
			floodfill(x, y - 1, k, field);
		}
	}
	
	static boolean is_possible(int k, int[][] field) {
		for(int i = 0; i < visited.length; i++) {
			for(int j = 0; j < visited.length; j++) {
				visited[i][j] = false;
			}
		}
		
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field.length; j++) {
				if(visited[i][j]) continue;
				floodfill(i, j, k, field);
//				System.out.println(count + "  " + goal);
				if(count >= goal) {
					count = 0;
					return true;
				}
				count = 0;
			}
		}
		
		return false;
	}
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
		
		return result;
	}
}
