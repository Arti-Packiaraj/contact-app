package com.example.hp.list;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Defining android ListView
    ListView mListView;

    //Elements that will be displayed in android ListView
    String[] contacts = new String[]{"ABC", "XYZ", "Tris",
            "Harry", "Al", "Kabir", "Four", "Name1"};
    double[] numbers = new double[]{8095566491L, 8390178936L, 6453829012L, 5368929821L, 9023536273L, 8964738745L, 8792349078L, 9456720912L};
    int[] contactpic = new int[]{R.drawable.secondpic, R.drawable.secondpic,
            R.drawable.secondpic, R.drawable.secondpic,
            R.drawable.secondpic, R.drawable.secondpic, R.drawable.secondpic,
            R.drawable.secondpic};
    ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(contacts));
    ArrayList<Integer> intList = new ArrayList<Integer>();
    ArrayList<Double> doubleList = new ArrayList<Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        for (int index = 0; index < contactpic.length; index++) {
            intList.add(contactpic[index]);
            doubleList.add(numbers[index]);
        }
        final CustomAdapter custom = new CustomAdapter(this, intList, stringList);
        mListView.setAdapter(custom);
        Button addcontacts = (Button) findViewById(R.id.addbutton);

        addcontacts.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                
                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.activity_main4, null);
                final EditText etUsername = (EditText) alertLayout.findViewById(R.id.entername);
                final EditText etcontactnumber = (EditText) alertLayout.findViewById(R.id.enternumber);
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("ADD CONTACT");
                alert.setView(alertLayout);
                alert.setCancelable(false);
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String user = etUsername.getText().toString();
                        String usern = etcontactnumber.getText().toString();
                        stringList.add(user);
                        intList.add(intList.get(0));
                        custom.notifyDataSetChanged();
                        double usernum = Double.parseDouble(usern);
                        doubleList.add(usernum);
                        Toast.makeText(getBaseContext(), "Contact " + user+ "added", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                custom.notifyDataSetChanged();
                final int itemPosition = position;
                String itemValue = (String) mListView.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("contactpics", intList.get(position));
                intent.putExtra("contacts", stringList.get(position));
                intent.putExtra("numbers", doubleList.get(position));
                startActivity(intent);

            }

        });


        //mListView.setLongClickable(true);
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View v, final int position, long id) {
                //The position where the list item is clicked is obtained from the
                //the parameter position of the android listview
                int itemPosition = position;
                //Get the String value of the item where the user clicked
                String itemValue = (String) mListView.getItemAtPosition(position);
                AlertDialog.Builder alert = new AlertDialog.Builder(
                        MainActivity.this);
                alert.setTitle("Alert!!");
                alert.setMessage("Are you sure to delete record");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        stringList.remove(stringList.get(position));
                        intList.remove(intList.get(position));
                        custom.notifyDataSetChanged();
                        doubleList.remove(doubleList.get(position));
                        dialog.dismiss();

                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alert.show();

                return true;
            }
        });
    }
}

