package com.example.its.citymap;

import android.content.Intent;
import android.location.Location;
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

public class CityMap extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    String city = "";
    MapFragment mf;
    GoogleMap map;
    private GoogleApiClient mGoogleApiClient;
    private Location mLocation;
    private double myLat;
    private double myLon;
    GPSTracker gps;

    public void setCity(String city)
    {
        this.city = city;
    }

    public void showMap()
    {
        mf = (MapFragment) getFragmentManager().findFragmentById(R.id.the_map);
        if (mf == null) {
            Intent intent = new Intent(this, MapActivity.class);
            intent.putExtra("city", city);
            startActivity(intent);
        } else {
            // CityMApFragment (Fragment B) is in the layout (tablet layout)
            mf.getMapAsync(this);

        }
    }

    @Override
    public void onMapReady(GoogleMap map) {    // map is loaded but not laid out yet
        this.map = map;
        double lat = 0, lon = 0;

        if (city.equals("My Location")) {
            lat = mLocation.getLatitude();
            lon = mLocation.getLongitude();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_city_map, menu);
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
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLocation != null) {
            myLat= mLocation.getLatitude();
            myLon= mLocation.getLongitude();
        } else {
            Toast.makeText(this, "Location not Detected", Toast.LENGTH_SHORT).show();
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
