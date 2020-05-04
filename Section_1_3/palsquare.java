package Section_1_3;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: palsquare
*/

public class palsquare {
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		 int base = Integer.parseInt(f.readLine());
		 
		 for(int i = 1; i < 300; i++) {
			 if(isPali(convertBase(i * i, base))) {
				 out.println(toInt(convertBase(i, base)) + " " + toInt(convertBase(i * i, base)));
			 }
		 }
		 
		 out.close();
		 f.close();
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
	
	static boolean isPali(List<Integer> number) {
		for(int i = 0; i < number.size(); i++) {
			if(number.get(i) != number.get(number.size() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	static String toInt(List<Integer> number) {
		String result = "";
		for(int i = 0; i < number.size(); i++) {
			if(number.get(i) < 10) {
				result = result + number.get(i);
			} else {
				result = result + (char)(number.get(i) + 55);
			}
		}
		return result;
	}
}