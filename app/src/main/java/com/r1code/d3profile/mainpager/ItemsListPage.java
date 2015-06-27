package com.r1code.d3profile.mainpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r1code.d3profile.DataHolder;
import com.r1code.d3profile.R;
import com.r1code.d3profile.contracts.DataUpdatedHandler;
import com.r1code.d3profile.events.CurrentHeroIdChanged;
import com.r1code.d3profile.json.d3hero.Hero;
import com.r1code.d3profile.json.d3hero.Items;
import com.r1code.d3profile.services.OttoBusProvider;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by rafael on 11/06/15.
 */
public class ItemsListPage extends Fragment {

    @InjectView(R.id.items_list)
    RecyclerView recyclerView;

    Items heroItems = new Items();
    ItemsListAdapter itemsListAdapter;
    private boolean isRegistered;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.items_list_page, container, false);
        ButterKnife.inject(this, view);

        if (! isRegistered) {
            isRegistered = true;
            OttoBusProvider.getInstance().register(this);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        itemsListAdapter = new ItemsListAdapter(heroItems);
        recyclerView.setAdapter(itemsListAdapter);

        updateView(DataHolder.getInstance().getCurrentHeroId());

        return view;
    }

    private void updateView(final long heroId) {
        DataHolder dataHolder = DataHolder.getInstance();

        dataHolder.getHero(dataHolder.getCurrentBattleTag(), heroId, new DataUpdatedHandler<Hero>() {
            @Override
            public void onDataUpdated(Hero data) {
                heroItems.setItems(data.getItems().getItems());
                itemsListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        updateView(DataHolder.getInstance().getCurrentHeroId());
    }

    @Subscribe
    public void changedHeroId(CurrentHeroIdChanged currentHeroId) {
        updateView(currentHeroId.getId());
    }
}
