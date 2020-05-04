package Pads;
/*
//ID: allanwz1
LANG: JAVA
TASK: subset
*/

import java.io.*;

public class Pad11 {
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("subset.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
	
		int num = Integer.parseInt(f.readLine());
		 
		if((num) * (num + 1) % 4 != 0) {
			out.println(0);
			System.out.println(0);
			out.close();
			f.close();
			return;
		}
		
		findAllCombos(num, 1, 0, new int[num]);
		
//		count /= 2;
		
//		System.out.println(count);
		out.println(count);
		
		out.close();
		f.close();
	}
	
	static int sumArray(int[] curr) {
		int total = 0;
		for(int j : curr) {
			total += j;
		}
		return total;
	}
	
	static void findAllCombos(int num, int i, int index, int[] curr) {
		if(sumArray(curr) > ((num) * (num + 1)) / 4) {
			return;
		} else if(sumArray(curr) == ((num) * (num + 1)) / 4){
			count++;
			return;
		} else {
			for(int j = i + 1; j <= num; j++) {
				curr[index] = j;
				int[] copy = new int[curr.length];
				for(int k = 0; k < copy.length; k++) {
					copy[k] = curr[k];
				}
				findAllCombos(num, j, index + 1, copy);
			}
		}
	}
	
}
