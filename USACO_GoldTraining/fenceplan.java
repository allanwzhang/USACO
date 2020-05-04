package USACO_GoldTraining;
/*
//ID: allanwz1
LANG: JAVA
TASK: fenceplan
*/

import java.io.*;
import java.util.*;

public class fenceplan {
	
	static HashSet<Integer> visited = new HashSet<>();
	static int currBound = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("fenceplan.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 
		 int numCows = Integer.parseInt(arr[0]);
		 int numConnections = Integer.parseInt(arr[1]);
		 
		 TreeSet<Integer>[] connections = new TreeSet[numCows];
		 
		 for(int i = 0; i < connections.length; i++) {
			 connections[i] = new TreeSet<Integer>();
		 }
		 
		 Cow[] cows = new Cow[numCows];
		 
		 for(int i = 0; i < numCows; i++) {
			 String[] ar = f.readLine().split(" ");
			 cows[i] = new Cow(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]));
		 }
		 
		 for(int i = 0; i < numConnections; i++) {
			 String[] ar = f.readLine().split(" ");
			 int c1 = Integer.parseInt(ar[0]);
			 int c2 = Integer.parseInt(ar[1]);
			 connections[c1 - 1].add(c2 - 1);
			 connections[c2 - 1].add(c1 - 1);
		 }
		 
		 int minBound = Integer.MAX_VALUE;
		 
		 for(int i = 0; i < numCows; i++) {
			 if(visited.contains(i)) continue;
			 currBound = 0;
			 floodfill(i, cows, connections, cows[i].x, cows[i].y, cows[i].x, cows[i].y);
			 minBound = Math.min(minBound, currBound);
		 }
		 
		 System.out.println(minBound);
		 out.println(minBound);
		 
		 out.close();
		 f.close();
	}

	static void floodfill(int cow, Cow[] cows, TreeSet<Integer>[] connections, int maxX, int maxY, int minX, int minY) {
		if(visited.contains(cow)) return;
		visited.add(cow);
		maxX = Math.max(cows[cow].x, maxX);
		maxY = Math.max(cows[cow].y, maxY);
		minX = Math.min(cows[cow].x, minX);
		minY = Math.min(cows[cow].y, minY);
		currBound = Math.max(currBound, 2 * (maxX - minX) + 2 * (maxY - minY));
		
		for(Integer i : connections[cow]) {
			floodfill(i, cows, connections, maxX, maxY, minX, minY);
		}
	}
	
	static class Cow {
		int x,y;
		
		Cow(int xx, int yy) {
			x = xx;
			y = yy;
		}
	}
}