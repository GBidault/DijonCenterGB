package com.diiage.guillaumebidault.dijoncentergb.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GuillaumeBidault on 08/09/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "parcourt.sql";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String requette="CREATE TABLE parcourt ( id VARCHAR PRIMARY KEY NOT NULL , nom VARCHAR NOT NULL , idCinema VARCHAR NOT NULL , nomCinema VARCHAR NOT NULL, idRestaurant VARCHAR NOT NULL , nomRestaurant VARCHAR NOT NULL, dateCreation DATE NOT NULL , datePrevu DATE NOT NULL, accompagnant VARCHAR NOT NULL , status VARCHAR NOT NULL);";
        sqLiteDatabase.execSQL(requette);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
