package com.r1code.d3profile.events;

/**
 * Created by rafael on 8/06/15.
 */
public class CurrentHeroIdChanged {
    private long id;

    public CurrentHeroIdChanged(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
