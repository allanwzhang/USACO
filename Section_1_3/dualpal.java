package Section_1_3;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: dualpal
*/

public class dualpal {
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		 
		 String[] num = f.readLine().split(" ");
		 int numberOfNumbers = Integer.parseInt(num[0]);
		 int startingNumber = Integer.parseInt(num[1]);
		 
		 int count = 0;
		 List<Integer> solutions = new ArrayList<>();
		 
		 for(int i = startingNumber + 1; count < numberOfNumbers; i++) {
			 if(dualpali(i)) {
				 count++;
				 solutions.add(i);
			 }
		 }
		 
		 for(int i = 0; i < solutions.size(); i++) {
			 out.println(solutions.get(i));
		 }
		 
		 out.close();
		 f.close();
		 
	}
	
	static boolean dualpali(int num) {
		int count = 0;
		for(int i = 2; i <= 10; i++) {
			if(isPali(convertBase(num, i))) {
				count++;
			}
		}
		if(count >= 2) return true;
		return false;
	}
	
	static boolean isPali(List<Integer> number) {
		for(int i = 0; i < number.size(); i++) {
			if(number.get(i) != number.get(number.size() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	static List<Integer> convertBase(int number, int base) {
		List<Integer> a = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		
		while(number > 0) {
			int mod = number % base;
			a.add(mod);
			number = (number - mod) / base;
		}
		
		for(int i = 0; i < a.size(); i++) {
			result.add(a.get(a.size() - 1 - i));
		}
		return result;
	}
}
