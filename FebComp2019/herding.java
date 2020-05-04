package FebComp2019;
/*
//ID: allanwz1
LANG: JAVA
TASK: herding
*/


import java.io.*;
import java.util.*;

public class herding {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("herding.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
	
		 int length = Integer.parseInt(f.readLine());
		 int[] nums = new int[length];
		 for(int i = 0; i < length; i++) {
			 nums[i] = Integer.parseInt(f.readLine());
		 }
		 Arrays.sort(nums);
		 
		 int max = 0;
		 int min = Integer.MAX_VALUE;
		 
		 for(int i = 0; i < nums.length; i++) {
			 if(nums[i] + length - 1 > nums[nums.length - 1]) break;
			 int j = i;
			 int count = length;
			 while(j < nums.length && nums[j] < nums[i] + length) {
				 j++;
				 count--;
			 }
			 if(count < min) min = count;
			 if(count > max) max = count;
		 }
		 
		 System.out.println(min);
		 System.out.println(max);
		 out.println(min);
		 out.println(max);
		 
		 f.close();
		 out.close();
	}
}
