package com.diiage.guillaumebidault.dijoncentergb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Poi;
import com.google.android.gms.maps.GoogleMap;

public class ListPoiActivity extends AppCompatActivity {

    TextView mTextName;
    TextView mTextAdress;
    TextView mTextCity;
    TextView mTextPostal;

    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_poi);

        mTextName=(TextView)findViewById(R.id.txtName_LstPoi);
        mTextAdress=(TextView)findViewById(R.id.txtAdress_LstPoi);
        mTextCity=(TextView)findViewById(R.id.txtCity_LstPoi);
        mTextPostal=(TextView)findViewById(R.id.txtCodePost_LstPoi);

        Poi poi=(Poi)getIntent().getSerializableExtra("Poi");

        mTextName.setText(poi.getName());
        mTextAdress.setText(poi.getLocation().getAdress());
        mTextPostal.setText(poi.getLocation().getPostalCode());
        mTextCity.setText(poi.getLocation().getCity());

    }
}
