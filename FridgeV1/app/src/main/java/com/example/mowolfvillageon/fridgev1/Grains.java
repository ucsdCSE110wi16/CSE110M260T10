package com.example.mowolfvillageon.fridgev1;


public class Grains extends Food {
    private String name;

    public String getName() {
        return name;
    }

    public Grains(String owner, String name) {

        super(owner);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
