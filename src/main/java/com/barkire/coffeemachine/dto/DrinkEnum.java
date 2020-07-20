package com.barkire.coffeemachine.dto;

public enum DrinkEnum {
    TEA("Th", "0.4"), COFFEE("Ch", "0.6"),
    CHOCOLATE("Hh", "0.5"), ORANGE("O", "0.6"), MESSAGE("M");


    private String abbreviation;
    private String price;

    private DrinkEnum(String abbreviation){
        this.abbreviation = abbreviation;
        this.price = "";
    }

    private DrinkEnum(String abbreviation, String price){
        this.abbreviation = abbreviation;
        this.price = price;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    public String getPrice() {
        return price;
    }
}
