package MainActivityTest

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.support.test.rule.ActivityTestRule
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.R.id.*
import com.kade.derayanbimaalamsyah.kade_2_footbalmatchschedule.view.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField var activityRule = ActivityTestRule(MainActivity::class.java)
    private val wait: Long = 3000

    @Test
    fun testRecyclerViewBehaviour() {
        Thread.sleep(wait)
        Espresso.onView(withId(recycleViewPrevMatch)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(recycleViewPrevMatch)).perform(RecyclerViewActions.
                scrollToPosition<RecyclerView.ViewHolder>(8))
        Espresso.onView(withId(recycleViewPrevMatch)).perform(
                RecyclerViewActions.actionOnItemAtPosition<
                        RecyclerView.ViewHolder>(8, ViewActions.click()))
    }

    @Test
    fun testAppUIBehaviour() {

        //SwipeRefresh
        Thread.sleep(wait)
        Espresso.onView(withId(swipeRefresh)).perform(ViewActions.swipeDown())

        //
        Espresso.onView(withId(container)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(navigation_prev_league)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(navigation_next_league)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(navigation_favorites)).check(ViewAssertions.matches(isDisplayed()))

        Thread.sleep(wait)
        Espresso.onView(withId(recycleViewPrevMatch)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(recycleViewPrevMatch))
                .perform(RecyclerViewActions.actionOnItemAtPosition
                <RecyclerView.ViewHolder>(5, ViewActions.click()));

        Thread.sleep(wait)
        Espresso.onView(withId(lyEventDetail)).check(ViewAssertions.matches(isDisplayed()))

        Espresso.onView(withId(add_to_favorite)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(add_to_favorite)).perform(ViewActions.click())

        Espresso.onView(withId(add_to_favorite)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(add_to_favorite)).perform(ViewActions.click())

        Espresso.pressBack()

        Thread.sleep(wait)

        Espresso.onView(withId(navigation)).check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(navigation_favorites)).perform(ViewActions.click())
    }

}