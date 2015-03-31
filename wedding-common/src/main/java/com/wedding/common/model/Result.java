package com.wedding.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Result<T> {
	
	public Result(T t) {
		this.result = t;
	}

	@Getter
	@Setter
	private T result;
	
}
