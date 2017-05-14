package com.j7arsen.mvvmproject.di.components;

import android.databinding.ViewDataBinding;

import com.j7arsen.mvvmproject.base.BaseViewHolder;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.di.modules.ViewHolderModule;
import com.j7arsen.mvvmproject.di.modules.ViewModelModule;

import dagger.Subcomponent;

/**
 * Created by j7ars on 13.05.2017.
 */
@Subcomponent(modules = {ViewHolderModule.class, ViewModelModule.class})
public interface ViewHolderComponent {

    //inject view holder
}