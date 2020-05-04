package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: shuffle
*/

import java.io.*;
import java.util.HashMap;

public class shuffle {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		 
		 int size = Integer.parseInt(f.readLine());
		 
		 int[] moveTo = toIntArray(f.readLine().split(" "));
		 
		 boolean[] visited = new boolean[size];
		 
		 int count = 0;
		 
		 for(int i = 0; i < visited.length; i++) {
			 if(visited[i]) continue;
			 HashMap<Integer, Integer> looped = new HashMap<>();
			 int curr = i;
			 int indexHolder = 0;
			 while(indexHolder < moveTo.length) {
				 if(looped.containsKey(curr)) {
					 count += indexHolder - looped.get(curr) + 1;
					 break;
				 }
				 if(visited[curr]) break;
				 indexHolder++;
				 looped.put(curr, indexHolder);
				 visited[curr] = true;
				 curr = moveTo[curr];
			 }
		 }
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
	
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]) - 1;
		}
	
		return result;
	}
}
