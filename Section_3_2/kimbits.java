package Section_3_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: kimbits
*/

import java.io.*;
import java.util.*;

public class kimbits {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("kimbits.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
	
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 
		 int size = Integer.parseInt(st.nextToken());
		 int max = Integer.parseInt(st.nextToken());
		 double goal = Double.parseDouble(st.nextToken());
		 
		 int[][] total = new int[size + 1][size + 1];
		 
		 for(int i = 1; i < total.length; i++) {
			 total[i][1] = i + 1;
			 total[1][i] = 2;
		 }
		 
		 for(int j = 2; j < total.length; j++) {
			 for(int i = 2; i < total.length; i++) {
				 total[i][j] = total[i - 1][j] + total[i - 1][j - 1];
			 }
		 }
		 
//		 for(int[] i : total) { 
//			 System.out.println(Arrays.toString(i));
//		 }
		 
		 int n = size;
		 int l = max;
		 int count = 0;
		 
		 StringBuilder sb = new StringBuilder("");
		 
		 while(count < size) {
//			 System.out.println(goal + " " + total[n - 1][l] + " " + sb.toString());
			 if(goal == 1) {
//				 System.out.println("WTF");
				 sb.append(0);
				 count++;
				 continue;
			 }
			 if(total[n - 1][l] < goal) {
				 sb.append("1");
				 goal = goal - total[n - 1][l];
				 n = n - 1;
				 l = l - 1;
			 } else {
				 sb.append("0");
				 n = n - 1;
			 }
			 count++;
		 }
		 
		 System.out.println(sb.toString());
		 out.println(sb.toString());
		 
		 out.close();
		 f.close();
	}

}
