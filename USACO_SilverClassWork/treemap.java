package USACO_SilverClassWork;
import java.util.*;

public class treemap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		
		TreeMap<String, Integer> hm = new TreeMap<>();
		
		for(int i = 0; i < num; i++) {
			String curr = sc.nextLine();
			if(hm.containsKey(curr)) {
				hm.put(curr, hm.get(curr) + 1);
			} else {
				hm.put(curr, 1);
			}
		}
		
		for(String s : hm.keySet()) {
			System.out.println(s + " " + hm.get(s));
		}
		
		sc.close();
	}

}
