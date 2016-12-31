package com.example.hp.list;

import android.content.Intent;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.message;
import static com.example.hp.list.R.id.contactpic;

public class Addcontact extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        EditText editname = (EditText) findViewById(R.id.newcontactname);
         final String editnam = editname.getText().toString();
        final Intent i = getIntent();
        Button OK = (Button) findViewById(R.id.ok);

        OK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent backintent = new Intent(getApplicationContext(), MainActivity.class);
                backintent.putExtra("updatedcontactname", editnam);
                startActivity(backintent);
                //finish();
            }
        });
    }
}