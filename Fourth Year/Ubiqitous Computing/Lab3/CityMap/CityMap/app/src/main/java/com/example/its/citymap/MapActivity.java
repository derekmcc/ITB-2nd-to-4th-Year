package com.example.its.citymap;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    String city = "";
    MapFragment mf;
    GoogleMap map;
    private GoogleApiClient mGoogleApiClient;
    private Location mLocation;
    private double myLat = 0;
    private double myLon = 0;
    private static final int REQUEST_CODE_PERMISSION = 1;
    Context mContext;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    GPSTracker gps;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mContext = this;

        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        } else {
            gps = new GPSTracker(mContext, MapActivity.this);

            // Check if GPS enabled
            if (gps.canGetLocation()) {
                latitude = gps.getLatitude();
                longitude = gps.getLongitude();
            } else {

                gps.showSettingsAlert();
            }
        }
        Intent I = getIntent();
        city = I.getStringExtra("city");
        mf = (MapFragment) getFragmentManager().findFragmentById(R.id.the_map);
        mf.getMapAsync(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Override
    public void onMapReady(GoogleMap map) {    // map is loaded but not laid out yet
        this.map = map;
        // code to run when the map has loaded
        double lat, lon;

        if (city.equals("My Location")) {
            lat = latitude;
            lon = longitude;
        }
        else if (city.equals("Belfast")) {
            lat = 54.602755;
            lon = -5.945180;
        }
        else if (city.equals("Cork")){
            lat = 51.892171;
            lon = -8.475068;
        }
        else if (city.equals("Dublin")) {
            lat = 53.347860;
            lon = -6.272487;
        }
        else if (city.equals("Galway")){
            lat = 53.276533;
            lon = -9.069362;
        }
        else if (city.equals("Kerry")){
            lat = 52.264007;
            lon = -9.686990;
        }
        else if (city.equals("Wexford")){
            lat = 52.336521;
            lon = -6.462855;
        }
        else {
            lat = 0;
            lon = 0;
        }

        map.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lon))
                        .title("")
        );

        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lon)));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 10));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLocation != null) {
            myLat = mLocation.getLatitude();
            myLon = mLocation.getLongitude();
        } else {
            Toast.makeText(this," Lat + long" + myLat + " " + myLon,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("alert", "Connection Suspended");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i("TAG", "Connection failed. Error: " + connectionResult.getErrorCode());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }
}
