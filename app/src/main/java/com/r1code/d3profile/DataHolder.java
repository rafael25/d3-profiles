package com.r1code.d3profile;

import android.util.Log;

import com.r1code.d3profile.contracts.DataUpdatedHandler;
import com.r1code.d3profile.http.DiabloAPIClient;
import com.r1code.d3profile.json.d3profile.Profile;

import java.util.WeakHashMap;

/**
 * Created by rafael on 4/06/15.
 */
public class DataHolder {

    private static DataHolder instance = null;

    private WeakHashMap<String, Profile> profiles;
    private String currentBattleTag;
    private long currentHeroId;

    private DataHolder() {
        profiles = new WeakHashMap<>();
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
            Log.i(DataHolder.class.getName(), "Datos accedidos desde Data Holder");
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
