package com.example.mowolfvillageon.fridgev1;

/**
 * Created by mowolfvillageon on 2/24/16.
 */
public class Meals extends Food{

    private String name;

    public Meals(String owner, String name) {
        super(owner);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

