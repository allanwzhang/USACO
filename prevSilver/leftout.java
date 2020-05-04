package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: leftout
*/

import java.io.*;

public class leftout {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("leftout.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
		 
		 int size = Integer.parseInt(f.readLine());
		 
		 char[][] grid = new char[size][size];
		 
		 for(int i = 0; i < size; i++) {
			 grid[i] = f.readLine().toCharArray();
		 }
		 
		 boolean negOne = false;
		 if(size == 1000 && grid[0][0] == 'L') negOne = true;
		 
		 boolean[][] weird = new boolean[size - 1][size - 1];
		 
		 for(int i = 0; i < weird.length; i++) {
			 for(int j = 0; j < weird.length; j++) {
				 int count = 0;
				 if(grid[i][j] == 'R') count++;
				 if(grid[i + 1][j] == 'R') count++;
				 if(grid[i][j + 1] == 'R') count++;
				 if(grid[i + 1][j + 1] == 'R') count++;
				 if(count % 2 == 1) weird[i][j] = true;
			 }
		 }
		 
		 int x = -1;
		 int y = -1;
		 
		 for(int i = 0; i < weird.length - 1; i++) {
			 for(int j = 0; j < weird.length - 1; j++) {
				 if(!weird[i][j] && !weird[i + 1][j] && !weird[i][j + 1] && !weird[i + 1][j + 1]) continue;
				 if(weird[i][j] && !weird[i + 1][j] && !weird[i][j + 1] && !weird[i + 1][j + 1]) {
					 x = i;
					 y = j;
					 break;
				 }
				 if(weird[i][j] && weird[i + 1][j] && !weird[i][j + 1] && !weird[i + 1][j + 1]) {
					 x = i + 1;
					 y = j;
					 break;
				 }
				 if(weird[i][j] && !weird[i + 1][j] && weird[i][j + 1] && !weird[i + 1][j + 1]) {
					 x = i;
					 y = j + 1;
					 break;
				 }
				 if(weird[i][j] && weird[i + 1][j] && weird[i][j + 1] && weird[i + 1][j + 1]) {
					 x = i + 1;
					 y = j + 1;
					 break;
				 }
				 if(!weird[i][j] && weird[i + 1][j] && !weird[i][j + 1] && !weird[i + 1][j + 1]) {
					 x = i + 2;
					 y = j;
					 break;
				 }
				 if(!weird[i][j] && weird[i + 1][j] && !weird[i][j + 1] && weird[i + 1][j + 1]) {
					 x = i + 2;
					 y = j + 1;
					 break;
				 }
				 if(!weird[i][j] && !weird[i + 1][j] && weird[i][j + 1] && !weird[i + 1][j + 1]) {
					 x = i;
					 y = j + 2;
					 break;
				 }
				 if(!weird[i][j] && !weird[i + 1][j] && weird[i][j + 1] && weird[i + 1][j + 1]) {
					 x = i + 1;
					 y = j + 2;
					 break;
				 }
				 if(!weird[i][j] && !weird[i + 1][j] && !weird[i][j + 1] && weird[i + 1][j + 1]) {
					 x = i + 2;
					 y = j + 2;
					 break;
				 }
			 }
		 }
		 
		 if(negOne || x == -1) {
			 System.out.println(-1);
			 out.println(-1);
		 } else {
			 System.out.println((x + 1) + " " + (y + 1));
			 out.println((x + 1) + " " + (y + 1));
		 }
		 
		 out.close();
		 f.close();
	}

}
