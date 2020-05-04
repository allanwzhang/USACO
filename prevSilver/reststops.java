package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: reststops
*/

import java.io.*;
import java.util.Arrays;

public class reststops {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("reststops.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numStops = Integer.parseInt(arr[1]);
		 long farmerSpeed = Long.parseLong(arr[2]);
		 long cowSpeed = Long.parseLong(arr[3]);
		 
		 Stop[] stops = new Stop[numStops + 1];
		 
		 stops[0] = new Stop(0, 0);
		 
		 for(int i = 1; i <= numStops; i++) {
			 String[] curr = f.readLine().split(" ");
			 stops[i] = new Stop(Integer.parseInt(curr[0]), Integer.parseInt(curr[1]));
		 }
		 
		 Arrays.sort(stops, (Stop a, Stop b) -> a.position - b.position);
		 
		 long count = 0;
		 int lastStop = 0;
		 while(lastStop < stops.length - 1) {
			 long max = 0;
			 int currIndex = -1;
			 for(int i = lastStop + 1; i < stops.length; i++) {
				 if(stops[i].taste > max) {
					 max = stops[i].taste;
					 currIndex = i;
				 }
			 }
			 count += ((farmerSpeed - cowSpeed) * (stops[currIndex].position - stops[lastStop].position)) * max;
			 lastStop = currIndex;
		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}

	static class Stop {
		int position, taste;
		
		Stop(int p, int t) {
			position = p;
			taste = t;
		}
	}
}
