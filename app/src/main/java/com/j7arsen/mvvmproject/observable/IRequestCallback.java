package com.j7arsen.mvvmproject.observable;

import com.j7arsen.mvvmproject.dataclasses.Pair;

/**
 * Created by j7ars on 14.05.2017.
 */

public interface IRequestCallback {

    void onErrorResponse(Throwable e);

    void onSuccessResponse(Pair successData);

}
