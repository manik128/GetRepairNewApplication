package com.atss.getrepairnewapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Address;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import android.location.LocationListener;
import android.widget.Toast;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener{
    private static final String TAG = MainActivity.class.getSimpleName();

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    TextView checkbut,logintext,forgetpass;
    String[] spiltaddr,spiltaddr2;
    private String fulladdr;
    String address = null,province = null,country = null,postalCode = null,knownName = null,local=null,local2=null;
    private Location mLastLocation;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sp;
    // Google client to interact with Google API


    // boolean flag to toggle periodic location updates
    private boolean mRequestingLocationUpdates = false;

    private LocationRequest mLocationRequest;

    boolean press=true;
    EditText email,pass,name;
    private GoogleApiClient mGoogleApiClient;
    Geocoder geocoder;
    Mainclass mclass;
    List<Address> addresses = null;
    TextInputLayout txtlay,txtlay1,txtlay2;
    private static int UPDATE_INTERVAL = 10000; // 10 sec
    private static int FATEST_INTERVAL = 5000; // 5 sec
    private static int DISPLACEMENT = 10; // 10 meters

    // UI elements
    private TextView lblLocation;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Button b1 = (Button) findViewById(R.id.button);
        email=(EditText)findViewById(R.id.etemail);
        pass=(EditText)findViewById(R.id.etpassword);
        name=(EditText)findViewById(R.id.etfullname);
        logintext=(TextView)findViewById(R.id.tit);
        checkbut = (TextView) findViewById(R.id.rdbtn);
        forgetpass = (TextView) findViewById(R.id.forpass);
        txtlay = ( TextInputLayout ) findViewById(R.id.input_layout_fullname);
        txtlay1 = ( TextInputLayout ) findViewById(R.id.input_layout_email);
        txtlay2 = ( TextInputLayout ) findViewById(R.id.input_layout_password);
        mclass=(Mainclass) getApplicationContext();

        Activity mContext = MainActivity.this;//change this your activity name
        StartLocationAlert startLocationAlert = new StartLocationAlert(mContext);
       grfont gr= new grfont(MainActivity.this);
        gr.grfonttxt(checkbut);
        gr.grfonttxt(forgetpass);
        gr.grfontbut(b1);
        gr.grfonttxtinpt(txtlay1);
        gr.grfonttxtinpt(txtlay2);
        gr.grfonttxt(logintext);
        gr.grfonttxtinpt(txtlay);
        mclass.setName("mahi");
        mclass.setMobilenumber("8147041121");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(getApplicationContext(), HomePage.class);
                startActivity(n);
            }
        });
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Forgotpassword.class);
                startActivity(intent);
            }
        });
        checkbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(press==true) {
                    Drawable img = getBaseContext().getResources().getDrawable(R.drawable.checked);
                    img.setBounds(0, 0,  (int)(img.getIntrinsicWidth()),(int)(img.getIntrinsicHeight()));

                    checkbut.setCompoundDrawables(img, null, null, null);
                    press=false;
                    txtlay.setVisibility(View.INVISIBLE);

                }
                else{
                    Drawable img = getBaseContext().getResources().getDrawable(R.drawable.dots_clear);
                    img.setBounds(0, 0, (int)(img.getIntrinsicWidth()),  (int)(img.getIntrinsicWidth()));

                    checkbut.setCompoundDrawables(img, null, null, null);
                    press=true;
                    txtlay.setVisibility(View.VISIBLE);
                }

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
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
//@Override
//public void onStart() {
//    super.onStart();
//    if (mGoogleApiClient != null) {
//        mGoogleApiClient.connect();
//    }
//}
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        checkPlayServices();
//
//        // Resuming the periodic location updates
//        if (mGoogleApiClient.isConnected() && mRequestingLocationUpdates) {
//            startLocationUpdates();
//        }
//    }
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mGoogleApiClient.isConnected()) {
//            mGoogleApiClient.disconnect();
//        }
//    }
//    @Override
//    public void onPause() {
//        super.onPause();
//        stopLocationUpdates();
//    }
    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


//    public void onLocationChanged(Location location) {
//        double latitude = location.getLatitude();
//        double longitude = location.getLongitude();
//        LatLng latLng = new LatLng(latitude, longitude);
//
//        mclass.setLat(latitude);
//        mclass.setLang(longitude);
//        //mclass.setName("mahi");
//        geocoder = new Geocoder(MainActivity.this);
//        try {
//            //address = addresses.get(0).getAddressLine(0)+addresses.get(0).getAddressLine(1);
//
//            addresses = geocoder.getFromLocation(latitude, longitude, 1);
//            local2=addresses.get(0).getAddressLine(2);
////local= "*"+addresses.get(0).getAddressLine(2);
//            country = addresses.get(0).getAddressLine(3);
//            spiltaddr= local2.split(",");
//            spiltaddr2= spiltaddr[1].split("\\s");
//            province = spiltaddr2[1];
//            local=spiltaddr[0];
//            postalCode=spiltaddr2[2];
//            fulladdr=address+","+local+","+province+","+postalCode+","+country;
//            mclass.setAddress(address);
////            mclass.setArea(address);
////            mclass.setLocadd(local);
//            mclass.setCity(province);
//            mclass.setPin(postalCode);
//            mclass.setAddress(country);
////fulladdr= fulladdr.replace(',',' ');
////fulladdr=fulladdr.replaceAll("\\s+","");
//// a.replaceAll("\\s+","");
//            System.out.println("full addr"+fulladdr);
////            System.out.println(addresses.get(0).getSubLocality()+addresses.get(0).getLocality()+addresses.get(0).getAdminArea());
////            mclass.setArea(addresses.get(0).getAddressLine(0));
////            mclass.setAddress(addresses.get(0).getAddressLine(1));
////            mclass.setCity(addresses.get(0).getAddressLine(2));
////            mclass.setPin(addresses.get(0).getAddressLine(3));
//           // mclass.setLocadd(addresses.get(0).getSubLocality()+","+addresses.get(0).getLocality()+","+addresses.get(0).getAdminArea());
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//
//
//        } catch (IllegalArgumentException ex) {
//            ex.printStackTrace();
//
//        }
//    }

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
           geocoder = new Geocoder(MainActivity.this);
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
               lblLocation.setText(fulladdr);
               mclass.setAddress(address);
               mclass.setCity(province);
               mclass.setPin(postalCode);
               mclass.setLocadd(fulladdr);
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
               //Toast.makeText(Home.this, "lat:" + fulladdr, Toast.LENGTH_SHORT).show();
           } catch (IOException ex) {
               ex.printStackTrace();


           } catch (IllegalArgumentException ex) {
               ex.printStackTrace();

           }

       }
   }
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(MainActivity.this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, MainActivity.this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                MainActivity.this.finish();
            }
            return false;
        }
        return true;
    }
    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;

        Toast.makeText(MainActivity.this, "Location changed!",
                Toast.LENGTH_SHORT).show();

        // Displaying the new location on UI
        displayLocation();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

//    public void gpstrack() {
//        LocationManager locationManager = (LocationManager) getSystemService(MainActivity.this.LOCATION_SERVICE);
//        Criteria criteria = new Criteria();
//
//        String bestProvider = locationManager.getBestProvider(criteria, true);
//
//        //client = new GoogleApiClient.Builder(this).addApi(LocationServices.API).build();
//        //mGoogleApiClient.connect();
//  checkPermission();
//
//        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//
//           Location location = locationManager.getLastKnownLocation(bestProvider);
//
//            locationManager.requestLocationUpdates(bestProvider, 20000, 0,  this);
//            System.out.println("location:"+location);
//            if (location != null) {
//                onLocationChanged(location);
//                System.out.println("location:"+location);
//
//                //locationManager.requestLocationUpdates(bestProvider, 20000, 0,  this);
//
//                //Toast.makeText(this, "GPS is Enabled in your devide", Toast.LENGTH_SHORT).show();
//
//                //}
//            }
//        }
//        else{
//            //showGPSDisabledAlertToUser();
//        }
//    }
    private boolean checkPermission() {
        boolean flag = true;
        String[] permissions = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.RECEIVE_SMS"};
        if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
                mGoogleApiClient, mLocationRequest, (com.google.android.gms.location.LocationListener) this);

    }

    /**
     * Stopping location updates
     */
    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, (com.google.android.gms.location.LocationListener) this);
    }

    /**
     * Google api callback methods
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
    }
}
