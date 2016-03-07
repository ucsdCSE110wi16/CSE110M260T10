package com.example.mowolfvillageon.fridgev1.FoodFiles;


public class Meats extends Food {
    private String name;
    private String catagory;

    public Meats(String owner, String name) {
        super(owner);
        this.name = name;
        this.catagory = "Meats";
    }

    public String getName() {
        return name;
    }

    public String getCatagory() { return catagory; }

    public void setName(String name) {
        this.name = name;
    }
}
