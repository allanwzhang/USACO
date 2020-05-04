package USACO_SilverClassWork;
import java.util.*;

public class queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= 10; i++) {
			queue.add(i);
		}
		for(int i = 0; i < 5; i++) {
			queue.poll();
		}
		
		System.out.println(queue.peek());
	}

}
