package com.j7arsen.mvvmproject.observable;

import com.j7arsen.mvvmproject.base.BaseEvent;
import com.j7arsen.mvvmproject.dataclasses.Pair;

/**
 * Created by j7ars on 14.05.2017.
 */

public interface ISubject {

    void addObserver(IObserver iObserver);

    void removeObserver(IObserver iObserver);

    void removeAllObservers();

    void notifyStartedWithAction(final int action);

    void notifySuccess(int actionCode, final Pair o);

    void notifyFailed(int actionCode, Throwable e);

    boolean containObserver(IObserver iObserver);

    void notifyEvent(BaseEvent event);

}
