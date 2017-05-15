package com.j7arsen.mvvmproject.managers;

import com.j7arsen.mvvmproject.network.response.PeopleResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by arsen on 15.05.17.
 */

public class DataManager {

    private RequestManager mRequestManager;

    @Inject
    public DataManager(RequestManager requestManager){
        this.mRequestManager = requestManager;
    }

    public Observable<PeopleResponse> fetchPeople(){
        return mRequestManager.fetchPeople();
    }

}
