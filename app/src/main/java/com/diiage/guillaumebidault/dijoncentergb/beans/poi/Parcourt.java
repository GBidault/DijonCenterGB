package com.diiage.guillaumebidault.dijoncentergb.beans.poi;

import android.content.ContentValues;
import android.database.Cursor;

import java.sql.Date;

/**
 * Created by GuillaumeBidault on 20/09/2017.
 */

public class Parcourt {
    String id;
    String nom;
    String idCinema;
    String nomCinema;
    String idRestaurant;
    String nomRestaurant;
    Date dateCreation;
    Date datePrevu;
    String accompagnant;
    String status;

    public Parcourt() {}

    public Parcourt(Cursor cursor) {
        id=cursor.getString(0);
        nom=cursor.getString(1);
        idCinema=cursor.getString(2);
        nomCinema=cursor.getString(3);
        idRestaurant=cursor.getString(4);
        nomRestaurant=cursor.getString(5);
        dateCreation=Date.valueOf(cursor.getString(6));
        datePrevu=Date.valueOf(cursor.getString(7));
        accompagnant=cursor.getString(8);
        status=cursor.getString(9);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(String idCinema) {
        this.idCinema = idCinema;
    }

    public String getNomCinema() {
        return nomCinema;
    }

    public void setNomCinema(String nomCinema) {
        this.nomCinema = nomCinema;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNomRestaurant() {
        return nomRestaurant;
    }

    public void setNomRestaurant(String nomRestaurant) {
        this.nomRestaurant = nomRestaurant;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDatePrevu() {
        return datePrevu;
    }

    public void setDatePrevu(Date datePrevu) {
        this.datePrevu = datePrevu;
    }

    public String getAccompagnant() {
        return accompagnant;
    }

    public void setAccompagnant(String accompagnant) {
        this.accompagnant = accompagnant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ContentValues getContentValues(){
        ContentValues values=new ContentValues();
        values.put("id",id);
        values.put( "nom",nom);
        values.put( "idCinema",idCinema);
        values.put( "nomCinema",nomCinema);
        values.put( "idRestaurant",idRestaurant);
        values.put( "nomRestaurant",nomRestaurant);
        values.put( "dateCreation",dateCreation.toString());
        values.put( "datePrevu",datePrevu.toString());
        values.put( "accompagnant",accompagnant);
        values.put( "status",status);

        return values;
    }
}
