package com.atss.getrepairnewapplication.SchedulePage;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.atss.getrepairnewapplication.ChangeAddressPage.AddadressActivity;
import com.atss.getrepairnewapplication.HomePage;
import com.atss.getrepairnewapplication.Mainclass;
import com.atss.getrepairnewapplication.OrdersummaryActivity;
import com.atss.getrepairnewapplication.R;
import com.atss.getrepairnewapplication.RepairPojoClass;
import com.atss.getrepairnewapplication.grfont;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SchedulePageActivity extends AppCompatActivity {
    RelativeLayout relativeLayout,relativecalender;
    Date dt;
    LinearLayout linearlayouthorscroll;
    int mcur,fmur=0;
    int value;
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
    TextView tvchangeaddress, tvname, tvhousenopage,tvstreetpage,tvcitypage, tvmobile,tvpin,
            tvlistname,tvlistaddress,tvlistphone, tvhouseno,tvservicing,tvselectdate,tvselecttime,tvchange, tvcommercial;
    HorizontalScrollView horizontalScrollView;
Button btncontinue;
ImageView ivedit,ivdelete, ivactionmenu;
Mainclass mclass;
String tempaddr, tvdt,tvtm;
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

        relativecalender = (RelativeLayout) findViewById(R.id.relativecalender);
        linearlayouthorscroll = (LinearLayout) findViewById(R.id.linearlayouthorscroll);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativecalender);
        tvchange = (TextView) findViewById(R.id.tvchange);
        tvservicing = (TextView) findViewById(R.id.tvservicing);
        tvselectdate = (TextView) findViewById(R.id.tvselectdate);

        btncontinue = (Button) findViewById(R.id.btncontinue);
       mclass = (Mainclass) getApplicationContext();
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
        if(getIntent().getExtras()!=null) {
            addrval= getIntent().getExtras().getInt("address");
            if(addrval == 1) {
                final LinearLayout container = (LinearLayout) findViewById(R.id.container_destacado);

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View myView = inflater.inflate(R.layout.addresspagedetails, null);
                tvhouseno = (TextView) myView.findViewById(R.id.tvhouseno);
                tvstreetpage = (TextView) myView.findViewById(R.id.tvstreetpage);
                tvcitypage = (TextView) myView.findViewById(R.id.tvcitypage);
                tvname = (TextView) myView.findViewById(R.id.tvname);
                tvmobile = (TextView) myView.findViewById(R.id.tvmobile);
                ivdelete = (ImageView) myView.findViewById(R.id.ivdelete);
                gr[0].grfonttxt(tvhouseno);
                gr[0].grfonttxt(tvstreetpage);
                gr[0].grfonttxt(tvcitypage);
                gr[0].grfonttxt(tvname);
                gr[0].grfonttxt(tvmobile);

                container.addView(myView);

            }

        }
  tvhouseno = (TextView) findViewById(R.id.tvhouseno);
        tvstreetpage=(TextView)findViewById(R.id.tvstreetpage);
        tvcitypage=(TextView)findViewById(R.id.tvcitypage);
        tvname = (TextView) findViewById(R.id.tvname);
        tvmobile = (TextView) findViewById(R.id.tvmobile);


        final LinearLayout container = (LinearLayout)findViewById(R.id.container_destacado);

        LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View myView = inflater.inflate(R.layout.addresspagedetails, null);
        tvhouseno = (TextView) myView.findViewById(R.id.tvhouseno);
        tvstreetpage=(TextView)myView.findViewById(R.id.tvstreetpage);
        tvcitypage=(TextView)myView.findViewById(R.id.tvcitypage);
        tvname = (TextView)myView.findViewById(R.id.tvname);
        tvpin = (TextView) myView.findViewById(R.id.tvpinpage);
        tvmobile = (TextView) myView.findViewById(R.id.tvmobile);
        ivdelete = (ImageView) myView.findViewById(R.id.ivdelete);
        gr[0].grfonttxt(tvhouseno);
        gr[0].grfonttxt(tvstreetpage);
        gr[0].grfonttxt(tvcitypage);
        gr[0].grfonttxt(tvname);
        gr[0].grfonttxt(tvmobile);
       tvname.setText(mclass.getName());
       tvhouseno.setText(mclass.getAddress());
       tvmobile.setText(mclass.getMobilenumber());
      tvcitypage.setText(mclass.getCity());
        tvstreetpage.setText(mclass.getState());
       tvpin.setText(mclass.getPin());
        container.addView(myView);
        tvname.setText(mclass.getName());
        tvhouseno.setText(mclass.getAddress());
        tvcitypage.setText(mclass.getCity());
        tvstreetpage.setText(mclass.getArea());
        tvpin.setText(mclass.getPin());
        tempaddr=mclass.getLocadd();




        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( tvdt== null) {
                    Snackbar.make(v, "Please select date", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else if ( tvtm== null) {
                        Snackbar.make(v, "Please select time", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                }else {
                    if ((fmur - value) >= ldt) {
                        mcur = mcur + 1;
                    }
                    mclass.setDate(Integer.toString(value) + "," + mon[mcur] + "," + calendar.get(Calendar.YEAR));
                    Intent intent = new Intent(SchedulePageActivity.this, OrdersummaryActivity.class);
                    startActivityForResult(intent, 2);
                }

            }
        });

ivedit=(ImageView)findViewById(R.id.ivedit);
        ivedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SchedulePageActivity.this, AddadressActivity.class);
                intent.putExtra("name", tvname.getText().toString());
                intent.putExtra("address",tvhouseno.getText().toString());
                intent.putExtra("mobile", tvmobile.getText().toString());
                intent.putExtra("state", tvcitypage.getText().toString());
                intent.putExtra("pin", tvpin.getText().toString());
                //intent.putExtra("state", etstate.getText().toString());
                //intent.putExtra("pin", etpin.getText().toString());
                startActivityForResult(intent, 2);

//              Intent intent = new Intent();
////                LinearLayout container = (LinearLayout)findViewById(R.id.container_destacado);
////
////                LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////                View myView = inflater.inflate(R.layout.addresspagedetails, null);
//                intent.putExtra("name", tvname.getText().toString());
//                intent.putExtra("address", tvhouseno.getText().toString());
//                intent.putExtra("mobile", tvmobile.getText().toString());
//                intent.putExtra("city", tvcitypage.getText().toString());
//                intent.putExtra("state", tvstreetpage.getText().toString());
//               // intent.putExtra("pin", etpin.getText().toString());
//                setResult(RESULT_OK, intent);
//                finish();
            }
        });


//        tvchange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//                    Intent intent = new Intent(SchedulePageActivity.this,AddadressActivity.class);
//
//                    startActivity(intent);
//
//
//            }
//        });
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
        final SimpleDateFormat sdf_ = new SimpleDateFormat("EE");
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
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(SchedulePageActivity.this,HomePage.class);

        startActivity(intent);
    }
    }
