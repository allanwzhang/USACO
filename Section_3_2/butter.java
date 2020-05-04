package Section_3_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: butter
*/

import java.io.*;
import java.util.*;

public class butter {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("butter.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("butter.out")));
	
		 StringTokenizer st = new StringTokenizer(f.readLine());
		 
		 int cows = Integer.parseInt(st.nextToken());
		 int pasture = Integer.parseInt(st.nextToken());
		 
		 HashMap<Integer, Integer> withCow = new HashMap<>();
		 
		 for(int i = 0; i < cows; i++) {
			 int hold = Integer.parseInt(f.readLine());
			 withCow.put(hold, withCow.getOrDefault(hold, 0) + 1);
		 }
		 
		 ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		 
		 for(int i = 0; i <= pasture; i++) {
			 adj.add(new ArrayList<Integer>());
		 }
		 
		 int[][] paths = new int[pasture + 1][pasture + 1];
		 
		 while(f.ready()) {
			 StringTokenizer str = new StringTokenizer(f.readLine());
			 int a = Integer.parseInt(str.nextToken());
			 int b = Integer.parseInt(str.nextToken());
			 int len = Integer.parseInt(str.nextToken());
			 paths[a][b] = len;
			 paths[b][a] = len;
			 adj.get(a).add(b);
			 adj.get(b).add(a);
		 }
		 
		 int min = Integer.MAX_VALUE;
		 
//		 System.out.println(System.currentTimeMillis());
		 
		 for(int i = 1; i <= pasture; i++) {
			min = dijkstra(paths, adj, i, withCow, cows, min);
		 }

//		 System.out.println(System.currentTimeMillis());
		 
		 System.out.println(min);
		 out.println(min);
		 
		 out.close();
		 f.close();
	}
	
	static int dijkstra(int[][] paths, ArrayList<ArrayList<Integer>> adj, int i, HashMap<Integer, Integer> withCow, int numCows, int currMin) {		
		int result = 0;
		
		PastureComparator pc = new PastureComparator();
		PriorityQueue<Pasture> pq = new PriorityQueue<>(500, pc);
		pq.add(new Pasture(i, 0));
		
		HashSet<Integer> visited = new HashSet<>();
		int count = 0;
		
		while(count < numCows) {
			Pasture p = pq.poll();
			
			if(visited.contains(p.index)) {
				continue;
			}
			
			paths[p.index][i] = Math.min(paths[p.index][i], p.dist);
			paths[i][p.index] = paths[p.index][i];
			
			if(withCow.containsKey(p.index)) {
				int num = withCow.get(p.index);
				count += num;
				result += p.dist * num;
				if(result > currMin) return currMin;
			}
			
			visited.add(p.index);
			
			for(int j : adj.get(p.index)) {	
				if(!visited.contains(j)) {
					pq.add(new Pasture(j, p.dist + paths[p.index][j]));
				}
			}
		}
		
		return result;
	}
	
	static class PastureComparator implements Comparator<Pasture> {

		@Override
		public int compare(Pasture a, Pasture b) {
			return a.dist - b.dist;
		}
		
	}
	
	static class Pasture {
		Integer index;
		int dist;
		
		Pasture(int i, int d) {
			index = i;
			dist = d;
		}
	}
}
