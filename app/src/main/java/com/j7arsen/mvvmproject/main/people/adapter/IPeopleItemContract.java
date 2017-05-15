package com.j7arsen.mvvmproject.main.people.adapter;

import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.dataclasses.People;

/**
 * Created by arsen on 15.05.17.
 */

public interface IPeopleItemContract {

    interface View extends IMvvmView {

    }

    interface ViewModel extends IMvvmViewModel<View> {
        String getFullName();
        String getCell();
        String getMail();
        String getPictureProfile();
        void updatePeople(People people);
        void onItemClick(android.view.View view);
    }

}
