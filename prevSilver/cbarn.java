package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: cbarn
*/

import java.io.*;
import java.util.*;

public class cbarn {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		 
		 int size = Integer.parseInt(f.readLine());
		 int[] barn = new int[size];
		 
		 for(int i = 0; i < size; i++) {
			 barn[i] = Integer.parseInt(f.readLine());
		 }
//		 int realStart = -1;
//		 int max = 0;
//		 int cowsCarry = 0;
//		 for(int i = 0; i < barn.length; i++) {
//			 cowsCarry += barn[i] - 1;
//			 if(cowsCarry > max) {
//				 max = cowsCarry;
//				 realStart = i;
//			 }
//		 }
//		 
//		 System.out.println(realStart);
		 
		 long count = 0;
		 long min = Integer.MAX_VALUE;
		 
		 for(int realStart = 0; realStart < barn.length; realStart++) {
			 int i = realStart;
			 PriorityQueue<Integer> cows = new PriorityQueue<>();
			 while(i != realStart || count == 0) {
				 for(int j = 0; j < barn[i]; j++) {
					 if(realStart > i) cows.add(i - (realStart - barn.length));
					 else cows.add(i - realStart);
				 }
				 if(cows.size() <= 0) {
					 count = 0;
					 break;
				 }
				 int oldest = cows.remove();
	//			 System.out.println(oldest);
				 if(realStart > i) {
					 count += Math.pow((i - (realStart - barn.length)) - oldest, 2);
				 } else {
					 count += Math.pow(i - realStart - oldest, 2);
				 }
				 i++;
				 if(i == barn.length) i = 0;
		//			 System.out.println(count);
			 }
			 if(count != 0) min = Math.min(count, min);
			 count = 0;
		 }
	
		 System.out.println(min);
		 out.println(min);
		 
		 out.close();
		 f.close();
	}
	
}
