package zw.co.nm.koroutine.networking

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {

    private val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()


    private val apiService:APIService by lazy {
        retrofit.create(
            APIService::class.java
        )
    }

    val apiClient = APIClient(apiService)
}