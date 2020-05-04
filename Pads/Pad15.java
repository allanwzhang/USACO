package Pads;
/*
//ID: allanwz1
LANG: JAVA
TASK: inflate
*/

import java.io.*;
import java.util.*;

public class Pad15 {
	
	static int left = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
		 
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 
		 int goal = Integer.parseInt(st.nextToken());
		 int numCat = Integer.parseInt(st.nextToken());
		 
		 Comparator<Category> comparator = new CategoryComparator();
		 PriorityQueue<Category> pq = new PriorityQueue<>(10, comparator);
		 
		 for(int i = 0; i < numCat; i++) {
			 String[] arr = f.readLine().split(" ");
			 int points = Integer.parseInt(arr[0]);
			 int minutes = Integer.parseInt(arr[1]);
			 pq.add(new Category(points, minutes, (double) points/minutes));
		 }
		 
		 int curr = 0;
		 int points = 0;
		 
		 while(!pq.isEmpty()) {
			 Category c = pq.poll();
			 while (curr + c.minutes <= goal) {
				 System.out.println(c.minutes + " " + c.points + " " + c.worth);
				 curr += c.minutes;
				 points += c.points;
			 }
		 }
		 
		 System.out.println(points);
		 out.println(points);
		 
		 out.close();
		 f.close();
	}
	
	static class CategoryComparator implements Comparator<Category> {

		@Override
		public int compare(Category a, Category b) {		
			return (int)(10000 * b.worth - 10000 * a.worth);
		}
		
	}
	
	static class Category {
		int minutes;
		int points;
		double worth;
		
		Category(int p, int m, double w) {
			minutes = m;
			points = p;
			worth = w;
		}
	}
}
