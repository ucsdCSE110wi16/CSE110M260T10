package com.example.mowolfvillageon.fridgev1;


public abstract class Food {
    private String owner;
    private String category;
    private String expiration;
    private String name;

    public Food(String owner, String category, String expiration, String name) {
        this.owner = owner;
        this.category = category;
        this.expiration = expiration;
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public String getCategory() {
        return category;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
