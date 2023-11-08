package prob3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestMartianVolumeComparator {
	public static void main(String[] args) {
		
		testSortedList();
		testMaxVolume();
		testMinVolume();
		testGreenMartianSearch_Success();
		testRedMartianSearch_Success();
		
	}
	
	// Sorts a list of Martians based on ID in ascending order
	public static void testSortedList() {
		List<Martian> martians = listBuilder();
		
		MartianVolumeComparator volComp = new MartianVolumeComparator();
		
		Collections.sort(martians, volComp);
		System.out.println("\n[testSortedList]\nSorted on Volume");
		System.out.println(martians.toString());
	}
	
	
	// Returns the Martian with the greatest ID value from a list
	public static void testMaxVolume() {
		List<Martian> martians = listBuilder();
		
		MartianVolumeComparator volComp = new MartianVolumeComparator();
		
		Martian mMax = Collections.max(martians, volComp);
		System.out.println("\n[testMaxVolume]\nMartian with largest volume: " + mMax);
	}
	
	
	// Returns the Martian with the least ID value from a list
	public static void testMinVolume() {
		List<Martian> martians = listBuilder();
		
		MartianVolumeComparator volComp = new MartianVolumeComparator();
		
		Martian mMin = Collections.min(martians, volComp);
		System.out.println("\n[testMinVolume]\nMartian with least volume: " + mMin);
	}
	
	
	// Utilize comparator to find a GreenMartian with a given ID
	public static void testGreenMartianSearch_Success() {
		List<Martian> martians = listBuilder();
		
		MartianVolumeComparator volComp = new MartianVolumeComparator();
		Collections.sort(martians, volComp);
		
		Martian key = new GreenMartian(-1, 2);

		int pos = Collections.binarySearch(martians, key, volComp);

		System.out.println("\n[testGreenMartianSearch_Success]\nMartian Volume searched for: " + key.getVolume());
		
		Martian m = martians.get(pos);
		System.out.println("Martian Match Found: " + m);		
	}
	
	
	// Utilize comparator to find a RedMartian with a given ID
	public static void testRedMartianSearch_Success() {
		List<Martian> martians = listBuilder();
		
		MartianVolumeComparator volComp = new MartianVolumeComparator();
		Collections.sort(martians, volComp);
		
		Martian key = new RedMartian(-1, 3, -1);

		int pos = Collections.binarySearch(martians, key, volComp);

		System.out.println("\n[testRedMartianSearch_Success]\nMartian Volume searched for: " + key.getVolume());
		
		Martian m = martians.get(pos);
		System.out.println("Martian Match Found: " + m);		
	}
	
	public static List<Martian> listBuilder() {
		List<Martian> martians = new LinkedList<>();

		martians.add(new GreenMartian(4, 2));
		martians.add(new RedMartian(9, 3, 1));
		martians.add(new GreenMartian(3, 7));
		
		return martians;
	}

}
