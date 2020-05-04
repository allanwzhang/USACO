package Section_3_1;
/*
//ID: allanwz1
LANG: JAVA
TASK: inflate
*/

import java.io.*;
import java.util.*;

public class inflate {
	
	static int left = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
		 
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 
		 int goal = Integer.parseInt(st.nextToken());
		 int numCat = Integer.parseInt(st.nextToken());
	
		 int[] allPoss = new int[goal + 1];
		 
		 for(int i = 0; i < numCat; i++) {
			 st = new StringTokenizer(f.readLine());
			 int points = Integer.parseInt(st.nextToken());
			 int min = Integer.parseInt(st.nextToken());
			 
			 for(int j = min; j < allPoss.length; j++) {
				 if(allPoss[j] < allPoss[j - min] + points) {
					 allPoss[j] = allPoss[j - min] + points;
				 }
			 }
		 }
		 
		 System.out.println(allPoss[goal]);
		 out.println(allPoss[goal]);
		 
		 out.close();
		 f.close();
	}
}
