package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: maxcross
*/

import java.io.*;

public class maxcross {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		 
		 String[] curr = f.readLine().split(" ");
		 int numSignals = Integer.parseInt(curr[0]);
		 int goalConsec = Integer.parseInt(curr[1]);
		 int numBroken = Integer.parseInt(curr[2]);
		 
		 boolean[] isBroken = new boolean[numSignals];
		 
		 for(int i = 0; i < numBroken; i++) {
			 isBroken[Integer.parseInt(f.readLine()) - 1] = true;
		 }
		 
		 int lastConsec = 0;
		 for(int i = 0; i < goalConsec; i++) {
			 if(isBroken[i]) lastConsec++;
		 }
		 
		 int min = lastConsec;
		 for(int i = goalConsec; i < isBroken.length; i++) {
			 int currConsec = lastConsec;
			 if(isBroken[i - goalConsec]) currConsec--;
			 if(isBroken[i]) currConsec++;
			 min = Math.min(currConsec, min);
			 lastConsec = currConsec;
		 }
		 
		 System.out.println(min);
		 out.println(min);
		 
		 out.close();
		 f.close();
	}

}
