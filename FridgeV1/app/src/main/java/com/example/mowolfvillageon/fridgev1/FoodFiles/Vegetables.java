package com.example.mowolfvillageon.fridgev1.FoodFiles;


public class Vegetables extends Food {
    private String name;
    private String catagory;
    private String expiration;

    public Vegetables(String owner, String name, String expiration) {
        super(owner);
        this.name = name;
        this.catagory = "Vegetables";
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public String getCatagory() { return catagory; }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiration () { return expiration; }
}
