package src;

import datastructure.*;

/**
 * Client class product class
 * <ul>
 * <li>name the client name
 * <li>clientId unique ID of the client
 * <li>clientEmail
 * </ul>
 * 
 * @author veewang
 *
 */

public class Client {
	private String name;
	private int clientId;
	private String clientEmail;

//private LinkedList Order;
	/**
	 * constructor
	 * 
	 * @param name
	 * @param email
	 */
	public Client(String name, String email) {
		this.name = name;
		clientEmail = email;

	}

	/**
	 * get clientEmail
	 * 
	 * @return clientEmail
	 */
	public String getClientEmail() {
		return clientEmail;
	}

	/**
	 * set clientEmail
	 * 
	 * @param clientEmail
	 */
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	/**
	 * get clien name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set client name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get client name
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
//	public int createOrder() {
//		Order newOrder=new Order();
//		newOrder.setOrderId(clientId+Order.size());
//		Order.addFirst(newOrder);
//		return clientId+Order.size();
//		
//	}

}
