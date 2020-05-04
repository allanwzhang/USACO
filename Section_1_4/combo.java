package Section_1_4;
import java.io.*;
import java.util.*;

/*
//ID: allanwz1
LANG: JAVA
TASK: combo
*/

public class combo {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		
		int lockNum = Integer.parseInt(f.readLine());
		String[] farmer = f.readLine().split(" ");
		String[] master = f.readLine().split(" ");
	
		List<Integer> farmerCombo = new ArrayList<>();
		List<Integer> masterCombo = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			farmerCombo.add(Integer.parseInt(farmer[i]));
			masterCombo.add(Integer.parseInt(master[i]));
		}
		
		out.println(findCombos(farmerCombo, masterCombo, lockNum).size());
		
		out.close();
		f.close();
	}

	static HashSet<String> findCombos(List<Integer> farmerCombo, List<Integer> masterCombo, int lockNum){
		int first = farmerCombo.get(0);
		int second = farmerCombo.get(1);
		int third = farmerCombo.get(2);
		
		int first1 = masterCombo.get(0);
		int second1 = masterCombo.get(1);
		int third1 = masterCombo.get(2);
		
		int[] firstPoss = new int[] {(first - 2 + lockNum) % lockNum, (first - 1 + lockNum) % lockNum, (first + lockNum) % lockNum, (first + 1 + lockNum) % lockNum, (first + 2 + lockNum) % lockNum}; 
		int[] secondPoss = new int[] {(second - 2 + lockNum) % lockNum, (second - 1 + lockNum) % lockNum, (second + lockNum) % lockNum, (second + 1 + lockNum) % lockNum, (second + 2 + lockNum) % lockNum};
		int[] thirdPoss = new int[] {(third - 2 + lockNum) % lockNum, (third - 1 + lockNum) % lockNum, (third + lockNum) % lockNum, (third + 1 + lockNum) % lockNum, (third + 2 + lockNum) % lockNum};
		
		int[] first1Poss = new int[] {(first1 - 2 + lockNum) % lockNum, (first1 - 1 + lockNum) % lockNum, (first1 + lockNum) % lockNum, (first1 + 1 + lockNum) % lockNum, (first1 + 2 + lockNum) % lockNum}; 
		int[] second1Poss = new int[] {(second1 - 2 + lockNum) % lockNum, (second1 - 1 + lockNum) % lockNum, (second1 + lockNum) % lockNum, (second1 + 1 + lockNum) % lockNum, (second1 + 2 + lockNum) % lockNum};
		int[] third1Poss = new int[] {(third1 - 2 + lockNum) % lockNum, (third1 - 1 + lockNum) % lockNum, (third1 + lockNum) % lockNum, (third1 + 1 + lockNum) % lockNum, (third1 + 2 + lockNum) % lockNum};
		
		HashSet<String> result = new HashSet<>();
		
		for(int a = 0; a < 5; a++) {
			for(int b = 0; b < 5; b++) {
				for(int c = 0; c < 5; c++) {
					if(firstPoss[a] == 0) firstPoss[a] = lockNum;
					if(secondPoss[b] == 0) secondPoss[b] = lockNum;
					if(thirdPoss[c] == 0) thirdPoss[c] = lockNum;
					
					String add = firstPoss[a] + " " + secondPoss[b] + " " + thirdPoss[c];
					result.add(add);
					
					if(first1Poss[a] == 0) first1Poss[a] = lockNum;
					if(second1Poss[b] == 0) second1Poss[b] = lockNum;
					if(third1Poss[c] == 0) third1Poss[c] = lockNum;
					
					String add1 = first1Poss[a] + " " + second1Poss[b] + " " + third1Poss[c];
					result.add(add1);
				}
			}
		}
		
		return result;
	}
	
}
