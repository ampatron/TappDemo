package com.tdmr.tappdemo.models;
//
//import com.bluelinelabs.logansquare.annotation.JsonField;
//import com.bluelinelabs.logansquare.annotation.JsonObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by abigail on 6/4/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class Category implements CatalogItem {
    @JsonProperty("product-category-id")
    private long id;
    @JsonProperty("product-category-image-id")
    private long imageId;
    @JsonProperty("product-category-rank")
    private long rank;
    @JsonProperty("category-key")
    private String key;
    @JsonProperty("category-localized-title")
    private String localizedTitle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLocalizedTitle() {
        return localizedTitle;
    }

    public void setLocalizedTitle(String localizedTitle) {
        this.localizedTitle = localizedTitle;
    }

    @Override
    public String getTitle() {
        return localizedTitle;
    }
}
