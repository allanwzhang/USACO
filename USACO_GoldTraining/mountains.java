package USACO_GoldTraining;
/*
//ID: allanwz1
LANG: JAVA
TASK: mountains
*/

import java.io.*;
import java.util.*;

public class mountains {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
	
		 int numMountains = Integer.parseInt(f.readLine());
		 Mountain[] mountains = new Mountain[numMountains];
		 
		 for(int i = 0; i < numMountains; i++) {
			 String[] arr = f.readLine().split(" ");
			 mountains[i] = new Mountain(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
//			 System.out.println(mountains[i].x + " " + mountains[i].y);
		 }
		 
		 Arrays.sort(mountains);
		 
		 int answer = 1;
		 
		 int count = 1;
		 Mountain tallest = mountains[0];
		 
		 while(count < numMountains) {
			 Mountain curr = mountains[count];
			 if(curr.x + curr.y > tallest.x + tallest.y) {
				 answer++;
				 tallest = curr;
			 }
			 count++;
		 }
		 
		 System.out.println(answer);
		 out.println(answer);
		 
		 out.close();
		 f.close();
	}
	
	static class Mountain implements Comparable<Mountain> {
		int x, y;
		
		Mountain(int xx, int yy) {
			x = xx;
			y = yy;
		}

		public int compareTo(Mountain m) {
			if((x - y) - (m.x - m.y) == 0) {
				return m.y - y;
			}
			return (x - y) - (m.x - m.y);
		}
	}
}
