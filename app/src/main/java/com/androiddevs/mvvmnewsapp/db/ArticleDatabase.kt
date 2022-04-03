package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androiddevs.mvvmnewsapp.models.Article

//this is database class for room, abstract is mandatory for database class
@Database(
    //list of entity, here article as an array
    entities = [Article::class],
    version = 1 //use to update db, like changes at some point
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    //returns article dao
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile //other threads can see when threads changes instance
        private var instance: ArticleDatabase? = null
        private val LOCK = Any() //synchronise setting that instance, only single instance at once it should be

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}