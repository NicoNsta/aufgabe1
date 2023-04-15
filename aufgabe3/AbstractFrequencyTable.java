package aufgabe3;

import org.w3c.dom.ls.LSOutput;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable implements FrequencyTable {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
    public void add(String w) {
        add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable fq) {
		// Ihr Code:
		for (int i = 0; i < size(); i++) {
			if (fq.get(i) != null) {
				this.add(fq.get(i).getWord(), fq.get(i).getFrequency());
			}
		}
	}

	@Override
	public void collectMostFrequent(FrequencyTable fq) {
		// Ihr Code:
		int t = 0;
		fq.clear();
		if (this.isEmpty()) {
			return;
		}
		t = this.get(0).getFrequency();

		for (int j = 0; j < this.size(); j++) {
			if (this.get(j) != null && this.get(j).getFrequency() == t) {
				fq.add(get(j).getWord(), t);
			}
		}
	}

	@Override
	public void collectLeastFrequent(FrequencyTable fq) {
		// Ihr Code:
		fq.clear();
		if (this.isEmpty()) {
			return;
		}
		for (int i = this.size() - 1; i >= 0; i--) {
			if (this.get(i) != null && this.get(i).getFrequency() == 1) {
				fq.add(get(i).getWord());
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
		// Ihr Code:
//		if (this.isEmpty()) {
//			System.out.println("Table is empty");
//			System.exit(1);
//		}
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
