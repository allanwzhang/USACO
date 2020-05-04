package Section_3_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: msquare
*/

import java.io.*;
import java.util.*;

public class msquare {
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("msquare.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
	
		 int[] goal = toIntArray(f.readLine().split(" "));
		 int intGoal = toInt(goal);
		 
		 int[] stand = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		 
		 HashSet<Integer> visited = new HashSet<>();
		 
		 Deque<Square> dq = new ArrayDeque<>();
		 
		 dq.push(new Square(stand, ""));
		 
		 String result = "";
		 int moves = 0;
		 
		 while(dq.size() > 0) {
			Square curr = dq.removeLast();
			
			int intCurr = toInt(curr.order);
			if(visited.contains(intCurr)) continue;
			visited.add(intCurr);
			if(intCurr == intGoal) {
				result = curr.path;
				moves = curr.path.length();
				break;
			}
			dq.push(new Square(moveA(curr.order), curr.path + "A"));
			dq.push(new Square(moveB(curr.order), curr.path + "B"));
			dq.push(new Square(moveC(curr.order), curr.path + "C"));
		 }
//		 String answer = new StringBuilder(result).reverse().toString();
		 
		 System.out.println(moves);
		 System.out.println(result);
		 
		 out.println(moves);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}
	
	static int[] moveC(int[] i) {
//		int one = i[1];
//		int two = i[2];
//		int five = i[5];
//		int six = i[6];
//		i[1] = six;
//		i[2] = one;
//		i[5] = two;
//		i[6] = five;
		return new int[] {i[0], i[6], i[1], i[3], i[4], i[2], i[5], i[7]};
	}
	
	static int[] moveB(int[] i) {
//		int zero = i[0];
//		int one = i[1];
//		int two = i[2];
//		int three = i[3];
//		int four = i[4];
//		int five = i[5];
//		int six = i[6];
//		int sev = i[7];
//		i[0] = three;
//		i[1] = zero;
//		i[2] = one;
//		i[3] = two;
//		i[4] = five;
//		i[5] = six;
//		i[6] = sev;
//		i[7] = four;
		return new int[] {i[3], i[0], i[1], i[2], i[5], i[6], i[7], i[4]};
	}
	
	static int[] moveA(int[] i) {
//		int zero = i[0];
//		int one = i[1];
//		int two = i[2];
//		int three = i[3];
//		int four = i[4];
//		int five = i[5];
//		int six = i[6];
//		int sev = i[7];
//		i[0] = sev;
//		i[1] = six;
//		i[2] = five;
//		i[3] = four;
//		i[4] = three;
//		i[5] = two;
//		i[6] = one;
//		i[7] = zero;
		return new int[] {i[7], i[6], i[5], i[4], i[3], i[2], i[1], i[0]};
	}
	
	static int toInt(int[] curr) {
		int result = 0;
		for(int i = 0; i < curr.length; i++) {
			result *= 10;
			result += curr[i];
		}
		return result;
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
