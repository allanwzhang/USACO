package prevSilver;
/*
//ID: allanwz1
LANG: JAVA
TASK: diamond
*/


import java.io.*;
import java.util.*;

public class diamond {
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		 
		 String[] a = f.readLine().split(" ");
		 int numLines = Integer.parseInt(a[0]);
		 int diff = Integer.parseInt(a[1]);
		 
		 ArrayList<Integer> size = new ArrayList<>();
		 
		 for(int i = 0; i < numLines; i++) {
			 size.add(Integer.parseInt(f.readLine()));
		 }
		 
		 Collections.sort(size);
		 
		 int count = maxNum(size, diff);
		 
		 for(Integer i : list) {
			 size.remove(i);
		 }
		 
		 count += maxNum(size, diff);
		 
		 System.out.println(count);
		 out.println(count);
		 
		 out.close();
		 f.close();
	}

//	static int[] split(int[] size, int i, int fs) {
//		int[] first = new int[i];
//		int[] second = new int[size.length - i];
//		
//		for(int j = 0; j < size.length; j++) {
//			if(j < i) first[j] = size[j];
//			else second[j - i] = size[j];
//		}
//		
//		if(fs == 0) return first;
//		return second;
//	}
	
	static int maxNum(ArrayList<Integer> arr, int diff) {
		int max = 0;
		
		for(int i = 0; i < arr.size(); i++) {
			int j = i;
			int count = 0;
			ArrayList<Integer> temp = new ArrayList<>();
			while(j < arr.size() && arr.get(j) - arr.get(i) <= diff) {
				temp.add(arr.get(j));
				j++;
				count++;
			}
			if(count > max) {
				max = count;
				list = temp;
			}
		}
		return max;
	}
	
}
