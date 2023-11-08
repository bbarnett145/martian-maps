package prob3;

public class GreenMartian extends Martian implements Teleporter {
	
	public GreenMartian(int id) { super(id, 1); }
	public GreenMartian(int id, int volume) { super(id, volume); }
	
	public String speak() {
		return "id=" + getId() + ", Grobldy Grock";
	}
	
	public String teleport(String dest) {
		return "id=" + getId() + " teleporting to " + dest;
	}
	
	@Override
	public int power() {
		int power = getVolume() * 3;
		return power;
	}
	
	@Override
	public String toString() {
		String msg = String.format("Green Martian - id=%d, vol=%d", getId(), getVolume());
		return msg;
	}

}
