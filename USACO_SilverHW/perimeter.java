package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: perimeter
*/

import java.io.*;

public class perimeter {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
	
		 int numBales = Integer.parseInt(f.readLine());
		 
		 byte[][] bales = new byte[105][105];
		 
		 int minX = Integer.MAX_VALUE;
		 int minY = Integer.MAX_VALUE;
		 
		 for(int i = 0; i < numBales; i++) {
			 String[] arr = f.readLine().split(" ");
			 minX = Math.min(Integer.parseInt(arr[0]), minX);
			 minY = Math.min(Integer.parseInt(arr[1]), minY);
			 bales[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = 1;
		 }
		
//		 System.out.println(minX + " " + minY);
		 
		 byte[][] visited = new byte[105][105];
		 
		 int result = floodfill(bales, 0, 0, visited);
		 
		 System.out.println(result);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}
	
	static int floodfill(byte[][] arr, int x, int y, byte[][] visited) {
		if(x >= arr.length || x < 0 || y >= arr[0].length || y < 0 || visited[x][y] == 1) return 0;
		
		if(arr[x][y] == 1) return 1;
		
		visited[x][y] = 1;
		
		return floodfill(arr, x + 1, y, visited) + floodfill(arr, x, y + 1, visited) + floodfill(arr, x, y - 1, visited) + floodfill(arr, x - 1, y, visited);
//		return floodfill(arr, x + 1, y, visited, minX, minY) + floodfill(arr, x, y + 1, visited, minX, minY) + floodfill(arr, x, y - 1, visited, minX, minY) + floodfill(arr, x - 1, y, visited, minX, minY);
	}
}