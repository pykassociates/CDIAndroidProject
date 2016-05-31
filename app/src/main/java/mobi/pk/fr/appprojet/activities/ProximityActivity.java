package mobi.pk.fr.appprojet.activities;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import mobi.pk.fr.activities.R;
import mobi.pk.fr.appprojet.business.AsyncRestManager;
import mobi.pk.fr.appprojet.business.MetroMobiliteAPIAdapter;
import mobi.pk.fr.appprojet.entity.Station;
import mobi.pk.fr.appprojet.utils.Consts;

public class ProximityActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng position;
    private List<Station> stations = new ArrayList<Station>();
    private LocationManager locationManager;

    private MetroMobiliteAPIAdapter metroMobiliteAPIAdapter;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(getClass().getName(), "Receiving Broadcast");
            String result = intent.getStringExtra(Consts.RESULT_AS_JSON);
            Log.i(getClass().getName(), "Result value : " + result);
            Toast.makeText(context, "OK, ça marche : ", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the JSON from intent
        //Intent proximity = this.getIntent();
        //proximity.getStringExtra(Consts.RESULT_AS_JSON);
        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();


        position = new LatLng(45.191513, 5.714254);
        registerReceiver(receiver, new IntentFilter(Consts.STRING_FOR_INTENT_CALLBACK));

        setContentView(R.layout.activity_proximity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //GetGPSPosition();

        //TODO : chercher position
        //TODO : chercher stations
        //TODO : remplir stations
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Move the camera to Grenoble
        // position = new LatLng(45.191513, 5.714254);
        // Move the camera to last known location
        //GetGPSPosition();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 12));
        mMap.addMarker(new MarkerOptions().position(position));

        metroMobiliteAPIAdapter = new MetroMobiliteAPIAdapter(mMap, this);
        metroMobiliteAPIAdapter.findNearestStations(position);

        //Add markers to stations
        for (Station station : stations) {
            LatLng position = station.getLocation();
            //LatLng position = new LatLng(station.getLocation().latitude(), station.getLocation().longitude());
            mMap.addMarker(new MarkerOptions().position(position).title(station.getName()));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(Consts.STRING_FOR_INTENT_CALLBACK));
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void GetGPSPosition() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
            position = new LatLng(45.191513, 5.714254);
            return;
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
        position = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());

        /*locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 1000, 1, new LocationListener() {
            @Override
              public void onLocationChanged(Location location) {
                if (location.getAccuracy() < 10){

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
        });*/
    }
}
