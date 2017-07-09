package com.example.listvsrecyclerview;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BasicDataRecyclerAdapter.ItemInteractionListener {

    private View mRoot;
    private RecyclerView mRecyclerView;
    private BasicDataRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRoot = findViewById(R.id.frameLayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // setup the recyclerView
        mAdapter = new BasicDataRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL)); // display the divider between each row item

        addSomeFakeData();
    }

    // just build a list of 100 strings
    private void addSomeFakeData() {
        int total = 100;
        ArrayList<String> data = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            data.add(String.valueOf(i));
        }

        mAdapter.addData(data);
    }

    @Override
    public void onItemClicked(String basicData) {
        Snackbar.make(mRoot, "You just clicked on: " + basicData, Snackbar.LENGTH_SHORT).show();
    }
}
