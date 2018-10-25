package com.ronak.deliciousbaking.network;

import com.ronak.deliciousbaking.models.Recipes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeDatabase {
//todo check go in
    public static final String URL = "http://go.udacity.com";

    @GET("android-baking-app-json")
    Call<List<Recipes>> getRecipes();
}
