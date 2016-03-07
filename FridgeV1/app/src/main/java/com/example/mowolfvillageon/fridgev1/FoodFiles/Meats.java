package com.example.mowolfvillageon.fridgev1.FoodFiles;


public class Meats extends Food {
    private String name;
    private String catagory;
    private String expiration;

    public Meats(String owner, String name, String expiration) {
        super(owner);
        this.name = name;
        this.catagory = "Meats";
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
