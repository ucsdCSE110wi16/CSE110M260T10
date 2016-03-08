package com.example.mowolfvillageon.fridgev1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class ItemInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String value = extras.getString("value");
        String loginPassword = extras.getString("loginPassword");

        Firebase ref = new Firebase("https://fridge-it2.firebaseio.com/" + loginPassword + "/" + value + "/");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String s = (String) snapshot.child("name").getValue();
                setContentView(R.layout.activity_item_info);
                TextView tvName = (TextView) findViewById(R.id.FoodNameDisplay);
                tvName.setText("Name: " + s);

                s = (String) snapshot.child("catagory").getValue();
                TextView tvCat = (TextView) findViewById(R.id.FoodCategoryDisplay);
                tvCat.setText("Category: " + s);

                s = (String) snapshot.child("expiration").getValue();
                TextView tvExp = (TextView) findViewById(R.id.FoodExpirationDisplay);
                tvExp.setText("Expiration: " + s);

                s = (String) snapshot.child("owner").getValue();
                TextView tvOwner = (TextView) findViewById(R.id.FoodOwnerDisplay);
                tvOwner.setText("Owner: " + s);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

    public void close(View v) {
        finish();

    }

}
