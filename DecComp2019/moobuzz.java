package DecComp2019;
/*
//ID: allanwz1
LANG: JAVA
TASK: moobuzz
*/

import java.io.*;

public class moobuzz {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("moobuzz.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
		 
		 int goal = Integer.parseInt(f.readLine());
		 long answer = 0;
		 int fifteen = goal / 8;
		 int remainder = goal % 8;
		 answer += fifteen * 15;
		 if(remainder == 1) answer += 1;
		 else if(remainder == 2) answer += 2;
		 else if(remainder == 3) answer += 4;
		 else if(remainder == 4) answer += 7;
		 else if(remainder == 5) answer += 8;
		 else if(remainder == 6) answer += 11;
		 else if(remainder == 7) answer += 13;
		 else if(remainder == 0) answer -= 1;
		 
		 System.out.println(answer);
		 out.println(answer);
		 
		 out.close();
		 f.close();
	}

}
