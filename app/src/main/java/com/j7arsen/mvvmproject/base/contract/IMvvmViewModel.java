package com.j7arsen.mvvmproject.base.contract;

import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.NonNull;


/**
 * Created by j7ars on 13.05.2017.
 */

public interface IMvvmViewModel<V extends IMvvmView> extends Observable {

    void attachView(V view, Bundle savedInstanceState);
    void detachView();

    void saveInstanceState(@NonNull Bundle outState);
}
