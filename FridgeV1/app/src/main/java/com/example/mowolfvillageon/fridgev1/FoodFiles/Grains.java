package com.example.mowolfvillageon.fridgev1.FoodFiles;


import com.example.mowolfvillageon.fridgev1.Food;

public class Grains extends Food {
    private String name;
    private String catagory;
    private String expiration;

    public Grains(String owner, String name, String expiration) {
        super(owner, "Grains", expiration, name);
        /* super(owner);
        this.name = name;
        this.catagory = "Grain";
        this.expiration = expiration; */
    }

    /* public String getName() {
        return name;
    }

    public String getCatagory() { return catagory; }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiration () { return expiration; } */
}
