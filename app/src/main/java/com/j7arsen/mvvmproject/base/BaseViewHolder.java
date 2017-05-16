package com.j7arsen.mvvmproject.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.j7arsen.mvvmproject.BR;
import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.base.viewmodel.EmptyViewModel;
import com.j7arsen.mvvmproject.di.components.DaggerViewHolderComponent;
import com.j7arsen.mvvmproject.di.components.ViewHolderComponent;
import com.j7arsen.mvvmproject.utils.Utils;

import javax.inject.Inject;

/**
 * Created by j7ars on 13.05.2017.
 */

/*
* After calling these methods, the binding and the view model is initialized.
 * saveInstanceState() and restoreInstanceState() are not called/used for ViewHolder
 * view models.
 *
 * Your subclass must implement the MvvmView implementation that you use in your
 * view model.
 * */

public abstract class BaseViewHolder<B extends ViewDataBinding, V extends IMvvmViewModel> extends RecyclerView.ViewHolder {

    protected B mBinding;
    @Inject
    protected V mViewModel;

    protected final View itemView;

    private ViewHolderComponent mViewHolderComponent;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    protected final ViewHolderComponent viewHolderComponent() {
        if(mViewHolderComponent == null) {
            mViewHolderComponent = DaggerViewHolderComponent.builder()
                    .activityComponent(Utils.castActivityFromContext(itemView.getContext(), BaseActivity.class).activityComponent())
                    .build();
        }

        return mViewHolderComponent;
    }

    protected final void bindContentView(@NonNull View view) {
        if (mViewModel == null) {
            throw new IllegalStateException("viewModel must not be null and should be injected via viewHolderComponent().inject(this)");
        }
        mBinding = DataBindingUtil.bind(view);
        mBinding.setVariable(BR.vm, mViewModel);

        try {
            mViewModel.attachView((IMvvmView) this, null);
        } catch (ClassCastException e) {
            if (!(mViewModel instanceof EmptyViewModel)) {
                throw new RuntimeException(getClass().getSimpleName() + " must implement MvvmView subclass as declared in " + mViewModel.getClass().getSimpleName());
            }
        }
    }

    public final V viewModel() {
        return mViewModel;
    }

    public final void executePendingBindings() {
        if (mBinding != null) {
            mBinding.executePendingBindings();
        }
    }
}
