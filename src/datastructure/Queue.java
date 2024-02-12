package datastructure;
public class Queue {
	
	private Vector data;
	
	public Queue() {
		Vector data = new Vector(100);
		
	}

	public void push(Comparable o) {
		data.addLast(o);
	}

	public Object pop() {
		Object n=data.getFirst();
		data.removeFirst();
		return n;
	}

	public Object top() {
		Object n=data.getFirst();
		return n;
	}

	public int size() {
		return data.size();
	}

	public boolean empty() {
		if(data.size()==0) return true;
		else return false;
	
	}
}
