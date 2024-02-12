package datastructure;



public class LinkedList implements Comparable {
	

		private class ListElement{
			private Object el1;
			private ListElement el2;
			public ListElement(Object el,ListElement nextElement) {
				el1=el;
				el2=nextElement;
				
			}
			public ListElement(Object el) {
			    this(el, null);
			   
			}
			public Object first() {
				return el1;
			}
			public ListElement rest() {
				return el2;
			}
			public void setFirst(Object value) {
				el1=value;
			}
			public void setRest(ListElement value) {
				el2=value;
			}
			public int compareTo(Object o) {
				ListElement p2 = (ListElement) o;
				return ((Comparable) first()).compareTo(p2.first());
			}
			
		}
		
		private ListElement head;
		public LinkedList() {
			head=null;	
		}
		public void addFirst(Object o) {
			head=new ListElement(o, head);
		}
//		public void addLast() {
//			
//		}
		public Object getFirst() {
			return head.first();
		}
		public Object get(int n) {
			ListElement d=head;
			while(n>0) {
				d=d.rest();
				n--;
			}
			return d.first();	
			}
		public String toString() {
			String s="(";
			ListElement d=head;
			while(d!=null) {
				s+=d.first().toString();
			    s+="";
			    d=d.rest();		}
			s+=")";
			return s;
		}
		public int size() {
			ListElement d=head;
			int i=0;
			
			if(d!=null) {
				d=d.rest();
				i++;
			}
			else {
				i=0;
			}
	
			return i;
		}
		
		public void set(int n,Object o) {
			ListElement d=head;
			while(n>0) {
				d=d.rest();
				n--;
			}
			d.setFirst(o);
			
			
			
		}
		public Object getLast() {
			
			int i=size();
			return get(i-1);
			
			
		}
		public void addLast(Object o) {
			ListElement listElement=new ListElement(o,null);
			ListElement d=head;
			while(d.rest()!=null) {
				d=d.rest();
			}
			ListElement last =d.rest();
			d.setRest(new ListElement(o,last));
				
		}
		public void removeFirst() {
		     head=head.rest();
		}
		public void removeLast() {
			
			
		}
		public boolean search(Object o) {
			ListElement listElement=new ListElement(o);
			ListElement d=head;
			for(int i=0;i<size();i++) {
				d=d.rest();    
				if(d.first()==o) 
			    	return true;
			}
			
			
				return false;
			}
		public Object find(Object o) {
			ListElement listElement=new ListElement(o);
			ListElement d=head;
			for(int i=0;i<size();i++) {
				d=d.rest();    
				if(d.first()==listElement.first()) 
			    	return d.first();
			}
			
			
				return null;
			}
		
		public static void main(String[] args) {
			LinkedList l = new LinkedList();
			l.addFirst(1);
			l.addFirst(2);
			System.out.println(l.find(1));
		}
		
		
		
		
		
		
		
		
		public void remove(Object o) {
			while(head != null && head.first()==o){
	            ListElement node = head;
	            head = head.el2;
	            head.el2 = null;
	        }
	        if(head == null){
	            System.out.println("The warehouse is empty");
	        }else{
	            
	            ListElement prev = head;
	            while(prev != null){
	                if(prev.first()==o){
	                    
	                    ListElement node = prev.rest();
	                    prev.el2 = node.rest();
	                    node.el2 = null;
	                }else{
	                    prev = prev.rest();
	                }
	            }
	            System.out.println("The product is removed.");
	      
		}
	
		
	    
		
		
		
		}

		public void addSorted(Comparable o) {
			if(head ==null) head=new ListElement(o,null);
			else if (((ListElement) head.first()).compareTo(o)>0) {
				head =new ListElement(o,head);
			}
			else {
				ListElement d= head;
				while((d.rest()!=null)&&(((ListElement) d.rest().first()).compareTo(o)<0)) {
					d=d.rest();
				}
				ListElement next=d.rest();
				d.setRest(new ListElement(o,next));
			}
		
		}
		public int addAfterEach(Object x,Object y) {
			if(head==null) return 0;
			else 
			{ ListElement xnode=new ListElement(x,null);
			ListElement temp=new ListElement(0,null);
			ListElement test=head;
			int count=0;
			
			while(test.rest()!=null) {
				if(test.first()==y) {
					temp=test.rest();
					test.el2=xnode;
					xnode.el2=temp;
					temp=temp.rest().rest();
					count++;
					
				}
				
			}
                if(test.rest()==null&&test.first()==y) {
                	test.el2=xnode;
                	count++;
				
			}
		return count;
		}
		}
//		public void reverse() {
//			//创建一个反转头
//			ListElement reverseHead =new ListElement(null);
//			//获取正序链表的第一个元素
//			ListElement first = head.rest();
//			
//			while(first!=null) {
//				head.el2=first.rest();
//				first.el2=reverseHead.rest();
//				reverseHead.el2=first;
//				first=head.rest();
//				
//			}
//			head.el2=reverseHead.el2;
//			
//		}
		public void reverse() {
			reverseRec(head);
		}
		public ListElement reverseRec(ListElement curr) {
			if(curr.rest()!=null) {
				ListElement newHead = reverseRec(curr.rest());
				curr.rest().el2=newHead.rest();	
				curr.el2=null;
				return newHead;
			}
			else return null;
			
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
//			ListElement l =new ListElement(o);
//			return this.first().compareTo(l.first());
			return 0;
		}
}
