package com.r1code.d3profile;

import android.util.Log;

import com.r1code.d3profile.contracts.DataUpdatedHandler;
import com.r1code.d3profile.events.CurrentHeroIdChanged;
import com.r1code.d3profile.http.DiabloAPIClient;
import com.r1code.d3profile.json.d3hero.Hero;
import com.r1code.d3profile.json.d3profile.Profile;
import com.r1code.d3profile.services.OttoBusProvider;
import com.squareup.otto.Subscribe;

import java.util.WeakHashMap;

/**
 * Created by rafael on 4/06/15.
 */
public class DataHolder {

    private static DataHolder instance = null;

    private WeakHashMap<String, Profile> profiles;
    private WeakHashMap<Long, Hero> heroes;

    private String currentBattleTag;
    private long currentHeroId;
    private boolean registered = false;

    private DataHolder() {
        profiles = new WeakHashMap<>();
        heroes = new WeakHashMap<>();
        currentBattleTag = "";

        currentHeroId = 24571053l;
        currentBattleTag = "rafael25#1369";

        if (! registered) {
            registered = true;
            OttoBusProvider.getInstance().register(this);
        }
    }

    public static DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
        }
        return instance;
    }

    public void getProfile(final String battleTag, final DataUpdatedHandler<Profile> callback) {

        if (profiles.get(battleTag) != null) {
            Log.i(DataHolder.class.getName(), "Datos de perfil accedidos desde Data Holder");
            currentBattleTag = battleTag;
            callback.onDataUpdated(profiles.get(battleTag));
        }

        if (profiles.get(battleTag) == null) {
            DiabloAPIClient client = DiabloAPIClient.getInstance();

            client.getProfile(battleTag, new DataUpdatedHandler<Profile>() {
                @Override
                public void onDataUpdated(Profile data) {
                    currentBattleTag = battleTag;
                    profiles.put(data.getBattleTag(), data);
                    callback.onDataUpdated(data);
                }
            });
        }
    }

    public void getHero(final String battleTag, final long heroId, final DataUpdatedHandler<Hero> callback) {

        if (heroes.get(heroId) != null) {
            Log.i(DataHolder.class.getName(), "Datos de heroe accedidos desde Data Holder");
            currentHeroId = heroId;
            callback.onDataUpdated(heroes.get(heroId));
        }

        if (heroes.get(new Long(heroId)) == null) {
            DiabloAPIClient client = DiabloAPIClient.getInstance();

            client.getHero(battleTag, heroId, new DataUpdatedHandler<Hero>() {
                @Override
                public void onDataUpdated(Hero data) {
                    currentHeroId = data.getId();
                    heroes.put(data.getId(), data);
                    callback.onDataUpdated(data);
                }
            });
        }
    }

    public void setCurrentBattleTag(String battleTag) {
        this.currentBattleTag = battleTag;
    }

    public String getCurrentBattleTag() {
        return currentBattleTag;
    }

    public long getCurrentHeroId() {
        return currentHeroId;
    }

    @Subscribe
    public void setCurrentHeroId(CurrentHeroIdChanged currentHeroId) {
        this.currentHeroId = currentHeroId.getId();
    }
}
