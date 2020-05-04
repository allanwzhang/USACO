package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: div7
*/

import java.io.*;

public class div7 {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("div7.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		 
		 int numInt = Integer.parseInt(f.readLine());
		 
		 int[] nums = new int[numInt];
		 
		 int[] maxModSev = new int[7];
		 
		 int count = 0;
		 
		 for(int i = 0; i < numInt; i++) {
			 nums[i]  = (int) (Long.parseLong(f.readLine()) % 7);
			 count += nums[i];
			 count %= 7;
			 maxModSev[count] = i;
		 }
		 
		 int max = maxModSev[0];
		 
		 int sum = 0;
		 
		 for(int i = 0; i < numInt; i++) {
			 sum += nums[i];
			 sum %= 7;
			 max = Math.max(max, maxModSev[sum] - i);
		 }
		 
		 System.out.println(max);
		 out.println(max);
		 
		 out.close();
		 f.close();
	}

}
