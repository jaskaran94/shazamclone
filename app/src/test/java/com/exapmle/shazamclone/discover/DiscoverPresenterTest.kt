package com.exapmle.shazamclone.discover

import com.exapmle.shazamclone.data.identify.Song
import com.exapmle.shazamclone.data.identify.SongIdentifyService
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by jaskaranhome on 25/01/18.
 */
class DiscoverPresenterTest {
    private val mSong = Song()
    private val mSongIdentifyService: SongIdentifyService = mock()
    private val mDiscoverView: DiscoverContract.View = mock()

    private lateinit var mDiscoverPresenter: DiscoverContract.Presenter

    @Before
    fun setupDiscoverPresenter() {
        // Create a presenter before the test and pass in the DiscoverView as an argument to the Presenter bindView method
        mDiscoverPresenter = DiscoverPresenter(mSongIdentifyService)
        mDiscoverPresenter.bindView(mDiscoverView)
    }

    @After
    fun releasePresenter() {
        // unbind the DiscoverView on the presenter after test
        mDiscoverPresenter.unBindView()
    }

    @Test
    fun onStartIdentifyButtonClickedAndSongWasFoundOpensSongDetailPage() {
        mDiscoverPresenter.onStartIdentifyButtonClicked()
        argumentCaptor<SongIdentifyService.SongIdentificationCallback>().apply() {
            // Ensure that when start discovering button is clicked,
            // a call is made to the SongIdentifyService to start song identification
            // Also capture the callback that is passed to the SongIdentifyService startIdentification function
            verify(mSongIdentifyService).startIdentification(capture())

            // Call the callback onSongFound function passing in the simply song object
            firstValue.onSongFound(mSong)
        }

        // Ensure that when start discovering button is clicked
        // A call is made to hide the start discovering button,
        // A call is made to show stop discovering button,
        // A call is made to show the progress view,
        // A call is mafe to hide any error view
        verify(mDiscoverView).hideStartIdentiifyButton()
        verify(mDiscoverView).showStopIdentifyButtonView()
        verify(mDiscoverView).showIdentifyProgressView()
        verify(mDiscoverView).hideErrorViews()

        // And since the MusicIdentifyService was able to identify the song,
        // ensure that a call was made to open the song detail page
        verify(mDiscoverView).openSongDetailPage(mSong)
    }

    @Test
    fun onStartIdentifyButtonClickedAndSongWasNotFoundShowsSongNotFoundError() {
        mDiscoverPresenter.onStartIdentifyButtonClicked()
        argumentCaptor<SongIdentifyService.SongIdentificationCallback>().apply {
            verify(mSongIdentifyService).startIdentification(capture())
            firstValue.onSongNotFound()
        }

        verify(mDiscoverView).hideStartIdentiifyButton()
        verify(mDiscoverView).showStopIdentifyButtonView()
        verify(mDiscoverView).showIdentifyProgressView()
        verify(mDiscoverView).hideErrorViews()
        verify(mDiscoverView).showIdentifyProgressView()

        // And since the MusicIdentifyService could not identify the song,
        // ensure the a call was made to show a song not found error view
        verify(mDiscoverView).showNotFoundErrorView()
    }

    @Test
    fun onStartIdentifyButtonClickedAndOfflineErrorShowsOfflineErrorView() {
        mDiscoverPresenter.onStartIdentifyButtonClicked()
        argumentCaptor<SongIdentifyService.SongIdentificationCallback>().apply {
            verify(mSongIdentifyService).startIdentification(capture())
            firstValue.onOfflineError()
        }

        verify(mDiscoverView).hideStartIdentiifyButton()
        verify(mDiscoverView).showStopIdentifyButtonView()
        verify(mDiscoverView).showIdentifyProgressView()
        verify(mDiscoverView).hideErrorViews()
        verify(mDiscoverView).showIdentifyProgressView()

        // And since the MusicIdentifyService could not identify a song because the user is offline,
        // ensure that a call was made to show an offline error view

        verify(mDiscoverView).showOfflineErrorView()

    }

    @Test
    fun onStartIdentifyButtonClickedAndGenericErrorShowsGenericErrorView() {
        mDiscoverPresenter.onStartIdentifyButtonClicked()
        argumentCaptor<SongIdentifyService.SongIdentificationCallback>().apply {
            verify(mSongIdentifyService).startIdentification(capture())
            firstValue.onGenericError()
        }

        verify(mDiscoverView).hideStartIdentiifyButton()
        verify(mDiscoverView).showStopIdentifyButtonView()
        verify(mDiscoverView).showIdentifyProgressView()
        verify(mDiscoverView).hideErrorViews()
        verify(mDiscoverView).showIdentifyProgressView()

        // And since the MusicIdentifyService could not identify a song because of a generic error,
        // ensure that a call was made to show an offline error view
        verify(mDiscoverView).showGenericErrorView()
    }

    @Test
    fun onStopIdentifyButtonClicked() {
        mDiscoverPresenter.onStopIdentifyButtonClicked()

        // Ensure that when stop identify button is clicked, music identification is stopped, progress view is hidden,
        // stop discovering button is hidden and start discovering button is shown
        verify(mSongIdentifyService).stopIdentification()
        verify(mDiscoverView).hideIdentifyProgressView()
        verify(mDiscoverView).hideStopIdentifyButtonView()
        verify(mDiscoverView).showStartIdentifyButton()
    }

    @Test
    fun onDonateButtonClicked() {
        mDiscoverPresenter.onDonateButtonClicked()
        // Ensure that when donate button is clicked, a call to open the donate page is made
        verify(mDiscoverView).openDonatePage()
    }

    @Test
    fun onHistoryButtonClicked() {
        mDiscoverPresenter.onHistoryButtonClicked()
        verify(mDiscoverView).openHistoryPage()
    }


}