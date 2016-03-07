package com.example.mowolfvillageon.fridgev1.FoodFiles;

/**
 * Created by mowolfvillageon on 2/24/16.
 */
public class Condiments extends Food{

    private String name;
    private String catagory;

    public Condiments(String owner, String name) {
        super(owner);
        this.name = name;
        this.catagory = "Condiment";
    }

    public String getName() {
        return name;
    }

    public String getCatagory() { return catagory; }

    public void setName(String name) {
        this.name = name;
    }
}
