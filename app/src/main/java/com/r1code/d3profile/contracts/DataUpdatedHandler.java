package com.r1code.d3profile.contracts;

/**
 * Created by rafael on 5/06/15.
 */
public interface DataUpdatedHandler<T> {

    public void onDataUpdated(T data);
}
