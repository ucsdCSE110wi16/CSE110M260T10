package com.example.mowolfvillageon.fridgev1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main2Activity extends AppCompatActivity {
    private int count;
    protected ArrayList<String> foodNames = new ArrayList<>();
    protected ArrayList<String> expDates = new ArrayList<>();
    protected ArrayList<String> ownerNames = new ArrayList<>();
    protected ArrayList<String> catagoryNames = new ArrayList<>();
    SearchView sv;  //initializing the SearchView
    ArrayAdapter<String> adapter; //moved initialization of adapter so it can be reached by SearchView
    ListView list;
     /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        count = 0;
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        populateListView();

        final Spinner spinSorter = (Spinner) findViewById(R.id.sortSpinner);

        // Catagory Spinner - Set up
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.sort_categories,
                R.layout.custom_textview);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSorter.setAdapter(categoryAdapter);

        spinSorter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sortChoice = parent.getItemAtPosition(position).toString();
                Toast.makeText(Main2Activity.this, sortChoice, Toast.LENGTH_SHORT).show();
                onSortList(spinSorter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void populateListView() {
        foodNames.clear();
        // Create Fridge List of items
        //String[] starterFoods = {"Apple", "Chicken", "Water"};

        // Set up adapter

        Bundle extras = getIntent().getExtras();
        final String loginPassword = extras.getString("loginPassword");

        final Firebase myFirebaseRef = new Firebase("https://fridge-it2.firebaseio.com/");

        //Check if child exists, so that data is not overwritten
        if (myFirebaseRef.child(loginPassword) == null) {
            myFirebaseRef.child(loginPassword).setValue(loginPassword);
        }

        Firebase ref = new Firebase("https://fridge-it2.firebaseio.com/" + loginPassword);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    String foodName = (String) child.child("name").getValue();
                    foodNames.add(foodName);
                    String expDate = (String) child.child("expiration").getValue();
                    expDates.add(expDate);
                    String catagory = (String) child.child("catagory").getValue();
                    catagoryNames.add(expDate);
                    String owner = (String) child.child("owner").getValue();
                    ownerNames.add(expDate);
                    count++;
                }
                adapter = new ArrayAdapter<>(
                        Main2Activity.this,
                        R.layout.custom_textview, // layout being created, custom_textview for white text
                        foodNames); //items to add to list


                list = (ListView) findViewById(R.id.listViewFridge);
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
    public void onAddItemButtonClick(View v) {
        Button button = (Button) v;

        Bundle extras = getIntent().getExtras();
        String loginPassword = extras.getString("loginPassword");

        Intent i = new Intent(getApplicationContext(), InsertActivity.class);
        i.putExtra("loginPassword", loginPassword);
        startActivity(i);
    }

    // Button for removing an Item
    public void onRemoveItemButtonClick(View v) {
        Button button = (Button) v;

        Bundle extras = getIntent().getExtras();
        String loginPassword = extras.getString("loginPassword");

        Intent i = new Intent(getApplicationContext(), RemoveActivity.class);
        i.putExtra("loginPassword", loginPassword);
        startActivity(i);
    }

    // Logout Button
    public void onLogOutButtonClick(View v) {
        Button button = (Button) v;
        Toast.makeText(Main2Activity.this, "Logged Out Successful!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
    }

    public void onSortList(Spinner spinSortChoice) {
        Bundle extras = getIntent().getExtras();
        final String loginPassword = extras.getString("loginPassword");
        Firebase ref = new Firebase("https://fridge-it2.firebaseio.com/" + loginPassword);
        System.out.println("hello...my ref is...." + ref);


        final String SortChoice = spinSortChoice.getSelectedItem().toString();

        if (SortChoice.equals("A->Z")) {
            Toast.makeText(Main2Activity.this, "1", Toast.LENGTH_SHORT).show();
            Collections.sort(foodNames);
            // ref.orderByKey();
            adapter.notifyDataSetChanged();

            populateListView();

        } else if (SortChoice.equals("Category")) {
            //Firebase catagoryRef = ref.child("catagory");
            //ref.orderByChild("catagory");
            ArrayList<Firebase> catagoryNames = new ArrayList<>();
            for(int i = 0; i < foodNames.size(); i++) {
                catagoryNames.add(ref.child(foodNames.get(i)).child("catagory").);
                System.out.println("HELLO...." + catagoryNames.toString());
            }
             Collections.sort(catagoryNames, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Firebase p1 = (Firebase) o1;
                    Firebase p2 = (Firebase) o2;
                    System.out.println("1: " + p1.toString() + "2: " + p2.toString());
                    return p1.toString().compareToIgnoreCase(p2.toString());
                }
            });
            ArrayList<String> foodName = new ArrayList<>();
            for(int i = 0; i < catagoryNames.size(); i++) {
                foodName.add(catagoryNames.get(i).getParent().toString());
                System.out.println("Hye...." + foodName);
            }
            foodNames=foodName;
            adapter.notifyDataSetChanged();
            list.setAdapter(adapter);

            //Collections.sort(foodNames);
            /* Collections.sort(foodNames, new Comparator<String>(){
                public int compare(Food f1, Food f2) {
                    return f1.getCatagory().compareToIgnoreCase(f2.getCatagory());
                }
            }); */

            Toast.makeText(Main2Activity.this, "2.1", Toast.LENGTH_SHORT).show();

        } else if (SortChoice.equals("Expiration Date")) {
            Firebase expirationRef = ref.child("expiration");
            ref.orderByChild("expiration");
            adapter.notifyDataSetChanged();
            populateListView();

            //populateListView();
            Toast.makeText(Main2Activity.this, "3", Toast.LENGTH_SHORT).show();
        }
        else if (SortChoice.equals("Owner")) {
            Firebase ownerRef = ref.child("owner");
            ref.orderByChild("owner");
            adapter.notifyDataSetChanged();

            populateListView();
            /* Collections.sort(foodNames, new Comparator<String>() {
                public int compare(Food f1, Food f2) {
                    return f1.getOwner().compareToIgnoreCase(f2.getOwner());
                }
            }); */

            //populateListView();
            Toast.makeText(Main2Activity.this, "4", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Main2Activity.this, "5", Toast.LENGTH_SHORT).show();
        }

    }

    public int getDatabaseCount() {
        return count;

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.mowolfvillageon.fridgev1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.mowolfvillageon.fridgev1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
