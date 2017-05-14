package com.j7arsen.mvvmproject.base;

import android.app.DialogFragment;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.j7arsen.mvvmproject.BR;
import com.j7arsen.mvvmproject.app.MVVMApp;
import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.base.viewmodel.EmptyViewModel;
import com.j7arsen.mvvmproject.di.components.ConfigPersistentComponent;
import com.j7arsen.mvvmproject.di.components.DaggerConfigPersistentComponent;
import com.j7arsen.mvvmproject.di.components.DialogFragmentComponent;
import com.j7arsen.mvvmproject.di.modules.DialogFragmentModule;

import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;

/**
 * Created by j7ars on 13.05.2017.
 */

public abstract class BaseDialogFragment<B extends ViewDataBinding, V extends IMvvmViewModel> extends DialogFragment {

    private static final String KEY_DIALOG_FRAGMENT_ID = "KEY_DIALOG_FRAGMENT_ID";
    private static final LongSparseArray<ConfigPersistentComponent> sComponentsArray =
            new LongSparseArray<>();
    private static final AtomicLong NEXT_ID = new AtomicLong(0);

    private DialogFragmentComponent mDialogFragmentComponent;
    private long mDialogFragmentId;

    protected B mBinding;
    @Inject
    protected V mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialogFragmentId = savedInstanceState != null ?
                savedInstanceState.getLong(KEY_DIALOG_FRAGMENT_ID) : NEXT_ID.getAndIncrement();
        ConfigPersistentComponent configPersistentComponent;
        if (sComponentsArray.get(mDialogFragmentId) == null) {
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .applicationComponent(MVVMApp.get(
                            getActivity()).getComponent())
                    .build();
            sComponentsArray.put(mDialogFragmentId, configPersistentComponent);
        } else {
            configPersistentComponent = sComponentsArray.get(mDialogFragmentId);
        }
        mDialogFragmentComponent = configPersistentComponent.dialogFragmentComponent(new DialogFragmentModule(this));
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
        outState.putLong(KEY_DIALOG_FRAGMENT_ID, mDialogFragmentId);
        if (mViewModel != null) {
            mViewModel.saveInstanceState(outState);
        }
    }

    public DialogFragmentComponent dialogFragmentComponent() {
        return mDialogFragmentComponent;
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
        if (!getActivity().isChangingConfigurations()) {
            sComponentsArray.remove(mDialogFragmentId);
        }
        mDialogFragmentComponent = null;
        super.onDestroy();
    }

}
