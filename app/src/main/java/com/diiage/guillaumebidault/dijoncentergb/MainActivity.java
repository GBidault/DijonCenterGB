package com.diiage.guillaumebidault.dijoncentergb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.diiage.guillaumebidault.dijoncentergb.adapter.PoiAdapter;
import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Poi;
import com.diiage.guillaumebidault.dijoncentergb.service.ApiGetPoisTask;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mBtnLstPoi;
    Button mBtnAddParcourt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Definition des variables object par rapport a l'interface
        mBtnLstPoi=(Button)findViewById(R.id.btn_main_lstPoi);
        mBtnAddParcourt=(Button)findViewById(R.id.btn_main_addParcourt);

        //Instanciation des listener pour les boutons
        mBtnLstPoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),ListPoiActivity.class);
                startActivity(intent);
            }
        });

        mBtnAddParcourt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),AddParcourtActivity.class);
                startActivity(intent);
            }
        });
    }
}
