package Section_2_4;
/*
//ID: allanwz1
LANG: JAVA
TASK: ttwo
*/

import java.io.*;

public class ttwo {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
	
		 char[][] obstacles = new char[10][10];
		 
		 Node farmer = new Node(0, 0, 0);
		 Node cow = new Node(0, 0, 0);
		 
		 for(int i = 0; i < 10; i++) {
			 obstacles[i] = f.readLine().toCharArray();
			 for(int j = 0; j < obstacles[i].length; j++) {
				 if(obstacles[i][j] == 'F') {
					 farmer.y = i;
					 farmer.x = j;
					 obstacles[i][j] = '.';
					 break;
				 }
				 if(obstacles[i][j] == 'C') {
					 cow.y = i;
					 cow.x = j;
					 obstacles[i][j] = '.';
					 break;
				 }
			 }
		 }
		 
		 
		 int count = 0;
		 
		 while(count < 160000) {
			 if(farmer.x == cow.x && farmer.y == cow.y) {
				 break;
			 }
			 
			 move(obstacles, farmer);
			 move(obstacles, cow);
			 count++;
		 }
		 
		 if(count == 160000) {
			 out.println(0);
			 System.out.println(0);
		 } else {
			 System.out.println(count);
			 out.println(count);
		 }
		
		 out.close();
		 f.close();
	}
	
	//0 = north
	//1 = east
	//2 = south
	//3 = west
	
	//grid:
	// 0 1 2 3 4 5 6 7 8 9
	// 1
	// 2
	// 3
	// 4
	// ...
	
	static void move(char[][] obs, Node n) {
		if(isObs(obs, n)) {
			n.dir = (n.dir + 1) % 4;
			return;
		} else {
			if(n.dir == 0) {
				n.y--;
				return;
			}
			if(n.dir == 1) {
				n.x++;
				return;
			}
			if(n.dir == 2) {
				n.y++;
				return;
			}
			if(n.dir == 3) {
				n.x--;
				return;
			}
		}
	}
	
	static boolean isObs(char[][] obs, Node n) {
		if(n.dir == 0) {
			if(n.y == 0 || obs[n.y - 1][n.x] == '*') {
				return true;
			}
		}
		if(n.dir == 1) {
			if(n.x == 9 || obs[n.y][n.x + 1] == '*') {
				return true;
			}
		}
		if(n.dir == 2) {
			if(n.y == 9 || obs[n.y + 1][n.x] == '*') {
				return true;
			}
		}
		if(n.dir == 3) {
			if(n.x == 0 || obs[n.y][n.x - 1] == '*') {
				return true;
			}
		}
		return false;
	}
	
	static class Node {
		int dir;
		int x, y;
		
		Node(int xx, int yy, int d) {
			x = xx;
			y = yy;
			dir = d;
		}
	}
}
