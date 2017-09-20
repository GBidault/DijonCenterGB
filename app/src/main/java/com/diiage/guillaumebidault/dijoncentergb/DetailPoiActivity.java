package com.diiage.guillaumebidault.dijoncentergb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Poi;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailPoiActivity extends AppCompatActivity implements OnMapReadyCallback {

    TextView mTextName;
    TextView mTextAdress;
    TextView mTextCity;
    TextView mTextPostal;

    private GoogleMap mMap;
    private Poi mPoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_poi);

        mTextName=(TextView)findViewById(R.id.txtName_LstPoi);
        mTextAdress=(TextView)findViewById(R.id.txtAdress_LstPoi);
        mTextCity=(TextView)findViewById(R.id.txtCity_LstPoi);
        mTextPostal=(TextView)findViewById(R.id.txtCodePost_LstPoi);

        mPoi=(Poi)getIntent().getSerializableExtra("Poi");

        mTextName.setText(mPoi.getName());
        mTextAdress.setText(mPoi.getLocation().getAdress());
        mTextPostal.setText(mPoi.getLocation().getPostalCode());
        mTextCity.setText(mPoi.getLocation().getCity());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng marker = new LatLng(mPoi.getLocation().getPosition().getLat(), mPoi.getLocation().getPosition().getLon());
        mMap.addMarker(new MarkerOptions().position(marker).title(mPoi.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,12));

    }
}
