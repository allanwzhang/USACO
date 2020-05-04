package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: herding
*/

import java.io.*;
import java.util.Arrays;

public class herding {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("herding.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		 
		 int numCows = Integer.parseInt(f.readLine());
		 
		 int[] cows = new int[numCows];
		 
		 int min1 = Integer.MAX_VALUE;
		 int min2 = Integer.MAX_VALUE;
		 int max1 = -1;
		 int max2 = -1;
		 for(int i = 0; i < numCows; i++) {
			 int curr = Integer.parseInt(f.readLine());
			 cows[i] = curr;
			 if(curr < min1) {
				 min2 = min1;
				 min1 = curr;
			 } else if(curr < min2) {
				 min2 = curr;
			 }
			 if(curr > max1) {
				 max2 = max1;
				 max1 = curr;
			 } else if(curr > max2) {
				 max2 = curr;
			 }
		 }
		 
		 Arrays.sort(cows);
		 
		 int max = -1;
		 for(int i = 0; i < cows.length; i++) {
			 int curr = cows[i];
			 int count = 1;
			 int consec = 1;
			 for(int j = i + 1; j < cows.length; j++) {
				 if(cows[j] < numCows + curr) {
					 count++;
					 if(cows[j] == cows[j - 1] + 1) consec++;
				 }
				 else break;
			 }
//			 System.out.println(i + " " + consec);
			 if(consec == numCows - 1) count--;
			 max = Math.max(max, count);
		 }
		 
		 int minMoves = numCows - max;
		 
		 int maxMoves = Math.max(max1 - min2, max2 - min1);
		 maxMoves = maxMoves - numCows + 2;
		 
		 System.out.println(minMoves);
		 System.out.println(maxMoves);
		 out.println(minMoves);
		 out.println(maxMoves);
		 
		 out.close();
		 f.close();
	}

}
