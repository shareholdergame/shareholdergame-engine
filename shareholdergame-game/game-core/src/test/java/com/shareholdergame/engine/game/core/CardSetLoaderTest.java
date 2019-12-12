package com.shareholdergame.engine.game.core;

import com.shareholdergame.engine.game.core.exception.CardSetGenerationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CardSetLoaderTest {

    @Test
    public void testLoad() throws CardSetGenerationException {
        CardSet cardSet = new CardSetLoader().load();
        Assert.assertNotNull(cardSet);
        Assert.assertEquals(20, cardSet.getMajorCards().size());
        Assert.assertEquals(32, cardSet.getMinorCards().size());
    }
}