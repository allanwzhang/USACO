package NotComplete;
/*
//ID: allanwz1
LANG: JAVA
TASK: balancing
*/

import java.io.*;

public class balancing {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		 
		 int numCows = Integer.parseInt(f.readLine());
		 
		 Cow[] cows = new Cow[numCows];
		 
		 for(int i = 0; i < numCows; i++) {
			 String[] arr = f.readLine().split(" ");
			 Cow curr = new Cow(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			 cows[i] = curr;
		 }
		 
		 int min = Integer.MAX_VALUE;
		 
		 for(int i = 0; i < cows.length; i++) {
			 Cow curr = cows[i];
			 int ur = 0;
			 int ul = 0;
			 int dr = 0;
			 int dl = 0;
			 
			 for(int j = 0; j < cows.length; j++) {
				 Cow comp = cows[j];
				 if(comp.x > curr.x && comp.y > curr.y) dr++;
				 if(comp.x > curr.x && comp.y <= curr.y) ur++;
				 if(comp.x <= curr.x && comp.y > curr.y) dl++;
				 if(comp.x <= curr.x && comp.y <= curr.y) ul++;
			 }
			 
			 min = Math.min(min, Math.max(Math.max(ur, ul), Math.max(dr, dl)));
		 }
		 
		 System.out.println(min);
		 out.println(min);
		 
		 out.close();
		 f.close();
	}

	static class Cow {
		int x, y;
		
		Cow(int xx, int yy) {
			x = xx;
			y = yy;
		}
	}
}
