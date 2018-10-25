package com.ronak.deliciousbaking.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Recipes implements Parcelable {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("ingredients")
    private List<Ingredient> ingredientList = new ArrayList<>();

    @SerializedName("steps")
    private List<Steps> stepsList = new ArrayList<>();

    @SerializedName("image")
    private String imagePath;

    @SerializedName("servings")
    private int servings;


    public Recipes(String recipe_name, String recipe_id, List<Ingredient> ingredientList1,
                   List<Steps> steps,
                   String imagePath1, Integer servings1) {
        name = recipe_name;
        id = recipe_id;
        ingredientList = ingredientList1;
        stepsList = steps;
        imagePath = imagePath1;
        servings = servings1;
    }

    public Recipes(String recipe_name, Integer servings1){
        this.name = recipe_name;
        this.servings = servings1;
    }


    public String getName() {
        return  name;
    }

    public void setName(String name1){
        this.name = name1;
    }

    public String getId() {
        return  id;
    }

    public void setId(String id){
        this.id = id;
    }

    public List<Ingredient> getIngredientList(){
        return  ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList){
        this.ingredientList = ingredientList;
    }

    public List<Steps> getStepsList(){
        return stepsList;
    }

    public void setStepsList(List<Steps> stepsList){
        this.stepsList = stepsList;
    }

    public String getImagePath(){
        return  imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getServings(){
        return  servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(id);
        parcel.writeList(ingredientList);
        parcel.writeList(stepsList);
        parcel.writeInt(servings);
        parcel.writeString(imagePath);
    }

    public Recipes(Parcel in){
        name = in.readString();
        id = in.readString();
        ingredientList = new ArrayList<Ingredient>();
        in.readList(ingredientList, Ingredient.class.getClassLoader());
        stepsList = new ArrayList<Steps>();
        in.readList(stepsList, Steps.class.getClassLoader());
        servings = in.readInt();
        imagePath = in.readString();
    }

    public static final  Creator<Recipes> CREATOR = new Creator<Recipes>() {
        @Override
        public Recipes createFromParcel(Parcel source) {
            return  new Recipes(source);
        }

        @Override
        public Recipes[] newArray(int size) {
            return new Recipes[size];
        }
    };

}
