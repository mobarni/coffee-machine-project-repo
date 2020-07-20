package com.barkire.coffeemachine.utils;

import com.barkire.coffeemachine.dto.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProtocolMakerUtilTest {
    /**
     * Five following tests for the first iteration
     */
    @Test
    void drink_maker_makes_one_tea_with_sugar() {

        Tea firstOrder = new Tea();
        firstOrder.setNumberOfSugar(1);

        String resultProtocol = ProtocolMakerUtil.convertOrder(firstOrder);

        assertEquals("Th:1:0", resultProtocol);

    }

    @Test
    void drink_maker_makes_one_chocolate_with_no_sugar() {
        Chocolate secondOrder = new Chocolate();
        secondOrder.setNumberOfSugar(0);

        String resultProtocol = ProtocolMakerUtil.convertOrder(secondOrder);

        assertEquals("Hh::", resultProtocol);

    }

    @Test
    void drink_maker_makes_one_coffee_with_sugar() {
        Coffee thirdOrder = new Coffee();
        thirdOrder.setNumberOfSugar(2);

        String resultProtocol = ProtocolMakerUtil.convertOrder(thirdOrder);

        assertEquals("Ch:2:0", resultProtocol);

    }


    /**
     * Six following tests for the second iteration
     */
    @Test
    void order_tea_with_five_euros() throws Exception {
        Tea order = new Tea();
        order.setNumberOfSugar(2);

        Money money = new Money();
        money.setCashInserted(5);

        String resultProtocol = ProtocolMakerUtil.deliverDrink(order, money);

        assertEquals("Th:2:0", resultProtocol);

    }

    @Test
    void order_coffee_with_fifty_cents() throws Exception {
        Coffee order = new Coffee();
        order.setNumberOfSugar(2);

        Money money = new Money();
        money.setCashInserted(0.5);

        String resultProtocol = ProtocolMakerUtil.deliverDrink(order, money);

        assertEquals("M:0.1 euros are missing for making a cup of coffee extra hot", resultProtocol);

    }

    @Test
    void order_chocolate_with_thirty_cents() throws Exception {
        Chocolate order = new Chocolate();
        order.setNumberOfSugar(1);

        Money money = new Money();
        money.setCashInserted(0.3);

        String resultProtocol = ProtocolMakerUtil.deliverDrink(order, money);

        assertEquals("M:0.2 euros are missing for making a cup of chocolate extra hot", resultProtocol);

    }


    @Test
    void order_coffee_with_seventy_cents() throws Exception {
        Coffee order = new Coffee();
        order.setNumberOfSugar(2);

        Money money = new Money();
        money.setCashInserted(0.7);

        String resultProtocol = ProtocolMakerUtil.deliverDrink(order, money);

        assertEquals("Ch:2:0", resultProtocol);

    }

    @Test
    void order_tea_with_zero_cents() throws Exception{
        Tea order = new Tea();
        order.setNumberOfSugar(1);

        Money money = new Money();
        money.setCashInserted(0);

        String resultProtocol = ProtocolMakerUtil.deliverDrink(order, money);


        assertEquals("M:0.4 euros are missing for making a cup of tea extra hot", resultProtocol);

    }

    @Test
    void order_chocolate_with_negative_amount_cents() {
        Chocolate order = new Chocolate();
        order.setNumberOfSugar(1);

        Money money = new Money();
        money.setCashInserted(-2);
        Exception exception = assertThrows(Exception.class, () -> {
            ProtocolMakerUtil.deliverDrink(order, money);
        });

        String expectedMessage = "Bad input for the money";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


    }


    /**
     * Three following tests for the third iteration
     */


    @Test
    void order_orange_with_sixty_cents() throws Exception {
        Orange order = new Orange();
        order.setNumberOfSugar(3);

        Money money = new Money();
        money.setCashInserted(0.6);

        String resultProtocol = ProtocolMakerUtil.deliverDrink(order, money);

        assertEquals("O:3:0", resultProtocol);

    }

    @Test
    void order_orange_with_zero_cents() throws Exception{
        Orange order = new Orange();
        order.setNumberOfSugar(1);

        Money money = new Money();
        money.setCashInserted(0);

        String resultProtocol = ProtocolMakerUtil.deliverDrink(order, money);

        assertEquals("M:0.6 euros are missing for making a cup of orange juice", resultProtocol);

    }

    @Test
    void order_orange_with_negative_amount_cents() {
        Orange order = new Orange();
        order.setNumberOfSugar(1);

        Money money = new Money();
        money.setCashInserted(-3);
        Exception exception = assertThrows(Exception.class, () -> {
            ProtocolMakerUtil.deliverDrink(order, money);
        });

        String expectedMessage = "Bad input for the money";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


    }



}