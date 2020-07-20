package com.barkire.coffeemachine.dto;

public class Orange extends Drink {

    public Orange(){
        super(DrinkEnum.ORANGE);
    }

    public String buildMessage(double missingMoney) {
        return missingMoney + " euros are missing for making a cup of orange juice";
    }

}
