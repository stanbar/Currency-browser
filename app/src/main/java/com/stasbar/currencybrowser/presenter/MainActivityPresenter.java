package com.stasbar.currencybrowser.presenter;

import android.util.Log;
import android.widget.CompoundButton;

import com.stasbar.currencybrowser.IMainActivityView;
import com.stasbar.currencybrowser.api.ApiClient;
import com.stasbar.currencybrowser.pojo.Pozycja;
import com.stasbar.currencybrowser.pojo.Tabela_kursow;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Stanisław on 2015-08-05.
 */
public class MainActivityPresenter implements IMainActivityPresenter {
    private boolean isInProgress= false;
    private IMainActivityView view;

    public MainActivityPresenter(IMainActivityView view){
        this.view = view;
        getTable();
    }

    public void getTable(){

        if(!isInProgress) {
            isInProgress = true;
            ApiClient.getApiClient().getTable(new Callback<Tabela_kursow>() {
                @Override
                public void success(Tabela_kursow tabela, Response response) {
                    Log.d("retrofit",response.getStatus()+"");
                    view.returnList(tabela.getPozycja());
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("Test",error.toString());
                    view.message(error.toString());
                }
            });
            isInProgress=false;

        }
    }

}
