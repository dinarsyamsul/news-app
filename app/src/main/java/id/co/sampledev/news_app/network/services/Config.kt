package id.co.sampledev.news_app.network.services

class Config {
    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"

        fun <Api> buildApi(
            api: Class<Api>
        ): Api {
            return retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()
                .create(api)
        }
    }
}