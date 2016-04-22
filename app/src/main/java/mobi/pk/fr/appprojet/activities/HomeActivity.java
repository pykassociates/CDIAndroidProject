package mobi.pk.fr.appprojet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mobi.pk.fr.activities.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // buttonProximity
        Button buttonProximity = (Button) this.findViewById(R.id.buttonProximity);
        buttonProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proximity = new Intent(v.getContext(), ProximityActivity.class);
                startActivity(proximity);
            }
        });
    }
}
