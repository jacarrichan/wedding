package com.wedding.items.pojo.search;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class ItemsDescSearch {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String itemDescKey;

    @Field(type=FieldType.String, indexAnalyzer="ik", searchAnalyzer="ik")
    @Getter
    @Setter
    private String itemDescValue;

    @Getter
    @Setter
    private String itemId;

    @Field(type=FieldType.String, indexAnalyzer="ik", searchAnalyzer="ik")
    @Getter
    @Setter
    private String itemDescTextValue;
}
