package com.barkire.coffeemachine.dto;

public class Coffee extends Drink {

    public Coffee(){
        super(DrinkEnum.COFFEE);
    }

    public String buildMessage(double missingMoney) {
        return missingMoney + " euros are missing for making a cup of coffee extra hot";
    }


}
