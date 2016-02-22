package com.example.mowolfvillageon.fridgev1;


public class Fruits extends Food {
    private String name;

    public Fruits(String owner, String name) {
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
