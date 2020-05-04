package Section_1_6;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: numtri
*/

public class numtri {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
	
		int rows = Integer.parseInt(f.readLine());
		List<int[]> triangle = new ArrayList<>();
		
		for(int i = 1; i <= rows; i++) {
			String[] r = f.readLine().split(" ");
			int[] row = new int[i];
			for(int j = 0; j < r.length; j++) {
				row[j] = Integer.parseInt(r[j]);
			}
			triangle.add(row);
		}
		
		findPath(triangle);
		System.out.println(triangle.get(0)[0]);
		out.println(triangle.get(0)[0]);
		
		out.close();
		f.close();
	}
	
	static void findPath(List<int[]> triangle) {
		for(int i = triangle.size() - 2; i >= 0; i--) {
			for(int j = 0; j < triangle.get(i).length; j++) {
				if(triangle.get(i + 1)[j] > triangle.get(i + 1)[j + 1]) {
					triangle.get(i)[j] += triangle.get(i + 1)[j];
				} else {
					triangle.get(i)[j] += triangle.get(i + 1)[j + 1];
				}
			}
		}
	}
}
