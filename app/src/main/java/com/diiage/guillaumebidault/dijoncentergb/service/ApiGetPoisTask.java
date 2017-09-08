package com.diiage.guillaumebidault.dijoncentergb.service;

import android.os.AsyncTask;

import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Poi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuillaumeBidault on 08/09/2017.
 */

public class ApiGetPoisTask extends AsyncTask<String,Void,List<Poi>> {

    private Exception exception;

    @Override
    protected List<Poi> doInBackground(String... urls) {
        List<Poi> pois=null;
        try{
            pois=new ArrayList<>();
            URL urlPoi=new URL(urls[0]);

            URLConnection con=urlPoi.openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            BufferedReader inputStream=new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = inputStream.readLine()) != null){
                responseStrBuilder.append(inputStr);
            }

            JSONArray jsonArray=new JSONArray(responseStrBuilder.toString());

            for (int i=0;i<jsonArray.length();i++){
                pois.add(new Poi(jsonArray.getJSONObject(i)));
            }

        }catch(Exception e){
            this.exception=e;
        }finally {
            return pois;
        }
    }
}
