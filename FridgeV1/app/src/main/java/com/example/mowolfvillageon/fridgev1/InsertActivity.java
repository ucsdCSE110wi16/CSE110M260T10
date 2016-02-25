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
import android.widget.Toast;

import com.firebase.client.Firebase;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        EditText etFoodName = (EditText) findViewById(R.id.EditTextFoodName);
        Spinner spinFoodCategory = (Spinner) findViewById(R.id.SpinnerFoodCatagory);
        EditText etFoodOwner = (EditText) findViewById(R.id.EditTextFoodOwner);


        // Catagory Spinner - Set up
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.food_categories,
                android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinFoodCategory.setAdapter(categoryAdapter);


    }

    public void insert(View button){
        EditText etFoodName = (EditText) findViewById(R.id.EditTextFoodName);
        Spinner spinFoodCategory = (Spinner) findViewById(R.id.SpinnerFoodCatagory);
        EditText etFoodOwner = (EditText) findViewById(R.id.EditTextFoodOwner);

        // Food Name
        String FoodName = etFoodName.getText().toString();


        // Food Category

        // Get Spinner info

        spinFoodCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String FoodCategory = parent.getItemAtPosition(position).toString();
                Toast.makeText(InsertActivity.this, FoodCategory, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final String FoodCategory = spinFoodCategory.getSelectedItem().toString();

        // Food Owner
        String FoodOwner = etFoodOwner.getText().toString();

        Firebase myFirebaseRef = new Firebase("https://fridge-it2.firebaseio.com/");
        if(FoodCategory == "Condiments") {
            Condiments condiments = new Condiments(FoodOwner, FoodName);
            myFirebaseRef.child(condiments.getName()).setValue(condiments);
            Toast.makeText(InsertActivity.this, "Success: Condiments", Toast.LENGTH_SHORT).show();
        }

        if(FoodCategory == "Dairy") {
            Dairy dairy = new Dairy(FoodOwner, FoodName);
            myFirebaseRef.child(dairy.getName()).setValue(dairy);
            Toast.makeText(InsertActivity.this, "Success: Dairy", Toast.LENGTH_SHORT).show();
        }

        if(FoodCategory == "Drinks") {
            Drinks drinks = new Drinks(FoodOwner, FoodName);
            myFirebaseRef.child(drinks.getName()).setValue(drinks);
            Toast.makeText(InsertActivity.this, "Success: Drinks", Toast.LENGTH_SHORT).show();
        }

        if(FoodCategory == "Frozen Meals") {
            FrozenMeals frozenmeals = new FrozenMeals(FoodOwner, FoodName);
            myFirebaseRef.child(frozenmeals.getName()).setValue(frozenmeals);
            Toast.makeText(InsertActivity.this, "Success: Frozen Meals", Toast.LENGTH_SHORT).show();
        }

        if(FoodCategory == "Fruit") {
            Fruits fruit = new Fruits(FoodOwner, FoodName);
            myFirebaseRef.child(fruit.getName()).setValue(fruit);
            Toast.makeText(InsertActivity.this, "Success: Fruit", Toast.LENGTH_SHORT).show();
        }

        if(FoodCategory == "Grains") {
            Grains grains = new Grains(FoodOwner, FoodName);
            myFirebaseRef.child(grains.getName()).setValue(grains);
            Toast.makeText(InsertActivity.this, "Success: Grains", Toast.LENGTH_SHORT).show();
        }

        if(FoodCategory == "Meals") {
            Meals meals = new Meals(FoodOwner, FoodName);
            myFirebaseRef.child(meals.getName()).setValue(meals);
            Toast.makeText(InsertActivity.this, "Success: Meals", Toast.LENGTH_SHORT).show();
        }

        if(FoodCategory == "Meats") {
            Meats meats = new Meats(FoodOwner, FoodName);
            myFirebaseRef.child(meats.getName()).setValue(meats);
            Toast.makeText(InsertActivity.this, "Success: Meats", Toast.LENGTH_SHORT).show();
        }

        if(FoodCategory == "Other") {
            OtherFood other = new OtherFood(FoodOwner, FoodName);
            myFirebaseRef.child(other.getName()).setValue(other);
            Toast.makeText(InsertActivity.this, "Success: Other", Toast.LENGTH_SHORT).show();
        }

        if(FoodCategory == "Vegetables") {
            Vegetables veg = new Vegetables(FoodOwner, FoodName);
            myFirebaseRef.child(veg.getName()).setValue(veg);
            Toast.makeText(InsertActivity.this, "Success: Vegetables", Toast.LENGTH_SHORT).show();
        }
        Intent output = new Intent();
        setResult(RESULT_OK, output);
        finish();
    }
}
