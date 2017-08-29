package com.google.android.gms.nearby.messages.samples.nearbydevices;

import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by kevincho on 4/26/17.
 */

public class ConnectionTask extends AsyncTask<String, Void, Void> {
    protected Void doInBackground(String... params) {
        try {
            //creating a URL to use
            URL url = new URL(params[0]);
            //connecting to URL. The parameters are literally in the URL to use
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream aInputStream = connection.getInputStream();
        }

        catch (Exception e) {
            //whatever logging here
        }
        return null;

    }

}
