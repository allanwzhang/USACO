package Section_1_2;
/*
ID: allanwz1
LANG: JAVA
TASK: ride
*/

import java.io.*;

public class ride {

	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		 String a = f.readLine();
		 String b = f.readLine();
		 int producta = 1;
		 int productb = 1;
		 
		 for(int i = 0; i < a.length(); i++) {
			 producta = producta * ((int)a.charAt(i) - 64);
		 }
		 
		 for(int i = 0; i < b.length(); i++) {
			 productb = productb * ((int)b.charAt(i) - 64);
		 }
		 System.out.println(producta % 47 + "  " + productb % 47);
		 if(producta % 47 == productb % 47) {
			 out.println("GO");
		 } else {
			 out.println("STAY");
		 }
		 	f.close();
		 	out.close();
	}

}
