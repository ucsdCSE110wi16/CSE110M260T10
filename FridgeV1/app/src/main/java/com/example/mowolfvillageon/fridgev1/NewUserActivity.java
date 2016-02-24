package com.example.mowolfvillageon.fridgev1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class NewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_new_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void createNewUser(View v) {
        EditText etNewUserName = (EditText) findViewById(R.id.EditTextNewUserName);
        EditText etNewUserEmail = (EditText) findViewById(R.id.EditTextNewUserEmail);
        EditText etNewUserPassword = (EditText) findViewById(R.id.EditTextNewUserPassword);
        String userName = etNewUserName.getText().toString();
        String userEmail = etNewUserEmail.getText().toString();
        String userPassword = etNewUserPassword.getText().toString();

        Firebase myFirebaseRef = new Firebase("https://fridge-it2.firebaseio.com");

        myFirebaseRef.createUser(userEmail, userPassword, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                Toast.makeText(NewUserActivity.this, "Successfully created user account with uid: " + result.get("uid"), Toast.LENGTH_SHORT).show();
                System.out.println("Successfully created user account with uid: " + result.get("uid"));
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }
            @Override
            public void onError(FirebaseError firebaseError) {
                // there was an error
                Toast.makeText(NewUserActivity.this, "Unsuccessful in creating a new user account.\n" +
                        "Make sure the email entered is valid and has an @ sign", Toast.LENGTH_LONG).show();
                System.out.println("Unsuccessful in creating a new user account");
               // startActivity(new Intent(getApplicationContext(), NewUserActivity.class));
            }
        });

       // Intent output = new Intent();
       // setResult(RESULT_OK, output);
       // finish();
    }

}
