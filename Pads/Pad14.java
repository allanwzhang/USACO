package Pads;

/*
//ID: allanwz1
LANG: JAVA
TASK: comehome
*/

import java.io.*;
import java.util.*;

public class Pad14 {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("comehome.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
	
		 int numFields = Integer.parseInt(f.readLine());
		 
		 HashMap<String, Field> fields = new HashMap<>();
		 
		 for(int i = 0; i < numFields; i++) {
			 String[] arr = f.readLine().split(" ");
			 if(!fields.keySet().contains(arr[0])) {
				 fields.put(arr[0], new Field(arr[0], 0, new HashMap<Field, Integer>()));
			 }
			 if(!fields.keySet().contains(arr[1])) {
				 fields.put(arr[1], new Field(arr[1], 0, new HashMap<Field, Integer>()));
			 }
			 fields.get(arr[0]).neighbors.put(fields.get(arr[1]), Integer.parseInt(arr[2]));
			 fields.get(arr[1]).neighbors.put(fields.get(arr[0]), Integer.parseInt(arr[2]));
		 }
		 
//		 for(String s : fields.keySet()) {
//			 System.out.println(s);
//			 for(Field fi : fields.get(s).neighbors.keySet()) {
//				 System.out.println(fi.name);
//			 }
//			 System.out.println();
//		 }
		 
		 Comparator<Field> comparator = new FieldComparator();
		 PriorityQueue<Field> pq = new PriorityQueue<>(10, comparator);
		 
		 pq.add(fields.get("Z"));
		 
		 HashSet<String> visited = new HashSet<>();
		 
		 while(!isUpperCase(pq.peek().name)) {
			 Field curr = pq.poll();
			 if(visited.contains(curr.name)) {
				 System.out.println("continued: " + curr.name + " with dist: " + curr.distFromBarn);
				 continue;
			 }
			 System.out.println(curr.name + " " + curr.distFromBarn);
			 visited.add(curr.name);
			 for(Field next : curr.neighbors.keySet()) {
				next.distFromBarn = curr.distFromBarn + curr.neighbors.get(next);
				System.out.println("added " + next.name + " with dist: " + next.distFromBarn + " from " + curr.name);
				pq.offer(next);
			 }
		 }
		 
		 System.out.println(pq.peek().name + " " + pq.peek().distFromBarn);
		 out.println(pq.peek().name + " " + pq.peek().distFromBarn);
		 
		 out.close();
		 f.close();
	}
	
	static public class FieldComparator implements Comparator<Field> {
	    @Override
	    public int compare(Field x, Field y) {
	    	return x.distFromBarn - y.distFromBarn;
	    }
	    
	}
	
	static boolean isUpperCase(String s) {
		if((int)s.charAt(0) >= 65 && (int)s.charAt(0) <= 89) {
			return true;
		}
		return false;
	}
	
	static class Field {
		String name;
		Map<Field, Integer> neighbors;
		int distFromBarn;
		
		Field(String na, int d, HashMap<Field, Integer> n) {
			name = na;
			neighbors = n;
			distFromBarn = d;
		}
	}

}
