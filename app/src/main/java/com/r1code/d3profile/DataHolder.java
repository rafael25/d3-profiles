package com.r1code.d3profile;

import android.util.Log;

import com.r1code.d3profile.contracts.DataUpdatedInterface;
import com.r1code.d3profile.http.DiabloAPIClient;
import com.r1code.d3profile.json.d3profile.Profile;

import java.util.WeakHashMap;

/**
 * Created by rafael on 4/06/15.
 */
public class DataHolder {

    private static DataHolder instance = null;

    private WeakHashMap<String, Profile> profiles;

    private DataHolder() {
        profiles = new WeakHashMap<>();
    }

    public static DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
        }
        return instance;
    }

    public void getProfile(String battleTag, final DataUpdatedInterface<Profile> callback) {

        if (profiles.get(battleTag) != null) {
            Log.i("DATA-HOLDER", "Datos accedidos desde Data Holder");
            callback.onDataUpdated(profiles.get(battleTag));
        }

        if (profiles.get(battleTag) == null) {
            DiabloAPIClient client = DiabloAPIClient.getInstance();

            client.getProfile(battleTag, new DataUpdatedInterface<Profile>() {
                @Override
                public void onDataUpdated(Profile data) {
                    profiles.put(data.getBattleTag(), data);
                    callback.onDataUpdated(data);
                }
            });
        }
    }
}
