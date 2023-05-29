package com.example.laboratorio05.data.dao

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.data.model.CastModel
import com.example.laboratorio05.data.model.MovieModel

@Database(entities = [MovieModel::class, ActorModel::class, CastModel::class], version = 1)
abstract class MovieReviewerDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao

    abstract fun actorDao(): ActorDao

    abstract fun castDao(): CastDao

    companion object{
        @Volatile
        private var INSTANCE: MovieReviewerDatabase? = null

        fun newInstace (application: Application): MovieReviewerDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room
                    .databaseBuilder(
                        application.applicationContext,
                        MovieReviewerDatabase::class.java,
                        "movie_reviewer"
                    ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}