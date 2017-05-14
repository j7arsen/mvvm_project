package com.j7arsen.mvvmproject.di.components;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.databinding.ViewDataBinding;

import com.j7arsen.mvvmproject.base.BaseFragment;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.di.modules.FragmentModule;
import com.j7arsen.mvvmproject.di.modules.ViewModelModule;
import com.j7arsen.mvvmproject.di.qualifier.ActivityContext;
import com.j7arsen.mvvmproject.di.qualifier.ActivityFragmentManagerContext;
import com.j7arsen.mvvmproject.di.qualifier.ChildFragmentManagerContext;
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
    @ActivityContext
    Context context();
    @ActivityFragmentManagerContext
    FragmentManager fragmentManager();
    @ChildFragmentManagerContext
    FragmentManager childFragmentManager();

    //inject fragment

}
