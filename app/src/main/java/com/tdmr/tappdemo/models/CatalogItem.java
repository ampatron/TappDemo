package com.tdmr.tappdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by abigail on 6/7/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes(value = {
        @JsonSubTypes.Type(value = Category.class, name = "category"),
        @JsonSubTypes.Type(value = Product.class, name = "product"),
        @JsonSubTypes.Type(value = Service.class, name = "service")
})

public interface CatalogItem {
    @JsonIgnore
    String getTitle();

    long getId();

    public static enum TYPE {
        CATEGORY,
        PRODUCT,
    }
}