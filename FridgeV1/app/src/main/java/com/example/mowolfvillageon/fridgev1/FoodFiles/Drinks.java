package com.example.mowolfvillageon.fridgev1.FoodFiles;

/**
 * Created by mowolfvillageon on 2/24/16.
 */
public class Drinks  extends Food{
    private String name;
    private String catagory;

    public Drinks(String owner, String name) {
        super(owner);
        this.name = name;
        this.catagory = "Drink";
    }

    public String getName() {
        return name;
    }

    public String getCatagory() { return catagory; }

    public void setName(String name) {
        this.name = name;
    }
}
