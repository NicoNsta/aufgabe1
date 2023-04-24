package aufgabe3;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author oliverbittel
 * @since 25.03.2021
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
	private int size;
	private T[] fqTable;
	private static final int DEFAULT_SIZE = 100;

	public ArrayFrequencyTable() {
        clear();
    }
	
	@Override
	public int size() {
		// throw muss noch auskommentiert werden!
		// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		return this.size;
	}

	@Override
	@SuppressWarnings("unchecked")
	public final void clear() {
		// throw muss noch auskommentiert werden!
		// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		size = 0;
		fqTable = (T[]) new Element[DEFAULT_SIZE];
	}

	@SuppressWarnings("unchecked")
	private void moveToLeft(int pos) {
		T data = this.fqTable[pos];
		int i = pos - 1;
		while (i >= 0 && ((Element<Integer>) data).getFrequency() > ((Element<Integer>) this.fqTable[i]).getFrequency()) {
			this.fqTable[i + 1] = this.fqTable[i];
			i--;
		}
		fqTable[i + 1] = data;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void add(T data, int f) {
		// throw muss noch auskommentiert werden!
		// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:

		if (this.size == this.fqTable.length) {
			this.fqTable = Arrays.copyOf(this.fqTable, size() * 2);
			}


		if (this.isEmpty()){
			this.fqTable[0] = (T) new Element<>(data, f);
			size++;
			return;
		}

		for (int i = 0; i < this.size(); i++) {

			if (((Element<T>) this.fqTable[i]).getElement().equals(data)) {
				((Element<Integer>) this.fqTable[i]).addFrequency(f);
				moveToLeft(i);
				return;
			}
		}

		this.fqTable[size()] = (T) new Element<>(data, f);
		moveToLeft(size());
		size++;

		}



	@Override
	@SuppressWarnings("unchecked")
	public Element<T> get(int pos) {

		if (pos < 0 || pos >= size()) {
			return null;
		}
		return (Element<T>) this.fqTable[pos];
	}

	@Override
	@SuppressWarnings("unchecked")
	public int get(T data) {
		// throw muss noch auskommentiert werden!
		// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		for (T t : this.fqTable) {
			if (t != null && ((Element<T>) t).getElement().equals(data)) {
				return ((Element<Integer>) t).getFrequency();
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < this.size(); i++) {
			if (this.get(i) != null) {
				s.append(this.get(i));
			}
		}
		s.append("\nsize = ").append(this.size());


		return s.toString();
	}

	public Iterator<Element<T>> iterator() {
		return new ArrayFrequencyTableIterator();
	}

	private class ArrayFrequencyTableIterator implements Iterator<Element<T>> {
		private int pos = 0;

		@Override
		public boolean hasNext() {
			return pos < size();
		}

		@Override
		public Element<T> next() {
			return get(pos++);
		}
	}
}
