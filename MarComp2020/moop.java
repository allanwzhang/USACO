package MarComp2020;
/*
//ID: allanwz1
LANG: JAVA
TASK: moop
*/

import java.io.*;
import java.util.*;

public class moop {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("moop.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
		 
		 int numParticles = Integer.parseInt(f.readLine());
		 
		 ArrayList<Particle> particles = new ArrayList<>();
		 
		 for(int i = 0; i < numParticles; i++) {
			 String[] curr = f.readLine().split(" ");
			 particles.add(new Particle(Integer.parseInt(curr[0]), Integer.parseInt(curr[1])));
		 }
		 
		 Collections.sort(particles);
		 
		 for(int i = 0; i < particles.size(); i++) {
			 Particle curr = particles.get(i);
			 int currY = particles.get(i).y;
			 Particle lastP = particles.get(i);
			 int lastIndex = -1;
			 for(int j = 0; j < i; j++) {
				 if(currY >= particles.get(j).y) {
					 lastP = particles.remove(j);
					 lastIndex = j;
					 i--;
					 j--;
				 }
			 }
			 if(lastIndex == -1) continue;
			 particles.add(lastIndex, lastP);
			 particles.remove(curr);
		 }
		 
		 System.out.println(particles.size());
		 out.println(particles.size());
		 
		 out.close();
		 f.close();
	}

	static class Particle implements Comparable<Particle> {
		int x;
		int y;
		public Particle(int xx, int yy) {
			x = xx;
			y = yy;
		}
		
		@Override
		public int compareTo(Particle p) {
			if(this.x == p.x) return this.y - p.y;
			return this.x - p.x;
		}
		
	}
}
