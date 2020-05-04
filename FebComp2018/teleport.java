package FebComp2018;
/*
//ID: allanwz1
LANG: JAVA
TASK: teleport
*/
import java.io.*;

public class teleport {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
	
		 String[] nums = f.readLine().split(" ");
		 
		 int[] dist = new int[] {Math.min(Integer.parseInt(nums[0]), Integer.parseInt(nums[1])), Math.max(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]))};
		 int[] tele = new int[] {Math.min(Integer.parseInt(nums[2]), Integer.parseInt(nums[3])), Math.max(Integer.parseInt(nums[2]), Integer.parseInt(nums[3]))};
		 
		 int min = dist[1] - dist[0];
		 
		 min = Math.min(min, Math.abs(dist[0] - tele[0]) + Math.abs(dist[1] - tele[1]));
		 
		 System.out.println(min);
		 out.println(min);
		 
		 f.close();
		 out.close();
	}
}
