package com.a4nuquet.anuquet.earthmarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.a4nuquet.anuquet.earthmarket.adapter.FruitAdapter;
import com.a4nuquet.anuquet.earthmarket.models.Fruit;
import com.a4nuquet.anuquet.earthmarket.util.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    FruitAdapter adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        Data.data = new ArrayList<>();
        adapter = new FruitAdapter(getLayoutInflater(), Data.data);
        list.setAdapter(adapter);

        loadFruit();
    }


    public void loadFruit()
    {
        Fruit f1 = new Fruit();
        f1.setImage("http://www.frutismo.co/wp-content/uploads/2015/03/granadilla.jpg");
        f1.setName("GRANADILLA");
        f1.setP_today(12000);
        f1.setP_yester(10000);

        Fruit f2 = new Fruit();
        f2.setImage("https://cdn.shopify.com/s/files/1/1382/4921/products/Papa_Pastusa_2048x2048.jpg?v=1479351571");
        f2.setName("PAPA");
        f2.setP_today(20000);
        f2.setP_yester(5000);

        Data.data.add(f1);
        Data.data.add(f2);

        adapter.notifyDataSetChanged();


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, FruitActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent);
    }
}

