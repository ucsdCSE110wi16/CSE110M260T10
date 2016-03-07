package com.example.mowolfvillageon.fridgev1;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.ArrayAdapter;

import com.firebase.client.Firebase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by mowolfvillageon on 3/7/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExpressoTest {
    String sFood;
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    /* @Test
    public void listGoesOverTheFold() {
        onView(withText("Hello world!")).check(matches(isDisplayed()));
    } */
    @Before
    public void initValidString() {
        // Specify a valid string.
        sFood = "Apple";
    }
    @Test
    public void removedItem() {
        Firebase myFirebaseRef = new Firebase("https://fridge-it2.firebaseio.com/");


        //String value = (String)adapter.getItemAtPosition(position);
        //assertThat(removedItem(););
        //onView(withId(R.id.listViewFridgeRemove)).perform(click()).check();
        //onView(withId(R.id.goodbye_button)).perform(click());
        //onView();
        /*onView(withId(R.id.my_view))            // withId(R.id.my_view) is a ViewMatcher
                .perform(click())               // click() is a ViewAction
                .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion */
    }
}

