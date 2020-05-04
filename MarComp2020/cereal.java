package MarComp2020;
/*
//ID: allanwz1
LANG: JAVA
TASK: cereal
*/

import java.io.*;
import java.util.*;

public class cereal {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("cereal.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numCows = Integer.parseInt(arr[0]);
		 int numTypes = Integer.parseInt(arr[1]);
		 
		 Cow[] cows = new Cow[numCows];
		 
		 for(int i = 0; i < numCows; i++) {
			 String[] curr = f.readLine().split(" ");
			 cows[i] = new Cow(Integer.parseInt(curr[0]) - 1, Integer.parseInt(curr[1]) - 1);
		 }
		 
		 int[][] timeChoicesAval = new int[numCows][2];
		 int[][] whereCerealAre = new int[numTypes][2];
		 
		 for(int[] a : whereCerealAre) {
			 Arrays.fill(a, -1);
		 }
		 
		 for(int i = 0; i < numCows; i++) {
			 if(whereCerealAre[cows[i].f][0] == -1 && whereCerealAre[cows[i].f][1] == -1) {
				 timeChoicesAval[i][0] = 0;
				 timeChoicesAval[i][1] = -1;
				 whereCerealAre[cows[i].f][0] = i;
				 continue;
			 }

			 if(whereCerealAre[cows[i].f][0] == -1) {
				 timeChoicesAval[i][0] = timeChoicesAval[whereCerealAre[cows[i].f][1]][0];
				 whereCerealAre[cows[i].f][0] = i;
			 } else {
				 if(whereCerealAre[cows[i].f][1] == -1) {
					 timeChoicesAval[i][0] = whereCerealAre[cows[i].f][0] + 1;
					 whereCerealAre[cows[i].f][0] = i;
				 } else {
					 timeChoicesAval[i][0] = Math.max(whereCerealAre[cows[i].f][0] + 1, timeChoicesAval[whereCerealAre[cows[i].f][1]][0]);
					 whereCerealAre[cows[i].f][0] = i;
				 }
			 }
			 
			 if(whereCerealAre[cows[i].s][0] == -1 && whereCerealAre[cows[i].s][1] == -1) {
				 timeChoicesAval[i][1] = 0;
				 whereCerealAre[cows[i].s][1] = i;
			 } else {
				 if(whereCerealAre[cows[i].s][0] == -1) {
					 timeChoicesAval[i][1] = timeChoicesAval[whereCerealAre[cows[i].s][1]][0];
					 if(timeChoicesAval[i][1] < timeChoicesAval[i][0]) whereCerealAre[cows[i].s][1] = i;
				 } else {
					 if(whereCerealAre[cows[i].s][1] == -1) {
						 timeChoicesAval[i][1] = whereCerealAre[cows[i].s][0] + 1;
						  whereCerealAre[cows[i].s][1] = i;
					 } else {
						 timeChoicesAval[i][1] = Math.max(whereCerealAre[cows[i].s][0] + 1, timeChoicesAval[whereCerealAre[cows[i].s][1]][0]);
						 if(timeChoicesAval[i][1] < timeChoicesAval[i][0]) whereCerealAre[cows[i].s][1] = i;
					 }
				 }
			 }
			 
		 }
		 
		 int[] times = new int[numCows];
		 for(int i = 0; i < numCows; i++) {
			 if(timeChoicesAval[i][0] == -1) {
				 times[timeChoicesAval[i][1]]++;
			 } else if(timeChoicesAval[i][1] == -1) {
				 times[timeChoicesAval[i][0]]++;
			 } else {
				 times[Math.min(timeChoicesAval[i][0], timeChoicesAval[i][1])]++;
			 }
		 }
		 
		 int sum = 0;
		 for(int i = 0; i < numCows; i++) {
			 sum += times[i];
			 out.println(sum);
			 sum--;
		 }
		 
		 out.close();
		 f.close();
	}

	static class Cow {
		int f;
		int s;
		
		public Cow(int ff, int ss) {
			f = ff;
			s = ss;
		}
	}
}
