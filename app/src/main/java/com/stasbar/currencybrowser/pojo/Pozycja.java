package com.stasbar.currencybrowser.pojo;

/**
 * Created by Stanisław on 2015-08-05.
 */
public class Pozycja
{
    private String przelicznik;

    private String kurs_sredni;

    private String nazwa_waluty;

    private String kod_waluty;

    public String getPrzelicznik ()
    {
        return przelicznik;
    }

    public void setPrzelicznik (String przelicznik)
    {
        this.przelicznik = przelicznik;
    }

    public String getKurs_sredni ()
    {
        return kurs_sredni;
    }

    public void setKurs_sredni (String kurs_sredni)
    {
        this.kurs_sredni = kurs_sredni;
    }

    public String getNazwa_waluty ()
    {
        return nazwa_waluty;
    }

    public void setNazwa_waluty (String nazwa_waluty)
    {
        this.nazwa_waluty = nazwa_waluty;
    }

    public String getKod_waluty ()
    {
        return kod_waluty;
    }

    public void setKod_waluty (String kod_waluty)
    {
        this.kod_waluty = kod_waluty;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [przelicznik = "+przelicznik+", kurs_sredni = "+kurs_sredni+", nazwa_waluty = "+nazwa_waluty+", kod_waluty = "+kod_waluty+"]";
    }
}

