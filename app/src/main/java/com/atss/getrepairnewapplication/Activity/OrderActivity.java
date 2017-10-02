package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.atss.getrepairnewapplication.Adapter.MyRecyclerVieworderAdapter;
import com.atss.getrepairnewapplication.Pojoclass.DataObjectorder;
import com.atss.getrepairnewapplication.R;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    private List<DataObjectorder> orderlist = new ArrayList<>();
    private RecyclerView recyclerView;
    MyRecyclerVieworderAdapter myadapter;
    ImageView ivactionmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarorders, null);
        getSupportActionBar().setCustomView(mActionBarView);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setElevation(0);
        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
        ivactionmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this,HomePage.class);

                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        myadapter = new MyRecyclerVieworderAdapter(OrderActivity.this,orderlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myadapter);

        prepareOrderData();
    }
    private void prepareOrderData() {
       DataObjectorder order = new DataObjectorder("11013", "Refridgerator","refrigerator","refrigerator",R.drawable.skyline);
        orderlist.add(order);

        order = new DataObjectorder("11013", "Refridgerator","refrigerator","refrigerator",R.drawable.tire);
        orderlist.add(order);



        myadapter.notifyDataSetChanged();
    }
}
