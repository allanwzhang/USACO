package USACO_SilverHW;


import java.io.*;
import java.util.*;

public class lightson {

	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
	
		 String[] arr = f.readLine().split(" ");
		 int N = Integer.parseInt(arr[0]);
		 int M = Integer.parseInt(arr[1]);
		 
		 HashMap<Pair, ArrayList<Pair>> lights = new HashMap<>(); 
		 
		 for(int i = 0; i < M; i++) {
			 String[] array = f.readLine().split(" ");
			 Pair a = new Pair(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
			 Pair b = new Pair(Integer.parseInt(array[2]), Integer.parseInt(array[3]));
			 if(lights.containsKey(a)) {
				 lights.get(a).add(b);
			 } else {
				 ArrayList<Pair> temp = new ArrayList<>();
				 temp.add(b);
				 lights.put(a, temp);
			 }
		 }
		 
		 boolean[][] rooms = new boolean[N + 5][N + 5];
		 boolean[][] lit = new boolean[N + 5][N + 5];
		 lit[1][1] = true;
		 
		 floodfill(rooms, lit, lights, 1, 1);
		 
//		 for(boolean[] b : rooms) {
//			 System.out.println(Arrays.toString(b));
//		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}
	static void floodfill(boolean[][] visited, boolean[][] lit, HashMap<Pair, ArrayList<Pair>> map, int x, int y) {
		if(visited[x][y]) return;
		visited[x][y] = true;
		count++;
		Pair p = new Pair(x, y);
		if(map.containsKey(p)) {
			for(Pair o : map.get(p)) {
				lit[o.a][o.b] = true;
				if(hasNeighbor(visited, o.a, o.b)) {
					floodfill(visited, lit, map, o.a, o.b);
				}
			}
		}
		
		if(x > 0 && !visited[x - 1][y] && lit[x - 1][y]) {
			floodfill(visited, lit, map, x - 1, y);
		}
		if(x < visited.length - 1 && !visited[x + 1][y] && lit[x + 1][y]) {
			floodfill(visited, lit, map, x + 1, y);
		}
		if(y > 0 && !visited[x][y - 1] && lit[x][y - 1]) {
			floodfill(visited, lit, map, x, y - 1);
		}
		if(y < visited[0].length - 1 && !visited[x][y + 1] && lit[x][y + 1]) {		   
			floodfill(visited, lit, map, x, y + 1);
		}
	}
	
	static boolean hasNeighbor(boolean[][] visited, int x, int y) {
		if((x > 0 && visited[x - 1][y]) || (x < visited.length - 1 && visited[x + 1][y]) 
		|| (y > 0 && visited[x][y - 1]) || (y < visited[0].length - 1 && visited[x][y + 1])) return true;
		return false;
	}
	
	static class Pair {
		int a, b;

		Pair(int aa, int bb) {
			a = aa;
			b = bb;
		}
		
		 @Override    
		 public boolean equals(Object o) {        
		     if (this == o) return true;        
		     if (o == null || getClass() != o.getClass()) return false;        
		     Pair p = (Pair) o;        
		     if (a != p.a) return false;                        
		     return b == p.b;    
		 }    
		 
		 @Override    
		 public int hashCode() {        
			 int hash = 7;
			 hash = 31 * hash + (int) a;
			 hash = 31 * hash + (int) b;
			 return hash;  
		 }   
	}
}
