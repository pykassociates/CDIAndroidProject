package mobi.pk.fr.appprojet.business;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import mobi.pk.fr.appprojet.activities.ProximityActivity;
import mobi.pk.fr.appprojet.utils.Consts;

/**
 * Created by kpareau on 10/05/2016.
 */
public class AsyncRestManager extends AsyncTask<String, Integer, String> {

    private RestClient restClient;
    private Context context;
    private GoogleMap map;

    public AsyncRestManager(GoogleMap map, Context context) {
        restClient = new RestClient();
        this.context = context;
        this.map = map;
    }

    @Override
    protected String doInBackground(String... params) {
        String url = params[0];
        String result = restClient.sendGetRequest(url);
        return result;
        //Map<String, String> mapToReturn = new HashMap<String, String>();
        //mapToReturn.put(params[1], stationsAsJson);
       // return mapToReturn;
    }

    // Called when doInBackground terminate
    protected void onPostExecute(String result) {
        Log.i(this.getClass().getName() + " : ", result);
        //Intent intent = new Intent(Consts.STRING_FOR_INTENT_CALLBACK);
        //intent.putExtra(RESULT_AS_JSON, result);

        //LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        //context.sendBroadcast(intent);

        //Intent proximity = new Intent(context, ProximityActivity.class);
        //proximity.putExtra(Consts.RESULT_AS_JSON, result);
        //context.startActivity(proximity);
        try {
            List<MarkerOptions> markers = parseJson(result);

            for(MarkerOptions marker : markers) {
                map.addMarker(marker);
            }
        } catch(JSONException e) {
            Log.e("", e.getMessage());
        }
    }

    public List<MarkerOptions> parseJson(String json) throws JSONException {
        JSONArray array = new JSONArray(json);
        List<MarkerOptions> markers = new ArrayList<MarkerOptions>();
        for(int i = 0; i < array.length(); i++) {
            JSONObject station = array.optJSONObject(i);
            double latitude = station.getDouble("lat");
            double longitude = station.getDouble("lon");
            LatLng position = new LatLng(latitude, longitude);
            String title = station.getString("name");
            MarkerOptions marker = new MarkerOptions().position(position).title(title);
            markers.add(marker);
        }
        return markers;
    }

}
