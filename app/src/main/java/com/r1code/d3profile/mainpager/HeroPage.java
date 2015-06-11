package com.r1code.d3profile.mainpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.r1code.d3profile.DataHolder;
import com.r1code.d3profile.MainActivity;
import com.r1code.d3profile.R;
import com.r1code.d3profile.contracts.DataUpdatedHandler;
import com.r1code.d3profile.events.CurrentHeroIdChanged;
import com.r1code.d3profile.json.d3hero.Hero;
import com.r1code.d3profile.services.OttoBusProvider;
import com.squareup.otto.Subscribe;

import java.text.NumberFormat;
import java.util.Locale;

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

    @InjectView(R.id.hero_stat_damage)
    TextView heroDamage;

    @InjectView(R.id.hero_stat_life)
    TextView heroLife;

    private boolean isRegistered = false;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hero_page, container, false);
        ButterKnife.inject(this, view);

        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.spinner);
        heroPortrait.setScaleType(ImageView.ScaleType.CENTER);
        heroPortrait.startAnimation(loadAnimation);

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

                    NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);

                    heroName.setText(data.getName());
                    heroClass.setText(data.getClass_());
                    heroLevel.setText(data.getLevel() + "");
                    paragonLevel.setText(data.getParagonLevel() + "");

                    heroPortrait.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    heroPortrait.setImageResource(portrait);
                    heroPortrait.clearAnimation();

                    heroDamage.setText(nf.format(data.getStats().getDamage()));
                    heroLife.setText(nf.format(data.getStats().getLife()));
                }
            }
        });
    }

    @Subscribe
    public void changedHeroId(CurrentHeroIdChanged currentHeroId) {
        updateView(currentHeroId.getId());
    }
}
