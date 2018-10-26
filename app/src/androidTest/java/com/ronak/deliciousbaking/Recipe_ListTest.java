package com.ronak.deliciousbaking;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Recipe_ListTest {

    @Rule
    public ActivityTestRule<Recipe_List> mActivityTestRule = new ActivityTestRule<>(Recipe_List.class);

    @Test
    public void recipe_ListTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recipe_recycler),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Send to widget"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.step_short_desc), withText("0. Recipe Introduction"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(R.id.step_short_desc), withText("5. Finish filling prep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        5),
                                0),
                        isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction appCompatTextView4 = onView(
                allOf(withId(R.id.step_short_desc), withText("1. Starting prep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        1),
                                0),
                        isDisplayed()));
        appCompatTextView4.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatTextView5 = onView(
                allOf(withId(R.id.step_short_desc), withText("2. Prep the cookie crust."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        2),
                                0),
                        isDisplayed()));
        appCompatTextView5.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4960);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction appCompatTextView6 = onView(
                allOf(withId(R.id.step_short_desc), withText("3. Press the crust into baking form."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        3),
                                0),
                        isDisplayed()));
        appCompatTextView6.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4960);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction appCompatTextView7 = onView(
                allOf(withId(R.id.step_short_desc), withText("4. Start filling prep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        4),
                                0),
                        isDisplayed()));
        appCompatTextView7.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4969);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction appCompatTextView8 = onView(
                allOf(withId(R.id.step_short_desc), withText("5. Finish filling prep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        5),
                                0),
                        isDisplayed()));
        appCompatTextView8.perform(click());

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        ViewInteraction appCompatTextView9 = onView(
                allOf(withId(R.id.step_short_desc), withText("6. Finishing Steps"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        6),
                                0),
                        isDisplayed()));
        appCompatTextView9.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4970);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageButton8 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton8.perform(click());

        ViewInteraction appCompatImageButton9 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton9.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recipe_recycler),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction appCompatTextView10 = onView(
                allOf(withId(R.id.step_short_desc), withText("0. Recipe Introduction"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView10.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4969);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView11 = onView(
                allOf(withId(R.id.step_short_desc), withText("1. Starting prep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        1),
                                0),
                        isDisplayed()));
        appCompatTextView11.perform(click());

        pressBack();

        ViewInteraction appCompatTextView12 = onView(
                allOf(withId(R.id.step_short_desc), withText("2. Melt butter and bittersweet chocolate."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        2),
                                0),
                        isDisplayed()));
        appCompatTextView12.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4973);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView13 = onView(
                allOf(withId(R.id.step_short_desc), withText("3. Add sugars to wet mixture."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        3),
                                0),
                        isDisplayed()));
        appCompatTextView13.perform(click());

        pressBack();

        ViewInteraction appCompatTextView14 = onView(
                allOf(withId(R.id.step_short_desc), withText("4. Mix together dry ingredients."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        4),
                                0),
                        isDisplayed()));
        appCompatTextView14.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4960);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView15 = onView(
                allOf(withId(R.id.step_short_desc), withText("5. Add eggs."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        5),
                                0),
                        isDisplayed()));
        appCompatTextView15.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4965);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView16 = onView(
                allOf(withId(R.id.step_short_desc), withText("6. Add dry mixture to wet mixture."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        6),
                                0),
                        isDisplayed()));
        appCompatTextView16.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4973);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView17 = onView(
                allOf(withId(R.id.step_short_desc), withText("7. Add batter to pan."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        7),
                                0),
                        isDisplayed()));
        appCompatTextView17.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4973);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView18 = onView(
                allOf(withId(R.id.step_short_desc), withText("8. Remove pan from oven."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        8),
                                0),
                        isDisplayed()));
        appCompatTextView18.perform(click());

        pressBack();

        ViewInteraction appCompatTextView19 = onView(
                allOf(withId(R.id.step_short_desc), withText("9. Cut and serve."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        9),
                                0),
                        isDisplayed()));
        appCompatTextView19.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4975);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        pressBack();

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recipe_recycler),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)));
        recyclerView3.perform(actionOnItemAtPosition(2, click()));

        ViewInteraction appCompatTextView20 = onView(
                allOf(withId(R.id.step_short_desc), withText("0. Recipe Introduction"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView20.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4970);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView21 = onView(
                allOf(withId(R.id.step_short_desc), withText("1. Starting prep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        1),
                                0),
                        isDisplayed()));
        appCompatTextView21.perform(click());

        pressBack();

        ViewInteraction appCompatTextView22 = onView(
                allOf(withId(R.id.step_short_desc), withText("2. Combine dry ingredients."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        2),
                                0),
                        isDisplayed()));
        appCompatTextView22.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4972);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView23 = onView(
                allOf(withId(R.id.step_short_desc), withText("3. Prepare wet ingredients."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        3),
                                0),
                        isDisplayed()));
        appCompatTextView23.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4976);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView24 = onView(
                allOf(withId(R.id.step_short_desc), withText("4. Add butter and milk to dry ingredients."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        4),
                                0),
                        isDisplayed()));
        appCompatTextView24.perform(click());

        pressBack();

        ViewInteraction appCompatTextView25 = onView(
                allOf(withId(R.id.step_short_desc), withText("5. Add egg mixture to batter."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        5),
                                0),
                        isDisplayed()));
        appCompatTextView25.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4967);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView26 = onView(
                allOf(withId(R.id.step_short_desc), withText("6. Pour batter into pans."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        6),
                                0),
                        isDisplayed()));
        appCompatTextView26.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4976);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView27 = onView(
                allOf(withId(R.id.step_short_desc), withText("8. Begin making buttercream."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        7),
                                0),
                        isDisplayed()));
        appCompatTextView27.perform(click());

        pressBack();

        ViewInteraction appCompatTextView28 = onView(
                allOf(withId(R.id.step_short_desc), withText("9. Prepare egg whites."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        8),
                                0),
                        isDisplayed()));
        appCompatTextView28.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4966);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView29 = onView(
                allOf(withId(R.id.step_short_desc), withText("10. Beat egg whites to stiff peaks."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        9),
                                0),
                        isDisplayed()));
        appCompatTextView29.perform(click());

        pressBack();

        ViewInteraction appCompatTextView30 = onView(
                allOf(withId(R.id.step_short_desc), withText("12. Finish buttercream icing."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        11),
                                0),
                        isDisplayed()));
        appCompatTextView30.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4966);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView31 = onView(
                allOf(withId(R.id.step_short_desc), withText("13. Frost cakes."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        12),
                                0),
                        isDisplayed()));
        appCompatTextView31.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4977);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        pressBack();

        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.recipe_recycler),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)));
        recyclerView4.perform(actionOnItemAtPosition(3, click()));

        ViewInteraction appCompatTextView32 = onView(
                allOf(withId(R.id.step_short_desc), withText("0. Recipe Introduction"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        0),
                                0),
                        isDisplayed()));
        appCompatTextView32.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4968);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView33 = onView(
                allOf(withId(R.id.step_short_desc), withText("1. Starting prep."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        1),
                                0),
                        isDisplayed()));
        appCompatTextView33.perform(click());

        pressBack();

        ViewInteraction appCompatTextView34 = onView(
                allOf(withId(R.id.step_short_desc), withText("2. Prep the cookie crust."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        2),
                                0),
                        isDisplayed()));
        appCompatTextView34.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4978);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView35 = onView(
                allOf(withId(R.id.step_short_desc), withText("3. Start water bath."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        3),
                                0),
                        isDisplayed()));
        appCompatTextView35.perform(click());

        pressBack();

        ViewInteraction appCompatTextView36 = onView(
                allOf(withId(R.id.step_short_desc), withText("4. Prebake cookie crust. "),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        4),
                                0),
                        isDisplayed()));
        appCompatTextView36.perform(click());

        pressBack();

        ViewInteraction appCompatTextView37 = onView(
                allOf(withId(R.id.step_short_desc), withText("5. Mix cream cheese and dry ingredients."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        5),
                                0),
                        isDisplayed()));
        appCompatTextView37.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4970);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView38 = onView(
                allOf(withId(R.id.step_short_desc), withText("6. Add eggs."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        6),
                                0),
                        isDisplayed()));
        appCompatTextView38.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4966);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView39 = onView(
                allOf(withId(R.id.step_short_desc), withText("7. Add heavy cream and vanilla."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        7),
                                0),
                        isDisplayed()));
        appCompatTextView39.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4976);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView40 = onView(
                allOf(withId(R.id.step_short_desc), withText("8. Pour batter in pan."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        8),
                                0),
                        isDisplayed()));
        appCompatTextView40.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4967);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatTextView41 = onView(
                allOf(withId(R.id.step_short_desc), withText("9. Bake the cheesecake."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        9),
                                0),
                        isDisplayed()));
        appCompatTextView41.perform(click());

        pressBack();

        ViewInteraction appCompatTextView42 = onView(
                allOf(withId(R.id.step_short_desc), withText("10. Turn off oven and leave cake in."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        10),
                                0),
                        isDisplayed()));
        appCompatTextView42.perform(click());

        pressBack();

        ViewInteraction appCompatTextView43 = onView(
                allOf(withId(R.id.step_short_desc), withText("11. Remove from oven and cool at room temperature."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        11),
                                0),
                        isDisplayed()));
        appCompatTextView43.perform(click());

        pressBack();

        ViewInteraction appCompatTextView44 = onView(
                allOf(withId(R.id.step_short_desc), withText("12. Final cooling and set."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.steps_recycler),
                                        12),
                                0),
                        isDisplayed()));
        appCompatTextView44.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4975);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        pressBack();
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
