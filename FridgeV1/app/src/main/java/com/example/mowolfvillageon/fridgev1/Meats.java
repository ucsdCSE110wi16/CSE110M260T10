package com.example.mowolfvillageon.fridgev1;


public class Meats extends Food {
    private String name;

    public Meats(String owner, String name) {
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
