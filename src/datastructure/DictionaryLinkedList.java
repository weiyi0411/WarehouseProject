package datastructure;



public class DictionaryLinkedList {

		private class DictionaryPair implements Comparable {
			private Object key;
			private Object value;

			public DictionaryPair(Object key, Object value) {
				this.key=key;
				this.value=value;
			}

			public Object getKey() {
				return key;
			}

			public void setKey(Object key) {
				key=key;
			}

			public Object getValue() {
				return value;
			}

			public void setValue(Object value) {
				value=value;
			}

			public int compareTo(Object o) {
				DictionaryPair p2=(DictionaryPair) o;
			return 	((Comparable)key).compareTo(p2.key);
			}
		}

		
		LinkedList data=new LinkedList(); 

		public DictionaryLinkedList() {
		}

		public void add(Object key, Object value) {
			DictionaryPair pair = new DictionaryPair(key,value);
			 data.addLast(pair);
			
		}

		public int findPosition(Object key) {
			int i=0;
			for(i=0;i<data.size();i++) {
				if(((DictionaryPair)data.get(i)).compareTo(key)==0) {
					return i;
				}
			}
			return -1;
				
		}
	   public Object find(Object key) {
		   int i=0;
		   i=findPosition(key);
		  Object value;
		  value=((DictionaryPair) data.get(i)).getValue();
		   return value;
	   }
		

		public int size() {
			int i= data.size();
			return i;
		}
		
		public void remove(Object key) {
			data.remove(key);
		   
		}
		
}
