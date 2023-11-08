package prob3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestMartianIdComparator {
	public static void main(String[] args) {
		
		testSortedList();
		testMaxID();
		testMinID();
		testGreenMartianSearch_Success();
		testRedMartianSearch_Success();
		
	}
	
	// Sorts a list of Martians based on ID in ascending order
	public static void testSortedList() {
		List<Martian> martians = listBuilder();
		
		MartianIdComparator idComp = new MartianIdComparator();
		
		Collections.sort(martians, idComp);
		System.out.println("\n[testSortedList]\nSorted on ID");
		System.out.println(martians.toString());;
	}
	
	
	// Returns the Martian with the greatest ID value from a list
	public static void testMaxID() {
		List<Martian> martians = listBuilder();
		
		MartianIdComparator idComp = new MartianIdComparator();
		
		Martian mMax = Collections.max(martians, idComp);
		System.out.println("\n[testMaxID]\nMartian with largest ID: " + mMax);
	}
	
	
	// Returns the Martian with the least ID value from a list
	public static void testMinID() {
		List<Martian> martians = listBuilder();
		
		MartianIdComparator idComp = new MartianIdComparator();
		
		Martian mMin = Collections.min(martians, idComp);
		System.out.println("\n[testMinID]\nMartian with least ID: " + mMin);
	}
	
	
	// Utilize comparator to find a GreenMartian with a given ID
	public static void testGreenMartianSearch_Success() {
		List<Martian> martians = listBuilder();
		
		MartianIdComparator idComp = new MartianIdComparator();
		Collections.sort(martians, idComp);
		
		Martian key = new GreenMartian(3, -1);

		int pos = Collections.binarySearch(martians, key, idComp);

		System.out.println("\n[testGreenMartianSearch_Success]\nMartian ID searched for: " + key.getId());
		
		Martian m = martians.get(pos);
		System.out.println("Martian Match Found: " + m);		
	}
	
	
	// Utilize comparator to find a RedMartian with a given ID
	public static void testRedMartianSearch_Success() {
		List<Martian> martians = listBuilder();
		
		MartianIdComparator idComp = new MartianIdComparator();
		Collections.sort(martians, idComp);
		
		Martian key = new RedMartian(9, -1, -1);

		int pos = Collections.binarySearch(martians, key, idComp);

		System.out.println("\n[testRedMartianSearch_Success]\nMartian ID searched for: " + key.getId());
		
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
