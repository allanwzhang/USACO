package FebComp2019;
/*
//ID: allanwz1
LANG: JAVA
TASK: revegetate
*/


import java.io.*;
import java.util.*;

public class revegetate {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
	
		 String[] arr = f.readLine().split(" ");
		 int numFields = Integer.parseInt(arr[0]);
		 int numRestrict = Integer.parseInt(arr[1]);
		 
		 ArrayList<HashSet<Integer>> fields = new ArrayList<>();
		 HashSet<Integer> fieldTracker = new HashSet<>();
		 
		 for(int i = 0; i < numRestrict; i++) {
			 String[] array = f.readLine().split(" ");
			 int f1 = Integer.parseInt(array[1]);
			 int f2 = Integer.parseInt(array[2]);
//			 System.out.println(f1 + " " + f2);
			 fieldTracker.add(f1);
			 fieldTracker.add(f2);
			 int f1Pres = -1;
			 int f2Pres = -1;
			 for(int j = 0; j < fields.size(); j++) {
				 if(fields.get(j).contains(f1)) {
					f1Pres = j;
				 }
				 if(fields.get(j).contains(f2)) {
					f2Pres = j;
				 }
			 }
			 
			 if(f1Pres == -1 && f2Pres == -1) {
				 HashSet<Integer> set = new HashSet<>();
				 set.add(f1);
				 set.add(f2);
				 fields.add(set);
//				 System.out.println(f1 + " " + f2);
//				 System.out.println(fields.size());
//				 System.out.println(fields.get(0).size());
			 } else if(f1Pres == -1) {
				 fields.get(f2Pres).add(f1);
			 } else if(f2Pres == -1) {
				 fields.get(f1Pres).add(f2);
			 } else if(f1Pres != f2Pres){
				HashSet<Integer> a = fields.remove(f1Pres);
				HashSet<Integer> b = fields.remove(f2Pres);
				a.addAll(b);
				fields.add(new HashSet<Integer>(a));
			 }
		 }
		 
//		 for(int i = 0; i < fields.size(); i++) {
//			 System.out.println(fields.get(i).size());
//		 }
		 
//		 System.out.println(numFields);
//		 System.out.println(fieldTracker.size());
//		 System.out.println(fields.size());
		 
		 int count = numFields - fieldTracker.size() + fields.size();
		 System.out.println(Long.toBinaryString((int) Math.pow(2, count)));
		 out.println(Long.toBinaryString((int) Math.pow(2, count)));
		 
		 f.close();
		 out.close();
	}
}
