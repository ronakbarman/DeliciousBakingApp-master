package com.ronak.deliciousbaking.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.google.gson.Gson;
import com.ronak.deliciousbaking.R;
import com.ronak.deliciousbaking.models.Ingredient;
import com.ronak.deliciousbaking.models.Recipes;

import java.util.List;

public class IngredientRemoteViewFactory implements RemoteViewsService.RemoteViewsFactory, SharedPreferences.OnSharedPreferenceChangeListener {

    private Context context;
    private List<Ingredient> ingredientList = null;

    public IngredientRemoteViewFactory(@NonNull final Context context1){
        context = context1;
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        fetch_Ingredients(sharedPreferences);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {


        if (key.equals("recipe_on_widget")){
            fetch_Ingredients(sharedPreferences);
        }

    }

    private void fetch_Ingredients(final SharedPreferences sharedPreferences){
        final String recipeJsonStr = sharedPreferences.getString("recipe_on_widget",null);
        final Recipes recipes = (null == recipeJsonStr) ? null: new Gson().fromJson(recipeJsonStr, Recipes.class);
        if (null != recipes){
            ingredientList = recipes.getIngredientList();
            onDataSetChanged();
        }
    }

    @Override
    public void onCreate() {
    final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {
final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public int getCount() {
        return (null == ingredientList) ? 0 : ingredientList.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.ingredient_items);
        final Ingredient ingredient = ingredientList.get(position);
        final String ingredientName = ingredient.getIngredient();
        final String ingredientText = context.getString(R.string.ingredients_format, String.valueOf(ingredient.getQuantity()), ingredient.getMeasure());
        remoteViews.setTextViewText(R.id.ingredientName, ingredientName);
        remoteViews.setTextViewText(R.id.ingredient, ingredientText);
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


}
