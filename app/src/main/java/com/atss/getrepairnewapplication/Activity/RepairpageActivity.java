package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.atss.getrepairnewapplication.R;

public class RepairpageActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Button btntips,btninfor;
    RelativeLayout rltips,rltipinformation;
    LinearLayout repairguarantee;
    TextView tvbrand,tvissue;
   boolean press;
    Spinner spinnerbrand;
    ImageView ivlist2,ivlist1;
    String[] type = {"Brand", "Bajaj Avenger", "Bajaj Discover","Bajaj Platina","Bajaj Pulsar"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairpage);
        btntips=(Button)findViewById(R.id.btntips);
        btninfor=(Button)findViewById(R.id.btninfor);
        rltips=(RelativeLayout)findViewById(R.id.rltips);
repairguarantee=(LinearLayout)findViewById(R.id.repairguarantee);
        repairguarantee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RepairpageActivity.this,GuaranteeActivity.class);
                startActivity(intent);
            }
        });

      spinnerbrand=(Spinner)findViewById(R.id.spinnerbrand);
        spinnerbrand.setOnItemSelectedListener(this);
        final ArrayAdapter aasp = new ArrayAdapter(RepairpageActivity.this, android.R.layout.simple_spinner_item,type);
        aasp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerbrand.setAdapter(aasp);
        rltipinformation=(RelativeLayout)findViewById(R.id.rltipinformation);
        ivlist1=(ImageView)findViewById(R.id.ivlist1);


       /* rlbrandtop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate(R.layout.brand,null);
                if (press==true){

                    rlbrand.addView(view);
                    rlbrand.setVisibility(View.VISIBLE);
                    ivlist1.setImageResource(R.drawable.drop1);
                    press=false;

                }
                else{
                   rlbrand.setVisibility(View.GONE);
                    rlbrand.removeView(view);
                    ivlist1.setImageResource(R.drawable.drop);
                    press=true;
                }
            }
        });*/


        btntips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rltips.setVisibility(View.VISIBLE);
                rltipinformation.setVisibility(View.GONE);
                btntips.setClickable(false);
                btninfor.setClickable(true);
                btntips.setBackgroundResource(R.drawable.myborderbuildingblue);
                btninfor.setBackgroundResource(R.drawable.myborderrecrepair);
            }
        });
        btninfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btninfor.setClickable(false);
                btntips.setClickable(true);
                rltips.setVisibility(View.GONE);
                rltipinformation.setVisibility(View.VISIBLE);
                btninfor.setBackgroundResource(R.drawable.myborderbuildingblue);
                btntips.setBackgroundResource(R.drawable.myborderrecrepair);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
