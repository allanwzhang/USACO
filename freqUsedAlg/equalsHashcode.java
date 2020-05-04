package freqUsedAlg;

public class equalsHashcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Pair {
		int a, b;

		Pair(int aa, int bb) {
			a = aa;
			b = bb;
		}
		
		 @Override    
		 public boolean equals(Object o) {        
		     if (this == o) return true;        
		     if (o == null || getClass() != o.getClass()) return false;        
		     Pair p = (Pair) o;        
		     if (a != p.a) return false;                        
		     return b == p.b;    
		 }    
		 
		 @Override    
		 public int hashCode() {        
			 int hash = 7;
			 hash = 31 * hash + (int) a;
			 hash = 31 * hash + (int) b;
			 return hash;  
		 }   
	}
}
