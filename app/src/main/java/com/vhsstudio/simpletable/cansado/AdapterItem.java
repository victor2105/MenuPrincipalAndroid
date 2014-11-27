package com.vhsstudio.simpletable.cansado;


import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by VictorHS on 10/26/2014.
 */
public class AdapterItem extends ArrayAdapter<Item> {
    Context context;
    int itemResourceId;
    List<Item> objects;


    public AdapterItem(Context context, int itemResourceId, List<Item> objects) {
        super(context, itemResourceId, objects);
        this.context = context;
        this.itemResourceId = itemResourceId;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(itemResourceId, parent, false);
        }

        Item item = objects.get(position);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView valueEsperado = (TextView) convertView.findViewById(R.id.valueExpected);
        TextView valueActual = (TextView) convertView.findViewById(R.id.valueActual);

        name.setText(item.getItemName());



        return convertView;

    }
}
