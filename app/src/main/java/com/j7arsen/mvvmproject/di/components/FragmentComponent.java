package com.j7arsen.mvvmproject.di.components;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;

import com.j7arsen.mvvmproject.di.modules.FragmentModule;
import com.j7arsen.mvvmproject.di.modules.ViewModelModule;
import com.j7arsen.mvvmproject.di.qualifier.ActivityFragmentManagerContext;
import com.j7arsen.mvvmproject.di.qualifier.ChildFragmentManagerContext;
import com.j7arsen.mvvmproject.di.qualifier.FragmentContext;
import com.j7arsen.mvvmproject.di.scopes.PerFragment;

import dagger.Subcomponent;

/**
 * Created by j7ars on 13.05.2017.
 */
@PerFragment
@Subcomponent(modules = {FragmentModule.class, ViewModelModule.class})
public interface FragmentComponent {

    Fragment fragment();
    Activity activity();
    @FragmentContext
    Context context();
    @ActivityFragmentManagerContext
    FragmentManager fragmentManager();
    @ChildFragmentManagerContext
    FragmentManager childFragmentManager();

    //inject fragment

}
