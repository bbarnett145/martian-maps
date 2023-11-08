package prob3;

public class RedMartian extends Martian {
	private int tenacity;
	
	public RedMartian(int id, int tenacity) {
		super(id, 1);
		this.tenacity = tenacity;
	}
	public RedMartian(int id, int volume, int tenacity) {
		super(id, volume);
		this.tenacity = tenacity;
	}
	
	public int getTenacity() {
		return tenacity;
	}
	
	public String speak() {
		return "id=" + getId() + ", Rubldy Rock";
	}
	
	@Override
	public int power() {
		int power = getVolume() * 2 + getTenacity();
		return power;
	}
	
	@Override
	public String toString() {
		String msg = String.format("Red Martian - id=%d, vol=%d, ten=%d", getId(), getVolume(), tenacity);
		return msg;
	}

}
