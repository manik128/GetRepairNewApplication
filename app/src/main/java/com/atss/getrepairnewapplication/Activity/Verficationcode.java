package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.atss.getrepairnewapplication.Pojoclass.grfont;
import com.atss.getrepairnewapplication.R;

public class Verficationcode extends AppCompatActivity {
Button btnverify;
    TextView tvmail;
    EditText email;
    TextInputLayout txtlay,txtlay1,txtlay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verficationcode);
        getSupportActionBar().hide();
        btnverify=(Button)findViewById(R.id.btnverify);
       tvmail=(TextView) findViewById(R.id.tvmail);
        txtlay1 = ( TextInputLayout ) findViewById(R.id.input_layout_email);
        email=(EditText)findViewById(R.id.etemail);
        grfont gr= new grfont(Verficationcode.this);
        gr.grfontbut(btnverify);
       gr.grfonttxt(tvmail);
        gr.grfonted(email);
        gr.grfonttxtinpt(txtlay1);

        btnverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Verficationcode.this,Newpassword.class);
                startActivity(intent);
}
});

        }
        }
