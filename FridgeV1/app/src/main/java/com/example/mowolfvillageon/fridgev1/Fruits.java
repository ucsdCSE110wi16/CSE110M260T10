package com.example.mowolfvillageon.fridgev1;

/**
 * Created by Kevin on 2/21/2016.
 */
public class Fruits extends Food {
    private String name;

    public Fruits(String owner, int expiration_month, int expiration_day, int expiration_year, String name) {
        super(owner, expiration_month, expiration_day, expiration_year);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
