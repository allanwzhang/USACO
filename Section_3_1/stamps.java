package Section_3_1;
/*
//ID: allanwz1
LANG: JAVA
TASK: stamps
*/

import java.io.*;
import java.util.*;

public class stamps {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("stamps.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));
	
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 int max = Integer.parseInt(st.nextToken());
		 int numStamps = Integer.parseInt(st.nextToken());
		 
		 int stamps[] = new int[numStamps];
		 
		 int index = 0;
		 
		 while(f.ready()) {
			 StringTokenizer str = new StringTokenizer(f.readLine());
			 while(str.hasMoreTokens()) {
				 stamps[index] = Integer.parseInt(str.nextToken());
				 index++;
			 }
		 }
		 
		 Arrays.sort(stamps);
		 
//		 System.out.println(Arrays.toString(stamps));
		 
		 int[] arr = new int[2000000];
		 
		 int result = 0;
		 
		 for(int i = 1; i < arr.length; i++) {
			 int min = Integer.MAX_VALUE;
			 for(int j : stamps) {
				 if(j <= i && arr[i - j] < max) {
					 min = Math.min(min, arr[i - j] + 1);
				 }
			 }
			 if(min == Integer.MAX_VALUE) {
				 result = i;
				 break;
			 } else {
//				System.out.println(i + " " + min);
				arr[i] = min; 
			 }
		 }
		 
		 System.out.println(result - 1);
		 out.println(result - 1);
		 
		 out.close();
		 f.close();
	}

	static int[] toIntArray(String[] c) {
		int[] result = new int[c.length];
		for(int i = 0; i < c.length; i++) {
			result[i] = Integer.parseInt(c[i]);
		}
		return result;
	}
}
