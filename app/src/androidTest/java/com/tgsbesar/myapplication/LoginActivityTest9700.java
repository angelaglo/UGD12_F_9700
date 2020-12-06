package com.tgsbesar.myapplication;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest9700 {

    @Rule
    public ActivityTestRule<splashScreen> mActivityTestRule = new ActivityTestRule<>(splashScreen.class);

    @Test
    public void loginActivityTest9700() {
        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.toLogin), withText("Sudah punya akun? Login disini!"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        3),
                                1),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.tv_rmLogin),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_rmLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("angelagloria68@gmail.com"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.signIn), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.tv_rmLogin), withText("angelagloria68@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_rmLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.tv_rmLogin), withText("angelagloria68@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_rmLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText(""));

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.tv_rmLogin),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_rmLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.tv_passLogin),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_passLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("123456"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.signIn), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.tv_rmLogin),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_rmLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(replaceText("angela"), closeSoftKeyboard());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.signIn), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.tv_rmLogin), withText("angela"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_rmLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText7.perform(click());

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.tv_rmLogin), withText("angela"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_rmLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText8.perform(replaceText("angelagloria68@gmail.com"));

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.tv_rmLogin), withText("angelagloria68@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_rmLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText9.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.tv_passLogin), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_passLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText10.perform(replaceText("12"));

        ViewInteraction textInputEditText11 = onView(
                allOf(withId(R.id.tv_passLogin), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_passLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText11.perform(closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.signIn), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction textInputEditText12 = onView(
                allOf(withId(R.id.tv_passLogin), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_passLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText12.perform(click());

        ViewInteraction textInputEditText13 = onView(
                allOf(withId(R.id.tv_passLogin), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_passLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText13.perform(replaceText("123456"));

        ViewInteraction textInputEditText14 = onView(
                allOf(withId(R.id.tv_passLogin), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_passLogin),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText14.perform(closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.signIn), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton5.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
