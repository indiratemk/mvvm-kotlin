package com.example.retrofitmvvm.requests

import com.example.retrofitmvvm.util.Constrants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(Constrants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val recipeApi: RecipeApi by lazy {
        retrofitBuilder
            .build()
            .create(RecipeApi::class.java)
    }
}