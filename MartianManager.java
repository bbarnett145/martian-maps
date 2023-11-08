package prob3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MartianManager {
	protected HashMap<Integer, Martian> martians = new HashMap<>();
	protected HashMap<Integer, Teleporter> teleporters = new HashMap<>();
	
	public MartianManager() {}
	
	// Add Martian to HashMap martians, if the Martian is a Teleporter, add to Teleporter map.
	public boolean addMartian(Martian m) {
		if(martians.containsKey(m.getId())) {
			return false;
		}
		martians.put(m.getId(), m);
		if(m instanceof Teleporter t) {
			teleporters.put(m.getId(), t);
		}
		return true;
	}
	
	// Commence a battle between an accepted list of Martian invaders and the current list of Martians
	// Deaths are determined by power calculations-- killed Martians are stored and returned in a list, and removed from the list of Martians
	public ArrayList<Martian> battle(ArrayList<Martian> invaders) {
		ArrayList<Martian> killList = new ArrayList<>();
		for(Martian i : invaders) {
			for(int key : martians.keySet()) {
				Martian m = martians.get(key);
				if(getPower(m) < getPower(i)) {
					killList.add(m);
					martians.remove(m);
					break;
				}
			}
		}
		return killList;
	}
	
	// Check if a Martian with a certain id already exists in the list
	public boolean contains(int id) {
		if(martians.containsKey(id)) {
			return true;
		}
		return false;
	}
	
	
	
	// Returns the Martian closest to the given id
	public Martian getMartianClosestTo(Martian martian) {
		int id = martian.getId();
		return getMartianClosestTo(id);
	}
	
	public Martian getMartianClosestTo(int id) {
		int closestDiff = Integer.MAX_VALUE;
		Martian closestM = null;
		for(int key : martians.keySet()) {
			Martian m = martians.get(key);
			if(Math.abs(m.getId() - id) < closestDiff) {
				closestDiff = Math.abs(m.getId() - id);
				closestM = m;
			}
		}
		return closestM;
	}
	
	// Returns the Martian with a specified id, if valid
	public Martian getMartian(int id) {
		if(!martians.containsKey(id)) {
			return null;
		}
		return martians.get(id);
//		GreenMartian dummy = new GreenMartian(id, 0);
//		int index = martians.indexOf(dummy);
//		return martians.get(index);
	}
	
	// Returns number of Martians in the list martians
	public int getNumMartians() {
		return martians.size();
	}
	
	// Returns number of Teleporters in the list martians
	public int getNumTeleporters() {
		int num = 0;
		for(int key : martians.keySet()) {
			if(martians.get(key) instanceof GreenMartian gm) {
				num++;
			}
		}
		return num;
	}
	
	/***
	 * Returns a sorted list of martians using the Comparator specified by sortType.
	 * @param sortType The type of sort to do. Valid values are "ID" and "VOLUME".
	 * @return Sorted list of Martians either by ID or VOLUME.
	 */
	public ArrayList<Martian> getSortedMartians(String sortType) {
		ArrayList<Martian> sorted = new ArrayList<>();
		for(int key : martians.keySet()) {
			sorted.add(martians.get(key));
		}
		if(sortType.equals("ID")) {
			sorted.sort(new MartianIdComparator());
		}
		else if(sortType.equals("VOLUME")) {
			sorted.sort(new MartianVolumeComparator());
		}
		else {
			return null;
		}
		return sorted;
		
	}
	
	// Returns the teleporter with the given id
	public Teleporter getTeleporter(int id) {
		return teleporters.get(id);
	}
	
	/**
	 * Increases the volume of any existing Teleporter objects below the threshold by 1.
	 * @param idThreshold The number for determining which Teleporters are modified. Any Teleporter below idThreshold will be modified.
	 */
	public void increaseTeleporterVolume(int idThreshold) {
		for(int key : teleporters.keySet()) {
			if(key < idThreshold) {
				int newVol = ((Martian) teleporters.get(key)).getVolume() + 1;
				((Martian) teleporters.get(key)).setVolume(newVol);
			}
		}
	}

	
	// Returns a string of all Martians speaking at once
	public String groupSpeak() {
		String msg = "";
		for(int key : martians.keySet()) {
			Martian m = martians.get(key);
			msg += m.speak() + "\n";
		}
		return msg;
	}
	
	// Returns a string of all Teleporters going to their destination
	public String groupTeleport(String dest) {
		String msg = "";
		for(int key : teleporters.keySet()) {
			Teleporter t = teleporters.get(key);
			msg += t.teleport(dest) + "\n";
		}
		return msg;
	}
	
	// Removes all Teleporters from the martians and teleporters lists
	public void obliterateTeleporters() {
		for(int key : teleporters.keySet()) {
			Teleporter t = teleporters.get(key);
			martians.remove(key);
		}
		teleporters.clear();
	}
	
	
	// Removes and returns a martian with the given id
	public Martian removeMartian(int id) {
		return martians.remove(id);
	}
	
	
	// Helper method for battle
	public int getPower(Martian m) {
		return m.power();
	}
	
	@Override
	public String toString() {
		String msg = "Martians:\n";
		for(int key : martians.keySet()) {
			msg += martians.get(key).toString() + "\n";
		}
		msg += "\nTeleporters:\n";
		for(int key : martians.keySet()) {
			if(martians.get(key) instanceof Teleporter t) {
				msg += t.toString() + "\n";
			}
		}
		return msg;
	}

}
