package com.r1code.d3profile.mainpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.r1code.d3profile.DataHolder;
import com.r1code.d3profile.R;
import com.r1code.d3profile.contracts.DataUpdatedHandler;
import com.r1code.d3profile.events.CurrentHeroIdChanged;
import com.r1code.d3profile.json.d3hero.Hero;
import com.r1code.d3profile.services.OttoBusProvider;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by rafael on 8/06/15.
 */
public class HeroPage extends Fragment {

    @InjectView(R.id.hero_name)
    TextView heroName;

    @InjectView(R.id.hero_class)
    TextView heroClass;

    @InjectView(R.id.hero_level)
    TextView heroLevel;

    @InjectView(R.id.hero_paragon)
    TextView paragonLevel;

    @InjectView(R.id.hero_big_portrait)
    ImageView heroPortrait;

    private boolean isRegistered = false;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hero_page, container, false);
        ButterKnife.inject(this, view);

        DataHolder dataHolder = DataHolder.getInstance();

        updateView(24571053l);

        if (! isRegistered) {
            isRegistered = true;
            OttoBusProvider.getInstance().register(this);
        }

        return view;
    }

    private void updateView(final long heroId) {
        DataHolder dataHolder = DataHolder.getInstance();

        dataHolder.getHero("rafael25#1369", heroId, new DataUpdatedHandler<Hero>() {
            @Override
            public void onDataUpdated(Hero data) {
                if (isAdded()) {
                    String className = data.getClass_();
                    String imageName = "@mipmap/" + className.replace('-', '_') + "_" + data.getGender();
                    int portrait = getResources().getIdentifier(imageName, "mipmap", getActivity().getPackageName());

                    heroName.setText(data.getName());
                    heroClass.setText(data.getClass_());
                    heroLevel.setText(data.getLevel() + "");
                    paragonLevel.setText(data.getParagonLevel() + "");
                    heroPortrait.setImageResource(portrait);
                }
            }
        });
    }

    @Subscribe
    public void changedHeroId(CurrentHeroIdChanged currentHeroId) {
        updateView(currentHeroId.getId());
    }
}
