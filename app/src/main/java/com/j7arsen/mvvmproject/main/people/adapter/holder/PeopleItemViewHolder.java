package com.j7arsen.mvvmproject.main.people.adapter.holder;

import android.view.View;

import com.j7arsen.mvvmproject.base.BaseViewHolder;
import com.j7arsen.mvvmproject.databinding.ItemPeopleBinding;
import com.j7arsen.mvvmproject.main.people.adapter.IPeopleItemContract;

/**
 * Created by arsen on 15.05.17.
 */

public class PeopleItemViewHolder extends BaseViewHolder<ItemPeopleBinding, IPeopleItemContract.ViewModel> implements IPeopleItemContract.View {

    public PeopleItemViewHolder(View v) {
        super(v);
        viewHolderComponent().inject(this);
        bindContentView(v);
    }

}