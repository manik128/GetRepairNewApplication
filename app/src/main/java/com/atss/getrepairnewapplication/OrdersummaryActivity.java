package com.atss.getrepairnewapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atss.getrepairnewapplication.SchedulePage.SchedulePageActivity;

import java.util.ArrayList;
import java.util.List;

public class OrdersummaryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
int budgflag;
    EditText etcode;
    Button button,buttons;
    TextView tvterm,tvdate,tvnumber,tvcontact,tvname,tvuser,tvmobile,tvaddress,tvuseraddress,tvselectmake,textView,tvlegendName,legendBorn,tvprice,tvbrand,tvtimes,tvdates,tvsize,tvarea,tvsqft,tvnumbers,tvfloor,tvtell,tvbudget,tvintime,tvtime1,tvouttime,tvtime2,tvservice,tvtype,tvweekoff,tvweek,tvfurinture1,tvelectrical1,tvvechicle1,tvveg,tvnonveg;
    ListView lv;
    LinearLayout ll;
    ImageView edit,imagerupee,ivactionmenu;
    Mainclass mclass;
    LayoutInflater linf;
    RelativeLayout rr;
    LinearLayout llContent;
    Context context;
    int pos,sertyp;
    String[] name = {"Basic Inspection","Basic Inspection2","Basic Inspection3"};
    String[] born = {"Basic Inspection"};
    String[] price = {"SERVICE"};

    private int NoOfTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordersummary);
        mclass=(Mainclass) getApplicationContext();
        Intent intent = getIntent();
          sertyp= mclass.getSertyp();
       // sertyp = intent.getIntExtra("sertyp", 0);
        View mActionBarView = getLayoutInflater().inflate(R.layout.actionbarsummary, null);
        getSupportActionBar().setCustomView(mActionBarView);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setElevation(0);
        ivactionmenu=(ImageView) mActionBarView.findViewById(R.id.ivactionmenu);
        ivactionmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrdersummaryActivity.this, SchedulePageActivity.class);

                startActivity(intent);
            }
        });
        tvterm = (TextView) findViewById(R.id.tvterm);
        tvdate = (TextView) findViewById(R.id.tvdate);

        tvcontact = (TextView) findViewById(R.id.tvcontact);
        tvname = (TextView) findViewById(R.id.tvname);
        tvuser = (TextView) findViewById(R.id.tvuser);
        textView = (TextView) findViewById(R.id.textView);
        tvmobile = (TextView) findViewById(R.id.tvmobile);
        tvnumber = (TextView) findViewById(R.id.tvnumber);
        tvselectmake = (TextView) findViewById(R.id.tvselectmake);
        tvaddress = (TextView) findViewById(R.id.tvaddress);
        tvtimes = (TextView) findViewById(R.id.tvtimes);
        tvdates = (TextView) findViewById(R.id.tvdates);
        buttons = (Button) findViewById(R.id.buttons);
        tvuseraddress = (TextView) findViewById(R.id.tvuseraddress);


        textView.setText(R.string.your_string);
        pos=mclass.getPosition();
        grfont gr = new grfont(OrdersummaryActivity.this);
        gr.grfonttxt(tvdate);

        gr.grfonttxt(tvcontact);
        gr.grfonttxt(tvuser);
        gr.grfonttxt(tvmobile);
        gr.grfonttxt(tvnumber);
        gr.grfonttxt(tvselectmake);
        gr.grfonttxt(tvuseraddress);
        gr.grfonttxt(tvtimes);
        gr.grfonttxt(tvdates);
        gr.grfontlgttxt(tvterm);
        gr.grfontlgttxt(textView);


        gr.grfontlgttxt(tvmobile);
        gr.grfontlgttxt(tvaddress);

        gr.grfontbut(buttons);

        LayoutInflater layoutInflator = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout insertPoint = (LinearLayout) findViewById(R.id.rlselectmake);
        List views = new ArrayList();
        if (pos == 0) {

            View view = layoutInflator.inflate(R.layout.itemorders, null);

            tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
            legendBorn = (TextView) view.findViewById(R.id.legendBorn);
            tvbrand = (TextView) view.findViewById(R.id.tvbrand);
            tvprice = (TextView) view.findViewById(R.id.tvprice);
            tvlegendName.setText(mclass.getissue());
            legendBorn.setText(mclass.getType());
            tvbrand.setText(mclass.getModel());
            tvprice.setText(mclass.getService());
            //tvprice.setText(mclass.getRepair());
            tvselectmake.setText(mclass.getCategory());
            tvnumber.setText(mclass.getMobilenumber());
            tvuser.setText(mclass.getName());
            tvtimes.setText(mclass.getTime());
            tvdates.setText(mclass.getDate());
            tvuseraddress.setText(mclass.getLocadd());
//

            gr.grfonttxt(tvlegendName);
            gr.grfonttxt(legendBorn);
            gr.grfonttxt(tvprice);
            gr.grfonttxt(tvbrand);
            insertPoint.addView(view);
            //views.add(view);

        } else if (pos == 1) {

                View view = layoutInflator.inflate(R.layout.itemordersbuilding, null);

                // tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvsize = (TextView) view.findViewById(R.id.tvsize);
                tvarea = (TextView) view.findViewById(R.id.tvarea);
                tvsqft = (TextView) view.findViewById(R.id.tvsqft);
                tvnumbers = (TextView) view.findViewById(R.id.tvnumbers);
                tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                tvtell = (TextView) view.findViewById(R.id.tvtell);
                tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                tvprice = (TextView) view.findViewById(R.id.tvprice);

                //tvlegendName.setText(mclass.getissue());
            if (sertyp == 0) {
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getSize());
                tvsqft.setText(mclass.getSqft());
                tvfloor.setText(mclass.getFloor());

                tvbudget.setText(mclass.getBudget());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
//
            }else  if(sertyp==1){
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getSize());
                tvsqft.setText(mclass.getSqft());
                tvfloor.setText(mclass.getFloor());
                tvnumbers.setVisibility(view.GONE);
                tvbudget.setText(mclass.getBudget());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
            }else  if(sertyp==2){
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getSize());
                tvsqft.setText(mclass.getSqft());
                tvfloor.setText(mclass.getFloor());
                tvnumbers.setVisibility(view.GONE);
                tvbudget.setText(mclass.getBudget());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
            }
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                gr.grfonttxt(tvsize);
                gr.grfonttxt(tvarea);
                gr.grfonttxt(tvsqft);
                gr.grfonttxt(tvnumbers);
                gr.grfonttxt(tvfloor);
                gr.grfonttxt(tvtell);
                gr.grfonttxt(tvbudget);
                insertPoint.addView(view);

                //  gr.grfonttxt(tvlegendName);

                //views.add(view);

        }else if(pos==2){
            View view = layoutInflator.inflate(R.layout.itemorders, null);

            tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
            legendBorn = (TextView) view.findViewById(R.id.legendBorn);
            tvbrand = (TextView) view.findViewById(R.id.tvbrand);
            tvprice = (TextView) view.findViewById(R.id.tvprice);
            tvlegendName.setText(mclass.getissue());
            legendBorn.setText(mclass.getType());
            tvbrand.setText(mclass.getModel());
            tvprice.setText(mclass.getService());
            //tvprice.setText(mclass.getRepair());
            tvselectmake.setText(mclass.getCategory());
            tvnumber.setText(mclass.getMobilenumber());
            tvuser.setText(mclass.getName());
            tvtimes.setText(mclass.getTime());
            tvdates.setText(mclass.getDate());
            tvuseraddress.setText(mclass.getLocadd());
//

            gr.grfonttxt(tvlegendName);
            gr.grfonttxt(legendBorn);
            gr.grfonttxt(tvprice);
            gr.grfonttxt(tvbrand);
            insertPoint.addView(view);
        }else if(pos==3){

            //tvlegendName.setText(mclass.getissue());
            if (sertyp == 0) {
                View view = layoutInflator.inflate(R.layout.itemordershouse, null);

                // tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvsize = (TextView) view.findViewById(R.id.tvsize);
                tvarea = (TextView) view.findViewById(R.id.tvarea);
                //  tvsqft = (TextView) view.findViewById(R.id.tvsqft);
                tvnumbers = (TextView) view.findViewById(R.id.tvnumbers);
                tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                tvtell = (TextView) view.findViewById(R.id.tvtell);
                tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvintime = (TextView) view.findViewById(R.id.tvintime);
                tvouttime = (TextView) view.findViewById(R.id.tvouttime);
                tvtime1 = (TextView) view.findViewById(R.id.tvtime1);
                tvtime2= (TextView) view.findViewById(R.id.tvtime2);
                tvservice = (TextView) view.findViewById(R.id.tvservice);
                tvtype= (TextView) view.findViewById(R.id.tvtype);
                tvweekoff = (TextView) view.findViewById(R.id.tvweekoff);
                tvweek = (TextView) view.findViewById(R.id.tvweek);
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getGender());
//                tvsqft.setText(mclass.getSqft());
                tvfloor.setText(mclass.getDuty());
                tvtype.setText(mclass.getChoose());
                tvweek.setText(mclass.getWeekoff());
                tvbudget.setText(mclass.getQty());
                tvtime1.setText(mclass.getIntime());
                tvtime2.setText(mclass.getOuttime());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                gr.grfonttxt(tvsize);
                gr.grfonttxt(tvarea);
                //gr.grfonttxt(tvsqft);
                gr.grfonttxt(tvnumbers);
                gr.grfonttxt(tvfloor);
                gr.grfonttxt(tvtell);
                gr.grfonttxt(tvbudget);
                insertPoint.addView(view);
            }else  if(sertyp==3) {
                View view = layoutInflator.inflate(R.layout.itemorders, null);

                tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvlegendName.setText(mclass.getissue());
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
//

                gr.grfonttxt(tvlegendName);
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);
            }else  if(sertyp==4){
                    View view = layoutInflator.inflate(R.layout.itemorders, null);

                    tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                    legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                    tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                    tvprice = (TextView) view.findViewById(R.id.tvprice);
                    tvlegendName.setText(mclass.getissue());
                    legendBorn.setText(mclass.getType());
                    tvbrand.setText(mclass.getModel());
                    tvprice.setText(mclass.getService());
                    //tvprice.setText(mclass.getRepair());
                    tvselectmake.setText(mclass.getCategory());
                    tvnumber.setText(mclass.getMobilenumber());
                    tvuser.setText(mclass.getName());
                    tvtimes.setText(mclass.getTime());
                    tvdates.setText(mclass.getDate());
                    tvuseraddress.setText(mclass.getLocadd());
//

                    gr.grfonttxt(tvlegendName);
                    gr.grfonttxt(legendBorn);
                    gr.grfonttxt(tvprice);
                    gr.grfonttxt(tvbrand);
                    insertPoint.addView(view);
            }else  if(sertyp==5){
                View view = layoutInflator.inflate(R.layout.itemorders, null);

                tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvlegendName.setText(mclass.getissue());
                legendBorn.setText(mclass.getType());
               // tvbrand.setText(mclass.getModel());
                tvbrand.setText(mclass.getService());
                tvprice.setVisibility(view.GONE);
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
//
                gr.grfonttxt(tvlegendName);
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);
//
            }else  if(sertyp==6){
                View view = layoutInflator.inflate(R.layout.itemordersmove, null);

                tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvarea = (TextView) view.findViewById(R.id.tvarea);
                tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                tvbudget= (TextView) view.findViewById(R.id.tvbudget);
                tvtime1 = (TextView) view.findViewById(R.id.tvtime1);
                tvtime2 = (TextView) view.findViewById(R.id.tvtime2);
                tvtype = (TextView) view.findViewById(R.id.tvtype);
                tvweek = (TextView) view.findViewById(R.id.tvweek);
                tvfurinture1 = (TextView) view.findViewById(R.id.tvfurinture1);
                tvelectrical1= (TextView) view.findViewById(R.id.tvelectrical1);
                tvvechicle1 = (TextView) view.findViewById(R.id.tvvechicle1);
               // tvlegendName.setText(mclass.getissue());
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getCompany());
                tvfloor.setText(mclass.getCurrently());
                tvbudget.setText(mclass.getServicelift());
                tvtime1.setText(mclass.getmove());
                tvtime2.setText(mclass.getYes());
                tvtype.setText(mclass.getFrom());
                tvweek.setText(mclass.getTo());
                tvfurinture1.setText(mclass.getFurnitureqty());
                tvelectrical1.setText(mclass.getElectricalqty());
                tvvechicle1.setText(mclass.getVehicleqty());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
//
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);
            }else  if(sertyp==7) {
                View view = layoutInflator.inflate(R.layout.itemorderstour, null);

                tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvarea = (TextView) view.findViewById(R.id.tvarea);
                tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                tvtime1 = (TextView) view.findViewById(R.id.tvtime1);
                tvtime2 = (TextView) view.findViewById(R.id.tvtime2);
                tvtype = (TextView) view.findViewById(R.id.tvtype);
                tvweek = (TextView) view.findViewById(R.id.tvweek);
                tvfurinture1 = (TextView) view.findViewById(R.id.tvfurinture1);

                // tvlegendName.setText(mclass.getissue());
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getCompany());
               tvfloor.setText(mclass.getFrom());
                tvbudget.setText(mclass.getTo());
                tvtime1.setText(mclass.getAdult());
                tvtime2.setText(mclass.getchild());
                tvtype.setText(mclass.getVechicle());
                tvweek.setText(mclass.getTripfrom());
                tvfurinture1.setText(mclass.getTripto());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
//
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);

            } else  if(sertyp==8) {
                View view = layoutInflator.inflate(R.layout.itemorders, null);

                tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvlegendName.setText(mclass.getissue());
                legendBorn.setText(mclass.getType());
                // tvbrand.setText(mclass.getModel());
                tvbrand.setText(mclass.getService());
                tvprice.setVisibility(view.GONE);
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
//
//

                gr.grfonttxt(tvlegendName);
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);
            }
            else  if(sertyp==9){
                View view = layoutInflator.inflate(R.layout.itemorderssell, null);

                tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvarea = (TextView) view.findViewById(R.id.tvarea);
                tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                tvbudget= (TextView) view.findViewById(R.id.tvbudget);
                tvtime1 = (TextView) view.findViewById(R.id.tvtime1);
                tvtime2 = (TextView) view.findViewById(R.id.tvtime2);
                tvtype = (TextView) view.findViewById(R.id.tvtype);


                // tvlegendName.setText(mclass.getissue());
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getCompany());
                tvfloor.setText(mclass.getBuliding());
                tvbudget.setText(mclass.getAdd());
                tvtime1.setText(mclass.getQuotation());
                tvtime2.setText(mclass.getNegotiation());
                tvtype.setText(mclass.getFloor());

                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
//
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);
            }

            else  if(sertyp==10){
                View view = layoutInflator.inflate(R.layout.itemordersbuy, null);

                tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvarea = (TextView) view.findViewById(R.id.tvarea);
                tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                tvbudget= (TextView) view.findViewById(R.id.tvbudget);
                tvtime1 = (TextView) view.findViewById(R.id.tvtime1);
                tvtime2 = (TextView) view.findViewById(R.id.tvtime2);


                // tvlegendName.setText(mclass.getissue());
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getCompany());
                tvfloor.setText(mclass.getBuliding());
                tvbudget.setText(mclass.getAdd());
                tvtime1.setText(mclass.getBudget());
                tvtime2.setText(mclass.getFloor());

                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
//
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);
            }
            else {
                if (sertyp == 11) {
                    View view = layoutInflator.inflate(R.layout.itemorderssell, null);

                    tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                    legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                    tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                    tvprice = (TextView) view.findViewById(R.id.tvprice);
                    tvarea = (TextView) view.findViewById(R.id.tvarea);
                    tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                    tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                   tvintime = (TextView) view.findViewById(R.id.tvintime);
                    tvouttime = (TextView) view.findViewById(R.id.tvouttime);
                    tvservice = (TextView) view.findViewById(R.id.tvservice);
                    tvtime1 = (TextView) view.findViewById(R.id.tvtime1);
                    tvtime2 = (TextView) view.findViewById(R.id.tvtime2);
                    tvtype = (TextView) view.findViewById(R.id.tvtype);
                    budgflag=mclass.getBudgetflag();
                    if (budgflag== 1) {
                        legendBorn.setText(mclass.getType());
                        tvbrand.setText(mclass.getModel());
                        tvprice.setText(mclass.getService());
                        tvarea.setText(mclass.getCompany());
                        tvfloor.setText(mclass.getBuliding());
                        tvbudget.setText(mclass.getAdd());
                        tvtime1.setText(mclass.getQuotation());
                        tvtime2.setText(mclass.getNegotiation());
                        tvtype.setText(mclass.getYear());
                    tvservice.setText("No of years         :");
                    }else  if (budgflag==0){
                        legendBorn.setText(mclass.getType());
                        tvbrand.setText(mclass.getModel());
                        tvprice.setText(mclass.getService());
                        tvarea.setText(mclass.getCompany());
                        tvfloor.setText(mclass.getBuliding());
                        tvbudget.setText(mclass.getAdd());
                        tvintime.setText("Budget                   :");
                        tvtime1.setText(mclass.getNegotiation());
                        tvouttime.setText("No of years              :");
                        tvtime2.setText(mclass.getYear());
                        tvservice.setVisibility(view.GONE);
                        tvtype.setVisibility(view.GONE);


                    }
                    // tvlegendName.setText(mclass.getissue());
//                    legendBorn.setText(mclass.getType());
//                    tvbrand.setText(mclass.getModel());
//                    tvprice.setText(mclass.getService());
//                    tvarea.setText(mclass.getCompany());
//                    tvfloor.setText(mclass.getBuliding());
//                    tvbudget.setText(mclass.getAdd());
//                    tvtime1.setText(mclass.getQuotation());
//                    tvtime2.setText(mclass.getNegotiation());
//                    tvtype.setText(mclass.getFloor());

                    //tvprice.setText(mclass.getRepair());
                    tvselectmake.setText(mclass.getCategory());
                    tvnumber.setText(mclass.getMobilenumber());
                    tvuser.setText(mclass.getName());
                    tvtimes.setText(mclass.getTime());
                    tvdates.setText(mclass.getDate());
                    tvuseraddress.setText(mclass.getLocadd());
//          );
                    gr.grfonttxt(legendBorn);
                    gr.grfonttxt(tvprice);
                    gr.grfonttxt(tvbrand);
                    insertPoint.addView(view);
                } else if (sertyp == 12) {
                        View view = layoutInflator.inflate(R.layout.itemorderssell, null);

                        tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                        legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                        tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                        tvprice = (TextView) view.findViewById(R.id.tvprice);
                        tvarea = (TextView) view.findViewById(R.id.tvarea);
                        tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                        tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                        tvintime = (TextView) view.findViewById(R.id.tvintime);
                        tvouttime = (TextView) view.findViewById(R.id.tvouttime);
                        tvservice = (TextView) view.findViewById(R.id.tvservice);
                        tvtime1 = (TextView) view.findViewById(R.id.tvtime1);
                        tvtime2 = (TextView) view.findViewById(R.id.tvtime2);
                        tvtype = (TextView) view.findViewById(R.id.tvtype);
                        budgflag=mclass.getBudgetflag();
                        if (budgflag== 1) {
                            legendBorn.setText(mclass.getType());
                            tvbrand.setText(mclass.getModel());
                            tvprice.setText(mclass.getService());
                            tvarea.setText(mclass.getCompany());
                            tvfloor.setText(mclass.getBuliding());
                            tvbudget.setText(mclass.getAdd());
                            tvtime1.setText(mclass.getQuotation());
                            tvtime2.setText(mclass.getNegotiation());
                            tvtype.setText(mclass.getYear());
                            tvservice.setText("No of years         :");
                        }else  if (budgflag==0){
                            legendBorn.setText(mclass.getType());
                            tvbrand.setText(mclass.getModel());
                            tvprice.setText(mclass.getService());
                            tvarea.setText(mclass.getCompany());
                            tvfloor.setText(mclass.getBuliding());
                            tvbudget.setText(mclass.getAdd());
                            tvintime.setText("Budget                   :");
                            tvtime1.setText(mclass.getNegotiation());
                            tvouttime.setText("No of years              :");
                            tvtime2.setText(mclass.getYear());
                            tvservice.setVisibility(view.GONE);
                            tvtype.setVisibility(view.GONE);


                        }
                        // tvlegendName.setText(mclass.getissue());
//                    legendBorn.setText(mclass.getType());
//                    tvbrand.setText(mclass.getModel());
//                    tvprice.setText(mclass.getService());
//                    tvarea.setText(mclass.getCompany());
//                    tvfloor.setText(mclass.getBuliding());
//                    tvbudget.setText(mclass.getAdd());
//                    tvtime1.setText(mclass.getQuotation());
//                    tvtime2.setText(mclass.getNegotiation());
//                    tvtype.setText(mclass.getFloor());

                        //tvprice.setText(mclass.getRepair());
                        tvselectmake.setText(mclass.getCategory());
                        tvnumber.setText(mclass.getMobilenumber());
                        tvuser.setText(mclass.getName());
                        tvtimes.setText(mclass.getTime());
                        tvdates.setText(mclass.getDate());
                        tvuseraddress.setText(mclass.getLocadd());
//          );
                        gr.grfonttxt(legendBorn);
                        gr.grfonttxt(tvprice);
                        gr.grfonttxt(tvbrand);
                        insertPoint.addView(view);



                } else if (sertyp == 13) {
                    View view = layoutInflator.inflate(R.layout.itemordershouse, null);

                    // tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                    legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                    tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                    tvsize = (TextView) view.findViewById(R.id.tvsize);
                    tvarea = (TextView) view.findViewById(R.id.tvarea);
                    //  tvsqft = (TextView) view.findViewById(R.id.tvsqft);
                    tvnumbers = (TextView) view.findViewById(R.id.tvnumbers);
                    tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                    tvtell = (TextView) view.findViewById(R.id.tvtell);
                    tvbudget = (TextView) view.findViewById(R.id.tvbudget);
                    tvprice = (TextView) view.findViewById(R.id.tvprice);
                    tvintime = (TextView) view.findViewById(R.id.tvintime);
                    tvouttime = (TextView) view.findViewById(R.id.tvouttime);
                    tvtime1 = (TextView) view.findViewById(R.id.tvtime1);
                    tvtime2 = (TextView) view.findViewById(R.id.tvtime2);
                    tvservice = (TextView) view.findViewById(R.id.tvservice);
                    tvtype = (TextView) view.findViewById(R.id.tvtype);
                    tvweekoff = (TextView) view.findViewById(R.id.tvweekoff);
                    tvweek = (TextView) view.findViewById(R.id.tvweek);
                    legendBorn.setText(mclass.getType());
                    tvbrand.setText(mclass.getModel());
                    tvprice.setText(mclass.getService());
                    tvarea.setText(mclass.getGender());
//                tvsqft.setText(mclass.getSqft());
                    tvfloor.setText(mclass.getDuty());
                    tvtype.setText(mclass.getChoose());
                    tvweek.setText(mclass.getWeekoff());
                    tvbudget.setText(mclass.getQty());
                    tvtime1.setText(mclass.getIntime());
                    tvtime2.setText(mclass.getOuttime());
                    //tvprice.setText(mclass.getRepair());
                    tvselectmake.setText(mclass.getCategory());
                    tvnumber.setText(mclass.getMobilenumber());
                    tvuser.setText(mclass.getName());
                    tvtimes.setText(mclass.getTime());
                    tvdates.setText(mclass.getDate());
                    tvuseraddress.setText(mclass.getLocadd());
                    tvsize.setVisibility(view.GONE);
                  tvarea.setVisibility(view.GONE);
                    gr.grfonttxt(legendBorn);
                    gr.grfonttxt(tvprice);
                    gr.grfonttxt(tvbrand);
                    gr.grfonttxt(tvsize);
                    gr.grfonttxt(tvarea);
                    //gr.grfonttxt(tvsqft);
                    gr.grfonttxt(tvnumbers);
                    gr.grfonttxt(tvfloor);
                    gr.grfonttxt(tvtell);
                    gr.grfonttxt(tvbudget);
                    insertPoint.addView(view);


                } else if (sertyp == 14) {
                    View view = layoutInflator.inflate(R.layout.itemorders, null);

                    tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                    legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                    tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                    tvprice = (TextView) view.findViewById(R.id.tvprice);
                    tvlegendName.setText(mclass.getissue());
                    legendBorn.setText(mclass.getType());
                    // tvbrand.setText(mclass.getModel());
                    tvbrand.setText(mclass.getService());
                    tvprice.setVisibility(view.GONE);
                    //tvprice.setText(mclass.getRepair());
                    tvselectmake.setText(mclass.getCategory());
                    tvnumber.setText(mclass.getMobilenumber());
                    tvuser.setText(mclass.getName());
                    tvtimes.setText(mclass.getTime());
                    tvdates.setText(mclass.getDate());
                    tvuseraddress.setText(mclass.getLocadd());
//
//

                    gr.grfonttxt(tvlegendName);
                    gr.grfonttxt(legendBorn);
                    gr.grfonttxt(tvprice);
                    gr.grfonttxt(tvbrand);
                    insertPoint.addView(view);
                } else if (sertyp == 15) {
                    View view = layoutInflator.inflate(R.layout.itemorders, null);

                    tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
                    legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                    tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                    tvprice = (TextView) view.findViewById(R.id.tvprice);
                    tvlegendName.setText(mclass.getissue());
                    legendBorn.setText(mclass.getType());
                    // tvbrand.setText(mclass.getModel());
                    tvbrand.setText(mclass.getService());
                    tvprice.setVisibility(view.GONE);
                    //tvprice.setText(mclass.getRepair());
                    tvselectmake.setText(mclass.getCategory());
                    tvnumber.setText(mclass.getMobilenumber());
                    tvuser.setText(mclass.getName());
                    tvtimes.setText(mclass.getTime());
                    tvdates.setText(mclass.getDate());
                    tvuseraddress.setText(mclass.getLocadd());
//
//

                    gr.grfonttxt(tvlegendName);
                    gr.grfonttxt(legendBorn);
                    gr.grfonttxt(tvprice);
                    gr.grfonttxt(tvbrand);
                    insertPoint.addView(view);
                }
            }

            //  gr.grfonttxt(tvlegendName);

            //views.add(view);

        }else if(pos==4) {
            View view = layoutInflator.inflate(R.layout.itemorders, null);

            tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
            legendBorn = (TextView) view.findViewById(R.id.legendBorn);
            tvbrand = (TextView) view.findViewById(R.id.tvbrand);
            tvprice = (TextView) view.findViewById(R.id.tvprice);
            tvlegendName.setText(mclass.getissue());
            legendBorn.setText(mclass.getType());
            tvbrand.setText(mclass.getModel());
            tvprice.setText(mclass.getService());
            //tvprice.setText(mclass.getRepair());
            tvselectmake.setText(mclass.getCategory());
            tvnumber.setText(mclass.getMobilenumber());
            tvuser.setText(mclass.getName());
            tvtimes.setText(mclass.getTime());
            tvdates.setText(mclass.getDate());
            tvuseraddress.setText(mclass.getLocadd());
//

            gr.grfonttxt(tvlegendName);
            gr.grfonttxt(legendBorn);
            gr.grfonttxt(tvprice);
            gr.grfonttxt(tvbrand);
            insertPoint.addView(view);
        }else if(pos==5) {
            View view = layoutInflator.inflate(R.layout.itemorders, null);

            tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
            legendBorn = (TextView) view.findViewById(R.id.legendBorn);
            tvbrand = (TextView) view.findViewById(R.id.tvbrand);
            tvprice = (TextView) view.findViewById(R.id.tvprice);
            tvlegendName.setText(mclass.getissue());
            legendBorn.setText(mclass.getType());
            tvbrand.setText(mclass.getModel());
            tvprice.setText(mclass.getService());
            //tvprice.setText(mclass.getRepair());
            tvselectmake.setText(mclass.getCategory());
            tvnumber.setText(mclass.getMobilenumber());
            tvuser.setText(mclass.getName());
            tvtimes.setText(mclass.getTime());
            tvdates.setText(mclass.getDate());
            tvuseraddress.setText(mclass.getLocadd());
//

            gr.grfonttxt(tvlegendName);
            gr.grfonttxt(legendBorn);
            gr.grfonttxt(tvprice);
            gr.grfonttxt(tvbrand);
            insertPoint.addView(view);
        }else if(pos==6) {
            View view = layoutInflator.inflate(R.layout.itemorders, null);

            tvlegendName = (TextView) view.findViewById(R.id.tvlegendName);
            legendBorn = (TextView) view.findViewById(R.id.legendBorn);
            tvbrand = (TextView) view.findViewById(R.id.tvbrand);
            tvprice = (TextView) view.findViewById(R.id.tvprice);
            tvlegendName.setText(mclass.getissue());
            legendBorn.setText(mclass.getType());
            tvbrand.setText(mclass.getModel());
            tvprice.setText(mclass.getService());
            //tvprice.setText(mclass.getRepair());
            tvselectmake.setText(mclass.getCategory());
            tvnumber.setText(mclass.getMobilenumber());
            tvuser.setText(mclass.getName());
            tvtimes.setText(mclass.getTime());
            tvdates.setText(mclass.getDate());
            tvuseraddress.setText(mclass.getLocadd());
//

            gr.grfonttxt(tvlegendName);
            gr.grfonttxt(legendBorn);
            gr.grfonttxt(tvprice);
            gr.grfonttxt(tvbrand);
            insertPoint.addView(view);
        }else if(pos==7) {
            if (sertyp == 0) {
                View view = layoutInflator.inflate(R.layout.itemordersevent, null);


                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
               tvarea= (TextView) view.findViewById(R.id.tvarea);
                tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                tvveg=( TextView) view.findViewById(R.id.tvveg);
                tvnonveg=( TextView) view.findViewById(R.id.tvnonveg);
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getGuest());
                tvfloor.setText(mclass.getHost());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
           tvveg.setVisibility(view.GONE);
                tvnonveg.setVisibility(view.GONE);

//                gr.grfonttxt(tvlegendName);
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);
            } else if (sertyp == 1) {
                View view = layoutInflator.inflate(R.layout.itemordersevent, null);


                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvarea= (TextView) view.findViewById(R.id.tvarea);
                tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                tvsize = (TextView) view.findViewById(R.id.tvsize);
              tvnumbers = (TextView) view.findViewById(R.id.tvnumbers);
                tvveg=( TextView) view.findViewById(R.id.tvveg);
                tvnonveg=( TextView) view.findViewById(R.id.tvnonveg);
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setVisibility(view.GONE);
               tvarea.setVisibility(view.GONE);
               tvfloor.setVisibility(view.GONE);
                tvsize.setVisibility(view.GONE);
                tvnumbers.setVisibility(view.GONE);
                tvveg.setVisibility(view.GONE);
                tvnonveg.setVisibility(view.GONE);

                // tvprice.setText(mclass.getService());
               // tvarea.setText(mclass.getGuest());
               // tvfloor.setText(mclass.getHost());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());
//

//                gr.grfonttxt(tvlegendName);
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);
            }else if (sertyp == 2) {
                View view = layoutInflator.inflate(R.layout.itemordersevent, null);


                legendBorn = (TextView) view.findViewById(R.id.legendBorn);
                tvbrand = (TextView) view.findViewById(R.id.tvbrand);
                tvprice = (TextView) view.findViewById(R.id.tvprice);
                tvarea = (TextView) view.findViewById(R.id.tvarea);
                tvfloor = (TextView) view.findViewById(R.id.tvfloor);
                tvveg = (TextView) view.findViewById(R.id.tvveg);
                tvnonveg = (TextView) view.findViewById(R.id.tvnonveg);
                legendBorn.setText(mclass.getType());
                tvbrand.setText(mclass.getModel());
                tvprice.setText(mclass.getService());
                tvarea.setText(mclass.getGuest());
                tvfloor.setText(mclass.getHost());
                tvnonveg.setText(mclass.getVeg());
                //tvprice.setText(mclass.getRepair());
                tvselectmake.setText(mclass.getCategory());
                tvnumber.setText(mclass.getMobilenumber());
                tvuser.setText(mclass.getName());
                tvtimes.setText(mclass.getTime());
                tvdates.setText(mclass.getDate());
                tvuseraddress.setText(mclass.getLocadd());

//                gr.grfonttxt(tvlegendName);
                gr.grfonttxt(legendBorn);
                gr.grfonttxt(tvprice);
                gr.grfonttxt(tvbrand);
                insertPoint.addView(view);
            }
        }else if(pos==8){
            View view = layoutInflator.inflate(R.layout.itemordersloans, null);


            legendBorn = (TextView) view.findViewById(R.id.legendBorn);
            tvbrand = (TextView) view.findViewById(R.id.tvbrand);
            tvprice = (TextView) view.findViewById(R.id.tvprice);
            tvarea = (TextView) view.findViewById(R.id.tvarea);
            tvsize= (TextView) view.findViewById(R.id.tvsize);

            legendBorn.setText(mclass.getType());
            tvbrand.setText(mclass.getModel());
            tvprice.setText(mclass.getService());
            tvarea.setText(mclass.getBudget());

            //tvprice.setText(mclass.getRepair());
            tvselectmake.setText(mclass.getCategory());
            tvnumber.setText(mclass.getMobilenumber());
            tvuser.setText(mclass.getName());
            tvtimes.setText(mclass.getTime());
            tvdates.setText(mclass.getDate());
            tvuseraddress.setText(mclass.getLocadd());

//                gr.grfonttxt(tvlegendName);
            gr.grfonttxt(legendBorn);
            gr.grfonttxt(tvprice);
            gr.grfonttxt(tvbrand);
            insertPoint.addView(view);
        }
        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrdersummaryActivity.this, SchedulePageActivity.class);

                startActivity(intent);
            }
        });

    }

}


