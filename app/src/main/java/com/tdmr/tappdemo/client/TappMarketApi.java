package com.tdmr.tappdemo.client;

import com.tdmr.tappdemo.models.Category;
import com.tdmr.tappdemo.models.CategoryItems;
import com.tdmr.tappdemo.models.SubItemQueryResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by abigail on 6/4/2016.
 */
public interface TappMarketApi {
    public String SERVICE_ENDPOINT = "https://sandbox-market.tapp.fi";

    @GET("/api/1/product-categories")
    Observable<List<Category>> getCategories();

    @GET("/api/1/product-categories/{categoryId}")
    Observable<CategoryItems> getCategories(@Path("categoryId") long id);
}
