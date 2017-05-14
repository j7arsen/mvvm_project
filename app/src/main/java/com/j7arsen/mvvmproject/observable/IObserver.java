package com.j7arsen.mvvmproject.observable;

import com.j7arsen.mvvmproject.base.BaseEvent;
import com.j7arsen.mvvmproject.dataclasses.Pair;

/**
 * Created by j7ars on 14.05.2017.
 */

public interface IObserver {

    void onStartRequest(final int actionCode);

    void onSuccess(final int actionCode, Pair pair);

    void onFail(final int actionCode, Throwable e);

    //It is method for observe event from observable controller
    void onEvent(BaseEvent event);

}
