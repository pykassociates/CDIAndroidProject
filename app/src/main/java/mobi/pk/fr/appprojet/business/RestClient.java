package mobi.pk.fr.appprojet.business;

import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kpareau on 10/05/2016.
 */
public class RestClient {

    private Gson gson;

    public RestClient() {
        gson = new Gson();
    }

    public String sendGetRequest(String urlAsString) {
        try {
            URL url = new URL(urlAsString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = urlConnection.getInputStream();
                if(inputStream != null) {
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    return gson.fromJson(reader, String.class);
                }
            }
        } catch(Exception e) {
            Log.e("HTTP ERROR", "Error while trying to connect to web service : "  + urlAsString);
        }
        return null;
    }

}
