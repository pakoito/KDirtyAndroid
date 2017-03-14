/*
 * Copyright 2017 Victor Albertos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.common

import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.View
import org.hamcrest.Matcher

fun openDrawer(): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return isAssignableFrom(DrawerLayout::class.java)
        }

        override fun getDescription(): String {
            return "open drawer"
        }

        override fun perform(uiController: UiController, view: View) {
            (view as DrawerLayout).openDrawer(GravityCompat.START)
        }
    }
}

fun closeDrawer(): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return isAssignableFrom(DrawerLayout::class.java)
        }

        override fun getDescription(): String {
            return "close drawer"
        }

        override fun perform(uiController: UiController, view: View) {
            (view as DrawerLayout).closeDrawer(GravityCompat.START)
        }
    }
}
