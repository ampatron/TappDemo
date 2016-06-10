package com.tdmr.tappdemo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by abigail on 6/9/2016.
 */
public class CategoryItems {

    public CategoryItems() {
    }

    @JsonProperty("category-key")
    private String categoryKey;
    @JsonProperty("category-localized-title")
    private String categoryLocalizedTitle;
    private List<SubItemQueryResult> items;

    public String getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(String categoryKey) {
        this.categoryKey = categoryKey;
    }

    public String getCategoryLocalizedTitle() {
        return categoryLocalizedTitle;
    }

    public void setCategoryLocalizedTitle(String categoryLocalizedTitle) {
        this.categoryLocalizedTitle = categoryLocalizedTitle;
    }

    public List<SubItemQueryResult> getItems() {
        return items;
    }

    public void setItems(List<SubItemQueryResult> items) {
        this.items = items;
    }
}