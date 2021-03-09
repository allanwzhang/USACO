package freqUsedAlg;

public class binarySearching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int result = binarySearch(0, 100000000);
		System.out.println(result);
	}
	
	static int binarySearch(int min, int max) {
		while(min <= max) {
			int mid = (min + max) / 2;
			if(works(mid)) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return max;
	}

	static boolean works(int i) {
		return true;
	}
}
