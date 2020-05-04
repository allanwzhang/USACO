package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: hps
*/

import java.io.*;

public class hps {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("hps.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		 
		 int numGames = Integer.parseInt(f.readLine());
		 
		 char[] moves = new char[numGames];
		 
		 int numP = 0;
		 int numH = 0;
		 int numS = 0;
		 
		 for(int i = 0; i < moves.length; i++) {
			 char curr = f.readLine().charAt(0);
			 if(curr == 'P') numP++;
			 if(curr == 'H') numH++;
			 if(curr == 'S') numS++;
			 moves[i] = curr;
		 }
		 
		 int[] numPL = new int[numGames];
		 int[] numHL = new int[numGames];
		 int[] numSL = new int[numGames];
		 int[] numPR = new int[numGames];
		 int[] numHR = new int[numGames];
		 int[] numSR = new int[numGames];
		 
		 numPR[0] = numP;
		 numHR[0] = numH;
		 numSR[0] = numS;
		 
		 int max = Math.max(Math.max(numP, numH), numS);
		 
		 for(int i = 1; i < numPL.length; i++) {
			 char curr = moves[i - 1];
			 if(curr == 'P') {
				 numPL[i] = numPL[i - 1] + 1;
				 numPR[i] = numPR[i - 1] - 1;
				 numHL[i] = numHL[i - 1];
				 numHR[i] = numHR[i - 1];
				 numSL[i] = numSL[i - 1];
				 numSR[i] = numSR[i - 1];
			 } else if(curr == 'H') {
				 numPL[i] = numPL[i - 1];
				 numPR[i] = numPR[i - 1];
				 numHL[i] = numHL[i - 1] + 1;
				 numHR[i] = numHR[i - 1] - 1;
				 numSL[i] = numSL[i - 1];
				 numSR[i] = numSR[i - 1];
			 } else if(curr == 'S'){
				 numPL[i] = numPL[i - 1];
				 numPR[i] = numPR[i - 1];
				 numHL[i] = numHL[i - 1];
				 numHR[i] = numHR[i - 1];
				 numSL[i] = numSL[i - 1] + 1;
				 numSR[i] = numSR[i - 1] - 1;
			 }
			 max = Math.max(max, Math.max(Math.max(numPL[i], numHL[i]), numSL[i]) + Math.max(Math.max(numPR[i], numHR[i]), numSR[i]));
		 }
		 
		 System.out.println(max);
		 out.println(max);
		 
		 out.close();
		 f.close();
	}

}
