package freqUsedAlg;

public class segmentTree { // sum segtree
	public static int[] segtree,vals;
	public static int n;
	public static void main(String[] args) {
		n = 10;//will read in
		segtree = new int[3 * n];
		vals = new int[n];
		for(int i = 0; i < n; i++) {
			vals[i] = i;//will read in;
		}
		init();
		System.out.println(query(0, 1)); // should be 1
		System.out.println(query(0, 2)); // should be 3
		System.out.println(query(4, 5)); // should be 9
		System.out.println(query(3, 6)); // should be 18
		incUpdate(0, 10);
		System.out.println(query(0, 0));
	}
	static void init() { //runtime O(n) <- will go to all 2*n nodes once
		init(1, 0, n - 1);
	}
	static int query(int l, int r) {
		return query(1, 0, n - 1, l, r);
	}
	static void incUpdate(int indInVal, int v) {//v will be used to ADD to current value
		vals[indInVal] += v; 
		update(1, 0, n - 1, indInVal, v);
	}
	static void replaceUpdate(int indInVal, int v) {
		incUpdate(indInVal, v - vals[indInVal]);
	}
	static int query(int ind, int a, int b, int l, int r) {
		if(a >= l && b <= r) return segtree[ind];
		int mid = (a + b)/2;
		int out = 0;
		if(l <= mid) out += query(ind*2, a, mid, l, r);
		if(r > mid) out += query(ind*2 + 1, mid + 1, b, l, r);
		return out;
	}
	static void update(int ind, int a, int b, int indInVal, int v) { //inc
		segtree[ind] += v;
		if(a == b) return;
		int mid = (a + b)/2;
		if(indInVal <= mid) update(ind * 2, a, mid, indInVal, v);
		if(indInVal > mid) update(ind * 2 + 1, mid + 1, b, indInVal, v);
		
	}
	static int init(int ind, int a, int b) { //ind is index in segtree, a and b is the range that segtree[ind] reprsents in vals
		if(a != b) return segtree[ind] = init(ind * 2, a, (a + b)/2) + init(ind * 2 + 1, (a + b)/2 + 1, b);
		return segtree[ind] = vals[a];
	}
}

