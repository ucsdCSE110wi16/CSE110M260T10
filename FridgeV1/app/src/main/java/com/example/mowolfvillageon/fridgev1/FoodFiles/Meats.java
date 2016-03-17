package com.example.mowolfvillageon.fridgev1.FoodFiles;


import com.example.mowolfvillageon.fridgev1.Food;

public class Meats extends Food {
    private String name;
    private String catagory;
    private String expiration;

    public Meats(String owner, String name, String expiration) {
        super(owner, "Meat", expiration, name);
        /* super(owner);
        this.name = name;
        this.catagory = "Meat";
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
