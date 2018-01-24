package com.exapmle.shazamclone.data.identify

/**
 * Created by jaskaranhome on 25/01/18.
 */
interface SongIdentifyService {
    fun startIdentification(callback: SongIdentificationCallback)

    fun stopIdentification()

    interface SongIdentificationCallback {
        fun onOfflineError()
        fun onGenericError()
        fun onSongNotFound()
        fun onSongFound(song: Song)

    }
}