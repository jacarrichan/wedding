package com.wedding.common.ext;

import com.wedding.common.model.PageQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ExtPageQuery {
	
	@Setter
	@Getter
	private int limit;
	
	@Setter
	@Getter
	private int page;
	
	@Setter
	@Getter
	private int start;
	
	public PageQuery changeToPageQuery(){
		PageQuery query =  new PageQuery();
		query.setCurrPage(page);
		query.setPageSize(limit);
		return query;
	}
	
}
