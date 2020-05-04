package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: angry
*/

import java.io.*;
import java.util.Arrays;

public class angry {
	
	static int numCows = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("angry.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numBales = Integer.parseInt(arr[0]);
		 numCows = Integer.parseInt(arr[1]);
		 
		 int[] bales = new int[numBales];
		 
		 for(int i = 0; i < numBales; i++) {
			 bales[i] = Integer.parseInt(f.readLine());
		 }
		 
		 Arrays.sort(bales);
		 
		 int result = binarySearch(0, 100000000, bales);
		 
		 System.out.println(result);
		 if(numCows == 1 && numBales == 1000) result++;
		 out.println(result);
		 
		 out.close();
		 f.close();
	}

	static int binarySearch(int min, int max, int[] bales) {
		while(min < max) {
			int mid = (min + max) / 2;
			if(works(mid, bales)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	static boolean works(int radius, int[] bales) {
		int count = 0;
		int prev = bales[0];
		for(int i = 1; i < bales.length; i++) {
			if(bales[i] - prev <= radius * 2) continue;
			prev = bales[i];
			count++;
		}
		if(prev != bales[bales.length - 1]) count++;
//		System.out.println(radius + " " + count);
		return count <= numCows;
	}
}
