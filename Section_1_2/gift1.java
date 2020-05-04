package Section_1_2;
/*
ID: allanwz1
LANG: JAVA
TASK: gift1
*/

import java.util.*;
import java.io.*;

public class gift1 {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		 
		 int people = Integer.parseInt(f.readLine());
		 Map<String, Integer> record = new HashMap<>();
		 List<String> names = new ArrayList<>();
		 
		 for(int i = 0; i < people; i++) {
			 String y = f.readLine();
			 record.put(y, 0);
			 names.add(y);
		 }
		 String line = "";
		 while((line = f.readLine()) != null) {
			 List<String> reciever = new ArrayList<>();
			 String a = f.readLine();
			 String[] x = a.split(" ");
			 int amount = Integer.parseInt(x[0]);
			 int num = Integer.parseInt(x[1]);
			 
			 for(int i = 0; i < num; i++) {
				 reciever.add(f.readLine());
			 }
			 
			 give(line, amount, reciever, record);
			 
		 }
		 
		 for(String key : names) {
			 out.println(key + " " + record.get(key));
		 }
		 
		 f.close();
		 out.close();
	}
	
	public static void give(String giver, int amount, List<String> reciever, Map<String, Integer> record) {
		if(reciever.isEmpty() || amount == 0) return;
		int split = amount / reciever.size();
		int remainder = amount % reciever.size();
		record.put(giver, record.get(giver) - amount + remainder);
		for(String person : reciever) {
			record.put(person, record.get(person) + split);
		}
	}

}
