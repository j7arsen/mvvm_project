package com.j7arsen.mvvmproject.main.people.adapter.viewmodel;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.j7arsen.mvvmproject.base.viewmodel.BaseViewModel;
import com.j7arsen.mvvmproject.dataclasses.People;
import com.j7arsen.mvvmproject.di.scopes.PerViewHolder;
import com.j7arsen.mvvmproject.main.people.adapter.IPeopleItemContract;
import com.j7arsen.mvvmproject.navigator.Navigator;

import javax.inject.Inject;

/**
 * Created by arsen on 15.05.17.
 */
@PerViewHolder
public class PeopleItemViewModel extends BaseViewModel<IPeopleItemContract.View> implements IPeopleItemContract.ViewModel{

    private Navigator mNavigator;

    private People mCurrentPeople;

    @Inject
    public PeopleItemViewModel(Navigator navigator){
       this.mNavigator = navigator;
    }

    @Override
    public void updatePeople(People people) {
        this.mCurrentPeople = people;
        notifyChange();
    }

    @Override
    public void onItemClick(View view) {
        Log.i("Start activity", "Start Activity");

    }

    //properties
    @Override
    public String getFullName() {
        return mCurrentPeople.getName().getTitle() + "." + mCurrentPeople.getName().getFirst() + " " + mCurrentPeople.getName().getLast();
    }

    @Override
    public String getCell() {
        return mCurrentPeople.getCell();
    }

    @Override
    public String getMail() {
        return mCurrentPeople.getEmail();
    }

    @Override
    public String getPictureProfile() {
        return mCurrentPeople.getPicture().getMedium();
    }

    @BindingAdapter("imageUrl") public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

}
