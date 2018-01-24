package com.exapmle.shazamclone.discover

import com.exapmle.shazamclone.BasePresenter
import com.exapmle.shazamclone.BaseView
import com.exapmle.shazamclone.data.identify.Song

/**
 * Created by jaskaranhome on 25/01/18.
 */
interface DiscoverContract {
    interface View: BaseView<Presenter>{
        // show/hide progress view
        fun showIdentifyProgressView()
        fun hideIdentifyProgressView()

        // show/hide start button
        fun showStartIdentifyButton()
        fun hideStartIdentiifyButton()

        // show/hide stop button
        fun showStopIdentifyButtonView()
        fun hideStopIdentifyButtonView()

        // show error views
        fun showOfflineErrorView()
        fun showGenericErrorView()
        fun showNotFoundErrorView()
        // Function to hide them all
        fun hideErrorViews()


        // open the activities
        fun openSongDetailPage(song: Song)
        fun openDonatePage()
        fun openHistoryPage()
    }

    interface Presenter: BasePresenter<View>{
        // Called when the user clicks on start button
        fun onStartIdentifyButtonClicked()

        // Called when the user clicks on the stop button
        fun onStopIdentifyButtonClicked()

        // Called when the user clicks on the donate button
        fun onDonateButtonClicked()

        // Called when the user clicks on the history button
        fun onHistoryButtonClicked()

    }

}