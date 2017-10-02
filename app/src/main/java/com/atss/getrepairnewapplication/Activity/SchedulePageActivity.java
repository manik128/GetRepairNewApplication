package com.atss.getrepairnewapplication.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atss.getrepairnewapplication.Adapter.ViewPagerAdapter;
import com.atss.getrepairnewapplication.MInterface;
import com.atss.getrepairnewapplication.MainActivity12;
import com.atss.getrepairnewapplication.Mainclass;
import com.atss.getrepairnewapplication.Pojoclass.RepairPojoClass;
import com.atss.getrepairnewapplication.Pojoclass.grfont;
import com.atss.getrepairnewapplication.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SchedulePageActivity extends AppCompatActivity {
    RelativeLayout relativeLayout,relativecalender;
    Date dt;
    EditText etname, etaddress, etmobile, etcity, etstate, etpin,etarea,etemail;
    LinearLayout linearlayouthorscroll;
    int mcur,fmur=0;
    int value;
    String set;
    Button btnverify;
    public static final String MyPREFERENCES = "MyPrefs";
    ProgressDialog progressDialog;
    SharedPreferences settings;
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    String typ,location,pin,area;
    String url = "http://getrepair.in";
   Calendar calendar;
    String[] calender = {"13", "14", "15", "16", "17", "18", "19", "20", "21", "22 ", "23",
            "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] weeks = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    String[] mon = {"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};
    int k, w, pdt, ldt,addrval;
    View child, v1, v2;
    TextInputLayout txtlay, txtlay1, txtlay2;
    TextView tvchangeaddress, tvname, tvhousenopage,tvstreetpage,tvcitypage, tvmobile,tvpin,tvnumber,tvmail,tvresend,
            tvlistname,tvlistaddress,tvlistphone, tvhouseno,tvservicing,tvselectdate,tvselecttime,tvchange, tvcommercial;
    HorizontalScrollView horizontalScrollView;
Button btncontinue;
ImageView ivedit,ivdelete, ivactionmenu;
Mainclass mclass;
String tempaddr, tvdt,tvtm,userid;
    String[] time = {"6am-8am", "8am-10am", "10am-12pm", "12pm-2pm", "2pm-4pm", "4pm-6pm", "6pm-8pm", "8pm-10pm", "10pm-12am", "12am-2am", "2am-4am", "4am-6am"};
    private List database;
    SQLiteDatabase db;
    private long _id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedulepage);
        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarschedule, null);
        getSupportActionBar().setCustomView(mActionBarView);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setElevation(0);
        tvservicing= (TextView) mActionBarView.findViewById(R.id.tvservicing);
        settings = getSharedPreferences(MainActivity.MyPREFERENCES, 0);
        userid=settings.getString("userid","");
        relativecalender = (RelativeLayout) findViewById(R.id.relativecalender);
        linearlayouthorscroll = (LinearLayout) findViewById(R.id.linearlayouthorscroll);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativecalender);
        tvchange = (TextView) findViewById(R.id.tvchange);
        tvservicing = (TextView) findViewById(R.id.tvservicing);
        tvselectdate = (TextView) findViewById(R.id.tvselectdate);
        etname = (EditText) findViewById(R.id.etname);
        etaddress = (EditText) findViewById(R.id.etaddress);
        etmobile = (EditText) findViewById(R.id.etmobile);
        etcity = (EditText) findViewById(R.id.etcity);
        etstate = (EditText) findViewById(R.id.etstate);
        etpin = (EditText) findViewById(R.id.etpin);
        etarea= (EditText) findViewById(R.id.etarea);
        btncontinue = (Button) findViewById(R.id.btncontinue);
        mclass = (Mainclass) getApplicationContext();
        typ= mclass.getUserid();
        location=mclass.getAddress();
        area=mclass.getLocadd();
        pin=mclass.getPin();
        etpin.setText(pin);
        etarea.setText(area);
        etaddress.setText(location);

       // Toast.makeText(SchedulePageActivity.this, "pin" + pin, Toast.LENGTH_SHORT).show();
     //  etname.setText(mclass.getName());
//tvlistname=(TextView)findViewById(R.id.tvlistnamesch);
//tvlistaddress=(TextView)findViewById(R.id.tvlistaddresssch);
//        tvlistphone=(TextView)findViewById(R.id.tvlistmobilesch);
        final grfont[] gr = {new grfont(SchedulePageActivity.this)};
        gr[0].grfonttxt(tvchange);
        gr[0].grfonttxt(tvservicing);
        gr[0].grfonttxt(tvselectdate);

        gr[0].grfontbut(btncontinue);
        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
        ivactionmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchedulePageActivity.this,HomePage.class);

                startActivity(intent);
            }
        });
        progress();
        RestAdapter radapter = new RestAdapter.Builder().setEndpoint(url).build();

        MInterface restInt= radapter.create(MInterface.class);

        restInt.insertuserid(

                //Passing the values by getting it from editTexts

             userid,
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
                            progressDialog.dismiss();
                            String code = json_data.getString("name");
                            String code1 = json_data.getString("email");
                            String code2 = json_data.getString("phoneno");
                            //  String vendorid = json_data.getString("venid");
                             etname.setText(code);
                             etmobile.setText(code2);
                            //Toast.makeText(SchedulePageActivity.this, "error message"+code+code2+typ, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(SchedulePageActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        if(getIntent().getExtras()!=null) {
            addrval= getIntent().getExtras().getInt("address");
//            if(addrval == 1) {
//                final LinearLayout container = (LinearLayout) findViewById(R.id.container_destacado);
//
//                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                final View myView = inflater.inflate(R.layout.addresspagedetails, null);
//                tvhouseno = (TextView) myView.findViewById(R.id.tvhouseno);
//                tvstreetpage = (TextView) myView.findViewById(R.id.tvstreetpage);
//                tvcitypage = (TextView) myView.findViewById(R.id.tvcitypage);
//                tvname = (TextView) myView.findViewById(R.id.tvname);
//                tvmobile = (TextView) myView.findViewById(R.id.tvmobile);
//                ivdelete = (ImageView) myView.findViewById(R.id.ivdelete);
//                gr[0].grfonttxt(tvhouseno);
//                gr[0].grfonttxt(tvstreetpage);
//                gr[0].grfonttxt(tvcitypage);
//                gr[0].grfonttxt(tvname);
//                gr[0].grfonttxt(tvmobile);
//
//                container.addView(myView);
//
//            }

        }
  tvhouseno = (TextView) findViewById(R.id.tvhouseno);
        tvstreetpage=(TextView)findViewById(R.id.tvstreetpage);
        tvcitypage=(TextView)findViewById(R.id.tvcitypage);
        tvname = (TextView) findViewById(R.id.tvname);
        tvmobile = (TextView) findViewById(R.id.tvmobile);






        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String number = etmobile.getText().toString();
                final String pin = etpin.getText().toString();
                if ( tvdt== null) {
                    Snackbar.make(v, "Please select date", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else if (etname.getText().toString().equals("") || etaddress.getText().toString().equals("") || etmobile.getText().toString().equals("") ||etcity. getText().toString().equals("") || etstate.getText().toString().equals("") || etpin.getText().toString().equals("")) {
                    Snackbar.make(v, "Fields Should not be blank", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else if(! isValidPhonenumber(number)){

                    Snackbar.make(v, "Invalid number", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else if(! isValidPinnumber(pin)){

                    Snackbar.make(v, "Invalid pin", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else if ( tvtm== null) {
                        Snackbar.make(v, "Please select time", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                }else {
                    if ((fmur - value) >= ldt) {
                        mcur = mcur + 1;
                    }
                    progress();
                    RestAdapter radapter1 = new RestAdapter.Builder().setEndpoint(url).build();

                    final MInterface restInt1= radapter1.create(MInterface.class);

                    restInt1.insertotp(

                            //Passing the values by getting it from editTexts

                            userid,
                            etmobile.getText().toString(),
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
                                        progressDialog.dismiss();
                                        String code = json_data.getString("status");
                                        if (code.equalsIgnoreCase("success")) {

                                            builder = new AlertDialog.Builder(SchedulePageActivity.this);
                                            builder.setCancelable(false);
                                            View vw = getLayoutInflater().inflate(R.layout.popupverficode, null);
                                            btnverify = (Button) vw.findViewById(R.id.btnverify);
                                            tvnumber = (TextView) vw.findViewById(R.id.tvnumber);
                                            etemail = (EditText) vw.findViewById(R.id.etemail);
                                            tvmail = (TextView) vw.findViewById(R.id.tvmail);
                                            tvresend = (TextView) vw.findViewById(R.id.tvresend);
                                            txtlay = (TextInputLayout) findViewById(R.id.input_layout_email);
                                            set=etmobile.getText().toString();
                                            tvnumber.setText(set);
                                            final grfont[] gr = {new grfont(SchedulePageActivity.this)};
                                            gr[0].grfonttxt(tvnumber);
                                            gr[0].grfonttxt(tvmail);
                                            gr[0].grfonttxt(tvresend);
                                            gr[0].grfontbut(btnverify);

                                            gr[0].grfonttxtinpt(txtlay);
                                            gr[0].grfonted(etemail);
                                            tvresend.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    restInt1.insertotp(

                                                            //Passing the values by getting it from editTexts

                                                            userid,
                                                            etmobile.getText().toString(),
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
                                                                        progressDialog.dismiss();
                                                                        String code = json_data.getString("status");
                                                                        if (code.equalsIgnoreCase("success")) {

                                                                            builder = new AlertDialog.Builder(SchedulePageActivity.this);
                                                                            builder.setCancelable(false);
                                                                            View vw = getLayoutInflater().inflate(R.layout.popupverficode, null);
                                                                            btnverify = (Button) vw.findViewById(R.id.btnverify);
                                                                            tvnumber = (TextView) vw.findViewById(R.id.tvnumber);
                                                                            etemail = (EditText) vw.findViewById(R.id.etemail);
                                                                            tvmail = (TextView) vw.findViewById(R.id.tvmail);
                                                                            tvresend = (TextView) vw.findViewById(R.id.tvresend);
                                                                            txtlay = (TextInputLayout) findViewById(R.id.input_layout_email);
                                                                            set=etmobile.getText().toString();
                                                                            tvnumber.setText(set);
                                                                            final grfont[] gr = {new grfont(SchedulePageActivity.this)};
                                                                            gr[0].grfonttxt(tvnumber);
                                                                            gr[0].grfonttxt(tvmail);
                                                                            gr[0].grfonttxt(tvresend);
                                                                            gr[0].grfontbut(btnverify);

                                                                            gr[0].grfonttxtinpt(txtlay);
                                                                            gr[0].grfonted(etemail);

                                                                            btnverify.setOnClickListener(new View.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(final View v) {

                                                                                    RestAdapter radapter1 = new RestAdapter.Builder().setEndpoint(url).build();

                                                                                    MInterface restInt1= radapter1.create(MInterface.class);

                                                                                    restInt1.insertcheck(

                                                                                            //Passing the values by getting it from editTexts

                                                                                            userid,
                                                                                            etemail.getText().toString(),
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

                                                                                                        String code = json_data.getString("status");
                                                                                                        if (code.equalsIgnoreCase("match")) {

                                                                                                            mclass.setName(etname.getText().toString());
                                                                                                            mclass.setFulladdress(etaddress.getText().toString()+etcity.getText().toString()+etstate.getText().toString()+etarea.getText().toString()+etpin.getText().toString());
                                                                                                            mclass.setMobilenumber(etmobile.getText().toString());
                                                                                                            mclass.setDate(Integer.toString(value) + "," + mon[mcur] + "," + calendar.get(Calendar.YEAR));
                                                                                                            Intent intent = new Intent(SchedulePageActivity.this, OrdersummaryActivity.class);
                                                                                                            startActivityForResult(intent, 2);
                                                                                                        }else {
                                                                                                            Snackbar.make(v, "Enter valid verification number", Snackbar.LENGTH_LONG)
                                                                                                                    .setAction("Action", null).show();
                                                                                                        }

                                                                                                    } catch (JSONException e) {
                                                                                                        e.printStackTrace();
                                                                                                    }
                                                                                                    //Displaying the output as a toast
                                                                                                    //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                                                                                                }

                                                                                                @Override
                                                                                                public void failure(RetrofitError error) {
                                                                                                    //If any error occured displaying the error as toast
                                                                                                    Toast.makeText(SchedulePageActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                                                                                                }
                                                                                            }
                                                                                    );

                                                                                }
                                                                            });
                                                                            builder.setView(vw);
                                                                            alertDialog = builder.create();
                                                                            alertDialog.show();



                                                                        }

                                                                    } catch (JSONException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                    //Displaying the output as a toast
                                                                    //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                                                                }

                                                                @Override
                                                                public void failure(RetrofitError error) {
                                                                    //If any error occured displaying the error as toast
                                                                    Toast.makeText(SchedulePageActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                                                                }
                                                            }
                                                    );
                                                }
                                            });
                                            btnverify.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(final View v) {

                                                    RestAdapter radapter1 = new RestAdapter.Builder().setEndpoint(url).build();

                                                    MInterface restInt1= radapter1.create(MInterface.class);

                                                    restInt1.insertcheck(

                                                            //Passing the values by getting it from editTexts

                                                            userid,
                                                           etemail.getText().toString(),
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

                                                                        String code = json_data.getString("status");
                                                                        if (code.equalsIgnoreCase("match")) {

                                                                            mclass.setName(etname.getText().toString());
                                                                            mclass.setFulladdress(etaddress.getText().toString()+etcity.getText().toString()+etstate.getText().toString()+etarea.getText().toString()+etpin.getText().toString());
                                                                            mclass.setMobilenumber(etmobile.getText().toString());
                                                                            mclass.setDate(Integer.toString(value) + "," + mon[mcur] + "," + calendar.get(Calendar.YEAR));
                                                                            Intent intent = new Intent(SchedulePageActivity.this, OrdersummaryActivity.class);
                                                                            startActivityForResult(intent, 2);
                                                                        }else {
                                                                            Snackbar.make(v, "Enter valid verification number", Snackbar.LENGTH_LONG)
                                                                                    .setAction("Action", null).show();
                                                                        }

                                                                    } catch (JSONException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                    //Displaying the output as a toast
                                                                    //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                                                                }

                                                                @Override
                                                                public void failure(RetrofitError error) {
                                                                    //If any error occured displaying the error as toast
                                                                    Toast.makeText(SchedulePageActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                                                                }
                                                            }
                                                    );

                                                }
                                            });
                                            builder.setView(vw);
                                            alertDialog = builder.create();
                                            alertDialog.show();



                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    //Displaying the output as a toast
                                    //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void failure(RetrofitError error) {
                                    //If any error occured displaying the error as toast
                                    Toast.makeText(SchedulePageActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                                }
                            }
                    );

                }

            }
        });

        SimpleDateFormat sdf = new SimpleDateFormat("dd");

        Date today = new Date();
         calendar = Calendar.getInstance();


        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        dt = new Date();
        calender[0] = sdf.format(dt);
         mcur=calendar.get(Calendar.MONTH);
          // int s=calendar.get(Calendar.);

            k = Integer.parseInt(calender[0])-1;
            fmur=k;
        final SimpleDateFormat sdf_ = new SimpleDateFormat("EEE");
       String s=sdf_ .format(dt);
        for (int m = 0; m < weeks.length; m++) {
            if (sdf_.format(dt).equals(weeks[m])) {
                break;
            }
            else{
                w = m + 1;
            }
        }

        ldt = Integer.parseInt(sdf.format(lastDayOfMonth));
        LinearLayout root = (LinearLayout) findViewById(R.id.linearlayouthorscroll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        root.setOrientation(LinearLayout.HORIZONTAL);
        root.setPadding(10, 10, 10, 10);
        for (int j = 1; j <= 20; j++) {
            //calender[j-1] = Integer.toString(k);
            fmur=fmur+1;
            if (k == ldt) {
                pdt = 0;
            } else {
                pdt = Integer.parseInt(Integer.toString(k));

            }
            k = pdt + 1;



            dt = new Date();
            //Calendar c = Calendar.getInstance();
            RepairPojoClass pojoClass = new RepairPojoClass(new LinearLayout(SchedulePageActivity.this), j);
            pojoClass.getLinearLayout().setOrientation(LinearLayout.HORIZONTAL);
            pojoClass.getLinearLayout().setPadding(10, 10, 10, 10);
            params.setMargins(2, 0, 2, 0);
            pojoClass.getLinearLayout().setLayoutParams(params);
            pojoClass.getLinearLayout().setClickable(true);
            final TextView tvdate = new TextView(SchedulePageActivity.this);
            //tvdate.setText(calender[j]);

            gr[0] = new grfont(SchedulePageActivity.this);
            gr[0].grfonttxt(tvdate);
            tvdate.setTextSize(18);
            tvdate.setPadding(10, 10, 10, 10);

            tvdate.setText(Integer.toString(k) + "\n" + weeks[w]);
            w++;
            if (w > 6) {
                w = 0;
            }

            pojoClass.getLinearLayout().addView(tvdate);
            final int positon = pojoClass.getPosition();
            pojoClass.getLinearLayout().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvdt= (tvdate.getText().toString().replaceAll("[^0-9]", ""));

                    value = Integer.parseInt(tvdate.getText().toString().replaceAll("[^0-9]", ""));
                    if (v2 != null) {
                        v2.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                    v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                    child = getLayoutInflater().inflate(R.layout.item_sechdule, null);
                    relativeLayout.addView(child);
                    v2 = v;
                  tvselecttime=(TextView)findViewById(R.id.tvselecttime);
                    //    horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalheadbar);
                    LinearLayout root1 = (LinearLayout) findViewById(R.id.linearlayouthorscrollitem);
                    LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    root1.setOrientation(LinearLayout.HORIZONTAL);
                    root1.setPadding(10, 10, 10, 10);
                    for (int i = 0; i <= 11; i++) {
                        final TextView tvtime = new TextView(SchedulePageActivity.this);
                        tvtime.setText(time[i]);
                        gr[0] = new grfont(SchedulePageActivity.this);
                        gr[0].grfonttxt(tvtime);
                        gr[0].grfonttxt(tvselecttime);
                      //  mclass.setTime(tvtime.getText().toString());
                        // tvtime.setTextColor(Color.parseColor("#0088B0"));
                        tvtime.setTextSize(18);
                        tvtime.setPadding(20, 0, 20, 0);

                        root1.addView(tvtime);

                        tvtime.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          tvtm= (tvtime.getText().toString().replaceAll("[^0-9]", ""));
                                                          mclass.setTime(tvtime.getText().toString());
                                                          if (v1 != null) {
                                                              v1.setBackgroundColor(Color.parseColor("#ffffff"));

                                                          }
                                                          v.setBackgroundColor(Color.parseColor("#ecf0f1"));
                                                          v1 = v;
                                                      }
                                                  }

                        );
                    }
                }


            });

            root.addView(pojoClass.getLinearLayout());
        }
    }
    private boolean isValidPhonenumber(String number) {

        if (number !=null && number.length()<=10&&number.length()>=10){
            return true;
        }
        return false;
    }
    private boolean isValidPinnumber(String pin) {

        if (pin !=null && pin.length()<=6&&pin.length()>=6){
            return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                String address= data.getStringExtra("address");
                String mobile = data.getStringExtra("mobile");
                String city = data.getStringExtra("city");
                String state = data.getStringExtra("state");
                String pin = data.getStringExtra("pin");
                tvname.setText(name);
                tvhouseno.setText(address);
                tvstreetpage.setText(state);
                tvcitypage.setText(city);
                tvmobile.setText(mobile);

            }
        }else if (requestCode==5){
            if (resultCode==RESULT_OK){

                String s=  data.getStringExtra("name");
                String s1=data.getStringExtra("address");
                String s2=data.getStringExtra("mobile");
               // tvlistaddress.setText(s1);
              //  tvlistphone.setText(s2);
           //     Toast.makeText(SchedulePageActivity.this,s+"inserted",Toast.LENGTH_SHORT).show();
              //  tvlistname.setText(s);
            }
       }
        }
    public void progress(){
        progressDialog = new ProgressDialog(
                SchedulePageActivity.this);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Loading ...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.show();
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(SchedulePageActivity.this,HomePage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
    }
