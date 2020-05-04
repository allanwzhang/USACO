package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: closing
*/

import java.io.*;
import java.util.*;

public class closing {
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("closing.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numFarms = Integer.parseInt(arr[0]);
		 int connections = Integer.parseInt(arr[1]);
		 
		 LinkedList<Integer>[] edges = new LinkedList[numFarms];
		 for(int i = 0; i < edges.length; i++) {
			 edges[i] = new LinkedList<Integer>();
		 }
		 
		 for(int i = 0; i < connections; i++) {
			 String[] ar = f.readLine().split(" ");
			 int a = Integer.parseInt(ar[0]);
			 int b = Integer.parseInt(ar[1]);
			 edges[a - 1].add(b - 1);
			 edges[b - 1].add(a - 1);
		 }
		 
		 int[] order = new int[numFarms];
		 for(int i = 0; i < numFarms; i++) {
			 order[i] = Integer.parseInt(f.readLine());
		 }
		 
		 isFullyConnected(edges, new boolean[numFarms], order[numFarms - 1] - 1);
		 if(count == numFarms) {
			 out.println("YES");
		 }
		 count = 0;
		 
		 for(int i = 0; i < order.length - 1; i++) {
			 Integer curr = order[i] - 1;
			 for(Integer j : edges[curr]) {
				 edges[j].remove(curr);
			 }
			 edges[curr] = new LinkedList<Integer>();
			 isFullyConnected(edges, new boolean[numFarms], order[numFarms - 1] - 1);
			 if(count == numFarms - i - 1) {
				 out.println("YES");
			 } else {
				 System.out.println(count + " " + (numFarms - i - 1));
				 out.println("NO");
			 }
			 count = 0;
		 }
//		 out.println("YES");
		 
		 f.close();
		 out.close();
	}
	
	static void isFullyConnected(LinkedList<Integer>[] edges, boolean[] visited, int curr) {
		if(visited[curr]) return;
		count++;
		visited[curr] = true;
		for(Integer i : edges[curr]) {
			isFullyConnected(edges, visited, i);
		}
	}
}
