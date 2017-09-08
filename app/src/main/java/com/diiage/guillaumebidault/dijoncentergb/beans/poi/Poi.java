package com.diiage.guillaumebidault.dijoncentergb.beans.poi;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by GuillaumeBidault on 08/09/2017.
 */

public class Poi {
    String id;
    String type;
    String name;
    Location location;

    public Poi(JSONObject jsonObject) throws JSONException {
        id=jsonObject.getString("id");
        type=jsonObject.getString("type");
        name=jsonObject.getString("name");
        location=new Location(jsonObject.getJSONObject("location"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
