package com.j7arsen.mvvmproject.di.components;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.databinding.ViewDataBinding;

import com.j7arsen.mvvmproject.base.BaseDialogFragment;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.di.modules.DialogFragmentModule;
import com.j7arsen.mvvmproject.di.modules.ViewModelModule;
import com.j7arsen.mvvmproject.di.qualifier.ActivityContext;
import com.j7arsen.mvvmproject.di.qualifier.ActivityFragmentManagerContext;
import com.j7arsen.mvvmproject.di.qualifier.ChildFragmentManagerContext;
import com.j7arsen.mvvmproject.di.scopes.PerDialogFragment;

import dagger.Subcomponent;

/**
 * Created by j7ars on 13.05.2017.
 */
@PerDialogFragment
@Subcomponent(modules = {DialogFragmentModule.class, ViewModelModule.class})
public interface DialogFragmentComponent {

    DialogFragment dialogFragment();
    Activity activity();
    @ActivityContext
    Context context();
    @ActivityFragmentManagerContext
    FragmentManager fragmentManager();
    @ChildFragmentManagerContext
    FragmentManager provideChildFragmentManager();

    //inject dialog fragment

}
