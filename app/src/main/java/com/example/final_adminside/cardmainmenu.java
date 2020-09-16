package com.example.final_adminside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class cardmainmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardmainmenu);

        getSupportActionBar().setTitle("Select options");
    }

    public void createProject(View view) {
        Intent intent = new Intent(getApplicationContext(), create_project.class);
        startActivity(intent);
    }

    public void createEvent(View view) {
        Intent intent = new Intent(getApplicationContext(), add_event.class);
        startActivity(intent);
    }

    public void viewproject(View view) {
        Intent intent = new Intent(getApplicationContext(), projectrecycler.class);
        startActivity(intent);
    }

    public void viewEvent(View view) {
        Intent intent = new Intent(getApplicationContext(), eventrecycler.class);
        startActivity(intent);
    }

    public void viewfeedback(View view) {
        Intent intent = new Intent(getApplicationContext(), feedbackrecycler.class);
        startActivity(intent);
    }

    public void viewdonor(View view) {
        Intent intent = new Intent(getApplicationContext(), donorrecycler.class);
        startActivity(intent);
    }
}
