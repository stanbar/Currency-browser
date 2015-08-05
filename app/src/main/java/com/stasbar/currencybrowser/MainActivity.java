package com.stasbar.currencybrowser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import com.stasbar.currencybrowser.adapter.PozycjaAdapter;
import com.stasbar.currencybrowser.pojo.Pozycja;
import com.stasbar.currencybrowser.presenter.IMainActivityPresenter;
import com.stasbar.currencybrowser.presenter.MainActivityPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements IMainActivityView, CompoundButton.OnCheckedChangeListener {
    @Bind(R.id.list_view_currency)
    ListView listView;
    @Bind(R.id.cb_USD)
    CheckBox cbUSD;
    @Bind(R.id.cb_AUD)
    CheckBox cbAUD;
    @Bind(R.id.cb_CAD)
    CheckBox cbCAD;
    @Bind(R.id.cb_EUR)
    CheckBox cbEUR;
    @Bind(R.id.cb_CHF)
    CheckBox cbCHF;
    @Bind(R.id.cb_JPY)
    CheckBox cbJPY;
    @Bind(R.id.cb_CZK)
    CheckBox cbCZK;

    private IMainActivityPresenter presenter;
    private ArrayList<Pozycja> pozycjaArrayList = new ArrayList<>();
    private String filter = "USD:AUD:CAD:EUR:CHF:JPY:CZK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainActivityPresenter(this);
        cbUSD.setOnCheckedChangeListener(this);
        cbAUD.setOnCheckedChangeListener(this);
        cbCAD.setOnCheckedChangeListener(this);
        cbEUR.setOnCheckedChangeListener(this);
        cbCHF.setOnCheckedChangeListener(this);
        cbJPY.setOnCheckedChangeListener(this);
        cbCZK.setOnCheckedChangeListener(this);
    }

    @Override
    public void message(String message) {
        Toast.makeText(this, message + " ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void returnList(List<Pozycja> listPozycja) {
        pozycjaArrayList = (ArrayList<Pozycja>) listPozycja;
        showList();
    }

    public void showList() {
        ArrayList<Pozycja> filteredList = new ArrayList<>();
        for (Pozycja pozycja : pozycjaArrayList) {
            if (filter.contains(pozycja.getKod_waluty())) {
                filteredList.add(pozycja);
            }
        }
        PozycjaAdapter adapter = new PozycjaAdapter(this, filteredList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        StringBuilder filterTemp = new StringBuilder(filter);
        switch (compoundButton.getText().toString()) {
            case "USD":
                if (b) {
                    filterTemp.replace(0, 3, "USD");
                    cbUSD.setChecked(true);
                } else {
                    filterTemp.replace(0, 3, "XXX");
                    cbUSD.setChecked(false);
                }
                break;
            case "AUD":
                if (b) {
                    filterTemp.replace(4, 7, "AUD");
                    cbAUD.setChecked(true);
                } else {
                    filterTemp.replace(4, 7, "XXX");
                    cbAUD.setChecked(false);
                }
                break;
            case "CAD":
                if (b) {
                    filterTemp.replace(8, 11, "CAD");
                    cbCAD.setChecked(true);
                } else {
                    filterTemp.replace(8, 11, "XXX");
                    cbCAD.setChecked(false);
                }
                break;
            case "EUR":
                if (b) {
                    filterTemp.replace(12, 15, "EUR");
                    cbEUR.setChecked(true);
                } else {
                    filterTemp.replace(12, 15, "XXX");
                    cbEUR.setChecked(false);
                }
                break;
            case "CHF":
                if (b) {
                    filterTemp.replace(16, 19, "CHF");
                    cbCHF.setChecked(true);
                } else {
                    filterTemp.replace(16, 19, "XXX");
                    cbCHF.setChecked(false);
                }
                break;
            case "JPY":
                if (b) {
                    filterTemp.replace(20, 23, "JPY");
                    cbJPY.setChecked(true);
                } else {
                    filterTemp.replace(20, 23, "XXX");
                    cbJPY.setChecked(false);
                }
                break;
            case "CZK":
                if (b) {
                    filterTemp.replace(24, 27, "CZK");
                    cbCZK.setChecked(true);
                } else {
                    filterTemp.replace(24, 27, "XXX");
                    cbCZK.setChecked(false);
                }
                break;
        }
        filter = filterTemp.toString();
        Log.d("filter", filter);
        showList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_refresh) {
            presenter.getTable();
        }

        return super.onOptionsItemSelected(item);
    }
}
