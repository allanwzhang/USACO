package USACO_SilverClassWork;
import java.util.*;

public class meat {
	static int cost = 0;
	static int i = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int days = Integer.parseInt(sc.nextLine());
	    
	    int[][] meat = new int[days][2];
	    
	    for(int i = 0; i < days; i++) {
	    	String[] arr = sc.nextLine().split(" ");
	    	meat[i][0] = Integer.parseInt(arr[0]);
	    	meat[i][1] = Integer.parseInt(arr[1]);
	    }
	    i = meat.length;
	    while(i != 0) {
	    	System.out.println(i);
	    	findMin(meat);
	    }
	    sc.close();
	    
	    System.out.println(cost);
	}
	
	static void findMin(int[][] meat) {
		int min = Integer.MAX_VALUE;
		int minI = -1;
		for(int j = 0; j < i; j++) {
			if(meat[j][0] < min) {
				minI = j;
				min = meat[j][0];
			}
		}
		
		for(int j = minI; j < i; j++) {
			cost += meat[j][1] * min;
		}
		System.out.println(minI);
		i = minI;
	}
}
