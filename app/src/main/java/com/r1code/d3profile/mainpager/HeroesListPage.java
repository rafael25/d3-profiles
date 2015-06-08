package com.r1code.d3profile.mainpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r1code.d3profile.DataHolder;
import com.r1code.d3profile.R;
import com.r1code.d3profile.contracts.DataUpdatedHandler;
import com.r1code.d3profile.json.d3profile.Hero;
import com.r1code.d3profile.json.d3profile.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 5/06/15.
 */
public class HeroesListPage extends Fragment {

    RecyclerView recyclerView;
    HeroesListAdapter heroesListAdapter;

    List<Hero> heroes = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.heroes_list_page, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.heroes_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        heroesListAdapter = new HeroesListAdapter(heroes, this);
        recyclerView.setAdapter(heroesListAdapter);

        DataHolder.getInstance().getProfile("rafael25#1369", new DataUpdatedHandler<Profile>() {
            @Override
            public void onDataUpdated(Profile data) {
                heroes.clear();
                heroes.addAll(data.getHeroes());
                heroesListAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}
