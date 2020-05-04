package freqUsedAlg;

import java.util.Arrays;
import java.util.Comparator;

public class doubleComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pt[] pts = new pt[4];
		Arrays.sort(pts);
		Arrays.sort(pts, new ptCmpY());
	}
	
}

class pt implements Comparable<pt> {

    public int x;
    public int y;
	public boolean canRemove;

    public pt(int myx, int myy) {
        x = myx;
        y = myy;
    	canRemove = false;
    }

    public int compareTo(pt other) {
        return this.x - other.x;
    }
}

class ptCmpY implements Comparator<pt> {
	public int compare(pt a, pt b) {
		return a.y - b.y;
	}
}
