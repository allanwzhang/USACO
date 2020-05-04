package Section_3_3;
/*
//ID: allanwz1
LANG: JAVA
TASK: game1
*/

import java.io.*;
import java.util.*;

public class game1 {
	
	static int[][] dp = new int[101][101];
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("game1.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("game1.out")));
		 
		 int length = Integer.parseInt(f.readLine());
		 
		 int[] list = new int[length];
		 
		 int count = 0;
		 while(f.ready()) {
			 StringTokenizer st = new StringTokenizer(f.readLine());
			 while(st.hasMoreTokens()) {
				 list[count] = Integer.parseInt(st.nextToken());
				 count++;
			 }
		 }
		 
//		 System.out.println(Arrays.toString(list));
		 
		 for(int[] i : dp) {
			 Arrays.fill(i, -1);
		 }
		 
		 int result = dp(list, 0, list.length - 1);
		 
		 int sum = 0;
		 for(int i : list) {
			 sum += i;
		 }
		 
		 int second = sum - result;
		 
		 System.out.println(result + " " + second);
		 out.println(result + " " + second);
		 
		 out.close();
		 f.close();
	}
	
	static int dp(int[] list, int start, int end) {
		if(start > end) return 0;
		if(start == end) return dp[start][end] = list[start];
		if(dp[start][end] != -1) return dp[start][end];
		int max = Math.max(Math.min(dp(list, start, end - 2), dp(list, start + 1, end - 1)) + list[end], Math.min(dp(list, start + 1, end - 1), dp(list, start + 2, end)) + list[start]);
		return dp[start][end] = max;
	}
	
}