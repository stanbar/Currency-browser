package com.stasbar.currencybrowser.api;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by Stanisław on 2015-08-05.
 */
public class ApiClient {
    private static ApiService apiService;

    public static ApiService getApiClient() {
        if (apiService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setClient(new OkClient(new OkHttpClient()))
                    .setEndpoint("http://www.nbp.pl")
                    .setConverter(new SimpleXMLConverter())
                    .build();
            apiService = restAdapter.create(ApiService.class);
        }
        return apiService;
    }

}
