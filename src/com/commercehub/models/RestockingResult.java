package com.commercehub.models;

public class RestockingResult {
	
	private String productId;
	private int levelAfterRestocking;
	private String locationName;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getLevelAfterRestocking() {
		return levelAfterRestocking;
	}
	public void setLevelAfterRestocking(int levelAfterRestocking) {
		this.levelAfterRestocking = levelAfterRestocking;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getLocationName()+" has "+getLevelAfterRestocking()+" products with productId "+getProductId();
	}	
}
