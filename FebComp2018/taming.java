package FebComp2018;



import java.io.*;

public class taming {
	static boolean fail = false;
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("taming.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
	
		 int days = Integer.parseInt(f.readLine());
		 
		 String[] s = f.readLine().split(" ");
		 
		 int[] breakout = new int[days];
		 
		 for(int i = 0; i < s.length; i++) {
			 breakout[i] = Integer.parseInt(s[i]);
		 }
		 
		 breakout[0] = 0;
		 
//		 for(int i : breakout) {
//			 System.out.println(i);
//		 }
		 
		 findBreakouts(breakout);
		 
		 if(fail) {
			 System.out.println(-1);
			 out.println(-1);
			 
			 f.close();
			 out.close();
			 return;
		 }
		 
		 int count = 0;
		 int breaks = 0;
		 
		 for(int i : breakout) {
			 if(i == 0) count++;
			 if(i == -1) breaks++;
//			 System.out.println(i);
		 }
		 
		 System.out.println(count + " " + (count + breaks));
		 out.println(count + " " + (count + breaks));
		 
		 f.close();
		 out.close();
	}
	
	static void findBreakouts(int[] breakout) {
		for(int i = 0; i < breakout.length; i++) {
			if(breakout[i] > 0) {
				fillIn(breakout, i, breakout[i]);
			}
		}
	}
	
	static void fillIn(int[] breakout, int index, int num) {
		int count = 1;
		while(count <= num) {
			if(breakout[index - count] > (num - count)) {
				fail = true;
				break;
			}
			breakout[index - count] = num - count;
			count++;
		}
	}
}
