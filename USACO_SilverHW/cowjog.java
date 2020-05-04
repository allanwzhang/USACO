package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: cowjog
*/

import java.io.*;
import java.util.*;

public class cowjog {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("cowjog.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numCows = Integer.parseInt(arr[0]);
		 double timeLimit = Integer.parseInt(arr[1]);
		 
		 ArrayList<Cow> cows1 = new ArrayList<>();
		 
		 for(int i = 0; i < numCows; i++) {
			 String[] curr = f.readLine().split(" ");
			 cows1.add(new Cow(Integer.parseInt(curr[0]), Integer.parseInt(curr[1])));
		 }
		 
		 ArrayList<Cow> cows = new ArrayList<>();
		 
		 for(int i = cows1.size() - 1; i >= 0; i--) {
			 cows.add(cows1.get(i));
		 }
		 
		 int i = 1;
		 
		 while(i < cows.size()) {
			 Cow a = cows.get(i - 1);
			 Cow b = cows.get(i);
			 if((a.position - b.position) / (b.speed - a.speed) <= timeLimit && b.speed - a.speed > 0) {
//				 System.out.println("removed " + b.position + " " + b.speed);
				 cows.remove(i);
			 } else {
				 i++;
			 }
		 }
		 
		 System.out.println(cows.size());
		 out.println(cows.size());
		 
		 out.close();
		 f.close();
	}

	static class Cow {
		double position, speed;
		
		Cow(double p, double s) {
			position = p;
			speed = s;
		}
	}
}
