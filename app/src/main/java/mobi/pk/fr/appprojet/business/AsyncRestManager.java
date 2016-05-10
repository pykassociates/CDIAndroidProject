package mobi.pk.fr.appprojet.business;

import android.os.AsyncTask;

import java.util.List;

import mobi.pk.fr.appprojet.entity.Station;

/**
 * Created by kpareau on 10/05/2016.
 */
public class AsyncRestManager extends AsyncTask<String, Integer, List<Object>> {

    private List<Station> stations;
    private RestClient restClient;

    public AsyncRestManager(List<Station> stations) {
        this.stations = stations;
        restClient = new RestClient();
    }

    @Override
    protected List<Object> doInBackground(String... urls) {
        String url = urls[0];
        String stationsAsJson = restClient.sendGetRequest(url);
        return null;
    }

}
