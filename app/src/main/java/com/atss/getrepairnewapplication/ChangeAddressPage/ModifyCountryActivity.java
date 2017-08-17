package com.atss.getrepairnewapplication.ChangeAddressPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.atss.getrepairnewapplication.R;


public class ModifyCountryActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etname;
    private Button updateBtn, deleteBtn,btnaddress;
    private EditText etaddress,etmobile;

    private long _id;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Record");
        setContentView(R.layout.activity_editlist);
        dbManager = new DBManager(this);
        dbManager.open();
        etname = (EditText) findViewById(R.id.etnamelist);
        etaddress = (EditText) findViewById(R.id.etaddresslist);
        etmobile=(EditText)findViewById(R.id.etmobilelist);
        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
//btnaddress=(Button)findViewById(R.id.btnaddress);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
String mobile=intent.getStringExtra("mobile");
        _id = Long.parseLong(id);
        etname.setText(name);
        etaddress.setText(address);
        etmobile.setText(mobile);
//btnaddress.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

   /* @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnaddress:
                String name = etname.getText().toString();
                String address = etaddress.getText().toString();
                dbManager.update(_id, name, address);
                this.returnHome();
        }
    }*/

     @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_update:
                    String name = etname.getText().toString();
                    String address = etaddress.getText().toString();
          String mobile=etmobile.getText().toString();
                    dbManager.update(_id, name, address,mobile);
                    this.returnHome();
                    break;

                case R.id.btn_delete:
                    dbManager.delete(_id);
                    this.returnHome();
                    break;
            }
        }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(),ChangeAddressActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
 /*   public void returnHome1(){
        Intent home_intent = new Intent(getApplicationContext(),ChangeAddressActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }*/
}
