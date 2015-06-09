package com.r1code.d3profile;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;

import com.r1code.d3profile.events.CurrentHeroIdChanged;
import com.r1code.d3profile.services.OttoBusProvider;
import com.squareup.otto.Subscribe;

/**
 * Created by rafael on 9/06/15.
 */
public class ViewPager extends android.support.v4.view.ViewPager {

    private boolean isRegistered;

    public ViewPager(Context context) {
        super(context);
        register();
    }

    public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        register();
    }

    private void register() {
        if (! isRegistered) {
            isRegistered = true;
            OttoBusProvider.getInstance().register(this);
        }
    }

    @Subscribe
    public void heroSelected(CurrentHeroIdChanged currentHeroId) {
        Log.i(ViewPager.class.getName(), "Evento: CurrentHeroIdChanged recivido");
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            setCurrentItem(2);
        }
    }
}
