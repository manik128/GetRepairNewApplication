package com.atss.getrepairnewapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atss.getrepairnewapplication.MInterface;
import com.atss.getrepairnewapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AddtocartActivity extends AppCompatActivity {
    LinearLayout insertPoint;
    TextView  tvcommercial,tvselectmake,tvservice,tvrepair,tvorders;
    View view;
    String url = "http://getrepair.in";
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
        tvselectmake=(TextView) view.findViewById(R.id.tvselectmake);
        tvservice=(TextView) view.findViewById(R.id.tvservice);
        tvrepair=(TextView) view.findViewById(R.id.tvrepair);
        tvorders=(TextView) view.findViewById(R.id.tvorders);
        RestAdapter radapter = new RestAdapter.Builder().setEndpoint(url).build();

        MInterface restInt = radapter.create(MInterface.class);
        restInt.insertcart(

                //Passing the values by getting it from editTexts
                cart,



                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {

                            JSONObject json_data = new JSONObject(output);
                            //json_data.put("us", result);
                            //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                            //json_data.put("code", result);

                            String code = json_data.getString("cart");

                            final View mActionBarView1 = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                            getSupportActionBar().setCustomView(mActionBarView1);
                            getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                            getSupportActionBar().setElevation(0);
                            tvcommercial = (TextView)mActionBarView1.findViewById(R.id.tvcommercial);
                            badgent = (TextView)mActionBarView1.findViewById(R.id.badgent);
                            tvcommercial.setText(catvalue);
                            gr.grfonttxt(tvcommercial);
                            mclass.setCart(code);
                            //  String vendorid = json_data.getString("venid");

                            badgent.setText(code);
                            badgent.setVisibility(View.VISIBLE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(ServicingActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        insertPoint.addView(view);

    }

}
