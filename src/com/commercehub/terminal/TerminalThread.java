package com.commercehub.terminal;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.commercehub.ims.InventoryManagementSystem;
import com.commercehub.models.Product;
import com.commercehub.sampleproducts.ProductA;
import com.commercehub.sampleproducts.ProductB;
import com.commercehub.sampleproducts.ProductC;

public class TerminalThread implements Runnable {
	
	private static int terminalCount=0;
	
	private Random random;
	private int terminalId;
	private InventoryManagementSystem productInventory;
	private CountDownLatch latch;
	
	public TerminalThread(InventoryManagementSystem productInventory,CountDownLatch latch){
		random = new Random();
		this.productInventory = productInventory;
		this.latch = latch;
		terminalCount++;
		terminalId = terminalCount;
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			randomOperation();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		latch.countDown();
	}
	
	private void randomOperation(){
		String pid = pickRandomProduct().getProductId();
		int qty = random.nextInt(5)+1;
		switch(random.nextInt(2)){
		case 0 :
			System.out.println("Terminal "+terminalId+" restock("+pid+","+qty+") :\n"+
					productInventory.restockProduct(pid,qty)+"\n");
			break;
		case 1 : 
			System.out.println("Terminal "+terminalId+" pick("+pid+","+qty+") :\n"+
					productInventory.pickProduct(pid, qty)+"\n");
			break;
		default:
			return;
		}
	}
	
	private Product pickRandomProduct(){
		switch(random.nextInt(3)){
		case 0 : 
			return new ProductA();
		case 1 : 
			return new ProductB();
		case 2 :
			return new ProductC();
		default : 
			return null;
		}
	}
	
}
