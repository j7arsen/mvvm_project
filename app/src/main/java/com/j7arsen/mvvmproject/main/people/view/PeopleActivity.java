package com.j7arsen.mvvmproject.main.people.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.j7arsen.mvvmproject.R;
import com.j7arsen.mvvmproject.base.BaseActivity;
import com.j7arsen.mvvmproject.databinding.ActivityPeopleBinding;
import com.j7arsen.mvvmproject.main.people.IPeopleContract;
import com.j7arsen.mvvmproject.main.people.adapter.adapter.PeopleItemAdapter;

import javax.inject.Inject;

/**
 * Created by arsen on 15.05.17.
 */
public class PeopleActivity extends BaseActivity<ActivityPeopleBinding, IPeopleContract.ViewModel> implements IPeopleContract.View{

    @Inject
    PeopleItemAdapter mPeopleItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(savedInstanceState, R.layout.activity_people);

        setSupportActionBar(mBinding.toolbar);
        initAdapter();

    }

    private void initAdapter(){
        mBinding.listPeople.setLayoutManager(new LinearLayoutManager(this));
        mBinding.listPeople.setAdapter(mPeopleItemAdapter);
    }

    @Override
    protected void setupComponent() {
        activityComponent().inject(this);
    }
}
