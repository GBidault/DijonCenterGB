package com.diiage.guillaumebidault.dijoncentergb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.diiage.guillaumebidault.dijoncentergb.R;
import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Poi;

import java.util.List;

/**
 * Created by GuillaumeBidault on 08/09/2017.
 */

public class PoiAdapter extends ArrayAdapter<Poi>{

   public PoiAdapter(Context context, List<Poi> poi) {
        super(context, 0, poi);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_poi,parent, false);
        }

        PoiViewHolder viewHolder = (PoiViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new PoiViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.txtName_LstRowPoi);
            viewHolder.lieu = (TextView) convertView.findViewById(R.id.txtLieu_lstRowPoi);
            viewHolder.logo = (ImageView)convertView.findViewById(R.id.imgLogo_LstRowPoi);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Poi poi = getItem(position);
        viewHolder.name.setText(poi.getName());
        viewHolder.lieu.setText(poi.getLocation().getCompletteAdress());
        switch(poi.getType()){
            case "CINE":
                viewHolder.logo.setImageResource(R.drawable.cinema);
                break;
            case "REST":
                viewHolder.logo.setImageResource(R.drawable.resto);
                break;
            default:
                viewHolder.logo.setImageResource(R.drawable.none);
        }

        return convertView;
    }

    private class PoiViewHolder{
        public TextView name;
        public TextView lieu;
        public ImageView logo;
    }

}
