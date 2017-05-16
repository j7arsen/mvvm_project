package com.j7arsen.mvvmproject.di.components;

import com.j7arsen.mvvmproject.di.modules.FragmentModule;
import com.j7arsen.mvvmproject.di.modules.ViewModelModule;
import com.j7arsen.mvvmproject.di.scopes.PerFragment;

import dagger.Component;

/**
 * Created by j7ars on 13.05.2017.
 */
@PerFragment
@Component(dependencies = ActivityComponent.class, modules = {FragmentModule.class, ViewModelModule.class})
public interface FragmentComponent {

    //inject fragment

}
