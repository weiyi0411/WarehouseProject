package datastructure;

public class DictionaryTree {

	private class DictionaryPair implements Comparable {
		private Comparable key;
		private Comparable value;

		public DictionaryPair(Comparable key, Comparable value) {
			this.key = key;
			this.value = value;
		}

		public Comparable getKey() {
			return key;
		}

		public void setKey(Comparable key) {
			key = key;
		}

		public Comparable getValue() {
			return value;
		}

		public void setValue(Comparable value) {
			value = value;
		}

		@Override

		public int compareTo(Object o) {
			DictionaryPair p2 = (DictionaryPair) o;
			return ((Comparable) key).compareTo(p2.key);
		}

	}

	Tree data = new Tree();

	public DictionaryTree() {
	}

	public void add(Comparable key, Comparable value) {
		DictionaryPair pair = new DictionaryPair(key, value);
		data.insert(pair);

	}
//		public boolean isFind(Comparable key) {
//			if(find(key)!=null)
//				return true;
//			return false;
//		}

	public Comparable find(Comparable key) {
//			if (data.find((Comparable) key) != null) {
//				return ((DictionaryPair)(data.find((Comparable)key))).value;
//			}
//			else return null;
		DictionaryPair temp = new DictionaryPair(key, null);
		DictionaryPair result = (DictionaryPair) data.find(temp);
		if (result != null) {
			return result.value;
		} else
			return null;

	}
	public boolean remove(Comparable key) {
		DictionaryPair temp = new DictionaryPair(key, null);
		data.remove(temp);
		return true;
		
	}
//		public void remove(Comparable key,Comparable value) {
//			
//			data.remove(key);
//		}

//
//		public int findPosition(Comparable key) {
//			int i=0;
//			for(i=0;i<data.size();i++) {
//				if(((DictionaryPair)data.get(i)).compareTo(key)==0) {
//					return i;
//				}
//			}
//			return -1;
//				
//		}
//	   public Comparable find(Comparable key) {
//		   int i=0;
//		   i=findPosition(key);
//		  Comparable value;
//		  value=((DictionaryPair) data.get(i)).getValue();
//		   return value;
//	   }
//		
//
	public int size() {
		int i = data.size();
		return i;
	}
	//

}
