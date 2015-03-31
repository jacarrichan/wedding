package com.wedding.tool.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tank on 14-9-26.
 */

/**
 * 结婚记事本DTO
 */
public class ToolsNoteDto implements Serializable {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String context;

    @Getter
    @Setter
    private Integer type;

    @Getter
    @Setter
    private Integer planDay;
}
