package datastructure;



public  class Stack implements Comparable{
	
	 Vector data = new Vector(1000);

	public Stack() {
	   

		
	}

	public void  push(Comparable o) {
	   data.addLast(o);
	}

	public Comparable pop() {
		
		Comparable n=data.getLast();
		data.removeLast();
		return n;
	}

	public Comparable top() {
		Comparable n = data.getLast();
		return n;
	}

	public int size() {
		int n=data.size();
		return n;
	}

	public boolean empty() {
		if(data.size()==0) return true;
		else return false;
	}
//	public int compareTo(Object arg0) {
//	     Stack p2=(Stack) arg0;
//		return 	((Comparable)top()).compareTo(p2.top());
//	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
