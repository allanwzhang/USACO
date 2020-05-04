package USACO_SilverClassWork;
import java.util.*;

public class graphPractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array = sc.nextLine().split(" ");
		int n = Integer.parseInt(array[0]);
		int m = Integer.parseInt(array[1]);
		boolean[][] nodes = new boolean[n + 1][n + 1];
		for(int i = 0; i < m; i++) {
			String[] arr = sc.nextLine().split(" ");
			nodes[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = true;
			nodes[Integer.parseInt(arr[1])][Integer.parseInt(arr[0])] = true;
		}
		sc.nextLine();
		HashSet<Integer> special = new HashSet<>();
		for(String s : sc.nextLine().split(" ")) {
			special.add(Integer.parseInt(s));
		}
		
		String result = "";
		
		int count = 0;
		
		for(int j : special) {
			if(nodes[1][j]) count++;
		}
		
		result = count + "";
		count = 0;
		
		for(int i = 2; i < nodes.length; i++) {
			for(int j : special) {
				if(nodes[i][j]) count++;
			}
			result += " " + count;
			count = 0;
		}
		
		System.out.println(result);
		
		sc.close();
	}

}
