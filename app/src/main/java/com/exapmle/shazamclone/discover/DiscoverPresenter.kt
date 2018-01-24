package com.exapmle.shazamclone.discover

import com.exapmle.shazamclone.data.identify.SongIdentifyService

/**
 * Created by jaskaranhome on 25/01/18.
 */
class DiscoverPresenter(private val songIdentifyService: SongIdentifyService): DiscoverContract.Presenter {
    override fun bindView(view: DiscoverContract.View) {

    }

    override fun unBindView() {
    }

    override fun onStartIdentifyButtonClicked() {
    }

    override fun onStopIdentifyButtonClicked() {
    }

    override fun onDonateButtonClicked() {
    }

    override fun onHistoryButtonClicked() {
    }

}