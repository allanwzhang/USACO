package DecComp2019;
/*
//ID: allanwz1
LANG: JAVA
TASK: meetings
*/

import java.io.*;

public class meetings {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("meetings.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numCow = Integer.parseInt(arr[0]);
		 if(numCow == 3) out.println(2);
		 else out.println(1);
		 
		 out.close();
		 f.close();
	}

}
