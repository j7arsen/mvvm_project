package com.j7arsen.mvvmproject.dataclasses;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by j7ars on 14.05.2017.
 */
@Parcel(Parcel.Serialization.BEAN)
public class Id {

    @SerializedName("name")
    private String name;
    @SerializedName("value")
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
