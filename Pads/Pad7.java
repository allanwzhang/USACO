package Pads;
import java.util.*;

public class Pad7 {

	public static void main(String[] args) {
		Binary[] arr = new Binary[3];
		arr[0] = new Binary(1, new byte[] {1}, 1);
		arr[2] = new Binary(4, new byte[] {1, 0, 0}, 1);
		arr[1] = new Binary(3, new byte[] {1, 1}, 2);
		
		Arrays.sort(arr, new BinaryComparator());
		
		for(Binary b : arr) {
			System.out.println(b.value);
			System.out.println(b.numberOf1);
		}
	}
	
	static class BinaryComparator implements Comparator<Binary> {
		@Override
		public int compare(Binary a, Binary b) {
			if(a.numberOf1 > b.numberOf1) return 1;
			else if (a.numberOf1 < b.numberOf1) return -1;
			
			if(a.value > b.value) return 1;
			else if(a.value < b.value) return -1;
			
			return 0;
		}
	}
	
	static class Binary {
		int value;
		byte[] binaryRep;
		int numberOf1;
		
		Binary(int v, byte[] b, int n) {
			value = v;
			binaryRep = b;
			numberOf1 = n;
		}
	}
	
}
