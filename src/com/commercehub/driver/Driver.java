package com.commercehub.driver;

import java.util.concurrent.CountDownLatch;

import com.commercehub.ims.ProductInventory;
import com.commercehub.samplelocations.LocationA;
import com.commercehub.samplelocations.LocationB;
import com.commercehub.samplelocations.LocationC;
import com.commercehub.sampleproducts.ProductA;
import com.commercehub.sampleproducts.ProductB;
import com.commercehub.sampleproducts.ProductC;
import com.commercehub.terminal.TerminalThread;

public class Driver {
	
	//method to initilize inventory with product and location map
	public static void initilize(ProductInventory productInventory){
		productInventory.addNewProduct(new ProductA(), new LocationA());
		productInventory.addNewProduct(new ProductB(), new LocationB());
		productInventory.addNewProduct(new ProductC(), new LocationC());
	}
	
	public static void main(String[] args){
		int noOfTerminals = 5;
		CountDownLatch latch = new CountDownLatch(noOfTerminals);
		ProductInventory productInventory = new ProductInventory();
		initilize(productInventory);		
		for(int i=0;i<noOfTerminals;i++){
			new Thread(new TerminalThread(productInventory,latch)).start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
