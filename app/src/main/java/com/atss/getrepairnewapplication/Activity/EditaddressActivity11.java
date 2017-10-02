package com.atss.getrepairnewapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.atss.getrepairnewapplication.Mainclass;
import com.atss.getrepairnewapplication.R;
import com.google.android.gms.common.api.GoogleApiClient;


public class EditaddressActivity11 extends AppCompatActivity {
EditText etname,etaddress,etmobile,ethousenumber,etstreet;
    Button btnsaveedit;
    Mainclass mclass;
    private GoogleApiClient mGoogleApiClient;
    Geocoder geocoder;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editaddress);
        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbaredit, null);
        getSupportActionBar().setCustomView(mActionBarView);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setElevation(0);
        etname = (EditText) findViewById(R.id.etnameedit);
        etaddress = (EditText) findViewById(R.id.etaddressedit);
        etmobile = (EditText) findViewById(R.id.etmobileedit);
        ethousenumber = (EditText) findViewById(R.id.ethouseedit);
        etstreet = (EditText) findViewById(R.id.etstreetedit);
        btnsaveedit = (Button) findViewById(R.id.btnsaveedit);
        mclass=new Mainclass();
        Activity mContext = EditaddressActivity11.this;//change this your activity name
        StartLocationAlert startLocationAlert = new StartLocationAlert(mContext);

        btnsaveedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
//                LinearLayout container = (LinearLayout)findViewById(R.id.container_destacado);
//
//                LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View myView = inflater.inflate(R.layout.addresspagedetails, null);
                intent.putExtra("name", etname.getText().toString());
                intent.putExtra("address", etaddress.getText().toString());
                intent.putExtra("mobile", etmobile.getText().toString());
                intent.putExtra("house", ethousenumber.getText().toString());
                intent.putExtra("street", etstreet.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }


    }



