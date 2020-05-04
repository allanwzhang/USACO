package Section_2_2;
/*
//ID: allanwz1
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.*;
import java.util.List;

public class lamps {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
		 
		 int numLamps = Integer.parseInt(f.readLine());
		 int moves = Integer.parseInt(f.readLine());
		 String[] lampOn = f.readLine().split(" +");
		 String[] lampOff = f.readLine().split(" +");
		 
		 ArrayList<Integer> allPoss = new ArrayList<>();
		 
		 if(moves == 0) {
			 allPoss.add(0);
		 } else if (moves == 1) {
			 allPoss.addAll(Arrays.asList(8, 4, 2, 1));
		 } else if (moves == 2) {
			 allPoss.addAll(Arrays.asList(6, 5, 12, 9, 10, 3, 0));
		 } else if (moves % 2 == 1) {
			 allPoss.addAll(Arrays.asList(14, 13, 11, 8, 7, 4, 2, 1));
		 } else {
			 allPoss.addAll(Arrays.asList(6, 5, 12, 15, 9, 10, 3, 0));
		 }
		 
		 int[] holder = new int[numLamps];
		 reset(holder);
		 
		 List<int[]> result = new ArrayList<>();
		 
		 for(int i : allPoss) {
			 changeArr(i, holder);
			 if(satisfy(holder, lampOn, lampOff)) {
				 result.add(copyArr(holder));
				 System.out.println(i);
			 }
			 reset(holder);
		 }
		 
		 if(result.isEmpty()) out.println("IMPOSSIBLE");
		 
		 for(int[] a : result) {
			 for(int i : a) {
				 System.out.print(i);
				 out.print(i);
			 }
			 System.out.println();
			 out.println();
		 }
		 
		 out.close();
		 f.close();
	}
	
//	static class listComparator implements Comparator<int[]> {
//
//		@Override
//		public int compare(int[] arr1, int[] arr2) {
//			for(int i = 0; i < arr1.length; i++) {
//				if(arr1[i] == 0 && arr2[i] == 0) {
//					return 0;
//				} else if (arr1[i] == 0) {
//					return -1;
//				} else if(arr2[i] == 0) {
//					return 1;
//				}
//			}
//			return 0;
//		}
//		
//	}
	
	static int[] copyArr(int[] arr) {
		int[] result = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}
	
	static boolean satisfy(int[] holder, String[] lampOn, String[] lampOff) {
		for(int i = 0; i < lampOn.length - 1; i++) {
			if(holder[Integer.parseInt(lampOn[i]) - 1] == 0) {
				return false;
			}
		}
		
		for(int i = 0; i < lampOff.length - 1; i++) {
			if(holder[Integer.parseInt(lampOff[i]) - 1] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	static void reset(int[] holder) {
		for(int i = 0; i < holder.length; i++) {
			 holder[i] = 1;
		 }
	}
	
	static void turnAllOff(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				arr[i] = 1;
			} else {
				arr[i] = 0;
			}
		}
	}
	
	static void turnOddOff(int[] arr) {
		for(int i = 1; i < arr.length; i += 2) {
			if(arr[i] == 0) {
				arr[i] = 1;
			} else {
				arr[i] = 0;
			}
		}
	}
	
	static void turnEvenOff(int[] arr) {
		for(int i = 0; i < arr.length; i += 2) {
			if(arr[i] == 0) {
				arr[i] = 1;
			} else {
				arr[i] = 0;
			}
		}
	}
	
	static void turn1Mod3Off(int[] arr) {
		for(int i = 0; i < arr.length; i += 3) {
			if(arr[i] == 0) {
				arr[i] = 1;
			} else {
				arr[i] = 0;
			}
		}
	}
	
	static void changeArr(int i, int[] arr) {
		if(i >= 8) {
			turnAllOff(arr);
			i -= 8;
		}
		if(i >= 4) {
			turnOddOff(arr);
			i -= 4;
		}
		if(i >= 2) {
			turnEvenOff(arr);
			i -= 2;
		}
		if(i >= 1) {
			turn1Mod3Off(arr);
			i -= 1;
		}
		if(i != 0) System.out.println("PROBLEM!");
	}
}
