package com.exapmle.shazamclone

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.exapmle.shazamclone.discover.DiscoverActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by jaskaranhome on 24/01/18.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class DiscoverFragmentTest {
    // Instructs the Kotlin compiler not to generate getters/setters for this property and expose it as a field.
    @JvmField
    @Rule
    val mDiscoverActivityTestRule = ActivityTestRule<DiscoverActivity>(DiscoverActivity::class.java)

    // Check that clicking start button opens up the song detail page
    @Test
    fun clickStartIdentifyButtonOpenSongDetailPage() {
        // Click on the start button
        onView(withId(R.id.discoverStartIdentifyButton)).perform(click())
        // Check that the song detail view is shown afterwards
        onView(withId(R.id.songDetailFragmentContainer)).check(matches(isDisplayed()))
    }

    // Check that clicking the donate button opens the donate page
    @Test
    fun clickDonateButtonOpensDonatePage() {
        // Click on the donate button
        onView(withId(R.id.discoverDonateButton)).perform(click())
        // Check that the donate view is shown afterwards
        onView(withId(R.id.donateFragmentContainer)).check(matches(isDisplayed()))

    }

    // Check that clicking history button opens the history page
    @Test
    fun clickHistoryButtonOpensHistoryPage() {
        // Click on the history button
        onView(withId(R.id.discoverHistoryButton)).perform(click())
        // Check that the history view is shown afterwards
        onView(withId(R.id.historyFragmentContainer)).check(matches(isDisplayed()))
    }

}