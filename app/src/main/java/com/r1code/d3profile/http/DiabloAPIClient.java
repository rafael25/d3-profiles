package com.r1code.d3profile.http;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.r1code.d3profile.contracts.DataUpdatedHandler;
import com.r1code.d3profile.json.d3profile.Profile;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 2/06/15.
 */
public class DiabloAPIClient {

    private static DiabloAPIClient instance;

    private final String BASE_URL = "http://us.battle.net/api/d3/";

    private AsyncHttpClient client;
    private ObjectMapper mapper;
    private List<DataUpdatedHandler> queue;

    private DiabloAPIClient() {
        client = new AsyncHttpClient();
        mapper = new ObjectMapper();
        queue = new ArrayList<>();
    }

    public static DiabloAPIClient getInstance() {
        if (instance == null) {
            instance = new DiabloAPIClient();
        }
        return instance;
    }

    public void getProfile(String battleTag, final DataUpdatedHandler<Profile> callback) {
        battleTag = battleTag.replace('#', '-');
        queue.add(callback);

        if (queue.size() == 1 /* Download only first time called */) {
            client.get(BASE_URL + "profile/" + battleTag + '/', null, new BaseJsonHttpResponseHandler<Profile>() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Profile response) {
                    Log.i(DiabloAPIClient.class.getName(), "Consulta realizada a API");
                    for (DataUpdatedHandler callback : queue) {
                        callback.onDataUpdated(response);
                    }
                    queue.clear();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Profile errorResponse) {
                }

                @Override
                protected Profile parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                    Profile profile = new Profile();

                    if (!isFailure) {
                        profile = mapper.readValue(rawJsonData, Profile.class);
                    }

                    return profile;
                }
            });
        }
    }
}
