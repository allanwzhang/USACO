package Section_1_3;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: namenum
*/

public class namenum2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		BufferedReader d = new BufferedReader(new FileReader("dict.txt"));
		
		System.out.println(System.currentTimeMillis());
		List<String> result = new ArrayList<>();
		String path = "";
		String number = f.readLine();
		allCombos(number, 0, result, path);
		
		HashSet<String> dictLines = new HashSet<>();
		String line;
	    while ((line = d.readLine()) != null) {
	       dictLines.add(line);
	    }
	    
	    List<String> answer = new ArrayList<>();
	    for(int i = 0; i < result.size(); i++) {
	    	if(dictLines.contains(result.get(i))) {
	    		answer.add(result.get(i));
	    	}
	    }
	   
	    if(answer.size() == 0) out.println("NONE");
	    else for(String asdf : answer) out.println(asdf);
	
	    System.out.println(System.currentTimeMillis());
	    
	    out.close();
	    f.close();
	    d.close();
	}
	
	static void allCombos(String number, int i, List<String> result, String path){
		if(i == number.length()) {
			result.add(path);
			return;
		}

		for (char c : getLetters(number.charAt(i))) {
			allCombos(number, i +1, result, path+c);
		}
	}
	
	static char[] getLetters(char i){
		List<String> a = Arrays.asList("", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY");
		return a.get(Integer.parseInt(i + "")).toCharArray();
	}
}