package com.j7arsen.mvvmproject.utils;

import io.reactivex.functions.Consumer;

/**
 * Created by j7ars on 14.05.2017.
 */

public interface PlainConsumer<T> extends Consumer<T>{

    @Override
    void accept(T t);

}
