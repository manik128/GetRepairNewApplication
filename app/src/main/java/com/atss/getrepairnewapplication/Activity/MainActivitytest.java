package com.atss.getrepairnewapplication.Activity;

import android.Manifest;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.atss.getrepairnewapplication.MInterface;
import com.atss.getrepairnewapplication.Mainclass;
import com.atss.getrepairnewapplication.Pojoclass.grfont;
import com.atss.getrepairnewapplication.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import android.accounts.AccountManager;
import android.accounts.Account;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.atss.getrepairnewapplication.R.id.etemail;

public class MainActivitytest extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private static final String TAG = MainActivitytest.class.getSimpleName();

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    TextView checkbut, logintext, forgetpass;
    String[] spiltaddr, spiltaddr2;
    private String fulladdr;
    String address = null, province = null, country = null, postalCode = null, knownName = null, local = null, local2 = null;
    private Location mLastLocation;
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sp;
    // Google client to interact with Google API

    SharedPreferences settings;


    ProgressDialog progressDialog;
    // boolean flag to toggle periodic location updates
    private boolean mRequestingLocationUpdates = false;

    private LocationRequest mLocationRequest;
    String url = "http://getrepair.in";
    String id = "", username = "", mail = "", mobile = "", password = "";
    boolean press = true;
    EditText email, pass, name;
    private GoogleApiClient mGoogleApiClient;
    Geocoder geocoder;
    Mainclass mclass;
    List<Address> addresses = null;
    TextInputLayout txtlay, txtlay1, txtlay2;
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
        final Button b1 = (Button) findViewById(R.id.button);
        email = (EditText) findViewById(etemail);
        pass = (EditText) findViewById(R.id.etpassword);
        name = (EditText) findViewById(R.id.etfullname);
        logintext = (TextView) findViewById(R.id.tit);
        checkbut = (TextView) findViewById(R.id.rdbtn);
        forgetpass = (TextView) findViewById(R.id.forpass);
        txtlay = (TextInputLayout) findViewById(R.id.input_layout_fullname);
        txtlay1 = (TextInputLayout) findViewById(R.id.input_layout_email);
        txtlay2 = (TextInputLayout) findViewById(R.id.input_layout_password);
        mclass = (Mainclass) getApplicationContext();

        Activity mContext = MainActivitytest.this;//change this your activity name
        StartLocationAlert startLocationAlert = new StartLocationAlert(mContext);
        grfont gr = new grfont(MainActivitytest.this);
        gr.grfonttxt(checkbut);
        gr.grfonttxt(forgetpass);
        gr.grfontbut(b1);
        gr.grfonttxtinpt(txtlay1);
        gr.grfonttxtinpt(txtlay2);
        gr.grfonttxt(logintext);
        gr.grfonttxtinpt(txtlay);
//        mclass.setName("mahi");
//        mclass.setMobilenumber("8147041121");

        String emails = null;
        String username=null;
        Pattern gmailPattern = Patterns.EMAIL_ADDRESS;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Account[] accounts = AccountManager.get(this).getAccounts();
        for (Account account : accounts) {
            if (gmailPattern.matcher(account.name).matches()) {
                emails = account.name;

            }
        }
        email.setText(emails);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        settings = getSharedPreferences(MainActivitytest.MyPREFERENCES, 0);// 0 - for private mode
        boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);

        if(hasLoggedIn)
        {
            Intent intent = new Intent();
            intent.setClass(MainActivitytest.this, HomePage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            this.finish();//Go directly to main activity.
        }
        else
        {
            Toast.makeText(MainActivitytest.this,"login to Proceed", Toast.LENGTH_LONG).show();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {


                final String emails = email.getText().toString();



                RestAdapter radapter = new RestAdapter.Builder().setEndpoint(url).build();

                MInterface restInt = radapter.create(MInterface.class);


                if (!press) {
                    if (email.getText().toString().equals("") || pass.getText().toString().equals("")) {

                        Snackbar.make(view, "Please enter the form", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        // tvvalidation.setText("Please enter the form");
                    }else if(!validation(emails) ){
                        Snackbar.make(view, "Invalid email or phone number", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    }else {
                        progress();
                        restInt.insertlogin(

                                //Passing the values by getting it from editTexts
                                email.getText().toString(),
                                pass.getText().toString(),


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
                                            //  String vendorid = json_data.getString("venid");
                                            String user = json_data.getString("userid");
                                            //String code1 = json_data.getString("userid");
                                            if (code.equalsIgnoreCase("success")) {
                                                mclass.setUserid(user);
                                                session(user);
                                                // mclass.setVendorid(vendorid);
                                                // mclass.setLogin(true);
                                                Intent n = new Intent(MainActivitytest.this, HomePage.class);
                                                finish();
                                                startActivity(n);
                                            }
                                            else {
                                                Snackbar.make(view, "Wrong Emailid and password", Snackbar.LENGTH_LONG)
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
                                        Toast.makeText(MainActivitytest.this, error.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                    }
                } else {
                    if (name.getText().toString().equals("")
                            || email.getText().toString().equals("") || pass.getText().toString().equals("")) {
                        Snackbar.make(view, "Please enter the form", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        // tvvalidation.setText("Please enter the form");
                    } else if (!validation(emails)) {
                        Snackbar.make(view, "Invalid email or phone number", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    } else {
                        progress();
                        restInt.insertUser(


                                //Passing the values by getting it from editTexts
                                email.getText().toString(),
                                pass.getText().toString(),
                                name.getText().toString(),

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
                                            //  String vendorid = json_data.getString("venid");
                                            String user = json_data.getString("userid");

                                            if (code.equalsIgnoreCase("success")) {


                                                mclass.setUserid(user);
                                                // mclass.setLogin(true);
                                                Intent n = new Intent(MainActivitytest.this, HomePage.class);

                                                startActivity(n);
                                            }else if(code.equalsIgnoreCase("Exist")){
                                                Snackbar.make(view, "Already registered with this emailid/Phone no", Snackbar.LENGTH_LONG)
                                                        .setAction("Action", null).show();

                                            }
                                            else {
                                                Snackbar.make(view, "Wrong Emailid and password", Snackbar.LENGTH_LONG)
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
                                        Toast.makeText(MainActivitytest.this, error.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                    }
                }
            }

        });
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivitytest.this,Forgotpassword.class);
                startActivity(intent);
            }
        });
        checkbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(press==true) {
                    Drawable img = getBaseContext().getResources().getDrawable(R.drawable.checked);
                    img.setBounds(0, 0,  (int)(img.getIntrinsicWidth()),(int)(img.getIntrinsicHeight()));
                    b1.setText("Login");
                    checkbut.setCompoundDrawables(img, null, null, null);
                    press=false;
                    txtlay.setVisibility(View.INVISIBLE);

                }
                else{
                    Drawable img = getBaseContext().getResources().getDrawable(R.drawable.dots_clear);
                    img.setBounds(0, 0, (int)(img.getIntrinsicWidth()),  (int)(img.getIntrinsicWidth()));
                    b1.setText("Register");
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
    public void session(String nm)
    {

        SharedPreferences.Editor editor = settings.edit();
        //Toast.makeText(LoginPage.this,"welcome", Toast.LENGTH_LONG).show();

        //Set "hasLoggedIn" to true
        editor.putBoolean("hasLoggedIn", true);
        editor.putString("userid",nm);
        // Commit the edits!
        editor.commit();
    }
    //    private boolean isValidPhonenumber(String number) {
//        String regEx = "^[0-9]{11,12}$";
//        return number.matches(regEx);
//        if (number !=null && number.length()<=10&&number.length()>=10){
//            return true;
//        }
//        return false;
//    }
//    private boolean isValidEmail(String email) {
//
//        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//        Pattern pattern= Pattern.compile(EMAIL_PATTERN);
//        Matcher matcher=pattern.matcher(email);
//        return matcher.matches();
//    }
    public boolean validation(String email) {
        String regEx = "[0-9]+";
        //return email.matches(regEx);
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern= Pattern.compile(EMAIL_PATTERN);
        Matcher matcher=pattern.matcher(email);
        Pattern pattern1= Pattern.compile(regEx);
        Matcher matcher1=pattern1.matcher(email);
        if(matcher.matches()){
            return true;
        }
        else if(matcher1.matches()){
            return true;
        }
        else
        {
            return false;
        }
        // return matcher.matches();
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
            geocoder = new Geocoder(MainActivitytest.this);
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
                Toast.makeText(MainActivitytest.this, "pin" +address, Toast.LENGTH_SHORT).show();
            } catch (IOException ex) {
                ex.printStackTrace();


            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();

            }

        }
    }
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(MainActivitytest.this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, MainActivitytest.this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(MainActivitytest.this,
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                MainActivitytest.this.finish();
            }
            return false;
        }
        return true;
    }
    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;

        Toast.makeText(MainActivitytest.this, "Location changed!",
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
//        LocationManager locationManager = (LocationManager) getSystemService(MainActivitytest.this.LOCATION_SERVICE);
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
        if (ActivityCompat.checkSelfPermission(MainActivitytest.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivitytest.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
    public void progress(){
        progressDialog = new ProgressDialog(MainActivitytest.this);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Loading ...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        progressDialog.setMax(100);
        progressDialog.show();
    }
}
