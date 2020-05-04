package Section_2_4;
/*
//ID: allanwz1
LANG: JAVA
TASK: comehome
*/

import java.io.*;
import java.util.*;

public class comehome {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("comehome.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
	
		 int numFields = Integer.parseInt(f.readLine());
		 
		 HashMap<String, Field> fields = new HashMap<>();
		 
		 for(int i = 0; i < numFields; i++) {
			 String[] arr = f.readLine().split(" ");
			 if(arr[0].equals(arr[1])) continue;
			 if(!fields.keySet().contains(arr[0])) {
				 fields.put(arr[0], new Field(arr[0], 0, new HashMap<Field, Integer>()));
			 }
			 if(!fields.keySet().contains(arr[1])) {
				 fields.put(arr[1], new Field(arr[1], 0, new HashMap<Field, Integer>()));
			 }
			 if(!fields.get(arr[0]).neighbors.containsKey(fields.get(arr[1]))) {
				 fields.get(arr[0]).neighbors.put(fields.get(arr[1]), Integer.parseInt(arr[2]));
//				 System.out.println("put in " + fields.get(arr[0]).name + " connected to " + fields.get(arr[1]).name + " with dist: " + Integer.parseInt(arr[2]));
			 } else {
				 int hold = fields.get(arr[0]).neighbors.remove(fields.get(arr[1]));
				 fields.get(arr[0]).neighbors.put(fields.get(arr[1]), Math.min(hold, Integer.parseInt(arr[2])));
//				 System.out.println("put in " + fields.get(arr[0]).name + " connected to " + fields.get(arr[1]).name + " with dist: " + Math.min(hold, Integer.parseInt(arr[2])));
			 }
			 if(!fields.get(arr[1]).neighbors.containsKey(fields.get(arr[0]))) {
				 fields.get(arr[1]).neighbors.put(fields.get(arr[0]), Integer.parseInt(arr[2]));
//				 System.out.println("put in " + fields.get(arr[1]).name + " connected to " + fields.get(arr[0]).name + " with dist: " + Integer.parseInt(arr[2]));
			 } else {
				 int hold = fields.get(arr[1]).neighbors.remove(fields.get(arr[0]));
				 fields.get(arr[1]).neighbors.put(fields.get(arr[0]), Math.min(hold, Integer.parseInt(arr[2])));
//				 System.out.println("put in " + fields.get(arr[1]).name + " connected to " + fields.get(arr[0]).name + " with dist: " + Math.min(hold, Integer.parseInt(arr[2])));
			 }
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
//				 System.out.println("visited: " + curr.name + " with dist: " + curr.distFromBarn);
				 continue;
			 }
//			 System.out.println(curr.name + " " + curr.distFromBarn);
			 visited.add(curr.name);
			 for(Field next : curr.neighbors.keySet()) {
				if(next.distFromBarn == 0) {
					next.distFromBarn = curr.distFromBarn + curr.neighbors.get(next);
				} else {
					next.distFromBarn = Math.min(curr.distFromBarn + curr.neighbors.get(next), next.distFromBarn);
				}
//				System.out.println("added " + next.name + " with dist: " + next.distFromBarn + " from " + curr.name);
				pq.offer(next);
			 }
//			 printout(pq);
//			 System.out.println();
		 }
		 
		 System.out.println(pq.peek().name + " " + pq.peek().distFromBarn);
		 out.println(pq.peek().name + " " + pq.peek().distFromBarn);
		 
		 out.close();
		 f.close();
	}
	
	static void printout(PriorityQueue<Field> pq) {
		Field[] a = new Field[pq.size()];
		a = pq.toArray(a);
		for(Field f : a) {
			System.out.println("in array: " + f.name + " with dist: " + f.distFromBarn);
		}
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
