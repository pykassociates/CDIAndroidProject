package mobi.pk.fr.appprojet.business;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mobi.pk.fr.appprojet.entity.Station;

/**
 * Created by kpareau on 10/05/2016.
 */
public class AsyncRestManager extends AsyncTask<String, Integer, Map<String, String>> {

    private RestClient restClient;

    public AsyncRestManager() {
        restClient = new RestClient();
    }

    @Override
    protected Map<String, String> doInBackground(String... params) {
        String url = params[0];
        String stationsAsJson = restClient.sendGetRequest(url);
        Map<String, String> mapToReturn = new HashMap<String, String>();
        mapToReturn.put(params[1], stationsAsJson);
        return mapToReturn;
    }

    // Called when doInBackground terminate
    protected void onPostExecute(Map<String, String> map) {
        //TODO : notify Metro
    }

}
