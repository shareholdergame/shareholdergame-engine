package com.shareholdergame.engine.facade.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.shareholdergame.engine.common.support.ResponseWrapper;
import com.shareholdergame.engine.facade.dto.GameEvent;
import com.shareholdergame.engine.facade.dto.GameListResponse;
import com.shareholdergame.engine.facade.dto.GameOptionFilter;
import com.shareholdergame.engine.facade.dto.GameOwner;
import com.shareholdergame.engine.facade.dto.game.GameStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;

@Controller("/games")
@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Game")
public class GameController {

    /**
     * Returns list of games filtered by parameters.
     * @param gameOptionFilter game option.
     * @param gameStatus game status.
     * @param playerNamePrefix player name prefix. At least 3 symbols required.
     * @param offset pagination parameter offset (not required).
     * @param itemsPerPage pagination parameter number of items per page (not required).
     * @return list of games.
     */
    @Get("/{gameOptionFilter}/{gameStatus}")
    public ResponseWrapper<GameListResponse> getGames(@NotNull GameOptionFilter gameOptionFilter,
                                                      @NotNull GameStatus gameStatus,
                                                      @QueryValue("playerNamePrefix") @Nullable String playerNamePrefix,
                                                      @QueryValue(value = "offset", defaultValue = "0") @Parameter(required = false) int offset,
                                                      @QueryValue(value = "ipp", defaultValue = "10") @Parameter(required = false) int itemsPerPage,
                                                      Principal principal) {
        return ResponseWrapper.ok(new GameListResponse());
    }

    /**
     * Returns play statistics.
     * @return play statistics.
     */
    @Get("/statistics")
    public ResponseWrapper<Map<GameOptionFilter, Map<GameStatus, Map<GameOwner, Integer>>>> getStatistics(@NotNull Principal principal) {
        Map<GameOptionFilter, Map<GameStatus, Map<GameOwner, Integer>>> statistics =
                ImmutableMap.<GameOptionFilter, Map<GameStatus, Map<GameOwner, Integer>>>builder()
                        .put(GameOptionFilter.game_4x6, ImmutableMap.<GameStatus, Map<GameOwner, Integer>>builder()
                                .put(GameStatus.running, ImmutableMap.<GameOwner, Integer>builder()
                                        .put(GameOwner.my, 3)
                                        .put(GameOwner.other, 7)
                                        .build())
                                .put(GameStatus.finished, ImmutableMap.<GameOwner, Integer>builder()
                                        .put(GameOwner.my, 20)
                                        .put(GameOwner.other, 700)
                                        .build())
                                .build())
                        .put(GameOptionFilter.game_3x5, ImmutableMap.<GameStatus, Map<GameOwner, Integer>>builder()
                                .put(GameStatus.running, ImmutableMap.<GameOwner, Integer>builder()
                                        .put(GameOwner.my, 0)
                                        .put(GameOwner.other, 3)
                                        .build())
                                .put(GameStatus.finished, ImmutableMap.<GameOwner, Integer>builder()
                                        .put(GameOwner.my, 5)
                                        .put(GameOwner.other, 50)
                                        .build())
                                .build())
                        .build();
        return ResponseWrapper.ok(statistics);
    }

    /**
     * Returns latest events.
     * @param offset pagination parameter offset (not required).
     * @param itemsPerPage pagination parameter number of items per page (not required).
     * @return list of events.
     */
    @Get("/events")
    public ResponseWrapper<Collection<GameEvent>> getEvents(@QueryValue(value = "offset", defaultValue = "0") @Parameter(required = false) int offset,
                                                            @QueryValue(value = "ipp", defaultValue = "10") @Parameter(required = false) int itemsPerPage,
                                                            @NotNull Principal principal) {
        return ResponseWrapper.ok(Lists.newArrayList());
    }
}
