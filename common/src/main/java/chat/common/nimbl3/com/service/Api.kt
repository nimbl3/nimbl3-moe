package chat.common.nimbl3.com.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by trung on 10/19/17.
 */

object Api {
    private val BASE_URL = "https://api.github.com/"

    private val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

    val service = builder.build().create(GithubApi::class.java)
}
