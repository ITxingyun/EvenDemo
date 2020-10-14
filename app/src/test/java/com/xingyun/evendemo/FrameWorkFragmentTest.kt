package com.xingyun.evendemo

import android.content.Context
import android.content.Intent
import android.widget.Button
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import com.xingyun.evendemo.framework.launchmode.StandardActivity
import com.xingyun.evendemo.home.MainActivity
import org.junit.AfterClass
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf


@RunWith(RobolectricTestRunner::class)
class FrameWorkFragmentTest {
    val context = ApplicationProvider.getApplicationContext<Context>()

    @AfterClass
    fun testq() {

    }

    @Test
    fun click_activity_lifecycle_btn() {
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        activity.findViewById<Button>(R.id.btn_activity_lifecycle).performClick()

        val expectedIntent = Intent(activity, StandardActivity::class.java)
        val actual = shadowOf(RuntimeEnvironment.application).nextStartedActivity
        assertThat(expectedIntent.component).isEqualTo(actual.component)
    }

}