package com.example.team6;

import android.os.Parcel;
import android.os.Parcelable;

public class Products implements Parcelable {


    String name;
   String pdesc;




    public Products(String name)
    {
        this.name=name;
        this.pdesc=pdesc;

    }



    protected Products(Parcel in) {

        name=in.readString();
        pdesc=in.readString();
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(pdesc);



    }
}
