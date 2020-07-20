package com.barkire.coffeemachine.dto;

public class Tea extends Drink{

    public Tea(){
        super(DrinkEnum.TEA);
    }

    public String buildMessage(double missingMoney) {
        return missingMoney + " euros are missing for making a cup of tea extra hot";
    }


}
