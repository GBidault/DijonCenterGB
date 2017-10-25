package com.diiage.guillaumebidault.dijoncentergb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.diiage.guillaumebidault.dijoncentergb.R;
import com.diiage.guillaumebidault.dijoncentergb.beans.poi.Parcourt;

import java.util.List;

/**
 * Created by GuillaumeBidault on 25/10/2017.
 */

public class ParcourtAdapter extends ArrayAdapter<Parcourt> {

    public ParcourtAdapter(Context context, List<Parcourt> parcourt){
        super(context,0,parcourt);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView==null){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.adapter_parcourt,parent,false);
        }

        ParcourtViewHolder viewHolder=(ParcourtViewHolder)convertView.getTag();
        if(viewHolder==null){
        viewHolder=new ParcourtViewHolder();
        viewHolder.name=(TextView)convertView.findViewById(R.id.txtName_LstRowParcourt);
        convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Parcourt parcourt=getItem(position);
        viewHolder.name.setText(parcourt.getNom());

        return convertView;
    }
}

class ParcourtViewHolder{
    public TextView name;
}

