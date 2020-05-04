package Section_1_6;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: pprime
*/

public class pprime {
	static List<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
	
		String[] r = f.readLine().split(" ");
		int[] range = new int[] {Integer.parseInt(r[0]), Integer.parseInt(r[1])};
		
		int minNumDigits = r[0].length();
		int maxNumDigits = r[1].length();
		
		findPali(minNumDigits, maxNumDigits, range[0], range[1]);
		
		for(int i : result) {
			System.out.println(i);
			out.println(i);
		}
		
		out.close();
		f.close();
	}
	
	static void findPali(int minDigits, int maxDigits, int min, int max) {
		System.out.println(minDigits + " " + maxDigits + " " + min + " " + max);
		for(int i = minDigits; i <= maxDigits; i++) {
			digitPali(i, min, max);
		}
	}

	static void digitPali(int digits, int min, int max) {
//		System.out.println(digits + "-digit number");
		if(digits == 1) {
			for(int i = 1; i < 9; i++) {
				if(i >= min && i <= max && isPali(i)) {
//					System.out.println(i);
					result.add(i);
				}
			}
		} else if(digits == 2) {
			for(int i = 1; i <= 9; i += 2) {
				int pali = 11 * i;
				if(pali >= min && pali <= max && isPali(pali)) {
					result.add(pali);
				}
			}
		} else if(digits == 3) {
			for(int i = 1; i <= 9; i += 2) {
				for(int j = 0; j <= 9; j++) {
					int pali = 101 * i + 10 * j;
					if(pali >= min && pali <= max && isPali(pali)) {
						result.add(pali);
					}
				}
			}
		} else if(digits == 4) {
			for(int i = 1; i <= 9; i += 2) {
				for(int j = 0; j <= 9; j++) {
					int pali = 1001 * i + 110 * j;
					if(pali >= min && pali <= max && isPali(pali)) {
						result.add(pali);
					}
				}
			}
		} else if (digits == 5) {
			for(int i = 1; i <= 9; i += 2) {
				for(int j = 0; j <= 9; j++) {
					for(int k = 0; k <= 9; k++) {
						int pali = 10001 * i + 1010 * j + 100 * k;
						if(pali >= min && pali <= max && isPali(pali)) {
							result.add(pali);
						}
					}
				}
			}
		} else if (digits == 6) {
			for(int i = 1; i <= 9; i += 2) {
				for(int j = 0; j <= 9; j++) {
					for(int k = 0; k <= 9; k++) {
						int pali = 100001 * i + 10010 * j + 1100 * k;
						if(pali >= min && pali <= max && isPali(pali)) {
							result.add(pali);
						}
					}
				}
			}
		} else if(digits == 7) {
			for(int i = 1; i <= 9; i += 2) {
				for(int j = 0; j <= 9; j++) {
					for(int k = 0; k <= 9; k++) {
						for(int m = 0; m <= 9; m++) {
							int pali = 1000001 * i + 100010 * j + 10100 * k + 1000 * m;
							if(pali >= min && pali <= max && isPali(pali)) {
								result.add(pali);
							}
						}
					}
				}
			}
		} else {
			for(int i = 1; i <= 9; i += 2) {
				for(int j = 0; j <= 9; j++) {
					for(int k = 0; k <= 9; k++) {
						for(int m = 0; m <= 9; m++) {
							int pali = 10000001 * i + 1000010 * j + 100100 * k + 1100 * m;
							if(pali >= min && pali <= max && isPali(pali)) {
								result.add(pali);
							}
						}
					}
				}
			}
		}
	}
	
	static boolean isPali(int num) {
		if(num == 2) return true;
		if(num % 2 == 0) return false;
		for(int i = 3; i <= Math.sqrt(num); i += 2) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
