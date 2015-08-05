package com.stasbar.currencybrowser;

import com.stasbar.currencybrowser.pojo.Pozycja;

import java.util.List;

/**
 * Created by Stanisław on 2015-08-05.
 */
public interface IMainActivityView {
    void message(String message);

    void returnList(List<Pozycja> listPozycja);
}
