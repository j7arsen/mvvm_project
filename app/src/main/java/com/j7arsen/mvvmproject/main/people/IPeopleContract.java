package com.j7arsen.mvvmproject.main.people;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.viewmodel.BaseAdapterMvvmViewModel;

/**
 * Created by arsen on 15.05.17.
 */

public interface IPeopleContract {

    interface View extends IMvvmView{

    }

    interface ViewModel extends BaseAdapterMvvmViewModel<View>{
        void onClickFab(android.view.View view);
        ObservableInt getPeopleProgress();
        ObservableInt getPeopleRecycler();
        ObservableInt getPeopleLabel();
        ObservableField<String> getMessageLabel();
    }

}
