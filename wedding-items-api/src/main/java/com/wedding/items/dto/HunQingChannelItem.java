package com.wedding.items.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class HunQingChannelItem {

	@Getter
	@Setter
	private String image;
	
	@Getter
	@Setter
	private String itemName;
	
	@Getter
	@Setter
	private String description1;
	
	@Getter
	@Setter
	private String description2;
	
	@Getter
	@Setter
	private String href;
}
