package com.wedding.tool.dto;

import java.io.Serializable;

import com.wedding.common.redis.RedisKeyPrefix;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RedisKeyPrefix(prefixValue="tool:areaDto:parentId")
@ToString
public class AreaDto implements Serializable{

	private static final long serialVersionUID = -2274313560490313473L;

	@Getter
	@Setter
    private Integer id;

	@Getter
	@Setter
    private Integer parentId;

	@Getter
	@Setter
    private String name;

	@Getter
	@Setter
    private Short level;
}
