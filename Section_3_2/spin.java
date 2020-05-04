package Section_3_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: spin
*/

import java.io.*;
import java.util.*;

public class spin {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("spin.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));
	
		 ArrayList<Wheel> holder = new ArrayList<>();
		 
		 while(f.ready()) {
			 holder.add(new Wheel(f.readLine().split(" ")));
		 }
		 
		 int count = 0;
		 
		 while(count < 360) {
			 if(isHoleTotal(count, holder)) {
				 break;
			 }
//			 System.out.println();
			 count++;
		 }
		 
		 if(count == 360) {
			 System.out.println("none");
			 out.println("none");
			 
			 out.close();
			 f.close();
			 return;
		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}
	
	static boolean isHoleTotal(int time, ArrayList<Wheel> holder) {
		for(int i = 0; i < 360; i++) {
			if(isHole(time, holder, i)) return true;
		}
		return false;
	}
	
	static boolean isHole(int time, ArrayList<Wheel> holder, int i) {
		for(Wheel w : holder) {
			if(!w.open[(i - time * w.speed + 360000000) % 360]) {
//				System.out.println(i + " " + w.speed + " " + Math.abs(i - time * w.speed) % 360);
				return false;
			}
		}
		return true;
	}
	
	static class Wheel {
		int speed;
		boolean[] open = new boolean[360];
		
		Wheel(String[] s) {
			speed = Integer.parseInt(s[0]);
			int num = Integer.parseInt(s[1]);
			for(int i = 1; i <= num; i++) {
				int start = Integer.parseInt(s[2 * i]);
				int len = Integer.parseInt(s[2 * i + 1]);
				for(int j = start; j <= start + len; j++) {
					
					open[j % 360] = true;
				}
			}
		}
	}
}
