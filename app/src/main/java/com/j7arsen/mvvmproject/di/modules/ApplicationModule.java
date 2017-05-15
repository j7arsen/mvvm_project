package com.j7arsen.mvvmproject.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.j7arsen.mvvmproject.di.qualifier.ApplicationContext;
import com.j7arsen.mvvmproject.di.scopes.PerApplication;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import dagger.Module;
import dagger.Provides;

/**
 * Created by j7ars on 13.05.2017.
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application){
        this.mApplication = application;
    }

    @Provides
    @PerApplication
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @PerApplication
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    @PerApplication
    Resources provideResources(){
        return mApplication.getResources();
    }

    @Provides
    @PerApplication
    RefWatcher provideRefWatcher(){
        return LeakCanary.install(mApplication);
    }



}
