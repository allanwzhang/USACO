package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: fairphoto
*/

import java.io.*;
import java.util.*;

public class fairphoto {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("fairphoto.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fairphoto.out")));
	
		 int numCows = Integer.parseInt(f.readLine());
		 
		 Cow[] cows = new Cow[numCows];
		 
		 for(int i = 0; i < numCows; i++) {
			 String[] arr = f.readLine().split(" ");
			 if(arr[1].charAt(0) == 'G') {
				 cows[i] = new Cow(-1, Integer.parseInt(arr[0]));
			 } else {
				 cows[i] = new Cow(1, Integer.parseInt(arr[0]));
			 }
		 }
		 
		 Arrays.sort(cows);
		 
		 long max = 0;
		 
		 int curr = cows[0].type;
		 int startIndex = 0;
		 
		 for(int i = 1; i < cows.length; i++) {
			 if(cows[i].type == curr) continue;
			 max = Math.max(max, cows[i - 1].pos - cows[startIndex].pos);
			 startIndex = i;
			 curr = cows[i].type;
		 }
		 
		 for(int i = 1; i < cows.length; i++) {
			 cows[i].type = cows[i].type + cows[i - 1].type;
		 }
		 
		 HashMap<Integer, Integer> visited = new HashMap<>();
		 
		 for(int i = 0; i < cows.length; i++) {
			 if(visited.keySet().contains(cows[i].type)) {
				 max = Math.max(max, cows[i].pos - cows[visited.get(cows[i].type) + 1].pos);
				 continue;
			 }
			 visited.put(cows[i].type, i);
		 }
		 
		 System.out.println(max);
		 out.println(max);
		 
		 out.close();
		 f.close();
	}
	
	static class Cow implements Comparable<Cow> {
		int type = 0;
		int pos = 0;
		
		Cow(int t, int p) {
			type = t;
			pos = p;
		}

		@Override
		public int compareTo(Cow c) {
			return pos - c.pos;
		}
	}
	
}
