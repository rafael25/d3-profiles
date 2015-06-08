package com.r1code.d3profile.mainpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.r1code.d3profile.DataHolder;
import com.r1code.d3profile.R;
import com.r1code.d3profile.contracts.DataUpdatedHandler;
import com.r1code.d3profile.json.d3profile.Profile;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by rafael on 1/06/15.
 */
public class ProfilePage extends Fragment {

    @InjectView(R.id.battle_tag)
    TextView battleTag;

    @InjectView(R.id.lifetime_kills)
    TextView lifeTimeKills;

    @InjectView(R.id.elite_kills)
    TextView eliteKills;

    @InjectView(R.id.paragon_level)
    TextView paragonLevel;

    public ProfilePage() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_page, container, false);
        ButterKnife.inject(this, view);

        DataHolder dataHolder = DataHolder.getInstance();

        dataHolder.getProfile("rafael25#1369", new DataUpdatedHandler<Profile>() {
            @Override
            public void onDataUpdated(Profile data) {
                battleTag.setText(data.getBattleTag());
                lifeTimeKills.setText(data.getKills().getMonsters() + "");
                eliteKills.setText(data.getKills().getElites() + "");
                paragonLevel.setText(data.getParagonLevel() + "");
            }
        });

        return view;
    }
}
