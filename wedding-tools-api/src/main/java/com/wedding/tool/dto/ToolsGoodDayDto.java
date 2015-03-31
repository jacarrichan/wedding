package com.wedding.tool.dto;

import lombok.Setter;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by tank on 14-9-26.
 */

/**
 * 黄道吉日DTO
 */
public class ToolsGoodDayDto implements Serializable {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String riqi;

    @Getter
    @Setter
    private String gongli;

    @Getter
    @Setter
    private String nongli;

    @Getter
    @Setter
    private String yi;

    @Getter
    @Setter
    private String ji;

    @Getter
    @Setter
    private String jinji;
    @Getter
    @Setter
    private String jishen;


}
