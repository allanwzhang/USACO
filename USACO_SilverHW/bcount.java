package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: bcount
*/

import java.io.*;
//import java.util.Arrays;

public class bcount {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 
		 int numCows = Integer.parseInt(arr[0]);
		 int query = Integer.parseInt(arr[1]);
		 
		 int[] cows = new int[numCows];
		 
		 for(int i = 0; i < numCows; i++) {
			 cows[i] = Integer.parseInt(f.readLine());
		 }
		 
		 int[][] cowType = new int[numCows + 1][3];
		 
		 for(int i = 1; i < cowType.length; i++) {
			 cowType[i][0] = cowType[i - 1][0];
			 cowType[i][1] = cowType[i - 1][1];
			 cowType[i][2] = cowType[i - 1][2];
			 if(cows[i - 1] == 1) {
				 cowType[i][0]++;
			 } else if(cows[i - 1] == 2) {
				 cowType[i][1]++;
			 } else {
				 cowType[i][2]++;
			 }
		 }
		 
//		 for(int[] a : cowType) {
//			 System.out.println(Arrays.toString(a));
//		 }
		 
		 for(int i = 0; i < query; i++) {
			 String[] ar = f.readLine().split(" ");
			 int a = Integer.parseInt(ar[0]);
			 int b = Integer.parseInt(ar[1]);
			 
			 out.println((cowType[b][0] - cowType[a - 1][0]) + " " + (cowType[b][1] - cowType[a - 1][1]) + " " + (cowType[b][2] - cowType[a - 1][2]));
//			 System.out.println((cowType[b][0] - cowType[a - 1][0]) + " " + (cowType[b][1] - cowType[a - 1][1]) + " " + (cowType[b][2] - cowType[a - 1][2]));
		 }
		 
		 out.close();
		 f.close();
	}

}
