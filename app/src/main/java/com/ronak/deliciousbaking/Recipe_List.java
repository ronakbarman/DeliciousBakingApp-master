package com.ronak.deliciousbaking;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ronak.deliciousbaking.adapters.RecipeAdapter;
import com.ronak.deliciousbaking.models.Recipes;
import com.ronak.deliciousbaking.network.FetchRecipesAsyncTask;

public class Recipe_List extends AppCompatActivity implements RecipeAdapter.OnClickListener,FetchRecipesAsyncTask.Listener {

    private RecipeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe__list);

        final RecyclerView recyclerView = findViewById(R.id.recipe_recycler);
        final RecipeAdapter.OnClickListener listener = this;

        adapter = new RecipeAdapter(listener);
        recyclerView.setAdapter(adapter);

        int count = 1;
        final int orientation =  this.getResources().getConfiguration().orientation;
        if (Configuration.ORIENTATION_LANDSCAPE == orientation){
            count = 3;
        }

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, count);
        recyclerView.setLayoutManager(gridLayoutManager);

        new FetchRecipesAsyncTask(this).execute();

    }

    @Override
    public void onFetchRecipeFinished(Recipes[] recipes) {
        adapter.setRecipes(recipes);
    }

    @Override
    public void onItemClick(Recipes recipes) {
        final Intent intent = new Intent(this, Recipe_detail.class);
        intent.putExtra(Recipe_detail.RECIPE_DATA, recipes);
        startActivity(intent);
    }

}

