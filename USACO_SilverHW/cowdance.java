package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: cowdance
*/

import java.io.*;
import java.util.*;

public class cowdance {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 int numCows = Integer.parseInt(st.nextToken());
		 int timeRest = Integer.parseInt(st.nextToken());
//		 System.out.println(timeRest);
		 ArrayList<Integer> cows = new ArrayList<>();
		 for(int i = 0; i < numCows; i++) {
			 cows.add(Integer.parseInt(f.readLine()));
		 }
//		 for(int i = 0; i < cows.size(); i++) {
//			 System.out.println(cows.get(i));
//		 }
		 int min = 0;
		 int max = numCows;
		 
		 while(min != max) {
			 int mid = (min + max) / 2;
			 ArrayList<Integer> copy = new ArrayList<Integer>(cows);
			 if(inTime(mid, copy, timeRest)) {
				 max = mid;
			 } else {
				 min = mid + 1;
			 }
		 }
		 
		 System.out.println(min);
		 out.println(min);
		 
		 out.close();
		 f.close();
	}

	static boolean inTime(int stage, ArrayList<Integer> cows, int timeRest) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < cows.size(); i++) {
			int curr = cows.get(i);
			if(pq.size() == stage) curr += pq.poll();
			if(curr > timeRest) return false;
			pq.add(curr);
		}
		return true;
	}
}
