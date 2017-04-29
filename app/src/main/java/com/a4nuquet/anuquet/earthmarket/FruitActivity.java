package com.a4nuquet.anuquet.earthmarket;

import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.a4nuquet.anuquet.earthmarket.models.Fruit;
import com.a4nuquet.anuquet.earthmarket.util.Data;
import com.squareup.picasso.Picasso;

/**
 * Created by oscar on 29/04/2017.
 */

public class FruitActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fruit);

        int pos = getIntent().getExtras().getInt("pos");
        Fruit f = Data.data.get(pos);

        ImageView image = (ImageView)findViewById(R.id.image);
        TextView name = (TextView)findViewById(R.id.nombre);
        TextView pHoy = (TextView) findViewById(R.id.today);
        TextView pYester = (TextView) findViewById(R.id.yester);

        name.setText(f.getName());
        pHoy.setText(""+f.getP_today());
        pYester.setText(""+f.getP_yester());

        Picasso.with(this)
                .load(Uri.parse(f.getImage()))
                .into(image);
    }
}
