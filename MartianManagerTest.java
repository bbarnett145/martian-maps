package prob3;
import java.util.ArrayList;

public class MartianManagerTest {
	
	public static void main(String[] args) {
		testAddMartian_Red_Success();
		testAddMartian_Green_Success();
		testAddMartian_RedGreen_Failure();
		testAddMartian_GreenRed_Failure();
		testContains_Success();
		testContains_Failure();
		testGetMartianClosestTo_Index_LowerMatch();
		testGetMartianClosestTo_Martian_LowerMatch();
		testGetMartianWithId_Success();
		testGetMartianWithId_Failure();
		testGetSortedMartians_ID();
		testGetSortedMartians_VOLUME();
		testGetTeleporterAt_ValidIndex();
		testGetTeleporterAt_InvalidIndex_Low();
		testGetTeleporterAt_InvalidIndex_High();
		testGroupSpeak();
		testGroupTeleport();
		testObliterateTeleporters_One();
		testObliterateTeleporters_Many();
		testRemoveMartianWithId_Success_Red();
		testRemoveMartianWithId_Success_Green();
		testRemoveMartianWithId_Failure();
		testToString();
		testBattle_Small();
		testBattle_Larger();
		testIncreaseTeleporterVolume();
	}
	
	
	// Adding a RedMartian to the MartianManager
	public static void testAddMartian_Red_Success() {
		MartianManager MM = new MartianManager();
		RedMartian m1 = new RedMartian(501, 90, 5);
		System.out.println("[testAddMartian_Red_Success]");
		System.out.println(MM.addMartian(m1));
	}
	
	// Adding a GreenMartian to the MartianManager
	public static void testAddMartian_Green_Success() {
		MartianManager MM = new MartianManager();
		GreenMartian m1 = new GreenMartian(913, 45);
		System.out.println("[testAddMartian_Green_Success");
		System.out.println(MM.addMartian(m1));
	}
	
	// Attempting to add a Martian that already exists
	public static void testAddMartian_RedGreen_Failure() {
		MartianManager MM = new MartianManager();
		RedMartian m1 = new RedMartian(510, 45, 2);
		GreenMartian m2 = new GreenMartian(510, 30);
		MM.addMartian(m1);
		System.out.println("[testAddMartian_RedGreen_Failure]");
		System.out.println(MM.addMartian(m2));
	}
	
	// Attempting to add a Martian that already exists
	public static void testAddMartian_GreenRed_Failure() {
		MartianManager MM = new MartianManager();
		GreenMartian m1 = new GreenMartian(510, 30);
		RedMartian m2 = new RedMartian(510, 45, 2);
		MM.addMartian(m1);
		System.out.println("[testAddMartian_GreenRed_Failure]");
		System.out.println(MM.addMartian(m2));
	}
	
	// Verify contains method with id that does not exist
	public static void testContains_Success() {
		MartianManager MM = MBuilder();
		System.out.println("[testContains_Success]");
		System.out.println(MM.contains(6));
	}
	
	// Verify contains method with id that already exists
	public static void testContains_Failure() {
		MartianManager MM = MBuilder();
		System.out.println("[testContains_Failure]");
		System.out.println(MM.contains(3));
	}
	
	// Testing a small scale battle
	public static void testBattle_Small() {
		MartianManager MM = new MartianManager();
		MM.addMartian(new GreenMartian(1, 3)); // power = 9
		MM.addMartian(new RedMartian(2, 5, 2)); // power = 12
		MM.addMartian(new RedMartian(4, 3, 3)); // power = 9
		MM.addMartian(new GreenMartian(3, 2)); // power = 6
		ArrayList<Martian> invaders = new ArrayList<>();
		invaders.add(new GreenMartian(1, 3)); // power = 9
		invaders.add(new RedMartian(2, 1, 1)); // power = 3
		System.out.println("[testBattle_Small]");
		// Should kill a GreenMartian with id = 3 and vol = 2.
		System.out.println("KILLED MARTIANS\n-----\n" + MM.battle(invaders));
		System.out.println("SURVIING MARTIANS\n-----\n" + MM.toString());
	}
	
	// Testing a larger scale battle
	public static void testBattle_Larger() {
		MartianManager MM = new MartianManager();
		MM.addMartian(new RedMartian(1, 3, 0)); // power = 6
		MM.addMartian(new RedMartian(2, 5, 2)); // power = 12
		MM.addMartian(new RedMartian(4, 3, 3)); // power = 9
		MM.addMartian(new GreenMartian(3, 2)); // power = 6
		MM.addMartian(new GreenMartian(5, 1)); // power = 3
		ArrayList<Martian> invaders = new ArrayList<>();
		invaders.add(new GreenMartian(1, 4)); // power = 8
		invaders.add(new RedMartian(2, 1, 3)); // power = 4
		invaders.add(new GreenMartian(3, 1)); // power = 1
		System.out.println("[testBattle_Larger]");
		// Should kill a GreenMartian (id 5) and a RedMartian (id 1)
		System.out.println("KILLED MARTIANS\n-----\n" + MM.battle(invaders));
		System.out.println("SURVIING MARTIANS\n-----\n" + MM.toString());
	}
	
	// Find the Martian closest to a given id
	public static void testGetMartianClosestTo_Index_LowerMatch() {
		MartianManager MM = new MartianManager();
		MM.addMartian(new RedMartian(1, 2, 1));
		MM.addMartian(new GreenMartian(3, 1));
		MM.addMartian(new RedMartian(8, 3, 2));
		MM.addMartian(new GreenMartian(13, 3));
		System.out.println("[testGetMartianClosestTo_Index_LowerMatch]");
		// Should return the GreenMartian with id = 3 and then RedMartian with id = 8
		System.out.println("Case One (Index 4) - " + MM.getMartianClosestTo(4));
		System.out.println("Case Two (Index 6) - " + MM.getMartianClosestTo(8));
	}
	
	// Find the Martian closest to the id of a given Martian
	public static void testGetMartianClosestTo_Martian_LowerMatch() {
		MartianManager MM = new MartianManager();
		GreenMartian reference = new GreenMartian(6, 1);
		MM.addMartian(new RedMartian(1, 2, 1));
		MM.addMartian(new GreenMartian(3, 1));
		MM.addMartian(new RedMartian(8, 3, 2));
		MM.addMartian(new GreenMartian(13, 3));
		System.out.println("[testGetMartianClosestTo_Martian_LowerMatch]");
		// Should return the RedMartian with id = 8
		System.out.println(MM.getMartianClosestTo(reference));
	}
	
	// Retrieve Martian with a specified id, if valid
	public static void testGetMartianWithId_Success() {
		MartianManager MM = MBuilder();
		System.out.println("[testGetMartianWithId_Success]");
		// Should return RedMartian with vol = 3, ten = 3
		System.out.println(MM.getMartian(4));
	}
	
	// Unsuccessful retrieval of Martian with an invalid id
	public static void testGetMartianWithId_Failure() {
		MartianManager MM = MBuilder();
		System.out.println("[testGetMartianWithId_Failure]");
		System.out.println(MM.getMartian(9));
	}
	
	// Test .sort(Comparator) to sort and return Martians by id, ascending
	public static void testGetSortedMartians_ID() {
		MartianManager MM = new MartianManager();
		MM.addMartian(new GreenMartian(4, 0));
		MM.addMartian(new GreenMartian(8, 1));
		MM.addMartian(new GreenMartian(1, 1));
		MM.addMartian(new GreenMartian(2, 3));
		MM.addMartian(new RedMartian(2, 5, 1)); // Duplicate ID, will not be added.
		System.out.println("[testGetSortedMartians_ID]");
		System.out.println("Sorted Martians - " + MM.getSortedMartians("ID"));
		System.out.println("Original List - " + MM.toString());
	}
	
	// Test .sort(Comparator) to sort and return Martians by volume, ascending
	public static void testGetSortedMartians_VOLUME() {
		MartianManager MM = new MartianManager();
		MM.addMartian(new GreenMartian(4, 0));
		MM.addMartian(new GreenMartian(8, 1));
		MM.addMartian(new GreenMartian(1, 1));
		MM.addMartian(new GreenMartian(2, 3));
		MM.addMartian(new RedMartian(6, 9, 4));
		System.out.println("[testGetSortedMartians_VOLUME]");
		System.out.println("Sorted Martians - " + MM.getSortedMartians("VOLUME"));
		System.out.println("Original List - " + MM.toString());
	}
	
	// Successful retrieval of a Teleporter at valid index
	public static void testGetTeleporterAt_ValidIndex() {
		MartianManager MM = MBuilder();
		System.out.println("[testGetTeleporterAt_ValidIndex]");
		System.out.println(MM.getTeleporter(1));
	}
	
	// Unsuccessful retrieval at a negative index
	public static void testGetTeleporterAt_InvalidIndex_Low() {
		MartianManager MM = MBuilder();
		System.out.println("[testGetTeleporterAt_InvalidIndex_Low]");
		System.out.println(MM.getTeleporter(-1));
	}
	
	// Unsuccessful retrieval at too high of an index
	public static void testGetTeleporterAt_InvalidIndex_High() {
		MartianManager MM = MBuilder();
		System.out.println("[testGetTeleporterAt_InvalidIndex_High]");
		System.out.println(MM.getTeleporter(100));
	}
	
	// Verify groupSpeak outputs all Martians speaking
	public static void testGroupSpeak() {
		MartianManager MM = MBuilder();
		System.out.println("[testGroupSpeak]");
		System.out.println(MM.groupSpeak());
	}
	
	// Verify groupTeleport outputs all Teleporters going to their destination
	public static void testGroupTeleport() {
		MartianManager MM = MBuilder();
		System.out.println("[testGroupTeleport]");
		System.out.println(MM.groupTeleport("Jupiter"));
	}
	
	// Remove a Teleporter and verify that it worked
	public static void testObliterateTeleporters_One() {
		MartianManager MM = new MartianManager();
		MM.addMartian(new GreenMartian(1,0));
		MM.addMartian(new RedMartian(2,0,0));
		MM.addMartian(new RedMartian(3,0));
		System.out.println("[testObliterateTeleporters_One]");
		System.out.println("Before - " + MM.toString());
		MM.obliterateTeleporters();
		System.out.println("After - " + MM.toString());
	}
	
	// Remove all Teleporters and verify that it worked
	public static void testObliterateTeleporters_Many() {
		MartianManager MM = MBuilder();
		MM.addMartian(new GreenMartian(6, 0));
		System.out.println("[testObliterateTeleporters_Many]");
		System.out.println("Before - " + MM.toString());
		MM.obliterateTeleporters();
		System.out.println("After - " + MM.toString());
	}
	
	// Remove a red martian and verify
	public static void testRemoveMartianWithId_Success_Red() {
		MartianManager MM = MBuilder();
		System.out.println("[testRemoveMartianWithId_Success_Red]");
		System.out.println("Before - " + MM.toString());
		MM.removeMartian(6);
		System.out.println("After - " + MM.toString());
	}
	
	// Remove a green martian and verify
	public static void testRemoveMartianWithId_Success_Green() {
		MartianManager MM = MBuilder();
		System.out.println("[testRemoveMartianWithId_Success_Green]");
		System.out.println("Before - " + MM.toString());
		MM.removeMartian(1);
		System.out.println("After - " + MM.toString());
	}
	
	// Attempt to remove an invalid id and verify
	public static void testRemoveMartianWithId_Failure() {
		MartianManager MM = MBuilder();
		System.out.println("[testRemoveMartianWithId_Failure]");
		System.out.println(MM.removeMartian(9));
	}
	
	// Verify toString
	public static void testToString() {
		MartianManager MM = MBuilder();
		System.out.println("[testToString]");
		System.out.println(MM.toString());
	}
	
	// Verify that all GreenMartians with ID < 5 will have their volume increased by 1.
	public static void testIncreaseTeleporterVolume() {
		MartianManager MM = new MartianManager();
		MM.addMartian(new GreenMartian(4, 0)); // New vol = 1
		MM.addMartian(new GreenMartian(8, 1)); // Vol remains = 1
		MM.addMartian(new GreenMartian(1, 1)); // New vol = 2
		MM.addMartian(new GreenMartian(2, 3)); // New vol = 4
		MM.addMartian(new RedMartian(6, 1, 9)); // Not a teleporter, vol unchanged
		System.out.println("[testIncreaseTeleporterVolume]");
		System.out.println("Original Values - " + MM.toString());
		MM.increaseTeleporterVolume(5);
		System.out.println("After Teleporter Modification - " + MM.toString());
	}
	
	// Helper method that adds 5 Martians to a MartianManager
	public static MartianManager MBuilder() {
		MartianManager MM = new MartianManager();
		MM.addMartian(new RedMartian(6, 3, 0)); 
		MM.addMartian(new RedMartian(2, 5, 2));
		MM.addMartian(new RedMartian(4, 3, 3));
		MM.addMartian(new GreenMartian(1, 2));
		MM.addMartian(new GreenMartian(5, 1));
		return MM;
	}

}
