package com.j7arsen.mvvmproject.base;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.j7arsen.mvvmproject.BR;
import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.base.viewmodel.EmptyViewModel;
import com.j7arsen.mvvmproject.di.components.DaggerFragmentComponent;
import com.j7arsen.mvvmproject.di.components.FragmentComponent;
import com.j7arsen.mvvmproject.di.modules.FragmentModule;

import javax.inject.Inject;

/**
 * Created by j7ars on 13.05.2017.
 */

public abstract class BaseFragment<B extends ViewDataBinding, V extends IMvvmViewModel> extends Fragment {

    private FragmentComponent mFragmentComponent;

    protected B mBinding;
    @Inject
    protected V mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent();
    }

    protected abstract void setupComponent();

    /* Sets the content view, creates the binding and attaches the view to the view model */
    protected final View setAndBindContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, @LayoutRes int layoutResID) {
        if (mViewModel == null) {
            throw new IllegalStateException("viewModel must already be set via injection");
        }
        mBinding = DataBindingUtil.inflate(inflater, layoutResID, container, false);
        mBinding.setVariable(BR.vm, mViewModel);

        try {
            mViewModel.attachView((IMvvmView) this, savedInstanceState);
        } catch (ClassCastException e) {
            if (!(mViewModel instanceof EmptyViewModel)) {
                throw new RuntimeException(getClass().getSimpleName() + " must implement MvvmView subclass as declared in " + mViewModel.getClass().getSimpleName());
            }
        }

        return mBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mViewModel != null) {
            mViewModel.saveInstanceState(outState);
        }
    }

    public FragmentComponent fragmentComponent() {
        if(mFragmentComponent == null) {
            mFragmentComponent = DaggerFragmentComponent.builder()
                    .fragmentModule(new FragmentModule(this))
                    .activityComponent(((BaseActivity) getActivity()).activityComponent())
                    .build();
        }

        return mFragmentComponent;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mViewModel != null) {
            mViewModel.detachView();
        }
        mBinding = null;
        mViewModel = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFragmentComponent = null;
        super.onDestroy();
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
