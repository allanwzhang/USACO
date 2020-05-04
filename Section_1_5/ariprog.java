package Section_1_5;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: ariprog
*/

public class ariprog {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		
		int length = Integer.parseInt(f.readLine());
		int bisquareLim = Integer.parseInt(f.readLine());		
		
		Set<Integer> bisquares = new HashSet<>();
		
		for(int i = 0; i <= bisquareLim; i++) {
			for(int j = i; j <= bisquareLim; j++) {
				bisquares.add(j * j + i * i);
			}
		}
		
//		int[][] bToAArray = new int[bisquareLim * bisquareLim * 2][bisquareLim * bisquareLim * 2];
		List<Sequence> sequences = new ArrayList<>();
		
		int count = 0;
		
		Iterator<Integer> itr = bisquares.iterator();
		while(itr.hasNext()) {
			int start = itr.next();
			int largestB = largestB(start, length, bisquareLim);
			for(int i = 1; i <= largestB; i++) {
//				System.out.println(start + " " + i);
				if(isSequence(start, i, bisquares, length)) {
					count++;
					Sequence s = new Sequence(start, i);
					sequences.add(s);
//					bToAArray[i][start] = 1;
//					System.out.println(start + " " + i + " worked");
				}
			}
		}
		
		if(count == 0) {
			out.println("NONE");
			out.close();
			f.close();
			return;
		}
		
		Collections.sort(sequences);
		
//		for(int i = 0; i < bToAArray.length; i++) {
//			for(int j = 0; j < bToAArray.length; j++) {
//				if(bToAArray[i][j] == 1) {
//					out.println(j + " " + i);
//					System.out.println(j + " " + i + " worked");
//				}
//			}
//		}
		
		for(Sequence s : sequences) {
			System.out.println(s.a + " " + s.b + " worked");
			out.println(s.a + " " + s.b);
		}
		
		f.close();
		out.close();
	}

	static int largestB(int start, int length, int biLimit) {
		int largest = biLimit * biLimit * 2;
		int result = (largest - start) / (length - 1);
		return result;
	}
	
	static boolean isSequence(int start, int diff, Set<Integer> bisquares, int length) {
		int count = 1;
		
		while(count < length) {
			start += diff;
//			if(diff == 12) System.out.println("start is: " + start);
			if(!bisquares.contains(start)) {
//				if(diff == 12) System.out.println("test case false");
				return false;
			}
			count++;
		}
		return true;
	}
	
	static class Sequence implements Comparable<Sequence> {
		int a;
		int b;
		
		Sequence(int aa, int bb) {
			a = aa;
			b = bb;
		}
		
		@Override
		public int compareTo(Sequence s) {
			if(s.b == this.b) {
				return this.a - s.a;
			}
			return this.b - s.b;
		}
		
	}
	
}
