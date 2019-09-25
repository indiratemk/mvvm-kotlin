package com.example.retrofitmvvm

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.retrofitmvvm.requests.ServiceGenerator
import com.example.retrofitmvvm.util.Constrants
import kotlinx.android.synthetic.main.activity_recipe_list.*
import kotlinx.coroutines.*

class RecipeListActivity: BaseActivity() {

    var job: CompletableJob? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        test.setOnClickListener{
            if (progressBar.visibility == View.VISIBLE) showProgressBar(false) else showProgressBar(true)
        }

        testRetrofitRequest()
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