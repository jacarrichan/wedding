package com.wedding.tool.constants;

/**
 * Created by Tank on 14-9-26.
 */

/**
 * 结婚流程笔记类型枚举
 */
public enum ToolsNoteTypeEnum {

    WEDDING_IMPROVE(1,"婚礼美容计划"),
    WEDDING_FLOW(2,"婚礼待办事项");

    private int index;

    private String typeName;

    ToolsNoteTypeEnum(int index, String typeName) {
        this.index = index;
        this.typeName = typeName;
    }

    public int getIndex(){
        return index;
    }
    public String getTypeName(){
        return typeName;
    }


}
