package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: haybales
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class haybales {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 
		 st.nextToken();
		 int numRange = Integer.parseInt(st.nextToken());

		 int[] bales = toIntArray(f.readLine().split(" "));
		 Arrays.sort(bales);
		 
		 for(int i = 0; i < numRange; i++) {
			 st = new StringTokenizer(f.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 int bsb = binarySearch(b, bales);
			 int bsa = binarySearch(a - 1, bales);
			 out.println(bsb - bsa);
			 System.out.println(bsb - bsa);
		 }
		 
		 out.close();
		 f.close();
	}
	
	public static int binarySearch(int x, int[] arr) {
		if(arr[0] > x) {
			return 0;
		}
		int min = 0;
		int max = arr.length-1;
		
		while(min != max) {
			int mid = (min+max+1)/2;
			if(arr[mid] <= x) {
				min = mid;
			}
			else {
				max = mid-1;
			}
		}
		return min + 1;
	}
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
		
		return result;
	}
}
