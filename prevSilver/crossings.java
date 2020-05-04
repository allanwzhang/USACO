package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: crossings
*/

import java.io.*;
import java.util.*;

public class crossings {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("crossings.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossings.out")));
	
		 int numLines = Integer.parseInt(f.readLine());
		 
		 Line[] lines = new Line[numLines];
		 
		 for(int i = 0; i < numLines; i++) {
			 String[] arr = f.readLine().split(" ");
			 lines[i] = new Line(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		 }
		 
		 Arrays.sort(lines);
		 
		 int max = lines[0].b;
		 
		 for(int i = 1; i < lines.length; i++) {
			 if(lines[i].b < max) lines[i].cross = true;
			 max = Math.max(max, lines[i].b);
		 }
		 
		 int min = lines[lines.length - 1].b;
		 
		 for(int i = lines.length - 2; i >= 0; i--) {
			 if(lines[i].b > min) lines[i].cross = true;
			 min = Math.min(min, lines[i].b);
		 }
		 
		 int count = 0;
		 
		 for(Line l : lines) {
			 if(!l.cross) count++;
		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}
	
	
	static class Line implements Comparable<Line> {
		int a, b;
		boolean cross = false;
		
		Line(int aa, int bb) {
			a = aa;
			b = bb;
		}

		@Override
		public int compareTo(Line l) {
			return a - l.a;
		}
	}
}