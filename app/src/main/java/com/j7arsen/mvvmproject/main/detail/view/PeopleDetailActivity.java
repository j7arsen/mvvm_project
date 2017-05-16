package com.j7arsen.mvvmproject.main.detail.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.j7arsen.mvvmproject.R;
import com.j7arsen.mvvmproject.base.BaseActivity;
import com.j7arsen.mvvmproject.databinding.ActivityDetailBinding;
import com.j7arsen.mvvmproject.dataclasses.People;
import com.j7arsen.mvvmproject.main.detail.IPeopleDetailContract;

import org.parceler.Parcels;

/**
 * Created by arsen on 15.05.17.
 */

public class PeopleDetailActivity extends BaseActivity<ActivityDetailBinding, IPeopleDetailContract.ViewModel> implements IPeopleDetailContract.View{

    private static final String PEOPLE_DETAIL = "PeopleDetailActivity.PEOPLE_DETAIL";

    public static void startActivity(Activity activity, People people) {
        Intent intent = new Intent(activity, PeopleDetailActivity.class);
        intent.putExtra(PEOPLE_DETAIL, Parcels.wrap(people));
        activity.startActivity(intent);
    }

    public static void startActivity(Fragment fragment, Activity activity, People people) {
        Intent intent = new Intent(activity, PeopleDetailActivity.class);
        intent.putExtra(PEOPLE_DETAIL, Parcels.wrap(people));
        fragment.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(savedInstanceState, R.layout.activity_detail);
        getExtras();
    }

    private void getExtras(){
        if(getIntent().getExtras() != null){
            mViewModel.setPeople(Parcels.unwrap(getIntent().getExtras().getParcelable(PEOPLE_DETAIL)));
        }
    }

    @Override
    protected void setupComponent() {
        activityComponent().inject(this);
    }
}
