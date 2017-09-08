package com.diiage.guillaumebidault.dijoncentergb.beans.poi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by GuillaumeBidault on 08/09/2017.
 */

public class Location implements Serializable {
    String adress;
    String postalCode;
    String city;
    Position position;

    public Location(JSONObject jsonObject) throws JSONException {
        this.adress=jsonObject.getString("adress");
        this.postalCode=jsonObject.getString("postalCode");
        this.city=jsonObject.getString("city");
        this.position=new Position(jsonObject.getJSONObject("position"));
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCompletteAdress(){
        return adress+" "+postalCode+" "+city;
    }
}
