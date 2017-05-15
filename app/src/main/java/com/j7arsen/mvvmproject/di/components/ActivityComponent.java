package com.j7arsen.mvvmproject.di.components;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;

import com.j7arsen.mvvmproject.MainActivity;
import com.j7arsen.mvvmproject.di.modules.ActivityModule;
import com.j7arsen.mvvmproject.di.modules.ViewHolderModule;
import com.j7arsen.mvvmproject.di.modules.ViewModelModule;
import com.j7arsen.mvvmproject.di.qualifier.ActivityContext;
import com.j7arsen.mvvmproject.di.qualifier.ActivityFragmentManagerContext;
import com.j7arsen.mvvmproject.di.scopes.PerActivity;
import com.j7arsen.mvvmproject.main.people.view.PeopleActivity;

import dagger.Subcomponent;

/**
 * Created by j7ars on 13.05.2017.
 */
@PerActivity
@Subcomponent(modules = {ActivityModule.class, ViewModelModule.class})
public interface ActivityComponent {

    @ActivityContext
    Context activityContext();
    @ActivityFragmentManagerContext
    FragmentManager fragmentManager();
    Activity activity();

    ViewHolderComponent viewHolderComponent(ViewHolderModule viewHolderModule);

    //inject activity
    void inject(MainActivity activity);
    void inject(PeopleActivity peopleActivity);

}
