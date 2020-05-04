package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: cowroute
*/

import java.io.*;
import java.util.Arrays;

public class cowroute {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("cowroute.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int start = Integer.parseInt(arr[0]);
		 int end = Integer.parseInt(arr[1]);
		 int numFlights = Integer.parseInt(arr[2]);
		 
		 int[] minFirstFlight = new int[10001];
		 Arrays.fill(minFirstFlight, Integer.MAX_VALUE);
		 
		 int[] minSecondFlight = new int[10001];
		 Arrays.fill(minSecondFlight, Integer.MAX_VALUE);
		 
		 int min = Integer.MAX_VALUE;
		 
		 for(int i = 0; i < numFlights; i++) {
			 String[] ar = f.readLine().split(" ");
			 int cost = Integer.parseInt(ar[0]);
			 int numIslands = Integer.parseInt(ar[1]);
			 int[] islands = toIntArray(f.readLine().split(" "));
			 
			 boolean startIsland = false;
			 for(int j = 0; j < numIslands; j++) {
				 if(startIsland) minFirstFlight[islands[j]] = Math.min(cost, minFirstFlight[islands[j]]);
				 if(islands[j] == start) startIsland = true;
				 if(islands[j] == end && startIsland) min = Math.min(min, cost);
			 }
			 
			 boolean endIsland = false;
			 for(int j = numIslands - 1; j >= 0; j--) {
				 if(endIsland) minSecondFlight[islands[j]] = Math.min(cost, minSecondFlight[islands[j]]);
				 if(islands[j] == end) endIsland = true;
			 }
		 }
		 
		 for(int i = 0; i < minFirstFlight.length; i++) {
			 if(minFirstFlight[i] != Integer.MAX_VALUE && minSecondFlight[i] != Integer.MAX_VALUE) min = Math.min(min, minFirstFlight[i] + minSecondFlight[i]);
		 }
		 
		 if(min == Integer.MAX_VALUE) {
			 System.out.println(-1);
			 out.println(-1);
			 out.close();
			 f.close();
			 return;
		 }
		 
		 System.out.println(min);
		 out.println(min);
		 
		 out.close();
		 f.close();
	}
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
	
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
	
		return result;
	}	

}
