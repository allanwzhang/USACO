package Section_3_1;
/*
//ID: allanwz1
LANG: JAVA
TASK: humble
*/

import java.io.*;
import java.util.*;

public class humble {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("humble.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
		 
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 int numPrimes = Integer.parseInt(st.nextToken());
		 int goal = Integer.parseInt(st.nextToken());
		 
		 int[] primes = toIntArray(f.readLine().split(" "));
		 
//		 System.out.println(Arrays.toString(primes));
//		 System.out.println(goal + " " + numPrimes);
		 
		 int result = findHum(primes, numPrimes, goal);
		 System.out.println(result);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}
	
	static int findHum(int[] primes, int numHum, int goal) {
		int[] hum = new int[goal + 1];
		int[] holder = new int[numHum];
		
		hum[0] = 1;
		
		for(int i = 1; i <= goal; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < holder.length; j++) {
				while(holder[j] < i && primes[j] * hum[holder[j]] <= hum[i - 1]) {
					holder[j]++;
				}
				min = Math.min(min, hum[holder[j]] * primes[j]);
			}
			hum[i] = min;
		}
		
		return hum[goal];
	}
	static int[] toIntArray(String[] s) {
		int[] result = new int[s.length];
		for(int i = 0; i < s.length; i++) {
			result[i] = Integer.parseInt(s[i]);
		}
		return result;
	}
}
