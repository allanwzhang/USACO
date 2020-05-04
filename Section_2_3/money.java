package Section_2_3;
/*
//ID: allanwz1
LANG: JAVA
TASK: money
*/

import java.io.*;
import java.util.Arrays;

public class money {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("money.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numCoins = Integer.parseInt(arr[0]);
		 int value = Integer.parseInt(arr[1]);
		 
		 int[] possCoins = new int[numCoins];
		 
		 int count = 0;
		 while(count < numCoins) {
			 String[] array = f.readLine().split(" ");
			 for(int i = 0; i < array.length; i++) {
				 possCoins[count + i] = Integer.parseInt(array[i]);
			 }
			 count += array.length;
		 }
		 
		 Arrays.sort(possCoins);
		 
		 long[] numPoss = new long[value + 1];
		 
		 numPoss[0] = 1L;
		 
		 for(int i = 0; i < possCoins.length; i++) {
			 for(int j = possCoins[i]; j < numPoss.length; j++) {
				 if(numPoss[j - possCoins[i]] != 0) {
					 numPoss[j] += numPoss[j - possCoins[i]];
				 }
			 }
		 }
		 
		 System.out.println(Arrays.toString(numPoss));
		 System.out.println(numPoss[numPoss.length - 1]);
		 out.println(numPoss[numPoss.length - 1]);
		 
		 out.close();
		 f.close();
	}
}
