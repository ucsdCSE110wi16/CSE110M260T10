package com.example.mowolfvillageon.fridgev1;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.ArrayAdapter;

import com.firebase.client.Firebase;

import junit.framework.TestCase;

import org.junit.Before;
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
 * Created by roger on 3/8/16.
 */
@RunWith(AndroidJUnit4.class)
public class InsertTester extends TestCase{

    int dbCount;
    int dbCountI;


    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(Main2Activity.class);
    Main2Activity m2a = new Main2Activity();

    @Before
    public void initSetup() {
        dbCount = m2a.getDatabaseCount();
    }

    @Test
    public void insertTester(){
        onView(withId(R.id.button2)).perform(click());
        dbCountI = m2a.getDatabaseCount();
        assertEquals((dbCount+1), dbCountI);

    }
}
