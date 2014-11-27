package com.vhsstudio.simpletable.cansado;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by VictorHS on 10/26/2014.
 */
public class AdapterTable extends ArrayAdapter<Table> {
    Context context;
    int itemResourceId;
    List<Table> objects;


    public AdapterTable(Context context, int itemResourceId, List<Table> objects) {
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
            convertView.setLayoutParams(new GridView.LayoutParams(150, 150));
            convertView.setPadding(5,5,5,5);


        }
        /*


        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150)); // 85, 85
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5); //8, 8, 8, 8
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(R.drawable.table);
        return imageView;*/

        TextView textView = (TextView) convertView.findViewById(R.id.textView);

        String name = objects.get(position).getName();

        textView.setText(name);
        return convertView;
    }

}
