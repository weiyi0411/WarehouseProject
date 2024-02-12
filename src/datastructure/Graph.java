package datastructure;

public class Graph {
	public class Node implements Comparable {
		private Comparable info;
//		private Vector edges;
		private Node parent;
		private int distance = Integer.MAX_VALUE;

		Vector edges = new Vector(100);

		public Node(Comparable label) {
			info = label;
			this.edges = edges;

		}

		public void addEdge(Edge e) {
			edges.addLast(e);
		}

		public Vector getEdges(Comparable label) {
			info = label;
			return edges;
		}

		public void addNeighbor(Node node, int weight) {
			edges.addLast(new Edge(this, node, weight));
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Vector getNeighbors() {
			return edges;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int compareTo(Object o) {
			// two nodes are equal if they have the same label
			Node n = (Node) o;
			return n.info.compareTo(info);
		}

		public Comparable getLabel() {
			return info;
		}

		public String toString() {
			String s = " ";
			s += info;
			s += " daitance is ";
			s += distance;
			return s;
		}

	}

	private class Edge implements Comparable {
		private Node fromNode;
		private Node toNode;
		private int weight;

		public Edge(Node from, Node to, int value) {
			fromNode = from;
			toNode = to;
			weight = value;
		}

		public int compareTo(Object o) {
			// two edges are equal if they point
			// to the same node.
			// this assumes that the edges are
			// starting from the same node !!!
			Edge n = (Edge) o;
			return n.toNode.compareTo(toNode);
		}

		public String toString() {
			String s = " ";
			s += fromNode;
			s += " to ";
			s += toNode;
			s += " distance is";
			s += weight;
			return s;
		}
	}

	private Vector nodes;
	private int edgeNum;

	public Graph() {
		nodes = new Vector(10);
	}

	public void addNode(Comparable label) {
		nodes.addLast(new Node(label));
	}

	public int getNodes() {
		return nodes.size();
	}

	public int getEdges() {
		return edgeNum;
	}

	public Node findNode(Comparable nodeLabel) {
		Node res = null;
		for (int i = 0; i < nodes.size(); i++) {
			Node n = (Node) nodes.get(i);
			if (n.getLabel() == nodeLabel) {
//				System.out.println(n.getLabel());
				res = n;
				break;
			}
		}
		return res;
	}

	public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2, int weight) {
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2);
		n1.addEdge(new Edge(n1, n2, weight));
		edgeNum++;


	}

	public String toString() {
		String s = "";
		for (int i = 0; i < nodes.size(); i++) {
			s += nodes.get(i).toString();
		}
		return s;
	}

	public int findNodeIndex(Node node) {
		for (int i = 0; i < nodes.size(); i++) {
			if (node == (Node) nodes.get(i)) {
				return i;
			}
		}
		return -1;
	}// 找到点在数组中的位置

	public boolean findPath(Comparable nodeLabel1, Comparable nodeLabel2) {
		Node startState = findNode(nodeLabel1);
		Node endState = findNode(nodeLabel2);
		Stack toDoList = new Stack();
		toDoList.push(startState);
		while (!toDoList.empty()) {
			Node current = (Node) toDoList.pop();
			if (current == endState) {
				return true;
			} else {
				for (int i = 0; i < current.edges.size(); i++) {
					Edge e = (Edge) current.edges.get(i);
					toDoList.push(e.toNode);
				}
			}
		}
		return false;
	}

	public void getShortesePath(Comparable fromNode, Comparable toNode) {
		Node source = findNode(fromNode);
		source.setDistance(0);// initialize fromNode.distacnce=0 others nodes are Int.Max
		Vector nodeList = new Vector(100);// store all the nodes
		nodeList.addLast(source);
		for (int i = 0; i < nodes.size(); i++) {

			if (((Node) nodes.get(i)).info == source.info) {
				continue;
			}
			nodeList.addLast((Node) nodes.get(i));
		}
		boolean flag = shortestPath(nodeList, fromNode);
		System.out.println("Is there  path avialible:" + flag);
		for (int i = 0; i < nodeList.size(); i++) {
			Node node = (Node) nodeList.get(i);
			System.out.println(node.toString());
		}

	}

	//O(n)
	public boolean shortestPath(Vector nodes, Comparable fromNode) {
		Vector nodesList = nodes;
//		int s=0;//原点
		Vector edgeQueue = new Vector(100);// store all the edges
		for (int i = 0; i < nodesList.size(); i++) {
			for (int a = 0; a < ((Node) nodesList.get(i)).getNeighbors().size(); a++) {
				edgeQueue.addLast((Edge) ((Node) nodesList.get(i)).getNeighbors().get(a));
			}

		} // relax
		for (int i = 1; i < nodesList.size(); i++) {
			for (int a = 0; a < edgeQueue.size(); a++) {
				relax((Edge) edgeQueue.get(a));
			}
		}
		// check
		for (int a = 0; a < edgeQueue.size(); a++) {
			Node u = ((Edge) edgeQueue.get(a)).fromNode;
			Node v = ((Edge) edgeQueue.get(a)).toNode;
			if (v.distance > u.distance + ((Edge) edgeQueue.get(a)).weight) {
				return false;
			}
		}
		return true;

	}

	/**
	 * relax method
	 * 
	 * @param edge
	 */

	//O(1)
	public void relax(Edge edge) {
		Node start = edge.fromNode;
		Node end = edge.toNode;
		int distance = start.distance + edge.weight;
		if (end.distance > distance) {
			end.setDistance(distance);
			end.setParent(start);
		}

	}
//	public static void main(String[] args) {
//		Graph graph=new Graph();
//		graph.addNode("no2");
//		graph.addNode("no1");
//		graph.addEdge("no1", "no2", 10);
//		System.out.println(graph.findNode("no1").edges.getFirst().toString());
//		
//		
//		
//	}

}

