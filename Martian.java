package prob3;

public abstract class Martian implements Comparable<Martian> {
	private int id;
	private int volume;
	
	public Martian(int id, int volume) { this.id = id; this.volume = volume; }
	
	@Override
	public int compareTo(Martian other) {
		int diff = this.id - other.id;
		if(diff>0) return 1;
		if(diff<0) return -1;
		else return 0;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Martian) {
			Martian other = (Martian)o;
			return this.id == other.id;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}
	public int getVolume() {
		return volume;
	}
	
	
	public void setVolume(int vol) {
		this.volume = vol;
	}
	
	public abstract int power();
	
	public abstract String speak();
	
	@Override
	public String toString() {
		String msg = String.format("id=%d, vol=%d", id, volume);
		return msg;
	}

}
