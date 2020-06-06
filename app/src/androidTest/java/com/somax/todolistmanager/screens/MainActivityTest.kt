package com.somax.todolistmanager.screens


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.somax.todolistmanager.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val imageButton = onView(
            allOf(
                withId(R.id.button_add),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        imageButton.check(matches(isDisplayed()))

        val floatingActionButton = onView(
            allOf(
                withId(R.id.button_add),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val editText = onView(
            allOf(
                withId(R.id.editText), withText("Title"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        editText.check(matches(withText("Title")))

        val editText2 = onView(
            allOf(
                withId(R.id.editText2), withText("Note"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText2.check(matches(withText("Note")))

        val editText3 = onView(
            allOf(
                withId(R.id.editText2), withText("Note"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText3.check(matches(withText("Note")))

        val appCompatEditText = onView(
            allOf(
                withId(R.id.editText),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("Title"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editText), withText("Title"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(pressImeActionButton())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.editText2),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("Note"), closeSoftKeyboard())

        val floatingActionButton2 = onView(
            allOf(
                withId(R.id.button_save),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        floatingActionButton2.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
