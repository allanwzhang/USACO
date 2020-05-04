package Pads;
/*
//ID: allanwz1
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pad6 {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		 
		 f.readLine();
		 int[] vitReq = toIntArray(f.readLine().split(" "));
		 
		 int numFeeds = Integer.parseInt(f.readLine());
		 List<int[]> possVits = new ArrayList<>();
		 
		 for(int i = 0; i < numFeeds; i++) {
			 possVits.add(toIntArray(f.readLine().split(" +")));
		 }
		 
		 for(int i = 1; i < numFeeds; i++) {
			 findMinScoops(vitReq, possVits, new int[i], i);
		 }
		 
		 int count = 0;
		 String printout = "";
		 
//		 for(int i = 0; i < min.length; i++) {
//			 if(min[i] == 2) {
//				 count++;
//				 printout = printout + " " + (i + 1);
//			 }
//		 }
		 
		 System.out.println(count + printout);
		 
		 f.close();
		 out.close();
	}
	
	static void findMinScoops(int[] req, List<int[]> poss, int[] curr, int size) {
		
	}
	
	static boolean satisfy(int[] req, List<int[]> poss, int[] curr, int size) {
		int[] check = new int[req.length];
		int count = 0;
		
		for(int i = 0; i < curr.length; i++) {
			if(i == 2) {
				arrayAdd(check, poss.get(i));
				count++;
			}
		}
		
		if(count != size) return false;
		
		for(int i = 0; i < check.length; i++) {
			if(check[i] < req[i]) return false;
		}
		
		return false;
	}
	
	static void arrayAdd(int[] result, int[] b) {
		for(int i = 0; i < b.length; i++) {
			result[i] = result[i]  + b[i];
		}
	}
	
	static int[] toIntArray(String[] array) {
		int[] result = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = Integer.parseInt(array[i]);
		}
		return result;
	}
}
