package com.ronak.deliciousbaking.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Steps implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("shortDescription")
    private String shortDescription;

    @SerializedName("description")
    private String description;

    @SerializedName("videoURL")
    private String videoURL;

    @SerializedName("thumbnailURL")
    private String thumbnailURL;

    public Steps(int stepId, String shortDescription, String description,
                 String videoURL, String thumbnailURL) {

        this.id= stepId;
        this.shortDescription = shortDescription;
        this.description = description;
        this.videoURL = videoURL;
        this.thumbnailURL = thumbnailURL;

    }


    public int getId(){
        return id;
    }
    public void setId(int stepId){
        this.id = stepId;
    }

    public String getShortDescription(){
        return shortDescription;
    }
    public void setShortDescription(String shortDescription){
        this.shortDescription = shortDescription;
    }


    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public String getVideoURL(){
        return videoURL;
    }
    public void setVideoURL(String videoURL){
        this.videoURL = videoURL;

    }


    public String getThumbnailURL(){
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeInt(id);
    parcel.writeString(shortDescription);
    parcel.writeString(description);
    parcel.writeString(videoURL);
    parcel.writeString(thumbnailURL);
    }


    public Steps(Parcel in) {
        id = in.readInt();
        shortDescription = in.readString();
        description = in.readString();
        videoURL = in.readString();
        thumbnailURL = in.readString();
    }

    public static final Creator<Steps> CREATOR = new Creator<Steps> (){
        @Override
        public Steps createFromParcel(Parcel in) {
            return new Steps(in);
        }

        @Override
        public Steps[] newArray(int size) {
            return new Steps[size];
        }
    };

}
