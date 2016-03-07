package com.example.mowolfvillageon.fridgev1.FoodFiles;


public class Vegetables extends Food {
    private String name;
    private String catagory;

    public Vegetables(String owner, String name) {
        super(owner);
        this.name = name;
        this.catagory = "Vegetable";
    }

    public String getName() {
        return name;
    }

    public String getCatagory() { return catagory; }

    public void setName(String name) {
        this.name = name;
    }
}
