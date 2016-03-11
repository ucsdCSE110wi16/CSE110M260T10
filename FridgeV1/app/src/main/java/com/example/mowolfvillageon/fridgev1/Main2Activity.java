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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
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
    private int count;
    protected ArrayList<String> foodNames = new ArrayList<>();
    SearchView sv;  //initializing the SearchView
    ArrayAdapter<String> adapter; //moved initialization of adapter so it can be reached by SearchView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        count =0;
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        populateListView();

        Spinner spinSorter = (Spinner) findViewById(R.id.sortSpinner);

        // Catagory Spinner - Set up
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.sort_categories,
                R.layout.custom_textview);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSorter.setAdapter(categoryAdapter);

    }

    private void populateListView() {
        // Create Fridge List of items
        //String[] starterFoods = {"Apple", "Chicken", "Water"};

        // Set up adapter

        Bundle extras = getIntent().getExtras();
        final String loginPassword = extras.getString("loginPassword");

        final Firebase myFirebaseRef = new Firebase("https://fridge-it2.firebaseio.com/");

        //Check if child exists, so that data is not overwritten
        if(myFirebaseRef.child(loginPassword) == null) {
            myFirebaseRef.child(loginPassword).setValue(loginPassword);
        }

        Firebase ref = new Firebase("https://fridge-it2.firebaseio.com/" + loginPassword);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    String foodName = (String) child.child("name").getValue();
                    foodNames.add(foodName);
                    count++;
                }
                adapter = new ArrayAdapter<>(
                        Main2Activity.this,
                        R.layout.custom_textview, // layout being created, custom_textview for white text
                        foodNames); //items to add to list

                ListView list = (ListView) findViewById(R.id.listViewFridge);
                list.setAdapter(adapter);
                //Collections.sort(foodNames);

                //Click on items for its details
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View v, int position,
                                            long arg3) {
                        //Obtain string representation of food item to remove
                        String value = (String) adapter.getItemAtPosition(position);
                        Intent i = new Intent(getApplicationContext(), ItemInfo.class);
                        i.putExtra("value", value);
                        i.putExtra("loginPassword", loginPassword);
                        startActivity(i);
                        Toast.makeText(Main2Activity.this, value, Toast.LENGTH_SHORT).show();

                    }
                });

                //Filtering-styled search function
                sv = (SearchView) findViewById(R.id.searchView);
                //search text color to white
                int id = sv.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
                TextView textView = (TextView) sv.findViewById(id);
                textView.setTextColor(Color.WHITE);
                //sv.setIconifiedByDefault(false);




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

        Bundle extras = getIntent().getExtras();
        String loginPassword = extras.getString("loginPassword");

        Intent i = new Intent(getApplicationContext(), InsertActivity.class);
        i.putExtra("loginPassword", loginPassword);
        startActivity(i);
    }

    // Button for removing an Item
    public void onRemoveItemButtonClick(View v){
        Button button = (Button) v;

        Bundle extras = getIntent().getExtras();
        String loginPassword = extras.getString("loginPassword");

        Intent i = new Intent(getApplicationContext(), RemoveActivity.class);
        i.putExtra("loginPassword", loginPassword);
        startActivity(i);
    }

    // Logout Button
    public void onLogOutButtonClick(View v){
        Button button = (Button) v;
        Toast.makeText(Main2Activity.this, "Logged Out Successful!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
    }

    public void onSortList(View v) {
        Firebase ref = new Firebase("https://fridge-it2.firebaseio.com/");
        Spinner spinSortChoice = (Spinner) findViewById(R.id.sortSpinner);

        spinSortChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String SortChoice = parent.getItemAtPosition(position).toString();
                Toast.makeText(Main2Activity.this, SortChoice, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        final String SortChoice = spinSortChoice.getSelectedItem().toString();
        Toast.makeText(Main2Activity.this, SortChoice + "KK", Toast.LENGTH_SHORT).show();

        if (SortChoice.equals("A->Z")) {
            Toast.makeText(Main2Activity.this, "A->Z", Toast.LENGTH_SHORT).show();
        }
        else if (SortChoice.equals("Category")){
            ref.orderByChild("Category");
            Toast.makeText(Main2Activity.this, "Category", Toast.LENGTH_SHORT).show();


        }
        else if (SortChoice.equals("Expiration Date")) {
            Toast.makeText(Main2Activity.this, "Expiration Date", Toast.LENGTH_SHORT).show();
        }
        else if (SortChoice.equals("Owner")) {
            Toast.makeText(Main2Activity.this, "Owner", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(Main2Activity.this, "HELLLOOOO", Toast.LENGTH_SHORT).show();
        }

    }
    public int getDatabaseCount() {
        return count;

    }
}
