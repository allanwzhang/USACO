package Section_1_4;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: milk
*/

public class milk {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		
		String[] line = f.readLine().split(" ");
		int milkGoal = Integer.parseInt(line[0]);
		int farmers = Integer.parseInt(line[1]);
		
		Map<Integer, Integer> farmerMilk = new TreeMap<Integer, Integer>();
		
		for(int i = 0; i < farmers; i++) {
			String[] l = f.readLine().split(" ");
			if(farmerMilk.containsKey(Integer.parseInt(l[0]))) {
				farmerMilk.put(Integer.parseInt(l[0]), farmerMilk.get(Integer.parseInt(l[0])) + Integer.parseInt(l[1]));
			} else {
			farmerMilk.put(Integer.parseInt(l[0]), Integer.parseInt(l[1]));
			}
		}
		
		int milkHave = 0;
		int cost = 0;
		
			Collection<Integer> c = farmerMilk.keySet();
			Iterator<Integer> itr = c.iterator();
			
			while(itr.hasNext() && milkHave < milkGoal) {
				int price = itr.next();
				if(milkHave + farmerMilk.get(price) <= milkGoal) {
					cost += price * farmerMilk.get(price);
					milkHave += farmerMilk.get(price);
				} else {
					cost += (milkGoal - milkHave) * price;
					milkHave = milkGoal;
				}
			}
		
		out.println(cost);
		
		out.close();
		f.close();
	}
}