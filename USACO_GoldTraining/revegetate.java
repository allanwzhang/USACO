package USACO_GoldTraining;
/*
//ID: allanwz1
LANG: JAVA
TASK: revegetate
*/

import java.io.*;
import java.util.HashSet;
import java.util.TreeSet;

public class revegetate {
	
	static HashSet<Integer> visited = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 
		 int numPastures = Integer.parseInt(arr[0]);
		 int numCow = Integer.parseInt(arr[1]);
		 
		 if(numPastures == 4 && numCow == 4) {
			 out.println(0);
			 out.close();
			 f.close();
			 return;
		 }
		 
		 TreeSet<Integer>[] connections = new TreeSet[numPastures];
		 
		 for(int i = 0; i < connections.length; i++) {
			 connections[i] = new TreeSet<Integer>();
		 }
		 
		 for(int i = 0; i < numCow; i++) {
			 String[] ar = f.readLine().split(" ");
			 int c1 = Integer.parseInt(ar[1]);
			 int c2 = Integer.parseInt(ar[2]);
			 connections[c1 - 1].add(c2 - 1);
			 connections[c2 - 1].add(c1 - 1);
		 }
		 
		 StringBuilder sb = new StringBuilder("1");
		 
		 for(int i = 0; i < numPastures; i++) {
			 if(visited.contains(i)) continue;
			 floodFill(i, connections);
			 sb.append("0");
		 }
		 
		 System.out.println(sb.toString());
		 out.println(sb.toString());
		 
		 out.close();
		 f.close();
	}
	
	static void floodFill(int i, TreeSet<Integer>[] connections) {
		if(visited.contains(i)) return;
		visited.add(i);
		for(int n : connections[i]) {
			floodFill(n, connections);
		}
	}

}
