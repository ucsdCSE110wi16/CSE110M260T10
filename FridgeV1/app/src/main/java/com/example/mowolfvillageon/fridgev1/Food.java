package com.example.mowolfvillageon.fridgev1;


public abstract class Food {
    private String owner;
    private int expiration_month;
    private int expiration_day;
    private int expiration_year;

    public Food(String owner, int expiration_month, int expiration_day, int expiration_year) {
        this.owner = owner;
        this.expiration_month = expiration_month;
        this.expiration_day = expiration_day;
        this.expiration_year = expiration_year;
    }

    public String getOwner() {
        return owner;
    }

    public int getExpiration_month() {
        return expiration_month;
    }

    public int getExpiration_day() {
        return expiration_day;
    }

    public int getExpiration_year() {
        return expiration_year;
    }
}
