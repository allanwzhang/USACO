package Section_1_6;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: sprime
*/

public class sprime {
	static Deque<Integer> sprime = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
	
		int length = Integer.parseInt(f.readLine());
		
		sprime.push(2);
		sprime.push(3);
		sprime.push(5);
		sprime.push(7);
		
		findAllSprime(length);
		
		List<Integer> result = new ArrayList<>();
		
		while(!sprime.isEmpty()) {
			result.add(sprime.remove());
		}
		
		Collections.sort(result);
		
		for(int i : result) {
			System.out.println(i);
			out.println(i);
		}
		
		out.close();
		f.close();
	}
	
	static void findAllSprime(int length) {
		System.out.println(length);
		int count = 1;
		while(count < length) {
			findSprime(count);
			count++;
		}
	}
	
	static void findSprime(int length) {
		while(sprime.peek().toString().length() == length) {
			int prime = sprime.remove();
			for(int i = 1; i <= 9; i += 2) {
				if(i != 5) {
					int newPrime = 10 * prime + i;
					if(isPrime(newPrime)) {
						sprime.addLast(newPrime);
					}
				}
			}
		}
	}
	
	static boolean isPrime(int num) {
		if(num % 2 == 0) return false;
		for(int i = 3; i <= Math.sqrt(num); i += 2) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
