package com.atss.getrepairnewapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Newpassword extends AppCompatActivity {
    Button btnsubmit;
    EditText email,etpassword;
    TextInputLayout txtlay,txtlay1,txtlay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);
        getSupportActionBar().hide();
        btnsubmit=(Button)findViewById(R.id.btnsubmit);
        txtlay1 = ( TextInputLayout ) findViewById(R.id.input_layout_email);
        email=(EditText)findViewById(R.id.etemail);
        txtlay2 = ( TextInputLayout ) findViewById(R.id.input_layout_password);
        etpassword=(EditText)findViewById(R.id.etpassword);
        grfont gr= new grfont(Newpassword.this);
        gr.grfontbut(btnsubmit);
        gr.grfonted(email);
        gr.grfonted(etpassword);
        gr.grfonttxtinpt(txtlay1);
        gr.grfonttxtinpt(txtlay2);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Newpassword.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
