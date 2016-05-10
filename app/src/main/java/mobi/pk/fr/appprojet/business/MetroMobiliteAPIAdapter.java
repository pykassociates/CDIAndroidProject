package mobi.pk.fr.appprojet.business;

import com.google.android.gms.maps.model.LatLng;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import mobi.pk.fr.appprojet.entity.Station;

/**
 * Created by kpareau on 10/05/2016.
 */
public class MetroMobiliteAPIAdapter {
    private RestClient restClient;
    private AsyncRestManager asyncRestManager;
    private final static String BASE_URL = "http://data.metromobilite.fr/api";

    public MetroMobiliteAPIAdapter(List<Station> stations) {
        asyncRestManager = new AsyncRestManager(stations);
    }

    public List<Station> findNearestStations(LatLng currentPosition) {
        // Build the URL
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(BASE_URL);
        urlBuilder.append("/linesNear/json?");
        urlBuilder.append("x=" + currentPosition.longitude);
        urlBuilder.append("&y=" + currentPosition.latitude);
        urlBuilder.append("&dist=500");
        urlBuilder.append("&details=true");

        // Send request to API metromobilite
        asyncRestManager.execute(urlBuilder.toString());

        // stations list deserialization
        List<Station> stations = new ArrayList<Station>();
        return stations;
    }
}
