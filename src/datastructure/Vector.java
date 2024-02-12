package datastructure;

public class Vector implements Comparable {
	
		private  Comparable data[];
		private int count;
		
		public Vector(int capacity) {
			data= new Comparable[capacity];
			count=0;
		}
		public void addLast(Comparable o) {
			data[count]=o;
			count++;
		}
		public int size() {
			return count;
		}
		public Comparable get(int n) {
			
			return data[n];
		}
		public void removeLast() {
			count--;
		}
		public Comparable getLast() {
			return data[count-1];
		}
		public void removeFirst() {
			for(int i=0;i<count;i++) {
				data[i]=data[i+1];
			}
			count--;
		}
		public Comparable getFirst() {
			return data[0];
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		

	
}
