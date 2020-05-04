package Section_3_1;
/*
//ID: allanwz1
LANG: JAVA
TASK: contact
*/

import java.io.*;
import java.util.*;

public class contact {
	
	public static void main(String[] args) throws IOException { 
  		 BufferedReader f = new BufferedReader(new FileReader("contact.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
		 
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 
		 int minLen = Integer.parseInt(st.nextToken());
		 int maxLen = Integer.parseInt(st.nextToken());
		 int numVari = Integer.parseInt(st.nextToken());
		 
		 StringBuilder sb = new StringBuilder("");
		 
		 while(f.ready()) {
			 sb.append(f.readLine());
		 }
		 
		 String code = sb.toString();
		 
		 Map<Integer, Integer> freq = new HashMap<>();
		 
		 if(minLen == 1) {
			 int curr = code.charAt(0) - '0';
			 freq.put(curr + 2, 1);
		 }
		 
		 int curVal = code.charAt(0) - '0';
		 for(int i = 1; i < code.length(); i++) {
			 int rawVal = code.charAt(i) - '0';
			 int val = 0;
			 for(int k = 0; k <= maxLen; k++) {
				 if(k > i + 1) {
					 break;
				 }
				 val = getLastM(curVal, k - 1);
				 val = 1 << k | val << 1 | rawVal;
//				 System.out.println(val);
				 if(k >= minLen) freq.put(val, freq.getOrDefault(val, 0)+1);
			 }
			 curVal = val;
		 }
		 
//		 for(int i : freq.keySet()) {
//			 System.out.println(i + " " + freq.get(i));
//		 }
		 
		 TreeMap<Integer, ArrayList<Integer>> result = new TreeMap<>(Collections.reverseOrder());
		 
		 for(int i : freq.keySet()) {
			 int fre = freq.get(i);
			 if(result.containsKey(fre)) {
				 result.get(fre).add(i);
			 } else {
				 ArrayList<Integer> arr = new ArrayList<>();
				 arr.add(i);
				 result.put(fre, arr);
			 }
		 }
		 
		 int count = 1;
		 
		 for(int i : result.keySet()) {
			 if(count > numVari) break;
			 ArrayList<Integer> arr = result.get(i);
			 out.println(i);
//			 System.out.println(i);
			 out.print(toCode(arr.get(0)));
//			 System.out.print(toCode(arr.get(0)));
			 for(int j = 1; j < arr.size(); j++) {
				 if(j % 6 == 0) { 
					 out.println();
					 out.print(toCode(arr.get(j)));
				 } else {
					 out.print(" " + toCode(arr.get(j)));
				 }
//				 System.out.print(" " + toCode(arr.get(j)));
			 }
//			 System.out.println();
			 out.println();
			 count++;
		 }
		 
		 out.close();
		 f.close();
	}
	
	static String toCode(int i) {
		String result = Integer.toBinaryString(i);
		return result.substring(1);
	}
	
	static int getLastM(int curVal, int i) {
//		System.out.println(curVal);
//		System.out.println(i);`2
//		System.out.println("test: " + ((1 << i) - 1));
		return curVal & ((1 << i) - 1);
	}
}
