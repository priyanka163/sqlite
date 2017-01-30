package com.example.bridgelabz.sqlitecontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button mAdd, mDelete, mShow;
    EditText mName, mNumber;

    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDelete = (Button) findViewById(R.id.button_delete);
        mAdd = (Button) findViewById(R.id.Button_Add);
        mName = (EditText) findViewById(R.id.Edit_ADd);
        mNumber = (EditText) findViewById(R.id.Edit_Number);
        mShow = (Button) findViewById(R.id.showAll);
        db = new DatabaseHandler(this);


        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Names = mName.getText().toString();
                String Numbers = mNumber.getText().toString();

                Log.d("Insert: ", "Inserting ..");
                db.addContacts(new Contacts(Names, Numbers));


                // Reading all contacts
                Log.d("Reading: ", "Reading all contacts..");
            }
        });


        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.deleteContact(3);
            }
        });

        mShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final List<Contacts> contacts = db.getAllContacts();
                for (Contacts cn : contacts) {
                    String log = "Id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Phone: " +
                            cn.get_phone_number();
                    // Writing Contacts to log
                    Log.d("Name: ", log);
                }

            }
        });


    }
}
