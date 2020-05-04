package MarComp2020;
/*
//ID: allanwz1
LANG: JAVA
TASK: socdist
*/

import java.io.*;
import java.util.*;

public class socdist {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("socdist.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numCows = Integer.parseInt(arr[0]);
		 int numFields = Integer.parseInt(arr[1]);
		 
		 ArrayList<Pair> fields = new ArrayList<>();
		 for(int i = 0; i < numFields; i++) {
			 String[] curr = f.readLine().split(" ");
			 fields.add(new Pair(Long.parseLong(curr[0]), Long.parseLong(curr[1])));
		 }
		 
		 Collections.sort(fields);
		 
		 long result = binarySearch(1L, 1000000000000000000L, numCows, fields);
		 
		 System.out.println(result);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}

	static boolean works(long d, int numCows, ArrayList<Pair> fields) {
		int count = 0;
		long last = fields.get(0).start;
		int i = 0;
		while(i < fields.size()) {			
			Pair curr = fields.get(i);
			if(curr.end - last < d) {
				if(i == 0) count++;
				i++;
				continue;
			}
			if(curr.start - last > d || last == fields.get(0).start) {
				last = curr.start;
			} else {
				last = last + d;
			}

			for(long j = last; j <= curr.end; j += d) {
				last = j;
				count++;
			}
			i++;
			if(count >= numCows) {
				return true;
			}
		}
		return false;
	}
	
	static long binarySearch(long min, long max, int numCows, ArrayList<Pair> fields) {
		while(min <= max) {
			long mid = (min + max) / 2;

			if(works(mid, numCows, fields)) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return max;
	}
	
	static class Pair implements Comparable<Pair> {
		long start;
		long end;
		
		public Pair(long s, long e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Pair p) {
			return Long.compare(this.start, p.start);
		}
	}
}
