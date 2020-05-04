package Pads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.*;
import java.util.*;

public class Pad13 {
	
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("money.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
		 
		 String[] arr = f.readLine().split(" ");
		 int numCoins = Integer.parseInt(arr[0]);
		 int value = Integer.parseInt(arr[1]);
		 
		 int[] possCoins = new int[numCoins];
		 
		 int count = 0;
		 while(count < numCoins) {
			 String[] array = f.readLine().split(" ");
			 for(int i = 0; i < array.length; i++) {
				 possCoins[count + i] = Integer.parseInt(array[i]);
			 }
			 count += array.length;
		 }
		 
		 Arrays.sort(possCoins);
		 
		 dfs(0, value, 0, possCoins);
		 
		 System.out.println(result);
		 out.println(result);
		 
		 out.close();
		 f.close();
	}

	static void dfs(int curr, int goal, int index, int[] possCoins) {
		if(curr > goal) return;
		if(curr == goal) {
			result++;
			return;
		}
		for(int i = index; i < possCoins.length; i++) {
			if(curr + possCoins[i] > goal) {
				break;
			}
			dfs(curr + possCoins[i], goal, i, possCoins);
		}
	}
}
