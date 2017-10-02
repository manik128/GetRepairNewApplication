package com.atss.getrepairnewapplication.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.atss.getrepairnewapplication.Mainclass;
import com.atss.getrepairnewapplication.R;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class Splash extends AppCompatActivity  implements LocationListener {
    Geocoder geocoder;
    List<Address> addresses = null;
    Mainclass mclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mclass=(Mainclass) getApplicationContext();
        checkPermission();
        gpstrack();

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

	    	                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, 1000);



    }
    private boolean checkPermission() {
        boolean flag = true;
        String[] permissions = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        mclass.setLat(latitude);
        mclass.setLang(longitude);

        geocoder = new Geocoder(this);
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            System.out.println(addresses.get(0).getSubLocality()+addresses.get(0).getLocality()+addresses.get(0).getAdminArea());
            mclass.setLocadd(addresses.get(0).getSubLocality());
            mclass.setAddress(addresses.get(0).getSubLocality()+","+addresses.get(0).getLocality()+","+addresses.get(0).getAdminArea());
        }
        catch (IOException ex) {
            ex.printStackTrace();


        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();

        }
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
    public void gpstrack() {
        LocationManager locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        //String bestProvider = locationManager.getBestProvider(criteria, true);

        //client = new GoogleApiClient.Builder(this).addApi(LocationServices.API).build();
        //mGoogleApiClient.connect();
        checkPermission();

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 20000, 0,  this);
            System.out.println("location:"+location);
            if (location != null) {
                onLocationChanged(location);
                System.out.println("location:"+location);

                //locationManager.requestLocationUpdates(bestProvider, 20000, 0,  this);

                //Toast.makeText(this, "GPS is Enabled in your devide", Toast.LENGTH_SHORT).show();

                //}
            }
        }
        else{
            //showGPSDisabledAlertToUser();
        }
    }
}
