package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.atss.getrepairnewapplication.Mainclass;
import com.atss.getrepairnewapplication.R;



public class AddadressActivity extends AppCompatActivity {
    EditText etname, etaddress, etmobile, etcity, etstate, etpin;
    ImageView ivactionmenu;
    Button btnsave;
    Mainclass mclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbaraddress, null);
        getSupportActionBar().setCustomView(mActionBarView);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setElevation(0);
        mclass = (Mainclass) getApplicationContext();
        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
        ivactionmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddadressActivity.this, SchedulePageActivity.class);

                startActivity(intent);
            }
        });
        setContentView(R.layout.activity_addadress);
        etname = (EditText) findViewById(R.id.etname);
        etaddress = (EditText) findViewById(R.id.etaddress);
        etmobile = (EditText) findViewById(R.id.etmobile);
        etcity = (EditText) findViewById(R.id.etcity);
        etstate = (EditText) findViewById(R.id.etstate);
        etpin = (EditText) findViewById(R.id.etpin);
        btnsave = (Button) findViewById(R.id.btnsave);
        if (getIntent().getExtras() != null) {

            String name = getIntent().getExtras().getString("name");
            String addr = getIntent().getExtras().getString("address");
            String mob = getIntent().getExtras().getString("mobile");
            String state = getIntent().getExtras().getString("state");
            String pin = getIntent().getExtras().getString("pin");
            etname.setText(name);
            etaddress.setText(addr);
            etmobile.setText(mob);
            etstate.setText(state);
            etpin.setText(pin);
        }
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etname.getText().toString().equals("") || etaddress.getText().toString().equals("") || etmobile.getText().toString().equals("") ||etcity. getText().toString().equals("") || etstate.getText().toString().equals("") || etpin.getText().toString().equals("")) {
                    Snackbar.make(v, "Fields Should not be blank", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    Intent intent = new Intent(AddadressActivity.this,SchedulePageActivity.class);
                    intent.putExtra("address", 1);
                    mclass.setName(etname.getText().toString());
                    mclass.setAddress(etaddress.getText().toString());
                    mclass.setMobilenumber(etmobile.getText().toString());
                    mclass.setCity(etcity.getText().toString());
                    mclass.setState(etstate.getText().toString());
                    mclass.setPin(etpin.getText().toString());
                    startActivity(intent);
//                startActivityForResult(intent, 2);
//                    intent = new Intent();
//                LinearLayout container = (LinearLayout)findViewById(R.id.container_destacado);
//
//               LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//               View myView = inflater.inflate(R.layout.addresspagedetails, null);
//               intent.putExtra("name", etname.getText().toString());
//                intent.putExtra("address", etaddress.getText().toString());
//                intent.putExtra("mobile", etmobile.getText().toString());
//                intent.putExtra("city", etcity.getText().toString());
//                intent.putExtra("state", etstate.getText().toString());
//                intent.putExtra("pin", etpin.getText().toString());
//                setResult(RESULT_OK, intent);
//                finish();


                }


//
            }
        });


    }
}
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 2) {
//            if (resultCode == RESULT_OK) {
//                String name = data.getStringExtra("name");
//                String address = data.getStringExtra("address");
//                String mobile = data.getStringExtra("mobile");
//                String city = data.getStringExtra("city");
//                String state = data.getStringExtra("state");
//                String pin = data.getStringExtra("pin");
//                etname.setText(name);
//                etaddress.setText(address);
//                etstate.setText(state);
//                etcity.setText(city);
//                etmobile.setText(mobile);
//
//            }
//        }
//    }


