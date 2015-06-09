package com.r1code.d3profile.services;

import com.squareup.otto.Bus;

/**
 * Created by rafael on 9/06/15.
 */
public final class OttoBusProvider {
    private static final Bus BUS = new Bus();

    private OttoBusProvider() {}

    public static Bus getInstance() {
        return BUS;
    }
}
