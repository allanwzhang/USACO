package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: homework
*/


import java.io.*;
import java.util.*;

public class homework {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("homework.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
	
		 Integer.parseInt(f.readLine());
		 int[] problems = toIntArray(f.readLine().split(" "));
		 
		 float max = Math.max(problems[problems.length - 1], problems[problems.length - 2]);
		 ArrayList<Integer> result = new ArrayList<>();
		 int minNum = Math.min(problems[problems.length - 1], problems[problems.length - 2]);
		 float average = Math.max(problems[problems.length - 1], problems[problems.length - 2]);
		 
		 for(int i = problems.length - 3; i >= 0; i--) {
//			 System.out.println(max + " " + minNum + " " + average);
			 if(problems[i] < minNum) {
				 average = ((average * (problems.length - i - 2)) + minNum) / (problems.length - i - 1);
				 minNum = problems[i];
			 } else {
				 average = ((average * (problems.length - i - 2)) + problems[i]) / (problems.length - i - 1);
			 }
			 if(average == max) {
				 result.add(i);
			 } else if(average > max) {
				 max = average;
				 result.clear();
				 result.add(i);
			 }
		 }
		 
		 Collections.sort(result);
		 
		 for(int i : result) {
			 System.out.println(i);
			 out.println(i);
		 }
		 
		 out.close();
		 f.close();
	}
	
	
	static int[] toIntArray(String[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
		
		return result;
	}
}
