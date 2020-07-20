package com.barkire.coffeemachine.utils;

import com.barkire.coffeemachine.dto.*;

import java.text.DecimalFormat;
import java.util.Arrays;

import static com.barkire.coffeemachine.dto.DrinkEnum.MESSAGE;

public class ProtocolMakerUtil {

    private static String SEPARATOR = ":";
    public static String EMPTY = "";
    private static boolean isStickPresent(Drink drink){
        boolean presence = false;
        if(null != drink) {
            presence = drink.getNumberOfSugar() >= 1;
        }
        return presence;
    }

    public static String convertOrder(Drink drink){
        StringBuilder sb = new StringBuilder();
        if(null != drink && Arrays.asList(DrinkEnum.values()).contains(drink.getTypeOfDrink())) {
            if (MESSAGE.equals(drink.getTypeOfDrink())) {
                sb.append(drink.getTypeOfDrink().getAbbreviation()).append(SEPARATOR).append(drink.getMessage());
            } else {
                sb.append(drink.getTypeOfDrink().getAbbreviation()).append(SEPARATOR).append(isStickPresent(drink) ? drink.getNumberOfSugar() : EMPTY)
                        .append(SEPARATOR).append(isStickPresent(drink) ? 0 : EMPTY);
            }
        }
        return sb.toString();
    }

    public static String deliverDrink(Drink drink, Money money) throws Exception {
        if(money.getCashInserted() < 0){
            throw new Exception("Bad input for the money");
        }
        String result ="";
        Double drinkPrice = Double.parseDouble(drink.getTypeOfDrink().getPrice());
        if(money.getCashInserted() < drinkPrice){
            double missingMoneyTmp = drinkPrice - money.getCashInserted();
            DecimalFormat df = new DecimalFormat("0.00");
            double missingMoney = Double.parseDouble(df.format(missingMoneyTmp).replace(",","."));
            String message = drink.buildMessage(missingMoney);
            drink.setTypeOfDrink(MESSAGE);
            drink.setMessage(message);
        }
        result = convertOrder(drink);
        return result;
    }
}
