package FebComp2018;
/*
//ID: allanwz1
LANG: JAVA
TASK: hoofball
*/

import java.io.*;
import java.util.*;

public class hoofball {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
	
		 int numCows = Integer.parseInt(f.readLine());
		 
		 String[] d = f.readLine().split(" ");
		 
		 int[] dist = new int[numCows];
		 
		 for(int i = 0; i < d.length; i++) {
			 dist[i] = Integer.parseInt(d[i]);
		 }
		 
		 Arrays.sort(dist);
	
		 ArrayList<Character> rlc = minimize(dist);
		 
		 removeExtra(rlc);
		 
		 for(Character c : rlc) {
			 System.out.println(c);
		 }
		 
		 int result = findBalls(rlc);
		 
		 System.out.println(result);
		 out.println(result);
		 
		 f.close();
		 out.close();
	}
	
	static void removeExtra(ArrayList<Character> rlc) {
		for(int i = 1; i < rlc.size(); i++) {
			if(rlc.get(i) == rlc.get(i - 1) && rlc.get(i) != 'c') {
				rlc.remove(i);
			}
		}
	}
	
	static ArrayList<Character> minimize(int[] dist) {
		ArrayList<Character> result = new ArrayList<>();
		
		result.add('r');
		
		for(int i = 1; i < dist.length - 1; i++) {
			if(left(i, dist)) {
				if(result.get(result.size() - 1) == 'l') {
					result.add('l');
				} else if (result.get(result.size() - 1) == 'r') {
					result.remove(result.size() - 1);
					result.add('c');
				} else {
					result.add('l');
				}
			} else {
				if(result.get(result.size() - 1) == 'l') {
					result.add('r');
				} else if (result.get(result.size() - 1) == 'r') {
					result.add('r');
				} else {
					result.add('r');
				}
			}
		}
		
		if(result.get(result.size() - 1) == 'r') {
			result.remove(result.size() - 1);
			result.add('c');
		} else {
			result.add('l');
		}
		
		return result;
	}
	
	static int findBalls(ArrayList<Character> rlc) {
		for(int i = 0; i < rlc.size(); i++) {
			if(rlc.get(i) == 'c') {
				if(i != 0 && rlc.get(i - 1) != 'c') {
					for(int j = i - 1; j >= 0; j--) {
						if(rlc.get(j) == 'c') break;
						rlc.remove(j);
					}
				} else {
					for(int j = i + 1; j < rlc.size(); j++) {
						if(rlc.get(j) == 'c') break;
						rlc.remove(j);
					}
				}
			}
		}
		
		return rlc.size();
	}
	
	static boolean left(int i, int[] dist) {
		if((dist[i] - dist[i - 1]) <= (dist[i + 1] - dist[i])) {
			return true;
		} else {
			return false;
		}
	}
}
