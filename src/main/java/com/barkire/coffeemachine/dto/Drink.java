package com.barkire.coffeemachine.dto;

import static com.barkire.coffeemachine.utils.ProtocolMakerUtil.EMPTY;

public abstract class Drink {
    protected DrinkEnum typeOfDrink;
    protected int numberOfSugar;
    protected String message=EMPTY;


    public Drink(DrinkEnum typeOfDrink) {
        this.typeOfDrink = typeOfDrink;
    }

    public DrinkEnum getTypeOfDrink() {
        return typeOfDrink;
    }

    public void setTypeOfDrink(DrinkEnum typeOfDrink) {
        this.typeOfDrink = typeOfDrink;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }

    public void setNumberOfSugar(int numberOfSugar) {
        this.numberOfSugar = numberOfSugar;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public abstract String buildMessage(double missingMoney) ;
}
