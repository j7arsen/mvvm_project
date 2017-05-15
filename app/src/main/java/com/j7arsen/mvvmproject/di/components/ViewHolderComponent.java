package com.j7arsen.mvvmproject.di.components;

import com.j7arsen.mvvmproject.di.modules.ViewHolderModule;
import com.j7arsen.mvvmproject.di.modules.ViewModelModule;
import com.j7arsen.mvvmproject.di.scopes.PerViewHolder;
import com.j7arsen.mvvmproject.main.people.adapter.holder.PeopleItemViewHolder;

import dagger.Subcomponent;

/**
 * Created by j7ars on 13.05.2017.
 */
@PerViewHolder
@Subcomponent(modules = {ViewHolderModule.class, ViewModelModule.class})
public interface ViewHolderComponent {

    //inject view holder
    void inject(PeopleItemViewHolder peopleItemViewHolder);
}