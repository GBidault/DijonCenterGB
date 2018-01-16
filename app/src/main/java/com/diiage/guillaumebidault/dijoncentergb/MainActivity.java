package com.diiage.guillaumebidault.dijoncentergb;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.diiage.guillaumebidault.dijoncentergb.adapter.ParcourtAdapter;
import com.diiage.guillaumebidault.dijoncentergb.adapter.PoiAdapter;
import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Parcourt;
import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Poi;
import com.diiage.guillaumebidault.dijoncentergb.dao.ParcourtDao;
import com.diiage.guillaumebidault.dijoncentergb.service.ApiGetPoisTask;

import java.util.List;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {

    Button mBtnLstPoi;
    Button mBtnAddParcourt;

    Parcourt mParcourt;
    ParcourtDao mParcourtDao;

    ListView mListViewParcourt;
    final int REQUEST_CODE_ASK_PERMISSIONS = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Definition des variables object par rapport a l'interface
        mBtnLstPoi=(Button)findViewById(R.id.btn_main_lstPoi);
        mBtnAddParcourt=(Button)findViewById(R.id.btn_main_addParcourt);

        mParcourt=new Parcourt();
        mParcourtDao=new ParcourtDao(this);

        mListViewParcourt=(ListView)findViewById(R.id.lst_main_parcourt);

        //Recuperation des la liste des parcours sauvegardé
        mParcourtDao.open();
        List<Parcourt> parc=mParcourtDao.getParcourts();
        mParcourtDao.close();
        ParcourtAdapter parcourtAdapter=new ParcourtAdapter(MainActivity.this,parc);
        mListViewParcourt.setAdapter(parcourtAdapter);

        //Demande d'autorisation pour l'acces aux SMS
        int test=ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.RECEIVE_SMS);
        if(ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.RECEIVE_SMS}, REQUEST_CODE_ASK_PERMISSIONS);
        }

        //Récuperation des données MyHearth
        Cursor cursor=getContentResolver().query(Uri.parse("content://fr.diiage.bidault.myhealth.PersonneProvider/personne/"),null,"",new String[]{},null);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                int test1=cursor.getInt(0);
                cursor.moveToNext();
            }
        }else{
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, "Application MyHearth Introuvable", duration);
            toast.show();
        }

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

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
