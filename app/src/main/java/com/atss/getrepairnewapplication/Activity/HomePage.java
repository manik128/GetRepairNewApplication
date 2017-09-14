package com.atss.getrepairnewapplication.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atss.getrepairnewapplication.Adapter.ViewPagerAdapter;


import com.atss.getrepairnewapplication.MInterface;
import com.atss.getrepairnewapplication.MainActivity12;
import com.atss.getrepairnewapplication.Mainclass;
import com.atss.getrepairnewapplication.Pojoclass.Getrepairpojo;
import com.atss.getrepairnewapplication.Pojoclass.grfont;
import com.atss.getrepairnewapplication.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HomePage extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener,ConnectionCallbacks,
        OnConnectionFailedListener, LocationListener {
    ViewPager viewPager;
    ImageView indicator1, indicator2, indicator3,ivactionhomemap,fab1;
    LinearLayout lcar,linearcart;
    ViewPagerAdapter viewadapter;
    TextView title,bike,car,home,desktop,tvfacility,interior,loc,lochead,myprof,reward,wallet,share,notify,help,locmenu,tvarticles,tvguarantee,tvverify,tvprofessional,tvinsured,tvwork,tvsatisfaction,tvguarantees,tvbeauty,tvevents,tvloans, homeapp,repairtxt,tvinter,tvorders,tvtext;
    Timer timer;
    String address = null, province = null, country = null, postalCode = null, knownName = null, local = null, local2 = null;
    Mainclass mclass;
    private GoogleApiClient mGoogleApiClient;
    Geocoder geocoder;
    private static final String TAG = HomePage.class.getSimpleName();
    private boolean mRequestingLocationUpdates = false;
    private LocationRequest mLocationRequest;
    private TextView lblLocation;
    List<Address> addresses = null;
    private Location mLastLocation;
    public static final String MyPREFERENCES = "MyPrefs";
    int count = 0;
    private static int UPDATE_INTERVAL = 10000; // 10 sec
    private static int FATEST_INTERVAL = 5000; // 5 sec
    private static int DISPLACEMENT = 10; // 10 meters
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    String[] spiltaddr, spiltaddr2;
    private String fulladdr;
    int noofsize = 3;
    int position;
    CircleImageView profile_image;
    String url = "http://getrepair.in";
    int j;
    int[] mids = {

            R.drawable.cara,
            R.drawable.apartmenta,
            R.drawable.electriciana,
            R.drawable.bikea


    };
    String[] articles=new String[3];
    String cat[] = {"Minearl or Syntheticoil? What's betterfor your car?", "4 car lover must know",
            "Why does your car need to be waxed?", "How do you care for your motorcycle spark plug?"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buildGoogleApiClient();
        createLocationRequest();
        mclass=(Mainclass) getApplicationContext();
        //toolbar.setTitle("");
        //StartLocationAlert startLocationAlert = new StartLocationAlert(HomePage.this);
        indicator1 = (ImageView)findViewById(R.id.imgslidecircle1);
      tvorders = (TextView) findViewById(R.id.tvorders);
        tvorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,OrderActivity.class);
                startActivity(intent );
            }
        });
        profile_image = (CircleImageView) findViewById(R.id. profile_image);
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,Profilepage.class);

                startActivity(intent );
            }
        });

        indicator2 = (ImageView)findViewById(R.id.imgslidecircle2);
        indicator3 = (ImageView)findViewById(R.id.imgslidecircle3);
        loc=(TextView)findViewById(R.id.loc);

        RestAdapter radapter = new RestAdapter.Builder().setEndpoint(url).build();

        MInterface restInt = radapter.create(MInterface.class);

        restInt.insertarticle(

                //Passing the values by getting it from editTexts
                "auto",


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
                            JSONArray json_data = new JSONArray(output);

                            System.out.print("succesful"+output+json_data.length());
                            int flag=0;
                            //json_data.put("us", result);
                            //Toast.makeText(getBaseContext(), "Inserted Successfully"+result+json_data,Toast.LENGTH_SHORT).show();
                            //json_data.put("code", result);

                            for (int i = 0; i < json_data.length(); i++) {
                                final JSONObject jo = json_data.getJSONObject(i);

                                    flag = 1;
                                LinearLayout root = (LinearLayout) findViewById(R.id.linearlayouthorscroll);
                                    LayoutInflater layoutInflator = (LayoutInflater) HomePage.this.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                    View vw = layoutInflator.inflate(R.layout.horizantalscrollview, null);
                                    fab1 = (ImageView)vw.findViewById(R.id.fab1);
                                    tvtext= (TextView) vw.findViewById(R.id.tvtext);
                                grfont gr= new grfont(HomePage.this);
                                gr.grfonttxt(tvtext);
                                    final String question= jo.getString("ques");
                                    final String Image = jo.getString("img");
                                    final String content= jo.getString("cont");
                                Picasso.with(HomePage.this).load( Image).into(fab1);
                                tvtext.setText(question);
                               root.addView(vw);
                                vw.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(HomePage.this,ArticleActivity.class);
                                        intent.putExtra("ques",question);
                                        intent.putExtra("cont",content);
                                        startActivity(intent );
                                    }
                                });

//                    mclass.setTaskdate(jo.getString("taskdate"));
//                    mclass.setFrtime(jo.getString("fromtime"));
//                    mclass.setTotime(jo.getString("totime"));
//                    mclass.setTaskdescription(jo.getString("taskdesc"));
//                    mclass.setContactperson(jo.getString("contactperson"));
//                    mclass.setFromaddress(jo.getString("fromaddress"));
//                    mclass.setStatus(jo.getString("status"));


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
                        Toast.makeText(HomePage.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );

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
       // myprof=(TextView)findViewById(R.id.textView1);
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

        String[] images = {
                String.valueOf(R.drawable.homeimages)};
        viewadapter = new ViewPagerAdapter(HomePage.this,images);
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
        RestAdapter  radapter1 = new RestAdapter.Builder().setEndpoint(url).build();

        MInterface restInt1 = radapter1.create(MInterface.class);

        restInt1.insertUsers(

                //Passing the values by getting it from editTexts
                "home",
                "banner",

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

                            String code = json_data.getString("img1");
                            String code1 = json_data.getString("img2");
                            String code2 = json_data.getString("img3");
                            //  String vendorid = json_data.getString("venid");
                            String[] images = {
                                    code,
                                    code1,
                                    code2,
                                    // "http://getrepair.in/GetRepairApi/images/HomeBC.jpg",
                                    //"http://getrepair.in/GetRepairApi/images/HomeCar.jpg"
                            };
                            ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(HomePage.this).build();
                            ImageLoader.getInstance().init(config);
                            viewadapter = new ViewPagerAdapter(HomePage.this,images);
                            viewPager.setAdapter(viewadapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Displaying the output as a toast
                        //Toast.makeText(loginpageActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(HomePage.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }





    public void setfont(){
        grfont gr= new grfont(HomePage.this);
        gr.grfontlgttxt(tvorders);
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
    @Override
    public void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        checkPlayServices();

        // Resuming the periodic location updates
        if (mGoogleApiClient.isConnected() && mRequestingLocationUpdates) {
            startLocationUpdates();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
       // stopLocationUpdates();
    }
    private void displayLocation() {
        checkPermission();
        mLastLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);

        if (mLastLocation != null) {
            double latitude = mLastLocation.getLatitude();
            double longitude = mLastLocation.getLongitude();
            mclass.setLat(latitude);
            mclass.setLang(longitude);
            //lblLocation.setText(latitude + ", " + longitude);
            geocoder = new Geocoder(HomePage.this);
            try {
                addresses = geocoder.getFromLocation(latitude, longitude, 1);

                //get current Street name
                address = addresses.get(0).getAddressLine(0) + addresses.get(0).getAddressLine(1);

                //get current province/City

                local2 = addresses.get(0).getAddressLine(2);
                //local= "*"+addresses.get(0).getAddressLine(2);
                country = addresses.get(0).getAddressLine(3);
                spiltaddr = local2.split(",");
                spiltaddr2 = spiltaddr[1].split("\\s");
                province = spiltaddr2[1];
                local = spiltaddr[0];
                postalCode = spiltaddr2[2];
                fulladdr = address + "," + local + "," + province + "," + postalCode + "," + country;
                //lblLocation.setText(fulladdr);
                mclass.setAddress(address);
                mclass.setCity(province);
                mclass.setPin(postalCode);
                mclass.setLocadd(fulladdr);
                loc.setText( address );
                // mclass.setAddress(country);
                //fulladdr= fulladdr.replace(',',' ');
                //fulladdr=fulladdr.replaceAll("\\s+","");
                // a.replaceAll("\\s+","");
                System.out.println("full addr" + fulladdr);
                // loc.setText(fulladdr);
                //mclass.setAddress(fulladdr);
                //fulladdr.replaceAll(","," ");
                //get postal code
                // postalCode = "*"+addresses.get(0).getAddressLine(4);
                //Toast.makeText(GpsTrack.this,"add:"+spiltaddr[0]+spiltaddr2[1]+spiltaddr2[2],Toast.LENGTH_LONG).show();
                //get place Name
                //knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

            /*return  address + "\t"  + province + "\t " + country
                    + "\t" + postalCode + "\t"  + knownName;*/
               // Toast.makeText(HomePage.this, "pin" +address, Toast.LENGTH_SHORT).show();
            } catch (IOException ex) {
                ex.printStackTrace();


            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();

            }

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
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(HomePage.this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, HomePage.this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(HomePage.this,
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
              HomePage.this.finish();
            }
            return false;
        }
        return true;
    }
    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;

        Toast.makeText(HomePage.this, "Location changed!",
                Toast.LENGTH_SHORT).show();

        // Displaying the new location on UI
        displayLocation();
    }



    private boolean checkPermission() {
        boolean flag = true;
        String[] permissions = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.RECEIVE_SMS"};
        if (ActivityCompat.checkSelfPermission(HomePage.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(HomePage.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions, 3);
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }



    @Override
    public void onConnected(Bundle arg0) {

        // Once connected with google api, get the location
        displayLocation();

        if (mRequestingLocationUpdates) {
            startLocationUpdates();
        }
    }


    @Override
    public void onConnectionSuspended(int arg0) {
        mGoogleApiClient.connect();
    }


    protected void startLocationUpdates() {
        checkPermission();
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);

    }
//    protected void stopLocationUpdates() {
//        LocationServices.FusedLocationApi.removeLocationUpdates(
//                mGoogleApiClient, this);
//    }
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(HomePage.this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }

    /**
     * Creating location request object
     */
    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FATEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setSmallestDisplacement(DISPLACEMENT);
    }
    /**
     * Google api callback methods
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
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
