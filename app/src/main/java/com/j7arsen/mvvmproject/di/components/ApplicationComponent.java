package com.j7arsen.mvvmproject.di.components;

import android.content.Context;
import android.content.res.Resources;

import com.j7arsen.mvvmproject.di.modules.ApplicationModule;
import com.j7arsen.mvvmproject.di.qualifier.ApplicationContext;
import com.j7arsen.mvvmproject.di.scopes.PerApplication;
import com.squareup.leakcanary.RefWatcher;

import dagger.Component;

/**
 * Created by j7ars on 13.05.2017.
 */
@PerApplication
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context applicationContext();
    Resources resources();
    RefWatcher refWatcher();


}
