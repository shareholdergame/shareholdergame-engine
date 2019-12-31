package com.shareholdergame.engine.game.core.configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.shareholdergame.engine.game.core.*;
import com.shareholdergame.engine.game.core.exception.ConfigurationReadingException;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class GameConfigurationReader {

    private static final String GAME_CLASSIC_CONFIG_JSON = "game-classic-config.json";
    private static final String CARD_SET_JSON = "card-set.json";
    private static final String CARD_ID = "cardId";
    private static final String GROUP = "group";
    private static final String OPERATIONS = "operations";
    private static final String OPERAND = "operand";
    private static final String COLOR_ID = "colorId";
    private static final String OPERATION = "operation";
    private static final String PRICE_SCALE = "priceScale";
    private static final String COLORS = "colors";
    private static final String CASH = "cash";
    private static final String INITIAL_VALUE = "initialValue";
    private static final String INITIAL_PRICE = "initialPrice";
    private static final String INITIAL_QUANTITY = "initialQuantity";
    private static final String MIN_PRICE = "minPrice";
    private static final String MAX_PRICE = "maxPrice";
    private static final String STEP = "step";
    private static final String CARD_SET = "cardSet";

    private ObjectMapper mapper = new ObjectMapper();

    public GameConfiguration readConfiguration() throws ConfigurationReadingException {
        JsonNode rootNode = loadJson(GAME_CLASSIC_CONFIG_JSON);
        GameConfiguration.GameConfigurationBuilder gameConfigurationBuilder = GameConfiguration.builder();
        if (rootNode.has(PRICE_SCALE)) {
            gameConfigurationBuilder.priceScale(parsePriceScale(rootNode.get(PRICE_SCALE)));
        }
        if (rootNode.has(COLORS) && rootNode.get(COLORS).isArray()) {
            JsonNode colorsArray = rootNode.get(COLORS);
            for (JsonNode colorNode : colorsArray) {
                gameConfigurationBuilder.addColor(parseColorNode(colorNode));
            }
        }
        if (rootNode.has(CASH)) {
            gameConfigurationBuilder
                    .cashInitialValue(readField(rootNode.get(CASH), INITIAL_VALUE, JsonNode::asDouble));
        }
        if (rootNode.has(CARD_SET) && rootNode.get(CARD_SET).isArray()) {
            gameConfigurationBuilder.cardSet(parseCardSet(rootNode.get(CARD_SET)));
        }
        return gameConfigurationBuilder.build();
    }

    private Color parseColorNode(JsonNode colorNode) throws ConfigurationReadingException {
        return Color.of(readField(colorNode, COLOR_ID, JsonNode::asLong),
                readField(colorNode, INITIAL_PRICE, JsonNode::asDouble),
                readField(colorNode, INITIAL_QUANTITY, JsonNode::asInt));
    }

    private PriceScale parsePriceScale(JsonNode priceScaleNode) throws ConfigurationReadingException {
        return PriceScale.of(readField(priceScaleNode, MIN_PRICE, JsonNode::asDouble),
                readField(priceScaleNode, MAX_PRICE, JsonNode::asDouble),
                readField(priceScaleNode, STEP, JsonNode::asDouble));
    }

    private CardSet parseCardSet(JsonNode jsonNode) throws ConfigurationReadingException {
        CardSet.CardSetBuilder builder = CardSet.builder();
        for (JsonNode cardNode : jsonNode) {
            if (cardNode.isObject()) {
                Card.CardBuilder cardBuilder = Card.builder();
                Long cardId = readField(cardNode, CARD_ID, JsonNode::asLong);
                String group = readField(cardNode, GROUP, JsonNode::asText);
                JsonNode operations = cardNode.get(OPERATIONS);
                for (JsonNode operationNode : operations) {
                    double operand = operationNode.get(OPERAND).asDouble();
                    Long shareId = readField(operationNode, COLOR_ID, JsonNode::asLong);
                    ArithmeticOperation arithmeticOperation =
                            ArithmeticOperation.valueOf(readField(operationNode, OPERATION, JsonNode::asText));
                    CardOperation cardOperation = CardOperation.of(shareId, Operation.of(operand, arithmeticOperation));
                    cardBuilder.addOperation(cardOperation);
                }
                cardBuilder.cardId(cardId);
                if (group.equalsIgnoreCase(CardGroup.MAJOR.name())) {
                    builder.addMajorCard(cardBuilder.build());
                } else {
                    builder.addMinorCard(cardBuilder.build());
                }
            } else {
                throw new ConfigurationReadingException();
            }
        }
        return builder.build();
    }

    private <T> T readField(JsonNode jsonNode, String fieldName, Function<JsonNode, T> converterFunction)
            throws ConfigurationReadingException {
        return Optional.ofNullable(jsonNode.get(fieldName)).map(converterFunction)
                .orElseThrow(ConfigurationReadingException::new);
    }

    private JsonNode loadJson(String fileName) {
        final AtomicReference<JsonNode> jsonNodeAtomicReference = new AtomicReference<>();
        Optional.ofNullable(this.getClass().getClassLoader().getResource(fileName))
                .ifPresent(url -> {
            try {
                jsonNodeAtomicReference.set(mapper.readTree(url));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return Optional.ofNullable(jsonNodeAtomicReference.get()).orElse(new ArrayNode(null, 0));
    }
}
