package datastructure;
import java.util.Comparator;

public class PriorityQueue 
{       
	private class PriorityPair implements Comparable {
		private Object element;
		private Object priority;

		public PriorityPair(Object element, Object priority) {
			this.element = element;
			this.priority = priority;
		}

		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}
	}

	private LinkedList data;

	public PriorityQueue()
	{
		data = new LinkedList();
	}

	public void push(Object o, int priority)
	{
		// make a pair of o and priority
		// add this pair to the sorted linked list.
		PriorityPair p =new PriorityPair(o,priority);
		data.addSorted((Comparable)p);
	}

	public Object pop()

	{
		Object n =data.getFirst();
		data.removeFirst();
		return n;
		// add your code here
	}

	public Object top()
	{
		
		return data.getFirst();
		// add your code here
	}
}
