package com.diiage.guillaumebidault.dijoncentergb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.diiage.guillaumebidault.dijoncentergb.adapter.PoiAdapter;
import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Poi;
import com.diiage.guillaumebidault.dijoncentergb.service.ApiGetPoisTask;

import java.util.List;

public class ListPoiActivity extends AppCompatActivity {

    private static final String URL_POI="https://my-json-server.typicode.com/lpotherat/pois/pois";

    ListView mListPoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_poi);

        mListPoi=(ListView)findViewById(R.id.lst_poi);

        new ApiGetPoisTask(){
            @Override
            protected void onPostExecute(List<Poi> pois) {
                PoiAdapter poiAdapter=new PoiAdapter(ListPoiActivity.this,pois);
                mListPoi.setAdapter(poiAdapter);
            }
        }.execute(URL_POI);

        mListPoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Poi item=(Poi)adapterView.getAdapter().getItem(i);
                Intent intent=new Intent(getBaseContext(),DetailPoiActivity.class);
                intent.putExtra("Poi",item);
                startActivity(intent);

            }
        });
    }
}
