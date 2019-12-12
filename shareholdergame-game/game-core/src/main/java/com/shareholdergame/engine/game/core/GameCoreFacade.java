package com.shareholdergame.engine.game.core;

public class GameCoreFacade {

    public GameInitializer gameInitializer() {
        return new GameInitializer();
    }

    public void doTurn(Turn turn) {

    }

    public GameReport gameReport() {
        return null;
    }

    public static class GameInitializer {

        private GameInitializer() {
        }

        public GameInitializer withId(Long gameSetId) {
            return this;
        }

        public GameInitializer withPlayers(String... players) {
            return this;
        }

        public GameInitializer withCardsOption(int major, int minor) {
            return this;
        }

        public GameReport initialize() {
            GameSet gameSet = GameSet.builder()
                    .color(1L, 100, 1)
                    .build();


            return null;
        }
    }
}
