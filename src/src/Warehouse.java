package src;

import datastructure.*;

/**
 * Warehouse class: The whole warehouse is a DictionaryTree datastructure store
 * dictionaryPair in the node dictionaryPair key is product name,value is a
 * product stack stack stores all the products.
 * 
 * <ul>
 * <li>clientLsit store all the clients in the warehouse
 * <li>productStack the same product stores in the same productStack
 * <li>productList store all the product name and id in the Vector,used to find
 * product name by id
 * <li>orderList stores all the order in the warehouse, node is a dictionaryPair
 * key is orderId value is the whole order
 * <li>warehouseGraph store all the location and path in the warehouse in a
 * graph
 * <li>setBarCode for set productId
 * <li>setClientId for set clientId
 * <li>setOrderId for set orderId
 * </ul>
 * 
 * @author veewang
 *
 */

public class Warehouse implements IWarehouse {

	private LinkedList clientList;
	private Stack productStack;
	private Vector productList;
	private DictionaryTree orderList;
	private Graph warehouseGraph;
	private int setBarCode;
	private int setClientId;
	private int setOrderId;

	DictionaryTree warehouse = new DictionaryTree();

	/**
	 * constructor
	 */
	public Warehouse() {

		this.warehouseGraph = new Graph();
		this.clientList = new LinkedList();
		this.productList = new Vector(100);
		this.orderList = new DictionaryTree();
		this.setBarCode = 0;
		this.setClientId = 0;
		this.setOrderId = 0;

	}

	// }//时间复杂度：因为warehouse是dictionaryTree 所以查找时用的是tree得查找方法，复杂度为O（logn）
	/**
	 * part 1 test
	 * 
	 * @param name
	 * @return
	 */
	public Stack get(String name) {
		return (Stack) (warehouse.find(name));
	}

	public String getOrder(int orderId) {
		
		return ((Order) orderList.find(orderId)).toString();
	}

	public int graphNodes() {
		return warehouseGraph.getNodes();
	}

	/**
	 * Method registers a new product to the system if the product is alredy in the
	 * warehouse add the quantity directly else add new produt and assigns
	 * (+returns) a unique id for the product
	 * 
	 * @param name     name of the product to be added
	 * @param quantity number of product items added to the warehouse
	 * @return unique identifier of the product that was added to the warehouse
	 */
	// O(n)
	public int addProduct(String name, int quantity) {
		if (warehouse.find(name) != null) {

			for (int i = 0; i < quantity; i++) {
				Product product = (Product) ((Stack) warehouse.find(name)).top();
				((Stack) warehouse.find(name)).push((Comparable) product);
			}
			return ((Product) ((Stack) warehouse.find(name)).top()).getBarcodeID();
		} //
		else {
			Stack newProductStack = new Stack();
			Product newProduct = new Product(name, setBarCode);
			setBarCode++;
			for (int i = 0; i < quantity; i++) {
				newProductStack.push((Comparable) newProduct);
			}
			warehouse.add(name, newProductStack);
			productList.addLast(newProduct);
			return newProduct.getBarcodeID();
		}

	}

	/**
	 * Method removes certain quantity of a product form the system. check the
	 * product quantity meet the demand of removement if meet remove then return
	 * true else return false
	 * 
	 * @param productId unique identifier of the product to be removed
	 * @param quantity  number of product items removed to the warehouse
	 * @return success or failure to remove the products
	 */
	// O(n)
	public boolean removeProduct(int productId, int quantity) {
		String name = null;
		for (int i = 0; i < productList.size(); i++) {
			if (((Product) productList.get(i)).getBarcodeID() == productId) {
				name = ((Product) productList.get(i)).getName();
			}
		}
		if (warehouse.find(name) != null) {
			if (((Stack) warehouse.find(name)).size() > quantity) {
				for (int i = 0; i < quantity; i++) {
					((Stack) warehouse.find(name)).pop();
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Method registers a new client in the system and assigns (+returns) a unique
	 * id. register a new client then add it into clientList
	 * 
	 * @param name  the fisrt and the last name of the client that is registered in
	 *              the system
	 * @param email e-mail address of the client to be registered
	 * @return unique identifier of the client that was registered to the system
	 */
	// O(1)
	public int registerClient(String name, String email) {
		Client client = new Client(name, email);
		client.setClientId(setClientId);
		setClientId++;
		clientList.addFirst(client);
		return client.getClientId();

	}

	/**
	 * Method created an order for a client and assigns it a unique id. create an
	 * order then add it into orderList
	 * 
	 * @param clientId id of the client to which the order belongs
	 * @return unique identifier of the order created in the system
	 */
	// O(1)
	public int createOrder(int clientId) {
		Order newOrder = new Order();
		newOrder.setClientId(clientId);
		newOrder.setOrderId(setOrderId);
		orderList.add(setOrderId, newOrder);
		setOrderId++;
		return newOrder.getOrderId();

	}

	/**
	 * Method creates an order with a unique id in the system. The order is
	 * associated with a client find the order in the orderList then add product in
	 * the order
	 * 
	 * @param productId id of the product added to the order
	 * @param quantity  quantity of the products added to the order
	 * @param orderId   id of the orded to be created (assumes createOrder(...)
	 *                  method was called first)
	 */
	// O(1)

	public void addToOrder(int productId, int quantity, int orderId) {
		Order order = (Order) orderList.find(orderId);
		order.addProduct(productId, quantity);
		System.out.println(quantity + " Prodrut " + productId + " are successfully added in order " + orderId);
//		System.out.println(order.getProductListSize());
	}

	/**
	 * Method finishes the order and removes the products from the stock of the
	 * warehouse. Once the order is finalized, no product can be added or removed.
	 * first use orderId to find order in the orderList second get the productList
	 * of the order third travers all the dictionaryPair in the productList and
	 * remove the product in the warehouse
	 * 
	 * @param orderId id of the order to be finalized
	 */
	// O(n)
	public void finalizeOrder(int orderId) {

		Order order = (Order) orderList.find(orderId);
		Dictionary productList = order.getProductList();
		for (int i = 0; i < order.getProductListSize(); i++) {
			int productId = (int) productList.getKey(i);
			int quantity = (int) productList.getValue(i);
			if (removeProduct(productId, quantity) == false) {
				System.out.println("The quantity is not enougu!");
			} else {
				System.out.println("Successfully finalize Order！");
				orderList.remove(orderId);
				
			}
		}

	}

	/**
	 * Method searches a product in the system based on the name. It prints the
	 * results of the search (name + quantity)
	 * 
	 * @param productName name of the product searched in the system
	 */
	// O(1)
	public void searchProduct(String productName) {
		if (warehouse.find(productName) != null) {
			int quantity = ((Stack) warehouse.find(productName)).size();
			System.out.println(productName + " has " + quantity);
		}

	}

	// part2 test
	//O(1)
	public int getWarehouseGraphNode() {
		return warehouseGraph.getNodes();
	}

	public int getWarehouseGraphEdge() {
		return warehouseGraph.getEdges();
	}

	/**
	 * Method assigns a location to a product, meaning the the product is stored at
	 * this location assigns a location to a product then add it into warehouseGraph
	 * by locationName
	 * 
	 * @param locationName name of the location in the warehouse
	 * @param productId    id of the product stored at the location c
	 */

	// O(n)
	public void assignLocation(String locationName, int productId) {
		String name = null;//productName
		for (int i = 0; i < productList.size(); i++) {
			if (((Product) productList.get(i)).getBarcodeID() == productId) {
				name = ((Product) productList.get(i)).getName();
			}
		}
		if (warehouse.find(name) != null) {
			((Product) ((Stack) warehouse.find(name)).top()).setLocation(locationName);//
			warehouseGraph.addNode(locationName);
		}

	}

	/**
	 * Method connects two locations at the warehouse. This means the personnel of
	 * the warehouse can walk/transfer directly between the two locations without
	 * crossing another one.
	 * 
	 * @param firstLocation  name of the first location to be connected
	 * @param secondLocation name of the second location to be connected
	 * @param distance       distance between locations (e.g. in meters)
	 */
	// O(1)
	public void connectLocations(String firatLocation, String secondLocation, int distance) {
		warehouseGraph.addEdge(firatLocation, secondLocation, distance);

	}

	/**
	 * Method prints the shortest path between two locations and the distance
	 * between them. use bellman-Frod
	 * 
	 * @param firstLocation  name of the starting location
	 * @param secondLocation name of the final location
	 */
	//O(n)
	public void printShortestPath(String firstLocation, String secondLocation) {
	       
		if (warehouseGraph.findPath(firstLocation, secondLocation) == true) {
			warehouseGraph.getShortesePath(firstLocation, secondLocation);
		}

	}

	public void printOptimalPath(int orderId) {

	}

}