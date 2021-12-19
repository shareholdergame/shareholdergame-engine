package com.shareholdergame.engine.game.core;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CardSetTest {

    @Test
    public void testCreateCardSet() {
        CardSet cardSet = CardSetUtil.buildCardSet();

        Assert.assertNotNull(cardSet);
        //Assert.assertEquals(52, cardSet.getMajorCards().size());
    }

}