package com.j7arsen.mvvmproject.main.people.adapter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.j7arsen.mvvmproject.R;
import com.j7arsen.mvvmproject.dataclasses.People;
import com.j7arsen.mvvmproject.di.scopes.PerActivity;
import com.j7arsen.mvvmproject.main.people.adapter.holder.PeopleItemViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by arsen on 15.05.17.
 */
@PerActivity
public class PeopleItemAdapter extends RecyclerView.Adapter<PeopleItemViewHolder>{

    private List<People> mPeopleList;

    @Inject
    public PeopleItemAdapter(){
        mPeopleList = new ArrayList<>();
    }

    public void setData(List<People> peopleList){
        this.mPeopleList = peopleList;
        notifyDataSetChanged();
    }

    @Override
    public PeopleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_people, parent, false);

        return new PeopleItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PeopleItemViewHolder holder, int position) {
        holder.viewModel().updatePeople(mPeopleList.get(position));
        holder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mPeopleList == null ? 0 : mPeopleList.size();
    }
}
