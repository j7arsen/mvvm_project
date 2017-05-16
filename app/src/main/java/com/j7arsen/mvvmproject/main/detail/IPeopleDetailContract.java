package com.j7arsen.mvvmproject.main.detail;

import com.j7arsen.mvvmproject.base.contract.IMvvmView;
import com.j7arsen.mvvmproject.base.contract.IMvvmViewModel;
import com.j7arsen.mvvmproject.dataclasses.People;

/**
 * Created by arsen on 16.05.17.
 */

public interface IPeopleDetailContract {

    interface View extends IMvvmView{

    }

    interface ViewModel extends IMvvmViewModel<View>{
        void setPeople(People people);
        String getFullUserName();
        public String getUserName();
        String getEmail();
        int getEmailVisibility();
        String getCell();
        String getPictureProfile();
        String getAddress();
        String getGender();
    }

}
