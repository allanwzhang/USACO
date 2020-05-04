package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: highcard
*/

import java.io.*;
import java.util.*;

public class highcard {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("highcard.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		 
		 int n = Integer.parseInt(f.readLine());
		 
		 int[] elsie = new int[n];
		 for(int i = 0; i < elsie.length; i++) {
			 elsie[i] = Integer.parseInt(f.readLine()) * -1;
		 }
		 
		 Arrays.sort(elsie);
		 for(int i = 0; i < elsie.length; i++) {
			 elsie[i] *= -1;
		 }
		 
		 int[] bessie = new int[n];
		 int ei = 0;
		 int bi = 0;
		 for(int i = 2 * n; i > 0; i--) {
			 if(ei == elsie.length) break;
			 if(elsie[ei] == i) {
				 ei++;
			 } else {
				 bessie[bi] = i;
				 bi++;
			 }
		 }
		 
		 int currb = 0;
		 int curre = 0;
		 int count = 0;
		 
		 while(curre < elsie.length && currb < bessie.length) {
			 if(bessie[currb] > elsie[curre]) {
				 count++;
				 currb++;
			 }
			 curre++;
		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}

}
