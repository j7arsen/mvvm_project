package com.j7arsen.mvvmproject.di.modules;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;

import com.j7arsen.mvvmproject.di.qualifier.ActivityContext;
import com.j7arsen.mvvmproject.di.qualifier.ActivityFragmentManagerContext;
import com.j7arsen.mvvmproject.di.qualifier.ChildFragmentManagerContext;
import com.j7arsen.mvvmproject.di.scopes.PerDialogFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by j7ars on 13.05.2017.
 */
@Module
public class DialogFragmentModule {

    private DialogFragment mDialogFragment;

    public DialogFragmentModule(DialogFragment dialogFragment) {
        mDialogFragment = dialogFragment;
    }

    @Provides
    @PerDialogFragment
    DialogFragment provideDialogFragment(){
        return mDialogFragment;
    }

    @Provides
    @PerDialogFragment
    Activity provideActivity(){
        return mDialogFragment.getActivity();
    }

    @Provides
    @PerDialogFragment
    @ActivityContext
    Context provideContext(){
        return mDialogFragment.getActivity();
    }

    @Provides
    @PerDialogFragment
    @ActivityFragmentManagerContext
    FragmentManager provideFragmentManager(){
        return mDialogFragment.getFragmentManager();
    }

    @Provides
    @PerDialogFragment
    @ChildFragmentManagerContext
    FragmentManager provideChildFragmentManager(){
        return mDialogFragment.getChildFragmentManager();
    }

}
