package com.diiage.guillaumebidault.dijoncentergb;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Parcourt;
import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Poi;
import com.diiage.guillaumebidault.dijoncentergb.dao.ParcourtDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddParcourtActivity extends AppCompatActivity {

    Button mBtnAnnuler;
    Button mBtnValider;
    TextView mTxtNom;
    TextView mTxtAccompagnant;
    Button mBtnCinema;
    Button mBtnRestaurant;

    Parcourt mParcourt;

    ParcourtDao mParcourtDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcourt);

        mParcourt=new Parcourt();
        mParcourtDao=new ParcourtDao(this);


        //Definition des variables object par rapport a l'interface
        mBtnAnnuler=(Button)findViewById(R.id.btn_addParcourt_annuler);
        mBtnValider=(Button)findViewById(R.id.btn_addParcourt_valider);
        mBtnCinema=(Button)findViewById(R.id.btn_addParcourt_cinema);
        mBtnRestaurant=(Button)findViewById(R.id.btn_addParcourt_restaurant);

        mTxtNom=(TextView)findViewById(R.id.txt_addParcourt_nom);
        mTxtAccompagnant=(TextView)findViewById(R.id.txt_addParcourt_accompagnant);

        //Instanciation des listener pour les boutons
        mBtnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mBtnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nom=mTxtNom.getText().toString();
                String Accompagnant=mTxtAccompagnant.getText().toString();
                //Verification des saisie obligatoire
                if(Nom.isEmpty()){
                    mTxtNom.setError("Nom requis");
                    return;
                }

                if(mParcourt.getIdCinema()==null || mParcourt.getIdCinema().isEmpty()){
                    mBtnCinema.setError("Saisie cinema obligatorie");
                    return;
                }

                if(mParcourt.getIdRestaurant()==null || mParcourt.getIdRestaurant().isEmpty()){
                    mBtnCinema.setError("Saisie restaurant obligatorie");
                    return;
                }


                mParcourt.setNom(Nom);
                mParcourt.setAccompagnant(Accompagnant);
                mParcourt.setDateCreation(new Date().toString());
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
                mParcourt.setDatePrevu(mTxtAccompagnant.getText().toString());
                mParcourt.setStatus("A venir");
                mParcourtDao.open();
                mParcourtDao.createParcourt(mParcourt);
                mParcourtDao.close();
                finish();
            }
        });

        mBtnRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listPoiIntent = new Intent(getBaseContext(),ListPoiResultActivity.class);
                listPoiIntent.putExtra("Filtre","REST");
                startActivityForResult(listPoiIntent,1);
            }
        });

        mBtnCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listPoiIntent = new Intent(getBaseContext(),ListPoiResultActivity.class);
                listPoiIntent.putExtra("Filtre","CINE");
                startActivityForResult(listPoiIntent,1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==0)return;
        Poi item=(Poi)data.getSerializableExtra("Poi");
        if(item.getType().equals("CINE")){
            mBtnCinema.setText(item.getName());
            mParcourt.setNomCinema(item.getName());
            mParcourt.setIdCinema(item.getId());
        }
        else if(item.getType().equals("REST")){
            mBtnRestaurant.setText(item.getName());
            mParcourt.setNomRestaurant(item.getName());
            mParcourt.setIdRestaurant(item.getId());
        }
    }
}
