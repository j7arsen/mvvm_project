package com.j7arsen.mvvmproject.base.viewmodel;

import android.support.v7.widget.RecyclerView;

import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;

/**
 * Created by j7ars on 14.05.2017.
 */

public interface BaseAdapterMvvmViewModel<V extends IMvvmView> extends IMvvmViewModel<V> {

    RecyclerView.Adapter getAdapter();

}
