package com.j7arsen.mvvmproject.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

import com.j7arsen.mvvmproject.utils.PlainConsumer;

/**
 * Created by j7ars on 14.05.2017.
 */

public interface IActivityNavigator {

    String EXTRA_ARG = "args";

    void finishActivity();
    void startActivity(@NonNull Intent intent);
    void startActivity(@NonNull String action);
    void startActivity(@NonNull String action, @NonNull Uri uri);
    void startActivity(@NonNull Class<? extends Activity> activityClass);
    void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction);
    void startActivity(@NonNull Class<? extends Activity> activityClass, Bundle args);
    void startActivity(@NonNull Class<? extends Activity> activityClass, Parcelable args);
    void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull String arg);
    void startActivity(@NonNull Class<? extends Activity> activityClass, int arg);

    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, int requestCode);
    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction, int requestCode);
    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, @NonNull Parcelable arg, int requestCode);
    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, @NonNull String arg, int requestCode);
    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, int arg, int requestCode);

    void replaceFragment(@IdRes int containerId, @NonNull Fragment fragment, Bundle args);
    void replaceFragment(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args);
    void replaceFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, Bundle args, String backstackTag);
    void replaceFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag);

}
