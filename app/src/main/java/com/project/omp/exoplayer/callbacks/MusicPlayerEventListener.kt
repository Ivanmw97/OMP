package com.project.omp.exoplayer.callbacks

import android.widget.Toast
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.Player
import com.project.omp.exoplayer.MusicService

class MusicPlayerEventListener(
    private val musicServer: MusicService
) : Player.EventListener {

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)
        if (playbackState == Player.STATE_READY && !playWhenReady) {
            musicServer.stopForeground(false)
        }
    }

    override fun onPlayerError(error: ExoPlaybackException) {
        super.onPlayerError(error)
        Toast.makeText(musicServer, "An unknown error", Toast.LENGTH_LONG).show()
    }
}