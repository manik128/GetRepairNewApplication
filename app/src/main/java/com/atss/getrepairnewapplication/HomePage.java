package com.atss.getrepairnewapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atss.getrepairnewapplication.SchedulePage.Getrepairpojo;

import java.util.Timer;
import java.util.TimerTask;

public class HomePage extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager;
    ImageView indicator1, indicator2, indicator3,ivactionhomemap;
    LinearLayout lcar,linearcart;
    ViewPagerAdapter viewadapter;
    TextView title,bike,car,home,desktop,tvfacility,interior,loc,lochead,myprof,reward,wallet,share,notify,help,locmenu,tvarticles,tvguarantee,tvverify,tvprofessional,tvinsured,tvwork,tvsatisfaction,tvguarantees,tvbeauty,tvevents,tvloans, homeapp,repairtxt,tvinter;
    Timer timer;
    Mainclass mclass;
    int count = 0;
    int noofsize = 3;
    int position;


    int j;
    int[] mids = {

            R.drawable.cara,
            R.drawable.apartmenta,
            R.drawable.electriciana,
            R.drawable.bikea


    };
    String cat[] = {"Minearl or Synthetic\noil? What's better\nfor your car?", "4 car lover\nmust know",
            "Why does your car\nneed to be waxed?", "How do you care for\nyour motorcycle\nspark plug?"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mclass=(Mainclass) getApplicationContext();
        //toolbar.setTitle("");
        //StartLocationAlert startLocationAlert = new StartLocationAlert(HomePage.this);
        indicator1 = (ImageView)findViewById(R.id.imgslidecircle1);

        indicator2 = (ImageView)findViewById(R.id.imgslidecircle2);
        indicator3 = (ImageView)findViewById(R.id.imgslidecircle3);
        loc=(TextView)findViewById(R.id.loc);
        LinearLayout root = (LinearLayout) findViewById(R.id.linearlayouthorscroll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        for (j = 0; j <= 3; j++) {
            Getrepairpojo pojo = new Getrepairpojo(new LinearLayout(HomePage.this), j);
            pojo.getLinearLayout().setOrientation(LinearLayout.VERTICAL);
            //    pojo.getLinearLayout().setBackgroundColor(color[j]);
            pojo.getLinearLayout().setPadding(10, 10, 10, 10);

//ll.setDividerPadding(1);
            params.setMargins(4, 0, 4, 0);
            pojo.getLinearLayout().setLayoutParams(params);
            pojo.getLinearLayout().setClickable(true);
            final ImageView ivproduct = new ImageView(HomePage.this);
            ivproduct.setImageResource(mids[j]);
            // ivproduct.setBackgroundColor(color[j]);
            //  ivproduct.setId(j+1);
            ivproduct.setPadding(10, 10, 10, 10);
            pojo.getLinearLayout().addView(ivproduct);

            TextView product = new TextView(HomePage.this);

            product.setText(cat[j]);
            product.setGravity(Gravity.CENTER);
            product.setPadding(10, 10, 10, 10);
            //product.setTextColor(Color.parseColor("#ffffff"));
            //product.setBackgroundColor(color[j]);
            pojo.getLinearLayout().addView(product);

            final int positon = pojo.getPosition();
            pojo.getLinearLayout().setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {
                    //  Toast.makeText(SagarAssociatesActivity.this,"clickable",Toast.LENGTH_LONG).show();
                    changeView(positon);
                }

            });

            root.addView(pojo.getLinearLayout());

        }
        final LinearLayout lcart=(LinearLayout)findViewById(R.id.linearcart);
        lcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,AddtocartActivity.class);

                startActivity(intent );
            }
        });

      final TextView bk = (TextView ) findViewById(R.id.bk);
        final LinearLayout lcar=(LinearLayout)findViewById(R.id.lcar);
        lcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MainActivity12.class);
                mclass.setPosition(0);
                mclass.setCategory(bk.getText().toString());
                startActivity(intent );
            }
        });
        final TextView cr = (TextView) findViewById(R.id.cr);
        final LinearLayout lbuilding=(LinearLayout)findViewById(R.id.lbuilding);
        lbuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MainActivity12.class);
                mclass.setPosition(1);
                mclass.setCategory("Building/Construction");
                startActivity(intent);
            }
        });
        TextView home = (TextView) findViewById(R.id.homeapp);
        final LinearLayout lhome=(LinearLayout)findViewById(R.id.lhome);
        final TextView finalHome = home;
        lhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MainActivity12.class);
                mclass.setPosition(2);
                mclass.setCategory("Home Appliances");
                startActivity(intent );
            }
        });
        final TextView facility = (TextView) findViewById(R.id.tvfacility);
        final LinearLayout lfacility=(LinearLayout)findViewById(R.id.lfacility);
        lfacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MainActivity12.class);
                mclass.setPosition(3);
                mclass.setCategory("Facility Management");
                startActivity(intent );
            }
        });
        TextView repair = (TextView) findViewById(R.id.repairtxt);
        final LinearLayout lrepair=(LinearLayout)findViewById(R.id.lrepair);
        final TextView finalRepair = repair;
        lrepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MainActivity12.class);
                mclass.setPosition(4);
                mclass.setCategory("Repair Maintaince");
                startActivity(intent );
            }
        });
        final TextView interior = (TextView) findViewById(R.id.tvinter);
        final LinearLayout linterior=(LinearLayout)findViewById(R.id.linterior);

        linterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MainActivity12.class);
                mclass.setPosition(5);
                mclass.setCategory("Interiorwork/Suppliers");
                startActivity(intent );
            }
        });
        final TextView beauty = (TextView) findViewById(R.id.tvbeauty);
        final LinearLayout lbeauty =(LinearLayout)findViewById(R.id.lbeauty);
        lbeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MainActivity12.class);
                mclass.setPosition(6);
                mclass.setCategory("Beauty Salon/Parlour");
                startActivity(intent );
            }
        });
        final TextView events = (TextView) findViewById(R.id.tvevents);
        final LinearLayout levents =(LinearLayout)findViewById(R.id.levents);
        levents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MainActivity12.class);
                mclass.setPosition(7);
                mclass.setCategory(events.getText().toString());
                startActivity(intent );
            }
        });
        final TextView loans = (TextView) findViewById(R.id.tvloans);
        final LinearLayout lloans =(LinearLayout)findViewById(R.id.lloans);
        lloans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MainActivity12.class);
                mclass.setPosition(8);
                mclass.setCategory("Financial Loans");
                startActivity(intent );
            }
        });
//        lcar.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                switch(event.getAction()) {
//
//                    case MotionEvent.ACTION_DOWN:
//                        lcar.setBackgroundColor(Color.LTGRAY);
//                        //Toast.makeText(c, "DOWN", Toast.LENGTH_SHORT).show();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        //Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//
//                return false;
//            }
//
//        });
        locmenu=(TextView)findViewById(R.id.menuloc);
        title=(TextView)findViewById(R.id.titlabel);
        bike=(TextView)findViewById(R.id.bk);
        car=(TextView)findViewById(R.id.cr);
        tvbeauty=(TextView)findViewById(R.id.tvbeauty);
        tvevents=(TextView)findViewById(R.id.tvevents);
        tvloans=(TextView)findViewById(R.id.tvloans);
       homeapp=(TextView)findViewById(R.id.homeapp);
      //  desktop=(TextView)findViewById(R.id.desk);
        tvfacility=(TextView)findViewById(R.id.tvfacility);
        repairtxt=(TextView)findViewById(R.id.repairtxt);
        tvinter=(TextView)findViewById(R.id.tvinter);
        lochead=(TextView)findViewById(R.id.header);
        myprof=(TextView)findViewById(R.id.textView1);
        reward=(TextView)findViewById(R.id.textView2);
        wallet=(TextView)findViewById(R.id.textView3);
        share=(TextView)findViewById(R.id.textView4);
        notify=(TextView)findViewById(R.id.textView5);

        tvarticles=(TextView)findViewById(R.id.tvarticles);
        tvguarantee=(TextView)findViewById(R.id.tvguarantee);
        tvverify=(TextView)findViewById(R.id.tvverify);
        tvprofessional=(TextView)findViewById(R.id.tvprofessional);
        tvinsured=(TextView)findViewById(R.id.tvinsured);
        tvwork=(TextView)findViewById(R.id.tvwork);
        tvsatisfaction=(TextView)findViewById(R.id.tvsatisfaction);
        tvguarantees=(TextView)findViewById(R.id.tvguarantees);


       setfont();

        loc.setText(mclass.getAddress());
        locmenu.setText(mclass.getAddress());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewadapter = new ViewPagerAdapter(HomePage.this);
        viewPager.setAdapter(viewadapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                try {
                    if (position == 0) {
                        indicator1.setBackgroundResource(R.drawable.selectindi);
                        indicator2.setBackgroundResource(R.drawable.circle);
                        indicator3.setBackgroundResource(R.drawable.circle);

                    } else if (position == 1) {
                        indicator1.setBackgroundResource(R.drawable.circle);
                        indicator2.setBackgroundResource(R.drawable.selectindi);
                        indicator3.setBackgroundResource(R.drawable.circle);

                    } else if (position == 2) {
                        indicator1.setBackgroundResource(R.drawable.circle);
                        indicator2.setBackgroundResource(R.drawable.circle);
                        indicator3.setBackgroundResource(R.drawable.selectindi);

                    }
                } catch (Exception e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (count <= 3) {
                            viewPager.setCurrentItem(count);
                            count++;
                        } else {
                            count = 0;
                            viewPager.setCurrentItem(count);

                        }
                    }
                });
            }
        }, 500, 3000);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n1= new Intent(HomePage.this,MapsActivity2.class);
                startActivity(n1);
            }
        });
    }

    public void setfont(){
        grfont gr= new grfont(HomePage.this);
        gr.grfontlgttxt(myprof);
        gr.grfontlgttxt(reward);
        gr.grfontlgttxt(wallet);
        gr.grfontlgttxt(share);
        gr.grfontlgttxt(notify);

        gr.grfonttxt(tvarticles);
        gr.grfonttxt(tvguarantee);
        gr.grfonttxt(tvprofessional);
        gr.grfonttxt(tvinsured);
        gr.grfonttxt(tvwork);

        gr.grfontlgttxt(tvbeauty);
        gr.grfontlgttxt(tvloans);
        gr.grfontlgttxt(tvevents);

        gr.grfonttxt(tvverify);
        gr.grfonttxt(tvguarantees);
        gr.grfonttxt(tvsatisfaction);
        gr.grfonttxt(loc);
        gr.grfonttxt(lochead);
        gr.grfontlgttxt(bike);
        gr.grfontlgttxt(car);
        gr.grfontlgttxt(homeapp);
        //gr.grfonttxt(desktop);
       gr.grfontlgttxt(repairtxt);
        gr.grfontlgttxt(tvinter);
        gr.grfontlgttxt(tvfacility);
    }
    private void changeView(int positon) {
        if (positon == 0) {
            Intent intent = new Intent(HomePage.this, ArticleActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

     /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*public void gpstrack() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        String bestProvider = locationManager.getBestProvider(criteria, true);
        mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(LocationServices.API).build();
        mGoogleApiClient.connect();

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Location location = locationManager.getLastKnownLocation(bestProvider);
            if (location != null) {
                onLocationChanged(location);
                locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);


                //Toast.makeText(this, "GPS is Enabled in your devide", Toast.LENGTH_SHORT).show();

                //}
            }
        }
        else{
            //showGPSDisabledAlertToUser();
        }
    }*/
}
