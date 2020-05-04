package NotComplete;
/*
//ID: allanwz1
LANG: JAVA
TASK: rental
*/

import java.io.*;
import java.util.*;

public class rental {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("rental.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numCows = Integer.parseInt(arr[0]);
		 int numStores = Integer.parseInt(arr[1]);
		 int numRentals = Integer.parseInt(arr[2]);
		 
		 Integer[] cows = new Integer[numCows];
		 
		 for(int i = 0; i < numCows; i++) {
			 cows[i] = Integer.parseInt(f.readLine());
		 }
		 
		 Arrays.sort(cows, (Integer a, Integer b) -> b - a);
		 
		 ArrayList<Store> stores = new ArrayList<>();
		 
		 for(int i = 0; i < numStores; i++) {
			 String[] curr = f.readLine().split(" ");
			 stores.add(new Store(Integer.parseInt(curr[1]), Integer.parseInt(curr[0])));
		 }
		 
		 Collections.sort(stores, (Store a, Store b) -> b.price - a.price);
		 
		 long[] rentals = new long[numRentals];
		 
		 for(int i = 0; i < numRentals; i++) {
			 rentals[i] = Long.parseLong(f.readLine()) * -1;
		 }
		 
		 Arrays.sort(rentals);
		 
		 for(int i = 0; i < rentals.length; i++) {
			 rentals[i] *= -1;
		 }
		 
		 for(int i = 1; i < rentals.length; i++) {
			 rentals[i] = rentals[i] + rentals[i - 1];
		 }
		 
		 long[] maxValue = new long[numCows];
		 
		 boolean breakAll = false;
		 
		 for(int i = 0; i < maxValue.length; i++) {
			 int curr = cows[i];
			 int value = 0;
			 while(curr > 0) {
				 if(stores.size() == 0) {
					 breakAll = true;
					 break;
				 }
				 Store currStore = stores.remove(0);
				 if(currStore.amount > curr) {
					 currStore.amount -= curr;
					 value += curr * currStore.price;
					 stores.add(0, currStore);
					 break;
				 } else {
					 curr -= currStore.amount;
					 value += currStore.amount * currStore.price;
				 }
			 }
			 
			 if(breakAll) {
				 maxValue[i] = Integer.MIN_VALUE;
				 break;
			 }
			 if(i == 0) maxValue[i] = value;
			 else maxValue[i] = maxValue[i - 1] + value;
		 }
		 
//		 System.out.println(Arrays.toString(maxValue));
//		 System.out.println(Arrays.toString(rentals));
		 
		 long max = 0;
		 if(rentals.length == numCows) max = rentals[numCows - 1];
		 for(int i = 0; i < numCows; i++) {
			 if(maxValue[i] == Integer.MIN_VALUE) break;
			 if(i == numCows - 1) {
				 max = Math.max(max, maxValue[i]);
				 break;
			 }
			 max = Math.max(max, maxValue[i] +  rentals[Math.min(numCows - i - 2, rentals.length - 1)]);
		 }
		 
		 System.out.println(max);
		 out.println(max);
		 
		 out.close();
		 f.close();
	}
	
	static class Store {
		int price, amount;
		
		Store(int p, int a) {
			price = p;
			amount = a;
		}
	}
}
