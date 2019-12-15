package com.shareholdergame.engine.game.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.shareholdergame.engine.game.core.exception.CardSetGenerationException;

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

    private ObjectMapper mapper = new ObjectMapper();

    public GameConfiguration readConfiguration() {
        JsonNode rootNode = loadJson(GAME_CLASSIC_CONFIG_JSON);

        return null;
    }

    public CardSet load() throws CardSetGenerationException {
        JsonNode jsonNode = loadJson(CARD_SET_JSON);
        if (!jsonNode.isArray() || jsonNode.isEmpty()) {
            throw new CardSetGenerationException();
        }
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
                throw new CardSetGenerationException();
            }
        }
        return builder.build();
    }

    private <T> T readField(JsonNode jsonNode, String fieldName, Function<JsonNode, T> converterFunction)
            throws CardSetGenerationException {
        return Optional.ofNullable(jsonNode.get(fieldName)).map(converterFunction)
                .orElseThrow(CardSetGenerationException::new);
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
