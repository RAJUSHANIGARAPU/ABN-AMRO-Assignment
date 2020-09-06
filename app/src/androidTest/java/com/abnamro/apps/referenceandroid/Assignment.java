package com.abnamro.apps.referenceandroid;


import android.view.View;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class Assignment{
    //Create a rule for Activity - make sure it's public
    //This will launch the activity before @Test
    @Rule
    public ActivityTestRule<MainActivity> main = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = null;

    // Used the before method to get the main activity initialized
    @Before
    public void setUp() throws Exception {
        mActivity = main.getActivity();
    }

    // Below test is to check if the app is launched and the fragement is loaded
    @Test
    public void launchTest() {
        View view = mActivity.findViewById(R.id.fragment);
        assert view!=null;
    }

    // Below test is to check if the app is launched and the userNameField is loaded
    @Test
    public void userNameFieldTest() {
        View view = mActivity.findViewById(R.id.username);
        assert view!=null;
    }

    // Below test is to check if the app is launched and the passwordField is loaded
    @Test
    public void passwordFieldTest() {
        View view = mActivity.findViewById(R.id.password);
        assert view!=null;
    }

    // Below test is to check if the app is launched and the LoginButton is loaded
    @Test
    public void loginButtonTest() {
        View view = mActivity.findViewById(R.id.buttonLogin);
        assert view!=null;
    }

    // Below test is to check if error msg is displayed on giving empty username
    @Test
    public void checkErrorEmptyUserNameandPassword() {
        onView(withId(R.id.buttonLogin)).perform(click());
        onView(withText("Failed to login")).check(matches(isDisplayed()));
        View view = mActivity.findViewById(R.id.loginFailure);
        assert view!=null;
    }

    // Below test is to check if error msg is displayed on giving empty password
    @Test
    public void checkErrorEmptypassword() {
        onView(withId(R.id.username)).perform(typeText("username"));
        onView(withId(R.id.password)).perform(typeText(""));
        onView(withId(R.id.buttonLogin)).perform(click());
        onView(withText("Failed to login")).check(matches(isDisplayed()));
        View view = mActivity.findViewById(R.id.loginFailure);
        assert view!=null;
    }

    // Below test is to check if error msg is displayed on giving empty password
    @Test
    public void checkErrorEmptyUserName() {
        onView(withId(R.id.username)).perform(typeText(""));
        onView(withId(R.id.password)).perform(typeText("password"));
        onView(withId(R.id.buttonLogin)).perform(click());
        onView(withText("Failed to login")).check(matches(isDisplayed()));
        View view = mActivity.findViewById(R.id.loginFailure);
        assert view!=null;
    }

    // Below test is to check if login is success on giving password less than 6 chars
    @Test
    public void checkErrorIncorrectPassword() {
        onView(withId(R.id.username)).perform(typeText("username"));
        onView(withId(R.id.password)).perform(typeText("pass"));
        onView(withId(R.id.buttonLogin)).perform(click());
        onView(withText("Failed to login")).check(matches(isDisplayed()));
        View view = mActivity.findViewById(R.id.successLogin);
        assert view!=null;
    }

    // Below test is to check if login is success on giving password equal to 6 chars
    @Test
    public void LoginSuccess1() {
        onView(withId(R.id.username)).perform(typeText("username"));
        onView(withId(R.id.password)).perform(typeText("passwo"));
        onView(withId(R.id.buttonLogin)).perform(click());
        onView(withText("Hello, You have logged in successfully!")).check(matches(isDisplayed()));
        View view = mActivity.findViewById(R.id.successLogin);
        assert view!=null;
    }


    // Below test is to check if login is success on giving password greater than 6 chars
    @Test
    public void LoginSuccess2() {
        onView(withId(R.id.username)).perform(typeText("username"));
        onView(withId(R.id.password)).perform(typeText("password"));
        onView(withId(R.id.buttonLogin)).perform(click());
        onView(withText("Hello, You have logged in successfully!")).check(matches(isDisplayed()));
        View view = mActivity.findViewById(R.id.successLogin);
        assert view!=null;
    }
    @After
    public void tearDown() throws Exception {
    }
}