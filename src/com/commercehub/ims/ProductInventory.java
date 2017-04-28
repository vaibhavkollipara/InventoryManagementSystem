package com.commercehub.ims;

import java.util.Hashtable;

import com.commercehub.models.Location;
import com.commercehub.models.PickingResult;
import com.commercehub.models.PickingResult.PickingResultStatus;
import com.commercehub.models.Product;
import com.commercehub.models.RestockingResult;

public class ProductInventory implements InventoryManagementSystem{
	private volatile Hashtable<String,Integer> productLevelMap;
	private ProductLocationMap productLocationMap;
	
	public ProductInventory(){
		productLevelMap = new Hashtable<String,Integer>();
		productLocationMap = new ProductLocationMap();
	}
	
	public void addNewProduct(Product product,Location location){
		productLocationMap.addProductToInventory(product.getProductId(), location);
		productLevelMap.put(product.getProductId(), 0);
	}
	
	@Override
	public synchronized PickingResult pickProduct(String productId, int amountToPick){
		if(amountToPick<1){
			System.out.println("Invalid input...\namountToPick should be greater than 0");
			return null;
		}
		PickingResult pResult = new PickingResult();
		int currentLevel;
		try {
			pResult.setProductId(productId);
			pResult.setLocationName(productLocationMap.getProductLocation(productId).getLocationName());
			currentLevel = productLevelMap.get(productId);
			if(currentLevel==0){
				pResult.setStatus(PickingResultStatus.FAILED);
				pResult.setQuantityAvailableForPickUp(0);
			}else if(currentLevel>=amountToPick){
				pResult.setStatus(PickingResultStatus.SUCCESS);
				pResult.setQuantityAvailableForPickUp(amountToPick);
				productLevelMap.put(productId, currentLevel-amountToPick);
			}else if(currentLevel<amountToPick){
				pResult.setStatus(PickingResultStatus.INCOMPLETE);
				pResult.setQuantityAvailableForPickUp(amountToPick-currentLevel);
				productLevelMap.put(productId, 0);
			}
			
		} catch (Exception e1) {
			e1.getMessage();
			e1.printStackTrace();
		}
		return pResult;
	}
	@Override
	public synchronized RestockingResult restockProduct(String productId, int amountToRestock) {
		RestockingResult rResult = new RestockingResult();
		try {
			rResult.setProductId(productId);
			rResult.setLocationName(productLocationMap.getProductLocation(productId).getLocationName());
			rResult.setLevelAfterRestocking(productLevelMap.get(productId)+amountToRestock);
			productLevelMap.put(productId, rResult.getLevelAfterRestocking());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
			e1.printStackTrace();
		}
		return rResult;
	}
	
}
