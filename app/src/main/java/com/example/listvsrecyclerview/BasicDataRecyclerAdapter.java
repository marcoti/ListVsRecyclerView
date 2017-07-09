package com.example.listvsrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BasicDataRecyclerAdapter extends RecyclerView.Adapter<BasicDataViewHolder> implements BasicDataViewHolder.OnBasicDataClickListener {

    private static int LAYOUT = R.layout.basic_data_item;

    private List<String> mData;
    private ItemInteractionListener mListener;

    public BasicDataRecyclerAdapter(ItemInteractionListener listener) {
        super();
        mListener = listener;
        mData = new ArrayList<>();
    }

    @Override
    public BasicDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // note: the viewType only matters if you want this recyclerViewadapter to support multiple view types
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(LAYOUT, parent, false);
        return new BasicDataViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(BasicDataViewHolder holder, int position) {
        String basicData = mData.get(position);
        holder.bindTo(basicData);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBasicDataItemClicked(String basicData) {
        mListener.onItemClicked(basicData);
    }

    public void addData(List<String> data) {
        mData.addAll(data);
    }

    interface ItemInteractionListener {

        void onItemClicked(String basicData);

    }
}
