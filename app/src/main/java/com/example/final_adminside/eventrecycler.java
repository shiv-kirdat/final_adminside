package com.example.final_adminside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class eventrecycler extends AppCompatActivity {

    RecyclerView recview;
    myadapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventrecycler);

        getSupportActionBar().setTitle("View Events");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recview=(RecyclerView) findViewById(R.id.recyclerview2);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options= new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("event"), model.class).build();

        adapter = new myadapter(options);
        recview.setAdapter(adapter);




    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}
