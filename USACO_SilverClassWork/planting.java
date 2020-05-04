package USACO_SilverClassWork;
/*
//ID: allanwz1
LANG: JAVA
TASK: planting
*/

import java.io.*;

public class planting {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("planting.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		 
		 int numFields = Integer.parseInt(f.readLine());
		 
		 int[] degree = new int[numFields + 1];
		 
		 while(f.ready()) {
			 String[] arr = f.readLine().split(" ");
			 degree[Integer.parseInt(arr[0])]++;
			 degree[Integer.parseInt(arr[1])]++;
		 }
		 
		 int max = 0;

		 for(int i : degree) {
			 max = Math.max(i, max);
		 }
		 
		 System.out.println(max + 1);
		 out.println(max + 1);
		 
		 out.close();
		 f.close();
	}
}
