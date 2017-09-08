package com.diiage.guillaumebidault.dijoncentergb;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.diiage.guillaumebidault.dijoncentergb.adapter.PoiAdapter;
import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Poi;
import com.diiage.guillaumebidault.dijoncentergb.service.ApiGetPoisTask;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String URL_POI="https://my-json-server.typicode.com/lpotherat/pois/pois";

    ListView mListPoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListPoi=(ListView)findViewById(R.id.lst_poi);

        new ApiGetPoisTask(){
            @Override
            protected void onPostExecute(List<Poi> pois) {
                PoiAdapter poiAdapter=new PoiAdapter(MainActivity.this,pois);
                mListPoi.setAdapter(poiAdapter);
            }
        }.execute(URL_POI);
    }
}
