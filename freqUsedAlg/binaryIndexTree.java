package freqUsedAlg;

public class binaryIndexTree {

	public static void main(String[] args) {
		int n = 1;
		int[] arr = new int[n];
		int[] bit = new int[n + 1];
		for(int i = 0; i < arr.length; i++) {
			add(bit, i + 1, arr[i]);
		}
	}

	//change value of element O(logN)
	static void add(int[] bit, int i, int val) {
		while(i < bit.length) {
			bit[i] += val;
			i += i & (-i);
		}
	}
	
	//query sum from 0-i O(logN)
	static int sum(int[] bit, int i) {
		int result = 0;
		while(i >= 1) {
			result += bit[i];
			i -= i & (-i);
		}
		return result;
	}
}
