package com.example.team6;

import android.os.Parcel;
import android.os.Parcelable;

public class Products implements Parcelable {


    String name;
   String follower,ownerAvatar,languages_url,description,avatar_url,following;



    public Products(String name, String follower, String ownerAvatar,String languages_url,String description,String avatar_url,String following)
    {
        this.name=name;
        this.follower= follower;
        this.ownerAvatar=ownerAvatar;
        this.languages_url= languages_url;
        this.description= description;
        this.avatar_url=avatar_url;
        this.following=following;



    }



    protected Products(Parcel in) {

        name=in.readString();
        follower=in.readString();
        ownerAvatar=in.readString();
        languages_url=in.readString();
        description=in.readString();
        avatar_url=in.readString();
        following=in.readString();

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
    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }
    public String getOwnerAvatar() {
        return ownerAvatar;
    }

    public void setOwnerAvatar(String ownerAvatar) {
        this.ownerAvatar = ownerAvatar;
    }

    public String getLanguages_url() {
        return languages_url;
    }

    public void setLanguages_url(String languages_url) {
        this.languages_url = languages_url;
    }
    public String getOwner() {
        return follower;
    }

    public void setOwner(String owner) {
        this.follower = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        dest.writeString(follower);
        dest.writeString(ownerAvatar);
        dest.writeString(description);
        dest.writeString(languages_url);
        dest.writeString(avatar_url);
        dest.writeString(following);



    }
}
