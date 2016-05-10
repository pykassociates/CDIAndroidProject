package mobi.pk.fr.appprojet.business;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by kpareau on 10/05/2016.
 */
public class RestClient {

    private Gson gson;

    public RestClient() {
        gson = new Gson();
    }

    public List<String> sendGetRequest(String urlAsString) {
        try {
            URL url = new URL(urlAsString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = urlConnection.getInputStream();
                if(inputStream != null) {
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    return gson.fromJson(reader, new TypeToken<List<String>>(){}.getType());
                }
            }
        } catch(Exception e) {
            Log.e("HTTP ERROR", "Error while trying to connect to web service : "  + urlAsString);
        }
        return null;
    }

}
