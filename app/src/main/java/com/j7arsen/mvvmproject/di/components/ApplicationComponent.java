package com.j7arsen.mvvmproject.di.components;

import android.content.Context;
import android.content.res.Resources;

import com.j7arsen.mvvmproject.di.modules.ApplicationModule;
import com.j7arsen.mvvmproject.di.modules.NetModule;
import com.j7arsen.mvvmproject.di.qualifier.ApplicationContext;
import com.j7arsen.mvvmproject.di.scopes.PerApplication;
import com.j7arsen.mvvmproject.managers.DataManager;
import com.j7arsen.mvvmproject.managers.RequestManager;
import com.squareup.leakcanary.RefWatcher;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by j7ars on 13.05.2017.
 */
@PerApplication
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {

    @ApplicationContext
    Context applicationContext();
    Resources resources();
    RefWatcher refWatcher();
    Retrofit retrofit();

    RequestManager requestManager();
    DataManager dataManager();

}
