package Section_1_3;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: namenum
*/

public class namenum {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		BufferedReader d = new BufferedReader(new FileReader("dict.txt"));
		
		String number = f.readLine();
		
		HashMap<Character, Integer> code = new HashMap<>();
		List<String> a = Arrays.asList("", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY");
		for(int i = 0; i < a.size(); i++) {
			String x = a.get(i);
			for(int j = 0; j < x.length(); j++) {
				code.put(x.charAt(j), i);
			}
		}		
		
		HashMap<String, List<String>> names = new HashMap<>();
		
		String line;
	    while ((line = d.readLine()) != null) {
	    	
	      String key = toNum(line, code);
	      if(!names.containsKey(key)) {  
	    	  names.put(key, new ArrayList<String>());
	      }
	      names.get(key).add(line);
	    }
		
		if(names.containsKey(number)) {
			List<String> asdf = names.get(number);
			for(String s : asdf) {
				out.println(s);
			}
		} else {
			out.println("NONE");
		}
	    
	    
	    
	    
	    out.close();
	    f.close();
	    d.close();
	}
	
	static String toNum(String name, Map<Character, Integer> code) {
		String num = "";
		for(int i = 0; i < name.length(); i++) {
			num = num + code.get(name.charAt(i));
		}
		return(num);
	}
}