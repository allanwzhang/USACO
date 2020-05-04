package Pads;

/*
//ID: allanwz1
LANG: JAVA
TASK: msquare
*/

import java.io.*;
import java.util.*;

public class Pad17 {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("msquare.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
	
		 int[] goal = toIntArray(f.readLine().split(" "));
		 
		 int[] stand = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		 
		 ArrayList<Integer> visited = new ArrayList<>();
		 
		 SquareComparator sc = new SquareComparator();
		 PriorityQueue<Square> pq = new PriorityQueue<Square>(10, sc);
		 
		 pq.add(new Square(goal, ""));
		 
		 String result = "";
		 int moves = 0;
		 
		 while(pq.size() > 0) {
			 Square curr = pq.poll();
			 if(pq.size() == 10000000) System.out.println(curr.path);
			 if(visited.contains(toInt(curr.order))) {
				 continue;
			 }
			 if(Arrays.equals(curr.order, stand)) {
				 result = curr.path;
				 moves = curr.path.length();
				 break;
			 }
			 pq.add(new Square(moveC(curr.order), curr.path + "C"));
			 pq.add(new Square(moveB(curr.order), curr.path + "B"));
			 pq.add(new Square(moveA(curr.order), curr.path + "A")); 
		 }
		 
		 String answer = new StringBuilder(result).reverse().toString();
		 
		 System.out.println(moves);
		 System.out.println(answer);
		 
		 out.println(moves);
		 out.println(answer);
		 
		 out.close();
		 f.close();
	}
	
	static int[] moveC(int[] i) {
		return new int[] {i[0], i[2], i[5], i[3], i[4], i[6], i[1], i[7]};
	}
	
	static int[] moveB(int[] i) {
		return new int[] {i[1], i[2], i[3], i[0], i[7], i[4], i[5], i[6]};
	}
	
	static int[] moveA(int[] i) {
		return new int[] {i[7], i[6], i[5], i[4], i[3], i[2], i[1], i[0]};
	}
	
	static int toInt(int[] curr) {
		int result = 0;
		for(int i = 0; i < curr.length; i++) {
			result += curr[i] * Math.pow(10, 7 - i);
		}
		return result;
	}
	
	static class SquareComparator implements Comparator<Square> {

		@Override
		public int compare(Square a, Square b) {
			if(a.path.length() != b.path.length()) return a.path.length() - b.path.length();
			for(int i = a.path.length() - 1; i >= 0; i--) {
				if(a.path.charAt(i) == b.path.charAt(i)) continue;
//				System.out.println(a.path + " " + b.path + " " + (b.path.charAt(i) - a.path.charAt(i)));
				return a.path.charAt(i) - b.path.charAt(i);
			}
			return 0;
		}
		
	}
	
	static class Square {
		int[] order;
		String path;
		
		Square(int[] o, String p) {
			order = o;
			path = p;
		}
	}
	
	static int[] toIntArray(String[] s) {
		int[] result = new int[s.length];
		for(int i = 0; i < s.length; i++) {
			result[i] = Integer.parseInt(s[i]);
		}
		return result;
	}
}
