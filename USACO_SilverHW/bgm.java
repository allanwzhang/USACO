package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: bgm
*/

import java.io.*;

public class bgm {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("bgm.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bgm.out")));
	
		 long[][] BESIGOM = new long[7][7];
		 
		 int lines = Integer.parseInt(f.readLine());
		 for(int i = 0; i < lines; i++) {
			 String[] arr = f.readLine().split(" ");
			 String x = arr[0];
			 int y = 0;
			 if(Integer.parseInt(arr[1]) > 0 || Integer.parseInt(arr[1]) % 7 == 0) {
				 y = Integer.parseInt(arr[1]) % 7;
			 } else {
				 y = 7 - (Math.abs(Integer.parseInt(arr[1]) % 7));
			 }
			 if(x.equals("B")) {
				 BESIGOM[0][y]++;
			 } else if(x.equals("E")) {
				 BESIGOM[1][y]++;
			 } else if(x.equals("S")) {
				 BESIGOM[2][y]++;
			 } else if(x.equals("I")) {
				 BESIGOM[3][y]++;
			 } else if(x.equals("G")) {
				 BESIGOM[4][y]++;
			 } else if(x.equals("O")) {
				 BESIGOM[5][y]++;
			 } else if(x.equals("M")) {
				 BESIGOM[6][y]++;
			 }
		 }
		 
		 
		 long count = 0;
		 
		 for(int i = 0; i < 7; i++) {
			 for(int j = 0; j < 7; j++) {
				 for(int k = 0; k < 7; k++) {
					 for(int l = 0; l < 7; l++) {
						 for(int m = 0; m < 7; m++) {
							 for(int n = 0; n < 7; n++) {
								 for(int o = 0; o < 7; o++) {
									 if(((i + 2 * j + 2 * k + l) * (j + k + m + n) * (2 * n + o)) % 7 == 0) {
										 count += BESIGOM[0][i] * BESIGOM[1][j] * BESIGOM[2][k] * BESIGOM[3][l] * BESIGOM[4][m]
												 * BESIGOM[5][n] * BESIGOM[6][o];
									 }
								 }
							 }
						 }
					 }
				 }
			 }
		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}

}
