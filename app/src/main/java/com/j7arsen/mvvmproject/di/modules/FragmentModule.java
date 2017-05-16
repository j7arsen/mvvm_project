package com.j7arsen.mvvmproject.di.modules;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;

import com.j7arsen.mvvmproject.di.qualifier.ActivityFragmentManagerContext;
import com.j7arsen.mvvmproject.di.qualifier.ChildFragmentManagerContext;
import com.j7arsen.mvvmproject.di.qualifier.FragmentContext;
import com.j7arsen.mvvmproject.di.scopes.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by j7ars on 13.05.2017.
 */
@Module
public class FragmentModule {

    private final Fragment mFragment;

    public FragmentModule(Fragment fragment){
        this.mFragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment provideFragment(){
        return mFragment;
    }

    @Provides
    @PerFragment
    Activity provideActivity(){
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    @FragmentContext
    Context provideContext(){
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    @ActivityFragmentManagerContext
    FragmentManager provideFragmentManager(){
        return mFragment.getFragmentManager();
    }

    @Provides
    @PerFragment
    @ChildFragmentManagerContext
    FragmentManager provideChildFragmentManager(){
        return mFragment.getChildFragmentManager();
    }



}
