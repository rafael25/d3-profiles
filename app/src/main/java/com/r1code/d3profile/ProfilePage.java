package com.r1code.d3profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.r1code.d3profile.json.d3profile.Profile;

import org.apache.http.Header;

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

        getProfile("profile/rafael25-1369/", null, new BaseJsonHttpResponseHandler<Profile>() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Profile response) {
                battleTag.setText(response.getBattleTag());
                lifeTimeKills.setText(response.getKills().getMonsters() + "");
                eliteKills.setText(response.getKills().getElites() + "");
                paragonLevel.setText(response.getParagonLevel() + "");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Profile errorResponse) {
            }

            @Override
            protected Profile parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                Profile profile = new Profile();
                ObjectMapper mapper = new ObjectMapper();

                if (!isFailure) {
                    profile = mapper.readValue(rawJsonData, Profile.class);
                }

                return profile;
            }
        });

        return view;
    }

    private void getProfile(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://us.battle.net/api/d3/" + url, params, responseHandler);
    }
}
