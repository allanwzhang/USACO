package Section_2_3;
/*
//ID: allanwz1
LANG: JAVA
TASK: nocows
*/

import java.io.*;
import java.util.*;

public class nocows {
	
	static long[][] nh = new long[100][200];
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
	
		 String[] input = f.readLine().split(" ");
		 int nodes = Integer.parseInt(input[0]);
		 int height = Integer.parseInt(input[1]);
		 
		 findWays(5, 15);
		 
		 long result = findWays(height, nodes);
		 
		 int count = 0;
		 
		 for(long[] arr : nh) {
			 System.out.print(count+ ": ");
			 System.out.println(Arrays.toString(arr));
			 count++;
		 }
		 
		 System.out.println(result % 9901);
		 out.println(result % 9901);
		 
		 f.close();
		 out.close();
	}
	
	static long findWays(int height, int nodes) {
		if(nh[height][nodes] != 0) {
//			if(nh[height][nodes] == -1) return 0;
			return nh[height][nodes];
		}
		if(Math.log(nodes) / Math.log(2) >= height || nodes < 2 * height - 1) {
//			nh[height][nodes] = -1;
//			System.out.println(nodes + " " + height);
			return 0;
		}
		if(nodes % 2 == 0) return 0;
		if(nodes == 1) {
			nh[height][nodes] = 1;
			return 1;
		}
		int count = 0;
		for(int i = 1; i < nodes - 1; i += 2) {
			long a = findWays(height - 1, i);
			long b = findWays(height - 1, nodes - i - 1);
			if(a == 0 && b == 0) continue;
			else if(a == 0) {
				for(int j = height - 1; j >= 1; j--) {
					if(findWays(j, i) != 0) {
						a += findWays(j, i);
					}
				}
				count += a * b % 9901;
			}
			else if (b == 0){
				for(int j = height - 1; j >= 1; j--) {
					if(findWays(j, nodes - i - 1) != 0) {
						b += findWays(j, nodes - i - 1);
					}
				}
				count += a * b % 9901;
			}
			else {
				int b2 = 0;
				for(int j = height - 1; j >= 1; j--) {
					if(findWays(j, nodes - i - 1) != 0) {
						b2 += findWays(j, nodes - i - 1);
					}
				}
				count += a * b2 % 9901;
				int a2 = 0;
				for(int j = height - 1; j >= 1; j--) {
					if(findWays(j, i) != 0) {
						a2 += findWays(j, i);
					}
				}
				count += a2 * b % 9901;
				count -= a * b % 9901;
			}
		}
		nh[height][nodes] = count % 9901;
		return count % 9901;
	}
}
