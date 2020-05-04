package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: countcross
*/

import java.io.*;
import java.util.ArrayList;

public class countcross {
	
	static ArrayList<Integer> regions = new ArrayList<>();
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("countcross.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int gridSize = Integer.parseInt(arr[0]);
		 int numCows = Integer.parseInt(arr[1]);
		 int numRoads = Integer.parseInt(arr[2]);
		 
		 boolean[][] cows = new boolean[gridSize][gridSize];
		 boolean[][][][] roads = new boolean[gridSize][gridSize][gridSize][gridSize];
		 
		 for(int i = 0; i < numRoads; i++) {
			 String[] curr = f.readLine().split(" ");
			 roads[Integer.parseInt(curr[0]) - 1][Integer.parseInt(curr[1]) - 1][Integer.parseInt(curr[2]) - 1][Integer.parseInt(curr[3]) - 1] = true;
		 }
		 
		 for(int i = 0; i < numCows; i++) {
			 String[] curr = f.readLine().split(" ");
			 cows[Integer.parseInt(curr[0]) - 1][Integer.parseInt(curr[1]) - 1] = true;
		 }
		 
		 boolean[][] visited = new boolean[gridSize][gridSize];
		 
		 for(int i = 0; i < cows.length; i++) {
			 for(int j = 0; j < cows.length; j++) {
				 if(visited[i][j]) continue;
				 floodfill(i, j, cows, roads, visited);
				 if(count != 0) regions.add(count);
				 count = 0;
			 }
		 }
		 
		 int answer = 0;
		 while(regions.size() > 1) {
			 int curr = regions.remove(0);
			 for(int i = 0; i < regions.size(); i++) {
				 answer += curr * regions.get(i);
			 }
		 }
		 
		 System.out.println(answer);
		 out.println(answer);
		 
		 out.close();
		 f.close();
	}

	static void floodfill(int i, int j, boolean[][] cows, boolean[][][][] roads, boolean[][] visited) {
		if(i < 0 || i >= cows.length || j < 0 || j >= cows.length || visited[i][j]) return;
		if(cows[i][j]) count++;
		visited[i][j] = true;
		if(i < roads.length - 1 && !roads[i][j][i + 1][j] && !roads[i + 1][j][i][j]) floodfill(i + 1, j, cows, roads, visited);
		if(j < roads.length - 1 && !roads[i][j][i][j + 1] && !roads[i][j + 1][i][j]) floodfill(i, j + 1, cows, roads, visited);
		if(i > 0 && !roads[i][j][i - 1][j] && !roads[i - 1][j][i][j]) floodfill(i - 1, j, cows, roads, visited);
		if(j > 0 && !roads[i][j][i][j - 1] && !roads[i][j - 1][i][j]) floodfill(i, j - 1, cows, roads, visited);
	}
	
}
