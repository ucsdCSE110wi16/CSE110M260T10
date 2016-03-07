package com.example.mowolfvillageon.fridgev1.FoodFiles;

/**
 * Created by mowolfvillageon on 2/24/16.
 */
public class FrozenMeals  extends Food{
    private String name;
    private String catagory;
    private String expiration;

    public FrozenMeals(String owner, String name, String expiration) {
        super(owner);
        this.name = name;
        this.catagory = "Frozen Meals";
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
