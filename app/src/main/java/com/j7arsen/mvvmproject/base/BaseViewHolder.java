package com.j7arsen.mvvmproject.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.j7arsen.mvvmproject.BR;
import com.j7arsen.mvvmproject.app.MVVMApp;
import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.base.viewmodel.EmptyViewModel;
import com.j7arsen.mvvmproject.di.components.ConfigPersistentComponent;
import com.j7arsen.mvvmproject.di.components.DaggerConfigPersistentComponent;
import com.j7arsen.mvvmproject.di.components.ViewHolderComponent;
import com.j7arsen.mvvmproject.di.modules.ViewHolderModule;
import com.j7arsen.mvvmproject.utils.Utils;

import javax.inject.Inject;

/**
 * Created by j7ars on 13.05.2017.
 */

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
            ConfigPersistentComponent configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .applicationComponent(MVVMApp.get(
                            Utils.castActivityFromContext(itemView.getContext(), BaseActivity.class)).getComponent())
                    .build();
            mViewHolderComponent = configPersistentComponent.viewHolderComponent(new ViewHolderModule());
        }

        return mViewHolderComponent;
    }

    protected final void bindContentView(@NonNull View view) {
        if(mViewModel == null) { throw new IllegalStateException("viewModel must not be null and should be injected via viewHolderComponent().inject(this)"); }
        mBinding = DataBindingUtil.bind(view);
        mBinding.setVariable(BR.vm, mViewModel);

        try {
            mViewModel.attachView((IMvvmView) this, null);
        } catch(ClassCastException e) {
            if (!(mViewModel instanceof EmptyViewModel)) {
                throw new RuntimeException(getClass().getSimpleName() + " must implement MvvmView subclass as declared in " + mViewModel.getClass().getSimpleName());
            }
        }
    }

    public final V viewModel() {
        return mViewModel;
    }

    public final void executePendingBindings() {
        if(mBinding != null) {
            mBinding.executePendingBindings();
        }
    }
}
