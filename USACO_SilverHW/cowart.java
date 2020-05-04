package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: cowart
*/

import java.io.*;

public class cowart {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("cowart.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowart.out")));
		 
		 int size = Integer.parseInt(f.readLine());
		 
		 char[][] graph = new char[size][size];
		 
		 for(int i = 0; i < size; i++) {
			 graph[i] = f.readLine().toCharArray();
		 }
		 
		 boolean[][] visitedH = new boolean[size][size];
		 int countH = 0;
		 
		 for(int x = 0; x < graph.length; x++) {
			 for(int y = 0; y < graph[0].length; y++) {
				 if(!visitedH[x][y]) {
					 floodfillH(graph[x][y], graph, x, y, visitedH);
					 countH++;
				 }
			 }
		 }
		 
		 boolean[][] visitedC = new boolean[size][size];
		 int countC = 0;
		 
		 for(int x = 0; x < graph.length; x++) {
			 for(int y = 0; y < graph[0].length; y++) {
				 if(!visitedC[x][y]) {
					 floodfillC(graph[x][y], graph, x, y, visitedC);
//					 System.out.println(x + " " + y);
					 countC++;
				 }
			 }
		 }
		 
		 System.out.println(countH + " " + countC);
		 out.println(countH + " " + countC);
		 
		 out.close();
		 f.close();
	}
	
	static void floodfillH(char c, char[][] arr, int x, int y, boolean[][] visited) {
		if(x >= arr.length || x < 0 || y >= arr[0].length || y < 0 || arr[x][y] != c || visited[x][y]) return;
		
		visited[x][y] = true;
		
		floodfillH(c, arr, x + 1, y, visited);
		floodfillH(c, arr, x, y + 1, visited);
		floodfillH(c, arr, x - 1, y, visited);
		floodfillH(c, arr, x, y - 1, visited);
	}
	
	static void floodfillC(char c, char[][] arr, int x, int y, boolean[][] visited) {
		if(x >= arr.length || x < 0 || y >= arr[0].length || y < 0 || visited[x][y]) return;
		if(c == 'B' && arr[x][y] != 'B') return;
		if(c == 'G' && arr[x][y] == 'B') return;
		if(c == 'R' && arr[x][y] == 'B') return;
		
		visited[x][y] = true;
		
		floodfillC(c, arr, x + 1, y, visited);
		floodfillC(c, arr, x, y + 1, visited);
		floodfillC(c, arr, x - 1, y, visited);
		floodfillC(c, arr, x, y - 1, visited);
	}
	
}
