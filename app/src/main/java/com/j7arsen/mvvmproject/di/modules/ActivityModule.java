package com.j7arsen.mvvmproject.di.modules;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;

import com.j7arsen.mvvmproject.di.qualifier.ActivityContext;
import com.j7arsen.mvvmproject.di.qualifier.ActivityFragmentManagerContext;
import com.j7arsen.mvvmproject.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by j7ars on 13.05.2017.
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity){
        this.mActivity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity(){
        return mActivity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Context provideActivityContext(){
        return mActivity;
    }

    @Provides
    @PerActivity
    @ActivityFragmentManagerContext
    FragmentManager provideFragmentManager(){
        return mActivity.getFragmentManager();
    }

}
