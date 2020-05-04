package NotComplete;
/*
//ID: allanwz1
LANG: JAVA
TASK: gates
*/

import java.io.*;

public class gates {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("gates.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
		 
		 int numGates = Integer.parseInt(f.readLine());
		 char[] direction = f.readLine().toCharArray();
		 
		 int[][] barn = new int[2002][2002];
		 
		 boolean[][] vert = new boolean[2002][2001];
		 boolean[][] hori = new boolean[2001][2002];
		 
		 int x = 1000;
		 int y = 1000;
		 
//		 for(int i = 0 ; i < numGates; i++) {
//			 char curr = direction[i];
//			 if(curr == 'N') {
//				 vert[--x][y-1] = true;
//				 
//			 } else if(curr == 'E') {
//				 
//			 } else if(curr == 'S') {
//			 } else if(curr == 'W') {
//			 }
//			 }
//		 }
	}

}
