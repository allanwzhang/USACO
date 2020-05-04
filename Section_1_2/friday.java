package Section_1_2;

/*
ID: allanwz1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
    int i1 = Integer.parseInt(st.nextToken()); 
    int endYear = i1 + 1900;
    int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] result = new int[7];

    //    
    int dayInWeek = 0;
    // 1900/01/13 is Sat
    for (int year =1900; year < endYear; year++) {
      if(isLeapYear(year)) months[1] = 29;
      else months[1] = 28;
    
      for (int i =0 ;i<12;i++) {
        result[dayInWeek] ++;
        dayInWeek = (dayInWeek + months[i]) % 7;
      }
    }
    for (int i = 0; i< 7; i++) {
      if( i!=0)out.print(" ");
      out.print(result[i]);
    }
    out.println();
    out.close();
    f.close();
    // close the output file
  }
  private static boolean isLeapYear(int year) {
    if (year%4 != 0) return false;
    if (year%100 == 0 && year%400!= 0) return false;
    return true;
  }
  
}