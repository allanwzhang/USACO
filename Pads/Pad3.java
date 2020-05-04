package Pads;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pad3 {
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
		
		List<int[]> allFarmerCombos = findAllCombos(farmerCombo, lockNum);
		List<int[]> allMasterCombos = findAllCombos(masterCombo, lockNum);
		
		int[] arr = new int[] {masterCombo.get(0), masterCombo.get(1), masterCombo.get(2)};
		
		allFarmerCombos.add(new int[] {farmerCombo.get(0), farmerCombo.get(1), farmerCombo.get(2)});
		if(!isDup(allMasterCombos, arr)) allMasterCombos.add(arr);
		
		for(int i = 0; i < allFarmerCombos.size(); i++) {
			if(!isDup(allMasterCombos, allFarmerCombos.get(i))) {
				allMasterCombos.add(allFarmerCombos.get(i));
			}
		}
		
		for(int i = 0; i < allMasterCombos.size(); i++) {
			int[] result = allMasterCombos.get(i);
			System.out.println(result[0] + " " + result[1] + " " + result[2]);
		}
		
		out.println(allMasterCombos.size());
		
		out.close();
		f.close();
	}
	
	static List<int[]> findAllCombos(List<Integer> farmerCombo, int lockNum){
		int first = farmerCombo.get(0);
		int second = farmerCombo.get(1);
		int third = farmerCombo.get(2);
		
		int[] firstPoss = new int[] {(first - 2 + lockNum) % lockNum, (first - 1 + lockNum) % lockNum, (first + lockNum) % lockNum, (first + 1 + lockNum) % lockNum, (first + 2 + lockNum) % lockNum}; 
		int[] secondPoss = new int[] {(second - 2 + lockNum) % lockNum, (second - 1 + lockNum) % lockNum, (second + lockNum) % lockNum, (second + 1 + lockNum) % lockNum, (second + 2 + lockNum) % lockNum};
		int[] thirdPoss = new int[] {(third - 2 + lockNum) % lockNum, (third - 1 + lockNum) % lockNum, (third + lockNum) % lockNum, (third + 1 + lockNum) % lockNum, (third + 2 + lockNum) % lockNum};
		
		List<int[]> result = new ArrayList<>(); 
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 5; k++) {
					if(firstPoss[i] == 0) firstPoss[i] = lockNum;
					if(secondPoss[i] == 0) secondPoss[j] = lockNum;
					if(thirdPoss[i] == 0) thirdPoss[k] = lockNum;
					
					int[] arr = new int[] {firstPoss[i], secondPoss[j], thirdPoss[k]}; 
					if(!isDup(result,arr)) result.add(arr);
				}
			}
		}
		
		return result;
	}
	
	static boolean isDup(List<int[]> list, int[] arr) {
		for(int i = 0; i < list.size(); i++) {
			if(Arrays.equals(list.get(i), arr)) {
				return true;
			}
		}
		return false;
	}
}
