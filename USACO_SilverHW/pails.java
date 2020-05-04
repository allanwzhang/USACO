package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: pails
*/

import java.io.*;

public class pails {
	
	static int[][] possible = new int[101][101];
	static int min = Integer.MAX_VALUE;
	static int maxMoves = 0;
	static int x = 0;
	static int y = 0;
	static int goal = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("pails.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 x = Integer.parseInt(arr[0]);
		 y = Integer.parseInt(arr[1]);
		 maxMoves = Integer.parseInt(arr[2]);
		 goal = Integer.parseInt(arr[3]);
		 
		 dp(0, 0, 0);
		 
		 System.out.println(min);
		 out.println(min);
		 
		 out.close();
		 f.close();
	}

	static void dp(int currX, int currY, int moves) {
		if(moves > maxMoves) return;
		if(possible[currX][currY] != 0 && possible[currX][currY] <= moves) {
			return;
		}
		possible[currX][currY] = moves;
		min = Math.min(min, Math.abs(currX + currY - goal));
		dp(currX, 0, moves + 1);
		dp(0, currY, moves + 1);
		dp(x, currY, moves + 1);
		dp(currX, y, moves + 1);
		if(currX - (y - currY) > 0) {
			dp(currX - (y - currY), y, moves + 1);
		} else {
			dp(0, currX + currY, moves + 1);
		}
		if(currY - (x - currX) > 0) {
			dp(x, currY - (x - currX), moves + 1);
		} else {
			dp(currX + currY, 0, moves + 1);
		}
	}
	
}
