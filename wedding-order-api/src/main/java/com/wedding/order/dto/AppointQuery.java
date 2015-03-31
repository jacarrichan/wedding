package com.wedding.order.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AppointQuery {

	@Getter
	@Setter
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date beginDate;
	
	@Getter
	@Setter
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date endDate;
	
    @Getter
    @Setter
    private Integer appointStatus;
    
    @Getter
    @Setter
    private String sellerName;
    
    @Getter
    @Setter
    private String userName;
    
}
