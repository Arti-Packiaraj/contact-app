package com.example.hp.list;

import android.app.Activity;
import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<String>
{
    public final Activity context;
    public final List<Integer> Imgid;
    public  List<String> names;

    public CustomAdapter(Activity context, List<Integer> Imgid,List<String> names ){
        super(context, R.layout.activity_main3, names);
        this.context = context;
        this.Imgid = Imgid;
        this.names = names;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.activity_main3, null, false);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
        txtTitle.setText(names.get(position));
        imageView.setImageResource(Imgid.get(position));
        return rowView;
    }
    public void register(List<String> names) {
        this.names = names;
        notifyDataSetChanged();
    }
}

