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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void login(final View v) {
        final EditText etLoginEmail = (EditText) findViewById(R.id.EditTextLoginEmail);
        EditText etLoginPassword = (EditText) findViewById(R.id.EditTextLoginPassword);
        final String loginEmail = etLoginEmail.getText().toString();
        String loginPassword = etLoginPassword.getText().toString();

        Firebase ref = new Firebase("https://fridge-it2.firebaseio.com");
        ref.authWithPassword(loginEmail, loginPassword, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                Toast.makeText(LoginActivity.this, "Login Successful!" , Toast.LENGTH_SHORT).show();
                System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                Button button = (Button) v;
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                // there was an error
                Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                System.out.println("Login Error");
                Button button = (Button) v;
                // startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                etLoginEmail.setText(loginEmail);
            }
        });

    }

}
