package Section_2_4;
/*
//ID: allanwz1
LANG: JAVA
TASK: cowtour
*/

import java.io.*;
import java.util.*;

public class cowtour {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
		 
		 int numFields = Integer.parseInt(f.readLine());
		 
		 Field[] fields = new Field[numFields];
		 
		 for(int i = 0; i < numFields; i++) {
			 String[] c = f.readLine().split(" ");
			 fields[i] = new Field(Integer.parseInt(c[0]), Integer.parseInt(c[1]));
		 }
		 
		 double[][] dist = new double[numFields][numFields];
		 
		 for(int i = 0; i < numFields; i++) {
			 dist[i] = toIntArray(f.readLine().toCharArray());
		 }
		 
		 for(int i = 0; i < dist.length; i++) {
			 for(int j = 0; j < dist[i].length; j++) {
				 if(dist[i][j] == 1) {
					 dist[i][j] = findDist(fields[i], fields[j]);
				 }
			 }
		 }
		 
		 for(int k = 0; k < fields.length; k++) {
			 for(int i = 0; i < fields.length; i++) {
				 for(int j = 0; j < fields.length; j++) {
					 if(dist[i][k] != 0 && dist[k][j] != 0) {
						 if(dist[i][k] + dist[k][j] < dist[i][j] || (dist[i][j] == 0 && i != j)) {
							 dist[i][j] = dist[i][k] + dist[k][j]; 
						 }
					 }
				 }
			 }
		 }
		 
		 for(double[] d : dist) {
			 System.out.println(Arrays.toString(d));
		 }
		 
		 double[] farthest = new double[numFields];
		 for(int i = 0; i < farthest.length; i++) {
			 double max = 0;
			 for(double a : dist[i]) {
				 max = Math.max(a, max);
			 }
			 farthest[i] = max;
		 }
		 
		 double min = Double.MAX_VALUE;
		 
		 for(int i = 0; i < dist.length; i++) {
			 for(int j = i + 1; j < dist.length; j++) {
				 if(dist[i][j] == 0) {
					 double max = Math.max(farthest[i] + farthest[j] + findDist(fields[i], fields[j]), Math.max(diameter(i, dist, farthest), diameter(j, dist, farthest)));
					 min = Math.min(min, max);
				 }
			 }
		 }
		 
		 double result = (double)Math.round(min * 1000000) / 1000000;
		 if((int)result == result) {
			 System.out.println(result + "00000");
			 out.println(result + "00000");
		 } else {
			 System.out.println(result);
			 out.println(result);
		 }
		 
		 out.close();
		 f.close();
	}

	static double diameter(int i, double[][] dist, double[] farthest) {
		ArrayList<Integer> poss = new ArrayList<>();
		for(int k = 0; k < dist.length; k++) {
			if(dist[i][k] != 0) {
				poss.add(k);
			}
		}
		
		if(poss.isEmpty()) return 0;
		
		double max = farthest[poss.get(0)];
		for(int j : poss) {
			max = Math.max(max, farthest[j]);
		}
		
		return max;
	}
	
	static double findDist(Field a, Field b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
	
	static double[] toIntArray(char[] c) {
		double[] result = new double[c.length];
		for(int i = 0; i < c.length; i++) {
			result[i] = Character.getNumericValue(c[i]);
		}
		return result;
	}
	
	static class Field {
		int x, y;
		
		Field(int xx, int yy) {
			x = xx;
			y = yy;
		}
	}
}
