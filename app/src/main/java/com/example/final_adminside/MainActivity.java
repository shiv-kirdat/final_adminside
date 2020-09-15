package com.example.final_adminside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Admin Login");

        email= (EditText)findViewById(R.id.emailid);
        password= (EditText)findViewById(R.id.password);
        login= (Button)findViewById(R.id.login_button);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((email.getText().toString().equals("admin@gmail.com"))
                        && (password.getText().toString().equals("admin123")))
                {
                    Intent intent= new Intent(MainActivity.this,cardmainmenu.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid data",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
