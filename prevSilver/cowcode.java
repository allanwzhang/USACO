package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: cowcode
*/

import java.io.*;

public class cowcode {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 long goal = Long.parseLong(arr[1]) - 1;
		 
		 char[] code = arr[0].toCharArray();
		 
		 char result = findChar(goal, code);
		 
		 System.out.println(result);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}
	
	static char findChar(long goal, char[] code) {
		if(goal < code.length) return code[(int) goal];
		long length = code.length;
		while(length * 2 <= goal) {
			length *= 2;
		}
		if(length == goal) return findChar(goal - 1, code);
		return findChar(goal - length - 1, code);
	}

}
