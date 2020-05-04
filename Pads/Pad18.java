package Pads;

import java.util.*;

public class Pad18 {
	public static void main(String[] args) {
		ArrayList<Cow> list = new ArrayList<>();
		list.add(new Cow(1, 2));
		list.add(new Cow(10, 11));
		
		ArrayList<Cow> list2 = new ArrayList<>();
		for(Cow c: list) {
			list2.add(c);
		}
		System.out.println(list.get(1).b);
		Cow curr =list2.remove(1);
		curr.b--;
		System.out.println(list.get(1).b);
	}
	
	static class Cow {
		int a, b;
		Cow(int aa, int bb) {
			a = aa;
			b = bb;
		}
	}
}
