package com.stasbar.currencybrowser.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanisław on 2015-08-05.
 */
@Root(name = "tabela_kursow")
public class Tabela_kursow
{
    @Attribute(name = "typ")
    private String typ;

    @Attribute(name = "uid")
    private String uid;

    @Element(name = "numer_tabeli")
    private String numer_tabeli;

    @Element(name = "data_publikacji")
    private String data_publikacji;

    @ElementList(inline = true,name = "pozycja")
    private List<Pozycja> pozycja = new ArrayList<>();



    public String getUid ()
    {
        return uid;
    }


    public String getNumer_tabeli ()
    {
        return numer_tabeli;
    }


    public List<Pozycja> getPozycja ()
    {
        return pozycja;
    }

    public String getTyp ()
    {
        return typ;
    }

    public String getData_publikacji ()
    {
        return data_publikacji;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [uid = "+uid+", numer_tabeli = "+numer_tabeli+", pozycja = "+pozycja+", typ = "+typ+", data_publikacji = "+data_publikacji+"]";
    }
}

