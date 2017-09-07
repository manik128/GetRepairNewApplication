package com.atss.getrepairnewapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atss.getrepairnewapplication.R;

public class AddtocartActivity extends AppCompatActivity {
    LinearLayout insertPoint;
    TextView  tvcommercial;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocart);
        View mActionBarView = getLayoutInflater().inflate(R.layout.actioncart, null);
        getSupportActionBar().setCustomView(mActionBarView);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setElevation(0);
        tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
        insertPoint = (LinearLayout) findViewById(R.id.contacts_type);
        view = getLayoutInflater().inflate(R.layout.cart, null);
        insertPoint.addView(view);
    }

}
