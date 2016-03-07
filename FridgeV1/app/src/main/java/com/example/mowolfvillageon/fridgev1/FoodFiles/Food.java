package com.example.mowolfvillageon.fridgev1.FoodFiles;


public abstract class Food {
    private String owner;

    public Food(String owner) {
        this.owner = owner;

    }

    public String getOwner() {
        return owner;
    }

}
