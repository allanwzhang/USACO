package freqUsedAlg;

public class floodfill {

	public static void main(String[] args) {
		int n = 5;
		int[][] arr = new int[n][n];
		//find how large the region of 1s is:
		//1 1 1 1 1
		//0 0 1 1 1
		//0 0 0 1 0
		//0 0 1 1 0
		//0 0 0 0 0
		ff(arr);
	}

	static int ff(int[][] array) {
	    int rows = array.length;
	    int cols = array[0].length;
	    boolean[][] flooded = new boolean[rows][cols];
	    return ff(array, 0, 0, flooded);
	  }
	  
	  // flooded[i][j] denotes whether cell at row i, column j has already been flooded
	 static int ff(int[][] array, int r, int c, boolean[][] flooded) {
		 int rows = array.length;
		 int cols = array[0].length;
	     if(0 <= r && r < rows && 0 <= c && c < cols && !flooded[r][c] && array[r][c] == array[0][0]) {
	    	 int count = 1;
	    	 flooded[r][c] = true;
	    	 count += ff(array, r+1, c, flooded);
	    	 count += ff(array, r-1, c, flooded);
	    	 count += ff(array, r, c+1, flooded);
	    	 count += ff(array, r, c-1, flooded);
	    	 return count;
	     } else {
	    	 return 0;
	     }
	  }
	
}
