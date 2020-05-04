package Section_3_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: ratios
*/

import java.io.*;

public class ratios {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("ratios.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));
	
		 int[] goal = toIntArray(f.readLine().split(" "));
		 
		 int[] combo1 = toIntArray(f.readLine().split(" "));
		 int[] combo2 = toIntArray(f.readLine().split(" "));
		 int[] combo3 = toIntArray(f.readLine().split(" "));
		 
		 int min = Integer.MAX_VALUE;
		 int[] result = new int[4];
		 
		 for(int i = 0; i < 101; i++) {
			 for(int j = 0; j < 101; j++) {
				 for(int k = 0; k < 101; k++) {
					 if(i + j + k > min) break;
					 int[] sum = sumArray(combo1, i, combo2, j, combo3, k);
					 if(isRatio(goal, sum)) {
						 result[0] = i;
						 result[1] = j;
						 result[2] = k;
						 result[3] = sum[0] / goal[0];
						 min = i + j + k;
					 }
				 }
			 }
		 }
		 
		 if(min == Integer.MAX_VALUE) {
			 System.out.println("NONE");
			 out.println("NONE");
			 out.close();
			 f.close();
			 return;
		 }
		 
		 System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
		 out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
		 
		 out.close();
		 f.close();
	}
	
	static boolean isRatio(int[] goal, int[] sum) {
		if(goal[0] == 0 || sum[0] / goal[0] == 0) return false;
		
		float ratio = 1.0f * sum[0] / goal[0];
		
		for(int i = 1; i < goal.length; i++) {
			if(sum[i] == 0 && goal[i] == 0) continue;
			if(1.0f * sum[i] / goal[i] != ratio) return false;
		}
		
		return true;
	}
	
	static int[] sumArray(int[] one, int num1, int[] two, int num2, int[] three, int num3) {
		int[] result = new int[3];
		for(int i = 0; i < result.length; i++) {
			result[i] = one[i] * num1 + two[i] * num2 + three[i] * num3;
		}
		return result;
	}
	
	static int[] toIntArray(String[] s) {
		int[] result = new int[s.length];
		for(int i = 0; i < s.length; i++) {
			result[i] = Integer.parseInt(s[i]);
		}
		return result;
	}
}
