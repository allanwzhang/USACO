package freqUsedAlg;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class dijkstra {

	public static void main(String[] args) {
		int n = 10;
		int[][] connections = new int[n][n];
		int start = 0;
		int end = 9;
		dijk(connections, start, end);
	}

	static class Point {
		int value;
		int distance;
		Point(int v, int d) {
			value = v;
			distance = d;
		}
	}
	
	static public class PointComparator implements Comparator<Point> {
	    @Override
	    public int compare(Point x, Point y) {
	    	return x.distance - y.distance;
	    }
	    
	}
	
	static int dijk(int[][] connections, int start, int end) {
		Comparator<Point> comparator = new PointComparator();
		PriorityQueue<Point> pq = new PriorityQueue<>(10, comparator);
//		PriorityQueue<Farm> pq = new PriorityQueue<>(10, (Point a, Point b) -> a.dist - b.dist);
		
		HashSet<Integer> visited = new HashSet<>();
		
		pq.add(new Point(start, 0));
		
		while(pq.peek().value != end) {
			Point curr = pq.poll();
			visited.add(curr.value);
			if(visited.contains(curr.value)) continue;
			for(int i = 0; i < connections.length; i++) {
				if(connections[i][curr.value] != 0 && !visited.contains(i)) {
					pq.add(new Point(i, curr.distance + connections[i][curr.value]));
				}
			}
		}
		
		return pq.poll().value;
	}
	
}
