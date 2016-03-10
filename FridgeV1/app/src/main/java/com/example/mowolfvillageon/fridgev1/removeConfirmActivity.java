package com.example.mowolfvillageon.fridgev1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class removeConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_confirm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        final String text = "Do you want to delete " + extras.getString("item") + "?";
        setContentView(R.layout.activity_remove_confirm);
        TextView  confirmText = (TextView) findViewById(R.id.confirmation);
        confirmText.setText(text);
    }

    public void onRemoveYesClick(View V) {
        //create firebase reference to the food item
        Bundle extras = getIntent().getExtras();
        final String loginPassword = extras.getString("loginPassword");
        final String item = extras.getString("item");

        Firebase removeItemRef = new Firebase("https://fridge-it2.firebaseio.com/" + loginPassword + "/" + item);

        //remove the food item
        removeItemRef.setValue(null);
        Toast.makeText(removeConfirmActivity.this, "Removed " + item, Toast.LENGTH_SHORT).show();

        Intent ir = new Intent(getApplicationContext(), RemoveActivity.class);
        ir.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ir.putExtra("loginPassword", loginPassword);
        startActivity(ir);
    }

    public void onRemoveNoClick(View V) {
        finish();
    }

}
