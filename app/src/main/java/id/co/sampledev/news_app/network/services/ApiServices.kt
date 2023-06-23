package id.co.sampledev.news_app.network.services

import id.co.sampledev.news_app.network.model.Headlines
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiServices {
    @Headers("Content-Type:application/json")
    @GET("top-headlines?country=id&apiKey=7dadc94cfb19429e931c34e4608b76f6")
    suspend fun getHeadlines(
    ): Response<Headlines>
}