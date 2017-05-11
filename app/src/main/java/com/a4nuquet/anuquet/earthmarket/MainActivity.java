package com.a4nuquet.anuquet.earthmarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.a4nuquet.anuquet.earthmarket.adapter.FruitAdapter;
import com.a4nuquet.anuquet.earthmarket.models.Fruit;
import com.a4nuquet.anuquet.earthmarket.net.FruitService;
import com.a4nuquet.anuquet.earthmarket.util.Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, Callback<List<Fruit>> {

    FruitAdapter adapter;
    ListView list;
    FruitService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        Data.data = new ArrayList<>();
        adapter = new FruitAdapter(getLayoutInflater(), Data.data);
        list.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.btn_Add);
        btn.setOnClickListener(this);

        //Instancia para cargar la lista
            service = Data.retrofit
                .create(FruitService.class);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Call<List<Fruit>> response = service.getAll();//Se ejecuta cuando se invoca
        response.enqueue(this);//para que se ejecute asincronamente
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, FruitActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResponse(Call<List<Fruit>> call, Response<List<Fruit>> response) {
        adapter.setData(response.body());
    }

    @Override
    public void onFailure(Call<List<Fruit>> call, Throwable t) {
        Toast.makeText(this,"Error al realizar consulta", Toast.LENGTH_SHORT).show();
    }
}

