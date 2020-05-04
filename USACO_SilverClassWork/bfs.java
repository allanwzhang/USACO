package USACO_SilverClassWork;
import java.util.*;

public class bfs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array = sc.nextLine().split(" ");
		int n = Integer.parseInt(array[0]);
		int e = Integer.parseInt(array[1]);

		boolean[][] connected = new boolean[n + 1][n + 1];
	
		for(int i = 0; i < e; i++) {
			String[] arr = sc.nextLine().split(" ");
			connected[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = true;
			connected[Integer.parseInt(arr[1])][Integer.parseInt(arr[0])] = true;
		}
		
		String[] finalLine = sc.nextLine().split(" ");
		
		int start = Integer.parseInt(finalLine[0]);
		int end = Integer.parseInt(finalLine[1]);
		
		Deque<Integer> nodes = new ArrayDeque<>();
		
		nodes.push(start);
		
		int count = 0;
		HashSet<Integer> visited = new HashSet<>();
		
		while(nodes.peek() != end) {
			int curr = nodes.pop();
			visited.add(curr);
			count++;
			for(int i = 0; i < connected.length; i++) {
				if(connected[curr][i] && !visited.contains(i)) {
					nodes.push(i);
				}
			}
		}
		
		System.out.println(count);
		sc.close();
	}

}
