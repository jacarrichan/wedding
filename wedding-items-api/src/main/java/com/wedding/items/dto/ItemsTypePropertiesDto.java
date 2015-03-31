package com.wedding.items.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ItemsTypePropertiesDto {

		@Getter
		@Setter
	    private String id;
	
		@Getter
		@Setter
	    private String itemsTypeId;
	
		@Getter
		@Setter
	    private String propertyName;
	
		@Getter
		@Setter
	    private Integer propertyType;
		
		@Getter
		@Setter
		private String propertyTypeName;
	
		@Getter
		@Setter
	    private Boolean required;
		
}
