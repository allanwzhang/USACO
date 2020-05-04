package Section_2_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: runround
*/

import java.io.*;
import java.util.ArrayList;

public class runround {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("runround.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
	
		 long num = Long.parseLong(f.readLine()) + 1;
		 
		 
		 while(true) {
			 String number = "" + num;
			 char[] numArr = number.toCharArray();
			 if(!diffDigits(numArr)) {
				 num++;
				 continue;
			 }
			 if(!checkRunround(numArr)) {
				 num++;
				 continue;
			 }
			 break;
		 }
		 
		 System.out.println(num);
		 out.println(num);
		 
		 out.close();
		 f.close();
	}
	
	static boolean diffDigits(char[] num) {
		ArrayList<Character> holder = new ArrayList<>();
		for(char c : num) {
			int digit = Character.getNumericValue(c);
			if(holder.contains(c) || digit % num.length == 0) return false;
			holder.add(c);
		}
		return true;
	}
	
	static boolean checkRunround(char[] num) {
		int[] passed = new int[num.length];
		int count = 0;
		int i = 0;
		while(count < num.length) {
			if(passed[i] == 1) return false;
			passed[i] = 1;
			i = (i + Character.getNumericValue(num[i])) % num.length;
			count++;
		}
		if(i != 0) return false;
		return true;
	}
}
