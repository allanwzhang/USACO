package USACO_SilverClassWork;
/*
//ID: allanwz1
LANG: JAVA
TASK: pairup
*/

import java.io.*;
import java.util.*;

public class pairup {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("pairup.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
	
		 int lines = Integer.parseInt(f.readLine());
		 
		 int[][] cows = new int[lines][2];
		 
		 for(int i = 0; i < lines; i++) {
			 String[] arr = f.readLine().split(" ");
			 cows[i][1] = Integer.parseInt(arr[0]);
			 cows[i][0] = Integer.parseInt(arr[1]);
		 }
		 
		 Arrays.sort(cows, new Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			        return Integer.compare(a[0], b[0]);
			    }
			}); 
		 
		 int max = 0;
		 
		 int i = 0;
		 int j = cows.length - 1;
		 
		 while(i <= j) {
			 if(cows[i][1] <= 0) {
				 i++;
			 }
			 if(cows[j][1] <= 0) {
				 j--;
			 }
			 max = Math.max(cows[i][0] + cows[j][0], max);
			 int min = Math.min(cows[i][1], cows[j][1]);
			 cows[i][1] -= min;
			 cows[j][1] -= min;
		 }
		 
		 System.out.println(max);
		 out.println(max);
		 
		 out.close();
		 f.close();
	}
}
