package com.example.final_adminside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class projectrecycler extends AppCompatActivity {

    RecyclerView projectrecview;
    projectadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectrecycler);

        getSupportActionBar().setTitle("View Projects");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        projectrecview=(RecyclerView) findViewById(R.id.recyclerview1);
        projectrecview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<projectmodel> options= new FirebaseRecyclerOptions.Builder<projectmodel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("projectDetails"), projectmodel.class).build();

        adapter = new projectadapter(options);
        projectrecview.setAdapter(adapter);
    }

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
