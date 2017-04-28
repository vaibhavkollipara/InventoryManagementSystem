package com.commercehub.ims;

import java.util.HashMap;
import java.util.Map;

import com.commercehub.models.Location;


class ProductLocationMap {
	private Map<String,Location> productToLocationMap; 
	
	public ProductLocationMap(){
		productToLocationMap = new HashMap<String,Location>();
	}
	
	public void addProductToInventory(String productId,Location location){
		productToLocationMap.put(productId,location);
		
	}
	
	public Location getProductLocation(String productId) throws Exception{
		if(productToLocationMap.containsKey(productId)){
			return productToLocationMap.get(productId);
		}else{
			throw new Exception("Product does not exist!\nAdd new Product to Inventory first.");
		}
	}
}
