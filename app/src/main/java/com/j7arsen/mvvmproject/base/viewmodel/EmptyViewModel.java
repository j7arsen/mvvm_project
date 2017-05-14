package com.j7arsen.mvvmproject.base.viewmodel;

import android.databinding.BaseObservable;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;

import javax.inject.Inject;

/**
 * Created by j7ars on 13.05.2017.
 */

public class EmptyViewModel extends BaseObservable implements IMvvmViewModel<IMvvmView> {

    @Inject
    public EmptyViewModel() {
    }

    @Override
    public void attachView(IMvvmView view, Bundle savedInstanceState) {
    }

    @Override
    public void detachView() {
    }

    @Override
    public void saveInstanceState(@NonNull Bundle outState) {
    }
}
