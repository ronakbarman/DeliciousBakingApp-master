package com.ronak.deliciousbaking.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RemoteViews;

import com.google.gson.Gson;
import com.ronak.deliciousbaking.R;
import com.ronak.deliciousbaking.models.Recipes;

public class IngredientWidgetProvider extends AppWidgetProvider {

    public static void updateWidget(final Context context, final Recipes recipes){
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        final String jsonStr = new Gson().toJson(recipes);
        sharedPreferences.edit().putString("recipe_on_widget", jsonStr).apply();
        final Class<IngredientWidgetProvider> widgetProviderClass = IngredientWidgetProvider.class;
        final Intent widget_Intent = new Intent(context, widgetProviderClass);
        widget_Intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        final int[] widgetId = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, widgetProviderClass));
        widget_Intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,widgetId);
        context.sendBroadcast(widget_Intent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(AppWidgetManager.ACTION_APPWIDGET_UPDATE)){
            final  AppWidgetManager widgetManager = AppWidgetManager.getInstance(context);
            final ComponentName componentName = new ComponentName(context, IngredientWidgetProvider.class);
            widgetManager.notifyAppWidgetViewDataChanged(widgetManager.getAppWidgetIds(componentName), R.id.widget_ingredients);
        }
        super.onReceive(context,intent);
    }

    @Override
    public void onUpdate( final Context context,final AppWidgetManager appWidgetManager,final int[] appWidgetIds) {
        for (int Id:appWidgetIds){
            final  Recipes recipes = getSelectedRecipe(context);
            final RemoteViews remoteViews =  getRemoteViews(context);
            if (null != recipes){
                show_IngredientsList(remoteViews, context, Id, recipes);
            }else {
                show_EmptyMessage(remoteViews);
            }
            appWidgetManager.updateAppWidget(Id, remoteViews);
        }
        super.onUpdate(context, appWidgetManager,appWidgetIds);
    }

    private void show_IngredientsList(final RemoteViews remoteViews, final Context context, final int id,final Recipes recipes){
        remoteViews.setViewVisibility(R.id.empty_widget, View.GONE);
        remoteViews.setTextViewText(R.id.widget_title, recipes.getName());
        remoteViews.setViewVisibility(R.id.widget_title, View.VISIBLE);
        remoteViews.setViewVisibility(R.id.widget_ingredients, View.VISIBLE);

        final Intent intent = new Intent(context,IngredientWidgetService.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, id);
        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
        remoteViews.setRemoteAdapter(R.id.widget_ingredients,intent);
    }

    private void show_EmptyMessage(final RemoteViews remoteViews){
        remoteViews.setViewVisibility(R.id.widget_title, View.GONE);
        remoteViews.setViewVisibility(R.id.widget_ingredients, View.GONE);
        remoteViews.setViewVisibility(R.id.empty_widget, View.VISIBLE);
    }

    private RemoteViews getRemoteViews(final Context context){
        return  new RemoteViews(context.getPackageName(),R.layout.widget);
    }

    private  Recipes getSelectedRecipe(final Context context){
        final  SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        final String recipe_jsonStr = sharedPreferences.getString("recipe_on_widget",null);
        return(null == recipe_jsonStr) ? null : new Gson().fromJson(recipe_jsonStr, Recipes.class);
    }

}
