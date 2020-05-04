package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: convention
*/

import java.io.*;
import java.util.Arrays;

public class convention {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("convention.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 
		 int numCows = Integer.parseInt(arr[0]);
		 int numBuses = Integer.parseInt(arr[1]);
		 int busCapacity = Integer.parseInt(arr[2]);
		 
		 int[] cows = new int[numCows];
		 cows = toIntArray(f.readLine().split(" "));
		 
		 Arrays.sort(cows);
		 
		 long result = binarySearch(0L, 10000000000L, cows, numBuses, busCapacity);
		 
		 System.out.println(result);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}

	static long binarySearch(long min, long max, int[] cows, int numBuses, int busCapacity) {
		while(min < max) {
			long mid = (min + max) / 2;
			if(works(mid, cows, numBuses, busCapacity)) {
//				System.out.println(mid + " works");
				max = mid;
			} else {
				min = mid + 1;
			}
//			System.out.println(min + " " + max);
		}
		return min;
	}

	static boolean works(long goal, int[] cows, int numBuses, int busCapacity) {
		int lastCow = cows[0];
		int count = 1;
		int busCount = 0;
		
		for(int i = 1; i < cows.length; i++) {
			if(count == busCapacity) {
				lastCow = cows[i];
				busCount++;
				count = 0;
			}
			if(cows[i] - lastCow > goal) {
				busCount++;
				count = 1;
				lastCow = cows[i];
			} else {
				count++;
			}
		}
		if(busCount + 1 <= numBuses) return true;
		return false;
	}
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
	
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
	
		return result;
	}
}
