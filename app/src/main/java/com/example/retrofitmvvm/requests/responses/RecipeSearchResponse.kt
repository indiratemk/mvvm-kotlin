package com.example.retrofitmvvm.requests.responses

import com.example.retrofitmvvm.models.Recipe
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(

    @Expose
    @SerializedName("count")
    val count: Int? = null,

    @Expose
    @SerializedName("recipes")
    val recipes: List<Recipe> = emptyList()
) {

    override fun toString(): String {
        return "RecipesSearchResponse{" +
                "count= $count, recipes= $recipes}"
    }
}