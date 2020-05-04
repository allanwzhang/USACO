package freqUsedAlg;

public class stringArrToIntArr {
	public static void main(String[] args) {
		
	}

	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
	
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
	
		return result;
	}	

}