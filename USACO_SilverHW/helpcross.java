package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: helpcross
*/

import java.io.*;
import java.util.*;

public class helpcross {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("helpcross.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numChick = Integer.parseInt(arr[0]);
		 int numCow = Integer.parseInt(arr[1]);
		 
		 int[] chickens = new int[numChick];
		 
		 for(int i = 0; i < numChick; i++) {
			 chickens[i] = Integer.parseInt(f.readLine());
		 }
		 
		 Arrays.sort(chickens);
		 
		 ArrayList<Cow> cows = new ArrayList<>();
		 
		 for(int i = 0; i < numCow; i++) {
			 String[] ar = f.readLine().split(" ");
			 int a = Integer.parseInt(ar[0]);
			 int b = Integer.parseInt(ar[1]);

			 cows.add(new Cow(a, b));
		 }
		 
		 Collections.sort(cows);
		 
		 int count = 0;
		 for(int i = 0; i < chickens.length; i++) {
			 int curr = chickens[i];
			 int min = Integer.MAX_VALUE;
			 int index = -1;
			 for(int j = 0; j < cows.size(); j++) {
				 if(curr >= cows.get(j).a) {
					 if(curr <= cows.get(j).b && cows.get(j).b < min) {
						 min = cows.get(j).b;
						 index = j;
					 }
				 } else {
					 break;
				 }
			 }
			 
			 if(index == -1) continue;
//			 System.out.println(curr + " " + cows.get(index).a + " " + cows.get(index).b + " " + index);
			 count++;
			 cows.remove(index);
		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}

	static class Cow implements Comparable<Cow>{
		int a;
		int b;
		
		Cow(int aa, int bb) {
			a = aa;
			b = bb;
		}

		@Override
		public int compareTo(Cow c) {
			// TODO Auto-generated method stub
			return a - c.a;
		}
	}
}
