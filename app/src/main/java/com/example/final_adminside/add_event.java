package com.example.final_adminside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_event extends AppCompatActivity {

    EditText ename,edesc,edate,eaddr;
    Button save,add;

    DatabaseReference myfirebaseproject1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        getSupportActionBar().setTitle("Create Event");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        myfirebaseproject1 = FirebaseDatabase.getInstance().getReference("event");

        ename = findViewById(R.id.event_name);
        edesc =  findViewById(R.id.event_desc);
        edate = findViewById(R.id.event_date);
        eaddr = findViewById(R.id.event_add);
        save=findViewById(R.id.save);
        add=findViewById(R.id.add);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addevent();

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addimage();
            }
        });
    }
    private void addevent(){
        String event_name = ename.getText().toString().trim();
        String event_desc=edesc.getText().toString().trim();
        String event_date= edate.getText().toString().trim();
        String event_addr= eaddr.getText().toString().trim();

        if (!TextUtils.isEmpty(event_name) && !TextUtils.isEmpty(event_desc) && !TextUtils.isEmpty(event_date) && !TextUtils.isEmpty(event_addr)){

            String id;
            id = myfirebaseproject1.push().getKey();

            event event1 = new event(id,event_name,event_desc,event_date,event_addr);

            //  myfirebaseproject1.child("events").child(id).setValue(event1);

            assert id != null;
            myfirebaseproject1.child(id).setValue(event1);

            Toast.makeText(this,"Event added",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Fields should not be empty",Toast.LENGTH_LONG).show();
        }
    }
    public void addimage(){

        Intent intent = new Intent(this, Event_upload_image.class);
        startActivity(intent);
    }
}
