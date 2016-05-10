package mobi.pk.fr.appprojet.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import mobi.pk.fr.activities.R;
import mobi.pk.fr.appprojet.entity.Station;

public class ProximityActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng position;
    private List<Station> stations = new ArrayList<Station>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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

        // Add a marker in Sydney and move the camera
        position = new LatLng(45.191513, 5.714254);
        //for (Station station: stations) {
        //    LatLng position = new LatLng(station.getLocation().getLatitude(), station.getLocation().getLongitude());
        //    mMap.addMarker(new MarkerOptions().position(position).title(station.getName()));
        //}
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 5));

    }
}
