package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: sleepy
*/


import java.io.*;

public class sleepy {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
		 
		 Integer.parseInt(f.readLine());
		 int[] cows = toIntArray(f.readLine().split(" "));
		 int result = 0;
		 
		 for(int i = cows.length - 1; i > 0; i--) {
			 if(cows[i] < cows[i - 1]) {
				 result = i;
				 break;
			 }
		 }
		 
		 System.out.println(result);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
		
		return result;
	}
}
