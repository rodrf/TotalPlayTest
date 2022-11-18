package com.universe.totalplaytest.di

import com.airbnb.lottie.BuildConfig
import com.universe.totalplaytest.data.network.TotalplayApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val customClient = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)

        /*Enable only when debug mode is active*/
        if(BuildConfig.DEBUG){
            customClient.addInterceptor(interceptor)
        }

        val clientBuilder = customClient.build()

        return Retrofit.Builder()
            .baseUrl("https://ott.totalplay.com.mx/AppTest0/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder)
            .build()
    }
    @Singleton
    @Provides
    fun provideTotalplayApi(retrofit: Retrofit): TotalplayApiClient{
        return retrofit.create(TotalplayApiClient::class.java)
    }
}