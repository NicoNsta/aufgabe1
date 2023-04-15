package aufgabe3;

import java.util.Arrays;

/**
 *
 * @author oliverbittel
 * @since 25.03.2021
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {
	private int size;
	private Word fqTable[];
	private final int DEFAULT_SIZE = 100;

	public ArrayFrequencyTable() {
        clear();
    }
	
	@Override
	public int size() {
		// throw muss noch auskommentiert werden!
		// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
//		this.size = 0;
//		for (int i = 0; i < this.fqTable.length; i++) {
//			if (this.fqTable[i] != null) {
//				size = this.size + 1;
////				System.out.println(fqTable[i])
		return this.size;
	}

	@Override
	public final void clear() {
		// throw muss noch auskommentiert werden!
		// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		size = 0;
		fqTable = new Word[DEFAULT_SIZE];
	}

	private void moveToLeft(int pos) {
		Word w = this.fqTable[pos];
		int i = pos - 1;
		while (i >= 0 && w.getFrequency() > this.fqTable[i].getFrequency()) {
			this.fqTable[i + 1] = this.fqTable[i];
			i--;
		}
		fqTable[i + 1] = w;
	}

	@Override
	public void add(String w, int f) {
		// throw muss noch auskommentiert werden!
		// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
//		System.out.println("Called");
//
		if (this.size == this.fqTable.length) {
			this.fqTable = Arrays.copyOf(this.fqTable, size() * 2);
			}


		if (this.isEmpty()){
			this.fqTable[0] = new Word(w, f);
			size++;
			return;
		}
//		for (int i = 0; i < this.size(); i++) {
//			if (this.fqTable[i] != null) {
//				if (this.fqTable[i].getWord().equals(w)) {
//					this.fqTable[i].addFrequency(f);
//					moveToLeft(i);
//					return;
//				}
//			} else {
//				this.fqTable[size()] = new Word(w, f);
//				moveToLeft(size());
//				size++;
//				return;
//			}
//		}
		for (int i = 0; i < this.size(); i++) {

			if (this.fqTable[i].getWord().equals(w)) {
				this.fqTable[i].addFrequency(f);
				moveToLeft(i);
				return;
			}
		}

		this.fqTable[size()] = new Word(w, f);
		moveToLeft(size());
		size++;
		return;
		}



	@Override
	public Word get(int pos) {
		// throw muss noch auskommentiert werden!
//		 throw new UnsupportedOperationException("Not supported yet.");
//		 To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		if (pos < 0 || pos >= size()) {
			return null;
		}
		return this.fqTable[pos];
	}

	@Override
	public int get(String w) {
		// throw muss noch auskommentiert werden!
		// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		for (int i = 0; i < this.fqTable.length; i++) {
			if (this.fqTable[i] != null && this.fqTable[i].getWord().equals(w)) {
				return fqTable[i].getFrequency();
			}
		}
		return 0;
	}
}
