package Pads;
import java.util.ArrayList;
import java.util.List;

public class Pad4 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i < 7; i++) {
			numbers.add(i);
		}
		List<Integer> pairs = new ArrayList<>();
		allCombos(numbers, pairs);
	}
	
	static void allCombos(List<Integer> numbers, List<Integer> pairs) {
		if(numbers.size() <= 0){
			for(int i = 0; i < pairs.size(); i += 2) {
				System.out.println(pairs.get(i) + " : " + pairs.get(i + 1));
			}
			System.out.println("Done");
		} else {
			for(int i = 0; i < numbers.size(); i++) {
				for(int j = i + 1; j < numbers.size(); j++) {
					List<Integer> copy = new ArrayList<>(numbers);
					copy.remove(j);
					copy.remove(i);
					pairs.add(numbers.get(i));
					pairs.add(numbers.get(j));
					allCombos(copy, pairs);
					pairs.remove(pairs.size() - 1);
					pairs.remove(pairs.size() - 1);
				}
			}
		}
	}

}
