package Section_1_4;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: crypt1
*/

public class crypt1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
	
		int numberOfPoss = Integer.parseInt(f.readLine());
		List<Integer> numbers = new ArrayList<>();
		
		String[] split = f.readLine().split(" ");
		for(int i = 0; i < numberOfPoss; i++) {
			numbers.add(Integer.parseInt(split[i]));
		}

		Collections.sort(numbers);
		
		int count = 0;
		
		List<Integer> possibleA = possibleA(numbers);
		for(int a = 0; a < possibleA.size(); a++) {
			for(int b = 0; b < numbers.size(); b++) {
				for(int c = 0; c < numbers.size(); c++) {
					for(int d = 0; d < possibleD(numbers, a).size(); d++) {
						for(int e = 0; e < numbers.size(); e++) {
							if(isCrypt(possibleA.get(a), numbers.get(b), numbers.get(c), possibleD(numbers, a).get(d), numbers.get(e), numbers)) count++;
						}
					}
				}
			}
		}
		
		out.println(count);
		
		out.close();
		f.close();
	}
	
	static List<Integer> possibleA(List<Integer> numbers) {
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < numbers.size(); i++) {
			if(numbers.get(i) * numbers.get(0) < 10) {
				result.add(numbers.get(i));
			} else {
				break;
			}
		}
		
		return result;
	}
	
	static List<Integer> possibleD(List<Integer> numbers, int a) {
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < numbers.size(); i++) {
			if(numbers.get(i) * a < 10) {
				result.add(numbers.get(i));
			} else {
				break;
			}
		}
		
		return result;
	}
	
	static boolean isCrypt(int a, int b, int c, int d, int e, List<Integer> numbers) {
		int top = 100 * a + 10 * b + c;
		int bot = 10 * d + e;
		
		return lineIsCrypt(top * d, numbers, 3) && lineIsCrypt(top * e, numbers, 3) && lineIsCrypt(top * bot, numbers, 4);
	}
	
	static boolean lineIsCrypt(int number, List<Integer> listNumbers, int length) {
		String line = number + "";
		if(line.length() > length) return false;
		for(int i = 0; i< line.length(); i++) {
			String c = line.charAt(i) + "";
			if(!listNumbers.contains(Integer.parseInt(c))) {
				return false;
			}
		}
		return true;
	}
}