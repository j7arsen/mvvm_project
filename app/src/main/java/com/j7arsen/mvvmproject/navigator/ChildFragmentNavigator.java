package com.j7arsen.mvvmproject.navigator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

/**
 * Created by j7ars on 14.05.2017.
 */

public class ChildFragmentNavigator extends ActivityNavigator implements IFragmentNavigator {

    private final Fragment fragment;

    public ChildFragmentNavigator(Fragment fragment) {
        super(fragment.getActivity());
        this.fragment = fragment;
    }

    @Override
    public final void replaceChildFragment(@IdRes int containerId, @NonNull Fragment fragment, Bundle args) {
        replaceFragmentInternal(this.fragment.getChildFragmentManager(), containerId, fragment, null, args, false, null);
    }

    @Override
    public final void replaceChildFragment(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args) {
        replaceFragmentInternal(this.fragment.getChildFragmentManager(), containerId, fragment, fragmentTag, args, false, null);
    }

    @Override
    public final void replaceChildFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, Bundle args, String backstackTag) {
        replaceFragmentInternal(this.fragment.getChildFragmentManager(), containerId, fragment, null, args, true, backstackTag);
    }

    @Override
    public final void replaceChildFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag) {
        replaceFragmentInternal(this.fragment.getChildFragmentManager(), containerId, fragment, fragmentTag, args, true, backstackTag);
    }

}