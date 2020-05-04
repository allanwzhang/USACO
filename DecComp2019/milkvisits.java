package DecComp2019;
/*
//ID: allanwz1
LANG: JAVA
TASK: milkvisits
*/

import java.io.*;
import java.util.*;

public class milkvisits {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numFarms = Integer.parseInt(arr[0]);
		 int numFarmers = Integer.parseInt(arr[1]);
		 
		 char[] farmTypes = f.readLine().toCharArray();

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
		 
		 StringBuilder result = new StringBuilder("");
		 
		 for(int i = 0; i < numFarmers; i++) {
			 String[] arrr = f.readLine().split(" ");
			 int start = Integer.parseInt(arrr[0]) - 1;
			 int end = Integer.parseInt(arrr[1]) - 1;
			 char cow = arrr[2].charAt(0);
			 if(farmTypes[start] != farmTypes[end] || farmTypes[start] == cow) result.append("1");
			 else if(!findPath(edges, -1, start, end, cow, farmTypes)) result.append("1");
			 else result.append("0");
		 }
		 
		 System.out.println(result);
		 out.println(result.toString());
		 
		 out.close();
		 f.close();
	}

	static boolean findPath(LinkedList<Integer>[] edges, int prev, int curr, int end, char cow, char[] types) {
		if(types[curr] == cow) return false;
		if(curr == end) return true;
		for(Integer neighbor : edges[curr]) {
			if(neighbor != prev && findPath(edges, curr, neighbor, end, cow, types)) return true;
		}
		return false;
	}
}