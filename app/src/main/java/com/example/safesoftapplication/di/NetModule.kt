package com.example.safesoftapplication.di

import android.app.Application
import android.content.SharedPreferences
import androidx.databinding.library.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class NetModule {
    @Provides
    @Singleton
    fun provideCache(application: Application): Cache {
        val cacheSize = 10L * 1024 * 1024
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    @Provides
    @Singleton
    @Named("normal_client")
    fun provideOkHttpClient(
        cache: Cache,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val client = OkHttpClient
            .Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .cache(cache)

//        if (BuildConfig.DEBUG)
        client.addInterceptor(loggingInterceptor)

        return client.build()
    }

    @Provides
    @Singleton
    @Named("secure_client")
    fun provideOkHttpClientAuthorized(
        cache: Cache,
        loggingInterceptor: HttpLoggingInterceptor,
        accessToken: String
    ): OkHttpClient {
        val client = OkHttpClient
            .Builder()
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain.request().newBuilder()
                        .addHeader("Authorisation", accessToken)
                        .method(chain.request().method(), chain.request().body())
                        .build()
                    return chain.proceed(request)
                }
            })
            .cache(cache)

        if (BuildConfig.DEBUG)
        client.addInterceptor(loggingInterceptor)

        return client.build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    }

    @Provides
    @Singleton
    @Named("normal_retro")
    fun provideRetrofit(
        gson: Gson,
        @Named("normal_client") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://192.168.1.200:8080/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("secure_retro")
    fun provideRetrofitAuthorized(
        gson: Gson,
        @Named("secure_client") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://192.168.1.200:8080/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideApiKey(prefs: SharedPreferences): String {
        return "Token " + prefs.getString("access_token", "")!!
    }
}