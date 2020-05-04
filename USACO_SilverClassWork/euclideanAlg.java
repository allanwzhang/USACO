package USACO_SilverClassWork;

public class euclideanAlg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(1001, 132));
	}
	
	static int gcd(int a, int b) {
		if(a == 0 || b == 0) return Math.abs(a-b);
		return gcd(Math.min(a, b), Math.abs(a - b));
	}
	
}
