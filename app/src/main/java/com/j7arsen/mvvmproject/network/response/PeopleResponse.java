package com.j7arsen.mvvmproject.network.response;

import com.google.gson.annotations.SerializedName;
import com.j7arsen.mvvmproject.dataclasses.Info;
import com.j7arsen.mvvmproject.dataclasses.People;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by j7ars on 14.05.2017.
 */
@Parcel(Parcel.Serialization.BEAN)
public class PeopleResponse {

    @SerializedName("results")
    private List<People> mPeopleList;
    @SerializedName("info")
    private Info mInfo;

    public List<People> getPeopleList() {
        return mPeopleList;
    }

    public void setPeopleList(List<People> mPeopleList) {
        this.mPeopleList = mPeopleList;
    }

    public Info getInfo() {
        return mInfo;
    }

    public void setInfo(Info mInfo) {
        this.mInfo = mInfo;
    }
}
