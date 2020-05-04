package Section_3_3;
/*
//ID: allanwz1
LANG: JAVA
TASK: range
*/

import java.io.*;
import java.util.*;

public class range {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("range.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("range.out")));
	
		 int length = Integer.parseInt(f.readLine());
		 
		 char[][] field = new char[length][length];
		 
		 int count = 0;
		 
		 while(f.ready()) {
			 field[count] = f.readLine().toCharArray();
			 count++;
		 }
		 
		 int[][] consL = new int[length][length];
		 int[][] consU = new int[length][length];
		 
		 for(int i = 0; i < consL.length; i++) {
			 if(field[i][0] == '1') {
				 consL[i][0] = 1;
			 }
			 if(field[0][i] == '1') {
				 consU[0][i] = 1;
			 }
		 }
		 
		 for(int i = 0; i < length; i++) {
			 for(int j = 1; j < length; j++) {
				 if(field[i][j] == '0') {
					 consL[i][j] = 0;
				 } else {
					 consL[i][j] = consL[i][j - 1] + 1;
				 }
			 }
		 }
		 
		 for(int i = 1; i < length; i++) {
			 for(int j = 0; j < length; j++) {
				 if(field[i][j] == '0') {
					 consU[i][j] = 0;
				 } else {
					 consU[i][j] = consU[i - 1][j] + 1;
				 }
			 }
		 }
		 
		 int[][] box = new int[length][length];
		 
		 for(int i = 0; i < box.length; i++) {
			 if(consL[i][0] >= 1 && consU[i][0] >= 1) box[i][0] = 1;
			 if(consL[0][i] >= 1 && consU[0][i] >= 1) box[0][i] = 1;
		 }
		 
		 for(int i = 1; i < length; i++) {
			 for(int j = 1; j < length; j++) {
				 box[i][j] = Math.min(box[i - 1][j - 1] + 1, Math.min(consU[i][j], consL[i][j]));
			 }
		 }
		 
		 TreeMap<Integer, Integer> result = new TreeMap<>();
		 
		 for(int i = 0; i < box.length; i++) {
			 for(int j = 0; j < box.length; j++) {
				 while(box[i][j] >= 2) {
					 result.put(box[i][j], result.getOrDefault(box[i][j], 0) + 1);
					 box[i][j]--;
				 }
			 }
		 }
		 
		 for(int i : result.keySet()) {
			 System.out.println(i + " " + result.get(i));
			 out.println(i + " " + result.get(i));
		 }
		 
		 out.close();
		 f.close();
	}
}
