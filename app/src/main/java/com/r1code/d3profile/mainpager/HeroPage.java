package com.r1code.d3profile.mainpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.r1code.d3profile.MainActivity;
import com.r1code.d3profile.R;
import com.r1code.d3profile.events.CurrentHeroId;
import com.squareup.otto.Subscribe;

/**
 * Created by rafael on 8/06/15.
 */
public class HeroPage extends Fragment {

    private boolean isRegistered = false;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hero_page, container, false);

        if (! isRegistered) {
            isRegistered = true;
            MainActivity.bus.register(this);
        }

        return view;
    }

    @Subscribe
    public void changedHeroId(CurrentHeroId currentHeroId) {
        TextView textView = (TextView) view.findViewById(R.id.hero_page_name);
        textView.setText(currentHeroId.getId() + "");
    }
}
