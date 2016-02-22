package com.example.mowolfvillageon.fridgev1;

/**
 * Created by Kevin on 2/21/2016.
 */
public class Vegetables extends Food {
    private String name;

    public Vegetables(String owner, String name) {
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
