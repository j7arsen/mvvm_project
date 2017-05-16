package com.j7arsen.mvvmproject.main.detail.viewmodel;

import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.j7arsen.mvvmproject.base.viewmodel.BaseViewModel;
import com.j7arsen.mvvmproject.dataclasses.People;
import com.j7arsen.mvvmproject.main.detail.IPeopleDetailContract;

import org.parceler.Parcels;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by arsen on 16.05.17.
 */

public class PeopleDetailViewModel extends BaseViewModel<IPeopleDetailContract.View> implements IPeopleDetailContract.ViewModel {

    private static final String SAVE_PEOPLE = "PeopleDetailViewModel.SAVE_PEOPLE";

    private People mCurrentPeople;

    @Inject
    public PeopleDetailViewModel(){}

    @Override
    public void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
        outState.putParcelable(SAVE_PEOPLE, Parcels.wrap(mCurrentPeople));
    }

    @Override
    protected void restoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.restoreInstanceState(savedInstanceState);
        mCurrentPeople = Parcels.unwrap(savedInstanceState.getParcelable(SAVE_PEOPLE));
    }

    public void setPeople(People people){
        this.mCurrentPeople = people;
        notifyChange();
    }

    //properties

    public String getFullUserName() {
        return mCurrentPeople.getName().getTitle() + "." + mCurrentPeople.getName().getFirst() + " " + mCurrentPeople.getName().getLast();
    }

    public String getUserName() {
        return getFullUserName();
    }

    public String getEmail() {
        return mCurrentPeople.getEmail();
    }

    public int getEmailVisibility() {
        return mCurrentPeople.getEmail() != null ? View.VISIBLE : View.GONE;
    }

    public String getCell() {
        return mCurrentPeople.getCell();
    }

    public String getPictureProfile() {
        return mCurrentPeople.getPicture().getLarge();
    }

    public String getAddress() {
        return mCurrentPeople.getLocation().getStreet()
                + " "
                + mCurrentPeople.getLocation().getCity()
                + " "
                + mCurrentPeople.getLocation().getState();
    }

    public String getGender() {
        return mCurrentPeople.getGender();
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

}
