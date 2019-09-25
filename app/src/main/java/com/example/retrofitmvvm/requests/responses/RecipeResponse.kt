package com.example.retrofitmvvm.requests.responses

import com.example.retrofitmvvm.models.Recipe
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeResponse(

    @Expose
    @SerializedName("recipe")
    val recipe: Recipe? = null
) {

    override fun toString(): String {
        return "RecipeResponse{ recipe= $recipe}"
    }
}