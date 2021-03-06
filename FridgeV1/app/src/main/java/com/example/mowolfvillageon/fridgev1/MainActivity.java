package com.example.mowolfvillageon.fridgev1;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ActionBar actionBar = getActionBar();
        //actionBar.hide();
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //When button is clicked, screen switched to second activity screen
    public void onLoginButtonClick (View v) {
        /*Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), Main2Activity.class));*/

        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    //When button is clicked, screen switched to NewUserActivity screen
    public void onNewUserButtonClick (View v) {
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), NewUserActivity.class));
    }

    //When image is clicked, screen switched to Post Login Screen screen
    public void onDevHackClick (View v) {
        Toast.makeText(MainActivity.this, "Hack Found", Toast.LENGTH_SHORT).show();
        ImageView dev = (ImageView) v;
        startActivity(new Intent(getApplicationContext(), Main2Activity.class));
    }
}
