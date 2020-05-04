package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: mootube
*/

import java.io.*;

public class mootube {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numVideos = Integer.parseInt(arr[0]);
		 int numQueries = Integer.parseInt(arr[1]);
		 
		 int[][] connections = new int[numVideos][numVideos];
		 
		 for(int i = 0; i < numVideos - 1; i++) {
			 String[] curr = f.readLine().split(" ");
			 int a = Integer.parseInt(curr[0]) - 1;
			 int b = Integer.parseInt(curr[1]) - 1;
			 int relevance = Integer.parseInt(curr[2]);
			 
			 connections[a][b] = relevance;
			 connections[b][a] = relevance;
			 
			 for(int j = 0; j < connections.length; j++) {
				 if(j != b && connections[j][a] != 0) {
					 System.out.println(a + " " + b + " " + j);
					 connections[j][b] = Math.min(relevance, connections[j][a]);
					 connections[b][j] = Math.min(relevance, connections[j][a]);
				 } else if(j != a && connections[j][b] != 0) {
					 connections[j][a] = Math.min(relevance, connections[j][b]);
					 connections[a][j] = Math.min(relevance, connections[j][b]);
				 }
				 
			 }
		 }
		 
		 for(int i = 0; i < numQueries; i++) {
			 String[] curr = f.readLine().split(" ");
			 int minRelevance = Integer.parseInt(curr[0]);
			 int start = Integer.parseInt(curr[1]) - 1;
			 int count = 0;
			 for(int j = 0; j < connections.length; j++) {
				 if(connections[j][start] >= minRelevance) count++;
			 }
//			 System.out.println(count);
			 out.println(count);
		 }
		 
		 out.close();
		 f.close();
	}

}
