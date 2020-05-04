package FebComp2019;
/*
//ID: allanwz1
LANG: JAVA
TASK: paintbarn
*/

import java.io.*;

public class paintbarn {
	
	static int[][] board = new int[1002][1002];
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
	
		 String[] arr = f.readLine().split(" ");
		 
		 int numRect = Integer.parseInt(arr[0]);
		 int goalCoats = Integer.parseInt(arr[1]);
		 
		 for(int i = 0; i < numRect; i++) {
			 String[] curr = f.readLine().split(" ");
			 int x1 = Integer.parseInt(curr[0]);
			 int y1 = Integer.parseInt(curr[1]);
			 int x2 = Integer.parseInt(curr[2]);
			 int y2 = Integer.parseInt(curr[3]);
			 board[x2 - 1][y2 - 1] += 1;
			 if(x1 != 0) board[x1 - 1][y2 - 1] -= 1;
			 if(y1 != 0) board[x2 - 1][y1 - 1] -= 1;
			 if(x1 != 0 && y1 != 0) board[x1 - 1][y1 - 1] += 1;
		 }
		 
		 int count = 0;
		 
		 for(int i = board.length - 2; i >= 0; i--) {
			 for(int j = board.length - 2; j >= 0; j--) {
				 board[i][j] += (board[i + 1][j] + board[i][j + 1] - board[i + 1][j + 1]);
				 if(board[i][j] == goalCoats) count++;
			 }
		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}
}
