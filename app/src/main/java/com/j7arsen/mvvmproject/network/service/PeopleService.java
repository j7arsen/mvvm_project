package com.j7arsen.mvvmproject.network.service;

import com.j7arsen.mvvmproject.network.response.PeopleResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by j7ars on 14.05.2017.
 */

public interface PeopleService {

    @GET
    Observable<PeopleResponse> fetchPeople(@Url String url);

}
