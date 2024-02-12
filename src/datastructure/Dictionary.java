package datastructure;

public class Dictionary {
	public class DictionaryPair implements Comparable {
		private Object key;
		private Object value;

		public DictionaryPair(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public Object getKey() {
			return key;
		}

		public void setKey(Object key) {
			key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			value = value;
		}

		public int compareTo(Object o) {
			DictionaryPair p2 = (DictionaryPair) o;
			return ((Comparable) key).compareTo(p2.key);
		}

		public String toString() {
			String s = "The product ";
			s += key;
			s += " quantity is ";
			s += value;
			return s;

		}
	}

	Vector data = new Vector(100);

	public Dictionary() {

	}

	public void add(Object key, Object value) {
		DictionaryPair pair = new DictionaryPair(key, value);
		data.addLast(pair);

	}

	public Object getKey(int i) {
		return ((DictionaryPair) data.get(i)).key;

	}

	public Object getValue(int i) {
		return ((DictionaryPair) data.get(i)).value;

	}

	public int findPosition(Object key) {
		int i = 0;
		for (i = 0; i < data.size(); i++) {
			if (((DictionaryPair) data.get(i)).compareTo(key) == 0) {
				return i;
			}
		}
		return -1;

	}

	public Object find(Object key) {
		int i = 0;
		i = findPosition(key);
		Object value;
		value = ((DictionaryPair) data.get(i)).getValue();
		return value;
	}

	public DictionaryPair get(int i) {
		return (DictionaryPair) data.get(i);
	}

	public int size() {
		int i = data.size();
		return i;
	}


}