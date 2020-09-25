package com.example.final_adminside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class donorrecycler extends AppCompatActivity {

    RecyclerView donorrecview;
    donoradapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donorrecycler);

        getSupportActionBar().setTitle("View Donor");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        donorrecview=(RecyclerView) findViewById(R.id.donorrecyclerview);
        donorrecview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<donormodel> options= new FirebaseRecyclerOptions.Builder<donormodel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("donor_info"), donormodel.class).build();

        adapter = new donoradapter(options);
        donorrecview.setAdapter(adapter);
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
