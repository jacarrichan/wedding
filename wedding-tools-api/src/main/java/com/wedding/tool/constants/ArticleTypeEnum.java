package com.wedding.tool.constants;

/**
 * Created by Tank on 14-9-26.
 */

/**
 * 结婚咨询类型枚举
 */
public enum ArticleTypeEnum {

    COMPANY_INFO(1,"行业动态"),
    PERSON_INFO(2,"名人喜事"),
    SHOP_INFO(3,"商家动态"),
    ARTICLE_INFO(4,"精品文章");

    private int index;

    private String typeName;

    ArticleTypeEnum(int index, String typeName) {
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
