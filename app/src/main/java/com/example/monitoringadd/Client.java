package com.example.monitoringadd;

import static org.apache.http.params.CoreConnectionPNames.CONNECTION_TIMEOUT;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Client extends AsyncTask<String, String, String> {

    JSONObject object;


    protected void onPreExecute(){
        super.onPreExecute();
        //сделать прикол с загрузкой
    }

    @Override
    protected String doInBackground(String... strings) {

        String content = null;
        URLConnection connection = null;
        try {
            connection =  new URL("http://service.gilenko.net/crcommand/getLatest").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        }catch ( Exception ex ) {
            //content = content + "fewew";
            ex.printStackTrace();
        }
        
        return content;

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);

        try {

            object = new JSONObject(String.valueOf(result));




        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
