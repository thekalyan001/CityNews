package com.androiddevs.mvvmnewsapp.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


//tell studio this class is a table in db
@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null, //unique id, primary key, null as not all article will have unique id as we'll not save all the article in db
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable