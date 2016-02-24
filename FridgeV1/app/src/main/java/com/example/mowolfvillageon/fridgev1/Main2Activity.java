package com.example.mowolfvillageon.fridgev1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Main2Activity extends AppCompatActivity {

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
        String[] starterFoods = {"Apple", "Chicken", "Water"};

        // Set up adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.textlistview, // layout being created
                starterFoods); // items to add to list

        // Configure List View
        ListView list = (ListView) findViewById(R.id.listViewFridge);
        list.setAdapter(adapter);
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
