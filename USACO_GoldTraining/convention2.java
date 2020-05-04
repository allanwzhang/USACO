package USACO_GoldTraining;
/*
//ID: allanwz1
LANG: JAVA
TASK: convention2
*/

import java.io.*;
import java.util.*;

public class convention2 {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("convention2.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
	
		 //sweepline by seniority
		 //use pq for the next cow in line
		 //
		 
		 int numCows = Integer.parseInt(f.readLine());
		 
		 ArrayList<Cow> cows = new ArrayList<>();
		 
		 for(int i = 1; i <= numCows; i++) {
			 String[] arr = f.readLine().split(" ");
			 
			 cows.add(new Cow(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), i));
		 }
		 
		 Collections.sort(cows, (Cow a, Cow b) -> a.arrival == b.arrival? a.seniority - b.seniority: a.arrival - b.arrival);
		 
		 PriorityQueue<Cow> pq = new PriorityQueue<>((Cow a, Cow b) -> a.seniority - b.seniority);
		 
		 int time = 0;
		 int maxWaitTime = 0;
		 
		 while(cows.size() > 0) {
			 while(cows.size() > 0 && cows.get(0).arrival < time) {
				 pq.add(cows.remove(0));
			 }
			 if(pq.size() == 0) {
				 time = cows.get(0).arrival;
				 pq.add(cows.remove(0));
			 }
			 Cow curr = pq.poll();
			 maxWaitTime = Math.max(maxWaitTime, time - curr.arrival);
			 time += curr.eatTime;
		 }
		 
		 System.out.println(maxWaitTime);
		 out.println(maxWaitTime);
		 
		 out.close();
		 f.close();
	}

	static class Cow {
		int arrival, eatTime, seniority;
		int wait = 0;
		
		Cow(int a, int e, int s) {
			arrival = a;
			eatTime = e;
			seniority = s;
		}
	}
	
}
