package com.barkire.coffeemachine.dto;

public class Chocolate extends Drink {

    public Chocolate(){
        super(DrinkEnum.CHOCOLATE);
    }
    public String buildMessage(double missingMoney) {
        return missingMoney + " euros are missing for making a cup of chocolate extra hot";
    }


}
