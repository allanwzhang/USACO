package Section_2_3;
/*
//ID: allanwz1
LANG: JAVA
TASK: concom
*/

import java.io.*;
import java.util.*;

public class concom {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("concom.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
		 
//		 int num = Integer.parseInt(f.readLine());
		 f.readLine();
		 
		 int[][] stocks = new int[101][101]; 
	     boolean[][] control = new boolean[101][101];
		 
	     while(f.ready()) {
			 String[] arr = f.readLine().split(" ");
			 int a = Integer.parseInt(arr[0]);
			 int b = Integer.parseInt(arr[1]);
			 int p = Integer.parseInt(arr[2]);
			 
			 stocks[a][b] = p;
			 if(p > 50) control[a][b] = true;
		 }
		 
		 
	          
	        for (int i=1;i<=100;i++){  
	            LinkedList<Integer> ll = new LinkedList<Integer>();  
	            for (int j=1;j<=100;j++){  
	                if (control[i][j]){  
	                    ll.add(j);  
	                }  
	            }  
	            while (ll.size()!=0){  
	                int temp = ll.removeFirst();  
	                for (int j=1;j<=100;j++){  
	                    if (!control[i][j]) {  
	                        stocks[i][j]+=stocks[temp][j];  
	                        if (stocks[i][j]>50){  
	                            ll.add(j);  
	                            control[i][j] = true;  
	                        }  
	                    }  
	                }  
	            }  
	        }  
		 for(int i = 0; i < stocks.length; i++) {
			 for(int j = 0; j < stocks.length; j++) {
				 if(control[i][j] && i != j) {
					 System.out.println(i + " " + j);
					 out.println(i + " " + j);
				 }
			 }
		 }
		 
//		 for(int i = 0; i < percent.length; i++) {
//			 ArrayList<Integer> holder = new ArrayList<>();
//			 
//			 for(int j = 0; j < percent.length; j++) {
//				 if(own[i][j]) {
//					 holder.add(j);
//				 }
//			 }
//			 
//			 while(!holder.isEmpty()) {
//				 int temp = holder.remove(0);
//				 for(int j = 0; j < percent.length; j++) {
//					 if(!own[i][j]) {
//						 percent[i][j] += percent[temp][j];
//					 }
//					 if(percent[i][j] > 50) {
//						 own[i][j] = true;
//					 }
//				 }
//			 }
//		 }
		 out.close();
		 f.close();
	}
}
