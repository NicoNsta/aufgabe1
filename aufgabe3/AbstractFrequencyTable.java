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
	@SuppressWarnings("unchecked")
	public void addAll(T fq) {
		// Ihr Code:
		for (int i = 0; i < size(); i++) {
			if (((FrequencyTable<T>) fq).get(i) != null) {
				this.add(((FrequencyTable<T>) fq).get(i).getElement(), ((FrequencyTable<T>) fq).get(i).getFrequency());
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void collectMostFrequent(T fq) {
		// Ihr Code:
		int t = 0;
		((FrequencyTable<T>) fq).clear();
		if (this.isEmpty()) {
			return;
		}
		t = this.get(0).getFrequency();

		for (int j = 0; j < this.size(); j++) {
			if (this.get(j) != null && this.get(j).getFrequency() == t) {
				((FrequencyTable<T>) fq).add(get(j).getElement(), t);
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void collectLeastFrequent(T fq) {
		// Ihr Code:
		((FrequencyTable<T>) fq).clear();
		if (this.isEmpty()) {
			return;
		}
		for (int i = this.size() - 1; i >= 0; i--) {
			if (this.get(i) != null && this.get(i).getFrequency() == 1) {
				((FrequencyTable<T>) fq).add(get(i).getElement());
			} else {
				break;
			}
		}
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * @return String-Darstellung.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("");

		s.append("{");
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i) != null) {
				s.append(this.get(i) +", ");
			}
		}
		s.append("}").append(" size = " + this.size());

		return s.toString();
	}
}
