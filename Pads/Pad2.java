package Pads;

public class Pad2 {

	public static void main(String[] args) {
		for(int i = 1; i < 76; i++) {
			//long[] a = new long[i];
			//System.out.print(i + ":" + fib(i - 1, a) + " , ");
			System.out.print(i + ":" + fib4(i) + ", ");
		}
		System.out.println();
		System.out.println("Done");
	}

	static long fib(int n, long[] values) {
		if(values[n] != 0) {
			return values[n];
		}
		if(n == 1) {
			return 1;
		} else if(n == 0) {
			return 0;
		} else {
			long v = fib(n - 1, values) + fib(n - 2, values);
			values[n] = v;
			return v;
		}
	}
	
	static int fib2(int n) {
		if(n < 2) {
			return n;
		}
		int[] val = new int[n];
		val[1] = 1;
		for(int i = 2; i < val.length; i++) {
			val[i] = val[i - 1] + val[i - 2];
		}
		return val[n - 1];
	}
	
	static int fib3(int n) {
		if(n < 2) {
			return n;
		}
		int[] val = new int[3];
		int i = 0;
		val[1] = 1;
		while(i < n) {
			val[2] = val[1] + val[0];
			int x = val[2];
			int y = val[1];
			val[1] = x;
			val[0] = y;
			i++;
		}
		return val[2];
	}

	static int fib4(int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		
		for(int i = 0; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}
}
