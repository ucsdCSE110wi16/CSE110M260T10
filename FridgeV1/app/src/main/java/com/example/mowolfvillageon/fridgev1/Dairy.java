package com.example.mowolfvillageon.fridgev1;


public class Dairy extends Food {
    private String name;

    public Dairy(String owner, String name) {
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
