package com.example.retrofitmvvm.requests

import com.example.retrofitmvvm.requests.responses.RecipeResponse
import com.example.retrofitmvvm.requests.responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("api/search")
    suspend fun searchRecipe(@Query("key") key: String,
                             @Query("q") query: String,
                             @Query("page") page: String): RecipeSearchResponse

    @GET("api/get")
    suspend fun getRecipe(@Query("key") key: String,
                          @Query("rId") recipeId: String): RecipeResponse
}