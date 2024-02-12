package src;

import datastructure.Dictionary;
import datastructure.DictionaryTree;
import datastructure.LinkedList;

/**
 * Order class
 * <ul>
 * <li>orderId unique id of the order
 * <li>clientId unique ID of the client
 * <li>productList a list of product
 * </ul>
 * 
 * @author veewang
 *
 */

public class Order implements Comparable {
	private Comparable orderId;
	private int clientId;
	private Dictionary productList;

	/**
	 * consturctor
	 * 
	 * @param clientId
	 * @param orderID
	 */
//	public Order(int clientId,int orderID ) {
//		this.clientId=clientId;
//		this.orderId=orderID;
//		this.productList=new LinkedList();
//	}
	/**
	 * constructor
	 * 
	 * @param orderID
	 */
	public Order(int orderID) {

		productList = new Dictionary();
		this.orderId = orderID;

	}

	/**
	 * constructor
	 */
	public Order() {
		productList = new Dictionary();
	}

	/**
	 * get clientId
	 * 
	 * @return clientId
	 */
	public int getClientId() {
		return clientId;
	}

	/**
	 * set clientId
	 * 
	 * @param clientId
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	/**
	 * get orderId
	 * 
	 * @return orderId
	 */
	public int getOrderId() {
		return (int) orderId;
	}

	/**
	 * set orderID
	 * 
	 * @param orderID
	 */
	public void setOrderId(int orderID) {
		this.orderId = orderID;
	}
//	public Product getProduct() {
//		return product;
//	}
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	/**
	 * add product to productList 把每个产品的id加进去，其实应该用dictionarytree更好
	 * 
	 * @param productId
	 * @param quantity
	 */

	public void addProduct(Comparable productId, Comparable quantity) {

		productList.add(productId, quantity);

	}

	public int getProductListSize() {
		return productList.size();
	}

	public Dictionary getProductList() {
		for (int i = 0; i < productList.size(); i++) {
			System.out.println("The order have product:" + productList.get(i).toString());

		}
		return productList;
	}

	/**
	 * remove product productList
	 * 
	 * @param productId
	 * @param quantity
	 */
//	public void removeProduct(Comparable productId, Comparable quantity) {
//		
//	}

	@Override
	public int compareTo(Object o) {
		Order order = (Order) o;
		return this.orderId.compareTo(order.orderId);

	}
	public String toString() {
		String s=" ";
		s+= orderId;
		s+= productList;
		return s;
	}

}
