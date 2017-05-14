package com.j7arsen.mvvmproject.observable;

import com.j7arsen.mvvmproject.base.BaseEvent;
import com.j7arsen.mvvmproject.dataclasses.Pair;
import com.j7arsen.mvvmproject.di.scopes.PerApplication;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by j7ars on 14.05.2017.
 */
@PerApplication
public class ObservableController implements ISubject {

    private ArrayList<IObserver> mObservers;

    @Inject
    public ObservableController() {
        mObservers = new ArrayList<>();
    }

    @Override
    public void addObserver(IObserver iObserver) {
        if (!mObservers.contains(iObserver)) {
            mObservers.add(iObserver);
        }
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        if (iObserver != null) {
            final int i = mObservers.indexOf(iObserver);
            if (i >= 0) {
                mObservers.remove(iObserver);
            }
        }
    }

    @Override
    public void removeAllObservers() {
        if (mObservers != null) {
            mObservers.clear();
        }
    }

    @Override
    public void notifyStartedWithAction(int action) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onStartRequest(action);
        }
    }

    @Override
    public void notifySuccess(int actionCode, Pair o) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onSuccess(actionCode, o);
        }
    }

    @Override
    public void notifyFailed(int actionCode, Throwable e) {
        final int size = mObservers.size();
        for (int i = 0; i < size; i++) {
            mObservers.get(i).onFail(actionCode, e);
        }
    }

    @Override
    public boolean containObserver(IObserver iObserver) {
        return mObservers.contains(iObserver);
    }

    @Override
    public void notifyEvent(BaseEvent event) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onEvent(event);
        }
    }
}
