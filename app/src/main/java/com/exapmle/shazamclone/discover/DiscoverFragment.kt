package com.exapmle.shazamclone.discover

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exapmle.shazamclone.R

class DiscoverFragment : Fragment() {

    val TAG = DiscoverFragment::class.java.simpleName + ".tag"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }
}
