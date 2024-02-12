package src;

import datastructure.*;

/**
 * Test class
 * 
 * @author veewang
 *
 */

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Warehouse warehouse = new Warehouse();
//test part 1
		System.out.println("----Test addProduct ---");
		warehouse.addProduct("cookie", 10);
		warehouse.addProduct("milk", 20);
		warehouse.addProduct("cherry", 12);
		warehouse.addProduct("water", 12);
		System.out.println("milk quantity is "+warehouse.get("milk").size());
		System.out.println("cookie quantity is "+warehouse.get("cookie").size());
		System.out.println("----Test removeProduct ---");
//		warehouse.removeProduct(0, 5);
		System.out.println(warehouse.removeProduct(0, 5));
		System.out.println("cookie quantity is "+warehouse.get("cookie").size());

		System.out.println("----Test registerClient ---");
		System.out.println("The client number is:" + warehouse.registerClient("weiyi", "vee@163.com"));
		System.out.println("The client number is:" + warehouse.registerClient("yueyue", "yueyue@163.com"));

		System.out.println("----Test createOrder ---");
		System.out.println("The order number is:" + warehouse.createOrder(0));
		System.out.println("The order number is:" + warehouse.createOrder(0));
		System.out.println("----Test addToOrder ---");
		warehouse.addToOrder(0, 2, 0);
		
		System.out.println("----Test finalizeOrder ---");
		warehouse.finalizeOrder(0);
//		System.out.println(warehouse.getOrder(0));
		System.out.println(warehouse.get("cookie").size());
		System.out.println("----Test searchProduct ---");
		warehouse.searchProduct("cookie");
//		
//		
//		
//		
//test part 2		
		System.out.println("----Test assignLocation ---");
		warehouse.assignLocation("No.1", 0);
		warehouse.assignLocation("No.2", 1);
		warehouse.assignLocation("No.3", 2);
		warehouse.assignLocation("No.4", 3);
		System.out.println(warehouse.getWarehouseGraphNode());// I add 3 location so the nodes of the warehouseGraph is
																// 3
		System.out.println("----Test connectLocations ---");
		warehouse.connectLocations("No.1", "No.2", 5);
		warehouse.connectLocations("No.2", "No.3", 10);
		warehouse.connectLocations("No.1", "No.3", 20);
		System.out.println(warehouse.getWarehouseGraphEdge());// I add 3 path so the edges of the warehouseGraph is 3
		System.out.println("----Test printShortestPath ---");
		warehouse.printShortestPath("No.1", "No.2");// it should be 15

	}

}
