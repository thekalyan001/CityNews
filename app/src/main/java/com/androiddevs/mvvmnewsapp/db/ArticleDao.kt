package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long //insert article id

    // when article in list changes then live data will get notified , List<Article>
    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>> //return live data object


    //delete article in database
    @Delete
    suspend fun deleteArticle(article: Article)
}