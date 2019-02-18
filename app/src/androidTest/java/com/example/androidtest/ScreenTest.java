package com.example.androidtest;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.DrawerMatchers;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;
import android.widget.TextView;

import com.example.androidtest.dashboard.DashboardActivity;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ScreenTest {

    @Rule
    public ActivityTestRule<DashboardActivity> activityRule =
            new ActivityTestRule<>(DashboardActivity.class);

    @Before
    public void onStartTest(){
        Espresso.registerIdlingResources(EspressoIdlingResource.getIdlingResource());
    }

    @After
    public void onFinishTest(){
        Espresso.unregisterIdlingResources(EspressoIdlingResource.getIdlingResource());
    }

    @Test
    public void drawerOpenTest() {
        // Check that left drawer is closed at startup
        Espresso.onView(ViewMatchers.withId(R.id.dashboard_drawer)).check(ViewAssertions.matches(DrawerMatchers.isClosed(Gravity.LEFT)))
        .perform(DrawerActions.open()); // Left Drawer should be closed.
        // Check if drawer is open
        Espresso.onView(ViewMatchers.withId(R.id.dashboard_drawer))
                .check(ViewAssertions.matches(DrawerMatchers.isOpen(Gravity.LEFT))); // Left drawer is open open.
    }

    @Test
    public void drawerClickTest() {
        // Check that left drawer is closed at startup
        Espresso.onView(ViewMatchers.withId(R.id.dashboard_drawer)).check(ViewAssertions.matches(DrawerMatchers.isClosed(Gravity.LEFT)))
                .perform(DrawerActions.open()); // Left Drawer should be closed.

        // Start statistics screen.
        Espresso.onView(ViewMatchers.withId(R.id.dashboard_navigation_drawer))
                .perform(NavigationViewActions.navigateTo(R.id.menu_main_option_recycler));

        Espresso.onView(Matchers.allOf(Matchers.instanceOf(TextView.class), ViewMatchers.withParent(ViewMatchers.withId(R.id.paging_toolbar)))).check(ViewAssertions.matches(ViewMatchers.withText("Paging RecyclerView")));

    }

    @Test
    public void pagingFragmentTest() {
        // Navigate to Paging Screen
        Espresso.onView(ViewMatchers.withId(R.id.dashboard_paging_label)).perform(ViewActions.click());
        // Check screen has paging title
        Espresso.onView(Matchers.allOf(Matchers.instanceOf(TextView.class), ViewMatchers.withParent(ViewMatchers.withId(R.id.paging_toolbar)))).check(ViewAssertions.matches(ViewMatchers.withText("Paging RecyclerView")));
        //
        String fruitToSearch = "apples";
        Espresso.onView(ViewMatchers.withId(R.id.paging_input_search)).perform(ViewActions.typeText(fruitToSearch));
        Espresso.onView(ViewMatchers.withId(R.id.paging_btn_search)).perform(ViewActions.click());
        // Check that exists a fruit with the name of 'apples' and click on it
        Espresso.onView(ViewMatchers.withId(R.id.paging_list_fruit))
                .perform(RecyclerViewActions.scrollTo(ViewMatchers.hasDescendant(first(ViewMatchers.withText(fruitToSearch)))))
                .perform(ViewActions.click());
    }


    @Test
    public void recylcerFragmentTest() {
        // Navigate to Recycler Screen
        Espresso.onView(ViewMatchers.withId(R.id.dashboard_recycler_label)).perform(ViewActions.click());
        // Check screen has recycler title
        Espresso.onView(Matchers.allOf(Matchers.instanceOf(TextView.class), ViewMatchers.withParent(ViewMatchers.withId(R.id.paging_toolbar)))).check(ViewAssertions.matches(ViewMatchers.withText("Paging RecyclerView")));
        // Perform click on the 'Add fab view'
        Espresso.onView(ViewMatchers.withId(R.id.paging_button_add)).perform(ViewActions.click());
        // Check that exists a new fruit added in the list
        Espresso.onView(ViewMatchers.withId(R.id.paging_list_fruit))
                .perform(RecyclerViewActions.scrollTo(ViewMatchers.hasDescendant(first(ViewMatchers.withText("Naranja")))));

    }

    private <T> Matcher<T> first(Matcher<T> matcher) {

        return new BaseMatcher<T>() {

            private boolean first = false;

            @Override
            public boolean matches(Object item) {
                if (!first && matcher.matches(item)) {
                    first = true;
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void describeTo(Description description) {

            }
        };

    }

}
