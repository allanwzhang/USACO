package USACO_GoldTraining;
/*
//ID: allanwz1
LANG: JAVA
TASK: mooyomooyo
*/

import java.io.*;

public class mooyomooyo {
	
	static boolean removing = true;
	static boolean delete = false;
	static int ffCount = 0;
	static int sizeToDelete = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 
		 int boardSize = Integer.parseInt(arr[0]);
		 sizeToDelete = Integer.parseInt(arr[1]);
		 
		 char[][] board = new char[boardSize][10];
		 
		 for(int i = 0; i < boardSize; i++) {
			 board[i] = f.readLine().toCharArray();
		 }
		 
		 while(removing) {
			 removing = false;
			 int count = 1;
			 int[][] visited = new int[boardSize][10];
			 for(int i = 0; i < visited.length; i++) {
				 for(int j = 0; j < visited[0].length; j++) {
					 if(visited[i][j] != 0 || board[i][j] == '0') continue;
					 ffCount = 0;
					 floodfill(i, j, board[i][j], count, board, visited);
					 if(delete) {
						 removing = true;
						 for(int m = 0; m < visited.length; m++) {
							 for(int n = 0; n < visited[0].length; n++) {
								 if(visited[m][n] == count) {
									 board[m][n] = '0';
								 }
							 }
							 
						 }
						 delete = false;
					 }
					 count++;
				 }
			 }
			 
			for(int j = 0; j < board[0].length; j++) {
				int zeroCount = 0;
				boolean prevIsZero = true;
				for(int i = board.length - 1; i >= 0; i--) {
					if(prevIsZero) {
						if(board[i][j] == '0') {
							zeroCount++;
						} else {
							prevIsZero = false;
							board[i + zeroCount][j] = board[i][j];
							if(zeroCount != 0) board[i][j] = '0';
						}
					} else {
						if(board[i][j] == '0') {
							zeroCount++;
							prevIsZero = true;
						} else {
							board[i + zeroCount][j] = board[i][j];
							if(zeroCount != 0) board[i][j] = '0';
						}
					}
				}
			}
		 }
	
		 for(char[] c : board) {
			 for(char ch : c) {
				 out.print(ch); 
			 }
			 out.println();
		 }
		 
		 out.close();
		 f.close();
	}
	
	static void floodfill(int i, int j, char curr, int filler, char[][] board, int[][] visited) {
		if(i < 0 || j < 0|| i >= board.length || j >= board[0].length || visited[i][j] != 0 || board[i][j] != curr) return;
		visited[i][j] = filler;
		ffCount++;
		if(ffCount >= sizeToDelete) delete = true;
		floodfill(i + 1, j, curr, filler, board, visited);
		floodfill(i - 1, j, curr, filler, board, visited);
		floodfill(i, j + 1, curr, filler, board, visited);
		floodfill(i, j - 1, curr, filler, board, visited);
	}
	
}
