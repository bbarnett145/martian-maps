package prob3;

import java.util.Comparator;

public class MartianVolumeComparator implements Comparator<Martian> {

	@Override
	public int compare(Martian m1, Martian m2) {
		return m1.getVolume() - m2.getVolume();
	}

}
