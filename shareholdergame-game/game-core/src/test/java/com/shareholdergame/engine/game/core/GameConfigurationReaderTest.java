package com.shareholdergame.engine.game.core;

import com.shareholdergame.engine.game.core.configuration.GameConfiguration;
import com.shareholdergame.engine.game.core.configuration.GameConfigurationReader;
import com.shareholdergame.engine.game.core.exception.ConfigurationReadingException;
import org.apache.commons.collections4.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GameConfigurationReaderTest {

    @Test
    public void testLoad() throws ConfigurationReadingException {
        GameConfiguration gameConfiguration = new GameConfigurationReader().readConfiguration();
        Assert.assertNotNull(gameConfiguration);
        Assert.assertNotNull(gameConfiguration.getPriceScale());
        Assert.assertTrue(CollectionUtils.isNotEmpty(gameConfiguration.getColors()));
        Assert.assertNotNull(gameConfiguration.getCardSet());
        Assert.assertEquals(20, gameConfiguration.getCardSet().getMajorCards().size());
        Assert.assertEquals(32, gameConfiguration.getCardSet().getMinorCards().size());
    }
}