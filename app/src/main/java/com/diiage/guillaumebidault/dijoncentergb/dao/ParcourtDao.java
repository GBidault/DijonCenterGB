package com.diiage.guillaumebidault.dijoncentergb.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Parcourt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuillaumeBidault on 20/09/2017.
 */

public class ParcourtDao {
    private SQLiteDatabase mSQLiteDapaBase;
    private DataBaseHelper mDbHelper;

    public ParcourtDao(Context context){
        mDbHelper=new DataBaseHelper(context);
    }

    public void open() throws SQLException {
        mSQLiteDapaBase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mSQLiteDapaBase.close();
    }

    public Parcourt createParcourt(Parcourt parcourt) {
        long insertId = mSQLiteDapaBase.insert("parcourt", null,parcourt.getContentValues());
        Cursor cursor = mSQLiteDapaBase.query("parcourt",new String[]{"*"}, "id" + " = " + insertId, null,null, null, null);
        cursor.moveToFirst();
        Parcourt newParcourt = new Parcourt(cursor);
        cursor.close();
        return newParcourt;
    }

    public List<Parcourt> getParcourts(){
        List<Parcourt> parcours=new ArrayList<>();
        Cursor cursor = mSQLiteDapaBase.query("parcourt",new String[]{"*"},null, null,null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Parcourt parcourt=new Parcourt(cursor);
            parcours.add(parcourt);
            cursor.moveToNext();
        }
        return parcours;
    }

}
