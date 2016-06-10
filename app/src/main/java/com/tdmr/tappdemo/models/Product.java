package com.tdmr.tappdemo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by abigail on 6/4/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class Product implements CatalogItem {
    @JsonProperty("engine-product-id")
    private String engineProductId;
    @JsonProperty("localization-key")
    private String localizationKey;
    @JsonProperty("type")
    private String type;
    @JsonProperty("localized-description")
    private String localizedDescription;
    @JsonProperty("category-key")
    private String categoryKey;
    @JsonProperty("denomination-currency")
    private String denominationCurrency;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("product-promotion-message")
    private String productPromotionMessage;
    @JsonProperty("denomination-amount")
    private double denominationAmount;
    @JsonProperty("parent-category-id")
    private long parentCategoryId;
    @JsonProperty("form")
    private String form;
    private String merchant;
    private double price;
    @JsonProperty("product-id")
    private long id;
    @JsonProperty("product-image-id")
    private long productImageId;
    private double srp;

    public String getEngineProductId() {
        return engineProductId;
    }

    public void setEngineProductId(String engineProductId) {
        this.engineProductId = engineProductId;
    }

    public String getLocalizationKey() {
        return localizationKey;
    }

    public void setLocalizationKey(String localizationKey) {
        this.localizationKey = localizationKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(String categoryKey) {
        this.categoryKey = categoryKey;
    }

    public String getDenominationCurrency() {
        return denominationCurrency;
    }

    public void setDenominationCurrency(String denominationCurrency) {
        this.denominationCurrency = denominationCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProductPromotionMessage() {
        return productPromotionMessage;
    }

    public void setProductPromotionMessage(String productPromotionMessage) {
        this.productPromotionMessage = productPromotionMessage;
    }

    public double getDenominationAmount() {
        return denominationAmount;
    }

    public void setDenominationAmount(double denominationAmount) {
        this.denominationAmount = denominationAmount;
    }

    public long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public long getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(long productImageId) {
        this.productImageId = productImageId;
    }

    public double getSrp() {
        return srp;
    }

    public void setSrp(double srp) {
        this.srp = srp;
    }

    @Override
    public String getTitle() {
        return localizedDescription;
    }
}
