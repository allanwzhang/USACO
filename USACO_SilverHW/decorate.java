package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: decorate
*/

import java.io.*;
import java.util.TreeSet;

public class decorate {
	
	static int count1 = 0;
	static int count2 = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("decorate.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("decorate.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 
		 int numCows = Integer.parseInt(arr[0]);
		 int numPaths = Integer.parseInt(arr[1]);
		 
		 TreeSet<Integer>[] connections = new TreeSet[numCows];
		 int[] visited = new int[numCows];
		 
		 for(int i = 0; i < connections.length; i++) {
			 connections[i] = new TreeSet<Integer>();
		 }
		 
		 for(int i = 0; i < numPaths; i++) {
			 String[] ar = f.readLine().split(" ");
			 connections[Integer.parseInt(ar[0]) - 1].add(Integer.parseInt(ar[1]) - 1);
			 connections[Integer.parseInt(ar[1]) - 1].add(Integer.parseInt(ar[0]) - 1);
		 }
		 
		 int result = 0;
		 
		 for(int i = 0; i < numCows; i++) {
			 if(visited[i] != 0) continue;
			 floodfill(i, connections, visited, 1);
			 if(count1 == -1) {
				 result = -1;
				 break;
			 }
			 result += Math.max(count1, count2);
			 count1 = 0;
			 count2 = 0;
		 }
		 
		 System.out.println(result);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}
	
	static void floodfill(int i, TreeSet<Integer>[] connections, int[] visited, int letter) {
//		System.out.println(i + " " + count);
		if(count1 == -1) return;
		if(visited[i] != 0) {
			if(visited[i] != letter) count1 = -1;
			return;
		}
		if(letter == 1) {
			count1++;
		} else {
			count2++;
		}
		visited[i] = letter;
		letter *= -1;
		for(Integer next : connections[i]) {
			floodfill(next, connections, visited, letter);
		}
	}

}
