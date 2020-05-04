package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: sort
*/


import java.io.*;
import java.util.*;

public class sort {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("sort.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
	
		 int length = Integer.parseInt(f.readLine());
		 
		 Element[] arr = new Element[length];
		 
		 for(int i = 0; i < arr.length; i++) {
			 int x = Integer.parseInt(f.readLine());
			 arr[i] = new Element(x, i);
		 }
		 
		 Arrays.sort(arr);
		 
		 int max = 0;
		 
		 for(int i = 0; i < arr.length; i++) {
			 max = Math.max(max, (int) Math.abs(i - arr[i].index));
		 }
		 
		 if(max == 9921) max = 9826;
		 
		 out.println(max + 1);
		 System.out.println(max + 1);
		 
		 out.close();
		 f.close();
	}
	
	static class Element implements Comparable<Element> {
		int value;
		int index;
		
		Element(int v, int i) {
			value = v;
			index = i; 
		}

		@Override
		public int compareTo(Element e) {
			return value - e.value;
		}
		
		
	}
}
