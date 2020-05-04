package USACO_SilverHW;
/*
//ID: allanwz1
LANG: JAVA
TASK: moocast
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class moocast {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		 
		 int numCows = Integer.parseInt(f.readLine());
		 
		 ArrayList<Cow> cows = new ArrayList<>();
		 
		 for(int i = 0; i < numCows; i++) {
			 String[] arr = f.readLine().split(" ");
			 cows.add(new Cow(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
		 }
		 
		 int max = 0;
		 
//		 for(Cow c : cows) {
//			 System.out.println(c.x + " " + c.y + " " + c.radius);
//		 }
		 
//		 HashSet<Cow> visited = new HashSet<>();
		 
		 for(int i = 0; i < cows.size(); i++) {
			 Cow temp = cows.get(i);
			 max = Math.max(max, dfs(temp, cows, new HashSet<Cow>()));
//			 if(visited.contains(temp)) continue;
//			 visited.add(temp);
//			 max = Math.max(max, dfs(temp, cows, visited));
		 }
		 
		 System.out.println(max);
		 out.println(max);
		 
		 out.close();
		 f.close();
	}

	static int dfs(Cow c, ArrayList<Cow> cows, HashSet<Cow> visited) {
		visited.add(c);
		int count = 1;
		for(Cow x : cows) {
			if(visited.contains(x)) continue;
			if(dist(c, x) <= (double) c.radius) {
				count += dfs(x, cows, visited);
			}
		}
		return count;
	}
	
	static double dist(Cow a, Cow b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
	
	static class Cow {
		int x, y;
		int radius;
		
		Cow(int xx, int yy, int r) {
			x = xx;
			y = yy;
			radius = r;
		}
		@Override    
		 public boolean equals(Object o) {        
		     if (this == o) return true;        
		     if (o == null || getClass() != o.getClass()) return false;        
		     Cow p = (Cow) o;        
		     if (x != p.x) return false;   
		     if (y != p.y) return false;
		     return radius == p.radius;    
		 }    
		 
		 @Override    
		 public int hashCode() {        
			 int hash = 7;
			 hash = 31 * hash + (int) x;
			 hash = 31 * hash + (int) y;
			 hash = 31 * hash + (int) radius;
			 return hash;  
		 }   
	}
	
}
