package com.j7arsen.mvvmproject.app;

import android.app.Application;
import android.content.Context;

import com.j7arsen.mvvmproject.di.components.ApplicationComponent;
import com.j7arsen.mvvmproject.di.components.DaggerApplicationComponent;
import com.j7arsen.mvvmproject.di.modules.ApplicationModule;

/**
 * Created by j7ars on 13.05.2017.
 */

public class MVVMApp extends Application {

    public static MVVMApp mInstance;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    public static MVVMApp get(Context context){
        return (MVVMApp) context.getApplicationContext();
    }

}
