package Pads;
import java.util.ArrayList;

public class Pad9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void findAllCombos(int num, int i, int index, int[] curr, ArrayList<int[]> allPoss) {
		if(index == curr.length) {
			allPoss.add(curr);
			return;
		} else {
			for(int j = i + 1; j <= num; j++) {
				curr[index] = j;
				int[] copy = new int[curr.length];
				for(int k = 0; k < copy.length; k++) {
					copy[k] = curr[k];
				}
				findAllCombos(num, j, index + 1, copy, allPoss);
			}
		}
	}
}
