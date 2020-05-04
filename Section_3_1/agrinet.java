package Section_3_1;
/*
//ID: allanwz1
LANG: JAVA
TASK: agrinet
*/

import java.io.*;
import java.util.*;

public class agrinet {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("agrinet.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
	
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 
		 int numOfFields = Integer.parseInt(st.nextToken());
		 
		 int[][] dist = new int[numOfFields][numOfFields];
		 
		 for (int i = 0; i < dist.length; i++) {
				st = new StringTokenizer(f.readLine());
				for (int j = 0; j < dist.length; j++) {
					if (st.hasMoreTokens()) {
						dist[i][j] = Integer.parseInt(st.nextToken());
					} else {
						st = new StringTokenizer(f.readLine());
						dist[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}
		 
//		 for(int[] b : dist) {
//			 System.out.println(Arrays.toString(b));
//		 }
		 
		 boolean[][] connections = prims(dist);
		 
		 int sum = 0;
		 
		 for(int i = 0; i < connections.length; i++) {
			 for(int j = i + 1; j < connections.length; j++) {
				 if(connections[i][j]) {
					 sum += dist[i][j];
				 }
			 }
		 }
		 
		 System.out.println(sum);
		 out.println(sum);
		 
		 out.close();
		 f.close();
	}
	
	static boolean[][] prims(int[][] dist) {
		List<Integer> visited = new ArrayList<>();
		boolean[][] result = new boolean[dist.length][dist.length];
		
		visited.add(0);
		
		while(!containsAll(visited, dist.length)) {
			int min = Integer.MAX_VALUE;
			int connected = 0;
			int connectedTo = 0;
			
			for(int i : visited) {
				for(int j = 0; j < dist.length; j++) {
					if(dist[i][j] != 0 && dist[i][j] < min && !visited.contains(j)) {
//						System.out.println(min);
//						System.out.println(i + " "+ j);
						min = dist[i][j];
						connected = j;
						connectedTo = i;
					}
				}
			}
			
//			System.out.println("connected " + connected + " to: " + connectedTo);
//			System.out.println("add " + connected + " to visited");
			visited.add(connected);
			
			result[connected][connectedTo] = true;
			result[connectedTo][connected] = true;
		}
		
		return result;
	}
	
	static boolean containsAll(List<Integer> visited, int i) {
		for(int j = 0; j < i; j++) {
			if(!visited.contains(j)) return false;
		}
		return true;
	}
	
	static int[] toIntArray(String[] s) {
		int[] result = new int[s.length];
		for(int i = 0; i < s.length; i++) {
			result[i] = Integer.parseInt(s[i]);
		}
		return result;
	}
}
