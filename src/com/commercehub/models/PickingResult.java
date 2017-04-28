package com.commercehub.models;

public class PickingResult {
	
	public static enum PickingResultStatus{
		SUCCESS,INCOMPLETE,FAILED
	}
	
	private PickingResultStatus status;
	private String productId;
	private String locationName;
	private int quantityAvailableForPickUp;
	
	public PickingResultStatus getStatus() {
		return status;
	}
	public void setStatus(PickingResultStatus status) {
		this.status = status;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public int getQuantityAvailableForPickUp() {
		return quantityAvailableForPickUp;
	}
	public void setQuantityAvailableForPickUp(int productsAvailableForPickUp) {
		this.quantityAvailableForPickUp = productsAvailableForPickUp;
	}
	
	@Override
	public String toString(){
		switch(getStatus()){
		case SUCCESS :
			return "Successful: "+getQuantityAvailableForPickUp()+" products with productId "+getProductId()+" can be picked from "+ getLocationName();
		case INCOMPLETE :
			return "Incomplete Request: only "+getQuantityAvailableForPickUp()+ " products available with produtId "+getProductId()+" at "+getLocationName();
		case FAILED :
			return "Failed: Products with productId "+getProductId()+" are out of Stock";
		default : 
			return "";
		}
	}
	
	
	
}