package com.commercehub.models;

public abstract class Location {
	
	private int locationId;
	private String locationName;
	private String locationDescription;
	
	protected Location(int locationId,String locationName,String locationDescription){
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationDescription = locationDescription;
	}
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationDescription() {
		return locationDescription;
	}
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	
	
}
