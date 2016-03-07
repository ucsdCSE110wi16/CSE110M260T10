package com.example.mowolfvillageon.fridgev1;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by mowolfvillageon on 3/7/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExpressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    /* @Test
    public void listGoesOverTheFold() {
        onView(withText("Hello world!")).check(matches(isDisplayed()));
    } */

    @Test
    public void removedItem() {
        //onView();
        /*onView(withId(R.id.my_view))            // withId(R.id.my_view) is a ViewMatcher
                .perform(click())               // click() is a ViewAction
                .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion */
    }
}

