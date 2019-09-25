package com.example.retrofitmvvm

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.retrofitmvvm.requests.ServiceGenerator
import com.example.retrofitmvvm.util.Constrants
import com.example.retrofitmvvm.viewmodels.RecipeListViewModel
import kotlinx.android.synthetic.main.activity_recipe_list.*
import kotlinx.coroutines.*

class RecipeListActivity: BaseActivity() {

    var job: CompletableJob? = null
    private lateinit var recipeListViewModel: RecipeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        recipeListViewModel = ViewModelProviders.of(this,
            RecipeListViewModel.Factory())[RecipeListViewModel::class.java]

        test.setOnClickListener{
            if (progressBar.visibility == View.VISIBLE) showProgressBar(false) else showProgressBar(true)
        }

//        testRetrofitRequest()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        recipeListViewModel.recipes.observe(this, Observer {

        })
    }
    
    private fun testRetrofitRequest() {
        job = Job()
        job?.let {localJob ->
            CoroutineScope(Dispatchers.IO + localJob).launch {
                val recipe = ServiceGenerator.recipeApi.getRecipe(Constrants.API_KEY, "8c0314")
                withContext(Dispatchers.Main) {
                    Log.d("taaaag", "result: $recipe")
                    localJob.complete()
                }
            }
        }
    }
}