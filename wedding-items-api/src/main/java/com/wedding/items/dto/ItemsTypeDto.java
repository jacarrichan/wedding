package com.wedding.items.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ItemsTypeDto {
	  
		@Getter
		@Setter
	    private String id;

		@Getter
		@Setter
	    private String typeName;
}
