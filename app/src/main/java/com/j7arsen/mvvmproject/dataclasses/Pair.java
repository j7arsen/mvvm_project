package com.j7arsen.mvvmproject.dataclasses;

/**
 * Created by j7ars on 14.05.2017.
 */

public class Pair<T> {

    private T mValue;

    public Pair(T mValue) {
        this.mValue = mValue;
    }

    public T getValue() {
        return mValue;
    }

    public void setValue(T mValue) {
        this.mValue = mValue;
    }
}
