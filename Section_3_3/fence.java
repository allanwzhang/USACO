package Section_3_3;
/*
//ID: allanwz1
LANG: JAVA
TASK: fence
*/


import java.io.*;
import java.util.*;

public class fence {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("fence.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
		 
		 int numFences = Integer.parseInt(f.readLine());
		 
		 int[][] connection = new int[1025][1025];
		 int[] degree = new int[1025];
		 
		 for(int i = 0; i < numFences; i++) {
			 String[] line = f.readLine().split(" ");
			 connection[Integer.parseInt(line[0])][Integer.parseInt(line[1])]++;
			 connection[Integer.parseInt(line[1])][Integer.parseInt(line[0])]++;
			 degree[Integer.parseInt(line[0])]++;
			 degree[Integer.parseInt(line[1])]++;
		 }
		 
//		 System.out.println(Arrays.toString(degree));
		 
		 ArrayList<Integer> result = eularianTour(connection, degree, numFences);
		 
		 for(int i : result) {
//			 System.out.println(i);
			 out.println(i);
		 }
		 
		 out.close();
		 f.close();
	}
	
	static ArrayList<Integer> eularianTour(int[][] connection, int[] degree, int numFences) {
		ArrayList<Integer> result = new ArrayList<>();
	
		int curr = 0;
		int count = 0;
		
		
		for(int i = 0; i < degree.length; i++) {
			if(degree[i] % 2 == 1) {
				curr = i;
				break;
			}
		}
		
		if(curr == 0) {
			for(int i = 0; i < degree.length; i++) {
				if(degree[i] != 0) {
					curr = i;
					break;
				}
			}
		}
		
		result.add(curr);
		
		while(count < numFences) {
			int next = 0;
			for(int i = 1; i < connection.length; i++) {
				if(count == numFences - 1) {
					if(connection[curr][i] > 0) {
						next = i;
						break;
					}
				} else {
					if(connection[curr][i] > 0 && degree[i] != 1) {
						connection[curr][i]--;
						connection[i][curr]--;
						degree[i]--;
						degree[curr]--;
						next = i;
						break;
					}
				}
			}
			count++;
			result.add(next);
//			System.out.println("Added: " + next);
			curr = next;
		}
		
		return result;
	}
	
	static boolean allZero(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) return false;
		}
		return true;
	}
}
