package com.wedding.common.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.format.annotation.DateTimeFormat;

@ToString
public class DateRange {

	@Getter
	@Setter
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date beginDate;
	
	@Getter
	@Setter
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date endDate;
}
