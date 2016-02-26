package com.example.mowolfvillageon.fridgev1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    protected ArrayList<String> foodNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        populateListView();
    }

    private void populateListView() {
        // Create Fridge List of items
        //String[] starterFoods = {"Apple", "Chicken", "Water"};

        // Set up adapter
        Firebase myFirebaseRef = new Firebase("https://fridge-it2.firebaseio.com/");

        myFirebaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    String foodName = (String) child.child("name").getValue();
                    foodNames.add(foodName);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        Main2Activity.this,
                        R.layout.textlistview, // layout being created
                        foodNames); //items to add to list

                ListView list = (ListView) findViewById(R.id.listViewFridge);
                list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


    }

    // Button for inserting an Item
    public void onAddItemButtonClick(View v){
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), InsertActivity.class));
    }

    // Logout Button
    public void onLogOutButtonClick(View v){
        Button button = (Button) v;
        Toast.makeText(Main2Activity.this, "Logged Out Successful!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

}
