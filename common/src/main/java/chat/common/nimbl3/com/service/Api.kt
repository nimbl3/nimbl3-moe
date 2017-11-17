package chat.common.nimbl3.com.service

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private val BASE_URL = "https://api.dialogflow.com/v1/"

    private val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

    val service = builder.build().create(ApiInterface::class.java)

    private fun createHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
                .addInterceptor(OurInterceptor())
                .addNetworkInterceptor(loggingInterceptor)
                .build()
    }
}

class OurInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        var request = chain?.request()
        var requestBuilder = request?.newBuilder()
        requestBuilder!!.addHeader("Authorization", "Bearer 479aa896137742a1959273fa9ce5e551")
        requestBuilder!!.addHeader("Content-Type", "application/json")
        return chain!!.proceed(requestBuilder.build())
    }
}