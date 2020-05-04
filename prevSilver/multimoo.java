package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: multimoo
*/


import java.io.*;
import java.util.*;

public class multimoo {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("multimoo.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
	
		 int rows = Integer.parseInt(f.readLine());
		 
		 int[][] board = new int[rows][rows];
		 
		 for(int i = 0; i < rows; i++) {
			 board[i] = toIntArray(f.readLine().split(" "));
		 }
		 
		 HashMap<Integer, Integer> region = new HashMap<>();
		 
		 boolean[][] connected = new boolean[1000][1000];
		 
		 floodFill(board, -1, new boolean[board.length][board.length], 0, 0, region, connected);
//		 for(int i : region.keySet()) {
//			 System.out.println(i + ": " + region.get(i));
//		 }
		 
		 int singleMax = 0;
		 int doubleMax = 0;
		 
		 for(int i : region.keySet()) {
			 for(int j : region.keySet()) {
				 if(region.get(i) > singleMax) singleMax = region.get(i);
				 if(i != j && connected[i][j]) {
					 doubleMax = Math.max(doubleMax, region.get(i) + region.get(j));
				 }
			 }
		 }
		 
		 System.out.println(singleMax);
		 System.out.println();
		 
		 out.close();
		 f.close();
	}
	
	static void floodFill(int[][] board, int previous, boolean[][] visited, int i, int j, HashMap<Integer, Integer> region, boolean[][] connected) {
		if(i < 0 || j < 0 || i >= board.length || j >= board.length || visited[i][j]) {
			return;
		}
//		System.out.println(i + " " + j);
		visited[i][j] = true;
		if(previous == -1) {
			region.put(board[i][j], 1);
		} else if(previous != board[i][j]) {
			connected[previous][board[i][j]] = true;
			connected[board[i][j]][previous] = true;
			if(region.containsKey(board[i][j])) {
				region.put(board[i][j], region.get(board[i][j]) + 1);
			} else {
				region.put(board[i][j], 1);
			}
		} else {
			region.put(board[i][j], region.get(board[i][j]) + 1);
		}
		floodFill(board, board[i][j], visited, i + 1, j, region, connected);
		floodFill(board, board[i][j], visited, i, j + 1, region, connected);
		floodFill(board, board[i][j], visited, i, j - 1, region, connected);
		floodFill(board, board[i][j], visited, i - 1, j, region, connected);
	}
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
		
		return result;
	}
}
