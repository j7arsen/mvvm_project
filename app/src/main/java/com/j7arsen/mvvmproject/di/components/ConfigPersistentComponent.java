package com.j7arsen.mvvmproject.di.components;

import com.j7arsen.mvvmproject.di.modules.ActivityModule;
import com.j7arsen.mvvmproject.di.modules.DialogFragmentModule;
import com.j7arsen.mvvmproject.di.modules.FragmentModule;
import com.j7arsen.mvvmproject.di.modules.ViewHolderModule;
import com.j7arsen.mvvmproject.di.scopes.ConfigPersistent;

import dagger.Component;

/**
 * Created by j7ars on 13.05.2017.
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

    DialogFragmentComponent dialogFragmentComponent(DialogFragmentModule dialogFragmentModule);

    ViewHolderComponent viewHolderComponent(ViewHolderModule viewHolderModule);

}
