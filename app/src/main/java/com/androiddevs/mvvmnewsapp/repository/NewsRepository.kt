package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article

//it will show the breaking news
class NewsRepository(
    val db: ArticleDatabase
) {

    //network fun should be suspend
    //suspend so can call within a coroutine or another suspend function
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    //search news function from api
    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)


    //inert an article to the saved fragment
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    //live data to get articles function
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    //delete article function
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}