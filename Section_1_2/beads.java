package Section_1_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: beads
*/

import java.io.*;

public class beads {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		 f.readLine();

		 String input = f.readLine();
		 int ret = beams(input);
		 out.println(ret);
		 f.close();
		 out.close();
	}
	
    public static int beams(String input) {
        String s = input+input;
        int redLeft[] =new int[s.length()+2];
        int blueLeft[] =new int[s.length()+2];
        int redRight[] =new int[s.length()+2];
        int blueRight[] =new int[s.length()+2];


        int curMax = 0;

        for (int i = 0;i<s.length();i++) {
            char curChar = s.charAt(i);
            if (curChar == 'r') {
                redLeft[i+1] = redLeft[i] +1;
                blueLeft[i+1]=0;
            }

            if (curChar == 'b' ) {
                blueLeft[i+1] = blueLeft[i] +1;
                redLeft[i+1]=0;
            }
            if (curChar == 'w' ) {
                blueLeft[i+1] = blueLeft[i] +1;
                redLeft[i+1] = redLeft[i] +1;
            }
        }

        for (int i = s.length()-1;i>=0;i--) {
            char curChar = s.charAt(i);
            if (curChar == 'r') {
                redRight[i+1] = redRight[i+2] +1;
                blueRight[i+1]=0;
            }

            if (curChar == 'b' ) {
                blueRight[i+1] = blueRight[i+2] +1;
                redRight[i+1]=0;
            }
            if (curChar == 'w' ) {
                blueRight[i+1] = blueRight[i+2] +1;
                redRight[i+1] = redRight[i+2] +1;
            }
        }
        for (int i = 1; i<=s.length();i++) {
            if (s.charAt(i-1) =='w') continue;
            curMax = Math.max(curMax, blueRight[i] + redLeft[i-1]);
            curMax = Math.max(curMax, blueLeft[i-1] + redRight[i]);
        }
        // all white....
        if (curMax == 0) {
            curMax = input.length();
        }
        return Math.min(input.length(), curMax);
    }

}
