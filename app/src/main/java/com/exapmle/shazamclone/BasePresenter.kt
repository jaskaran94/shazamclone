package com.exapmle.shazamclone

/**
 * Created by jaskaranhome on 25/01/18.
 */
interface BasePresenter<in V> {
    // This method is called by the View on the presenter when it is active
    fun bindView(view: V)

    // This method is called by the View when it is no longer active
    fun unBindView()
}