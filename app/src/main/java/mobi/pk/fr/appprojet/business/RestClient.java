package mobi.pk.fr.appprojet.business;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

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
                String json = IOUtils.toString(inputStream);
                return json;
            }
        } catch(Exception e) {
            Log.e("HTTP ERROR", "Error while trying to connect to web service : "  + urlAsString);
        }
        return null;
    }

}
