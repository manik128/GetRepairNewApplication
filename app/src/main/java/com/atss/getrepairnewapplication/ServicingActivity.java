package com.atss.getrepairnewapplication;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.atss.getrepairnewapplication.SchedulePage.Getrepairpojo;
import com.atss.getrepairnewapplication.SchedulePage.SchedulePageActivity;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.atss.getrepairnewapplication.R.id.radioGroup;
import static com.atss.getrepairnewapplication.R.id.sppositonsells;

public class ServicingActivity extends AppCompatActivity {
    TextView tvpeople, tvchild, tvservicing, tvarticles, tvguarantee, tvverify, tvprofessional, tvinsured, tvwork, tvsatisfaction, tvguaranteed, tveasy, tvpayment, tvtype, tvselectarea, tvselectmake, tvfloors, tvbudget, tvvehicle, tvone, tvtwo, tvthree, tvfromdate,tvtodate,tvconstructionbuy,tvmovebuy,tvquotation,tvfour,tveight,tvfive,tvcount1,tvcount2,tvcount3,tvintime,tvouttime,tvcount4,tvcompany,tvselectareas,tvarea,tvfood,tvselectmakes,tvselect,tvrequested,tventer,tvcommercial,tvgender,tvduty,tvqty,tvsericetype,tvweekoff,tvchoose,tvcounts,tvcount,tvcounting,tvlive,tvfloor,tvlift,tvlives,tvflooring,tvlifts,tvlocation,tvwantrentcomm,tvaddress, tvtripdate,intime,tvspinner;
    CheckBox basicCheckBox;
    ImageView imageview,ivminus2,ivminus3,ivplus2,ivplus3,ivminus4,ivplus4, ivplusone,ivminus1;

    EditText etselectmakes, etminimum, etfrom,etto,edaddress;
    LinearLayout linearLayout,contact,llinear;
    private TimePicker timePicker;
    int count = 1, count1 = 0, count2 = 2, count3 = 1;
    RelativeLayout relativeLayout, relativeLayout1, relativeLayout2, relativeLayout3;
    View view;
    Button btncontinue,set_button,btnyes,btnno,btnadd, set_buttons,  setbutton;
    int noofsize = 3;
    int position,budgflag=1;
    ImageView indicator1, indicator2, indicator3,ivactionmenu;
    grfont gr;
    Context con;
    RadioButton radioM;
    RadioButton radioF;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup radiog;
    RadioGroup radiogp;
    String gender;
     MultiAutoCompleteTextView multiAutoCompleteTextView1,multiAutoCompleteTextView,multiAutoCompleteTextViews,multiAutoCompleteTextView3 ;
    HorizontalScrollView horizontalScrollView;
    private String format = "";
RelativeLayout relativespinnerfloors,rlrs1,rlsppositonsells,rlrs3,rlrs2,rlrs4,rlvehicle;
    View view1;
    private Typeface myFont;
    Mainclass mclass;
    int pos;
    String selection, size, areas,floorses,Budget,catvalue,radio,linear;
    String timeslot;
    String selections;
    int positon, sertyp,selhrs,selmin;
    LayoutInflater layoutInflator;
    String fName, fcat,fservice,fservices,fhouse,fwithin,fsell,fwithout;
    LinearLayout insertPoint, insertchoose, insertPoints,insertPointing;
    Getrepairpojo pojo;
    Calendar mycalendar,mycalendar1;
    ListView lv;
    String[] geyser = {"Dripping geyser overflow", "Overheating", "Water not hot enough", "Geyser making noise ", "Discolored Water", "Water leaking through the ceiling", "Other problems"};
    String[] theatre = {"The HDMI Connection Doesn't Work", "The Turntable Volume is Very Low ", "Poor Sound or no sound at all", "No Signal from the home theater", "Other problems"};
    String[] washing = {"washer is vibrating", "washing machine leaking", "washer will not run or fill with water", "washer won’t drain or spin correctly", "motor overheated", "Water temperature hign or low", "Other Problems"};
    String[] refri = {"Refrigerator not cooling", "Refrigerator ice maker not working", "Refrigerator ice maker not working", "Refrigerator not defrosting", "Refrigerator is noisy or loud", "Refrigerator Won't Turn On", "Other Problems"};
    String[] dvd = {"DVD Drive Does not Play the DVD", "DVD keeps freezing or skipping", "Miscellaneous Problems", "Startup Problems", "General System Problems", "Other Problems"};

    String[] tvrepair = {"Television turns on and off by itself", " Video Issue or No Video", " Remote Issue", "Picture Problems", "picture but no sound", "sound without picture", "sound problem", "Other Services"};
    String[] name = {"Basic Inspection", "Battery- Charging", "Battery- Replacement", "Engine Oil Change", "Other Repairs"};
    String[] names = {"Getrepair Servicing"};
    String[] rent = {"2k-4k","4k-6k","6k-8k","8k-10k","10k-12k","12k-16k","16k-20k","Above"};
    String[] Hr = {"HR Manger","HR Executive","HR Asst.Manager","HR Trainee","Others"};
    String[] financial = {"Certified Financial Planner","Chartered Financial Analyst","Chartered Financial Consultant","Personal Financial Planner","Others"};
    String[] marketing = {"Marketing Director","Marketing Manager","Marketing Consultant","BDE","Others"};
    String[] It = {"Application Developer","Java Developer","Network Engineer","Software Developer","Web Developer","Others"};
    String[] pest = {"Ant","Cockroach","House Fly","Mosquito","BedBugs","Others"};
    String[] electricals = {" electrical interior"};
    String[] plumbing = {" plumbing interior"};
    String[]residental= {"Villas","Individual House","1BHK","2BHK","3BHK","4BHK"};
    String[] positionscommerical = {"Office space ","Shopping mall","shops","semi furniture","Fully furniture","Others"};
    String[] carpentrys = {" carpentry interior"};
    String[] paintings = {"Repainting","Fresh Painting"};
    String[] positionsresidental = {"Appartment","IndividualHouse", "Villa", "PG", "PentHouse", "GuestHouse", "Others"};
    String[] year = {"Select year" ," 1","2","3","4","5","6","7","8","9","10","Above"};
    String[] flooring = {" flooring interior"};
    String[]  onetimeresidential = {"House Cleaning","flat/villa","Appartment","Floor Polishing / Granite / Marble","1BHK","2BHK","3BHK","4BHK","Others"};
    String[] onetimecomerical = {"Carpet Shampoo Cleaning","Sofa Shampoo Cleaning","Floor Polishing / Granite / Marble","Post contraction Cleaning","Glass Cleaning","Chair Cleaning","Office Cleaning"};
    String[] consultant = {"HR consultant","IT consultant","Marketing consultant","Financial consultant"};
    String[] technical = {"Swimmingpool Maintenance","STP Operator","Lift Operator","Electrian","Plumber","Carpenter"};
    String[] civilwork = {" civilwork interior"};
    String[] furniture = {" Tables","Workstation","Chairs","Dinning table","sofa"};
    String[] pop = {"Partition Gypsum Work", "False Ceiling Gypsum Work", "Grid Ceiling Gypsum Work"};

    String[] designresidental = {"Badroom", "Kitchen", "Bathroom", "Living Room", "Flooring", "Others"};
    String[] designcommerical = {"Receptions", "Living Area", "WorkStation", "Cafeteria", "Flooring Walls", "Others"};
    String[] ac = {"Dry Servicing","Wet Servicing","Gas Refill","Installation","Uninstallation","Other Repairs"};
    String[] mobile = {"Heating Issues", "Hardware Issues", "Software Issues", "No Network Issues", "Battery Issues", "Network Issues", "Others"};
    String[] chair = {"Seat Cushion ", "Castors", "Gas Cylinder problems for chair", "Handle broken for chairs", "Others"};
    String[] printer = {"Printer Tells Me to Stop Printing Because Ink Is Low", "Paper Jams or Multiple Sheets Are Drawn", "The Printer Is Too Slow", "A Print Image Is Being Superseded Over Another", "The Print Quality Has Gone Down the Drain", "It’s Costing Too Much"};
    String[] manson = {"Painting Contractors", "Tiling Contractors", "Rebuliding House", "wall broken problem", "Plasting house"};
    String[] laptop = {"Screen damaged/cracked/broken", "Motherboard failure", "Power adapter socket", "Hard drive failure", "Keyboard failure", "Water or fluid ingress", "Broken screen hinges and plastics", "Smashed base and top plastics", "Reboot loop", "DVD/CD drive failure", "Repetitive beep sound on startup", "Battery not charging properly", "Laptop makes noise while running", "Laptop turns on and off repeatedly", "Screen is blank"};
    String[] lan = {"The Internet Is Too Slow", "Streaming Video is Choking My Network", "Wireless Network Shows Signal but won't Connect", "Network Outages and Inaccessible Files", "Slow Application Response", "Poor VoIP Quality "};
    String[] carpentry = {"Fitting or Installation", "Replacement", "Any Furniture repair", "Add this Service"};
    String[] projector = {"Display toggle", "Fuzzy Image or Excessive Visual Noise", "The Image Does Not Appear on the Screen", " Infrared Remote Controls Not Functioning", "Purple Dots on the Screen"};
    String[] biometric = {"hacking problem", "got locked out", "Poor Assembly, Poor Technology", "Electronic keypad died", "Fingerprint feature doesn't work", "Takes too many fingerprint attempts to open"};
    String[] painting = {"Asian Paints", "Berger", "Nerolac"};
    String[] interior = {"Electrical", "Plumbing", "POP", "Painting", "Flooring Work", "Roll Carpet Flooring", "Civil Work", "Window Blins", "Modular Furniture", "Chairs", "Tables", "Workstation", "Sofa", "CC Camera", "Lan Networking", "Water Proofing", "Alluminium Fabrication", "Others"};
    String[] glassdoor = {"Fitting or Installation", "Replacement"};
    String[] cleaning = {" cleaning machines break down and require service", "The scrubber isn’t putting down water", "Loss of suction", "Burning smell/beater bar isn't moving", "Vacuum shuts off during use", "Pump fails to produce pressure", "Pressure washer has erratic pressure", "Loss of pressure or low water volume"};
    String[] camera = {"Blur image in the night", "Picture not displaying in camera", "Bright spots on the monitor", "Snowy bars on the screen", "Identification problems"};
    String[] plumber = { "Fitting or Installation", "Repair", "Uninstallation"};
    String[] electical = {"Fitting or Installation", "Removal", "Replacement", "Any Wiring Work"};
    String[] tvwashing = {"350", "300", "250", "250", "200", "250", "on inspection"};
    String[] price = {"350", "300", "250", "250", "on inspection"};
    String[] tvtheatre = {"350", "300", "250", "250", "on inspection"};
    String[] tvprice = {"350", "300", "250", "250", "200", "250", "200", "on inspection"};
    String[] tvdvd = {"350", "300", "250", "250", "200", "250", "on inspection"};
    String[] tvgeyser = {"350", "300", "250", "250", "200", "250", "on inspection"};
    String[] tvrefi = {"350", "300", "250", "250", "200", "250", "on inspection"};
    String[] prices = {"450"};
    String[] budget={"Select Budget","50K-1LK","1LKh-3LKh","3Lkh-6.0Lkh", "7.0Lkh- 9.0Lkh", "10.0Lkh- 20.0Lkh", "20.0Lkh- 50.0Lkh", "50.0Lkh- 1Cr", "1Cr-2Cr","None"};

    String[] spinnertour = {"Select Vehicle","Min(3+1)","Suv(6+1)","Sedan(4+1)","Travellers(12+1)"};
    String[] bhks = {"Choose","Yes","No"};
    String[] arch = {"Select Building Type","Appartment", "IndividualHouse", "Villa", "Shoppingmall", "PentHouse", "GuestHouse", "Others"};
    String[] test;
    Spinner spinnertype, spinnersqft, spinnerfloors, sprs1, sprs2, sprs4,sprs3,spvehicle,sppositonsell,spbhksell,sprs1sell,sprsone,sprstwo,sprsthree,sprsfour;
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    AlertDialog.Builder builders;
    AlertDialog alertDialogs;
    String[] spinnermove = {"Select floor","Ground Floor"," 1st floor","2nd floor","3rd floor","4th floor","5th floor","6th floor","7th floor","Above"};
    String[] type = {"Flats", "Apartments", "Single House"};
    String[] area = {"Select Area","Sq.Ft.", "Sq.Mt", "R.Mt", "R.Ft", "C.M", "C.Ft", "Numbers"};
    String[] floors = {"Select floor","Ground Floor"," 1st floor","2nd floor","3rd floor","4th floor","5th floor","6th floor","7th floor","Above"};
    String[] spinnerrs1 = {"Select Budget","10K-30K", "40K-70K", "80K-1Lkh", "1.5Lkh -2.0Lhk", "2.5Lkh-3.0Lkh", "4.0Lkh-6.0Lkh", "7.0Lkh- 9.0Lkh", "10.0Lkh- 20.0Lkh", "30.0Lkh- 50.0Lkh", "70.0Lkh- 1Cr", "1.25Cr-2Cr","None"};
    String[] spinnerrs2 = {"Choose","Yes","No"};
    String[] floor = {"Select floor","Ground Floor"," 1st floor","2nd floor","3rd floor","4th floor","5th floor","6th floor","7th floor","Above"};
    String[]guest={"Choose","30-50","50-100","100-300","300-600","600-1000","1000-3000","3000-5000","5000-10000","Above"};
    int i,j,k,l,m,n,p,q,r;
    int Index;

    String Answer;
    int[] image = {
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,


    };
    int[] tvimage = {
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,


    };
    int[] DVDimage = {
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,
            R.drawable.indianrupee,


    };
    int[] images = {
            R.drawable.indianrupee,


    };
    int[] mids = {

            R.drawable.imagesbike,
            R.drawable.imagescar,
            R.drawable.imagesbike,
            R.drawable.imagescar


    };
    String cat[] = {"Minearl or Synthetic\noil? What's better\nfor your car?", "4 car lover\nmust know",
            "Why does your car\nneed to be waxed?", "How do you care for\nyour motorcycle\nspark plug?"};
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicing);
//        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
//        getSupportActionBar().setCustomView(mActionBarView);
//        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setElevation(0);
        etselectmakes = (EditText) findViewById(R.id.etselectmakes);
        tvservicing = (TextView) findViewById(R.id.tvservicing);
        tvselectmake = (TextView) findViewById(R.id.tvselectmake);
       tvselectmakes = (TextView) findViewById(R.id.tvselectmakes);
        tvarticles = (TextView) findViewById(R.id.tvarticles);
       multiAutoCompleteTextViews = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextViews);

        tvguarantee = (TextView) findViewById(R.id.tvguarantee);
        tvverify = (TextView) findViewById(R.id.tvverify);
        tvprofessional = (TextView) findViewById(R.id.tvprofessional);
        tvinsured = (TextView) findViewById(R.id.tvinsured);
       btnadd = (Button) findViewById(R.id.btnadd);
        tvwork = (TextView) findViewById(R.id.tvwork);
        tvrequested = (TextView) findViewById(R.id.tvrequested);
        tventer = (TextView) findViewById(R.id.tventer);
        tvcompany = (TextView) findViewById(R.id.tvcompany);
        multiAutoCompleteTextView1=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView1);
        tvguaranteed = (TextView) findViewById(R.id.tvguaranteed);
        tvsatisfaction = (TextView) findViewById(R.id.tvsatisfaction);
        mclass = (Mainclass) getApplicationContext();
        pos = mclass.getPosition();
        catvalue=mclass.getService();
        layoutInflator = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        insertPoint = (LinearLayout) findViewById(R.id.rlselectmake);
        insertPointing = (LinearLayout) findViewById(R.id.contact);
        insertPoints = (LinearLayout) findViewById(R.id.contacts_type);
        List views = new ArrayList();
        //linearLayout = (LinearLayout) findViewById(R.id.rlselectmake);
        relativeLayout2 = (RelativeLayout) findViewById(R.id.rltop);
        gr = new grfont(ServicingActivity.this);
        Intent intent = getIntent();
        fservice = intent.getStringExtra("service");
//        fwithout = intent.getStringExtra("without");
//        fsell = intent.getStringExtra("sell");
//        fwithin = intent.getStringExtra("within");
        fhouse = intent.getStringExtra("servicing");
        fservices = intent.getStringExtra("services");
        fName = intent.getStringExtra("message");
        fcat = intent.getStringExtra("sercat");
        sertyp = intent.getIntExtra("sertyp", 0);

        //  gr.grfonttxt(tvselectmake);
//        gr.grfonttxt(tvservicing);
        gr.grfonttxt(tvarticles);
       gr.grfonttxt(tvselectmakes);
        gr.grfonttxt(tvguarantee);
        gr.grfonttxt(tvverify);
        gr.grfonttxt(tvinsured);
        gr.grfonttxt(tvwork);
        gr.grfonttxt(tvcompany);
        gr.grfontbut(btnadd);
        gr.grfonmul(multiAutoCompleteTextViews);
        gr.grfonted(etselectmakes);
        gr.grfonttxt(tvguaranteed);
      //  gr.grfonttxt(tventer);
        gr.grfonttxt(tvsatisfaction);
        gr.grfonttxt(tvprofessional);
        test = new String[]{""};
        tvselectmake.setText(fhouse);
        tvselectmakes.setText(fservice);
//        tvselectmake.setText(fhouse);
//        tvselectmake.setText(fwithin);
//        tvselectmake.setText(fsell);
//        tvselectmake.setText(fwithout);


       etselectmakes.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tventer.setText(etselectmakes.getText().toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if (pos == 1) {
            if (sertyp == 0) {
                if (catvalue.equalsIgnoreCase("New Construction")) {
                    view = getLayoutInflater().inflate(R.layout.renovationitems, null);
                   tventer.setVisibility(view.GONE);
                    // tvselectmake.setText("Requirements");
                    gr.grfonttxt(tvselectmake);
                    etminimum = (EditText) view.findViewById(R.id.etminimum);
                    tvselectarea = (TextView) view.findViewById(R.id.tvselectarea);
                    tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                    tvfloors = (TextView) view.findViewById(R.id.tvfloors);
                    relativespinnerfloors=(RelativeLayout) view.findViewById(R.id.relativespinnerfloors);
                    rlrs1=(RelativeLayout) view.findViewById(R.id.rlrs1);
                    tvselectmake.setText("Construction");
                    gr.grfonttxt(tvselectarea);
                    gr.grfonttxt(tvbudget);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    tvrequested.setText("Requested for New Construction");
                    gr.grfonttxt(tvfloors);
                    gr.grfonted(etminimum);
                    etselectmakes.setVisibility(View.GONE);
                    spinnersqft = (Spinner) view.findViewById(R.id.spinnersqft);
                    spinnerfloors = (Spinner) view.findViewById(R.id.spinnerfloors);
                    sprs1 = (Spinner) view.findViewById(R.id.sprs1);
                    ArrayAdapter<String> adapter0 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    sprs1.setAdapter(adapter0);
                    sprs1.setOnItemSelectedListener(onItemSelectedListener0);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);

//           ;
         ArrayAdapter<String> adapter1 =
                    new ArrayAdapter<String>(ServicingActivity.this,
                            R.layout.simple_spinner_item,R.id.textview,area)
                    {

                        public View getView(int position, View convertView, ViewGroup parent) {
                            View v = super.getView(position, convertView, parent);

                            Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                            ((TextView) v).setTypeface(externalFont);

                            return v;
                        }



                    };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnersqft.setAdapter(adapter1);
                    spinnersqft.setOnItemSelectedListener(onItemSelectedListener0);
                    ArrayAdapter<String> adapter2=
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,floors)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                  spinnerfloors.setAdapter(adapter2);
                  spinnerfloors.setOnItemSelectedListener(onItemSelectedListener0);



                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    tvcommercial.setText("New Construction");
                    gr.grfonttxt(tvcommercial);

                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                    insertPoint.addView(view);
                } if (catvalue.equalsIgnoreCase("Renovation")) {
                    view = getLayoutInflater().inflate(R.layout.renovationitems, null);
                    tventer.setVisibility(view.GONE);
                   // insertPointing.setVisibility(view.GONE);
                    // tvselectmake.setText("Requirements");
                    gr.grfonttxt(tvselectmake);
                    etminimum = (EditText) view.findViewById(R.id.etminimum);
                    tvselectarea = (TextView) view.findViewById(R.id.tvselectarea);
                    tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                    tvfloors = (TextView) view.findViewById(R.id.tvfloors);
                    rlrs1=(RelativeLayout) view.findViewById(R.id.rlrs1);
                    relativespinnerfloors=(RelativeLayout) view.findViewById(R.id.relativespinnerfloors);
                    tvselectmake.setText("Construction");
                    gr.grfonttxt(tvselectarea);
                    gr.grfonttxt(tvbudget);
                    tvrequested.setText("Requested for the Renovation ");
                    gr.grfonttxt(tvfloors);
                    gr.grfonted(etminimum);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    etselectmakes.setVisibility(View.GONE);
                    spinnersqft = (Spinner) view.findViewById(R.id.spinnersqft);
                    spinnerfloors = (Spinner) view.findViewById(R.id.spinnerfloors);
                    sprs1 = (Spinner) view.findViewById(R.id.sprs1);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                    ArrayAdapter<String> adapter0 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    sprs1.setAdapter(adapter0);
                    sprs1.setOnItemSelectedListener(onItemSelectedListener0);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);

//           ;
                    ArrayAdapter<String> adapter1 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,area)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnersqft.setAdapter(adapter1);
                    spinnersqft.setOnItemSelectedListener(onItemSelectedListener0);
                    ArrayAdapter<String> adapter2=
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,floors)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerfloors.setAdapter(adapter2);
                    spinnerfloors.setOnItemSelectedListener(onItemSelectedListener0);


                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    tvcommercial.setText("Renovation");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                    insertPoint.addView(view);
                }
            } if (sertyp == 1) {
                if (catvalue.equalsIgnoreCase("New Construction")) {
                    view = getLayoutInflater().inflate(R.layout.renovationitems, null);
                    tventer.setVisibility(view.GONE);
                   // relativespinnerfloors=(RelativeLayout) view.findViewById(R.id.relativespinnerfloors);
                    rlrs1=(RelativeLayout) view.findViewById(R.id.rlrs1);
                    // insertPointing.setVisibility(view.GONE);
                    // tvselectmake.setText("Requirements");
                    gr.grfonttxt(tvselectmake);
                    etminimum = (EditText) view.findViewById(R.id.etminimum);
                    tvselectarea = (TextView) view.findViewById(R.id.tvselectarea);
                    tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                    tvfloors = (TextView) view.findViewById(R.id.tvfloors);
                    tvfloors.setVisibility(View.GONE);
                    tvselectmake.setText("Architecture");
                    gr.grfonttxt(tvselectarea);
                    gr.grfonttxt(tvbudget);
                    tvrequested.setText("Requested for New Construction");
                    gr.grfonttxt(tvfloors);
                    gr.grfonted(etminimum);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    etselectmakes.setVisibility(View.GONE);
                    spinnersqft = (Spinner) view.findViewById(R.id.spinnersqft);
                    spinnerfloors = (Spinner) view.findViewById(R.id.spinnerfloors);
                    spinnerfloors.setVisibility(View.GONE);
                    sprs1 = (Spinner) view.findViewById(R.id.sprs1);
           ArrayAdapter<String> adapter0 =
                    new ArrayAdapter<String>(ServicingActivity.this,
                            R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                    {

                        public View getView(int position, View convertView, ViewGroup parent) {
                            View v = super.getView(position, convertView, parent);

                            Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                            ((TextView) v).setTypeface(externalFont);

                            return v;
                        }



                    };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    sprs1.setAdapter(adapter0);
                    sprs1.setOnItemSelectedListener(onItemSelectedListener0);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);

//           ;
                    ArrayAdapter<String> adapter1 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,area)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnersqft.setAdapter(adapter1);
                    spinnersqft.setOnItemSelectedListener(onItemSelectedListener0);
                    ArrayAdapter<String> adapter2=
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,floors)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerfloors.setAdapter(adapter2);
                    spinnerfloors.setOnItemSelectedListener(onItemSelectedListener0);


                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    tvcommercial.setText("New Construction");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                    insertPoint.addView(view);
                }if (catvalue.equalsIgnoreCase("Renovation")) {
                    view = getLayoutInflater().inflate(R.layout.renovationitems, null);
                    tventer.setVisibility(view.GONE);
                    // insertPointing.setVisibility(view.GONE);
                    // tvselectmake.setText("Requirements");
                    gr.grfonttxt(tvselectmake);
                    etminimum = (EditText) view.findViewById(R.id.etminimum);
                    tvselectarea = (TextView) view.findViewById(R.id.tvselectarea);
                    tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                    tvfloors = (TextView) view.findViewById(R.id.tvfloors);
                    rlrs1=(RelativeLayout) view.findViewById(R.id.rlrs1);
                    tvfloors.setVisibility(View.GONE);
                    tvselectmake.setText("Architecture");
                    gr.grfonttxt(tvselectarea);
                    gr.grfonttxt(tvbudget);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    tvrequested.setText("Requested for the Renovation ");
                    gr.grfonttxt(tvfloors);
                    gr.grfonted(etminimum);
                    etselectmakes.setVisibility(View.GONE);
                    spinnersqft = (Spinner) view.findViewById(R.id.spinnersqft);
                    spinnerfloors = (Spinner) view.findViewById(R.id.spinnerfloors);
                    spinnerfloors.setVisibility(View.GONE);
                    sprs1 = (Spinner) view.findViewById(R.id.sprs1);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                    ArrayAdapter<String> adapter0 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    sprs1.setAdapter(adapter0);
                    sprs1.setOnItemSelectedListener(onItemSelectedListener0);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);

//           ;
                    ArrayAdapter<String> adapter1 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,area)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnersqft.setAdapter(adapter1);
                    spinnersqft.setOnItemSelectedListener(onItemSelectedListener0);
                    ArrayAdapter<String> adapter2=
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,floors)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerfloors.setAdapter(adapter2);
                    spinnerfloors.setOnItemSelectedListener(onItemSelectedListener0);


                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    tvcommercial.setText("Renovation");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                    insertPoint.addView(view);

                }
            } if (sertyp == 2) {
                if (catvalue.equalsIgnoreCase("New Design")) {
                    view = getLayoutInflater().inflate(R.layout.renovationitems, null);
                    tventer.setVisibility(view.GONE);
                    // insertPointing.setVisibility(view.GONE);
                    // tvselectmake.setText("Requirements");
                    gr.grfonttxt(tvselectmake);
                    etminimum = (EditText) view.findViewById(R.id.etminimum);
                    tvselectarea = (TextView) view.findViewById(R.id.tvselectarea);
                    tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                    tvfloors = (TextView) view.findViewById(R.id.tvfloors);
                    rlrs1=(RelativeLayout) view.findViewById(R.id.rlrs1);
                    tvfloors.setVisibility(View.GONE);
                    tvselectmake.setText("InteriorDesign");
                    gr.grfonttxt(tvselectarea);
                    gr.grfonttxt(tvbudget);
                    tvrequested.setText("Requested for new Interior design ");
                    gr.grfonttxt(tvfloors);
                    gr.grfonted(etminimum);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    etselectmakes.setVisibility(View.GONE);
                    spinnersqft = (Spinner) view.findViewById(R.id.spinnersqft);
                    spinnerfloors = (Spinner) view.findViewById(R.id.spinnerfloors);
                    spinnerfloors.setVisibility(View.GONE);
                    sprs1 = (Spinner) view.findViewById(R.id.sprs1);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                    ArrayAdapter<String> adapter0 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    sprs1.setAdapter(adapter0);
                    sprs1.setOnItemSelectedListener(onItemSelectedListener0);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);

//           ;
                    ArrayAdapter<String> adapter1 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,area)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnersqft.setAdapter(adapter1);
                    spinnersqft.setOnItemSelectedListener(onItemSelectedListener0);
                    ArrayAdapter<String> adapter2=
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,floors)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerfloors.setAdapter(adapter2);
                    spinnerfloors.setOnItemSelectedListener(onItemSelectedListener0);


                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    tvcommercial.setText("New Design");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                    insertPoint.addView(view);
                }
                if (catvalue.equalsIgnoreCase("Renovation")) {
                    view = getLayoutInflater().inflate(R.layout.renovationitems, null);
                    tventer.setVisibility(view.GONE);
                    // insertPointing.setVisibility(view.GONE);
                    // tvselectmake.setText("Requirements");
                    gr.grfonttxt(tvselectmake);
                    etminimum = (EditText) view.findViewById(R.id.etminimum);
                    rlrs1=(RelativeLayout) view.findViewById(R.id.rlrs1);
                    tvselectarea = (TextView) view.findViewById(R.id.tvselectarea);
                    tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                    tvfloors = (TextView) view.findViewById(R.id.tvfloors);
                    tvfloors.setVisibility(View.GONE);
                    tvselectmake.setText("InteriorDesign");
                    gr.grfonttxt(tvselectarea);
                    gr.grfonttxt(tvbudget);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    tvrequested.setText("Requested for the Renovation ");
                    gr.grfonttxt(tvfloors);
                    gr.grfonted(etminimum);
                    etselectmakes.setVisibility(View.GONE);
                    spinnersqft = (Spinner) view.findViewById(R.id.spinnersqft);
                    spinnerfloors = (Spinner) view.findViewById(R.id.spinnerfloors);
                    spinnerfloors.setVisibility(View.GONE);
                    sprs1 = (Spinner) view.findViewById(R.id.sprs1);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                    ArrayAdapter<String> adapter0 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    sprs1.setAdapter(adapter0);
                    sprs1.setOnItemSelectedListener(onItemSelectedListener0);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);

//           ;
                    ArrayAdapter<String> adapter1 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,area)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnersqft.setAdapter(adapter1);
                    spinnersqft.setOnItemSelectedListener(onItemSelectedListener0);
                    ArrayAdapter<String> adapter2=
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,floors)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spinnerfloors.setAdapter(adapter2);
                    spinnerfloors.setOnItemSelectedListener(onItemSelectedListener0);


                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    tvcommercial.setText("Renovation");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                    insertPoint.addView(view);
                }
            }
        }

        LinearLayout root = (LinearLayout) findViewById(R.id.linearlayouthorscroll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        for (j = 0; j <= 3; j++) {
            pojo = new Getrepairpojo(new LinearLayout(ServicingActivity.this), j);
            pojo.getLinearLayout().setOrientation(LinearLayout.VERTICAL);
            //    pojo.getLinearLayout().setBackgroundColor(color[j]);
            pojo.getLinearLayout().setPadding(10, 10, 10, 10);

//ll.setDividerPadding(1);
            params.setMargins(4, 0, 4, 0);
            pojo.getLinearLayout().setLayoutParams(params);
            pojo.getLinearLayout().setClickable(true);
            final ImageView ivproduct = new ImageView(ServicingActivity.this);
            ivproduct.setImageResource(mids[j]);
            // ivproduct.setBackgroundColor(color[j]);
            //  ivproduct.setId(j+1);

            ivproduct.setPadding(10, 10, 10, 10);
            pojo.getLinearLayout().addView(ivproduct);

            TextView product = new TextView(ServicingActivity.this);

            product.setText(cat[j]);
            gr = new grfont(ServicingActivity.this);
            gr.grfonttxt(product);
            product.setGravity(Gravity.CENTER);
            product.setPadding(10, 10, 10, 10);
            //product.setTextColor(Color.parseColor("#ffffff"));
            //product.setBackgroundColor(color[j]);
            pojo.getLinearLayout().addView(product);

            positon = pojo.getPosition();
            final int finalPositon = positon;
            pojo.getLinearLayout().setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {
                    //  Toast.makeText(SagarAssociatesActivity.this,"clickable",Toast.LENGTH_LONG).show();
                    changeView(finalPositon);
                }

            });

            root.addView(pojo.getLinearLayout());

        }
        btncontinue = (Button) findViewById(R.id.btncontinue);
        gr.grfontbut(btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
//                 else {
                    if (pos == 0) {
                        if (etselectmakes.getText().toString().equals("")) {
                            Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            etselectmakes.setError(null);

                            etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                            Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                            etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                        }
                        else{
                        mclass.setIssue(etselectmakes.getText().toString());
                            builder = new AlertDialog.Builder(ServicingActivity.this);
                            View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                            btnyes = (Button) vw.findViewById(R.id.btnyes);
                            btnno = (Button) vw.findViewById(R.id.btnno);
                            tvselect = (TextView) vw.findViewById(R.id.tvselect);
                           grfont gr = new grfont(ServicingActivity.this);
                            gr.grfonttxt(tvselect);
                            gr.grfontbut(btnyes);
                            gr.grfontbut(btnno);
                            btnno.setOnClickListener(new View.OnClickListener() {


                                @Override
                                public void onClick(View v) {


                                    alertDialog.dismiss();

                                }

                            });
                            btnyes.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            builder.setView(vw);
                            alertDialog = builder.create();
                            alertDialog.show();

                        }
                    } else if (pos == 1) {

                      size=etminimum.getText().toString();
                        areas=spinnersqft.getSelectedItem().toString();
                        floorses=spinnerfloors.getSelectedItem().toString();
                      Budget=sprs1.getSelectedItem().toString();
//                        if (size.equals("")) {
//                            Snackbar.make(view, "Select field size", Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                        }else if(areas.equals(""))
//                        {
//                            Snackbar.make(view, "Select field Sqfts", Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                        }else if(floorses.equals(""))
//                        {
//                            Snackbar.make(view, "Select field Sqfts", Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                        }
//                        else if(budget.equals(""))
//                        {
//                            Snackbar.make(view, "Select field Sqfts", Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                        }



                                if (sertyp == 0) {
                                    if (size.equals("")) {
                                        Snackbar.make(view, "Select field size", Snackbar.LENGTH_LONG)
                                                .setAction("Action", null).show();
                                        //etminimum.setError(null);
                                        etminimum.setBackgroundResource(R.drawable.mybordererror);
                                        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                    etminimum.startAnimation(startAnimation);
                                    }else if(areas.equals("Select Area"))
                                    {
                                        Snackbar.make(view, "Select field Sqfts", Snackbar.LENGTH_LONG)
                                                .setAction("Action", null).show();

                                      spinnersqft.setBackgroundResource(R.drawable.myborderbuildingerror);
                                        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                       spinnersqft.startAnimation(startAnimation);
                                    }else if(floorses.equals("Select floor"))
                                    {
                                        Snackbar.make(view, "Select field floor", Snackbar.LENGTH_LONG)
                                                .setAction("Action", null).show();
                                        relativespinnerfloors.setBackgroundResource(R.drawable.myborderbuildingerror);
                                        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                        relativespinnerfloors.startAnimation(startAnimation);
                                    }
                                    else if(Budget.equals("Select Budget"))
                                    {
                                        Snackbar.make(view, "Select field Budget", Snackbar.LENGTH_LONG)
                                                .setAction("Action", null).show();
                                        rlrs1.setBackgroundResource(R.drawable.myborderbuildingerror);
                                        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                        rlrs1.startAnimation(startAnimation);
                                    } else {
                                        mclass.setSize(etminimum.getText().toString());
                                        mclass.setSqft(spinnersqft.getSelectedItem().toString());
                                        mclass.setFloor(spinnerfloors.getSelectedItem().toString());
                                        mclass.setSertyp(0);
                                        mclass.setBudget(sprs1.getSelectedItem().toString());
                                        builder = new AlertDialog.Builder(ServicingActivity.this);
                                        View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                        btnyes = (Button) vw.findViewById(R.id.btnyes);
                                        btnno = (Button) vw.findViewById(R.id.btnno);
                                        tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                        grfont gr = new grfont(ServicingActivity.this);
                                        gr.grfonttxt(tvselect);
                                        gr.grfontbut(btnyes);
                                        gr.grfontbut(btnno);
                                        btnno.setOnClickListener(new View.OnClickListener() {


                                            @Override
                                            public void onClick(View v) {


                                                alertDialog.dismiss();

                                            }

                                        });
                                        btnyes.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        });
                                        builder.setView(vw);
                                        alertDialog = builder.create();
                                        alertDialog.show();

                                    }
                            }
                            if (sertyp == 1) {
                                if (size.equals("")) {
                                    Snackbar.make(view, "Select field size", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    //etminimum.setError(null);
                                    etminimum.setBackgroundResource(R.drawable.mybordererror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                    etminimum.startAnimation(startAnimation);
                                }else if(areas.equals("Select Area"))
                                {
                                    Snackbar.make(view, "Select field Sqfts", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();

                                    spinnersqft.setBackgroundResource(R.drawable.myborderbuildingerror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                    spinnersqft.startAnimation(startAnimation);
                                }
                                else if(Budget.equals("Select Budget"))
                                {
                                    Snackbar.make(view, "Select field Budget", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    rlrs1.setBackgroundResource(R.drawable.myborderbuildingerror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                    rlrs1.startAnimation(startAnimation);
                                } else {
                                    mclass.setSize(etminimum.getText().toString());
                                    mclass.setSqft(spinnersqft.getSelectedItem().toString());
                                    mclass.setSertyp(1);
                                    mclass.setFloor("");

                                    mclass.setBudget(sprs1.getSelectedItem().toString());
                                    builder = new AlertDialog.Builder(ServicingActivity.this);
                                    View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                    btnyes = (Button) vw.findViewById(R.id.btnyes);
                                    btnno = (Button) vw.findViewById(R.id.btnno);
                                    tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                    grfont gr = new grfont(ServicingActivity.this);
                                    gr.grfonttxt(tvselect);
                                    gr.grfontbut(btnyes);
                                    gr.grfontbut(btnno);
                                    btnno.setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {


                                            alertDialog.dismiss();

                                        }

                                    });
                                    btnyes.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                                    builder.setView(vw);
                                    alertDialog = builder.create();
                                    alertDialog.show();
                                }
                            }
                            if (sertyp == 2) {
                                if (size.equals("")) {
                                    Snackbar.make(view, "Select field size", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    //etminimum.setError(null);
                                    etminimum.setBackgroundResource(R.drawable.mybordererror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                    etminimum.startAnimation(startAnimation);
                                }else if(areas.equals("Select Area"))
                                {
                                    Snackbar.make(view, "Select field Sqfts", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();

                                    spinnersqft.setBackgroundResource(R.drawable.myborderbuildingerror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                    spinnersqft.startAnimation(startAnimation);
                                }
                                else if(Budget.equals("Select Budget"))
                                {
                                    Snackbar.make(view, "Select field Budget", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    rlrs1.setBackgroundResource(R.drawable.myborderbuildingerror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                    rlrs1.startAnimation(startAnimation);
                                } else {
                                    mclass.setSize(etminimum.getText().toString());
                                    mclass.setSqft(spinnersqft.getSelectedItem().toString());
                                    mclass.setSertyp(1);
                                    mclass.setFloor("");

                                    mclass.setBudget(sprs1.getSelectedItem().toString());
                                    builder = new AlertDialog.Builder(ServicingActivity.this);
                                    View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                    btnyes = (Button) vw.findViewById(R.id.btnyes);
                                    btnno = (Button) vw.findViewById(R.id.btnno);
                                    tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                    grfont gr = new grfont(ServicingActivity.this);
                                    gr.grfonttxt(tvselect);
                                    gr.grfontbut(btnyes);
                                    gr.grfontbut(btnno);
                                    btnno.setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {


                                            alertDialog.dismiss();

                                        }

                                    });
                                    btnyes.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                                    builder.setView(vw);
                                    alertDialog = builder.create();
                                    alertDialog.show();
                                }
                            }

                    } else if (pos == 2) {
                        if (etselectmakes.getText().toString().equals("")) {
                            Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            etselectmakes.setError(null);

                            etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                            Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                            etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                        }
                        else{
                            mclass.setIssue(etselectmakes.getText().toString());
                            builder = new AlertDialog.Builder(ServicingActivity.this);
                            View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                            btnyes = (Button) vw.findViewById(R.id.btnyes);
                            btnno = (Button) vw.findViewById(R.id.btnno);
                            tvselect = (TextView) vw.findViewById(R.id.tvselect);
                            grfont gr = new grfont(ServicingActivity.this);
                            gr.grfonttxt(tvselect);
                            gr.grfontbut(btnyes);
                            gr.grfontbut(btnno);
                            btnno.setOnClickListener(new View.OnClickListener() {


                                @Override
                                public void onClick(View v) {


                                    alertDialog.dismiss();

                                }

                            });
                            btnyes.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            builder.setView(vw);
                            alertDialog = builder.create();
                            alertDialog.show();

                        }
                    } else if (pos == 3) {


                        if (sertyp == 0) {
                            if(radiog.getCheckedRadioButtonId()==-1) {
                                Snackbar.make(view, "Please select Gender", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }else if(radiogp.getCheckedRadioButtonId()==-1) {
                                Snackbar.make(view, "Please select Service type", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                          }else if (tvintime.getText().toString().equals("Intime")) {
                                Snackbar.make(view, "Please select Intime type", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                tvintime.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                tvintime.startAnimation(startAnimation);
                            }else if (tvcount1.getText().toString().equals("00")&&tvcount2.getText().toString().equals("00")&&tvcount3.getText().toString().equals("00")) {
                                Snackbar.make(view, " Selected Hrs Qty should not be 00", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
//                                tvintime.setBackgroundResource(R.drawable.mybordererror);
//                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
//                                tvintime.startAnimation(startAnimation);
                            }

                            else {
                                int id = radiog.getCheckedRadioButtonId();
                                int ids = radiogp.getCheckedRadioButtonId();
                                //View radioButton = radiogp.findViewById(id);
                                RadioButton selectedRadioButton = (RadioButton) findViewById(id);
                                RadioButton selectedRadioButtons = (RadioButton) findViewById(ids);
                                //RadioButton btn = (RadioButton) radiogp.getChildAt(radioId);
                                selection = selectedRadioButton.getText().toString();
                                selections = selectedRadioButtons.getText().toString();


                                // String selection = (String) selectedRadioButton.getText();
                                mclass.setGender(selection);
                                mclass.setChoose(selections);
                                if (timeslot == null) {
                                    Snackbar.make(view, "Please Select Hrs", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                } else if (timeslot.equalsIgnoreCase("4 Hrs")) {
                                    mclass.setQty(tvcount1.getText().toString());
                                } else if (timeslot.equalsIgnoreCase("8 Hrs")) {
                                    mclass.setQty(tvcount2.getText().toString());
                                } else if (timeslot.equalsIgnoreCase("12 Hrs")) {
                                    mclass.setQty(tvcount3.getText().toString());
                                }

                                    mclass.setIntime(tvintime.getText().toString());

                                    //mclass.setQty(tvcount2.getText().toString());
                                    //mclass.setQty(tvcount3.getText().toString());
                                    mclass.setOuttime(tvouttime.getText().toString());
                                    // mclass.setChoose(radiogp.getText().toString());
                                    mclass.setWeekoff(tvcount4.getText().toString());
//                            if (selection.equals("")) {
//                                Snackbar.make(view, "Select field size", Snackbar.LENGTH_LONG)
//                                        .setAction("Action", null).show();
//                                //etminimum.setError(null);
//                           // selection.setBackgroundResource(R.drawable.mybordererror);
//                              //  Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
//                              // radiog.startAnimation(startAnimation);
//
// } }
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
                            }

                        } else if (sertyp == 3) {
                            if (etselectmakes.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                etselectmakes.setError(null);

                                etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }
                            else {
                                mclass.setIssue(etselectmakes.getText().toString());
                                mclass.setSertyp(3);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
                            }
                            }else if (sertyp == 4) {
                                if (etselectmakes.getText().toString().equals("")) {
                                    Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    etselectmakes.setError(null);

                                    etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                    etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                                }
                                else {
                                    mclass.setIssue(etselectmakes.getText().toString());
                                    mclass.setSertyp(4);
                                    builder = new AlertDialog.Builder(ServicingActivity.this);
                                    View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                    btnyes = (Button) vw.findViewById(R.id.btnyes);
                                    btnno = (Button) vw.findViewById(R.id.btnno);
                                    tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                    grfont gr = new grfont(ServicingActivity.this);
                                    gr.grfonttxt(tvselect);
                                    gr.grfontbut(btnyes);
                                    gr.grfontbut(btnno);
                                    btnno.setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {


                                            alertDialog.dismiss();

                                        }

                                    });
                                    btnyes.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                                    builder.setView(vw);
                                    alertDialog = builder.create();
                                    alertDialog.show();

                                }

                        } else if (sertyp == 5) {
                            if (etselectmakes.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                etselectmakes.setError(null);

                                etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }
                            else{
                                mclass.setIssue(etselectmakes.getText().toString());
                                mclass.setSertyp(5);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();

                            }


                        } else if (sertyp == 6) {
                            size=sprstwo.getSelectedItem().toString();
                            areas=sprsthree.getSelectedItem().toString();
                            floorses=sprsone.getSelectedItem().toString();
                            Budget=sprsfour.getSelectedItem().toString();
                            if (multiAutoCompleteTextView3.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter Company Name (or)Person Name", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView3.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView3.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else if(floorses.equals("Select floor"))
                            {
                                Snackbar.make(view, "Select field floor", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                sprsone.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                sprsone.startAnimation(startAnimation);
                            }else if(size.equals("Choose"))  {
                                Snackbar.make(view, "Select Service Lift Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                              sprstwo.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                               sprstwo.startAnimation(startAnimation);
                            }else if(areas.equals("Select floor"))  {
                                Snackbar.make(view, "Select field floor", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                sprsthree.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                sprsthree.startAnimation(startAnimation);
                            }else if(Budget.equals("Choose"))  {
                                Snackbar.make(view, "Select Service Lift Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                sprsfour.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                sprsfour.startAnimation(startAnimation);
                            } else if (multiAutoCompleteTextView.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter From Location", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else if (multiAutoCompleteTextView1.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter To Location", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView1.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView1.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else {
                                mclass.setCompany(multiAutoCompleteTextView3.getText().toString());
                                mclass.setCurrently(sprsone.getSelectedItem().toString());
                                mclass.setServicelift(sprstwo.getSelectedItem().toString());
                                mclass.setMove(sprsthree.getSelectedItem().toString());
                                mclass.setYes(sprsfour.getSelectedItem().toString());
                                mclass.setFrom(multiAutoCompleteTextView.getText().toString());
                                mclass.setTo(multiAutoCompleteTextView1.getText().toString());
                                mclass.setFurnitureqty(tvcounts.getText().toString());
                                mclass.setElectricalqty(tvcount.getText().toString());
                                mclass.setVehicleqty(tvcounting.getText().toString());
                                mclass.setSertyp(6);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
                            }
                        } else if (sertyp == 7) {
                            size=spvehicle.getSelectedItem().toString();
                            if (multiAutoCompleteTextView3.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter Company Name (or)Person Name", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView3.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView3.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else if (multiAutoCompleteTextView.getText().toString().equals("")) {
                                Snackbar.make(view, "Select From Location", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else if (multiAutoCompleteTextView1.getText().toString().equals("")) {
                                Snackbar.make(view, "Select To Location", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView1.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView1.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }
                            else if(size.equals("Select Vehicle" )) {
                                Snackbar.make(view, "Select Vehicle Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                rlvehicle.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlvehicle.startAnimation(startAnimation);
                            }else if (tvfromdate.getText().toString().equals("From Date")) {
                                Snackbar.make(view, "Select From Date", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                tvfromdate.setBackgroundResource(R.drawable.myborderbuildinggrayerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                tvfromdate.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else if (tvtodate.getText().toString().equals("To Date")) {
                                Snackbar.make(view, "Select To Date", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                tvtodate.setBackgroundResource(R.drawable.myborderbuildinggrayerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                tvtodate.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else {


                                mclass.setCompany(multiAutoCompleteTextView3.getText().toString());
                                mclass.setAdult(tvcount.getText().toString());
                                mclass.setFrom(multiAutoCompleteTextView.getText().toString());
                                mclass.setTo(multiAutoCompleteTextView1.getText().toString());
                                mclass.setChild(tvcount1.getText().toString());
                                mclass.setVechicle(spvehicle.getSelectedItem().toString());
                                mclass.setTripfrom(tvfromdate.getText().toString());
                                mclass.setTripto(tvtodate.getText().toString());
                                mclass.setSertyp(7);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
                            }
                        } else if (sertyp == 8) {
                            if (etselectmakes.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                etselectmakes.setError(null);

                                etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }
                            else{
                                mclass.setIssue(etselectmakes.getText().toString());
                                mclass.setSertyp(8);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();

                            }
                        } else if (sertyp == 9) {
                            size=sppositonsell.getSelectedItem().toString();
                            areas=sprs1.getSelectedItem().toString();
                            floorses=sprs2.getSelectedItem().toString();
                            Budget=sprs3.getSelectedItem().toString();
                            if (multiAutoCompleteTextView1.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter Company Name (or)Person Name", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView1.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView1.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }
                           else if(size.equals("Select Building Type")) {
                                Snackbar.make(view, "Select Building Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlsppositonsells.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlsppositonsells.startAnimation(startAnimation);
                            } else if(edaddress.getText().toString().equals("")){
                                Snackbar.make(view, "Select Address Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                edaddress.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                edaddress.startAnimation(startAnimation);
                            }
                            else if(areas.equals("Choose")) {
                                Snackbar.make(view, "Choose Quotation Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlrs3.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlrs3.startAnimation(startAnimation);
                            } else if(floorses.equals("Select Budget")) {
                                Snackbar.make(view, "Select Budget Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlrs2.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlrs2.startAnimation(startAnimation);
                            }else if(Budget.equals("Select Floors")) {
                                Snackbar.make(view, "Select Floors Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlrs4.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlrs4.startAnimation(startAnimation);
                            }
                            else {
                                mclass.setCompany(multiAutoCompleteTextView1.getText().toString());
                                mclass.setBuliding(sppositonsell.getSelectedItem().toString());
                                mclass.setAdd(edaddress.getText().toString());
                                mclass.setQuotation(sprs1.getSelectedItem().toString());
                                mclass.setNegotiation(sprs2.getSelectedItem().toString());
                                mclass.setFloor(sprs3.getSelectedItem().toString());
                                mclass.setSertyp(9);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
                            }
                        } else if (sertyp == 10) {
                            size=sppositonsell.getSelectedItem().toString();
                            areas=sprs1.getSelectedItem().toString();
                            Budget=sprs3.getSelectedItem().toString();
                            if (multiAutoCompleteTextView1.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter Company Name (or)Person Name", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView1.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView1.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else if(size.equals("Select Building Type")) {
                                Snackbar.make(view, "Select Building Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlsppositonsells.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlsppositonsells.startAnimation(startAnimation);
                            } else if(edaddress.getText().toString().equals("")){
                                Snackbar.make(view, "Select Address Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                edaddress.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                edaddress.startAnimation(startAnimation);
                            }else if(areas.equals("Select Budget")) {
                                Snackbar.make(view, "Select Budget Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlrs3.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlrs3.startAnimation(startAnimation);
                            }else if(Budget.equals("Select floor")) {
                                Snackbar.make(view, "Select Floor Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlrs4.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlrs4.startAnimation(startAnimation);
                            }
                            else {
                                mclass.setCompany(multiAutoCompleteTextView1.getText().toString());
                                mclass.setBuliding(sppositonsell.getSelectedItem().toString());
                                mclass.setAdd(edaddress.getText().toString());
                                mclass.setBudget(sprs1.getSelectedItem().toString());

                                mclass.setFloor(sprs3.getSelectedItem().toString());
                                mclass.setSertyp(10);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
                            }

                        } else if (sertyp == 11) {
                            size=sppositonsell.getSelectedItem().toString();
                            areas=sprs1.getSelectedItem().toString();
                            floorses=sprs2.getSelectedItem().toString();
                            Budget=sprs3.getSelectedItem().toString();
                            mclass.setBudgetflag(budgflag);
                            if (multiAutoCompleteTextView1.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter Company Name (or)Person Name", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView1.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView1.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else if(size.equals("Select Building Type")) {
                                Snackbar.make(view, "Select Building Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlsppositonsells.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlsppositonsells.startAnimation(startAnimation);
                            }else if(edaddress.getText().toString().equals("")){
                                Snackbar.make(view, "Select Address Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                edaddress.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                edaddress.startAnimation(startAnimation);
                            }else if(areas.equals("Choose")&& budgflag==1) {
                                Snackbar.make(view, "Choose Quotation Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlrs3.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlrs3.startAnimation(startAnimation);
                            } else if(floorses.equals("Select Budget")) {
                                Snackbar.make(view, "Select Budget Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlrs2.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlrs2.startAnimation(startAnimation);
                            }else if(Budget.equals("Select year")) {
                                Snackbar.make(view, "Select year Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                rlrs4.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                rlrs4.startAnimation(startAnimation);
                            }
                            else {
                                mclass.setCompany(multiAutoCompleteTextView1.getText().toString());
                                mclass.setBuliding(sppositonsell.getSelectedItem().toString());
                                mclass.setAdd(edaddress.getText().toString());
                                mclass.setQuotation(sprs1.getSelectedItem().toString());
                                mclass.setNegotiation(sprs2.getSelectedItem().toString());
                                mclass.setYear(sprs3.getSelectedItem().toString());
                                mclass.setSertyp(11);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
                            }
                            }else if (sertyp == 12) {
                                size=sppositonsell.getSelectedItem().toString();
                                areas=sprs1.getSelectedItem().toString();
                                floorses=sprs2.getSelectedItem().toString();
                                Budget=sprs3.getSelectedItem().toString();
                                mclass.setBudgetflag(budgflag);
                                if (multiAutoCompleteTextView1.getText().toString().equals("")) {
                                    Snackbar.make(view, "Please Enter Company Name (or)Person Name", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();

                                    multiAutoCompleteTextView1.setBackgroundResource(R.drawable.mybordererror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                    multiAutoCompleteTextView1.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                                }else if(size.equals("Select Building Type")) {
                                    Snackbar.make(view, "Select Building Field", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    rlsppositonsells.setBackgroundResource(R.drawable.myborderbuildingerror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                    rlsppositonsells.startAnimation(startAnimation);
                                }else if(edaddress.getText().toString().equals("")){
                                    Snackbar.make(view, "Select Address Field", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    edaddress.setBackgroundResource(R.drawable.myborderbuildingerror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                    edaddress.startAnimation(startAnimation);
                                }else if(areas.equals("Choose")&& budgflag==1) {
                                    Snackbar.make(view, "Choose Quotation Field", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    rlrs3.setBackgroundResource(R.drawable.myborderbuildingerror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                    rlrs3.startAnimation(startAnimation);
                                } else if(floorses.equals("Select Budget")) {
                                    Snackbar.make(view, "Select Budget Field", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    rlrs2.setBackgroundResource(R.drawable.myborderbuildingerror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                    rlrs2.startAnimation(startAnimation);
                                }else if(Budget.equals("Select year")) {
                                    Snackbar.make(view, "Select year Field", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    rlrs4.setBackgroundResource(R.drawable.myborderbuildingerror);
                                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                    rlrs4.startAnimation(startAnimation);
                                }
                                else {
                                    mclass.setCompany(multiAutoCompleteTextView1.getText().toString());
                                    mclass.setBuliding(sppositonsell.getSelectedItem().toString());
                                    mclass.setAdd(edaddress.getText().toString());
                                    mclass.setQuotation(sprs1.getSelectedItem().toString());
                                    mclass.setNegotiation(sprs2.getSelectedItem().toString());
                                    mclass.setYear(sprs3.getSelectedItem().toString());
                                    mclass.setSertyp(12);
                                    builder = new AlertDialog.Builder(ServicingActivity.this);
                                    View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                    btnyes = (Button) vw.findViewById(R.id.btnyes);
                                    btnno = (Button) vw.findViewById(R.id.btnno);
                                    tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                    grfont gr = new grfont(ServicingActivity.this);
                                    gr.grfonttxt(tvselect);
                                    gr.grfontbut(btnyes);
                                    gr.grfontbut(btnno);
                                    btnno.setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {


                                            alertDialog.dismiss();

                                        }

                                    });
                                    btnyes.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                                    builder.setView(vw);
                                    alertDialog = builder.create();
                                    alertDialog.show();
                                }
                        } else if (sertyp == 13) {
                            if(radiog.getCheckedRadioButtonId()==-1) {
                                Snackbar.make(view, "Please select Service type", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                            }else if (tvintime.getText().toString().equals("Intime")) {
                                Snackbar.make(view, "Please select Intime type", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                tvintime.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                tvintime.startAnimation(startAnimation);
                            }else if (tvcount1.getText().toString().equals("00")&&tvcount2.getText().toString().equals("00")&&tvcount3.getText().toString().equals("00")) {
                                Snackbar.make(view, " Selected Hrs Qty should not be 00", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
//                                tvintime.setBackgroundResource(R.drawable.mybordererror);
//                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
//                                tvintime.startAnimation(startAnimation);
                            }

                            else {
                                int id = radiog.getCheckedRadioButtonId();
                               // int ids = radiogp.getCheckedRadioButtonId();
                                //View radioButton = radiogp.findViewById(id);
                                RadioButton selectedRadioButton = (RadioButton) findViewById(id);
                              //  RadioButton selectedRadioButtons = (RadioButton) findViewById(ids);
                                //RadioButton btn = (RadioButton) radiogp.getChildAt(radioId);
                                selection = selectedRadioButton.getText().toString();
                               // selections = selectedRadioButtons.getText().toString();


                                // String selection = (String) selectedRadioButton.getText();
                               // mclass.setGender(selection);
                                mclass.setChoose(selection);
                                if (timeslot == null) {
                                    Snackbar.make(view, "Please Select Hrs", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                } else if (timeslot.equalsIgnoreCase("4 Hrs")) {
                                    mclass.setQty(tvcount1.getText().toString());
                                } else if (timeslot.equalsIgnoreCase("8 Hrs")) {
                                    mclass.setQty(tvcount2.getText().toString());
                                } else if (timeslot.equalsIgnoreCase("12 Hrs")) {
                                    mclass.setQty(tvcount3.getText().toString());
                                }

                                mclass.setIntime(tvintime.getText().toString());

                                //mclass.setQty(tvcount2.getText().toString());
                                //mclass.setQty(tvcount3.getText().toString());
                                mclass.setOuttime(tvouttime.getText().toString());
                                // mclass.setChoose(radiogp.getText().toString());
                                mclass.setWeekoff(tvcount4.getText().toString());
                                mclass.setSertyp(13);
//                            if (selection.equals("")) {
//                                Snackbar.make(view, "Select field size", Snackbar.LENGTH_LONG)
//                                        .setAction("Action", null).show();
//                                //etminimum.setError(null);
//                           // selection.setBackgroundResource(R.drawable.mybordererror);
//                              //  Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
//                              // radiog.startAnimation(startAnimation);
//
// } }
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
                            }
//
                        } else if (sertyp == 14) {
                            if (etselectmakes.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                etselectmakes.setError(null);

                                etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }
                            else{
                                mclass.setIssue(etselectmakes.getText().toString());
                                mclass.setSertyp(14);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();

                            }
                        } else if (sertyp == 15) {
                            if (etselectmakes.getText().toString().equals("")) {
                                Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                etselectmakes.setError(null);

                                etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }
                            else{
                                mclass.setIssue(etselectmakes.getText().toString());
                                mclass.setSertyp(15);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();

                            }
                        }
                    } else if (pos == 4) {
                        if (etselectmakes.getText().toString().equals("")) {
                            Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            etselectmakes.setError(null);

                            etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                            Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                            etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                        }
                        else{
                            mclass.setIssue(etselectmakes.getText().toString());

                            builder = new AlertDialog.Builder(ServicingActivity.this);
                            View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                            btnyes = (Button) vw.findViewById(R.id.btnyes);
                            btnno = (Button) vw.findViewById(R.id.btnno);
                            tvselect = (TextView) vw.findViewById(R.id.tvselect);
                            grfont gr = new grfont(ServicingActivity.this);
                            gr.grfonttxt(tvselect);
                            gr.grfontbut(btnyes);
                            gr.grfontbut(btnno);
                            btnno.setOnClickListener(new View.OnClickListener() {


                                @Override
                                public void onClick(View v) {


                                    alertDialog.dismiss();

                                }

                            });
                            btnyes.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            builder.setView(vw);
                            alertDialog = builder.create();
                            alertDialog.show();

                        }

                    } else if (pos == 5) {
                        if (etselectmakes.getText().toString().equals("")) {
                            Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            etselectmakes.setError(null);

                            etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                            Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                            etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                        }
                        else{
                            mclass.setIssue(etselectmakes.getText().toString());

                            builder = new AlertDialog.Builder(ServicingActivity.this);
                            View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                            btnyes = (Button) vw.findViewById(R.id.btnyes);
                            btnno = (Button) vw.findViewById(R.id.btnno);
                            tvselect = (TextView) vw.findViewById(R.id.tvselect);
                            grfont gr = new grfont(ServicingActivity.this);
                            gr.grfonttxt(tvselect);
                            gr.grfontbut(btnyes);
                            gr.grfontbut(btnno);
                            btnno.setOnClickListener(new View.OnClickListener() {


                                @Override
                                public void onClick(View v) {


                                    alertDialog.dismiss();

                                }

                            });
                            btnyes.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            builder.setView(vw);
                            alertDialog = builder.create();
                            alertDialog.show();

                        }

                    } else if (pos == 6) {
                        if (etselectmakes.getText().toString().equals("")) {
                            Snackbar.make(view, "Please Enter issue", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            etselectmakes.setError(null);

                            etselectmakes.setBackgroundResource(R.drawable.mybordererror);
                            Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                            etselectmakes.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                        }
                        else{
                            mclass.setIssue(etselectmakes.getText().toString());

                            builder = new AlertDialog.Builder(ServicingActivity.this);
                            View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                            btnyes = (Button) vw.findViewById(R.id.btnyes);
                            btnno = (Button) vw.findViewById(R.id.btnno);
                            tvselect = (TextView) vw.findViewById(R.id.tvselect);
                            grfont gr = new grfont(ServicingActivity.this);
                            gr.grfonttxt(tvselect);
                            gr.grfontbut(btnyes);
                            gr.grfontbut(btnno);
                            btnno.setOnClickListener(new View.OnClickListener() {


                                @Override
                                public void onClick(View v) {


                                    alertDialog.dismiss();

                                }

                            });
                            btnyes.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            builder.setView(vw);
                            alertDialog = builder.create();
                            alertDialog.show();


                    }
                    } else if (pos == 7) {
                        if (sertyp == 0) {
                            size=spvehicle.getSelectedItem().toString();
                            if(size.equals("Choose")) {
                                Snackbar.make(view, "Choose area Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                relativespinnerfloors.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                relativespinnerfloors.startAnimation(startAnimation);
                            }else if (multiAutoCompleteTextView1.getText().toString().equals("")) {
                                Snackbar.make(view, "Select area field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView1.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.blinking_animation);
                                multiAutoCompleteTextView1.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            }else {
                                mclass.setGuest(spvehicle.getSelectedItem().toString());
                                mclass.setHost(multiAutoCompleteTextView1.getText().toString());
                                mclass.setSertyp(0);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();


                            }
                        } else if (sertyp == 1) {
                            mclass.setSertyp(1);
                            builder = new AlertDialog.Builder(ServicingActivity.this);
                            View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                            btnyes = (Button) vw.findViewById(R.id.btnyes);
                            btnno = (Button) vw.findViewById(R.id.btnno);
                            tvselect = (TextView) vw.findViewById(R.id.tvselect);
                            grfont gr = new grfont(ServicingActivity.this);
                            gr.grfonttxt(tvselect);
                            gr.grfontbut(btnyes);
                            gr.grfontbut(btnno);
                            btnno.setOnClickListener(new View.OnClickListener() {


                                @Override
                                public void onClick(View v) {


                                    alertDialog.dismiss();

                                }

                            });
                            btnyes.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            builder.setView(vw);
                            alertDialog = builder.create();
                            alertDialog.show();

                        } else if (sertyp == 2) {
                            size = spvehicle.getSelectedItem().toString();
                            if(radiog.getCheckedRadioButtonId()==-1) {
                                Snackbar.make(view, "Please select Food Perference", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }
                              else  if (size.equals("Choose")) {
                                Snackbar.make(view, "Choose area Field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                relativespinnerfloors.setBackgroundResource(R.drawable.myborderbuildingerror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                relativespinnerfloors.startAnimation(startAnimation);
                            } else if (multiAutoCompleteTextView1.getText().toString().equals("")) {
                                Snackbar.make(view, "Select area field", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                multiAutoCompleteTextView1.setBackgroundResource(R.drawable.mybordererror);
                                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                                multiAutoCompleteTextView1.startAnimation(startAnimation);

//                            ObjectAnimator anim = ObjectAnimator.ofFloat(etselectmakes,"rotation",360);
//                            anim.setDuration(3000);
//                            anim.start();
                            } else {
                                mclass.setGuest(spvehicle.getSelectedItem().toString());
                                mclass.setHost(multiAutoCompleteTextView1.getText().toString());
                                int id = radiog.getCheckedRadioButtonId();

                                //View radioButton = radiogp.findViewById(id);
                                RadioButton selectedRadioButton = (RadioButton) findViewById(id);

                                //RadioButton btn = (RadioButton) radiogp.getChildAt(radioId);

                                selections = selectedRadioButton.getText().toString();
                                // String selection = (String) selectedRadioButton.getText();

                                mclass.setVeg(selections);
                                mclass.setSertyp(2);
                                builder = new AlertDialog.Builder(ServicingActivity.this);
                                View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                                btnyes = (Button) vw.findViewById(R.id.btnyes);
                                btnno = (Button) vw.findViewById(R.id.btnno);
                                tvselect = (TextView) vw.findViewById(R.id.tvselect);
                                grfont gr = new grfont(ServicingActivity.this);
                                gr.grfonttxt(tvselect);
                                gr.grfontbut(btnyes);
                                gr.grfontbut(btnno);
                                btnno.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {


                                        alertDialog.dismiss();

                                    }

                                });
                                btnyes.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();
                            }
                        }

                    } else if (pos == 8) {
                        size = sprs1.getSelectedItem().toString();
                        if (size.equals("Select Budget")) {
                            Snackbar.make(view, "Choose Budget Field", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            rlrs1.setBackgroundResource(R.drawable.myborderbuildingerror);
                            Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.blinking_animation);
                            rlrs1.startAnimation(startAnimation);
                        }else {
                            mclass.setBudget(sprs1.getSelectedItem().toString());
                            builder = new AlertDialog.Builder(ServicingActivity.this);
                            View vw = getLayoutInflater().inflate(R.layout.popupcontinue, null);
                            btnyes = (Button) vw.findViewById(R.id.btnyes);
                            btnno = (Button) vw.findViewById(R.id.btnno);
                            tvselect = (TextView) vw.findViewById(R.id.tvselect);
                            grfont gr = new grfont(ServicingActivity.this);
                            gr.grfonttxt(tvselect);
                            gr.grfontbut(btnyes);
                            gr.grfontbut(btnno);
                            btnno.setOnClickListener(new View.OnClickListener() {


                                @Override
                                public void onClick(View v) {


                                    alertDialog.dismiss();

                                }

                            });
                            btnyes.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ServicingActivity.this, SchedulePageActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            builder.setView(vw);
                            alertDialog = builder.create();
                            alertDialog.show();
                        }
                    }


                //}
            }
        });


//
        if (pos == 0) {
            if (sertyp == 0) {

//

                if (fName.equalsIgnoreCase("Services")) {
                    tvselectmake.setText(mclass.getType());
                     tvselectmakes.setText(mclass.getModel());
                   // mclass.setType(tvselectmake.getText().toString());
//                    tvselectmake.setText("Two-Wheelers");
                    tvrequested.setText("Requested for the Service");
                    gr.grfonttxt(tvselectmake);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });


                } else if (fName.equalsIgnoreCase("Repair")) {
                    tvselectmake.setText(mclass.getType());
                    tvselectmakes.setText(mclass.getModel());
                 //   tvselectmake.setText("Two-Wheelers");
                    // tvselectmakes.setText("Two-Wheelers");
                    tvrequested.setText("Requested for the Repair");
                    gr.grfonttxt(tvselectmake);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    tvcommercial.setText("Repair");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                 ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }
//

                linearLayout = (LinearLayout) findViewById(R.id.rlselectmake);
                relativeLayout2 = (RelativeLayout) findViewById(R.id.rltop);

            }else if (sertyp == 1) {
                if (fName.equalsIgnoreCase("Services")) {

                    tvselectmake.setText(mclass.getType());
                    tvselectmakes.setText(mclass.getModel());
                   // tvselectmake.setText("Cars");
                    tvrequested.setText("Requested for the Service");
                    gr.grfonttxt(tvselectmake);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });


                } else if (fName.equalsIgnoreCase("Repair")) {
                   // tvselectmake.setText("Cars");
                    tvselectmake.setText(mclass.getType());
                    tvselectmakes.setText(mclass.getModel());
                    // tvselectmakes.setText("Two-Wheelers");
                    tvrequested.setText("Requested for the Repair");
                    gr.grfonttxt(tvselectmake);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    tvcommercial.setText("Repair");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//

                }
//

                linearLayout = (LinearLayout) findViewById(R.id.rlselectmake);
                relativeLayout2 = (RelativeLayout) findViewById(R.id.rltop);

            }else if (sertyp == 2) {
                if (fName.equalsIgnoreCase("Services")) {


                  tvselectmake.setText(mclass.getType());
                    tvselectmakes.setText(mclass.getModel());
                    tvrequested.setText("Requested for the Service");
                    gr.grfonttxt(tvselectmake);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });


                } else if (fName.equalsIgnoreCase("Repair")) {
                    tvselectmake.setText(mclass.getType());
                    tvselectmakes.setText(mclass.getModel());
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    // tvselectmakes.setText("Two-Wheelers");
                    tvrequested.setText("Requested for the Repair");
                    gr.grfonttxt(tvselectmake);

                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                    tvcommercial.setText("Repair");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);

                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }
//

                linearLayout = (LinearLayout) findViewById(R.id.rlselectmake);
                relativeLayout2 = (RelativeLayout) findViewById(R.id.rltop);

            }
        } else if (pos == 2) {
            if (sertyp == 0) {


                if (fName.equalsIgnoreCase("Services")) {


                    tventer.setText("EX:picture but no sound");
                    tvrequested.setText("Requested for Service");

                    gr.grfonttxt(tventer);

                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tvrequested);

                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//
                } else if (fName.equalsIgnoreCase("Repair")) {

                    tventer.setText("EX:picture but no sound");

                    tvrequested.setText("Requested for Repair");
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);


                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    tvcommercial.setText("Repair");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                }

            } else if (sertyp == 1) {
                if (fName.equalsIgnoreCase("Services")) {


                    tventer.setText("EX:DVD keeps freezing or skipping");
                    tvrequested.setText("Requested for Service");
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);

                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tvrequested);

                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//
                } else if (fName.equalsIgnoreCase("Repair")) {

                    tventer.setText("EX:DVD keeps freezing or skipping");

                    tvrequested.setText("Requested for Repair");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    tvcommercial.setText("Repair");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                }

            } else if (sertyp == 2) {

                if (fName.equalsIgnoreCase("Services")) {


                    tventer.setText("EX:Refrigerator not cooling");
                    tvrequested.setText("Requested for Service");


                    gr.grfonttxt(tventer);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tvrequested);

                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//
                } else if (fName.equalsIgnoreCase("Repair")) {

                    tventer.setText("EX:Refrigerator not cooling");

                    tvrequested.setText("Requested for Repair");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    tvcommercial.setText("Repair");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                }
            } else if (sertyp == 3) {
                if (fName.equalsIgnoreCase("Services")) {


                    tventer.setText("EX:washer is vibrating");
                    tvrequested.setText("Requested for Service");


                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tvrequested);

                    gr.grfonttxt(tventer);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//
                } else if (fName.equalsIgnoreCase("Repair")) {

                    tventer.setText("EX:washer is vibrating");

                    tvrequested.setText("Requested for Repair");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    tvcommercial.setText("Repair");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                }
            } else if (sertyp == 4) {
                if (fName.equalsIgnoreCase("Services")) {


                    tventer.setText("EX:picture but no sound");
                    tvrequested.setText("Requested for Service");


                    gr.grfonttxt(tventer);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tvrequested);

                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//
                } else if (fName.equalsIgnoreCase("Repair")) {

                    tventer.setText("EX:picture but no sound");

                    tvrequested.setText("Requested for Repair");

                    gr.grfonttxt(tventer);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);


                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    tvcommercial.setText("Repair");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                }
            } else if (sertyp == 5) {
                if (fName.equalsIgnoreCase("Services")) {


                    tventer.setText("EX:Water leaking through the ceiling");
                    tvrequested.setText("Requested for Service");


                    gr.grfonttxt(tventer);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tvrequested);

                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//
                } else if (fName.equalsIgnoreCase("Repair")) {

                    tventer.setText("EX:Water leaking through the ceiling");

                    tvrequested.setText("Requested for Repair");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    tvcommercial.setText("Repair");
                    gr.grfonttxt(tvcommercial);
                    //views.add(view);
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                }
            }


//            gr.grfonttxt(checkbut);
//            gr.grfonttxt(forgetpass);
//            gr.grfontbut(b1);
//            gr.grfonttxtinpt(txtlay1);
//            gr.grfonttxtinpt(txtlay2);
//            gr.grfonttxt(logintext);
//            gr.grfonttxtinpt(txtlay);

            //lv = (ListView) findViewById(R.id.listView1);


//        CustomAdapter adapter = new CustomAdapter(this, modelItems);
//        lv.setAdapter(adapter);

            linearLayout = (LinearLayout) findViewById(R.id.rlselectmake);
            relativeLayout2 = (RelativeLayout) findViewById(R.id.rltop);
            // fm = getFragmentManager();
            // ft = fm.beginTransaction();
            //Fragmentone fragmentone = new Fragmentone();
            // Fragmenttwo fragmenttwo = new Fragmenttwo();
            //ft.remove(fragmenttwo);
            //ft.add(R.id.frame_containerone, fragmentone);

            // ft.commit();
//            etselectmakes = (EditText) findViewById(R.id.etselectmakes);
//            tvselectmake = (TextView) findViewById(R.id.tvselectmake);
//            grfont gr = new grfont(ServicingActivity.this);
//            gr.grfonttxt(tvselectmake);
//            gr.grfonttxt(tvservicing);
//            gr.grfonttxt(tvarticles);
//            gr.grfonted(etselectmakes);
            tvselectmake.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (count == 1) {


                        linearLayout.setVisibility(View.VISIBLE);
                        tvselectmake.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.substract, 0);
                        count++;
                    } else {
                        count = 0;


                        linearLayout.setVisibility(View.GONE);
                        tvselectmake.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.plus, 0);
                        count++;


                    }
                }
            });


            view = getLayoutInflater().inflate(R.layout.itemrepair, null);

            // CustomAdapter adapter = new CustomAdapter(this,


//            modelItems = new Model[3];
//            modelItems[0] = new Model("GetRepair Door Step Servicing",R.drawable.indianrupee,"450");
//            modelItems[1] = new Model("Battery- Charging",R.drawable.indianrupee,"300");
//            modelItems[2] = new Model("Battery- Replacement",R.drawable.indianrupee,"250");

        } else if (pos == 4) {

            if (sertyp == 0) {
                if (catvalue.equalsIgnoreCase("Commerical")) {




                    // tvselectmake.setText("Add to repair");

                    insertPoints.setVisibility(view.VISIBLE);
                    tventer.setText("EX:Electrical Interior");

                    tvrequested.setText("Requested for Electrical work ");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    //insertPointing.setVisibility(view.GONE);
                    gr.grfonttxt(tvselectmake);

                    tvselectmake.setText("Electrical Work");
//                gr.grfonttxt(tvprice);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Commerical");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

//

                }
                if (catvalue.equalsIgnoreCase("Residential")) {


                    // tvselectmake.setText("Add to repair");

                    insertPoints.setVisibility(view.VISIBLE);
                    tvcompany.setText("Name of the Person:");
                    multiAutoCompleteTextViews.setText("Maheswari");

                    tventer.setText("EX:Electrical Interior");

                    tvrequested.setText("Requested for Electrical work ");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    // insertPointing.setVisibility(view.GONE);
                    gr.grfonttxt(tvselectmake);

                    tvselectmake.setText("Electrical Work");
//                gr.grfonttxt(tvprice);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Residential");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//

                }

            } else if (sertyp == 1) {


                tventer.setText("EX:Fingerprint feature doesn't work");

                tvrequested.setText("Requested for Biometric Service");

                gr.grfonttxt(tvrequested);
                gr.grfonttxt(tvselectmake);

                gr.grfonttxt(tventer);
                // insertPointing.setVisibility(view.GONE);

                tvselectmake.setText("BioMetric Service");
                gr.grfonttxt(tvselectmake);

//                gr.grfonttxt(tvprice);

                //views.add(view);
                View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                getSupportActionBar().setCustomView(mActionBarView);
                getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                getSupportActionBar().setElevation(0);
                tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                gr.grfonttxt(tvcommercial);
                tvcommercial.setText("Biometric");
                ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                ivactionmenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                        startActivity(intent);
                    }
                });

//


            } else if (sertyp == 2) {
                if (catvalue.equalsIgnoreCase("Commerical")) {


                    // tvselectmake.setText("Add to repair");

                    insertPoints.setVisibility(view.VISIBLE);

                    gr.grfonttxt(tvselectmake);
                    tventer.setText("EX:Dry servicing");
                    tvselectmake.setText("Air Conditioner");
                    tvrequested.setText("Requested for Air Conditioner Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


//                gr.grfonttxt(tvprice);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Commerical");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//

                }
                if (catvalue.equalsIgnoreCase("Residential")) {


                    // tvselectmake.setText("Add to repair");

                    insertPoints.setVisibility(view.VISIBLE);
                    tvcompany.setText("Name of the Person:");
                    multiAutoCompleteTextViews.setText("Maheswari");
                    tventer.setText("EX:Dry servicing");
                    tvselectmake.setText("Air Conditioner");
                    tvrequested.setText("Requested for Air Conditioner Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    // insertPointing.setVisibility(view.GONE);


//                gr.grfonttxt(tvprice);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Residential");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//

                }


            } else if (sertyp == 3) {


                //insertPointing.setVisibility(view.GONE);
                gr.grfonttxt(tvselectmake);

                tventer.setText("EX:Display toggle");
                tvselectmake.setText("Projector Service");
                tvrequested.setText("Requested for Projector Service");

                gr.grfonttxt(tvrequested);
                gr.grfonttxt(tvselectmake);

                gr.grfonttxt(tventer);

//                gr.grfonttxt(tvprice);

                //views.add(view);
                View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                getSupportActionBar().setCustomView(mActionBarView);
                getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                getSupportActionBar().setElevation(0);
                tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                gr.grfonttxt(tvcommercial);
                tvcommercial.setText("Projector");
                ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                ivactionmenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                        startActivity(intent);
                    }
                });

            } else if (sertyp == 4) {
                if (catvalue.equalsIgnoreCase("Commerical")) {

                    tventer.setText("EX:Fitting or Installation");
                    tvselectmake.setText("Plumber Work");
                    tvrequested.setText("Requested for Plumber Work Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    // tvselectmake.setText("Add to repair");

                    insertPoints.setVisibility(view.VISIBLE);

                    gr.grfonttxt(tvselectmake);
                    // insertPointing.setVisibility(view.GONE);

//                gr.grfonttxt(tvprice);
                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Commerical");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }
                if (catvalue.equalsIgnoreCase("Residential")) {


                    insertPoints.setVisibility(view.VISIBLE);
                    tvcompany.setText("Name of the Person:");
                    multiAutoCompleteTextViews.setText("Maheswari");

                    tventer.setText("EX:Fitting or Installation");
                    tvselectmake.setText("Plumber Work");
                    tvrequested.setText("Requested for Plumber Work Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

//                gr.grfonttxt(tvprice);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Residential");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }
            } else if (sertyp == 5) {
                if (catvalue.equalsIgnoreCase("Commerical")) {

                    tventer.setText("EX:Repainting");
                    tvselectmake.setText("Painter Work");
                    tvrequested.setText("Requested for Painter Work Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    // tvselectmake.setText("Add to repair");

                    insertPoints.setVisibility(view.VISIBLE);

                    gr.grfonttxt(tvselectmake);
                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Commerical");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//

                }
                if (catvalue.equalsIgnoreCase("Residential")) {
                    insertPoints.setVisibility(view.VISIBLE);
                    tvcompany.setText("Name of the Person:");
                    multiAutoCompleteTextViews.setText("Maheswari");
                    tventer.setText("EX:Repainting");
                    tvselectmake.setText("Painter Work");
                    tvrequested.setText("Requested for Painter Work Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Residential");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//

                }
            } else if (sertyp == 6) {
                if (catvalue.equalsIgnoreCase("Commerical")) {


                    tventer.setText("EX:Fitting or Installation");
                    tvselectmake.setText("Carpentry Work");
                    tvrequested.setText("Requested for Carpentry Work Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    // tvselectmake.setText("Add to repair");

                    insertPoints.setVisibility(view.VISIBLE);

                    gr.grfonttxt(tvselectmake);

//                gr.grfonttxt(tvprice);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Commerical");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//

                }
                if (catvalue.equalsIgnoreCase("Residential")) {
                    insertPoints.setVisibility(view.VISIBLE);
                    tvcompany.setText("Name of the Person:");
                    multiAutoCompleteTextViews.setText("Maheswari");
                    tventer.setText("EX:Fitting or Installation");
                    tvselectmake.setText("Carpentry Work");
                    tvrequested.setText("Requested for Carpentry Work Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Residential");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//

                }
            } else if (sertyp == 7) {


                // tvselectmake.setText("Add to repair");


                //  insertPoints.setVisibility(view.VISIBLE);

                tventer.setText("EX:slow application response");
                tvselectmake.setText("Lan Networking Service");
                tvrequested.setText("Requested for Lan Networking Service");

                gr.grfonttxt(tvrequested);
                gr.grfonttxt(tvselectmake);

                gr.grfonttxt(tventer);


//                gr.grfonttxt(tvprice);

                //views.add(view);
                View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                getSupportActionBar().setCustomView(mActionBarView);
                getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                getSupportActionBar().setElevation(0);
                tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                gr.grfonttxt(tvcommercial);
                tvcommercial.setText("Lan Networking");
                ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                ivactionmenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                        startActivity(intent);
                    }
                });
//

            } else if (sertyp == 8) {
                if (catvalue.equalsIgnoreCase("Services")) {
                    tventer.setText("EX:Motherboard failure");
                    tvselectmake.setText("Laptop Service");
                    tvrequested.setText("Requested for Laptop Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Services");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                } else if (catvalue.equalsIgnoreCase("Repair")) {
                    tventer.setText("EX:Motherboard failure");
                    tvselectmake.setText("Laptop Service");
                    tvrequested.setText("Requested for Laptop Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Repair");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }

            } else if (sertyp == 9) {

                if (catvalue.equalsIgnoreCase("Services")) {
                    tventer.setText("EX:Bright Spots on the Monitor");
                    tvselectmake.setText("CCTV Camera Service");
                    tvrequested.setText("Requested for CCTV Camera Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Services");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                } else if (catvalue.equalsIgnoreCase("Repair")) {
                    tventer.setText("EX:Bright Spots on the Monitor");
                    tvselectmake.setText("CCTV Camera Service");
                    tvrequested.setText("Requested for CCTV Camera Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);

                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Repair");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }


            } else if (sertyp == 10) {

                // tvselectmake.setText("Add to repair");

                tventer.setText("EX:Fitting or Installation");
                tvselectmake.setText("Glass doors and Glass work service");
                tvrequested.setText("Requested for Glass work Service");

                gr.grfonttxt(tvrequested);
                gr.grfonttxt(tvselectmake);

                gr.grfonttxt(tventer);


                //views.add(view);
                View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                getSupportActionBar().setCustomView(mActionBarView);
                getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                getSupportActionBar().setElevation(0);
                tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                gr.grfonttxt(tvcommercial);
                tvcommercial.setText("Glasswork and Glassdoor");
                ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                ivactionmenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                        startActivity(intent);
                    }
                });

//

            } else if (sertyp == 11) {
                if (catvalue.equalsIgnoreCase("Services")) {
                    tventer.setText("EX:Vacuum shuts off during use");
                    tvselectmake.setText("Cleaning Equipments Work");
                    tvrequested.setText("Requested for Cleaning Equipments Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Services");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//
                } else if (catvalue.equalsIgnoreCase("Repair")) {
                    tventer.setText("EX:Vacuum shuts off during use");
                    tvselectmake.setText("Cleaning Equipments Work");
                    tvrequested.setText("Requested for Cleaning Equipments Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Repair");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }

            } else if (sertyp == 12) {
                if (catvalue.equalsIgnoreCase("Services")) {
                    tventer.setText("EX:The printer is too slow");
                    tvselectmake.setText("Printer Service");
                    tvrequested.setText("Requested for Printer Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Services");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

//
                } else if (catvalue.equalsIgnoreCase("Repair")) {
                    tventer.setText("EX:The printer is too slow");
                    tvselectmake.setText("Printer Service");
                    tvrequested.setText("Requested for Printer Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Repair");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }


            } else if (sertyp == 13) {
                if (catvalue.equalsIgnoreCase("Services")) {
                    tventer.setText("EX:Seat Cushion");
                    tvselectmake.setText("Chair Work");
                    tvrequested.setText("Requested for Chair Work Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Services");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

//
                } else if (catvalue.equalsIgnoreCase("Repair")) {
                    tventer.setText("EX:Seat Cushion");
                    tvselectmake.setText("Chair Work");
                    tvrequested.setText("Requested for Chair Work Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Repair");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }

            } else if (sertyp == 14) {
                if (catvalue.equalsIgnoreCase("Services")) {
                    tventer.setText("EX:Heating Issues");
                    tvselectmake.setText("Mobile Service");
                    tvrequested.setText("Requested for Mobile Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Services");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//
                } else if (catvalue.equalsIgnoreCase("Repair")) {
                    tventer.setText("EX:Heating Issues");
                    tvselectmake.setText("Mobile Service");
                    tvrequested.setText("Requested for Mobile Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Repair");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }

            } else if (sertyp == 15) {
                if (catvalue.equalsIgnoreCase("Services")) {
                    tventer.setText("EX:Heating Issues");
                    tvselectmake.setText("Tablet Service");
                    tvrequested.setText("Requested for Tablet Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Services");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

//
                } else if (catvalue.equalsIgnoreCase("Repair")) {
                    tventer.setText("EX:Heating Issues");
                    tvselectmake.setText("Tablet Service");
                    tvrequested.setText("Requested for Tablet Service");

                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tvselectmake);

                    gr.grfonttxt(tventer);


                    //views.add(view);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Repair");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                }
            }

            } else if (pos == 3) {
                if (sertyp == 0) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {
                        view = getLayoutInflater().inflate(R.layout.item_securitygaurd_female, null);


                        insertPoints.setVisibility(View.VISIBLE);
                        tvselectmake.setText("Man Power Service");
                        tvrequested.setText(" Requested for Men Power Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);

//                gr.grfonttxt(tvone);
                        tvintime = (TextView) view.findViewById(R.id.tvintime);
                        tvgender= (TextView) view.findViewById(R.id.tvgender);
                        llinear= (LinearLayout) view.findViewById(R.id.llinear);
                        tvouttime = (TextView) view.findViewById(R.id.tvouttime);
                        tvfour = (TextView) view.findViewById(R.id.tvfour);
                        tveight = (TextView) view.findViewById(R.id.tveight);
                        tvfive = (TextView) view.findViewById(R.id.tvfive);
                        tvcount1 = (TextView) view.findViewById(R.id.tvcount1);
                        tvcount2 = (TextView) view.findViewById(R.id.tvcount2);
                        tvcount3 = (TextView) view.findViewById(R.id.tvcount3);
                        tvcount4 = (TextView) view.findViewById(R.id.tvcount4);
                        ivminus1 = (ImageView) view.findViewById(R.id.ivminus1);
                        ivminus2 = (ImageView) view.findViewById(R.id.ivminus2);
                        ivminus3 = (ImageView) view.findViewById(R.id.ivminus3);
                        ivminus4 = (ImageView) view.findViewById(R.id.ivminus4);
                        ivplus4 = (ImageView) view.findViewById(R.id.ivplus4);
                        ivplusone = (ImageView) view.findViewById(R.id.ivplusone);
                        ivplus2 = (ImageView) view.findViewById(R.id.ivplus2);
                        ivplus3 = (ImageView) view.findViewById(R.id.ivplus3);
                        tvduty = (TextView) view.findViewById(R.id.tvduty);
                        tvqty = (TextView) view.findViewById(R.id.tvqty);
                        tvweekoff = (TextView) view.findViewById(R.id.tvweekoff);
                        tvsericetype = (TextView) view.findViewById(R.id.tvsericetype);
                        radiogp = (RadioGroup) view.findViewById(R.id.radiogp);
                        radioButton = (RadioButton) view.findViewById(R.id.radioButton);
                        radioButton2 = (RadioButton) view.findViewById(R.id.radioButton2);
                        radioButton3 = (RadioButton) view.findViewById(R.id.radioButton3);
                        radioM = (RadioButton) view.findViewById(R.id.radioM);
                        radiog= (RadioGroup) view.findViewById(R.id.radioGrp);
                        radioF= (RadioButton) view.findViewById(R.id.radioF);
                        int id= radiog.getCheckedRadioButtonId();
                        int ids=radiogp.getCheckedRadioButtonId();
//                        View radioButton = radiogp.findViewById(id);
//                        RadioButton selectedRadioButton = (RadioButton) findViewById(id);
//                        //RadioButton btn = (RadioButton) radiogp.getChildAt(radioId);
//                        selection =  selectedRadioButton.getText().toString();
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        gr.grfonttxt(tvintime);
                        gr.grfonttxt(tvgender);
                        gr.grfontra(radioF);
                        gr.grfontra(radioM);
                        gr.grfonttxt(tvduty);
                        gr.grfonttxt(tvqty);
                        gr.grfonttxt(tvfour);
                        gr.grfonttxt(tveight);
                        gr.grfonttxt(tvfive);
                        gr.grfonttxt(tvweekoff);
                        gr.grfonttxt(tvsericetype);
                        gr.grfonttxt(tvintime);
                        gr.grfonttxt(tvouttime);
                        gr.grfontra((RadioButton) radioButton);
                        gr.grfontra(radioButton2);
                        gr.grfontra(radioButton3);
                        gr.grfonttxt(tvcount1);
                        gr.grfonttxt(tvcount2);
                        gr.grfonttxt(tvcount3);
                        gr.grfonttxt(tvcount4);
                        n=0;

                        ivplus4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                n=n+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(n);
                                // DecimalFormat formatter = new DecimalFormat("00");


                                tvcount4.setText(s);
                                ivminus4.setEnabled(true);
                            }
                        });
                        ivminus4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (n == 0) {
                                    ivminus4.setEnabled(false);

                                }else
                                n=n-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(n);
                                tvcount4.setText(s);

                            }
                        });
                        tvintime.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                builder = new AlertDialog.Builder(ServicingActivity.this);

                                View vw = getLayoutInflater().inflate(R.layout.datepicker, null);
                                timePicker = (TimePicker) vw.findViewById(R.id.timePicker);
                                set_button = (Button) vw.findViewById(R.id.set_button);
                                set_button.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {

                                        final String s1=setTime(set_button,tvintime);
                                        alertDialog.dismiss();
                                        if(timeslot==null){
                                            Toast.makeText(ServicingActivity.this,
                                                    "Please Select Hrs and then select Intime", Toast.LENGTH_LONG).show();
                                            /*Snackbar.make(v, "Please Select Hrs and then select Intime", Snackbar.LENGTH_LONG)
                                                    .setAction("Action", null).show();*/}
                                        else{

                                            tvintime.setText(s1);
                                            int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                            int pertime=selhrs+value;
                                            int permin=selmin+0;
                                            String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                            tvouttime.setText(fvalue);
                                        }

                                    }

                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();

                            }
                        });

                        ivplusone.setEnabled(false);
                        ivminus1.setEnabled(false);
                        ivplus2.setEnabled(false);
                        ivminus2.setEnabled(false);
                        tvfour.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvfour.setPadding(0, 10, 0, 10);
                                tveight.setPadding(0, 10, 0, 10);
                                tvfive.setPadding(0, 10, 0, 10);
                                mclass.setDuty(tvfour.getText().toString());
                                mclass.setQty(tvcount1.getText().toString());
                                tvfour.setTextColor(Color.parseColor("#ffffff"));
                                tvfour.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tveight.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setTextColor(Color.parseColor("#727272"));
                                tveight.setTextColor(Color.parseColor("#727272"));
                                if(timeslot!=null) {
                                    timeslot=tvfour.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvcount2.setText("00");
                                    tvcount3.setText("00");
                                    tvouttime.setText(fvalue);
                                }else{

                                timeslot=tvfour.getText().toString();}

                                ivplusone.setEnabled(true);
                                ivminus1.setEnabled(true);
                                i=0;

                            }
                        });
                        ivplusone.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i=i+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(i);
                               // DecimalFormat formatter = new DecimalFormat("00");

                                tvcount1.setText(s);
                                ivminus1.setEnabled(true);



                            }
                        });
                        ivminus1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (i== 0) {
                                    ivminus1.setEnabled(false);

                                }else
                                i=i-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(i);
                                //Toast.makeText(ServicingActivity.this,"minus"+k,Toast.LENGTH_LONG).show();
                                //DecimalFormat formatter = new DecimalFormat("00");
                               // String s = formatter.format(l--);

                                tvcount1.setText(s);


                            }
                        });

                        tveight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mclass.setDuty(tveight.getText().toString());
                                mclass.setQty(tvcount2.getText().toString());
                                tveight.setPadding(0, 10, 0, 10);
                                tvfour.setPadding(0, 10, 0, 10);
                                tvfive.setPadding(0, 10, 0, 10);
                                tveight.setTextColor(Color.parseColor("#ffffff"));
                                tveight.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tvfour.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setTextColor(Color.parseColor("#727272"));
                                tvfour.setTextColor(Color.parseColor("#727272"));
                                if(timeslot!=null) {
                                    timeslot=tveight.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvouttime.setText(fvalue);
                                    tvcount1.setText("00");
                                    tvcount3.setText("00");
                                }
else{
                                timeslot=tveight.getText().toString();}
                                ivplus2.setEnabled(true);
                                ivminus2.setEnabled(true);
                                k=0;
                                ivplus2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                 k=k+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(k);
                                      //  DecimalFormat formatter = new DecimalFormat("00");

                                        tvcount2.setText(s);
                                        ivminus2.setEnabled(true);

                                    }
                                });
                                ivminus2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (k== 0) {
                                            ivminus2.setEnabled(false);

                                        }else
                                        k=k-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(k);
                                        //k=5;
                                        //Toast.makeText(ServicingActivity.this,"minus"+k,Toast.LENGTH_LONG).show();
                                        //DecimalFormat formatter = new DecimalFormat("00");

                                        tvcount2.setText(s);

                                    }
                                });

                            }
                        });
                        tvfive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mclass.setDuty(tvfive.getText().toString());
                                mclass.setQty(tvcount3.getText().toString());
                                tvfive.setPadding(0, 10, 0, 10);
                                tvfour.setPadding(0, 10, 0, 10);
                                tveight.setPadding(0, 10, 0, 10);
                                tvfive.setTextColor(Color.parseColor("#ffffff"));
                                tvfive.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tvfour.setBackgroundResource(R.drawable.myborderbuilding);
                                tveight.setBackgroundResource(R.drawable.myborderbuilding);
                                tveight.setTextColor(Color.parseColor("#727272"));
                                tvfour.setTextColor(Color.parseColor("#727272"));
                                if(timeslot!=null) {
                                    timeslot=tvfive.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvouttime.setText(fvalue);
                                    tvcount2.setText("00");
                                    tvcount1.setText("00");
                                }else{

                                timeslot=tvfive.getText().toString();}
                                ivplus3.setEnabled(true);
                                ivminus3.setEnabled(true);
                                l=0;
                                ivplus3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        l=l+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(l);
                                        tvcount3.setText(s);
                                        ivminus3.setEnabled(true);


                                    }
                                });
                                ivminus3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (l== 0) {
                                            ivminus3.setEnabled(false);

                                        }else
                                        l=l-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(l);
                                        tvcount3.setText(s);

                                    }
                                });

                            }
                        });
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commercial");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        insertPoint.addView(view);

                    } else if (catvalue.equalsIgnoreCase("Residential")) {

                        View view = layoutInflator.inflate(R.layout.item_securitygaurd_female, null);

                        insertPoints.setVisibility(View.VISIBLE);
                        tvselectmake.setText("Man Power Service");
                        tvrequested.setText(" Requested for Men Power Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);

//                gr.grfonttxt(tvone);
                        tvintime = (TextView) view.findViewById(R.id.tvintime);
                        tvcompany = (TextView) view.findViewById(R.id.tvcompany);
                        multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view.findViewById(R.id.multiAutoCompleteTextView1);
                        tvouttime = (TextView) view.findViewById(R.id.tvouttime);
                        tvfour = (TextView) view.findViewById(R.id.tvfour);
                        tveight = (TextView) view.findViewById(R.id.tveight);
                        tvfive = (TextView) view.findViewById(R.id.tvfive);
                        tvcount1 = (TextView) view.findViewById(R.id.tvcount1);
                        tvcount2 = (TextView) view.findViewById(R.id.tvcount2);
                        tvcount3 = (TextView) view.findViewById(R.id.tvcount3);
                        tvcount4 = (TextView) view.findViewById(R.id.tvcount4);
                        ivminus1 = (ImageView) view.findViewById(R.id.ivminus1);
                        ivminus2 = (ImageView) view.findViewById(R.id.ivminus2);
                        ivminus3 = (ImageView) view.findViewById(R.id.ivminus3);
                        ivminus4 = (ImageView) view.findViewById(R.id.ivminus4);
                        ivplus4 = (ImageView) view.findViewById(R.id.ivplus4);
                        ivplusone = (ImageView) view.findViewById(R.id.ivplusone);
                        ivplus2 = (ImageView) view.findViewById(R.id.ivplus2);
                        ivplus3 = (ImageView) view.findViewById(R.id.ivplus3);
                        tvduty = (TextView) view.findViewById(R.id.tvduty);
                        tvqty = (TextView) view.findViewById(R.id.tvqty);
                        tvweekoff = (TextView) view.findViewById(R.id.tvweekoff);
                        radiogp = (RadioGroup) view.findViewById(R.id.radiogp);
                        tvsericetype = (TextView) view.findViewById(R.id.tvsericetype);
                        radioButton = (RadioButton) view.findViewById(R.id.radioButton);
                        radioButton2 = (RadioButton) view.findViewById(R.id.radioButton2);
                        radioButton3 = (RadioButton) view.findViewById(R.id.radioButton3);
                        radioM = (RadioButton) view.findViewById(R.id.radioM);
                        radioF= (RadioButton) view.findViewById(R.id.radioF);
                        tvgender= (TextView) view.findViewById(R.id.tvgender);
                        radiog= (RadioGroup) view.findViewById(R.id.radioGrp);
                        int id= radiog.getCheckedRadioButtonId();
                        int ids=radiogp.getCheckedRadioButtonId();
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextView1.setText("Maheswari");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        gr.grfonttxt(tvselectmake);
                        gr.grfonttxt(tvgender);
                        gr.grfontra(radioF);
                        gr.grfontra(radioM);
                        gr.grfonttxt(tvduty);
                        gr.grfonttxt(tvqty);
                        gr.grfonttxt(tvintime);
                        gr.grfonttxt(tvouttime);
                        gr.grfontra(radioButton);
                        gr.grfontra(radioButton2);
                        gr.grfontra(radioButton3);
                        gr.grfonttxt(tvcount1);
                        gr.grfonttxt(tvcount2);
                        gr.grfonttxt(tvcount3);
                        gr.grfonttxt(tvcount4);
                        gr.grfonttxt(tvfour);
                        gr.grfonttxt(tveight);
                        gr.grfonttxt(tvfive);
                        gr.grfonttxt(tvweekoff);
                        gr.grfonttxt(tvsericetype);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        m=0;
                        ivplus4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                m=m+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(m);
                                tvcount4.setText(s);


                                ivminus4.setEnabled(true);
                            }
                        });
                        ivminus4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (m == 0) {
                                    ivminus4.setEnabled(false);

                                }else
                                m=m-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(m);
                                tvcount4.setText(s);

                            }
                        });
                        tvintime.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                builder = new AlertDialog.Builder(ServicingActivity.this);

                                View vw = getLayoutInflater().inflate(R.layout.datepicker, null);
                                timePicker = (TimePicker) vw.findViewById(R.id.timePicker);
                                set_button = (Button) vw.findViewById(R.id.set_button);
                                set_button.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {

                                        final String s1=setTime(set_button,tvintime);
                                        alertDialog.dismiss();
                                        if(timeslot==null){
                                            Toast.makeText(ServicingActivity.this,
                                                    "Please Select Hrs and then select Intime", Toast.LENGTH_LONG).show();
                                            /*Snackbar.make(v, "Please Select Hrs and then select Intime", Snackbar.LENGTH_LONG)
                                                    .setAction("Action", null).show();*/}
                                        else{

                                            tvintime.setText(s1);
                                            int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                            int pertime=selhrs+value;
                                            int permin=selmin+0;
                                            String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                            tvouttime.setText(fvalue);
                                        }

                                    }

                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();

                            }
                        });
                        ivplusone.setEnabled(false);
                        ivminus1.setEnabled(false);
                        ivplus2.setEnabled(false);
                        ivminus2.setEnabled(false);

                        tvfour.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvfour.setPadding(0, 10, 0, 10);
                                tveight.setPadding(0, 10, 0, 10);
                                tvfive.setPadding(0, 10, 0, 10);
                                mclass.setDuty(tvfour.getText().toString());
                                tvfour.setTextColor(Color.parseColor("#ffffff"));
                                tvfour.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tveight.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setTextColor(Color.parseColor("#727272"));
                                tveight.setTextColor(Color.parseColor("#727272"));
                                if(timeslot!=null) {
                                    timeslot=tvfour.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvcount2.setText("00");
                                    tvcount3.setText("00");
                                    tvouttime.setText(fvalue);
                                }else {

                                    timeslot = tvfour.getText().toString();
                                }
                                ivminus1.setEnabled(true);
                                ivplusone.setEnabled(true);
                                i=0;
                                ivplusone.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        i=i+1;
                                         DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(i);
                                        tvcount1.setText(s);
//                                        DecimalFormat formatter = new DecimalFormat("00");
//                                        String s = formatter.format(i++);
//                                        tvcount1.setText(s);
//
                                       ivminus1.setEnabled(true);
                                    }
                                });
                                ivminus1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (i == 0) {
                                            ivminus1.setEnabled(false);

                                        }else
                                        i=i-1;
                                         DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(i);
                                        tvcount1.setText(s);

//                                        DecimalFormat formatter = new DecimalFormat("00");
//                                        String s = formatter.format(--i);
//                                        tvcount1.setText(s);

//                                        ivminus1.setEnabled(false);
//                                        ivminus2.setEnabled(false);
//                                        ivminus3.setEnabled(false);
//                                        ivplus2.setEnabled(false);
//                                        ivplus3.setEnabled(false);


                                    }
                                });

                            }
                        });
                        tveight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tveight.setPadding(0, 10, 0, 10);
                                tvfour.setPadding(0, 10, 0, 10);
                                tvfive.setPadding(0, 10, 0, 10);
                                if(timeslot!=null) {
                                    timeslot=tveight.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvouttime.setText(fvalue);
                                    tvcount1.setText("00");
                                    tvcount3.setText("00");
                                }
                                else {
                                    timeslot = tveight.getText().toString();
                                }
                                mclass.setDuty(tveight.getText().toString());
                                tveight.setTextColor(Color.parseColor("#ffffff"));
                                tveight.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tvfour.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setTextColor(Color.parseColor("#727272"));
                                tvfour.setTextColor(Color.parseColor("#727272"));
                                ivminus2.setEnabled(true);
                                ivplus2.setEnabled(true);
                                k=0;
                                ivplus2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        k=k+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(k);
                                        ivminus2.setEnabled(true);
                                        tvcount2.setText(s);

                                    }
                                });
                                ivminus2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (k == 0) {
                                            ivminus2.setEnabled(false);

                                        }else
                                        k=k-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(k);
                                        tvcount2.setText(s);

//                                        ivminus2.setEnabled(false);
//                                        ivminus1.setEnabled(false);
//                                        ivminus3.setEnabled(false);
//                                        ivplusone.setEnabled(false);
//                                        ivplus3.setEnabled(false);

                                    }
                                });

                            }
                        });
                        tvfive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvfive.setPadding(0, 10, 0, 10);
                                tvfour.setPadding(0, 10, 0, 10);
                                tveight.setPadding(0, 10, 0, 10);
                                if(timeslot!=null) {
                                    timeslot=tvfive.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvouttime.setText(fvalue);
                                    tvcount1.setText("00");
                                    tvcount2.setText("00");
                                }
                                else {
                                    timeslot = tvfive.getText().toString();
                                }
                                mclass.setDuty(tvfive.getText().toString());
                                tvfive.setTextColor(Color.parseColor("#ffffff"));
                                tvfive.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tvfour.setBackgroundResource(R.drawable.myborderbuilding);
                                tveight.setBackgroundResource(R.drawable.myborderbuilding);
                                tveight.setTextColor(Color.parseColor("#727272"));
                                tvfour.setTextColor(Color.parseColor("#727272"));
                                ivminus3.setEnabled(true);
                                ivplus3.setEnabled(true);
                                l=0;
                                ivplus3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        l=l+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(l);
                                        ivminus3.setEnabled(true);
                                        tvcount3.setText(s);
                                    }
                                });
                                ivminus3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (l == 0) {
                                            ivminus3.setEnabled(false);
                                        }else
                                        l=l-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(l);
                                        tvcount3.setText(s);

//                                        ivminus3.setEnabled(false);
//                                        ivminus2.setEnabled(false);
//                                        ivminus1.setEnabled(false);
//                                        ivplusone.setEnabled(false);
//                                        ivplus2.setEnabled(false);

                                    }
                                });

                            }
                        });
                        insertPoint.addView(view);

                    }

                    tvselectmake.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (count == 1) {


                                linearLayout.setVisibility(View.VISIBLE);
                                tvselectmake.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.substract, 0);
                                count++;
                            } else {
                                count = 0;


                                linearLayout.setVisibility(View.GONE);
                                tvselectmake.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.plus, 0);
                                count++;


                            }
                        }
                    });


//                gr.grfonttxt(tvprice);

                    //views.add(view);

//                modelItems = new Model[5];
//                modelItems[0] = new Model("Basic Inspection",R.drawable.indianrupee,"350");
//                modelItems[1] = new Model("Battery- Charging",R.drawable.indianrupee,"300");
//                modelItems[2] = new Model("Battery- Replacement",R.drawable.indianrupee,"250");
//                modelItems[3] = new Model("Engine Oil Change",R.drawable.indianrupee,"250");
//                modelItems[4] = new Model("Other Repairs",R.drawable.indianrupee,"on inspection");

                } else if (sertyp == 1) {


//                    if (fcat.equalsIgnoreCase("Commerical")) {
//                        View view = layoutInflator.inflate(R.layout.item_securitygaurd_female, null);
//                        gr.grfonttxt(tvselectmake);
//                        insertPoints = (LinearLayout) findViewById(R.id.contacts_type);
//                        insertPoints.setVisibility(View.VISIBLE);
//                        insertPointing.setVisibility(view.GONE);
////                    gr.grfonttxt(tvone);
//                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
//                        getSupportActionBar().setCustomView(mActionBarView);
//                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
//                        getSupportActionBar().setElevation(0);
//                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
//                        gr.grfonttxt(tvcommercial);
//                        tvcommercial.setText("Commerical");
//                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
//                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);
//
//                                startActivity(intent);
//                            }
//                        });
//                        insertPoint.addView(view);
//                    } else if (fcat.equalsIgnoreCase("Residential")) {
//                        View view = layoutInflator.inflate(R.layout.item_securitygaurd_female, null);
//                        insertPoints = (LinearLayout) findViewById(R.id.contacts_type);
//                        insertPoints.setVisibility(view.VISIBLE);
//                        insertPointing.setVisibility(view.GONE);
//                        tvcompany.setText("Name of the Person:");
//                        multiAutoCompleteTextView1.setText("Maheswari");
//                        // tvselectmake.setText("Add to repair");
////                    tvone = (TextView) view.findViewById(R.id.tvone);
////                    tvtwo = (TextView) view.findViewById(R.id.tvtwo);
////                    tvthree = (TextView) view.findViewById(R.id.tvthree);
//                        gr.grfonttxt(tvselectmake);
////                    gr.grfonttxt(tvone);
//                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
//                        getSupportActionBar().setCustomView(mActionBarView);
//                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
//                        getSupportActionBar().setElevation(0);
//                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
//                        gr.grfonttxt(tvcommercial);
//                        tvcommercial.setText("Residential");
//                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
//                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);
//
//                                startActivity(intent);
//                            }
//                        });
//                        insertPoint.addView(view);
//                    }

                } else if (sertyp == 2) {

                } else if (sertyp == 3) {


//                tvselectmake.setText("Add to service");

                        gr.grfonttxt(tvselectmake);

                       tvselectmake.setText("Techincal Support");

                        tvrequested.setText(" Requested for Techincal Services");

                        tventer.setText("EX:STP Operator");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);


//                gr.grfonttxt(tvprice);

                        //views.add(view);

                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Techincal Support");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });



                } else if (sertyp == 4) {
                    if (catvalue.equalsIgnoreCase("HR Consultant")) {


//                tvselectmake.setText("Add to service");

                            gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Placement Service");

                        tvrequested.setText(" Requested for Placement Services");

                        tventer.setText("EX:HR Manger");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);


//                gr.grfonttxt(tvprice);

                            //views.add(view);

                            View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                            getSupportActionBar().setCustomView(mActionBarView);
                            getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                            getSupportActionBar().setElevation(0);
                            tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                            gr.grfonttxt(tvcommercial);
                            tvcommercial.setText("Hr Consultant");
                            ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                            ivactionmenu.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                    startActivity(intent);
                                }
                            });


                    } else if (catvalue.equalsIgnoreCase("IT Consultant")) {

//                tvselectmake.setText("Add to service");

                            gr.grfonttxt(tvselectmake);

                        tvselectmake.setText("Placement Service");

                        tvrequested.setText(" Requested for Placement Services");

                        tventer.setText("EX:Application Developer");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);


//                gr.grfonttxt(tvprice);

                            //views.add(view);
                            View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                            getSupportActionBar().setCustomView(mActionBarView);
                            getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                            getSupportActionBar().setElevation(0);
                            tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                            gr.grfonttxt(tvcommercial);
                            tvcommercial.setText("IT Consultant ");
                            ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                            ivactionmenu.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                    startActivity(intent);
                                }
                            });


                    } else if (catvalue.equalsIgnoreCase("Marketing Consultant")) {


//                tvselectmake.setText("Add to service");

                            gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Placement Service");

                        tvrequested.setText(" Requested for Placement Services");

                        tventer.setText("EX:Marketing Manager");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);




//                gr.grfonttxt(tvprice);

                            //views.add(view);
                            View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                            getSupportActionBar().setCustomView(mActionBarView);
                            getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                            getSupportActionBar().setElevation(0);
                            tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                            gr.grfonttxt(tvcommercial);
                            tvcommercial.setText("Marketing Consultant ");
                            ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                            ivactionmenu.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                    startActivity(intent);
                                }
                            });

                    } else if (catvalue.equalsIgnoreCase("Financial Consultant")) {


//                tvselectmake.setText("Add to service");


                        tvselectmake.setText("Placement Service");

                        tvrequested.setText(" Requested for Placement Services");

                        tventer.setText("EX:Certified Financial Planner");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);



                        gr.grfonttxt(tvselectmake);


//                gr.grfonttxt(tvprice);

                            //views.add(view);
                            View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                            getSupportActionBar().setCustomView(mActionBarView);
                            getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                            getSupportActionBar().setElevation(0);
                            tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                            gr.grfonttxt(tvcommercial);
                            tvcommercial.setText("Financial Consultant");
                            ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                            ivactionmenu.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                    startActivity(intent);
                                }
                            });
                        }


                } else if (sertyp == 5) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {


//                tvselectmake.setText("Add to service");

                        gr.grfonttxt(tvselectmake);
                        insertPoints.setVisibility(View.VISIBLE);
tvselectmakes.setVisibility(view.GONE);

//                        insertPointing.setVisibility(view.GONE);
//tvselectmake.setVisibility(View.GONE);
                        tvselectmake.setText("One time Cleaning Services");
                        tvrequested.setText(" Requested for Cleaning Services");

                        tventer.setText("EX:Carpet Shampoo Cleaning");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
//                gr.grfonttxt(tvprice);

                        //views.add(view);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });

                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {


                        gr.grfonttxt(tvselectmake);
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextViews.setText("Maheswari");
                        tvselectmakes.setVisibility(view.GONE);

                        // insertPointing.setVisibility(view.GONE);

                        tvselectmake.setText("One time Cleaning Services");

                        tvrequested.setText(" Requested for Cleaning Services");

                        tventer.setText("EX:Carpet Shampoo Cleaning");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
//                gr.grfonttxt(tvprice);

                        //views.add(view);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });


                    }

                } else if (sertyp == 6) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {
                        view = getLayoutInflater().inflate(R.layout.moversandpackersitems, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);

                        tvselectmake.setText("Movers and Packers");

                        gr.grfonttxt(tvselectmake);
                        insertPointing.setVisibility(view.GONE);
                        etselectmakes.setVisibility(view.GONE);
                        //  insertPointing.setVisibility(view.GONE);

                        sprsone = (Spinner) view.findViewById(R.id.sprsone);
                        sprstwo = (Spinner) view.findViewById(R.id.sprstwo);
                        sprsthree = (Spinner) view.findViewById(R.id.sprsthree);
                        sprsfour = (Spinner) view.findViewById(R.id.sprsfour);
                        tvchoose = (TextView) view.findViewById(R.id.tvchoose);
                        tvduty = (TextView) view.findViewById(R.id.tvduty);
                        tvqty = (TextView) view.findViewById(R.id.tvqty);
                        tvone = (TextView) view.findViewById(R.id.tvone);
                        tvtwo = (TextView) view.findViewById(R.id.tvtwo);
                        tvthree = (TextView) view.findViewById(R.id.tvthree);
                        tvcounts = (TextView) view.findViewById(R.id.tvcounts);
                        tvcount = (TextView) view.findViewById(R.id.tvcount);
                        tvcounting = (TextView) view.findViewById(R.id.tvcounting);
                        tvlive= (TextView) view.findViewById(R.id.tvlive);
                        tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                        tvlift = (TextView) view.findViewById(R.id.tvlift);
                        tvlives = (TextView) view.findViewById(R.id.tvlives);
                        tvflooring = (TextView) view.findViewById(R.id.tvflooring);
                        tvlifts = (TextView) view.findViewById(R.id.tvlifts);
                        tvcompany = (TextView)view. findViewById(R.id.tvcompany);
                        multiAutoCompleteTextViews=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextViews);
                        multiAutoCompleteTextView3=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView3);
                        tvlocation = (TextView) view.findViewById(R.id.tvlocation);
                        multiAutoCompleteTextView1=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView1);
                        multiAutoCompleteTextView=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView);
                        gr.grfonttxt(tvselectmake);
                        gr.grfonttxt(tvchoose);
                        gr.grfonttxt(tvduty);
                        gr.grfonttxt(tvqty);
                        gr.grfonttxt(tvone);
                        gr.grfonttxt(tvtwo);
                        gr.grfonttxt(tvthree);
                        gr.grfonttxt(tvcounts);
                        gr.grfonttxt(tvcount);
                        gr.grfonttxt(tvcompany);
//                        gr.grfonmul(multiAutoCompleteTextViews);
                        gr.grfonttxt(tvcounting);
                        gr.grfonttxt(tvlive);
                        gr.grfonttxt(tvfloor);
                        gr.grfonttxt(tvlift);
                        gr.grfonttxt(tvlives);
                        gr.grfonttxt(tvflooring);
                        gr.grfonttxt(tvlifts);
                        gr.grfonttxt(tvlocation);
                        gr.grfonmul(multiAutoCompleteTextView3);
                        gr.grfonmul(multiAutoCompleteTextView);
                        gr.grfonmul(multiAutoCompleteTextView1);
                        insertPoints.setVisibility(view.VISIBLE);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });

                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                       R.layout.simple_spinner_item,R.id.textview,floor)
                        {

                            public View getView(int position, View convertView, ViewGroup parent) {
                                View v = super.getView(position, convertView, parent);

                                Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                ((TextView) v).setTypeface(externalFont);

                                return v;
                            }



                        };


                       // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprsone.setAdapter(adapter0);
                        sprsone.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,bhks)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprstwo.setAdapter(adapter1);
                        sprstwo.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter2 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,floor)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprsthree.setAdapter(adapter2);
                        sprsthree.setOnItemSelectedListener(onItemSelectedListener0);

                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,bhks)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprsfour.setAdapter(adapter3);
                        sprsfour.setOnItemSelectedListener(onItemSelectedListener0);

//
////
                        final TextView tvcounts = (TextView) view.findViewById(R.id.tvcounts);
                        final TextView tvcount = (TextView) view.findViewById(R.id.tvcount);
                        final TextView tvcounting = (TextView) view.findViewById(R.id.tvcounting);
                        final ImageView ivminus1 = (ImageView) view.findViewById(R.id.ivminus1);
                        final ImageView ivminus2 = (ImageView) view.findViewById(R.id.ivminus2);
                        final ImageView ivminus3 = (ImageView) view.findViewById(R.id.ivminus3);
                        final ImageView ivplus = (ImageView) view.findViewById(R.id.ivplus1);
                        final ImageView ivplus1 = (ImageView) view.findViewById(R.id.ivplus2);
                        final ImageView ivplus2 = (ImageView) view.findViewById(R.id.ivplus3);
                        p=0;
                        ivplus.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                p=p+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(p);
                                tvcounts.setText(s);

                                ivminus1.setEnabled(true);
                            }
                        });
                        ivminus1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (p == 0) {
                                    ivminus1.setEnabled(false);
                                }else
                                p=p-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(p);
                                tvcounts.setText(s);

                            }
                        });
                        q=0;
                        ivplus1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                q=q+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(q);
                                tvcount.setText(s);

                                ivminus2.setEnabled(true);
                            }
                        });
                        ivminus2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (q == 0) {
                                    ivminus2.setEnabled(false);
                                }else
                                q=q-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(q);
                                tvcount.setText(s);

                            }
                        });
                        r=0;
                        ivplus2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                r=r+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(r);
                                tvcounting.setText(s);

                                ivminus3.setEnabled(true);
                            }
                        });
                        ivminus3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (r == 0) {
                                    ivminus3.setEnabled(false);
                                }else
                                    r=r-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(r);
                                tvcounting.setText(s);

                            }
                        });
//
                        insertPoint.addView(view);

                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {
                        view = getLayoutInflater().inflate(R.layout.moversandpackersitems, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        insertPointing.setVisibility(view.GONE);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Movers and Packers");
                        etselectmakes.setVisibility(view.GONE);
                        sprsone = (Spinner) view.findViewById(R.id.sprsone);
                        sprstwo = (Spinner) view.findViewById(R.id.sprstwo);
                        sprsthree = (Spinner) view.findViewById(R.id.sprsthree);
                        sprsfour = (Spinner) view.findViewById(R.id.sprsfour);
                        tvcompany = (TextView)view. findViewById(R.id.tvcompany);


                        tvchoose = (TextView) view.findViewById(R.id.tvchoose);
                        tvduty = (TextView) view.findViewById(R.id.tvduty);
                        tvqty = (TextView) view.findViewById(R.id.tvqty);
                        tvone = (TextView) view.findViewById(R.id.tvone);
                        tvtwo = (TextView) view.findViewById(R.id.tvtwo);
                        tvthree = (TextView) view.findViewById(R.id.tvthree);
                        tvcounts = (TextView) view.findViewById(R.id.tvcounts);
                        tvcount = (TextView) view.findViewById(R.id.tvcount);
                        tvcounting = (TextView) view.findViewById(R.id.tvcounting);
                        tvlive= (TextView) view.findViewById(R.id.tvlive);
                        tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                        tvlift = (TextView) view.findViewById(R.id.tvlift);
                        tvlives = (TextView) view.findViewById(R.id.tvlives);
                        tvflooring = (TextView) view.findViewById(R.id.tvflooring);
                        tvlifts = (TextView) view.findViewById(R.id.tvlifts);
                        tvlocation = (TextView) view.findViewById(R.id.tvlocation);
                        multiAutoCompleteTextView3=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView3);
                        multiAutoCompleteTextView1=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView1);
                        multiAutoCompleteTextView=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView);
                        gr.grfonttxt(tvselectmake);
                        gr.grfonttxt(tvchoose);
                        gr.grfonttxt(tvduty);
                        gr.grfonttxt(tvqty);
                        gr.grfonttxt(tvone);
                        gr.grfonttxt(tvtwo);
                        gr.grfonttxt(tvthree);
                        gr.grfonttxt(tvcounts);
                        gr.grfonttxt(tvcount);
                        gr.grfonttxt(tvcounting);
                        gr.grfonttxt(tvlive);
                        gr.grfonttxt(tvfloor);
                        gr.grfonttxt(tvlift);
                        gr.grfonttxt(tvlives);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvflooring);
                        gr.grfonttxt(tvlifts);
                        gr.grfonttxt(tvlocation);
                        gr.grfonmul(multiAutoCompleteTextView3);
                        gr.grfonmul(multiAutoCompleteTextView);
                        gr.grfonmul(multiAutoCompleteTextView1);

                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextView3.setHint(" EX:Maheswari");
                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,floor)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprsone.setAdapter(adapter0);
                        sprsone.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,bhks)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprstwo.setAdapter(adapter1);
                        sprstwo.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter2 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,floor)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprsthree.setAdapter(adapter2);
                        sprsthree.setOnItemSelectedListener(onItemSelectedListener0);

                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,bhks)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprsfour.setAdapter(adapter3);
                        sprsfour.setOnItemSelectedListener(onItemSelectedListener0);

                        final TextView tvcounts = (TextView) view.findViewById(R.id.tvcounts);
                        final TextView tvcount = (TextView) view.findViewById(R.id.tvcount);
                        final TextView tvcounting = (TextView) view.findViewById(R.id.tvcounting);
                        final ImageView ivminus1 = (ImageView) view.findViewById(R.id.ivminus1);
                        final ImageView ivminus2 = (ImageView) view.findViewById(R.id.ivminus2);
                        final ImageView ivminus3 = (ImageView) view.findViewById(R.id.ivminus3);
                        final ImageView ivplus = (ImageView) view.findViewById(R.id.ivplus1);
                        final ImageView ivplus1 = (ImageView) view.findViewById(R.id.ivplus2);
                        final ImageView ivplus2 = (ImageView) view.findViewById(R.id.ivplus3);
                        p=0;
                        ivplus.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                p=p+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(p);
                                tvcounts.setText(s);

                                ivminus1.setEnabled(true);
                            }
                        });
                        ivminus1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (p == 0) {
                                    ivminus1.setEnabled(false);
                                }else
                                p=p-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(p);
                                tvcounts.setText(s);

                            }
                        });
                        q=0;
                        ivplus1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                q=q+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(q);
                                tvcount.setText(s);

                                ivminus2.setEnabled(true);
                            }
                        });
                        ivminus2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (q== 0) {
                                    ivminus2.setEnabled(false);
                                }else
                                q=q-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(q);
                                tvcount.setText(s);

                            }
                        });
                        r=0;
                        ivplus2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                r=r+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(r);
                                tvcounting.setText(s);

                                ivminus3.setEnabled(true);
                            }
                        });
                        ivminus3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (r == 0) {
                                    ivminus3.setEnabled(false);
                                }else
                                r=r-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(r);
                                tvcounting.setText(s);

                            }
                        });
//
                        insertPoint.addView(view);
                    }

                } else if (sertyp == 7) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {
                        view = getLayoutInflater().inflate(R.layout.activity_tours_travels, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        insertPoints.setVisibility(View.VISIBLE);
                        gr.grfonttxt(tvselectmake);
                         insertPointing.setVisibility(view.GONE);
                        spvehicle = (Spinner) view.findViewById(R.id.spvehicle);
                        rlvehicle = (RelativeLayout) view.findViewById(R.id.rlvehicle);
                        tvlocation =(TextView) view.findViewById(R.id.tvlocation);
                        tvcompany=(TextView)view.findViewById(R.id.tvcompany);
                        multiAutoCompleteTextView3=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView3);
                        multiAutoCompleteTextView=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView);
                        multiAutoCompleteTextView1=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView1);
                        tvpeople=(TextView) view.findViewById(R.id.tvpeople);
                        tvone=(TextView) view.findViewById(R.id.tvone);
                        tvcount=(TextView) view.findViewById(R.id.tvcount);
                        tvchild=(TextView) view.findViewById(R.id.tvchild);
                        tvcount1=(TextView) view.findViewById(R.id.tvcount1);
                        tvvehicle=(TextView) view.findViewById(R.id.tvvehicle);
                        tvtripdate=(TextView) view.findViewById(R.id.tvtripdate);
                        tvfromdate=(TextView) view.findViewById(R.id.tvfromdate);
                        tvtodate=(TextView) view.findViewById(R.id.tvtodate);
                        tvselectmake.setText("Tours and Traveler");
                        tvrequested.setText("Requested for Tours and Traveler Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvlocation);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvpeople);
                        gr.grfonttxt(tvone);
                        gr.grfonttxt(tvcount);
                        gr.grfonttxt(tvchild);
                        gr.grfonttxt(tvcount1);
                        gr.grfonttxt(tvvehicle);
                        gr.grfonttxt(tvtripdate);
                        gr.grfonttxt(tvfromdate);
                        gr.grfonttxt(tvtodate);
                        gr.grfonmul(multiAutoCompleteTextView);
                        gr.grfonmul(multiAutoCompleteTextView1);
                        gr.grfonmul(multiAutoCompleteTextView3);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,spinnertour)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        spvehicle.setAdapter(adapter0);
                        spvehicle.setOnItemSelectedListener(onItemSelectedListener0);
//                        myFont = Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
//                      minArrayAdapter ma = new minArrayAdapter(this);
////
//                        spvehicle.setAdapter(ma);
//                        spvehicle.setOnItemSelectedListener(this);
////
//                        spvehicle.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) ServicingActivity.this);
//                        ArrayAdapter aasp = new ArrayAdapter(ServicingActivity.this, android.R.layout.simple_spinner_item, spinnertour);
//                        aasp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spvehicle.setAdapter(aasp);
                        final TextView tvcount = (TextView) view.findViewById(R.id.tvcount);
                        final TextView tvcount1 = (TextView) view.findViewById(R.id.tvcount1);
                        final ImageView ivminus1 = (ImageView) view.findViewById(R.id.ivminus1);
                        final ImageView ivminus2 = (ImageView) view.findViewById(R.id.ivminus2);
                        final ImageView ivplus1 = (ImageView) view.findViewById(R.id.ivplus1);
                        final ImageView ivplus2 = (ImageView) view.findViewById(R.id.ivplus2);
                        tvfromdate = (TextView) view.findViewById(R.id.tvfromdate);
                        tvtodate = (TextView) view.findViewById(R.id.tvtodate);

                        mycalendar = Calendar.getInstance();
                        mycalendar1 = Calendar.getInstance();
                        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                  int dayOfMonth) {
                                // TODO Auto-generated method stub
                                mycalendar.set(Calendar.YEAR, year);
                                mycalendar.set(Calendar.MONTH, monthOfYear);
                                mycalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                updateLabel();
                            }

                            private void updateLabel() {
                                String myFormat = "MMMMMM dd,yyyy"; //In which you need put here
                                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                                tvfromdate.setText(sdf.format(mycalendar.getTime()));

                            }

                        };
                        final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                  int dayOfMonth) {
                                // TODO Auto-generated method stub

                                mycalendar1.set(Calendar.YEAR, year);
                                mycalendar1.set(Calendar.MONTH, monthOfYear);
                                mycalendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                updateLabel1();
                            }

                            private void updateLabel1() {
                                String myFormat = "MMMMMM dd,yyyy"; //In which you need put here
                                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);


                                tvtodate.setText(sdf.format(mycalendar1.getTime()));
                            }

                        };
                        tvfromdate.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                new DatePickerDialog(ServicingActivity.this, date, mycalendar
                                        .get(Calendar.YEAR), mycalendar.get(Calendar.MONTH),
                                        mycalendar.get(Calendar.DAY_OF_MONTH)).show();
                            }
                        });
                        tvtodate.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                new DatePickerDialog(ServicingActivity.this, date1, mycalendar1
                                        .get(Calendar.YEAR), mycalendar1.get(Calendar.MONTH),
                                        mycalendar1.get(Calendar.DAY_OF_MONTH)).show();
                            }
                        });
                        i=0;
                        ivplus1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i=i+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(i);
                                tvcount.setText(s);

                                ivminus1.setEnabled(true);
                            }
                        });
                        ivminus1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (i == 0) {
                                    ivminus1.setEnabled(false);
                                }else
                                    i=i-1;

                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(i);
                                tvcount.setText(s);

                            }
                        });
                        j=0;
                        ivplus2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                j=j+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(j);
                                tvcount1.setText(s);

                                ivminus2.setEnabled(true);
                            }
                        });
                        ivminus2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (j == 0) {
                                    ivminus2.setEnabled(false);
                                }else
                                j=j-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(j);
                                tvcount1.setText(s);

                            }
                        });

//
                        insertPoint.addView(view);
                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {
                        view = getLayoutInflater().inflate(R.layout.activity_tours_travels, null);

                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        insertPointing.setVisibility(view.GONE);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Tours and Traveler");
                        tvrequested.setText(" Requested for Tours and Traveler Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        spvehicle = (Spinner) view.findViewById(R.id.spvehicle);
                        rlvehicle = (RelativeLayout) view.findViewById(R.id.rlvehicle);
                        tvcompany = (TextView) view.findViewById(R.id.tvcompany);
                        tvlocation =(TextView) view.findViewById(R.id.tvlocation);
                        tvcompany=(TextView)view.findViewById(R.id.tvcompany);
                        multiAutoCompleteTextView3=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView3);
                        multiAutoCompleteTextView=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView);
                        multiAutoCompleteTextView1=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView1);
                        tvpeople=(TextView) view.findViewById(R.id.tvpeople);
                        tvone=(TextView) view.findViewById(R.id.tvone);
                        tvcount=(TextView) view.findViewById(R.id.tvcount);
                        tvchild=(TextView) view.findViewById(R.id.tvchild);
                        tvcount1=(TextView) view.findViewById(R.id.tvcount1);
                        tvvehicle=(TextView) view.findViewById(R.id.tvvehicle);
                        tvtripdate=(TextView) view.findViewById(R.id.tvtripdate);
                        tvfromdate=(TextView) view.findViewById(R.id.tvfromdate);
                        tvtodate=(TextView) view.findViewById(R.id.tvtodate);
                        multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view.findViewById(R.id.multiAutoCompleteTextView1);
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextView3.setHint(" Ex:Maheswari");
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        gr.grfonttxt(tvlocation);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvpeople);
                        gr.grfonttxt(tvone);
                        gr.grfonttxt(tvcount);
                        gr.grfonttxt(tvchild);
                        gr.grfonttxt(tvcount1);
                        gr.grfonttxt(tvvehicle);
                        gr.grfonttxt(tvtripdate);
                        gr.grfonttxt(tvfromdate);
                        gr.grfonttxt(tvtodate);
                        gr.grfonmul(multiAutoCompleteTextView);
                        gr.grfonmul(multiAutoCompleteTextView1);
                        gr.grfonmul(multiAutoCompleteTextView3);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,spinnertour)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        spvehicle.setAdapter(adapter0);
                        spvehicle.setOnItemSelectedListener(onItemSelectedListener0);
//                        myFont = Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
//                        minArrayAdapter ma = new minArrayAdapter(this);
////
//                        spvehicle.setAdapter(ma);
//                        spvehicle.setOnItemSelectedListener(this);
                        final TextView tvcount = (TextView) view.findViewById(R.id.tvcount);
                        final TextView tvcount1 = (TextView) view.findViewById(R.id.tvcount1);
                        final ImageView ivminus1 = (ImageView) view.findViewById(R.id.ivminus1);
                        final ImageView ivminus2 = (ImageView) view.findViewById(R.id.ivminus2);
                        final ImageView ivplus1 = (ImageView) view.findViewById(R.id.ivplus1);
                        final ImageView ivplus2 = (ImageView) view.findViewById(R.id.ivplus2);
                        tvfromdate = (TextView) view.findViewById(R.id.tvfromdate);
                        tvtodate = (TextView) view.findViewById(R.id.tvtodate);

                        mycalendar = Calendar.getInstance();
                        mycalendar1 = Calendar.getInstance();
                        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                  int dayOfMonth) {
                                // TODO Auto-generated method stub
                                mycalendar.set(Calendar.YEAR, year);
                                mycalendar.set(Calendar.MONTH, monthOfYear);
                                mycalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                updateLabel();
                            }

                            private void updateLabel() {
                                String myFormat = "MMMMMM dd,yyyy"; //In which you need put here
                                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                                tvfromdate.setText(sdf.format(mycalendar.getTime()));

                            }

                        };
                        final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                  int dayOfMonth) {
                                // TODO Auto-generated method stub

                                mycalendar1.set(Calendar.YEAR, year);
                                mycalendar1.set(Calendar.MONTH, monthOfYear);
                                mycalendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                updateLabel1();
                            }

                            private void updateLabel1() {
                                String myFormat = "MMMMMM dd,yyyy"; //In which you need put here
                                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);


                                tvtodate.setText(sdf.format(mycalendar1.getTime()));
                            }

                        };
                        tvfromdate.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                new DatePickerDialog(ServicingActivity.this, date, mycalendar
                                        .get(Calendar.YEAR), mycalendar.get(Calendar.MONTH),
                                        mycalendar.get(Calendar.DAY_OF_MONTH)).show();
                            }
                        });
                        tvtodate.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                new DatePickerDialog(ServicingActivity.this, date1, mycalendar1
                                        .get(Calendar.YEAR), mycalendar1.get(Calendar.MONTH),
                                        mycalendar1.get(Calendar.DAY_OF_MONTH)).show();
                            }
                        });
                        i=0;
                        ivplus1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i=i+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(i);
                                tvcount.setText(s);

                                ivminus1.setEnabled(true);
                            }
                        });
                        ivminus1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (i == 0) {
                                    ivminus1.setEnabled(false);
                                }else
                                i=i-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(i);
                                tvcount.setText(s);

                            }
                        });
                        j=0;
                        ivplus2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                j=j+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(j);
                                tvcount1.setText(s);

                                ivminus2.setEnabled(true);
                            }
                        });
                        ivminus2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (j == 0) {
                                    ivminus2.setEnabled(false);
                                }else
                                j=j-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(j);
                                tvcount1.setText(s);

                            }
                        });

//
                        insertPoint.addView(view);
                    }

                } else if (sertyp == 8) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {


                        gr.grfonttxt(tvselectmake);
                        insertPoints.setVisibility(view.VISIBLE);
//                tvselectmake.setText("Add to service");


                        //insertPointing.setVisibility(view.GONE);

                        tvselectmake.setText("Pest Control Services");
                        tvrequested.setText(" Requested for Pest Control Services");
                     tventer.setText("EX:Cockroach");

                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
//                gr.grfonttxt(tvprice);

                        //views.add(view);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {


//                tvselectmake.setText("Add to service");
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextViews.setText("Maheswari");
                        // tvname = (TextView) view1.findViewById(R.id.tvname);
                        //  insertPointing.setVisibility(view.GONE);

                        tvselectmake.setText("Pest Control Services");
                        tvrequested.setText(" Requested for Pest Control Services");
                        tventer.setText("EX:Cockroach");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);


//                gr.grfonttxt(tvprice);

                        //views.add(view);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });

                    }
                } else if (sertyp == 9) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {
                        view = getLayoutInflater().inflate(R.layout.realestate_sell, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        insertPoints.setVisibility(view.VISIBLE);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Real Estate");
                        tvrequested.setText(" Requested for Real Estate Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        insertPointing.setVisibility(view.GONE);
                        sprs1 = (Spinner) view.findViewById(R.id.sprs1);
                        sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                        sprs3 = (Spinner) view.findViewById(R.id.sprs3);
                        tvcompany = (TextView)view.findViewById(R.id.tvcompany);
                        edaddress = (EditText) view.findViewById(R.id.edaddress);
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);
                        tvwantrentcomm = (TextView) view.findViewById(R.id.tvwantrentcomm);
                        rlsppositonsells= (RelativeLayout) view.findViewById(R.id.rlsppositonsells);
                        rlrs3= (RelativeLayout) view.findViewById(R.id.rlrs3);
                        rlrs2= (RelativeLayout) view.findViewById(R.id.rlrs2);
                        rlrs4= (RelativeLayout) view.findViewById(R.id.rlrs4);
                        tvaddress = (TextView) view.findViewById(R.id.tvaddress);
                        tvlives = (TextView) view.findViewById(R.id.tvlives);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        tvfloors= (TextView) view.findViewById(R.id.tvfloors);
                        multiAutoCompleteTextView1=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView1);
                        gr.grfonttxt(tvaddress);
                        gr.grfonttxt(tvlives);
                        gr.grfonttxt(tvlive);
                        gr.grfonted(edaddress);
                        gr.grfonttxt(tvfloors);
                        gr.grfonmul(multiAutoCompleteTextView1);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvwantrentcomm);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,arch)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sppositonsell.setAdapter(adapter0);
                        sppositonsell.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview, spinnerrs2)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs1.setAdapter(adapter1);
                        sprs1.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter2 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs2.setAdapter(adapter2);
                        sprs2.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,floor)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs3.setAdapter(adapter3);
                        sprs3.setOnItemSelectedListener(onItemSelectedListener0);
//
                        insertPoint.addView(view);
                        //views.add(view);

                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {
                        view = getLayoutInflater().inflate(R.layout.realestate_sell, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        insertPointing.setVisibility(view.GONE);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Real Estate");
                        tvrequested.setText(" Requested for Real Estate Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        sprs1 = (Spinner) view.findViewById(R.id.sprs1);
                        tvcompany = (TextView) view.findViewById(R.id.tvcompany);
                        rlsppositonsells= (RelativeLayout) view.findViewById(R.id.rlsppositonsells);
                        rlrs3= (RelativeLayout) view.findViewById(R.id.rlrs3);
                        rlrs2= (RelativeLayout) view.findViewById(R.id.rlrs2);
                        rlrs4= (RelativeLayout) view.findViewById(R.id.rlrs4);
                        multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view.findViewById(R.id.multiAutoCompleteTextView1);
                        gr.grfonttxt(tvcompany);
                        gr.grfonmul(multiAutoCompleteTextView1);
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextView1.setHint(" EX:Maheswari");
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcompany = (TextView)view.findViewById(R.id.tvcompany);
                        edaddress = (EditText) view.findViewById(R.id.edaddress);
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);
                        tvwantrentcomm = (TextView) view.findViewById(R.id.tvwantrentcomm);
                        tvaddress = (TextView) view.findViewById(R.id.tvaddress);
                        tvlives = (TextView) view.findViewById(R.id.tvlives);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        tvfloors= (TextView) view.findViewById(R.id.tvfloors);
                        multiAutoCompleteTextView1=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView1);
                        gr.grfonttxt(tvaddress);
                        gr.grfonttxt(tvlives);
                        gr.grfonttxt(tvlive);
                        gr.grfonted(edaddress);
                        gr.grfonttxt(tvfloors);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvwantrentcomm);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                        sprs3 = (Spinner) view.findViewById(R.id.sprs3);
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);

                        ArrayAdapter<String> adapter0 =
                        new ArrayAdapter<String>(ServicingActivity.this,
                                R.layout.simple_spinner_item,R.id.textview,arch)
                        {

                            public View getView(int position, View convertView, ViewGroup parent) {
                                View v = super.getView(position, convertView, parent);

                                Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                ((TextView) v).setTypeface(externalFont);

                                return v;
                            }



                        };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sppositonsell.setAdapter(adapter0);
                        sppositonsell.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview, spinnerrs2)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs1.setAdapter(adapter1);
                        sprs1.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter2 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs2.setAdapter(adapter2);
                        sprs2.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,floor)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs3.setAdapter(adapter3);
                        sprs3.setOnItemSelectedListener(onItemSelectedListener0);
//
                        insertPoint.addView(view);
                        //views.add(view);

                    }
                } else if (sertyp == 10) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {
                        view = getLayoutInflater().inflate(R.layout.realestate_buy, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        insertPoints.setVisibility(view.VISIBLE);
                        sprs1 = (Spinner) view.findViewById(R.id.sprs1);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Real Estate");
                        tvrequested.setText(" Requested for Real Estate Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        tvcompany = (TextView)view.findViewById(R.id.tvcompany);
                        edaddress = (EditText) view.findViewById(R.id.edaddress);
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);
                        tvwantrentcomm = (TextView) view.findViewById(R.id.tvwantrentcomm);
                        tvaddress = (TextView) view.findViewById(R.id.tvaddress);
                        tvlives = (TextView) view.findViewById(R.id.tvlives);
                        rlsppositonsells= (RelativeLayout) view.findViewById(R.id.rlsppositonsells);
                        rlrs3= (RelativeLayout) view.findViewById(R.id.rlrs3);
                        rlrs4= (RelativeLayout) view.findViewById(R.id.rlrs4);
                        multiAutoCompleteTextView1=(MultiAutoCompleteTextView)view.findViewById(R.id.multiAutoCompleteTextView1);
                       tvlive = (TextView) view.findViewById(R.id.tvlive);
                        tvfloors= (TextView) view.findViewById(R.id.tvfloors);
                        gr.grfonttxt(tvaddress);
                        gr.grfonttxt(tvlives);
                     //  gr.grfonttxt(tvlive);
                        gr.grfonted(edaddress);
                        gr.grfonttxt(tvfloors);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvwantrentcomm);
                        gr.grfonmul(multiAutoCompleteTextView1);

                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        insertPointing.setVisibility(view.GONE);
                        sprs3 = (Spinner) view.findViewById(R.id.sprs3);
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);
                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,arch)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sppositonsell.setAdapter(adapter0);
                        sppositonsell.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview, budget)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs1.setAdapter(adapter1);
                        sprs1.setOnItemSelectedListener(onItemSelectedListener0);

                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,floor)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs3.setAdapter(adapter3);
                        sprs3.setOnItemSelectedListener(onItemSelectedListener0);
//
//
                        insertPoint.addView(view);
                        //views.add(view);

                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {
                        view = getLayoutInflater().inflate(R.layout.realestate_buy, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        insertPointing.setVisibility(view.GONE);
                        sprs1 = (Spinner) view.findViewById(R.id.sprs1);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Real Estate");
                        tvrequested.setText(" Requested for Real Estate Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        sprs3 = (Spinner) view.findViewById(R.id.sprs3);
                        tvcompany = (TextView) view.findViewById(R.id.tvcompany);
                        multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view.findViewById(R.id.multiAutoCompleteTextView1);
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextView1.setHint(" EX:Maheswari");
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcompany = (TextView)view.findViewById(R.id.tvcompany);
                        edaddress = (EditText) view.findViewById(R.id.edaddress);
                        tvwantrentcomm = (TextView) view.findViewById(R.id.tvwantrentcomm);
                        tvaddress = (TextView) view.findViewById(R.id.tvaddress);
                        tvlives = (TextView) view.findViewById(R.id.tvlives);
                        rlsppositonsells= (RelativeLayout) view.findViewById(R.id.rlsppositonsells);
                        rlrs3= (RelativeLayout) view.findViewById(R.id.rlrs3);
                        rlrs4= (RelativeLayout) view.findViewById(R.id.rlrs4);
//                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        tvfloors= (TextView) view.findViewById(R.id.tvfloors);
                        gr.grfonttxt(tvaddress);
                        gr.grfonttxt(tvlives);
//                        gr.grfonttxt(tvlive);
                        gr.grfonted(edaddress);
                        gr.grfonttxt(tvfloors);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvwantrentcomm);
                       gr.grfonmul( multiAutoCompleteTextView1);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);
                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,arch)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sppositonsell.setAdapter(adapter0);
                        sppositonsell.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview, budget)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs1.setAdapter(adapter1);
                        sprs1.setOnItemSelectedListener(onItemSelectedListener0);

                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,floor)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs3.setAdapter(adapter3);
                        sprs3.setOnItemSelectedListener(onItemSelectedListener0);
//
//

//
                        insertPoint.addView(view);
                        //views.add(view);

                    }
                } else if (sertyp == 11) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {
                        gr.grfonttxt(tvselectmake);
                        view = getLayoutInflater().inflate(R.layout.realestate_lease, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        rlsppositonsells= (RelativeLayout) view.findViewById(R.id.rlsppositonsells);
                        rlrs3= (RelativeLayout) view.findViewById(R.id.rlrs3);
                        rlrs2= (RelativeLayout) view.findViewById(R.id.rlrs2);
                        rlrs4= (RelativeLayout) view.findViewById(R.id.rlrs4);
                        insertPoints.setVisibility(view.VISIBLE);
                        insertPointing.setVisibility(view.GONE);
                        tvselectmake.setText("Real Estate");
                        tvrequested.setText(" Requested for Real Estate Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        tvconstructionbuy = (TextView) view.findViewById(R.id.tvconstructionbuy);
                        tvmovebuy = (TextView) view.findViewById(R.id.tvmovebuy);
                        tvquotation = (TextView) view.findViewById(R.id.tvquotation);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        sprs1 = (Spinner) view.findViewById(R.id.sprs1);
                        sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                        sprs3 = (Spinner) view.findViewById(R.id.sprs3);
                        tvcompany = (TextView)view.findViewById(R.id.tvcompany);
                        edaddress = (EditText) view.findViewById(R.id.edaddress);
                        tvwantrentcomm = (TextView) view.findViewById(R.id.tvwantrentcomm);
                        tvaddress = (TextView) view.findViewById(R.id.tvaddress);
                      //  tvlives = (TextView) view.findViewById(R.id.tvlives);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        tvfloors= (TextView) view.findViewById(R.id.tvfloors);
                        multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view.findViewById(R.id.multiAutoCompleteTextView1);
                        gr.grfonttxt(tvaddress);
                       // gr.grfonttxt(tvlives);
                        gr.grfonttxt(tvlive);
                        gr.grfonttxt(tvquotation);
                        gr.grfonttxt(tvconstructionbuy);
                        gr.grfonttxt(tvmovebuy);
                        gr.grfonted(edaddress);
                        gr.grfonttxt(tvfloors);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvwantrentcomm);
                        gr.grfonmul(multiAutoCompleteTextView1);

                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        tvmovebuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvlive.setText("Tell us your Budget:");
                               tvquotation.setVisibility(View.GONE);
                                budgflag=0;
                                //mclass.setBudgetflag(budgflag);
                                tvmovebuy.setBackgroundResource(R.drawable.withmaterial);
                                tvconstructionbuy.setBackgroundResource(R.drawable.withoutmaterial);
                                tvconstructionbuy.setTextColor(Color.parseColor("#048AAC"));
                                tvmovebuy.setTextColor(Color.parseColor("#ffffff"));
                                sprs1.setVisibility(View.GONE);
                            }
                        });
                        tvconstructionbuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvquotation.setText("Quotation:");
                                tvquotation.setVisibility(View.VISIBLE);
                                budgflag=1;
                                //mclass.setBudgetflag(budgflag);
                                tvconstructionbuy.setBackgroundResource(R.drawable.withmaterial);
                                tvmovebuy.setBackgroundResource(R.drawable.withoutmaterial);
                                tvconstructionbuy.setTextColor(Color.parseColor("#ffffff"));
                                tvmovebuy.setTextColor(Color.parseColor("#048AAC"));
                                sprs1.setVisibility(View.VISIBLE);
                            }
                        });
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);
                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,arch)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sppositonsell.setAdapter(adapter0);
                        sppositonsell.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview, spinnerrs2)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs1.setAdapter(adapter1);
                        sprs1.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter2 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs2.setAdapter(adapter2);
                        sprs2.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,year)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs3.setAdapter(adapter3);
                        sprs3.setOnItemSelectedListener(onItemSelectedListener0);
//
//
////
                        insertPoint.addView(view);
                        //views.add(view);


                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {
                        view = getLayoutInflater().inflate(R.layout.realestate_lease, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        insertPointing.setVisibility(view.GONE);
                        rlsppositonsells= (RelativeLayout) view.findViewById(R.id.rlsppositonsells);
                        rlrs3= (RelativeLayout) view.findViewById(R.id.rlrs3);
                        rlrs2= (RelativeLayout) view.findViewById(R.id.rlrs2);
                        rlrs4= (RelativeLayout) view.findViewById(R.id.rlrs4);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Real Estate");
                        tvrequested.setText(" Requested for Real Estate Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        tvconstructionbuy = (TextView) view.findViewById(R.id.tvconstructionbuy);
                        tvmovebuy = (TextView) view.findViewById(R.id.tvmovebuy);
                        tvquotation = (TextView) view.findViewById(R.id.tvquotation);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        sprs1 = (Spinner) view.findViewById(R.id.sprs1);
                        tvcompany = (TextView) view.findViewById(R.id.tvcompany);
                        multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view.findViewById(R.id.multiAutoCompleteTextView1);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextView1.setHint(" Ex:Maheswari");
                        sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                        sprs3 = (Spinner) view.findViewById(R.id.sprs3);
                        tvcompany = (TextView)view.findViewById(R.id.tvcompany);
                        edaddress = (EditText) view.findViewById(R.id.edaddress);
                        tvwantrentcomm = (TextView) view.findViewById(R.id.tvwantrentcomm);
                        tvaddress = (TextView) view.findViewById(R.id.tvaddress);
                        //  tvlives = (TextView) view.findViewById(R.id.tvlives);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        tvfloors= (TextView) view.findViewById(R.id.tvfloors);
                        gr.grfonttxt(tvaddress);
                        // gr.grfonttxt(tvlives);
                        gr.grfonttxt(tvlive);
                        gr.grfonttxt(tvquotation);
                        gr.grfonttxt(tvconstructionbuy);
                        gr.grfonttxt(tvmovebuy);
                        gr.grfonted(edaddress);
                        gr.grfonttxt(tvfloors);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvwantrentcomm);

                        tvmovebuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvlive.setText("Tell us your Budget:");
                                tvquotation.setVisibility(View.GONE);
                                budgflag=0;
                                tvmovebuy.setBackgroundResource(R.drawable.withmaterial);
                                tvconstructionbuy.setBackgroundResource(R.drawable.withoutmaterial);
                                tvconstructionbuy.setTextColor(Color.parseColor("#048AAC"));
                                tvmovebuy.setTextColor(Color.parseColor("#ffffff"));
                                sprs1.setVisibility(View.GONE);
                            }
                        });
                        tvconstructionbuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvquotation.setText("Quotation:");
                                tvquotation.setVisibility(View.VISIBLE);
                                budgflag=1;

                                tvconstructionbuy.setBackgroundResource(R.drawable.withmaterial);
                                tvmovebuy.setBackgroundResource(R.drawable.withoutmaterial);
                                tvconstructionbuy.setTextColor(Color.parseColor("#ffffff"));
                                tvmovebuy.setTextColor(Color.parseColor("#048AAC"));
                                sprs1.setVisibility(View.VISIBLE);
                            }
                        });
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);
                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,arch)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sppositonsell.setAdapter(adapter0);
                        sppositonsell.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview, spinnerrs2)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs1.setAdapter(adapter1);
                        sprs1.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter2 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs2.setAdapter(adapter2);
                        sprs2.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,year)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs3.setAdapter(adapter3);
                        sprs3.setOnItemSelectedListener(onItemSelectedListener0);
//
//
                        insertPoint.addView(view);
                        //views.add(view);

                    }
                } else if (sertyp == 12) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {
                        view = getLayoutInflater().inflate(R.layout.realestate_lease, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        rlsppositonsells= (RelativeLayout) view.findViewById(R.id.rlsppositonsells);
                        rlrs3= (RelativeLayout) view.findViewById(R.id.rlrs3);
                        rlrs2= (RelativeLayout) view.findViewById(R.id.rlrs2);
                        rlrs4= (RelativeLayout) view.findViewById(R.id.rlrs4);
                        insertPoints.setVisibility(view.VISIBLE);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Real Estate");
                        tvrequested.setText(" Requested for Real Estate Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                         insertPointing.setVisibility(view.GONE);
                        tvconstructionbuy = (TextView) view.findViewById(R.id.tvconstructionbuy);
                        multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view.findViewById(R.id.multiAutoCompleteTextView1);
                        tvconstructionbuy.setText("Rent your Property");
                        tvmovebuy = (TextView) view.findViewById(R.id.tvmovebuy);
                        tvmovebuy.setText("Looking for Rent");
                        tvquotation = (TextView) view.findViewById(R.id.tvquotation);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        sprs1 = (Spinner) view.findViewById(R.id.sprs1);
                        sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                        sprs3 = (Spinner) view.findViewById(R.id.sprs3);
                        tvcompany = (TextView)view.findViewById(R.id.tvcompany);
                        edaddress = (EditText) view.findViewById(R.id.edaddress);
                        tvwantrentcomm = (TextView) view.findViewById(R.id.tvwantrentcomm);
                        tvaddress = (TextView) view.findViewById(R.id.tvaddress);
                        //  tvlives = (TextView) view.findViewById(R.id.tvlives);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        tvfloors= (TextView) view.findViewById(R.id.tvfloors);
                        gr.grfonttxt(tvaddress);
                        // gr.grfonttxt(tvlives);
                        gr.grfonttxt(tvlive);
                        gr.grfonttxt(tvquotation);
                        gr.grfonttxt(tvconstructionbuy);
                        gr.grfonttxt(tvmovebuy);
                        gr.grfonted(edaddress);
                        gr.grfonttxt(tvfloors);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvwantrentcomm);

                        tvmovebuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvlive.setText("Tell us your Budget:");
                                tvquotation.setVisibility(View.GONE);
                                budgflag=0;
                                tvmovebuy.setBackgroundResource(R.drawable.withmaterial);
                                tvconstructionbuy.setBackgroundResource(R.drawable.withoutmaterial);
                                tvconstructionbuy.setTextColor(Color.parseColor("#048AAC"));
                                tvmovebuy.setTextColor(Color.parseColor("#ffffff"));
                                sprs1.setVisibility(View.GONE);
                            }
                        });
                        tvconstructionbuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvquotation.setText("Quotation:");
                                tvquotation.setVisibility(View.VISIBLE);
                                budgflag=1;

                                tvconstructionbuy.setBackgroundResource(R.drawable.withmaterial);
                                tvmovebuy.setBackgroundResource(R.drawable.withoutmaterial);
                                tvconstructionbuy.setTextColor(Color.parseColor("#ffffff"));
                                tvmovebuy.setTextColor(Color.parseColor("#048AAC"));
                                sprs1.setVisibility(View.VISIBLE);
                            }
                        });
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);

                        ArrayAdapter<String> adapter0 =
                        new ArrayAdapter<String>(ServicingActivity.this,
                                R.layout.simple_spinner_item,R.id.textview,arch)
                        {

                            public View getView(int position, View convertView, ViewGroup parent) {
                                View v = super.getView(position, convertView, parent);

                                Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                ((TextView) v).setTypeface(externalFont);

                                return v;
                            }



                        };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sppositonsell.setAdapter(adapter0);
                        sppositonsell.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview, spinnerrs2)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs1.setAdapter(adapter1);
                        sprs1.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter2 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs2.setAdapter(adapter2);
                        sprs2.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,year)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs3.setAdapter(adapter3);
                        sprs3.setOnItemSelectedListener(onItemSelectedListener0);
//
//
                        insertPoint.addView(view);
                        //views.add(view);

                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {
                        view = getLayoutInflater().inflate(R.layout.realestate_lease, null);
                        insertPoints = (LinearLayout) view.findViewById(R.id.contacts_type);
                        insertPointing.setVisibility(view.GONE);
                        tvconstructionbuy = (TextView) view.findViewById(R.id.tvconstructionbuy);
                        rlsppositonsells= (RelativeLayout) view.findViewById(R.id.rlsppositonsells);
                        rlrs3= (RelativeLayout) view.findViewById(R.id.rlrs3);
                        rlrs2= (RelativeLayout) view.findViewById(R.id.rlrs2);
                        rlrs4= (RelativeLayout) view.findViewById(R.id.rlrs4);
                        tvmovebuy = (TextView) view.findViewById(R.id.tvmovebuy);
                        tvconstructionbuy.setText("Rent your Property");
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Real Estate");
                        tvrequested.setText(" Requested for Real Estate Services");
                        etselectmakes.setVisibility(View.GONE);
                        tventer.setVisibility(View.GONE);
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        tvmovebuy.setText("Looking for Rent");
                        tvquotation = (TextView) view.findViewById(R.id.tvquotation);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        sprs1 = (Spinner) view.findViewById(R.id.sprs1);
                        sprs2 = (Spinner) view.findViewById(R.id.sprs2);
                        sprs3 = (Spinner) view.findViewById(R.id.sprs3);
                        tvcompany = (TextView) view.findViewById(R.id.tvcompany);
                        multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view.findViewById(R.id.multiAutoCompleteTextView1);
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextView1.setHint(" Ex:Maheswari");
                        tvcompany = (TextView)view.findViewById(R.id.tvcompany);
                        edaddress = (EditText) view.findViewById(R.id.edaddress);
                        tvwantrentcomm = (TextView) view.findViewById(R.id.tvwantrentcomm);
                        tvaddress = (TextView) view.findViewById(R.id.tvaddress);
                        //  tvlives = (TextView) view.findViewById(R.id.tvlives);
                        tvlive = (TextView) view.findViewById(R.id.tvlive);
                        tvfloors= (TextView) view.findViewById(R.id.tvfloors);
                        gr.grfonttxt(tvaddress);
                        // gr.grfonttxt(tvlives);
                        gr.grfonttxt(tvlive);
                        gr.grfonttxt(tvquotation);
                        gr.grfonttxt(tvconstructionbuy);
                        gr.grfonttxt(tvmovebuy);
                        gr.grfonted(edaddress);
                        gr.grfonttxt(tvfloors);
                        gr.grfonttxt(tvcompany);
                        gr.grfonttxt(tvwantrentcomm);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        tvmovebuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvlive.setText("Tell us your Budget:");
                                tvquotation.setVisibility(View.GONE);
                                budgflag=0;
                                tvmovebuy.setBackgroundResource(R.drawable.withmaterial);
                                tvconstructionbuy.setBackgroundResource(R.drawable.withoutmaterial);
                                tvconstructionbuy.setTextColor(Color.parseColor("#048AAC"));
                                tvmovebuy.setTextColor(Color.parseColor("#ffffff"));
                                sprs1.setVisibility(View.GONE);
                            }
                        });
                        tvconstructionbuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvquotation.setText("Quotation:");
                                tvquotation.setVisibility(View.VISIBLE);
                                budgflag=1;


                                tvconstructionbuy.setBackgroundResource(R.drawable.withmaterial);
                                tvmovebuy.setBackgroundResource(R.drawable.withoutmaterial);
                                tvconstructionbuy.setTextColor(Color.parseColor("#ffffff"));
                                tvmovebuy.setTextColor(Color.parseColor("#048AAC"));
                                sprs1.setVisibility(View.VISIBLE);
                            }
                        });
                        sppositonsell = (Spinner) view.findViewById(R.id.sppositonsells);
                        ArrayAdapter<String> adapter0 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,arch)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sppositonsell.setAdapter(adapter0);
                        sppositonsell.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter1 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview, spinnerrs2)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs1.setAdapter(adapter1);
                        sprs1.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter2 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,spinnerrs1)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs2.setAdapter(adapter2);
                        sprs2.setOnItemSelectedListener(onItemSelectedListener0);
                        ArrayAdapter<String> adapter3 =
                                new ArrayAdapter<String>(ServicingActivity.this,
                                        R.layout.simple_spinner_item,R.id.textview,year)
                                {

                                    public View getView(int position, View convertView, ViewGroup parent) {
                                        View v = super.getView(position, convertView, parent);

                                        Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                        ((TextView) v).setTypeface(externalFont);

                                        return v;
                                    }



                                };


                        // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        sprs3.setAdapter(adapter3);
                        sprs3.setOnItemSelectedListener(onItemSelectedListener0);
//
//
                        insertPoint.addView(view);
                        //views.add(view);
                       
                    }

                } else if (sertyp == 13) {

                    if (catvalue.equalsIgnoreCase("Male")) {
                         insertPointing.setVisibility(view.GONE);
                        View view = layoutInflator.inflate(R.layout.item_securitygaurd_skill, null);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Skill Manpower Services");
                        tventer.setVisibility(view.GONE);
                        tvrequested.setText("Requested for Skill Manpower Services");
                        etselectmakes.setVisibility(view.GONE);
                        tvduty=(TextView)view.findViewById(R.id.tvduty);
                        tvqty=(TextView)view.findViewById(R.id.tvqty);
                        tvfour=(TextView)view.findViewById(R.id.tvfour);
                        tvcount1=(TextView)view.findViewById(R.id.tvcount1);
                        tveight=(TextView)view.findViewById(R.id.tveight);
                        tvcount2=(TextView)view.findViewById(R.id.tvcount2);
                        tvfive=(TextView)view.findViewById(R.id.tvfive);
                        tvcount3=(TextView)view.findViewById(R.id.tvcount3);
                        tvintime=(TextView)view.findViewById(R.id.tvintime);
                        tvouttime=(TextView)view.findViewById(R.id.tvouttime);
                        tvsericetype=(TextView)view.findViewById(R.id.tvsericetype);
                        radioButton=(RadioButton) view.findViewById(R.id.radioButton);
                        radioButton2=(RadioButton) view.findViewById(R.id.radioButton2);
                        radioButton3=(RadioButton) view.findViewById(R.id.radioButton3);
                        tvweekoff=(TextView)view.findViewById(R.id.tvweekoff);
                        radiog= (RadioGroup) view.findViewById(R.id.radioGroup);
                        tvcount4=(TextView)view.findViewById(R.id.tvcount4);
                        int id= radiog.getCheckedRadioButtonId();
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tvselectmake);
                        gr.grfonttxt(tvduty);
                        gr.grfonttxt(tvqty);
                        gr.grfonttxt(tvfour);
                        gr.grfonttxt(tvcount1);
                        gr.grfonttxt(tveight);
                        gr.grfonttxt(tvcount2);
                        gr.grfonttxt(tvfive);
                        gr.grfonttxt(tvcount3);
                        gr.grfonttxt(tvintime);
                        gr.grfonttxt(tvouttime);
                        gr.grfonttxt(tvweekoff);
                        gr.grfonttxt(tvcount4);
                        gr.grfonttxt(tvsericetype);
                        gr.grfontra(radioButton);
                        gr.grfontra(radioButton2);
                        gr.grfontra(radioButton3);

                        gr.grfonttxt(tventer);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Male");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        // tvselectmake.setText("Add to repair");
//                tvone = (TextView) view.findViewById(R.id.tvone);
//                tvtwo = (TextView) view.findViewById(R.id.tvtwo);
//                tvthree = (TextView) view.findViewById(R.id.tvthree);

//                gr.grfonttxt(tvone);
                        intime = (TextView) view.findViewById(R.id.tvintime);
                        tvouttime = (TextView) view.findViewById(R.id.tvouttime);
                        tvfour = (TextView) view.findViewById(R.id.tvfour);
                        tveight = (TextView) view.findViewById(R.id.tveight);
                        tvfive = (TextView) view.findViewById(R.id.tvfive);
                        tvcount1 = (TextView) view.findViewById(R.id.tvcount1);
                        tvcount2 = (TextView) view.findViewById(R.id.tvcount2);
                        tvcount3 = (TextView) view.findViewById(R.id.tvcount3);
                        tvcount4 = (TextView) view.findViewById(R.id.tvcount4);
                        ivminus1 = (ImageView) view.findViewById(R.id.ivminus1);
                        ivminus2 = (ImageView) view.findViewById(R.id.ivminus2);
                        ivminus3 = (ImageView) view.findViewById(R.id.ivminus3);
                        ivminus4 = (ImageView) view.findViewById(R.id.ivminus4);
                        ivplus4 = (ImageView) view.findViewById(R.id.ivplus4);
                        ivplusone = (ImageView) view.findViewById(R.id.ivplusone);
                        ivplus2 = (ImageView) view.findViewById(R.id.ivplus2);
                        ivplus3 = (ImageView) view.findViewById(R.id.ivplus3);

                       n=0;
                        ivplus4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                         n=n+1;

                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(n);
                                tvcount4.setText(s);

                               ivminus4.setEnabled(true);
                            }
                        });
                        ivminus4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (n == 0) {
                                    ivminus4.setEnabled(false);
                                }else
                                n=n-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(n);
                                tvcount4.setText(s);

                            }
                        });
                        tvintime.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                builder = new AlertDialog.Builder(ServicingActivity.this);

                                View vw = getLayoutInflater().inflate(R.layout.datepicker, null);
                                timePicker = (TimePicker) vw.findViewById(R.id.timePicker);
                                set_button = (Button) vw.findViewById(R.id.set_button);
                                set_button.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {

                                        final String s1=setTime(set_button,tvintime);
                                        alertDialog.dismiss();
                                        if(timeslot==null){
                                            Toast.makeText(ServicingActivity.this,
                                                    "Please Select Hrs and then select Intime", Toast.LENGTH_LONG).show();
                                            /*Snackbar.make(v, "Please Select Hrs and then select Intime", Snackbar.LENGTH_LONG)
                                                    .setAction("Action", null).show();*/}
                                        else{

                                            tvintime.setText(s1);
                                            int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                            int pertime=selhrs+value;
                                            int permin=selmin+0;
                                            String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                            tvouttime.setText(fvalue);
                                        }

                                    }

                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();

                            }
                        });
                        ivplusone.setEnabled(false);
                        ivminus1.setEnabled(false);
                        ivplus2.setEnabled(false);
                        ivminus2.setEnabled(false);
                        tvfour.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          tvfour.setPadding(0, 10, 0, 10);
                                                          tveight.setPadding(0, 10, 0, 10);
                                                          tvfive.setPadding(0, 10, 0, 10);
                                                          mclass.setDuty(tvfour.getText().toString());
                                                          mclass.setQty(tvcount1.getText().toString());
                                                          if(timeslot!=null) {
                                                              timeslot=tvfour.getText().toString();
                                                              int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                                              int pertime=selhrs+value;
                                                              int permin=selmin+0;
                                                              String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                                              tvcount2.setText("00");
                                                              tvcount3.setText("00");
                                                              tvouttime.setText(fvalue);
                                                          }else {
                                                              timeslot = tvfour.getText().toString();
                                                          }
                                                          tvfour.setTextColor(Color.parseColor("#ffffff"));
                                                          tvfour.setBackgroundResource(R.drawable.myborderbuildingblue);
                                                          tveight.setBackgroundResource(R.drawable.myborderbuilding);
                                                          tvfive.setBackgroundResource(R.drawable.myborderbuilding);
                                                          tvfive.setTextColor(Color.parseColor("#727272"));

                                                          tveight.setTextColor(Color.parseColor("#727272"));
                                                          ivplusone.setEnabled(true);
                                                          ivminus1.setEnabled(true);
                                                          i = 0;
                                                      }
                                                  });
                                ivplusone.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        i=i+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(i);
                                        tvcount1.setText(s);

                                        ivminus1.setEnabled(true);
                                    }
                                });
                                ivminus1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (i == 0) {
                                            ivminus1.setEnabled(false);
                                        }else
                                        i=i-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(i);
                                        tvcount1.setText(s);

                                    }
                                });

                        tveight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tveight.setPadding(0, 10, 0, 10);
                                tvfour.setPadding(0, 10, 0, 10);
                                tvfive.setPadding(0, 10, 0, 10);
                                if(timeslot!=null) {
                                    timeslot=tveight.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvouttime.setText(fvalue);
                                    tvcount1.setText("00");
                                    tvcount3.setText("00");
                                }
                                else {
                                    timeslot = tveight.getText().toString();
                                }
                                mclass.setDuty(tveight.getText().toString());
                                mclass.setQty(tvcount2.getText().toString());
                                tveight.setTextColor(Color.parseColor("#ffffff"));
                                tveight.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tvfour.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setTextColor(Color.parseColor("#727272"));
                                tvfour.setTextColor(Color.parseColor("#727272"));
                                ivplus2.setEnabled(true);
                                ivminus2.setEnabled(true);
                                k=0;
                                ivplus2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        k=k+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(k);
                                        tvcount2.setText(s);

                                        ivminus2.setEnabled(true);
                                    }
                                });
                                ivminus2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (k == 0) {
                                            ivminus2.setEnabled(false);
                                        }else
                                        k=k-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(k);
                                        tvcount2.setText(s);

                                    }
                                });

                            }
                        });
                        tvfive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvfive.setPadding(0, 10, 0, 10);
                                tvfour.setPadding(0, 10, 0, 10);
                                tveight.setPadding(0, 10, 0, 10);
                                if(timeslot!=null) {
                                    timeslot=tvfive.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvouttime.setText(fvalue);
                                    tvcount2.setText("00");
                                    tvcount1.setText("00");
                                }else {
                                    timeslot = tvfive.getText().toString();
                                }
                                mclass.setDuty(tvfive.getText().toString());
                                mclass.setQty(tvcount3.getText().toString());
                                tvfive.setTextColor(Color.parseColor("#ffffff"));
                                tvfive.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tvfour.setBackgroundResource(R.drawable.myborderbuilding);
                                tveight.setBackgroundResource(R.drawable.myborderbuilding);
                                tveight.setTextColor(Color.parseColor("#727272"));
                                tvfour.setTextColor(Color.parseColor("#727272"));
                                ivplus3.setEnabled(true);
                                ivminus3.setEnabled(true);
                                l=0;
                                ivplus3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        l=l+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(l);
                                        tvcount3.setText(s);

                                        ivminus3.setEnabled(true);
                                    }
                                });
                                ivminus3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (l == 0) {
                                            ivminus3.setEnabled(false);
                                        }else
                                        l=l-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(l);
                                        tvcount3.setText(s);

                                    }
                                });

                            }
                        });
                        insertPoint.addView(view);


                    } else if (catvalue.equalsIgnoreCase("Female")) {

                        View view = layoutInflator.inflate(R.layout.item_securitygaurd_skill, null);
                        gr.grfonttxt(tvselectmake);
                        tvselectmake.setText("Skill Manpower Services");
                        tventer.setVisibility(view.GONE);
                        tvrequested.setText("Requested for Skill Manpower Services");
                        etselectmakes.setVisibility(view.GONE);
                        tvduty=(TextView)view.findViewById(R.id.tvduty);
                        tvqty=(TextView)view.findViewById(R.id.tvqty);
                        tvfour=(TextView)view.findViewById(R.id.tvfour);
                        tvcount1=(TextView)view.findViewById(R.id.tvcount1);
                        tveight=(TextView)view.findViewById(R.id.tveight);
                        tvcount2=(TextView)view.findViewById(R.id.tvcount2);
                        tvfive=(TextView)view.findViewById(R.id.tvfive);
                        tvcount3=(TextView)view.findViewById(R.id.tvcount3);
                        tvintime=(TextView)view.findViewById(R.id.tvintime);
                        tvouttime=(TextView)view.findViewById(R.id.tvouttime);
                        tvsericetype=(TextView)view.findViewById(R.id.tvsericetype);
                        radioButton=(RadioButton) view.findViewById(R.id.radioButton);
                        radioButton2=(RadioButton) view.findViewById(R.id.radioButton2);
                        radioButton3=(RadioButton) view.findViewById(R.id.radioButton3);
                        tvweekoff=(TextView)view.findViewById(R.id.tvweekoff);
                        radiog= (RadioGroup) view.findViewById(R.id.radioGroup);
                        tvcount4=(TextView)view.findViewById(R.id.tvcount4);
                        int id= radiog.getCheckedRadioButtonId();
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tvselectmake);
                        gr.grfonttxt(tvduty);
                        gr.grfonttxt(tvqty);
                        gr.grfonttxt(tvfour);
                        gr.grfonttxt(tvcount1);
                        gr.grfonttxt(tveight);
                        gr.grfonttxt(tvcount2);
                        gr.grfonttxt(tvfive);
                        gr.grfonttxt(tvcount3);
                        gr.grfonttxt(tvintime);
                        gr.grfonttxt(tvouttime);
                        gr.grfonttxt(tvweekoff);
                        gr.grfonttxt(tvcount4);
                        gr.grfonttxt(tvsericetype);
                        gr.grfontra(radioButton);
                        gr.grfontra(radioButton2);
                        gr.grfontra(radioButton3);

                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tvselectmake);

                        gr.grfonttxt(tventer);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Female");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                        insertPointing.setVisibility(view.GONE);
                        // tvselectmake.setText("Add to repair");
//                tvone = (TextView) view.findViewById(R.id.tvone);
//                tvtwo = (TextView) view.findViewById(R.id.tvtwo);
//                tvthree = (TextView) view.findViewById(R.id.tvthree);

//                gr.grfonttxt(tvone);
                        intime = (TextView) view.findViewById(R.id.tvintime);
                        tvouttime = (TextView) view.findViewById(R.id.tvouttime);
                        tvfour = (TextView) view.findViewById(R.id.tvfour);
                        tveight = (TextView) view.findViewById(R.id.tveight);
                        tvfive = (TextView) view.findViewById(R.id.tvfive);
                        tvcount1 = (TextView) view.findViewById(R.id.tvcount1);
                        tvcount2 = (TextView) view.findViewById(R.id.tvcount2);
                        tvcount3 = (TextView) view.findViewById(R.id.tvcount3);
                        tvcount4 = (TextView) view.findViewById(R.id.tvcount4);
                        ivminus1 = (ImageView) view.findViewById(R.id.ivminus1);
                        ivminus2 = (ImageView) view.findViewById(R.id.ivminus2);
                        ivminus3 = (ImageView) view.findViewById(R.id.ivminus3);
                        ivminus4 = (ImageView) view.findViewById(R.id.ivminus4);
                        ivplus4 = (ImageView) view.findViewById(R.id.ivplus4);
                        ivplusone = (ImageView) view.findViewById(R.id.ivplusone);
                        ivplus2 = (ImageView) view.findViewById(R.id.ivplus2);
                        ivplus3 = (ImageView) view.findViewById(R.id.ivplus3);
                        n=0;
                        ivplus4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                               n=n+1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(n);
                                tvcount4.setText(s);

                              ivminus4.setEnabled(true);
                            }
                        });
                        ivminus4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (n == 0) {
                                    ivminus4.setEnabled(false);
                                }else
                                n=n-1;
                                DecimalFormat formatter = new DecimalFormat("00");
                                String s = formatter.format(n);
                                tvcount4.setText(s);

                            }
                        });
                        tvintime.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                builder = new AlertDialog.Builder(ServicingActivity.this);

                                View vw = getLayoutInflater().inflate(R.layout.datepicker, null);
                                timePicker = (TimePicker) vw.findViewById(R.id.timePicker);
                                set_button = (Button) vw.findViewById(R.id.set_button);
                                set_button.setOnClickListener(new View.OnClickListener() {


                                    @Override
                                    public void onClick(View v) {

                                        final String s1=setTime(set_button,tvintime);
                                        alertDialog.dismiss();
                                        if(timeslot==null){
                                            Toast.makeText(ServicingActivity.this,
                                                    "Please Select Hrs and then select Intime", Toast.LENGTH_LONG).show();
                                            /*Snackbar.make(v, "Please Select Hrs and then select Intime", Snackbar.LENGTH_LONG)
                                                    .setAction("Action", null).show();*/}
                                        else{

                                            tvintime.setText(s1);
                                            int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                            int pertime=selhrs+value;
                                            int permin=selmin+0;
                                            String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                            tvouttime.setText(fvalue);
                                        }

                                    }

                                });
                                builder.setView(vw);
                                alertDialog = builder.create();
                                alertDialog.show();

                            }
                        });
                        ivplusone.setEnabled(false);
                        ivminus1.setEnabled(false);
                        ivplus2.setEnabled(false);
                        ivminus2.setEnabled(false);
                        tvfour.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvfour.setPadding(0, 10, 0, 10);
                                tveight.setPadding(0, 10, 0, 10);
                                tvfive.setPadding(0, 10, 0, 10);
                                mclass.setDuty(tvfour.getText().toString());
                                mclass.setQty(tvcount1.getText().toString());
                                if(timeslot!=null) {
                                    timeslot=tvfour.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvcount2.setText("00");
                                    tvcount3.setText("00");
                                    tvouttime.setText(fvalue);
                                }else {
                                    timeslot = tvfour.getText().toString();
                                }
                                tvfour.setTextColor(Color.parseColor("#ffffff"));
                                tvfour.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tveight.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setTextColor(Color.parseColor("#727272"));
                                tveight.setTextColor(Color.parseColor("#727272"));
                                ivplusone.setEnabled(true);
                                ivminus1.setEnabled(true);
                                i = 0;
                                ivplusone.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        i=i+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(i);
                                        tvcount1.setText(s);

                                        ivminus1.setEnabled(true);
                                    }
                                });
                                ivminus1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (i == 0) {
                                            ivminus1.setEnabled(false);
                                        }else
                                        i=i-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(i);
                                        tvcount1.setText(s);

                                    }
                                });

                            }
                        });
                        tveight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tveight.setPadding(0, 10, 0, 10);
                                tvfour.setPadding(0, 10, 0, 10);
                                tvfive.setPadding(0, 10, 0, 10);
                                mclass.setDuty(tveight.getText().toString());
                                mclass.setQty(tvcount1.getText().toString());
                                if(timeslot!=null) {
                                    timeslot=tveight.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvouttime.setText(fvalue);
                                    tvcount1.setText("00");
                                    tvcount3.setText("00");
                                }
                                else {
                                    timeslot = tveight.getText().toString();
                                }
                                tveight.setTextColor(Color.parseColor("#ffffff"));
                                tveight.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tvfour.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setBackgroundResource(R.drawable.myborderbuilding);
                                tvfive.setTextColor(Color.parseColor("#727272"));
                                tvfour.setTextColor(Color.parseColor("#727272"));
                                ivplus2.setEnabled(true);
                                ivminus2.setEnabled(true);
                                k=0;
                                ivplus2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        k=k+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(k);
                                        tvcount2.setText(s);

                                        ivminus2.setEnabled(true);
                                    }
                                });
                                ivminus2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (k == 0) {
                                            ivminus2.setEnabled(false);
                                        }  else
                                        k=k-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(k);
                                        tvcount2.setText(s);

                                    }
                                });

                            }
                        });
                        tvfive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tvfive.setPadding(0, 10, 0, 10);
                                tvfour.setPadding(0, 10, 0, 10);
                                tveight.setPadding(0, 10, 0, 10);
                                mclass.setDuty(tvfive.getText().toString());
                                mclass.setQty(tvcount1.getText().toString());
                                if(timeslot!=null) {
                                    timeslot=tvfive.getText().toString();
                                    int value = Integer.parseInt(timeslot.replaceAll("[^0-9]", ""));
                                    int pertime=selhrs+value;
                                    int permin=selmin+0;
                                    String fvalue=String.valueOf(changetime(pertime,permin,tvouttime));
                                    tvouttime.setText(fvalue);
                                    tvcount2.setText("00");
                                    tvcount1.setText("00");
                                }else {
                                    timeslot = tvfive.getText().toString();
                                }
                                tvfive.setTextColor(Color.parseColor("#ffffff"));
                                tvfive.setBackgroundResource(R.drawable.myborderbuildingblue);
                                tvfour.setBackgroundResource(R.drawable.myborderbuilding);
                                tveight.setBackgroundResource(R.drawable.myborderbuilding);
                                tveight.setTextColor(Color.parseColor("#727272"));
                                tvfour.setTextColor(Color.parseColor("#727272"));
                                ivplus3.setEnabled(true);
                                ivminus3.setEnabled(true);
                                l=0;
                                ivplus3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        l=l+1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(l);
                                        tvcount3.setText(s);

                                        ivminus3.setEnabled(true);
                                    }
                                });
                                ivminus3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (l == 0) {
                                            ivminus3.setEnabled(false);
                                        }else
                                        l=l-1;
                                        DecimalFormat formatter = new DecimalFormat("00");
                                        String s = formatter.format(l);
                                        tvcount3.setText(s);

                                    }
                                });

                            }
                        });
                        insertPoint.addView(view);

                    }

                    tvselectmake.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (count == 1) {


                                linearLayout.setVisibility(View.VISIBLE);
                                tvselectmake.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.substract, 0);
                                count++;
                            } else {
                                count = 0;


                                linearLayout.setVisibility(View.GONE);
                                tvselectmake.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.plus, 0);
                                count++;


                            }
                        }
                    });
                }else if (sertyp == 14) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {


//                tvselectmake.setText("Add to service");

                        gr.grfonttxt(tvselectmake);
                        insertPoints.setVisibility(View.VISIBLE);

                        tvselectmakes.setVisibility(view.GONE);

//                        insertPointing.setVisibility(view.GONE);
                        //tvselectmake.setVisibility(View.GONE);
                         tvselectmake.setText("Housekeeping Materials Supplier");
                        tvrequested.setText(" Requested for Housekeeping Materials");

                        tventer.setText("EX: Tissue Papers ");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
//                gr.grfonttxt(tvprice);

                        //views.add(view);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this, MainActivity12.class);

                                startActivity(intent);
                            }
                        });

                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {


                        gr.grfonttxt(tvselectmake);
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextViews.setText("Maheswari");
                        tvselectmakes.setVisibility(view.GONE);

                        // insertPointing.setVisibility(view.GONE);
//tvselectmake.setVisibility(view.GONE);
                        tvselectmake.setText("Housekeeping Materials Supplier");

                        tvrequested.setText(" Requested for Housekeeping Materials");

                        tventer.setText("EX:Tissue Papers");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
//                gr.grfonttxt(tvprice);

                        //views.add(view);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this, MainActivity12.class);

                                startActivity(intent);
                            }
                        });


                    }
                }else if (sertyp == 15) {
                    if (catvalue.equalsIgnoreCase("Commerical")) {


//                tvselectmake.setText("Add to service");

                        gr.grfonttxt(tvselectmake);
                        insertPoints.setVisibility(View.VISIBLE);

                        tvselectmakes.setVisibility(view.GONE);

//                        insertPointing.setVisibility(view.GONE);
                        //tvselectmake.setVisibility(View.GONE);
                        tvselectmake.setText("Stationary Materials Supplier");
                        tvrequested.setText(" Requested for Stationary Materials");

                        tventer.setText("EX:Pens ");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
//                gr.grfonttxt(tvprice);

                        //views.add(view);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this, MainActivity12.class);

                                startActivity(intent);
                            }
                        });

                    }
                    if (catvalue.equalsIgnoreCase("Residential")) {


                        gr.grfonttxt(tvselectmake);
                        insertPoints.setVisibility(view.VISIBLE);
                        tvcompany.setText("Name of the Person:");
                        multiAutoCompleteTextViews.setText("Maheswari");
                        tvselectmakes.setVisibility(view.GONE);

                        // insertPointing.setVisibility(view.GONE);
//tvselectmake.setVisibility(view.GONE);
                        tvselectmake.setText("Stationary Materials Supplier");

                        tvrequested.setText(" Requested for Stationary Materialss");

                        tventer.setText("EX:pens");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
//                gr.grfonttxt(tvprice);

                        //views.add(view);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this, MainActivity12.class);

                                startActivity(intent);
                            }
                        });


                    }
                }
            } else if (pos == 5) {
                if (sertyp == 0) {

                    if (catvalue.equalsIgnoreCase("Commerical")) {
                        tvrequested.setText("Requested for Commerical Service");
                        tvselectmake.setText("Work Contractor");
                        tventer.setText("EX:Flooring contractor");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                    } else if (catvalue.equalsIgnoreCase("Residential")) {
                        tvselectmake.setText("Work Contractor");
                        tvrequested.setText("Requested for Residential Service");
                        tventer.setText("EX:Flooring contractor");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                    }

                }
                if (sertyp == 1) {

                    if (catvalue.equalsIgnoreCase("Commerical")) {
                        tvrequested.setText("Requested for Commerical Service");
                        tvselectmake.setText("Supplier");
                        tventer.setText("EX:Plumbing  Supplier");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Commerical");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this, MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                    } else if (catvalue.equalsIgnoreCase("Residential")) {
                        tvselectmake.setText("Supplier");
                        tvrequested.setText("Requested for Residential Service");
                        tventer.setText("EX:Plumbing  Supplier");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial = (TextView) mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Residential");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this, MainActivity12.class);

                                startActivity(intent);
                            }
                        });
                    }

                }

            } else if (pos == 6) {
                if (sertyp == 0) {

                    if (catvalue.equalsIgnoreCase("schedule  appointment  in salon")) {
                        tvrequested.setText(" appointment in salon");
                        tvselectmake.setText("Male");
                        tventer.setText("EX:Beard Trim");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Male");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });

                    } else if (catvalue.equalsIgnoreCase("Book  appointment in home")) {
                        tvrequested.setText(" appointment in home");
                        tvselectmake.setText("Male");
                        tventer.setText("EX:Beard Trim");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Male");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });


                    }

                }
                if (sertyp == 1) {

                    if (catvalue.equalsIgnoreCase("schedule  appointment  in parlour")) {
                        tvrequested.setText("appointment in parlour");
                        tvselectmake.setText("Female");
                        tventer.setText("EX:Bridal Makeup");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Female");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });

                    } else if (catvalue.equalsIgnoreCase("Book  appointment in home")) {
                        tvrequested.setText(" appointment in home");
                        tvselectmake.setText("Female");
                        tventer.setText("EX:Bridal Makeup");
                        gr.grfonttxt(tvrequested);
                        gr.grfonttxt(tventer);
                        gr.grfonttxt(tvselectmake);
                        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                        getSupportActionBar().setCustomView(mActionBarView);
                        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                        getSupportActionBar().setElevation(0);
                        tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                        gr.grfonttxt(tvcommercial);
                        tvcommercial.setText("Female");
                        ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                        ivactionmenu.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                                startActivity(intent);
                            }
                        });

                    }

                }

            } else if (pos == 7) {
                if (sertyp == 0) {
                    View view1 = layoutInflator.inflate(R.layout.events, null);
//                tvselectmake.setText("Add to service");
                    //insertPointing.setVisibility(view.GONE);
                    gr.grfonttxt(tvselectmake);
                    tvselectmake.setText("Function Hall");
                    tvrequested.setText("Requested for Events Function Hall");
                    tventer.setVisibility(view.GONE);
                    etselectmakes.setVisibility(view.GONE);
                    tvselectareas = (TextView) view1.findViewById(R.id.tvselectareas);
                    relativespinnerfloors = (RelativeLayout) view1.findViewById(R.id.relativespinnerfloors);
                    tvarea = (TextView) view1.findViewById(R.id.tvarea);
                    multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view1.findViewById(R.id.multiAutoCompleteTextView1);
                    gr.grfonttxt(tvselectareas);
                    gr.grfonmul(multiAutoCompleteTextView1);
                    gr.grfonttxt(tvarea);
                    spvehicle = (Spinner) view1.findViewById(R.id.spvehicle);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    gr.grfonttxt(tvselectmake);
//                    radiog= (RadioGroup) view1.findViewById(R.id.radioGrp);
//                    int id= radiog.getCheckedRadioButtonId();
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Function Hall");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                    ArrayAdapter<String> adapter0 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,guest)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spvehicle.setAdapter(adapter0);
                    spvehicle.setOnItemSelectedListener(onItemSelectedListener0);
//                    myFont = Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
//                    volArrayAdapter ma1 = new volArrayAdapter(this);
////
//                    spvehicle.setAdapter(ma1);
//                    spvehicle.setOnItemSelectedListener(this);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);
//                    spvehicle.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) ServicingActivity.this);
//                    ArrayAdapter aasp = new ArrayAdapter(ServicingActivity.this, android.R.layout.simple_spinner_item, spinnervol);
//                    aasp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spvehicle.setAdapter(aasp);
////
//                gr.grfonttxt(tvprice);
                    insertPoint.addView(view1);



                } else if (sertyp == 1) {
                    tvselectmake.setText("Decoration");
                    tvrequested.setText("Requested for Events Decoration");
                    tventer.setVisibility(view.GONE);
                    etselectmakes.setVisibility(view.GONE);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    gr.grfonttxt(tvselectmake);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Decoration");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });

                } else if (sertyp == 2) {
                    View view1 = layoutInflator.inflate(R.layout.caterring, null);
//                tvselectmake.setText("Add to service");

                    gr.grfonttxt(tvselectmake);
                    tvfood = (TextView) view1.findViewById(R.id.tvfood);
                    tvselectareas = (TextView) view1.findViewById(R.id.tvselectareas);
                    tvarea = (TextView) view1.findViewById(R.id.tvarea);
                    radioM=(RadioButton) view1.findViewById(R.id.radioM);
                    radioF=(RadioButton) view1.findViewById(R.id.radioF);
                    radiog= (RadioGroup) view1.findViewById(R.id.radioGrp);
                    int id= radiog.getCheckedRadioButtonId();
                    relativespinnerfloors = (RelativeLayout) view1.findViewById(R.id.relativespinnerfloors);
                    multiAutoCompleteTextView1 = (MultiAutoCompleteTextView) view1.findViewById(R.id.multiAutoCompleteTextView1);
                    gr.grfonttxt(tvselectareas);
                    gr.grfonttxt(tvarea);
                    gr.grfontra(radioM);
                    gr.grfontra(radioF);
                    gr.grfonmul(multiAutoCompleteTextView1);
                    gr.grfonttxt(tvfood);
                    spvehicle = (Spinner) view1.findViewById(R.id.spvehicle);
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Catering");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
                    tvselectmake.setText("Catering Services");
                    tvrequested.setText("Requested for Events Catering Services");
                    tventer.setVisibility(view.GONE);
                    etselectmakes.setVisibility(view.GONE);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    gr.grfonttxt(tvselectmake);
                    ArrayAdapter<String> adapter0 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,guest)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    spvehicle.setAdapter(adapter0);
                    spvehicle.setOnItemSelectedListener(onItemSelectedListener0);
//            sprs2 = (Spinner) view.findViewById(R.id.sprs2);
//                    myFont = Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
//                    volArrayAdapter ma1 = new volArrayAdapter(this);
////
//                    spvehicle.setAdapter(ma1);
//                    spvehicle.setOnItemSelectedListener(this);
//
//                gr.grfonttxt(tvprice);
                    insertPoint.addView(view1);



                }
            } else if (pos == 8) {
                if (sertyp == 0) {
                    View view1 = layoutInflator.inflate(R.layout.loans, null);
//                tvselectmake.setText("Add to service");
                    //insertPointing.setVisibility(view.GONE);
                    gr.grfonttxt(tvselectmake);
                    rlrs1=(RelativeLayout)view1. findViewById(R.id.rlrs1);
                    tvbudget = (TextView) view1.findViewById(R.id.tvbudget);

                    gr.grfonttxt(tvbudget);

                    sprs1 = (Spinner) view1.findViewById(R.id.sprs1);

                    tvselectmake.setText("Financial Services");
                    tvrequested.setText("Requested for Loan Services");
                    tventer.setVisibility(view.GONE);
                    etselectmakes.setVisibility(view.GONE);
                    gr.grfonttxt(tvrequested);
                    gr.grfonttxt(tventer);
                    gr.grfonttxt(tvselectmake);
                    ArrayAdapter<String> adapter0 =
                            new ArrayAdapter<String>(ServicingActivity.this,
                                    R.layout.simple_spinner_item,R.id.textview,budget)
                            {

                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);

                                    Typeface externalFont=Typeface.createFromAsset(getAssets(), "Kontrapunkt-Bold.otf");
                                    ((TextView) v).setTypeface(externalFont);

                                    return v;
                                }



                            };


                    // adapter0.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    sprs1.setAdapter(adapter0);
                    sprs1.setOnItemSelectedListener(onItemSelectedListener0);
//
                    View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarservicing, null);
                    getSupportActionBar().setCustomView(mActionBarView);
                    getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
                    getSupportActionBar().setElevation(0);
                    tvcommercial=(TextView)mActionBarView.findViewById(R.id.tvcommercial);
                    gr.grfonttxt(tvcommercial);
                    tvcommercial.setText("Financial");
                    ivactionmenu = (ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
                    ivactionmenu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ServicingActivity.this,MainActivity12.class);

                            startActivity(intent);
                        }
                    });
//                gr.grfonttxt(tvprice);
                    insertPoint.addView(view1);


                }

            }


        // CustomAdapter adapter = new CustomAdapter(this, modelItems);
        //  lv.setAdapter(adapter);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }



    private class MyArrayAdapter extends BaseAdapter  {

        private LayoutInflater mInflater;

        public MyArrayAdapter(ServicingActivity con) {
            // TODO Auto-generated constructor stub
            mInflater = LayoutInflater.from(con);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return spinnermove.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            final ListContent holder;
            View v = convertView;
            if (v == null) {
                v = mInflater.inflate(R.layout.my_spinner_style, null);
                holder = new ListContent();

                holder.name = (TextView) v.findViewById(R.id.tvspinner);

                v.setTag(holder);
            } else {

                holder = (ListContent) v.getTag();
            }

            holder.name.setTypeface(myFont);
            holder.name.setText("" + spinnermove[position]);

            return v;
        }

    }
    public static class ListContent {

        TextView name;

    }
    private class MyArrayAdapters extends BaseAdapter {

        private LayoutInflater mInflater;
        String[] n1=new String[100];
        public MyArrayAdapters(ServicingActivity con,String[] items) {
            // TODO Auto-generated constructor stub
            mInflater = LayoutInflater.from(con);
            n1=items;
        }


        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return spinnerrs2.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            final ListContent holder;
            View v = convertView;
            if (v == null) {
                v = mInflater.inflate(R.layout.my_spinner_style, null);
                holder = new ListContent();

                holder.name = (TextView) v.findViewById(R.id.tvspinner);

                v.setTag(holder);
            } else {

                holder = (ListContent) v.getTag();
            }

            holder.name.setTypeface(myFont);
            holder.name.setText("" + n1[position]);
            ///holder.name.setText("" + floors[position]);
            return v;
        }

    }
    private class MyArraysAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public MyArraysAdapter(ServicingActivity con) {
            // TODO Auto-generated constructor stub
            mInflater = LayoutInflater.from(con);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return positionscommerical.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            final ListContent holder;
            View v = convertView;
            if (v == null) {
                v = mInflater.inflate(R.layout.my_spinner_style, null);
                holder = new ListContent();

                holder.name = (TextView) v.findViewById(R.id.tvspinner);

                v.setTag(holder);
            } else {

                holder = (ListContent) v.getTag();
            }

            holder.name.setTypeface(myFont);
            holder.name.setText("" + positionscommerical[position]);

            return v;
        }

    }
    private class ArraysAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public ArraysAdapter(ServicingActivity con) {
            // TODO Auto-generated constructor stub
            mInflater = LayoutInflater.from(con);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return budget.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            final ListContent holder;
            View v = convertView;
            if (v == null) {
                v = mInflater.inflate(R.layout.my_spinner_style, null);
                holder = new ListContent();

                holder.name = (TextView) v.findViewById(R.id.tvspinner);

                v.setTag(holder);
            } else {

                holder = (ListContent) v.getTag();
            }

            holder.name.setTypeface(myFont);
            holder.name.setText("" + budget[position]);

            return v;
        }

    }
    private class mArrayAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public mArrayAdapter(ServicingActivity con) {
            // TODO Auto-generated constructor stub
            mInflater = LayoutInflater.from(con);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return year.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            final ListContent holder;
            View v = convertView;
            if (v == null) {
                v = mInflater.inflate(R.layout.my_spinner_style, null);
                holder = new ListContent();

                holder.name = (TextView) v.findViewById(R.id.tvspinner);

                v.setTag(holder);
            } else {

                holder = (ListContent) v.getTag();
            }

            holder.name.setTypeface(myFont);
            holder.name.setText("" +year[position]);

            return v;
        }

    }
    private class minArrayAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public minArrayAdapter(ServicingActivity con) {
            // TODO Auto-generated constructor stub
            mInflater = LayoutInflater.from(con);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return spinnertour.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            final ListContent holder;
            View v = convertView;
            if (v == null) {
                v = mInflater.inflate(R.layout.my_spinner_style, null);
                holder = new ListContent();

                holder.name = (TextView) v.findViewById(R.id.tvspinner);

                v.setTag(holder);
            } else {

                holder = (ListContent) v.getTag();
            }

            holder.name.setTypeface(myFont);
            holder.name.setText("" +spinnertour[position]);

            return v;
        }

    }



    public String setTime(View view,TextView vw) {
        int hour = timePicker.getCurrentHour();
        int min = timePicker.getCurrentMinute();
        String value=String.valueOf(showTime(hour, min,vw));
        return value;
    }

    public StringBuilder showTime(int hour, final int min, final TextView v1) {
//        int hr=hour;
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }
        final int finalHour = hour;
        selhrs=finalHour;
        selmin=min;

         return new StringBuilder().append(finalHour).append(" : ").append(min)
         .append(" ").append(format);

      ///  tvouttime.setText(new StringBuilder().append(hour).append(" : ").append(min)
              //  .append(" ").append(format));




    }
    public StringBuilder changetime(int hour, final int min, final TextView v1) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }
        final int hours = hour;


        return new StringBuilder().append(hours).append(" : ").append(min)
                .append(" ").append(format);

        ///  tvouttime.setText(new StringBuilder().append(hour).append(" : ").append(min)
        //  .append(" ").append(format));




    }


    private void changeView(int positon) {
        if (positon == 0) {
            Intent intent = new Intent(ServicingActivity.this, ArticleActivity.class);
            startActivity(intent);
        }

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Servicing Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    AdapterView.OnItemSelectedListener onItemSelectedListener0 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position,  long id ) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }

    public void servicetype(String[] nam) {


    }

}