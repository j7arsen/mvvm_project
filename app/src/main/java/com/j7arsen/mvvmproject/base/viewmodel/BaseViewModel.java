package com.j7arsen.mvvmproject.base.viewmodel;

import android.databinding.BaseObservable;
import android.os.Bundle;
import android.util.Log;

import com.j7arsen.mvvmproject.base.BaseEvent;
import com.j7arsen.mvvmproject.base.MvvmViewNotAttachedException;
import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.dataclasses.Pair;
import com.j7arsen.mvvmproject.managers.DataManager;
import com.j7arsen.mvvmproject.observable.IObserver;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by j7ars on 13.05.2017.
 */

public abstract class BaseViewModel<V extends IMvvmView> extends BaseObservable implements IMvvmViewModel<V>, IObserver {

    private V mMvvmView;

    @Inject
    protected DataManager mDataManager;

    //list of disposable
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    @Override
    public void attachView(V mvvmView, @Nullable Bundle savedInstanceState) {
        this.mMvvmView = mvvmView;
        if (savedInstanceState != null) {
            restoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void detachView() {
        mMvvmView = null;
        undisposableAll();
    }

    protected void restoreInstanceState(@NonNull Bundle savedInstanceState) {
    }

    public void saveInstanceState(Bundle outState) {
    }

    public final boolean isViewAttached() {
        return mMvvmView != null;
    }

    public final V getView() {
        checkViewAttached();
        return mMvvmView;
    }

    public final void checkViewAttached() {
        if (!isViewAttached()) throw new MvvmViewNotAttachedException();
    }

    @Override
    public void onStartRequest(int actionCode) {
        Log.i("Start Request", "Start Request");
        return;
    }

    @Override
    public void onSuccess(int actionCode, Pair pair) {
        Log.i("Success Request", "Success Request");
        return;
    }

    @Override
    public void onFail(int actionCode, Throwable e) {
        Log.i("Fail Request", "Fail Request");
        return;
    }

    @Override
    public void onEvent(BaseEvent event) {
        Log.i("Event", "Event");
        return;
    }

    public void addDisposable(Disposable disposable){
        mCompositeDisposable.add(disposable);
    }

    public void undisposable(Disposable disposable){
        if(mCompositeDisposable.size() != 0){
            if(!disposable.isDisposed()) {
                mCompositeDisposable.remove(disposable);
            }
        }
    }

    public void undisposableAll(){
        if(!mCompositeDisposable.isDisposed()){
            mCompositeDisposable.dispose();
        }
    }

}
