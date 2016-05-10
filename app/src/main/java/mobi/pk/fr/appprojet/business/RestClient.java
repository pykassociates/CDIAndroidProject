package mobi.pk.fr.appprojet.business;

import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kpareau on 10/05/2016.
 */
public class RestClient {

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
            Log.e("HTTP ERROR", "Error while trying to connect to web service : "  + urlAsString + " Message : " + e.getMessage());
        }
        return null;
    }

}
