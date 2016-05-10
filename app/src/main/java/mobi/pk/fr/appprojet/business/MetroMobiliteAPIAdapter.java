package mobi.pk.fr.appprojet.business;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import mobi.pk.fr.appprojet.entity.Station;

/**
 * Created by kpareau on 10/05/2016.
 */
public class MetroMobiliteAPIAdapter {
    private RestClient client;

    public MetroMobiliteAPIAdapter() {
        client = new RestClient();
    }

    public List<Station> findNearestStations(LatLng currentPosition) {
        return null;
    }
}
