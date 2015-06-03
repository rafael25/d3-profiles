package com.r1code.d3profile.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.r1code.d3profile.json.Profile;

import org.apache.http.Header;
import org.json.JSONArray;

/**
 * Created by rafael on 2/06/15.
 */
public class DiabloAPIClient {

    private static final String BASE_URL = "http://us.battle.net/api/d3/";

    private static AsyncHttpClient client = new AsyncHttpClient();
}
