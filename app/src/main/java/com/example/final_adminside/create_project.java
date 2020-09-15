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

public class create_project extends AppCompatActivity {

    EditText editTextProjectname, editTextDescription, editTextdate, editTextplace;
    Button buttonsavedata, addimage;

    DatabaseReference mdatabaseAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

        getSupportActionBar().setTitle("Create Project");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        mdatabaseAdmin = FirebaseDatabase.getInstance().getReference("projectDetails");

        editTextProjectname =  findViewById(R.id.project_name);
        editTextDescription =  findViewById(R.id.project_description);
        editTextdate =  findViewById(R.id.project_date);
        editTextplace =  findViewById(R.id.project_place);
        buttonsavedata =  findViewById(R.id.btnprojectsave);
        addimage = findViewById(R.id.btnprojectimage);

        buttonsavedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addproject();

            }
        });
        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addprojectimage();
            }
        });
    }

    private void addproject(){
        String projectname = editTextProjectname.getText().toString().trim();
        String projectdescription = editTextDescription.getText().toString().trim();
        String projectdate = editTextdate.getText().toString().trim();
        String projectplace = editTextplace.getText().toString().trim();
        //mdatabaseAdmin.push().setValue(projectDetails);

        if (!TextUtils.isEmpty(projectname) && !TextUtils.isEmpty(projectdescription) && !TextUtils.isEmpty(projectdate) && !TextUtils.isEmpty(projectplace)){
            String pid;
            pid = mdatabaseAdmin.push().getKey();

            projectDetails projectDetails1 = new projectDetails(pid, projectname, projectdescription, projectdate, projectplace);

            assert pid != null;
            mdatabaseAdmin.child(pid).setValue(projectDetails1);

            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Fields should not be empty", Toast.LENGTH_LONG).show();
        }


    }

    public void addprojectimage(){

        Intent intent = new Intent(this, Project_upload_image.class);
        startActivity(intent);
    }

}
