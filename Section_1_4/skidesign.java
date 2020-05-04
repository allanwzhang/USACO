package Section_1_4;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: skidesign
*/

public class skidesign {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
	
		int hillNum = Integer.parseInt(f.readLine());
		int[] hillHeights = new int[hillNum];
		
		for(int i = 0; i < hillNum; i++) {
			hillHeights[i] = Integer.parseInt(f.readLine());
		}
		
		Arrays.sort(hillHeights);
		
		out.println(changeHeight(hillHeights));
			
		out.close();
		f.close();
	}
	
	static int changeHeight(int[] hillHeights) {
		int[] hillHeights1 = new int[hillHeights.length];
		
		for(int i = 0; i < hillHeights.length; i++) {
			hillHeights1[i] = hillHeights[i];
		}
		
		while(hillHeights1[hillHeights1.length - 1] - hillHeights1[0] > 17) {
			if(hillHeights1[hillHeights1.length - 1] - hillHeights1[0] == 18) {
				move1(hillHeights1, hillHeights);
			} else {
				move2(hillHeights, hillHeights1);
			}
		}
		
		int count = 0;
		
		for(int i = 0; i < hillHeights.length; i++) {
			count += Math.abs(hillHeights1[i] - hillHeights[i]) * Math.abs(hillHeights1[i] - hillHeights[i]);
		}
		
		return count;
	}
	
	static void move1(int[] hillHeights1, int[] hillHeights) {
		int count1 = 0;
		for(int i = hillHeights1.length - 1; i >= 0; i--) {
			if(hillHeights1[i] == hillHeights1[hillHeights1.length - 1]) {
				count1 += 2 * (Math.abs(hillHeights[i] - hillHeights1[i])) + 1;
			} else {
				break;
			}
		}
		
		int count2 = 0;
		for(int i = 0; i < hillHeights1.length; i++) {
			if(hillHeights1[i] == hillHeights1[0]) {
				count2 += 2 * (Math.abs(hillHeights1[i] - hillHeights[i])) + 1;
			} else {
				break;
			}
		}
		
		if(count1 > count2) {
			for(int i = 1; i < hillHeights1.length; i++) {
				if(hillHeights1[i] == hillHeights1[0]) {
					hillHeights1[i]++;
				} else {
					break;
				}
			}
			hillHeights1[0]++;
		} else {
			for(int i = hillHeights1.length - 2; i >= 0; i--) {
				if(hillHeights1[i] == hillHeights1[hillHeights1.length - 1]) {
					hillHeights1[i]--;
				} else {
					break;
				}
			}
			hillHeights1[hillHeights1.length - 1]--;
		}
	}
	
	static void move2(int[] hillHeights, int[] hillHeights1) {
		int count1 = 0;
		for(int i = hillHeights1.length - 1; i >= 0; i--) {
			if(hillHeights1[i] == hillHeights1[hillHeights1.length - 1]) {
				count1 += 4 * (Math.abs(hillHeights[i] - hillHeights1[i])) + 4;
			} else if(hillHeights1[i] == hillHeights1[hillHeights1.length - 1] - 1){
				count1 += 2 * (Math.abs(hillHeights[i] - hillHeights1[i])) + 1;
			} else {
				break;
			}
		}
		
		int count2 = 0;
		for(int i = 0; i < hillHeights1.length; i++) {
			if(hillHeights1[i] == hillHeights1[0]) {
				count2 += 4 * (Math.abs(hillHeights1[i] - hillHeights[i])) + 4;
			} else if(hillHeights1[i] == hillHeights1[0] + 1){
				count2 += 2 * (Math.abs(hillHeights1[i] - hillHeights[i])) + 1;
			} else {
				break;
			}
		}
		
		int count3 = 0;
		for(int i = 0; i < hillHeights1.length; i++) {
			if(hillHeights1[i] == hillHeights1[0]) {
				count3 += 2 * (Math.abs(hillHeights1[i] - hillHeights[i])) + 1;
			} else {
				break;
			}
		}
		for(int i = hillHeights1.length - 1; i >= 0; i--) {
			if(hillHeights1[i] == hillHeights1[hillHeights1.length - 1]) {
				count3 += 2 * (Math.abs(hillHeights[i] - hillHeights1[i])) + 1;
			} else {
				break;
			}
		}
		
		if(count1 < count2 && count1 < count3) {
			for(int i = hillHeights1.length - 2; i >= 0; i--) {
				if(hillHeights1[i] == hillHeights1[hillHeights1.length - 1]) {
					hillHeights1[i]--;
				} else {
					break;
				}
			}
			hillHeights1[hillHeights1.length - 1]--;
			
			for(int i = hillHeights1.length - 2; i >= 0; i--) {
				if(hillHeights1[i] == hillHeights1[hillHeights1.length - 1]) {
					hillHeights1[i]--;
				} else {
					break;
				}
			}
			hillHeights1[hillHeights1.length - 1]--;
		} else if(count2 < count1 && count2 < count3) {
			for(int i = 1; i < hillHeights1.length; i++) {
				if(hillHeights1[i] == hillHeights1[0]) {
					hillHeights1[i]++;
				} else {
					break;
				}
			}
			hillHeights1[0]++;
			
			for(int i = 1; i < hillHeights1.length; i++) {
				if(hillHeights1[i] == hillHeights1[0]) {
					hillHeights1[i]++;
				} else {
					break;
				}
			}
			hillHeights1[0]++;
		} else {
			for(int i = hillHeights1.length - 2; i >= 0; i--) {
				if(hillHeights1[i] == hillHeights1[hillHeights1.length - 1]) {
					hillHeights1[i]--;
				} else {
					break;
				}
			}
			hillHeights1[hillHeights1.length - 1]--;
			
			for(int i = 1; i < hillHeights1.length; i++) {
				if(hillHeights1[i] == hillHeights1[0]) {
					hillHeights1[i]++;
				} else {
					break;
				}
			}
			hillHeights1[0]++;
		}
	}
}