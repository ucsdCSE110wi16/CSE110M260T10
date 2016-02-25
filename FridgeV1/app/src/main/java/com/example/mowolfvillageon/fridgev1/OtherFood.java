package com.example.mowolfvillageon.fridgev1;

/**
 * Created by mowolfvillageon on 2/24/16.
 */
public class OtherFood extends Food{

    private String name;

    public OtherFood(String owner, String name) {
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
