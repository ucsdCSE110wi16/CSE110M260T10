package com.example.mowolfvillageon.fridgev1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.Firebase;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
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

    public void insert(View button){
        EditText etFoodName = (EditText) findViewById(R.id.EditTextFoodName);
        Spinner etFoodCategory = (Spinner) findViewById(R.id.SpinnerFoodCatagory);
        EditText etFoodOwner = (EditText) findViewById(R.id.EditTextFoodOwner);

        // Food Name
        String FoodName = etFoodName.getText().toString();

        // Food Category
             // Set up
        ArrayAdapter<CharSequence> categoryadapter = ArrayAdapter.createFromResource(this,
                        R.array.food_categories,
                        R.layout.support_simple_spinner_dropdown_item);
        categoryadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        etFoodCategory.setAdapter(categoryadapter);
            // Get Spinner info
        etFoodCategory = (Spinner) findViewById(R.id.SpinnerFoodCatagory);
        etFoodCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String FoodCategory =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Food Owner
        String FoodOwner = etFoodOwner.getText().toString();

        Firebase myFirebaseRef = new Firebase("https://fridge-it2.firebaseio.com/");
        Fruits fruit = new Fruits(FoodOwner, FoodName);
        myFirebaseRef.child(fruit.getName()).setValue(fruit);

        Intent output = new Intent();
        setResult(RESULT_OK, output);
        finish();
    }
}
