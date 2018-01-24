package com.exapmle.shazamclone.discover

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.exapmle.shazamclone.R
import com.exapmle.shazamclone.utils.FragmentUtils

class DiscoverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)
        FragmentUtils.addIfNotExist(supportFragmentManager, R.id.discover_fragment_container, DiscoverFragment(), "discoverfragment")

    }
}
