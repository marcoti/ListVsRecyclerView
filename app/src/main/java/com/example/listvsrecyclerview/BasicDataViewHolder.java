package com.example.listvsrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BasicDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private String mBasicData;
    private TextView mTxtView;
    private OnBasicDataClickListener mListener;

    public BasicDataViewHolder(View itemView, OnBasicDataClickListener listener) {
        super(itemView);
        mListener = listener;

        mTxtView = itemView.findViewById(R.id.txtBasicData);
        itemView.setOnClickListener(this);
    }

    public void bindTo(String basicData) {
        mBasicData = basicData;

        mTxtView.setText(basicData);
    }

    @Override
    public void onClick(View view) {
        mListener.onBasicDataItemClicked(mBasicData);
    }

    interface OnBasicDataClickListener {

        /**
         * called when an item in the list is clicked on
         * @param basicData the BasicData that was clicked on
         */
        void onBasicDataItemClicked(String basicData);

    }
}