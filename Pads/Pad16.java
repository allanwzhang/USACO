package Pads;
/*
//ID: allanwz1
LANG: JAVA
TASK: humble
*/

import java.io.*;
import java.util.*;

public class Pad16 {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("humble.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
		 
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 st.nextToken();
		 int goal = Integer.parseInt(st.nextToken());
		 
		 int[] primes = toIntArray(f.readLine().split(" "));
		 
//		 int max = 0;
//		 int index = 0; 
//		 for(int i = 0; i < primes.length; i++) {
//			 if(primes[i] > max) {
//				 max = primes[i];
//				 index = i;
//			 }
//		 }
		 
		 int[] totalArr = new int[40000];
		 
		 for(int i = 0; i < primes.length; i++) {
			 totalArr[primes[i]] = 1;
		 }
		 
		 for(int i = 1; i < totalArr.length; i++) {
			 for(int j = i; j * i < totalArr.length; j++) {
				 if(totalArr[i] == 1 && totalArr[j] == 1 && totalArr[i * j] == 0) {
					 totalArr[i * j] = 1;
				 }
			 }
		 }
		 
//		 System.out.println(Arrays.toString(totalArr));
		 
		 int count = 0;
		 
		 for(int i = 0; i < totalArr.length; i++) {
			 if(totalArr[i] == 1) {
				 count++;
			 }
			 if(count == goal) {
				 System.out.println(i);
				 out.println(i);
				 break;
			 }
		 }
		 
		 out.close();
		 f.close();
	}
	
	static int[] toIntArray(String[] s) {
		int[] result = new int[s.length];
		for(int i = 0; i < s.length; i++) {
			result[i] = Integer.parseInt(s[i]);
		}
		return result;
	}
}
