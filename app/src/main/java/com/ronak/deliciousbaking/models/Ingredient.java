package com.ronak.deliciousbaking.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Ingredient implements Parcelable {

    @SerializedName("quantity")
    private Double quantity;

    @SerializedName("measure")
    private String measure;

    @SerializedName("ingredient")
    private  String ingredient;


    public Ingredient(double quantity, String measure, String ingredient){
        this.quantity = quantity;
        this.ingredient = ingredient;
        this.measure = measure;
    }

    public String getMeasure() {
        return measure;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
     parcel.writeDouble(quantity);
     parcel.writeString(measure);
     parcel.writeString(ingredient);
    }

    public  Ingredient(Parcel in) {
        quantity = in.readDouble();
        measure = in.readString();
        ingredient = in.readString();
    }


    public  static  final  Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

}
