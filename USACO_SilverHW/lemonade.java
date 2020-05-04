package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: lemonade
*/

import java.io.*;
import java.util.Arrays;

public class lemonade {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("lemonade.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		 
		 Integer.parseInt(f.readLine());
		 
		 int[] cows = toIntArray(f.readLine().split(" "));
		 
		 Arrays.sort(cows);
		 
		 int count = 0;
		 
		 for(int i = 0; i < cows.length; i++) {
			 if(cows[i] * -1 >= i) continue;
			 count = i;
			 break;
		 }
		 if(count == 0) count = cows.length;
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]) * -1;
		}
		
		return result;
	}
}
