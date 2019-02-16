package com.maestro.hotelcommerce.util;

public enum Title {

	MR("Mr"),
	MS("Ms");
	
	private String titleValue;
	
	
	Title(String titleValue){
		this.titleValue = titleValue;
	}
	
	public String getValue(){
		return titleValue;
	}
}
