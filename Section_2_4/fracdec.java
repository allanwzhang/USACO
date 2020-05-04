package Section_2_4;
/*
//ID: allanwz1
LANG: JAVA
TASK: fracdec
*/

import java.io.*;
//import java.util.Arrays;
//import java.util.*;

public class fracdec {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("fracdec.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
		 
		 String[] line = f.readLine().split(" ");
		 int num = Integer.parseInt(line[0]);
		 int denom = Integer.parseInt(line[1]);
		 
		 int wholeNum = 0;
		 int curr = num;
		 
		 if(num >= denom) {
			 wholeNum = (int) num / denom;
			 curr = num % denom;
		 }
		 
		 boolean[] visited = new boolean[denom];
		 
		 StringBuilder sb = new StringBuilder("");
		 
		 int j = 0;
		 int[] holder = new int[2000000];
		 
		 while(!visited[curr] && curr != 0) {
			 visited[curr]= true;
			 holder[j] = curr;
			 int hold = curr * 10 / denom;
			 sb.append(hold);
			 curr = (curr * 10) % denom;
			 j++;
		 }
		 
		 String fullDecimal = sb.toString();
		 
		 boolean terminating = false;
		 if(curr == 0) terminating = true;
		 
		 int index = 0;
		 
		 for(int i = 0; i < holder.length; i++) {
			 if(curr == holder[i]) {
				 index = i;
			 }
		 }
		 
		 String result = "";
		 
		 if(!terminating) result = wholeNum + "." + fullDecimal.substring(0, index) + "(" + fullDecimal.substring(index, fullDecimal.length()) + ")";
		 else if(fullDecimal.equals("")) result = wholeNum + ".0"; 
		 else result = wholeNum + "." + fullDecimal;
		 
//		 System.out.println(result);
		 
		 int count = 0;
		 
		 while(count + 76 < result.length()) {
			 out.println(result.substring(count, count + 76));
			 count += 76;
		 }
		 out.println(result.substring(count));
		 
		 out.close();
		 f.close();
	}

}
