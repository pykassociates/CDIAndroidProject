package mobi.pk.fr.appprojet.business;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import mobi.pk.fr.appprojet.entity.Station;

/**
 * Created by kpareau on 10/05/2016.
 */
public class MetroMobiliteAPIAdapter {
    private AsyncRestManager asyncRestManager;
    private final static String BASE_URL = "http://data.metromobilite.fr/api";

    public MetroMobiliteAPIAdapter(GoogleMap map, Context context) {
        asyncRestManager = new AsyncRestManager(map, context);
    }

    public void findNearestStations(LatLng currentPosition) {
        // Build the URL
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(BASE_URL);
        urlBuilder.append("/linesNear/json?");
        urlBuilder.append("x=" + currentPosition.longitude);
        urlBuilder.append("&y=" + currentPosition.latitude);
        urlBuilder.append("&dist=500");
        urlBuilder.append("&details=true");

        // Send request to API metromobilite
        asyncRestManager.execute(urlBuilder.toString(), Station.class.getName());
    }
}
