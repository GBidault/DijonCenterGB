package com.diiage.guillaumebidault.dijoncentergb.beans.poi;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by GuillaumeBidault on 08/09/2017.
 */

public class Position {
    double lat;
    double lon;

    public Position(JSONObject jsonObject) throws JSONException {
        this.lat=jsonObject.getDouble("lat");
        this.lon=jsonObject.getDouble("lon");
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
