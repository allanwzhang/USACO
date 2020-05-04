package Section_1_3;
import java.io.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: transform
*/

public class transform {
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		 
		 int numberRows = Integer.parseInt(f.readLine());
		 char[][] before = new char[numberRows][numberRows];
		 for(int i = 0; i < numberRows; i++) {
			 before[i] = f.readLine().toCharArray();
		 }
		 char[][] after = new char[numberRows][numberRows];
		 for(int i = 0; i < numberRows; i++) {
			 after[i] = f.readLine().toCharArray();
		 }
		 
		 f.close();
		 
		 if(isEqual(rotate90(before), after)) {
			 out.println("1");
			 out.close();
			 return;
		 }
		 if(isEqual(rotate180(before), after)) {
			 out.println("2");
			 out.close();
			 return;
		 }
		 if(isEqual(rotate270(before), after)) {
			 out.println("3");
			 out.close();
			 return;
		 }
		 if(isEqual(reflect(before), after)) {
			 out.println("4");
			 out.close();
			 return;
		 }
		 if(combo(before, after)) {
			 out.println("5");
			 out.close();
			 return;
		 }
		 if(isEqual(before, after)) {
			 out.println("6");
			 out.close();
			 return;
		 }
		 out.println("7");
		 out.close();
		 
//		 char[][] result = rotate90(before);
//		 for(int i = 0; i < result.length; i++) {
//			 StringBuffer sb = new StringBuffer();
//			for(int j = 0; j < result[i].length; j++) {
//				sb.append(result[i][j]);
//			}
//			System.out.println(sb.toString());
//		}


	}
	
	static char[][] rotate90(char[][] before) {
		char[][] result = new char[before.length][before.length];
		
		for(int i = 0; i < before.length; i++) {
			for(int j = 0; j < before[i].length; j++) {
				result[i][j] = before[before.length - 1 - j][i];
			}
		}
		return result;
	}
	
	static char[][] rotate180(char[][] before) {
		return rotate90(rotate90(before));
	}
	
	static char[][] rotate270(char[][] before) {
		return rotate90(rotate180(before));
	}
	
	static char[][] reflect(char[][] before) {
		char[][] result = new char[before.length][before.length];
		for(int i = 0; i < before.length; i++) {
			for(int j = 0; j < before[i].length; j++) {
				result[i][j] = before[i][before.length - 1 - j];
			}
		}
		return result;
	}
	
	static boolean combo(char[][] before, char[][] after) {
		if(isEqual(rotate90(reflect(before)), after)) {
			return true;
		}
		if(isEqual(rotate180(reflect(before)), after)) {
			return true;
		}
		if(isEqual(rotate270(reflect(before)), after)) {
			return true;
		}
		return false;
	}
	
	static boolean isEqual(char[][] before, char[][] after) {
		for(int i = 0; i < before.length; i++) {
			for(int j = 0; j < before[i].length; j++) {
				if(before[i][j] != after[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}