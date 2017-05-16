package com.j7arsen.mvvmproject.di.modules;

import com.j7arsen.mvvmproject.main.detail.IPeopleDetailContract;
import com.j7arsen.mvvmproject.main.detail.viewmodel.PeopleDetailViewModel;
import com.j7arsen.mvvmproject.main.people.IPeopleContract;
import com.j7arsen.mvvmproject.main.people.adapter.IPeopleItemContract;
import com.j7arsen.mvvmproject.main.people.adapter.viewmodel.PeopleItemViewModel;
import com.j7arsen.mvvmproject.main.people.viewmodel.PeopleViewModel;

import dagger.Binds;
import dagger.Module;

/**
 * Created by j7ars on 13.05.2017.
 */
@Module
public abstract class ViewModelModule {

    // Activities
    @Binds
    abstract IPeopleContract.ViewModel bindPeopleViewModel(PeopleViewModel peopleViewModel);

    @Binds
    abstract IPeopleDetailContract.ViewModel bindPeopleDetailModel(PeopleDetailViewModel peopleDetailViewModel);

    // Fragments

    //View Holder
    @Binds
    abstract IPeopleItemContract.ViewModel bindPeopleItemModel(PeopleItemViewModel peopleItemViewModel);

}
