package Pads;
import java.io.*;
import java.util.*;

public class Pad5 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
int num = Integer.parseInt(f.readLine());
		
		Map<Integer, int[]> wormHoles = new HashMap<>();
		
		for(int i = 1; i <= num; i++) {
			String[] a = f.readLine().split(" ");
			int[] ar = new int[] { Integer.parseInt(a[0]), Integer.parseInt(a[1]) };
			wormHoles.put(i, ar);
		}
		
		Map<int[], int[]> wormHoleCon = new HashMap<>();
		
		getAllRight(wormHoles, wormHoleCon);
		
//		for(int[] x : wormHoleCon.keySet()) {
//			if(x != null) {
//				int[] a = wormHoleCon.get(x);
//				if(a != null) System.out.println(x[0] + " " + x[1] + " : " + a[0] + " " + a[1]);
//				
//			}
//		}
		
		List<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < num; i++) numbers.add(i);
		
		List<Integer> pairs = new ArrayList<>();
		int result = combo(numbers, pairs, wormHoleCon, wormHoles);
		out.println(result / 2);
		System.out.println(result);
	
		out.close();
		f.close();
	}
	
static void getAllRight(Map<Integer, int[]> wormHoles, Map<int[], int[]> connections) {
		
		List<String> yx = new ArrayList<>();
		for(int i = 1; i <= wormHoles.size(); i++) {
			yx.add(wormHoles.get(i)[1] + "" + wormHoles.get(i)[0]);
		}
		
		Collections.sort(yx);
		
		for(int i = 0; i < yx.size() - 1; i++) {
			if(yx.get(i).charAt(0) == yx.get(i + 1).charAt(0)) {
				int[] a = new int[] {Integer.parseInt(yx.get(i).charAt(1) + ""), Integer.parseInt(yx.get(i).charAt(0) + "")};
				int[] b = new int[] {Integer.parseInt(yx.get(i + 1).charAt(1) + ""), Integer.parseInt(yx.get(i + 1).charAt(0) + "")};
				connections.put(a, b);
			}
		}
	}
	
	static int combo(List<Integer> numbers, List<Integer> pairs, Map<int[], int[]> connections, Map<Integer, int[]> wormHoles) {
		if(numbers.size() <= 0){
			if(checkIfLoop(pairs, connections, wormHoles)) {
				return 1;
			}
			return 0;
		} else {
			int count = 0;
			for(int i = 0; i < numbers.size(); i++) {
				for(int j = i + 1; j < numbers.size(); j++) {
					List<Integer> copy = new ArrayList<>(numbers);
					copy.remove(j);
					copy.remove(i);
					pairs.add(numbers.get(i));
					pairs.add(numbers.get(j));
					count += combo(copy, pairs, connections, wormHoles);
					pairs.remove(pairs.size() - 1);
					pairs.remove(pairs.size() - 1);
				}
			}
			return count;
		}
	}
	
	static boolean checkIfLoop(List<Integer> pairs, Map<int[], int[]> connections, Map<Integer, int[]> wormHoles) {
		Map<int[], int[]> connectionsCopy = new HashMap<int[], int[]>();
		for(int[] x : connections.keySet()) {
			connectionsCopy.put(x, connections.get(x));
		}
		
		for(int i = 0; i < pairs.size(); i += 2) {
			if(!connectionsCopy.containsKey(wormHoles.get(pairs.get(i)))) connectionsCopy.put(wormHoles.get(pairs.get(i)), wormHoles.get(pairs.get(i + 1)));
			if(!connectionsCopy.containsKey(wormHoles.get(pairs.get(i + 1)))) connectionsCopy.put(wormHoles.get(pairs.get(i + 1)), wormHoles.get(pairs.get(i)));
		}
		
		for(int i = 0; i < wormHoles.size(); i++) {
			if(!connectionsCopy.containsKey(wormHoles.get(i))) {
				System.out.println("put in");
				connectionsCopy.put(wormHoles.get(i), null);
			}
		}

		return loop(connectionsCopy, wormHoles.size() + 1, wormHoles.get(1));
	}
	
	static boolean loop(Map<int[], int[]> connections, int holes, int[] firstHole) {
		
		for(int[] x : connections.keySet()) {
			if(x != null) {
				int[] a = connections.get(x);
				if(a != null) System.out.println(x[0] + " " + x[1] + " : " + a[0] + " " + a[1]);
			}
		}
		
		int[] counter = firstHole;
		for(int i = 0; i < holes; i++) {
			if(counter == null) {
				System.out.println("false :(");
				return false;
			} else {
				counter = connections.get(counter);
			}
		}
		System.out.println("true :)");
		return true;
	}
}
