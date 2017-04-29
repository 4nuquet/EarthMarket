package com.a4nuquet.anuquet.earthmarket.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.a4nuquet.anuquet.earthmarket.R;
import com.a4nuquet.anuquet.earthmarket.models.Fruit;

import java.util.List;

/**
 * Created by oscar on 29/04/2017.
 */

public class FruitAdapter extends BaseAdapter {


    LayoutInflater inflater;
    List<Fruit> data;

    public FruitAdapter(LayoutInflater inflater, List<Fruit> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = convertView;

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.template_fruit, parent, false);
        }

        Fruit f = data.get(position);

        ImageView image = (ImageView) rootView.findViewById(R.id.image);
        TextView name = (TextView)rootView.findViewById(R.id.nombre);
        TextView pHoy = (TextView) rootView.findViewById(R.id.pricetoday);
        TextView pYester = (TextView) rootView.findViewById(R.id.priceyester);

        name.setText(f.getName());
        pHoy.setText(""+f.getP_today());
        pYester.setText(""+f.getP_yester());

        Picasso.with(image.getContext())
                .load(Uri.parse(f.getImage()))
                .into(image);

        return rootView;

    }
}
