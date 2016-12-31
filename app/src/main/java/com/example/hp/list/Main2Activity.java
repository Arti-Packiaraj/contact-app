package com.example.hp.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView imageView= (ImageView) findViewById(R.id.contactpic);
        TextView contactname=(TextView) findViewById(R.id.pebble);
        TextView contactnum=(TextView) findViewById(R.id.cal);
        Intent i = getIntent();
        int FlagId = i.getIntExtra("contactpics",0);
        imageView.setImageResource(FlagId);
        //String a=i.getStringArrayExtra("contacts");
        String contactnam=i.getStringExtra("contacts");
        contactname.setText(contactnam);
        double contactnm=i.getDoubleExtra("numbers", 0);
        contactnum.setText(String.valueOf((long)contactnm));

    }
}
