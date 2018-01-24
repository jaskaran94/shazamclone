package com.exapmle.shazamclone.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by jaskaranhome on 24/01/18.
 */
object FragmentUtils {
    fun addIfNotExist(fm: FragmentManager, containerRes: Int, fragment: Fragment, tag: String) {
        val existingFragmentWithTag = fm.findFragmentByTag(tag)

        if (existingFragmentWithTag == null) {
            fm.beginTransaction().add(containerRes, fragment, tag).commit()
        }
    }
}