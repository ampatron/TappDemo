package com.tdmr.tappdemo.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abigail on 6/9/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class SubItemQueryResult {
    private String type;
    private Map<String, CatalogItem> item = new HashMap<>();

    public SubItemQueryResult() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, CatalogItem> getItem() {
        return item;
    }

    @JsonAnySetter
    public void setItem(String type, CatalogItem value) {
        this.type = type;
        this.item.put(type, value);
    }


    public String getTitle() {
        return item.get(type).getTitle();
    }

    public long getId() {
        return item.get(type).getId();
    }
}
