package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.atss.getrepairnewapplication.Pojoclass.grfont;
import com.atss.getrepairnewapplication.R;

public class Forgotpassword extends AppCompatActivity {
Button btnsubmit;
    EditText email;
    TextInputLayout txtlay,txtlay1,txtlay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        getSupportActionBar().hide();
        txtlay1 = ( TextInputLayout ) findViewById(R.id.input_layout_email);
        email=(EditText)findViewById(R.id.etemail);
        btnsubmit=(Button)findViewById(R.id.btnsubmit);
        grfont gr= new grfont(Forgotpassword.this);
        gr.grfontbut(btnsubmit);
        gr.grfonted(email);
        gr.grfonttxtinpt(txtlay1);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Forgotpassword.this,Verficationcode.class);
                startActivity(intent);
            }
        });
    }
}
