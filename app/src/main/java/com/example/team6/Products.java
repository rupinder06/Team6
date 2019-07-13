package com.example.team6;

import android.os.Parcel;
import android.os.Parcelable;

public class Products implements Parcelable {


    String name;
   String owner,ownerAvatar,languages_url,description;



    public Products(String name, String languages_url)
    {
        this.name=name;
        this.owner= owner;
        this.ownerAvatar=ownerAvatar;
        this.languages_url= languages_url;
        this.description= description;


    }



    protected Products(Parcel in) {

        name=in.readString();
        owner=in.readString();
        ownerAvatar=in.readString();
        languages_url=in.readString();
        description=in.readString();

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
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        dest.writeString(owner);
        dest.writeString(ownerAvatar);
        dest.writeString(description);
        dest.writeString(languages_url);



    }
}
