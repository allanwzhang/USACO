package freqUsedAlg;

import java.util.*;

public class sortingInsteadOfComparable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Event[] people = new Event[0];
		
		//lambda expression
		
		Arrays.sort(people, (Event a, Event b) -> a.time == b.time ? a.type - b.type : a.time - b.time);
		TreeSet<Event> ts = new TreeSet<Event> ((Event a, Event b) -> a.time == b.time ? a.type - b.type : a.time - b.time);
		System.out.println(ts);
	}
	
	static class Event {
		int time, type;
	}

}
