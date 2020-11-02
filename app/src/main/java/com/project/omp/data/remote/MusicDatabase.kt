package com.project.omp.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.project.omp.data.entities.Song
import com.project.omp.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {

    private  val firestore = FirebaseFirestore.getInstance()
    private val  songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}