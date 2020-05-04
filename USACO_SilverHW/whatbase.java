package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: whatbase
*/

import java.io.*;

public class whatbase {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("whatbase.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whatbase.out")));
		 
		 int cases = Integer.parseInt(f.readLine());
		 
		 for(int i = 0; i < cases; i++) {
			 String[] arr = f.readLine().split(" ");
			 int x = Integer.parseInt(arr[0]);
			 int y = Integer.parseInt(arr[1]);
			 int xBase = 10;
			 int yBase = 10;
			 int xCurr = base(x, xBase);
			 int yCurr = base(y, yBase);
//			 System.out.println(x + " " + xBase + " " + xCurr);
			 while(xCurr != yCurr) {
				 if(xCurr > yCurr) {
					 yBase++;
					 yCurr = base(y, yBase);
				 } else {
					 xBase++;
					 xCurr = base(x, xBase);
				 }
			 }
			 
			 System.out.println(xBase + " " + yBase);
			 out.println(xBase + " " + yBase);
		 }
		 
		 out.close();
		 f.close();
	}
	
	static int base(int x, int base) {
		int result = 0;
		int count = 0;
		while(x > 0) {
			result += (x % 10) * Math.pow(base, count);
			count++;
			x = x/10;
		}
		return result;
	}
}
