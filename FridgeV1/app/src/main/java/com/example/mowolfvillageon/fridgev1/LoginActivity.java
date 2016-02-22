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

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

    public void login(final View v) {
        EditText etLoginEmail = (EditText) findViewById(R.id.EditTextLoginEmail);
        EditText etLoginPassword = (EditText) findViewById(R.id.EditTextLoginPassword);
        String loginEmail = etLoginEmail.getText().toString();
        String loginPassword = etLoginPassword.getText().toString();

        Firebase ref = new Firebase("https://fridge-it.firebaseio.com");
        ref.authWithPassword(loginEmail, loginPassword, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                Button button = (Button) v;
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                // there was an error
                System.out.println("Login Error");
                Button button = (Button) v;
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }

}
