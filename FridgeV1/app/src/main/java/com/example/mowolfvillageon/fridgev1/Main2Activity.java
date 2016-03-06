package com.example.mowolfvillageon.fridgev1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main2Activity extends AppCompatActivity {

    protected ArrayList<String> foodNames = new ArrayList<>();
    SearchView sv;  //initializing the SearchView
    ArrayAdapter<String> adapter; //moved initialization of adapter so it can be reached by SearchView

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
                adapter = new ArrayAdapter<>(
                        Main2Activity.this,
                        R.layout.custom_textview, // layout being created, custom_textview for white text
                        foodNames); //items to add to list

                ListView list = (ListView) findViewById(R.id.listViewFridge);
                list.setAdapter(adapter);
                Collections.sort(foodNames);
                

                //Filtering-styled search function
                sv = (SearchView) findViewById(R.id.searchView);
                //search text color to white
                int id = sv.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
                TextView textView = (TextView) sv.findViewById(id);
                textView.setTextColor(Color.WHITE);

                sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String text) {
                        //autogenerated method. Unused.
                        return false;
                    }

                    //If we're to change the type of object foodName is, we may have to change parameter type
                    @Override
                    public boolean onQueryTextChange(String text) {

                        adapter.getFilter().filter(text);

                        return false;
                    }
                });
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
