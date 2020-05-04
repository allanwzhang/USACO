package Section_2_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: preface
*/

import java.io.*;

public class preface {

	static int numI = 0;
	static int numV = 0;
	static int numX = 0;
	static int numL = 0;
	static int numC = 0;
	static int numD = 0;
	static int numM = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("preface.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
	
		int num = Integer.parseInt(f.readLine());
		
		for(int i = 1; i <= num; i++) {
			findRomanNum(i);
		}
		
		if(numI != 0) {
			System.out.println("I " + numI);
			out.println("I " + numI);
		}
		if(numV != 0) {
			System.out.println("V " + numV);
			out.println("V " + numV);
		}
		if(numX != 0) {
			System.out.println("X " + numX);
			out.println("X " + numX);
		}
		if(numL != 0) {
			System.out.println("L " + numL);
			out.println("L " + numL);
		}
		if(numC != 0) {
			System.out.println("C " + numC);
			out.println("C " + numC);
		}
		if(numD != 0) {
			System.out.println("D " + numD);
			out.println("D " + numD);
		}
		if(numM != 0) {
			System.out.println("M " + numM);
			out.println("M " + numM);
		}
		
		out.close();
		f.close();
	}
	
	static void findRomanNum(int i) {
		thousandDigit((int)(i / 1000));
		hundredDigit((int)((i % 1000) / 100));
		tenDigit((int)((i % 100) / 10));
		unitDigit((int)(i % 10));
		return;
	}
	
	static void unitDigit(int i) {
		if(i == 1) numI++;
		if(i == 2) numI += 2;
		if(i == 3) numI += 3;
		if(i == 4) {
			numI += 1;
			numV += 1;
		}
		if(i == 5) numV += 1;
		if(i == 6) {
			numV += 1;
			numI += 1;
		}
		if(i == 7) {
			numV++;
			numI += 2;
		}
		if(i == 8) {
			numV++;
			numI += 3;
		}
		if(i == 9) {
			numI++;
			numX++;
		}
		return;
	}
	
	static void tenDigit(int i) {
		if(i == 1) numX++;
		if(i == 2) numX += 2;
		if(i == 3) numX += 3;
		if(i == 4) {
			numX += 1;
			numL += 1;
		}
		if(i == 5) numL += 1;
		if(i == 6) {
			numL += 1;
			numX += 1;
		}
		if(i == 7) {
			numL++;
			numX += 2;
		}
		if(i == 8) {
			numL++;
			numX += 3;
		}
		if(i == 9) {
			numX++;
			numC++;
		}
		return;
	}
	
	static void hundredDigit(int i) {
		if(i == 1) numC++;
		if(i == 2) numC += 2;
		if(i == 3) numC += 3;
		if(i == 4) {
			numC += 1;
			numD += 1;
		}
		if(i == 5) numD += 1;
		if(i == 6) {
			numD += 1;
			numC += 1;
		}
		if(i == 7) {
			numD++;
			numC += 2;
		}
		if(i == 8) {
			numD++;
			numC += 3;
		}
		if(i == 9) {
			numC++;
			numM++;
		}
		return;
	}
	
	static void thousandDigit(int i) {
		if(i == 1) numM++;
		if(i == 2) numM += 2;
		if(i == 3) numM += 3;
		return;
	}
		 
}
