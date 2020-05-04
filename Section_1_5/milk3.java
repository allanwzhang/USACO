package Section_1_5;
import java.io.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: milk3
*/

public class milk3 {
	static int[][] past = new int[21][21];
	static int[] result = new int[21];
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		
		String[] line = f.readLine().split(" ");
		int[] buckets = new int[3];
		
		for(int i = 0; i < 3; i++) {
			buckets[i] = Integer.parseInt(line[i]);
		}
		
		findAllCombos(new Bucket(buckets[0], buckets[1], buckets[2]), 0, 0, buckets[2]);
		
		int count = 0;
		
		for(int i = 0; i < 21; i++) {
			if(result[i] == 1) {
				System.out.println(i);
				if(count == 0) {
					out.print(i);
					count++;
				} else {
					out.print(" " + i);
				}
			}
		}
		out.println();
		
		out.close();
		f.close();
	}
	
	static void findAllCombos(Bucket bucket, int a, int b, int c) {
		if(a == 0) {
			result[c] = 1;
		}
		if (past[a][b] == 1) {
			System.out.println("loop");
			return;
		}
		int newA = a;
		int newB = b;
		int newC = c;		
		past[a][b] = 1;
		if(a != 0 && b < bucket.totalB) {
			if(a + b > bucket.totalB) {
				newA = b + a - bucket.totalB;
				newB = bucket.totalB;
			} else {
				newB = a + b;
				newA = 0;
			}
			newC = c;
			System.out.println("a -> b: (" + newA + ", " + newB + ", " + newC + ")");
			findAllCombos(bucket, newA, newB, newC);
		}

		if(a != 0 && c < bucket.totalC) {
			System.out.println("a -> c: (" + newA + ", " + newB + ", " + newC + ")");
			if(a + c > bucket.totalC) {
				newA = c + a - bucket.totalC;
				newC = bucket.totalC;
			} else {
				newC = a + c;
				newA = 0;
			}
			newB = b;
			System.out.println("a -> c: (" + newA + ", " + newB + ", " + newC + ")");
			findAllCombos(bucket, newA, newB, newC);
		}
		
		if(b != 0 && a < bucket.totalA) {	
			if(b + a > bucket.totalA) {
					newB = a + b - bucket.totalA;
					newA = bucket.totalA;
				} else {
					newA = b + a;
					newB = 0;
				}
				newC = c;
			System.out.println("a -> b: (" + newA + ", " + newB + ", " + newC + ")");
				findAllCombos(bucket, newA, newB, newC);
		}
		
		if(b != 0 && c < bucket.totalC) {	
			if(b + c > bucket.totalC) {
					newB = c + b - bucket.totalC;
					newC = bucket.totalC;
				} else {
					newC = b + c;
					newB = 0;
				}
				newA = a;
			System.out.println("a -> b: (" + newA + ", " + newB + ", " + newC + ")");
				findAllCombos(bucket, newA, newB, newC);
		} 
		
		if(c != 0 && b < bucket.totalB) {
				if(c + b > bucket.totalB) {
					newC = c + b - bucket.totalB;
					newB = bucket.totalB;
				} else {
					newB = c + b;
					newC = 0;
				}
				newA = a;
				System.out.println("a -> b: (" + newA + ", " + newB + ", " + newC + ")");
				findAllCombos(bucket, newA, newB, newC);
		} 
		
		if(c != 0 && a < bucket.totalA) {	
			if(c + a > bucket.totalA) {
					newC = a + c - bucket.totalA;
					newA = bucket.totalA;
				} else {
					newA = c + a;
					newC = 0;
				}
				newB = b;
			System.out.println("a -> b: (" + newA + ", " + newB + ", " + newC + ")");
				findAllCombos(bucket, newA, newB, newC);
		} 
			
	}
	
	static class Bucket {
		int totalA, totalB, totalC;
		
		Bucket(int totalAA, int totalBB, int totalCC) {
			totalA = totalAA;
			totalB = totalBB;
			totalC = totalCC;
		}	
	}

}
