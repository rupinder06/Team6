package com.example.team6;

import android.os.Parcel;
import android.os.Parcelable;

public class Products implements Parcelable {


    String name;
   String avatar_url,description,followers_url;



    public Products(String name, String avatar_url, String description, String followers_url)
    {
        this.name=name;

        this.avatar_url=avatar_url;
        this.description=description;
        this.followers_url=followers_url;

    }


    protected Products(Parcel in) {

        name=in.readString();

        avatar_url=in.readString();
        description=in.readString();
        followers_url=in.readString();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);

        dest.writeString(avatar_url);
        dest.writeString(description);
        dest.writeString(followers_url);


    }
}
