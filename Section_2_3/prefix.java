package Section_2_3;
/*
//ID: allanwz1
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.*;

public class prefix {
	
	static String word = "";
	static HashSet<String> prefixs = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
		 
		 int max = 0;
		 
		 while(true) {
			 String[] arr = f.readLine().split(" ");
			 for(int i = 0; i < arr.length; i++) {
				 if(arr[i].length() > max) max = arr[i].length();
				 prefixs.add(arr[i]);
			 }
			 if(arr[0].equals(".")) break;
		 }
		 
		 StringBuilder sb = new StringBuilder();
		 
		 while(f.ready()) {
			 String s = f.readLine(); 
			 sb.append(s);
		 }
		 
		 word = sb.toString();
		 
		 int[] dpArr = new int[word.length()];
		 Arrays.fill(dpArr, -1);
		 
		 for(int i = 0; i < max; i++) {
			 if(prefixs.contains(word.substring(0, i + 1))) {
				 dpArr[i] = 1;
			 }
		 }
		 
		 for(int i = 1; i < word.length(); i++) {
			 if(dpArr[i] == -1) {
				 int len = Math.min(max, i);
				 for(int j = len; j >= 1; j--) {
					 if(dpArr[i - j] == 1 && prefixs.contains(word.substring(i - j + 1, i + 1))) {
						 dpArr[i] = 1;
						 break;
					 }
				 }
			 }
		 }
		 
//		 System.out.println(Arrays.toString(dpArr));
		 
		 int ret = 0;
		 for(int i = dpArr.length - 1; i >= 0; i--) {
			 if(dpArr[i] == 1) {
				 ret = i + 1;
				 break;
			 }
		 }
		 
		 System.out.println(ret);
		 out.println(ret);
		 
		 out.close();
		 f.close();
	}

}
