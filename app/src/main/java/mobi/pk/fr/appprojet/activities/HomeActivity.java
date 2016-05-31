package mobi.pk.fr.appprojet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.model.LatLng;

import mobi.pk.fr.activities.R;
import mobi.pk.fr.appprojet.business.MetroMobiliteAPIAdapter;

public class HomeActivity extends AppCompatActivity {

    //private MetroMobiliteAPIAdapter metroMobiliteAPIAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //metroMobiliteAPIAdapter = new MetroMobiliteAPIAdapter(this);

        // buttonProximity
        Button buttonProximity = (Button) this.findViewById(R.id.buttonProximity);
        buttonProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proximity = new Intent(v.getContext(), ProximityActivity.class);
                startActivity(proximity);

                //LatLng position = new LatLng(45.191513, 5.714254);
                //metroMobiliteAPIAdapter.findNearestStations(position);
            }
        });
    }
}
