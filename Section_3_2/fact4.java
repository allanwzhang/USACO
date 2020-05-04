package Section_3_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: fact4
*/

import java.io.*;

public class fact4 {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("fact4.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
	
		 int fact = Integer.parseInt(f.readLine());
		 
		 int lastFourDigit = 1;
		 
		 for(int i = 2; i <= fact; i++) {
			 int curr = i;
			 while(curr % 5 == 0) {
				 lastFourDigit /= 2;
				 curr = curr / 5;
			 }
			 lastFourDigit = (lastFourDigit * curr) % 10000;
		 }
		 
		 System.out.println(lastFourDigit % 10);
		 out.println(lastFourDigit % 10);
		 
		 out.close();
		 f.close();
	}

}
