package com.example.mowolfvillageon.fridgev1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mowolfvillageon.fridgev1.FoodFiles.Condiments;
import com.example.mowolfvillageon.fridgev1.FoodFiles.Dairy;
import com.example.mowolfvillageon.fridgev1.FoodFiles.Drinks;
import com.example.mowolfvillageon.fridgev1.FoodFiles.FrozenMeals;
import com.example.mowolfvillageon.fridgev1.FoodFiles.Fruits;
import com.example.mowolfvillageon.fridgev1.FoodFiles.Grains;
import com.example.mowolfvillageon.fridgev1.FoodFiles.Meals;
import com.example.mowolfvillageon.fridgev1.FoodFiles.Meats;
import com.example.mowolfvillageon.fridgev1.FoodFiles.OtherFood;
import com.example.mowolfvillageon.fridgev1.FoodFiles.Vegetables;
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
        EditText etFoodExpiration = (EditText) findViewById(R.id.EditTextFoodExpiration);
        EditText etFoodOwner = (EditText) findViewById(R.id.EditTextFoodOwner);


        // Catagory Spinner - Set up
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.food_categories,
                R.layout.custom_textview);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinFoodCategory.setAdapter(categoryAdapter);
        //categoryAdapter.setDropDownViewResource(android.R.layout.custom_textview);


    }


    public void insert(View button){
        EditText etFoodName = (EditText) findViewById(R.id.EditTextFoodName);
        Spinner spinFoodCategory = (Spinner) findViewById(R.id.SpinnerFoodCatagory);
        EditText etFoodOwner = (EditText) findViewById(R.id.EditTextFoodOwner);
        EditText etFoodExpiration = (EditText) findViewById(R.id.EditTextFoodExpiration);

        // Food Name
        String FoodName = etFoodName.getText().toString();
        String OwnerName = etFoodOwner.getText().toString();
        String expirationDate = etFoodExpiration.getText().toString();

        // check if both fields were left blank
        if (FoodName.matches("") || OwnerName.matches("") || expirationDate.matches("")) {
            // check if food name field was left blank
            if (FoodName.matches("")) {
                Toast.makeText(this, "You forgot to enter your food!", Toast.LENGTH_SHORT).show();
                return;
            }
            // check if owner name field was left blank
            else if (OwnerName.matches("")) {
                Toast.makeText(this, "You forgot to enter your name!", Toast.LENGTH_SHORT).show();
                return;
            }
            // check if expiration date was entered
            else{
                Toast.makeText(this, "You forgot to enter expiration date!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // if everything good, continue
        else {
            FoodName = wordCaseStandardized(FoodName);
        }


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

        //Food Expiration
        String FoodExpiration = etFoodExpiration.getText().toString();
        FoodExpiration = wordCaseStandardized(FoodExpiration);

        // Food Owner
        String FoodOwner = etFoodOwner.getText().toString();
        FoodOwner = wordCaseStandardized(FoodOwner);

        Firebase myFirebaseRef = new Firebase("https://fridge-it2.firebaseio.com/");

        /* Fruits fruit = new Fruits(FoodOwner, FoodName);
        myFirebaseRef.child(fruit.getName()).setValue(fruit); */

        Toast.makeText(InsertActivity.this, "Success: " + (String) FoodCategory, Toast.LENGTH_SHORT).show();

        if(  FoodCategory.equals("Condiments")) {
            Condiments condiments = new Condiments(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(condiments.getName()).setValue(condiments);
            Toast.makeText(InsertActivity.this, "Success: Condiments", Toast.LENGTH_SHORT).show();
        }

        if( FoodCategory.equals("Dairy")) {
            Dairy dairy = new Dairy(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(dairy.getName()).setValue(dairy);
            Toast.makeText(InsertActivity.this, "Success: Dairy", Toast.LENGTH_SHORT).show();
        }

        if( FoodCategory.equals("Drinks")) {
            Drinks drinks = new Drinks(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(drinks.getName()).setValue(drinks);
            Toast.makeText(InsertActivity.this, "Success: Drinks", Toast.LENGTH_SHORT).show();
        }

        if( FoodCategory.equals("Frozen Meals")) {
            FrozenMeals frozenmeals = new FrozenMeals(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(frozenmeals.getName()).setValue(frozenmeals);
            Toast.makeText(InsertActivity.this, "Success: Frozen Meals", Toast.LENGTH_SHORT).show();
        }

        if( FoodCategory.equals("Fruit")) {
            Fruits fruit = new Fruits(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(fruit.getName()).setValue(fruit);
            Toast.makeText(InsertActivity.this, "Success: Fruit", Toast.LENGTH_SHORT).show();
        }

        if( FoodCategory.equals("Grains")) {
            Grains grains = new Grains(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(grains.getName()).setValue(grains);
            Toast.makeText(InsertActivity.this, "Success: Grains", Toast.LENGTH_SHORT).show();
        }

        if( FoodCategory.equals("Meals")) {
            Meals meals = new Meals(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(meals.getName()).setValue(meals);
            Toast.makeText(InsertActivity.this, "Success: Meals", Toast.LENGTH_SHORT).show();
        }

        if( FoodCategory.equals("Meats")) {
            Meats meats = new Meats(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(meats.getName()).setValue(meats);
            Toast.makeText(InsertActivity.this, "Success: Meats", Toast.LENGTH_SHORT).show();
        }

        if( FoodCategory.equals("Other")) {
            OtherFood other = new OtherFood(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(other.getName()).setValue(other);
            Toast.makeText(InsertActivity.this, "Success: Other", Toast.LENGTH_SHORT).show();
        }

        if( FoodCategory.equals("Vegetables")) {
            Vegetables veg = new Vegetables(FoodOwner, FoodName, FoodExpiration);
            myFirebaseRef.child(veg.getName()).setValue(veg);
            Toast.makeText(InsertActivity.this, "Success: Vegetables", Toast.LENGTH_SHORT).show();
        }
        Intent output = new Intent();
        setResult(RESULT_OK, output);
        //finish();

        //creates new main2 while deleting old main2
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public String wordCaseStandardized(String a) {
        String b;

        // Capatalizes first letter of word, lowercase rest
        b = "";
        for(int i=0; i<a.length(); i++) {
            b+=Character.toLowerCase(a.charAt(i));
        }
        a = b;
        a = Character.toUpperCase(a.charAt(0)) + a.substring(1);

        return a;
    }
}
