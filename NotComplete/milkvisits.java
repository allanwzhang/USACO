package NotComplete;
/*
//ID: allanwz1
LANG: JAVA
TASK: milkvisits
*/

import java.io.*;
import java.util.LinkedList;

public class milkvisits {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numFarms = Integer.parseInt(arr[0]);
		 int numReq = Integer.parseInt(arr[1]);
		 char[] types = f.readLine().toCharArray();
		 
		 LinkedList<Integer>[] edges = new LinkedList[numFarms];
		 
		 for(int i = 0; i < numFarms; i++) {
				edges[i] = new LinkedList<Integer>();
		 }
		 
		 for(int i = 0; i < numFarms - 1; i++) {
			 String[] ar = f.readLine().split(" ");
			 int a = Integer.parseInt(ar[0]) - 1;
			 int b = Integer.parseInt(ar[1]) - 1;
			 edges[a].add(b);
			 edges[b].add(a);
		 }
		 
		 int[] parents = new int[numFarms];
		 for(int i = 0; i < parents.length; i++) {
			 parents[i] = i * -1;
		 }
		 dfs(edges, 0, 0, parents, types, new boolean[numFarms]);
		 
//		 System.out.println(Arrays.toString(parents));
		 
		 StringBuilder result = new StringBuilder("");
		 
		 for(int i = 0; i < numReq; i++) {
			 String[] curr = f.readLine().split(" ");
			 int start = Integer.parseInt(curr[0]) - 1;
			 int end = Integer.parseInt(curr[1]) - 1;
			 char req = curr[2].charAt(0);
			 if(parents[start] == parents[end] && types[start] != req) result.append("0");
			 else result.append("1");
		 }
		 
//		 System.out.println(result.toString());
		 out.println(result.toString());
		 
		 out.close();
		 f.close();
	}

	static void dfs(LinkedList<Integer>[] connections, int curr, int prev, int[] parents, char[] types, boolean[] visited) {
		if(types[curr] == types[prev]) {
			parents[curr] = parents[prev];
		}
		visited[curr] = true;
		for(Integer neighbor : connections[curr]) {
			if(!visited[neighbor]) dfs(connections, neighbor, curr, parents, types, visited);
		}
	}
	
}
