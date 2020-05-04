package Section_2_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: subset
*/

import java.io.*;

public class subset {

	static int[][] kToN = new int[40][390];
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("subset.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
	
		int num = Integer.parseInt(f.readLine());
		 
		if((num) * (num + 1) % 4 != 0) {
			out.println(0);
		} else {
			setArray();
			out.println(findCombos(num - 1, num * (num + 1) / 4 - num));
		}
		
		out.close();
		f.close();
	}
	
	static void setArray() {
		for(int i = 0; i < kToN.length; i++) {
			for(int j = 0; j < kToN[0].length; j++) {
				kToN[i][j] = -1;
			}
		}
 	}
	
	static int findCombos(int n, int k) {
		if(n < 0 || k < 0) return 0;
		if(k == 0) return kToN[n][k] = 1;
		if(kToN[n][k] != -1) return kToN[n][k];
		return kToN[n][k] = findCombos(n - 1, k) + findCombos(n - 1, k - n);
	}
}
