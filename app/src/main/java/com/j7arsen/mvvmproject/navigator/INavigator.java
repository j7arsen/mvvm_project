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

public interface INavigator {

    String EXTRA_ARG = "args";

    void finishActivity(@NonNull Activity activity);
    void startActivity(@NonNull Activity activity, @NonNull Intent intent);
    void startActivity(@NonNull Activity activity, @NonNull String action);
    void startActivity(@NonNull Activity activity, @NonNull String action, @NonNull Uri uri);
    void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass);
    void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction);
    void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, Bundle args);
    void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, Parcelable args);
    void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull String arg);
    void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, int arg);

    void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, int requestCode);
    void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction, int requestCode);
    void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull Parcelable arg, int requestCode);
    void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull String arg, int requestCode);
    void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, int arg, int requestCode);

    void replaceFragment(@NonNull Activity activity, @IdRes int containerId, @NonNull Fragment fragment, Bundle args);
    void replaceFragment(@NonNull Activity activity, @IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args);
    void replaceFragmentAndAddToBackStack(@NonNull Activity activity, @IdRes int containerId, @NonNull Fragment fragment, Bundle args, String backstackTag);
    void replaceFragmentAndAddToBackStack(@NonNull Activity activity, @IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag);

    void replaceChildFragment(@NonNull Fragment rootFragment, @IdRes int containerId, @NonNull Fragment fragment, Bundle args);
    void replaceChildFragment(@NonNull Fragment rootFragment, @IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args);
    void replaceChildFragmentAndAddToBackStack(@NonNull Fragment rootFragment, @IdRes int containerId, @NonNull Fragment fragment, Bundle args, String backstackTag);
    void replaceChildFragmentAndAddToBackStack(@NonNull Fragment rootFragment, @IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag);

}
