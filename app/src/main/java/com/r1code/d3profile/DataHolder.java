package com.r1code.d3profile;

import android.util.Log;

import com.r1code.d3profile.contracts.DataUpdatedHandler;
import com.r1code.d3profile.http.DiabloAPIClient;
import com.r1code.d3profile.json.d3hero.Hero;
import com.r1code.d3profile.json.d3profile.Profile;

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

    private DataHolder() {
        profiles = new WeakHashMap<>();
        heroes = new WeakHashMap<>();
        currentBattleTag = "";
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

    public void setCurrentHeroId(long currentHeroId) {
        this.currentHeroId = currentHeroId;
    }
}
