package src;
/**
 * product class
 * <ul>
 * <li>name the product name
 * <li>barcodeID unique ID of the product
 * <li>location locationname of the product
 * </ul>
 * @author veewang
 *
 */

public class Product implements Comparable{
	private String name;
	private int barcodeID;
	private String location;
	
	/**
	 * constructor
	 * @param name
	 * @param barcodeID
	 */
	public Product(String name,int barcodeID) {
		
		this.name=name;
		this.barcodeID=barcodeID;
		
	}
	/**
	 * constructor
	 * @param name
	 */
	public Product(String name) {
		this.name=name;
	}
	/**
	 * constructor
	 */
	public Product() {
		
	}
	/**
	 * get product name
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * get barcodeID
	 * @return barcodeID
	 */

	public int getBarcodeID() {
		return barcodeID;
	}
	/**
	 * get location
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * set location name
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	



}
