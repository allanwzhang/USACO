package Section_1_4;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: wormhole
*/

public class wormhole {
	
	static class Point implements Comparable<Point> {
		int x, y;
		Point next;
		
		Point(int xx, int yy) {
			x = xx;
			y = yy;
		}

		@Override
		public int compareTo(Point p) {
			if(p.y < this.y) {
				return 1;
			} else if(p.y == this.y) {
				return this.x - p.x;
			} else {
				return -1;
			}
		}
		
	}
	
	static class Pair {
		int p1, p2;
		
		Pair(int p1, int p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		
		int num = Integer.parseInt(f.readLine());
		
		List<Point> wormHoles = new ArrayList<>();
		
		for(int i = 0; i < num; i++) {
			String[] a = f.readLine().split(" ");
			wormHoles.add(new Point(Integer.parseInt(a[0]), Integer.parseInt(a[1])));
		}
		
		getAllRight(wormHoles);
		
		List<Pair> pairs = new ArrayList<>();
		Set<Integer> used = new HashSet<>();
		
		int result = allCombos(num, pairs, used, wormHoles);
		
		System.out.println(result);
		out.println(result);
		
		
		f.close();
		out.close();
	}
	
	static void getAllRight(List<Point> wormHoles) {
		Collections.sort(wormHoles);
		
		for(int i = 0; i < wormHoles.size() - 1; i++) {
			if(wormHoles.get(i).y == wormHoles.get(i + 1).y) {
				wormHoles.get(i).next = wormHoles.get(i + 1);
			}
		}
	}
	
	static int allCombos(int n, List<Pair> pairs, Set<Integer> used, List<Point> wormHoles) {
		if(used.size() == n){
//			System.out.println(pairs.size());
			if(createCon(pairs, wormHoles)) {
				return 1;
			}
			return 0;
		} else {
			int count = 0;
			int i = 0;
			for(int k = 0; k < n; k++) {
				if(!used.contains(k)) {
					i = k;
					break;
				}
			}
			for(int j = i + 1; j < n; j++) {
				if(used.contains(i) || used.contains(j)) {
					continue;
				}
				pairs.add(new Pair(i, j));
				used.add(i);
				used.add(j);
				count += allCombos(n, pairs, used, wormHoles);
				pairs.remove(pairs.size() - 1);
				used.remove(i);
				used.remove(j);
			}
			return count;
		}
	}
	
	static boolean createCon(List<Pair> pairs, List<Point> wormHoles) {
		Map<Point, Point> connections = new HashMap<>();
		
		for(int i = 0; i < pairs.size(); i++) {
			connections.put(wormHoles.get(pairs.get(i).p1), wormHoles.get(pairs.get(i).p2));
			connections.put(wormHoles.get(pairs.get(i).p2), wormHoles.get(pairs.get(i).p1));
		}
		
//		for(Point p : connections.keySet()) {
//			System.out.println(p.x + " " + p.y + " : " + connections.get(p).x + " " + connections.get(p).y);
//		}
		
		Set<Point> visited = new HashSet<>();
		
		for(int i = 0; i < wormHoles.size(); i++) {
//			System.out.println("Start WormHole is " + i);
			Point curr = wormHoles.get(i);
			while(curr != null) {
				curr = curr.next;
				if(visited.contains(curr)) {
//					System.out.println("true");
					return true;
				}
				visited.add(curr);
				if(curr != null) {
					curr = connections.get(curr);
				}
			}
			visited.clear();
		}
//		System.out.println("false");
		return false;
	}
}
