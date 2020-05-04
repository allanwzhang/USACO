package Section_1_3;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: milk2
*/

public class milk2 {
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

		 int farmers = Integer.parseInt(f.readLine());
		 List<Interval> times = new ArrayList<>();
		 for(int i = 0; i < farmers; i++) {
			 String[] x = f.readLine().split(" ");
			 List<Integer> hold = new ArrayList<>();
			 for(String a : x) {
				 hold.add(Integer.parseInt(a));
			 }
			 times.add(new Interval(hold.get(0), hold.get(1)));
		 }
//		 System.out.println(times);
		 Collections.sort(times);
//		 System.out.println(times);
		 
		 Interval curr = times.get(0);
		 int milkMax = 0;
		 int gapMax = 0;
		 
		 for(int i = 1; i < times.size(); i++) {
			 if(curr.end >= times.get(i).start) {
				 curr = new Interval(curr.start, Math.max(curr.end, times.get(i).end));
			 } else {
				 milkMax = Math.max(curr.end - curr.start, milkMax);
				 gapMax = Math.max(gapMax, times.get(i).start - curr.end);
				 curr = times.get(i);
			 }
		 }
		 
		 milkMax = Math.max(curr.end - curr.start, milkMax);
		 
		 out.println(milkMax + " " + gapMax);
		 out.close();
		 f.close();
	}
	
	 public static class Interval implements Comparable<Interval> {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
		@Override
		public int compareTo(Interval other) {
			return Integer.compare(this.start, other.start);
		}
		@Override
		public String toString() {
			return start + " : " + end;
		}
	      
	    
	 }
}
