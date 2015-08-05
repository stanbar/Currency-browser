package com.stasbar.currencybrowser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.stasbar.currencybrowser.R;
import com.stasbar.currencybrowser.pojo.Pozycja;

import java.util.ArrayList;

/**
 * Created by Stanisław on 2015-08-05.
 */
public class PozycjaAdapter extends ArrayAdapter<Pozycja> {
    // View lookup cache
    private static class ViewHolder {
        TextView pozycjaName;
        TextView pozycjaConversion;
        TextView pozycjaAverageExchangeRate;
    }

    public PozycjaAdapter(Context context, ArrayList<Pozycja> pozycjaArrayList) {
        super(context, R.layout.pozycja, pozycjaArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Pozycja pozycja = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.pozycja, parent, false);
            viewHolder.pozycjaName = (TextView) convertView.findViewById(R.id.text_view_name);
            viewHolder.pozycjaConversion = (TextView) convertView.findViewById(R.id.text_view_conversion);
            viewHolder.pozycjaAverageExchangeRate =
                    (TextView) convertView.findViewById(R.id.text_view_average_exchange_rate);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.pozycjaName.setText(pozycja.getNazwa_waluty());
        viewHolder.pozycjaConversion.setText(pozycja.getPrzelicznik());
        viewHolder.pozycjaAverageExchangeRate.setText(pozycja.getKurs_sredni());
        // Return the completed view to render on screen
        return convertView;
    }
}