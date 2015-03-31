package com.wedding.tool.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tank on 14-9-26.
 */

/**
 * 结婚资讯DTO
 */
public class ArticleDto implements Serializable {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String pic;

    @Getter
    @Setter
    private Integer type;

    @Getter
    @Setter
    private String context;
}
