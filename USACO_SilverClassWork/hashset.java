package USACO_SilverClassWork;
import java.util.*;

public class hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		Set<String> names = new TreeSet<>();
		
		for(int i = 0; i < num; i++) {
			names.add(sc.nextLine());
		}
		
		Iterator<String> it = names.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
//		System.out.println(names.size());
		
		sc.close();
	}

}
