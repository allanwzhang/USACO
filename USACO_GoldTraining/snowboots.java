package USACO_GoldTraining;


import java.io.*;

public class snowboots {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
	
		 int numBoots = Integer.parseInt(f.readLine().split(" ")[1]);
		 
		 int[] depths = toIntArray(f.readLine().split(" "));
		 int[] bootDepth = new int[numBoots];
		 int[] bootDist = new int[numBoots];
		 
		 for(int i = 0; i < numBoots; i++) {
			 String[] arr = f.readLine().split(" ");
			 bootDepth[i] = Integer.parseInt(arr[0]);
			 bootDist[i] = Integer.parseInt(arr[1]);
		 }
		 
		 boolean[][] possible = new boolean[depths.length][numBoots];
		 
		 for(int i = 0; i < numBoots; i++) {
			 possible[0][i] = true;
		 }
		 
		 for(int i = 1; i < possible.length; i++) {
			 boolean canChange = false;
			 for(int j = 0; j < numBoots; j++) {
				 if(bootDepth[j] >= depths[i]) {
					 for(int k = Math.max(0, i - bootDist[j]); k < i; k++) {
						 if(possible[k][j]) {
							 possible[i][j] = true;
						 }
					 }
					 if(j != 0 && canChange) possible[i][j] = true;
					 if(possible[i][j]) canChange = true;
				 }
			 }
		 }
		 
		 int answer = -1;
		 
		 for(int i = 0; i < numBoots; i++) {
			 if(possible[depths.length - 1][i]) {
				 answer = i;
				 break;
			 }
		 }
		 
		 System.out.println(answer);
		 out.println(answer);
		 
		 out.close();
		 f.close();
	}
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
		
		return result;
	}
}
