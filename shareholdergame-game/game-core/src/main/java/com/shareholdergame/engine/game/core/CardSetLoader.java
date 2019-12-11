package com.shareholdergame.engine.game.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.shareholdergame.engine.game.core.exception.CardSetGenerationException;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class CardSetLoader {

    public static final String CARD_SET_JSON = "card-set.json";

    private ObjectMapper mapper = new ObjectMapper();

    public CardSet load() throws CardSetGenerationException {
        JsonNode jsonNode = loadJson();
        if (!jsonNode.isArray() || jsonNode.isEmpty()) {
            throw new CardSetGenerationException();
        }
        CardSet.CardSetBuilder builder = CardSet.builder();
        for (JsonNode cardNode : jsonNode) {
            if (cardNode.isObject()) {
                Card.CardBuilder cardBuilder = Card.builder();
                Long cardId = (long) cardNode.get("cardId").asInt();
                String group = cardNode.get("group").asText();
                JsonNode operations = cardNode.get("operations");
            } else {
                throw new CardSetGenerationException();
            }
        }
        return builder.build();
    }

    private JsonNode loadJson() {
        final AtomicReference<JsonNode> jsonNodeAtomicReference = new AtomicReference<>();
        Optional.ofNullable(this.getClass().getClassLoader().getResource(CARD_SET_JSON))
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
