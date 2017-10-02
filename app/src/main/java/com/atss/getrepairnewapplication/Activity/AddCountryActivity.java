package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.atss.getrepairnewapplication.LocalDb.DBManager;
import com.atss.getrepairnewapplication.R;


public class AddCountryActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnsave;
    private EditText etname;
    private EditText etaddress,etmobile;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Record");

        setContentView(R.layout.activity_addadress);

        etname = (EditText) findViewById(R.id.etname);
        etaddress = (EditText) findViewById(R.id.etaddress);
        etmobile=(EditText)findViewById(R.id.etmobile);

        btnsave = (Button) findViewById(R.id.btnsave);

        dbManager = new DBManager(this);
        dbManager.open();
       btnsave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsave:

                final String name = etname.getText().toString();
                final String address = etaddress.getText().toString();
                String mobile=etmobile.getText().toString();
                dbManager.insert(name, address,mobile);

                Intent main = new Intent(AddCountryActivity.this, ChangeAddressActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }
}
