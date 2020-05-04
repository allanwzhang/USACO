package Section_1_4;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: barn1
*/

public class barn1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		
		String[] line = f.readLine().split(" ");
		int boards = Integer.parseInt(line[0]);
		int stallsNum = Integer.parseInt(line[1]);
		int cows = Integer.parseInt(line[2]);
		List<Integer> stalls = new ArrayList<>();
		
		for(int i = 0; i < cows; i++) {
			stalls.add(Integer.parseInt(f.readLine()));
		}
		Collections.sort(stalls);
		
		boolean[] hasBoards = new boolean[stallsNum + 1];
		
		for(int i = stalls.get(0); i <= stalls.get(stalls.size() - 1); i++) {
			hasBoards[i] = true;
		}
		
		for(int i = 1; i < boards; i++) {
			splitBoard2(stalls, hasBoards);
		}
		
		int count = 0;
		
		for(int i = 1; i < hasBoards.length; i++) {
			if(hasBoards[i]) {
				count++;
			}
		}
		
		out.println(count);
		
		out.close();
		f.close();
	}

	static void splitBoard(List<Integer> cows, boolean[] boards) {
		int start = 0;
		int end = 0;
		int max = 0;
		
		int start1 = 0;
		int end1 = 0;
		int max1 = 0;
		
		for(int i = 1; i < boards.length; i++) {
			if(boards[i]) {
				if(!cows.contains(i)) {
					max1++;
					end1 = i;
				} else {
					if(max1 > max) {
						start = start1;
						end = end1;
						max = max1;
					}
					max1 = 0;
					if(i != boards.length - 1) start1 = i + 1;
					end1 = 0;
				}
			}
		}
		
		for(int i = start; i <= end; i++) {
			boards[i] = false;
		}
	}

	static void splitBoard2(List<Integer> cows, boolean[] boards) {
		int start = 0;
		int maxGap = 0;
		int maxGapStart = 0;
		
		for(int i = 1; i < boards.length; i++) {
			if(boards[i]) {
				if(cows.contains(i)) {
					start = i;
				} else {
					if(i - start > maxGap) {
						maxGap = i - start;
						maxGapStart = start;
					}
				}
			}
		}
		
		for(int i = 0; i < maxGap; i++) {
			boards[i + maxGapStart + 1] = false;
		}
	}


}