package USACO_SilverClassWork;
/*
//ID: allanwz1
LANG: JAVA
TASK: citystate
*/

import java.io.*;
import java.util.*;

public class citystate {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
	
		 int lines = Integer.parseInt(f.readLine());
		 
		 HashMap<String, Long> map = new HashMap<>();
		 
		 for(int i = 0; i < lines; i++) {
			 StringTokenizer st = new StringTokenizer(f.readLine());
			 String city = st.nextToken().substring(0, 2);
			 String state = st.nextToken();
			 
			 if(!city.equals(state)) {
				 String code = city + state;
				 if(map.containsKey(code)) {
					 map.put(code, map.get(code) + 1);
				 } else {
					 map.put(code, 1L);
				 }
			 }
		 }
		 
		 int count = 0;
		 
		 for(String s : map.keySet()) {
			 String newCode = s.substring(2, 4) + s.substring(0, 2);
			 if(map.containsKey(newCode)) {
				 count += map.get(s) * map.get(newCode);
			 }
		 }
		 
		 System.out.println(count / 2);
		 out.println(count / 2);
		 
		 out.close();
		 f.close();
	}
}
