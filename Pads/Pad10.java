package Pads;
/*
//ID: allanwz1
LANG: JAVA
TASK: subset
*/

import java.io.*;

public class Pad10 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("subset.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
	
		int num = Integer.parseInt(f.readLine());
		 
		if((num) * (num + 1) % 4 != 0) {
			out.println(0);
			System.out.println(0);
			out.close();
			f.close();
			return;
		}
		
		int count = 0;
		
		for(int i = 1; i < ((int) Math.pow(2, num)) / 2; i++) {
			if(satisfy(toBinaryArray(i, num), ((num) * (num + 1)) / 4)) {
				count++;
			}
		}
		
		System.out.println(count);
		out.println(count);
		
		out.close();
		f.close();
	}
	
	static String toBinaryArray(int i, int length) {
		String str = Integer.toBinaryString(i);
		
		int missing0 = length - str.length();
		
		for(int j = 0; j < missing0; j++) {
			str = "0" + str;
		}
	
		return str;
	}
	
	static boolean satisfy(String arr, int req) {
		int count = 0;
		for(int i = 0; i < arr.length(); i++) {
			String s = "" + arr.charAt(i);
			if(Integer.parseInt(s) == 1) {
				count = count + i + 1;
			}
		}
		if(count == req) {
			return true;
		}
		return false;
	}
}
