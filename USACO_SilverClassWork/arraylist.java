package USACO_SilverClassWork;
import java.util.*;

public class arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			arr.add(i);
		}
		arr.set(4, 10);
		arr.remove(3);
		
		for(int i : arr) {
			System.out.println(i);
		}
	}

}
