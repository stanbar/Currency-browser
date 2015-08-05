package com.stasbar.currencybrowser.api;

import com.stasbar.currencybrowser.pojo.Tabela_kursow;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Stanisław on 2015-08-05.
 */
public interface ApiService {

    @GET("/kursy/xml/a149z150804.xml")
    void getTable(Callback<Tabela_kursow> boardCallback);
}

