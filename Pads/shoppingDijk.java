package Pads;

/*
//ID: allanwz1
LANG: JAVA
TASK: shopping
*/

import java.io.*;
import java.util.*;

public class shoppingDijk {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("shopping.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shopping.out")));
		 
		 int numOffers = Integer.parseInt(f.readLine());
		 
		 ArrayList<Offer> offers = new ArrayList<>();
		 
		 for(int i = 0; i < numOffers; i++) {
			 StringTokenizer st = new StringTokenizer(f.readLine());
			 int numItems = Integer.parseInt(st.nextToken());
			 HashMap<Integer, Integer> items = new HashMap<>();
			 for(int j = 0; j < numItems; j++) {
				 items.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			 }
			 offers.add(new Offer(items, Integer.parseInt(st.nextToken())));
		 }
		 
		 int items = Integer.parseInt(f.readLine());
		 
		 if(items == 0) {
			 System.out.println("0");
			 out.println("0");
			 
			 out.close();
			 f.close();
			 return;
		 }
		 
		 HashMap<Integer, Integer> needed = new HashMap<>();
		 
		 for(int i = 0; i < items; i++) {
			 StringTokenizer str = new StringTokenizer(f.readLine());
			 int id = Integer.parseInt(str.nextToken());
			 int need = Integer.parseInt(str.nextToken());
			 int regPrice = Integer.parseInt(str.nextToken());
			 needed.put(id, need);
			 HashMap<Integer, Integer> curr = new HashMap<>();
			 curr.put(id, 1);
			 offers.add(new Offer(curr, regPrice));
		 }
		 
//		 for(Offer o : offers) {
//			 for(int i : o.items.keySet()) {
//				 System.out.print(i + " " + o.items.get(i) + ": ");
//			 }
//			 System.out.println(o.cost);
//		 }
//		 
//		 for(int i : needed.keySet()) {
//			 System.out.println(i + " " + needed.get(i));
//		 }
		 
		 int result = dijk(needed, offers);
		 
		 System.out.println(result);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}

	static int dijk(HashMap<Integer, Integer> needed, ArrayList<Offer> offers) {
		OfferComparator oc = new OfferComparator();
		PriorityQueue<Offer> pq = new PriorityQueue<>(100, oc);
		
		pq.add(new Offer(new HashMap<Integer, Integer>(), 0));
		
		while(compare(pq.peek().items, needed) != 0) {
			Offer curr = pq.poll();
			
			for(int i : curr.items.keySet()) {
				System.out.println(i + " " + curr.items.get(i));
			}
			System.out.println(curr.cost);
			
			for(Offer o : offers) {
				HashMap<Integer, Integer> sum = add(o.items, curr.items);
				if(compare(sum, needed) < 1) {
					pq.add(new Offer(sum, o.cost + curr.cost));
				}
			}
		}
		
//		System.out.println(pq.peek().cost);
		
		return pq.poll().cost;
	}
	
	static HashMap<Integer, Integer> add(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b) {
		HashMap<Integer, Integer> result = new HashMap<>();
		for(int i : a.keySet()) {
			if(b.containsKey(i)) {
				result.put(i, a.get(i) + b.get(i));
			} else {
				result.put(i, a.get(i));
			}
		}
		
		for(int i : b.keySet()) {
			if(!a.containsKey(i)) result.put(i, b.get(i));
		}
		return result;
	}
	
	static int compare(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b) {	
		if(a.size() == 0) return -1;
		
		boolean allEqual = true;
		
		for(int i : b.keySet()) {
			if(!a.containsKey(i)) {
				allEqual = false;
				continue;
			}
			if(a.get(i) > b.get(i)) return 1;
			if(a.get(i) < b.get(i)) allEqual = false;
		}
		
		if(allEqual) return 0;
		return -1;
	}
	
	static class OfferComparator implements Comparator<Offer> {

		@Override
		public int compare(Offer a, Offer b) {
			return a.cost - b.cost;
		}
		
	}
	
	static class Offer {
		HashMap<Integer, Integer> items = new HashMap<>();
		int cost;
		
		Offer(HashMap<Integer, Integer> i, int c) {
			cost = c;
			items = i;
		}
	}
	
}
