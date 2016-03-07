package com.example.mowolfvillageon.fridgev1.FoodFiles;


public class Grains extends Food {
    private String name;
    private String catagory;

    public Grains(String owner, String name) {
        super(owner);
        this.name = name;
        this.catagory = "Grain";
    }

    public String getName() {
        return name;
    }

    public String getCatagory() { return catagory; }

    public void setName(String name) {
        this.name = name;
    }
}
