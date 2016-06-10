package com.tdmr.tappdemo.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tdmr.tappdemo.databinding.ItemCatalogBinding;
import com.tdmr.tappdemo.models.CatalogItem;
import com.tdmr.tappdemo.models.SubItemQueryResult;
import com.tdmr.tappdemo.views.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abigail on 6/10/2016.
 */
public class SubItemQueryResultAdapter extends RecyclerView.Adapter {
    private List<SubItemQueryResult> catalogItems = new ArrayList<>();
    @Nullable private OnItemClickListener listener;

    public SubItemQueryResultAdapter(List<SubItemQueryResult> items, OnItemClickListener listener) {
        catalogItems.addAll(items);
        this.listener = listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCatalogBinding binding = ItemCatalogBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ItemViewHolder vh = new ItemViewHolder(binding, listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = ((ItemViewHolder) holder);
        ItemCatalogBinding binding = itemViewHolder.binding;

        binding.setItem(getItemAt(position));
        binding.setOnClickListener(itemViewHolder);
    }

    public CatalogItem getItemAt(int position) {
        SubItemQueryResult subitem = catalogItems.get(position);
        return subitem.getItem().get(subitem.getType());
    }

    @Override
    public int getItemCount() {
        return catalogItems.size();
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ItemCatalogBinding binding;
        @NonNull public OnItemClickListener listener;

        public ItemViewHolder(@NonNull ItemCatalogBinding v, @Nullable OnItemClickListener listener) {
            super(v.getRoot());
            binding = v;
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            if (listener != null)
                listener.onItemClicked(binding.getItem());
        }
    }
}
