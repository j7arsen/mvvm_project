package com.j7arsen.mvvmproject.navigator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

import com.j7arsen.mvvmproject.utils.PlainConsumer;

import javax.inject.Inject;

/**
 * Created by j7ars on 14.05.2017.
 */

public class Navigator implements INavigator {

    @Inject
    public Navigator(){

    }

    @Override
    public void finishActivity(@NonNull Activity activity) {
        activity.finish();
    }

    @Override
    public final void startActivity(@NonNull Activity activity, @NonNull Intent intent) {
        activity.startActivity(intent);
    }

    @Override
    public final void startActivity(@NonNull Activity activity, @NonNull String action) {
        activity.startActivity(new Intent(action));
    }

    @Override
    public final void startActivity(@NonNull Activity activity, @NonNull String action, @NonNull Uri uri) {
        activity.startActivity(new Intent(action, uri));
    }

    @Override
    public final void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass) {
        startActivityInternal(activity, activityClass, null, null);
    }

    @Override
    public void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction) {
        startActivityInternal(activity, activityClass, setArgsAction, null);
    }

    @Override
    public void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, Bundle args) {
        startActivityInternal(activity, activityClass, intent -> intent.putExtra(EXTRA_ARG, args), null);
    }

    @Override
    public final void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull Parcelable arg) {
        startActivityInternal(activity, activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), null);
    }

    @Override
    public final void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull String arg) {
        startActivityInternal(activity, activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), null);
    }

    @Override
    public final void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, int arg) {
        startActivityInternal(activity, activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), null);
    }

    @Override
    public final void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, int requestCode) {
        startActivityInternal(activity, activityClass, null, requestCode);
    }

    @Override
    public void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction, int requestCode) {
        startActivityInternal(activity, activityClass, setArgsAction, requestCode);
    }

    @Override
    public final void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull Parcelable arg, int requestCode) {
        startActivityInternal(activity, activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), requestCode);
    }

    @Override
    public final void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, @NonNull String arg, int requestCode) {
        startActivityInternal(activity, activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), requestCode);
    }

    @Override
    public final void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> activityClass, int arg, int requestCode) {
        startActivityInternal(activity, activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), requestCode);
    }

    private void startActivityInternal(Activity activity, Class<? extends Activity> activityClass, PlainConsumer<Intent> setArgsAction, Integer requestCode) {
        Intent intent = new Intent(activity, activityClass);
        if(setArgsAction != null) { setArgsAction.accept(intent); }

        if(requestCode != null) {
            activity.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivity(intent);
        }
    }

    @Override
    public final void replaceFragment(@NonNull Activity activity, @IdRes int containerId, Fragment fragment, Bundle args) {
        replaceFragmentInternal(activity.getFragmentManager(), containerId, fragment, null, args, false, null);
    }

    @Override
    public final void replaceFragment(@NonNull Activity activity, @IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args) {
        replaceFragmentInternal(activity.getFragmentManager(), containerId, fragment, fragmentTag, args, false, null);
    }

    @Override
    public final void replaceFragmentAndAddToBackStack(@NonNull Activity activity, @IdRes int containerId, Fragment fragment, Bundle args, String backstackTag) {
        replaceFragmentInternal(activity.getFragmentManager(), containerId, fragment, null, args, true, backstackTag);
    }

    @Override
    public final void replaceFragmentAndAddToBackStack(@NonNull Activity activity, @IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag) {
        replaceFragmentInternal(activity.getFragmentManager(), containerId, fragment, fragmentTag, args, true, backstackTag);
    }

    protected final void replaceFragmentInternal(FragmentManager fm, @IdRes int containerId, Fragment fragment, String fragmentTag, Bundle args, boolean addToBackstack, String backstackTag) {
        if(args != null) { fragment.setArguments(args);}
        FragmentTransaction ft = fm.beginTransaction().replace(containerId, fragment, fragmentTag);
        if(addToBackstack) {
            ft.addToBackStack(backstackTag).commit();
            fm.executePendingTransactions();
        } else {
            ft.commitAllowingStateLoss();
        }
    }

    @Override
    public final void replaceChildFragment(@NonNull Fragment rootFragment,@IdRes int containerId, @NonNull Fragment fragment, Bundle args) {
        replaceFragmentInternal(rootFragment.getChildFragmentManager(), containerId, fragment, null, args, false, null);
    }

    @Override
    public final void replaceChildFragment(@NonNull Fragment rootFragment, @IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args) {
        replaceFragmentInternal(rootFragment.getChildFragmentManager(), containerId, fragment, fragmentTag, args, false, null);
    }

    @Override
    public final void replaceChildFragmentAndAddToBackStack(@NonNull Fragment rootFragment, @IdRes int containerId, @NonNull Fragment fragment, Bundle args, String backstackTag) {
        replaceFragmentInternal(rootFragment.getChildFragmentManager(), containerId, fragment, null, args, true, backstackTag);
    }

    @Override
    public final void replaceChildFragmentAndAddToBackStack(@NonNull Fragment rootFragment, @IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag) {
        replaceFragmentInternal(rootFragment.getChildFragmentManager(), containerId, fragment, fragmentTag, args, true, backstackTag);
    }

}
