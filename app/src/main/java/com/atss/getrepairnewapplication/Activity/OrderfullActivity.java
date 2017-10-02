package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.atss.getrepairnewapplication.R;

public class OrderfullActivity extends AppCompatActivity {
    ImageView ivactionmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderfull);
        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarorderdetails, null);
        getSupportActionBar().setCustomView(mActionBarView);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setElevation(0);
        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
        ivactionmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderfullActivity.this,OrderActivity.class);

                startActivity(intent);
            }
        });
    }
}
