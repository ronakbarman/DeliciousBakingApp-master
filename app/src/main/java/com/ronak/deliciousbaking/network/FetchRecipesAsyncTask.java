package com.ronak.deliciousbaking.network;

import android.os.AsyncTask;
import android.util.Log;

import com.ronak.deliciousbaking.models.Recipes;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FetchRecipesAsyncTask extends AsyncTask<Void, Void, Recipes[]> {

    private Listener listener;
    private String TAG = FetchRecipesAsyncTask.class.getName();
    public interface Listener{
        void onFetchRecipeFinished(Recipes[] recipes);
    }


    public FetchRecipesAsyncTask(Listener listener1){
        listener = listener1;
    }

    @Override
    protected Recipes[] doInBackground(Void... params) {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(RecipeDatabase.URL).addConverterFactory(GsonConverterFactory.create()).build();


        final Class<RecipeDatabase> recipeDatabaseDef = RecipeDatabase.class;

        RecipeDatabase recipeDatabase = retrofit.create(recipeDatabaseDef);

        final Call<List<Recipes>> call = recipeDatabase.getRecipes();
        if (null == call) {
            return null;
        }

        try{
            final Response<List<Recipes>> response = call.execute();
            if (response.isSuccessful()){
                final List<Recipes> recipes = response.body();

                return recipes.toArray(new Recipes[0]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Recipes[] recipes) {
        notifyTaskCompletion(recipes);
    }

    @Override
    protected void onCancelled() {
        notifyTaskCompletion(null);



    }

    private void notifyTaskCompletion( final Recipes[] recipes) {
        if (null == listener){
            Log.w(TAG, "nothing's listening" );
        }else {
            listener.onFetchRecipeFinished(recipes);
        }
    }
}
