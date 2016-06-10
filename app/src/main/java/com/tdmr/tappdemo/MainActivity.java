package com.tdmr.tappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.tdmr.tappdemo.adapters.CategoryAdapter;
import com.tdmr.tappdemo.adapters.SubItemQueryResultAdapter;
import com.tdmr.tappdemo.client.TappMarketApi;
import com.tdmr.tappdemo.models.CatalogItem;
import com.tdmr.tappdemo.models.Category;
import com.tdmr.tappdemo.models.CategoryItems;
import com.tdmr.tappdemo.views.OnItemClickListener;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Nullable long mCategoryId;
    private RecyclerView mRecycler;
    private CategoryAdapter mAdapter;
    private TappMarketApi mooTask;

    public MainActivity() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TappMarketApi.SERVICE_ENDPOINT)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        mooTask = retrofit.create(TappMarketApi.class);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("id")) {
            mCategoryId = intent.getLongExtra("id", 0);
        }

        if (mCategoryId == 0)
            getMainCategories();
        else
            getSubItems(mCategoryId);
    }


    private void getMainCategories() {
        mooTask.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(new Action0() {
                    @Override
                    public void call() {
                        Log.v(TAG, "terminate");
                    }
                })
                .subscribe(new Subscriber<List<Category>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v(TAG, "error : " + e.getMessage());
                    }

                    @Override
                    public void onNext(List<Category> categories) {
//                        mAdapter.setNewList(tasks);
                        mRecycler.setAdapter(new CategoryAdapter(categories, MainActivity.this));
                    }
                });
    }

    private void getSubItems(long id) {
        mooTask.getCategories(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(new Action0() {
                    @Override
                    public void call() {
                        Log.v(TAG, "terminate");
                    }
                })
                .subscribe(new Subscriber<CategoryItems>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v(TAG, "error : " + e.getMessage());
                    }

                    @Override
                    public void onNext(CategoryItems  categories) {
                        mRecycler.setAdapter(new SubItemQueryResultAdapter(categories.getItems(), MainActivity.this));
                    }
                });
    }

    public void onItemClicked(CatalogItem obj) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        if (obj instanceof Category) {
            i.putExtra("id", obj.getId());
            startActivity(i);
        } else {
            Toast.makeText(this, "Feature not yet supported.", Toast.LENGTH_SHORT).show();
        }
    }

}
