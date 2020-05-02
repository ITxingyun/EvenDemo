package com.xingyun.evendemo.view.shareelement

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.SharedElementCallback
import androidx.databinding.DataBindingUtil
import com.xingyun.evendemo.R
import com.xingyun.evendemo.databinding.ActivityShareElementBinding

/**
 * https://guides.codepath.com/android/shared-element-activity-transition
 * https://developer.android.com/training/transitions/start-activity
 */
class ShareElementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShareElementBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_share_element)
        val text = intent.getStringExtra("share") ?: ""

        setEnterSharedElementCallback(object : SharedElementCallback() {
            override fun onSharedElementEnd(sharedElementNames: MutableList<String>?, sharedElements: MutableList<View>?, sharedElementSnapshots: MutableList<View>?) {
                super.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots)
            }

            override fun onRejectSharedElements(rejectedSharedElements: MutableList<View>?) {
                super.onRejectSharedElements(rejectedSharedElements)
            }

            override fun onMapSharedElements(names: MutableList<String>?, sharedElements: MutableMap<String, View>?) {
                super.onMapSharedElements(names, sharedElements)
            }
        })

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ShareElementFragment.newInstance(text))
                .commit()
        }
    }

    override fun onBackPressed() {
        setResult(1)
        super.onBackPressed()
    }

}