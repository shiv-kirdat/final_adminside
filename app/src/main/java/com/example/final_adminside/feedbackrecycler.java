package com.example.final_adminside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class feedbackrecycler extends AppCompatActivity {

    RecyclerView feedrecview;
    feedadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackrecycler);

        getSupportActionBar().setTitle("View Feedback");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        feedrecview=(RecyclerView) findViewById(R.id.feedrecyclerview);
        feedrecview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<feedmodel> options= new FirebaseRecyclerOptions.Builder<feedmodel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("feedbackngo22"), feedmodel.class).build();

        adapter = new feedadapter(options);
        feedrecview.setAdapter(adapter);

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
