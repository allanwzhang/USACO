package USACO_GoldTraining;
/*
//ID: allanwz1
LANG: JAVA
TASK: lifeguards
*/

import java.io.*;
import java.util.*;

public class lifeguards {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
	
		 int numGuards = Integer.parseInt(f.readLine());
		 
		 ArrayList<Guard> guards = new ArrayList<>();
		 
		 for(int i = 0; i < numGuards; i++) {
			 String[] arr = f.readLine().split(" ");
			 guards.add(new Guard(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
		 }
		 
		 Collections.sort(guards, (Guard a, Guard b) -> a.start - b.start);
		 
		 int min = guards.get(1).start - guards.get(0).start;
		 int minStart = guards.get(0).start;
		 int maxEnd = guards.get(0).end;
		 
		 int middleGaps = Math.max(guards.get(1).start - guards.get(0).end, 0);
		 
		 guards.remove(0);
		 
		 while(guards.size() > 1) {
			 Guard curr = guards.remove(0);
			 int currMin = Math.min(curr.end, guards.get(0).start);
			 if(Math.max(maxEnd, curr.end) < guards.get(0).start) {
				middleGaps += guards.get(0).start - Math.max(maxEnd, curr.end); 
			 }
			 int diff = currMin - maxEnd;
			 if(diff < 0) diff = 0;
			 min = Math.min(min, diff);
			 maxEnd = Math.max(maxEnd, curr.end);
		 }
		 
		 int diff = Math.max(guards.get(0).end - Math.max(maxEnd, guards.get(0).start), 0);
		 min = Math.min(min, diff);
		 maxEnd = Math.max(maxEnd, guards.remove(0).end);
		 
		 System.out.println(maxEnd - minStart - middleGaps - min);
		 out.println(maxEnd - minStart - middleGaps - min);
		 
		 out.close();
		 f.close();
	}

	static class Guard {
		int start, end;
		
		Guard(int s, int e) {
			start = s;
			end = e;
		}
	}
	
}
