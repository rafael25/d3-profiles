package com.r1code.d3profile.http;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.r1code.d3profile.contracts.DataUpdatedInterface;
import com.r1code.d3profile.json.d3profile.Profile;

import org.apache.http.Header;

/**
 * Created by rafael on 2/06/15.
 */
public class DiabloAPIClient {

    private static DiabloAPIClient instance;

    private final String BASE_URL = "http://us.battle.net/api/d3/";

    private AsyncHttpClient client;
    private ObjectMapper mapper;

    private DiabloAPIClient() {
        client = new AsyncHttpClient();
        mapper = new ObjectMapper();
    }

    public static DiabloAPIClient getInstance() {
        if (instance == null) {
            instance = new DiabloAPIClient();
        }
        return instance;
    }

    public void getProfile(String battleTag, final DataUpdatedInterface<Profile> callback) {
        battleTag = battleTag.replace('#', '-');

        client.get(BASE_URL + "profile/" + battleTag + '/', null, new BaseJsonHttpResponseHandler<Profile>() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Profile response) {
                Log.i("HTTP-CLIENT", "Consulta realizada a API");
                callback.onDataUpdated(response);
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
