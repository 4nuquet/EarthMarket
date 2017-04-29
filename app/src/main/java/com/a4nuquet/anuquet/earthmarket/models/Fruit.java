package com.a4nuquet.anuquet.earthmarket.models;

/**
 * Created by oscar on 29/04/2017.
 */

public class Fruit {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getP_today() {
        return p_today;
    }

    public void setP_today(int p_today) {
        this.p_today = p_today;
    }

    public int getP_yester() {
        return p_yester;
    }

    public void setP_yester(int p_yester) {
        this.p_yester = p_yester;
    }

    String name, type, image;
    int p_today;
    int p_yester;


}
