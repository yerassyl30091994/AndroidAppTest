/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import kotlinx.android.synthetic.main.activity_align.view.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches
import org.hamcrest.core.StringContains.containsString

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeTextBehaviorKtTest {


    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun changeTextColor_sameActivity() {

        val textView = onView(withId(R.id.textView))
        val btnColor = onView(withId(R.id.btnColor))
        val btnRed = onView(withId(R.id.btnRed))
        val btnBlue = onView(withId(R.id.btnBlue))
        val btnGreen = onView(withId(R.id.btnGreen))

        val btnAlign = onView(withId(R.id.btnAlign))
        val btnLeft = onView(withId(R.id.btnLeft))
        val btnCenter = onView(withId(R.id.btnCenter))
        val btnRight = onView(withId(R.id.btnRight))

//        textView.check(matches(withText("BTS QA school")))
//        textView.check(matches(containsString("BTS QA school")))

        btnColor.perform(click())
        btnRed.perform(click())
        btnColor.perform(click())
        btnBlue.perform(click())
        btnColor.perform(click())
        btnGreen.perform(click())

        btnAlign.perform(click())
        btnLeft.perform(click())
        btnAlign.perform(click())
        btnRight.perform(click())
        btnAlign.perform(click())
        btnCenter.perform(click())

    }


}


