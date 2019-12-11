package com.shareholdergame.engine.game.core;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CardSetTest {

    @Test
    public void testCreateCardSet() {
        CardSet cardSet = CardSet.builder()
                .addMajorCard(Card.builder()
                        .cardId(10011L)
                        .addOperation(CardOperation.of(1L, Operation.of(100, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-30, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-20, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-10, ArithmeticOperation.ADD)))
                        .build())
                .addMajorCard(Card.builder()
                        .cardId(10012L)
                        .addOperation(CardOperation.of(1L, Operation.of(100, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-30, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-20, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-10, ArithmeticOperation.ADD)))
                        .build())
                .addMajorCard(Card.builder()
                        .cardId(10013L)
                        .addOperation(CardOperation.of(1L, Operation.of(100, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-30, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-20, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-10, ArithmeticOperation.ADD)))
                        .build())
                .addMajorCard(Card.builder()
                        .cardId(21L)
                        .addOperation(CardOperation.of(1L, Operation.of(2, ArithmeticOperation.MULT)))
                        .addOperation(CardOperation.of(0L, Operation.of(0.5, ArithmeticOperation.MULT)))
                        .build())
                .addMajorCard(Card.builder()
                        .cardId(-21L)
                        .addOperation(CardOperation.of(0L, Operation.of(2, ArithmeticOperation.MULT)))
                        .addOperation(CardOperation.of(1L, Operation.of(0.5, ArithmeticOperation.MULT)))
                        .build())
                .addMinorCard(Card.builder()
                        .cardId(301L)
                        .addOperation(CardOperation.of(1L, Operation.of(30, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(-60, ArithmeticOperation.ADD)))
                        .build())
                .addMinorCard(Card.builder()
                        .cardId(-301L)
                        .addOperation(CardOperation.of(1L, Operation.of(-30, ArithmeticOperation.ADD)))
                        .addOperation(CardOperation.of(0L, Operation.of(60, ArithmeticOperation.ADD)))
                        .build())
                .build();

        Assert.assertNotNull(cardSet);
        //Assert.assertEquals(52, cardSet.getMajorCards().size());
    }
}