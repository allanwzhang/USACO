package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: perimeter
*/


import java.io.*;
import java.util.*;

public class perimeter {
	
	static boolean[][] visited = new boolean[1001][1001];
	static TreeMap<Integer, Integer> AP = new TreeMap<>();
	static int area = 0;
	static int peri = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		 
		 int rows = Integer.parseInt(f.readLine());
		 char[][] map = new char[rows][rows];
		 for(int i = 0; i < map.length; i++) {
			 map[i] = f.readLine().toCharArray();
		 }
		 
		 for(int i = 0; i < map.length; i++) {
			 for(int j = 0; j < map[0].length; j++) {
				 if(!visited[i][j] && map[i][j] == '#') {
					 ff(map, i, j);
					 AP.put(area, peri);
					 area = 0;
					 peri = 0;
				 }
			 }
		 }
		 
		 System.out.println(AP.lastKey() + " " + AP.get(AP.lastKey()));
		 out.println(AP.lastKey() + " " + AP.get(AP.lastKey()));
		 
		 f.close();
		 out.close();
	}
	
	static void ff(char[][] array, int r, int c) {
		 if(r < 0 || r >= array.length || c < 0 || c >= array[0].length || array[r][c] == '.') {
			 peri++;
			 return;
		 }
	     if(visited[r][c]) {
	    	return; 
	     }
	     area++;
	     visited[r][c] = true;
	     ff(array, r+1, c);
    	 ff(array, r-1, c);
    	 ff(array, r, c + 1);
    	 ff(array, r, c - 1);
	  }
	
}
