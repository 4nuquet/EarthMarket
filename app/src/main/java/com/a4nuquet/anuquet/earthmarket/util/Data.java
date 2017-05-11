package com.a4nuquet.anuquet.earthmarket.util;

import com.a4nuquet.anuquet.earthmarket.models.Fruit;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oscar on 29/04/2017.
 */

public class Data {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")//se interperta con del equipo local
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .build();

    public static List<Fruit> data;

}
