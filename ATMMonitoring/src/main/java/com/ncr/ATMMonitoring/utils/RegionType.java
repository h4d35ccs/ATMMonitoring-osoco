package com.ncr.ATMMonitoring.utils;

import java.util.ArrayList;
import java.util.List;

public enum RegionType {
	WORLD("world", null),

	//--------------------------AFRICA-------------------------------

	AFRICA("002", WORLD),
	NORTHERN_AFRICA("015", AFRICA),
	WESTERN_AFRICA("011", AFRICA),
	MIDDLE_AFRICA("017", AFRICA),
	EASTERN_AFRICA("014", AFRICA),
	SOUTHERN_AFRICA("018", AFRICA),

	//--------------------------EUROPA-------------------------------

	EUROPE("150",WORLD), 	
	NORTHERN_EUROPE("154", EUROPE),
	WESTERN_EUROPE("155", EUROPE), 
	EASTERN_EUROPE("151", EUROPE),
	
	SOUTHERN_EUROPE("039", EUROPE),
	SPAIN("ES",SOUTHERN_EUROPE),
	ITALY("IT",SOUTHERN_EUROPE),
	//--------------------------AMERICA-------------------------------
	AMERICAS("019",WORLD), 	
	NORTHERN_AMERICA("021", AMERICAS),
	CARIBBEAN("029", AMERICAS),
	CENTRAL_AMERICA("013", AMERICAS),
	SOUTH_AMERICA("005", AMERICAS),

	//--------------------------ASIA-------------------------------
	ASIA("142",WORLD), 	
	CENTRAL_ASIA("143", ASIA),
	EASTERN_ASIA("030", ASIA),
	SOUTHERN_ASIA("034", ASIA),
	SOUTH_EASTERN_ASIA("035", ASIA),
	WESTERN_ASIA("145", ASIA),

	//--------------------------OCEANIA-------------------------------
	OCEANIA("009",WORLD), 	
	AUSTRALIA_AND_NEW_ZEALAND("053", OCEANIA),
	MELANESIA("054", OCEANIA), 	
	MICRONESIA("057", OCEANIA), 	
	POLYNESIA("061", OCEANIA);

	private String regionCode;
	private RegionType parentRegion;
	private List<RegionType> childrenRegion = new ArrayList<RegionType>();
	
	private RegionType(String regionCode, RegionType parentRegion) {
		this.regionCode = regionCode;
		this.parentRegion = parentRegion;
		
		if(this.parentRegion != null) {
			this.parentRegion.childrenRegion.add(this);	
		}
	}

	public boolean isContinent() {
		return this.parentRegion == WORLD;
	}

	public boolean isSubContinent() {
		return this.parentRegion.isContinent();
	}

	public boolean isCountry() {
		return this.parentRegion.isSubContinent();
	}

	public List<RegionType> getChildrenRegion() {
		return this.childrenRegion;
	}
	
	public String getCode() {
		return this.regionCode;
	}
}