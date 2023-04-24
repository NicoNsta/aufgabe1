package aufgabe3;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 * importwein org.w3c.dom.ls.LSOutput;
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
    public void add(T w) {
        add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable <? extends T> fq) {
		for (var x : fq) {
			this.add(x.getElement(), x.getFrequency());
		}
	}

	@Override
	public void collectMostFrequent(FrequencyTable <? super T> fq) {
		fq.clear();
		if (this.isEmpty()) {
			return;
		}
		int t = this.get(0).getFrequency();

		for (var x : this) {
			if (x.getFrequency() == t) {
				fq.add(x.getElement(), t);
			}
		}
	}

	@Override
	public void collectLeastFrequent(FrequencyTable <? super T> fq) {
		// Ihr Code:
		fq.clear();
		if (this.isEmpty()) {
			return;
		}
		for (var x : this) {
			if (x != null && x.getFrequency() == 1) {
				fq.add(x.getElement());
			}
		}
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * @return String-Darstellung.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (var x : this) {
			s.append(x);
		}
		s.append(" size = ").append(this.size());

		return s.toString();
	}
}
