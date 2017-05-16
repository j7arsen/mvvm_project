package com.j7arsen.mvvmproject.managers;

import com.j7arsen.mvvmproject.di.scopes.PerApplication;
import com.j7arsen.mvvmproject.network.Urls;
import com.j7arsen.mvvmproject.network.response.PeopleResponse;
import com.j7arsen.mvvmproject.network.service.PeopleService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by arsen on 15.05.17.
 */
@PerApplication
public class RequestManager {

    private Retrofit mRetrofit;

    @Inject
    public RequestManager(Retrofit retrofit){
        this.mRetrofit = retrofit;
    }

    private <S> S createService(Class<S> serviceClass){
        return mRetrofit.create(serviceClass);
    }

    public Observable<PeopleResponse> fetchPeople(){
        return createService(PeopleService.class).fetchPeople(Urls.GET_PEOPLE_URL).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
