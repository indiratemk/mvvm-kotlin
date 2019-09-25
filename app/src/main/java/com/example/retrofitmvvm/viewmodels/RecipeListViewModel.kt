package com.example.retrofitmvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvm.models.Recipe

class RecipeListViewModel: ViewModel() {

    private val mutableRecipes = MutableLiveData<List<Recipe>>()

    val recipes: LiveData<List<Recipe>>
        get() = mutableRecipes


    class Factory(): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RecipeListViewModel::class.java)) {
                return RecipeListViewModel() as T
            }

            throw IllegalStateException("ERROR!!!")
        }
    }
}