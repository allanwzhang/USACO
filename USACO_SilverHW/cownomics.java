package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: cownomics
*/

import java.io.*;
import java.util.*;

public class cownomics {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
	
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 int cows = Integer.parseInt(st.nextToken());
		 int genomeSize = Integer.parseInt(st.nextToken());
		 
		 String[] spotted = new String[cows];
		 String[] plain = new String[cows];
		 
		 for(int i = 0; i < cows; i++) {
			 spotted[i] = f.readLine();
		 }
		 for(int i = 0; i < cows; i++) {
			 plain[i] = f.readLine();
		 }
		 
		 int count = 0;
		 
		 for(int i = 0; i < genomeSize; i++) {
			 for(int j = i + 1; j < genomeSize; j++) {
				 for(int k = j + 1; k < genomeSize; k++) {
					 HashSet<Integer> curr = new HashSet<>();
					 for(int a = 0; a < spotted.length; a++) {
						 curr.add(findInt(spotted[a], i, j, k));
					 }
					 for(int a = 0; a < plain.length; a++) {
						 if(curr.contains(findInt(plain[a], i, j , k))) break;
						 if(a == plain.length - 1) count++;
					 }
				 }
			 }
		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}
	
	static int findInt(String spotted, int i, int j, int k) {
		return convert(spotted.charAt(i)) * 100 + convert(spotted.charAt(j)) * 10 + convert(spotted.charAt(k));
	}
	static int convert(char c) {
		if(c == 'A') return 1;
		if(c == 'C') return 2;
		if(c == 'G') return 3;
		return 4;
	}
}
