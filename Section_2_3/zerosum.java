package Section_2_3;
/*
//ID: allanwz1
LANG: JAVA
TASK: zerosum
*/

import java.io.*;
import java.util.*;

public class zerosum {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		 
		 int num = Integer.parseInt(f.readLine());
		 
		 ArrayList<String> holder= new ArrayList<>();
		 
		 dfs(2, num, 1, "1", holder);
		 
		 Collections.sort(holder);
		 
		 for(String s : holder) {
			 System.out.println(s);
			 out.println(s);
		 }
		 
		 out.close();
		 f.close();
	}
	
	static void dfs(int curr, int goal, int sum, String seq, ArrayList<String> holder) {
		if(curr == goal + 1) {
			if(sum == 0) {
				holder.add(seq);
			}
			return;
		} else {
			dfs(curr + 1, goal, sum + curr, seq + "+" + curr, holder);
			dfs(curr + 1, goal, sum - curr, seq + "-" + curr, holder);
			if(seq.length() > 2 && seq.charAt(seq.length() - 2) == '+') {
				dfs(curr + 1, goal, sum + 10 * curr - 9, seq + " " + curr, holder);
			} else if(seq.length() > 2 && seq.charAt(seq.length() - 2) == '-') {
				dfs(curr + 1, goal, sum - 10 * curr + 9, seq + " " + curr, holder);
			}
			if(seq.length() == 1) {
				dfs(curr + 1, goal, sum + 11, seq + " " + curr, holder);
			}
		}
	}

}
