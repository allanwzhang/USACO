package Pads;

public class Pad12 {

	public static void main(String[] args) {
		char[][] maze = new char[1][1];
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		boolean found1 = false;
		for(int i = 0; i < maze[0].length; i++) {
			 if(maze[0][i] == ' ') {
				if(!found1) {
					found1 = true;
					x1 = 0;
					y1 = i;
				} else {
					x2 = 0;
					y2 = i;
					break;
				}
			 } else if(maze[maze.length - 1][i] == ' ') {
				 if(!found1) {
						found1 = true;
						x1 = maze.length - 1;
						y1 = i;
					} else {
						x2 = maze.length - 1;
						y2 = i;
						break;
					}
			 }
		 }
		System.out.println(x1*x2*y1*y2);
	}

}
