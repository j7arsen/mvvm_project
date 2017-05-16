package com.j7arsen.mvvmproject.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import com.j7arsen.mvvmproject.BR;
import com.j7arsen.mvvmproject.app.MVVMApp;
import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.base.viewmodel.EmptyViewModel;
import com.j7arsen.mvvmproject.di.components.ActivityComponent;
import com.j7arsen.mvvmproject.di.components.DaggerActivityComponent;
import com.j7arsen.mvvmproject.di.modules.ActivityModule;

import javax.inject.Inject;

/**
 * Created by j7ars on 13.05.2017.
 */

public abstract class BaseActivity<B extends ViewDataBinding, V extends IMvvmViewModel> extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    protected B mBinding;
    @Inject
    protected V mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent();
    }

    protected abstract void setupComponent();

    /* Sets the content view, creates the binding and attaches the view to the view model */
    protected final void setAndBindContentView(@Nullable Bundle savedInstanceState, @LayoutRes int layoutResID) {
        if(mViewModel == null) { throw new IllegalStateException("viewModel must already be set via injection"); }
        mBinding = DataBindingUtil.setContentView(this, layoutResID);
        mBinding.setVariable(BR.vm, mViewModel);

        try {
            mViewModel.attachView((IMvvmView) this, savedInstanceState);
        } catch(ClassCastException e) {
            if (!(mViewModel instanceof EmptyViewModel)) {
                throw new RuntimeException(getClass().getSimpleName() + " must implement MvvmView subclass as declared in " + mViewModel.getClass().getSimpleName());
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mViewModel != null) {
            mViewModel.saveInstanceState(outState);
        }
    }

    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MVVMApp.mInstance.getComponent())
                    .build();
        }
        return mActivityComponent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mViewModel != null) {
            mViewModel.detachView();
        }
        mBinding = null;
        mViewModel = null;
        mActivityComponent = null;
    }

    public int dimen(@DimenRes int resId) {
        return (int) getResources().getDimension(resId);
    }

    public int color(@ColorRes int resId) {
        return getResources().getColor(resId);
    }

    public int integer(@IntegerRes int resId) {
        return getResources().getInteger(resId);
    }

    public String string(@StringRes int resId) {
        return getResources().getString(resId);
    }

}
