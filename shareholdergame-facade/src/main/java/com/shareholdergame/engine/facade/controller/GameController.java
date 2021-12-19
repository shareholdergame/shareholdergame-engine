package com.shareholdergame.engine.facade.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.shareholdergame.engine.api.game.GameService;
import com.shareholdergame.engine.common.http.ResponseWrapper;
import com.shareholdergame.engine.facade.dto.GameEvent;
import com.shareholdergame.engine.facade.dto.GameListResponse;
import com.shareholdergame.engine.facade.dto.GameOptionFilter;
import com.shareholdergame.engine.facade.dto.GameOwner;
import com.shareholdergame.engine.facade.dto.InvitationAction;
import com.shareholdergame.engine.facade.dto.Pagination;
import com.shareholdergame.engine.facade.dto.game.GameSetReport;
import com.shareholdergame.engine.facade.dto.game.GameStatusParameter;
import com.shareholdergame.engine.facade.dto.game.NewGame;
import com.shareholdergame.engine.facade.dto.game.Turn;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.annotation.Nullable;
import jakarta.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;

@Controller("/game")
@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Game")
public class GameController {

    @Inject
    private GameService gameService;

    /**
     * Initiates new game.
     * @param newGame object with game options and invited users.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Put("/new")
    public ResponseWrapper<?> startGame(@NotNull @Body NewGame newGame,
                                        Principal principal) {
        Long gameId = gameService.startGame(newGame.options, principal.getName(), newGame.invitedPlayers.toArray(new String[0]));
        return ResponseWrapper.ok(gameId);
    }

    /**
     * Perform action on invitation.
     * @param gameId invitation identifier.
     * @param invitationAction invitation action.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Post("/{gameId}/invitation")
    public ResponseWrapper<?> performInvitationAction(@NotBlank String gameId,
                                                      @QueryValue("action") InvitationAction invitationAction,
                                                      Principal principal) {
        return ResponseWrapper.ok();
    }

    /**
     * Returns game report.
     * @param gameId game identifier.
     * @param principal user principal.
     * @return game object.
     */
    @Get("/{gameId}/report")
    public ResponseWrapper<GameSetReport> gameById(@NotBlank String gameId, Principal principal) {
        return ResponseWrapper.ok(new GameSetReport());
    }

    /**
     * Apply turn on game.
     * @param gameId game identifier.
     * @param turn turn data.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Put("/{gameId}/doturn")
    public ResponseWrapper<?> doTurn(@NotBlank String gameId, @Body @NotNull Turn turn, Principal principal) {
        return ResponseWrapper.ok();
    }

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
                                                      @NotNull GameStatusParameter gameStatus,
                                                      @QueryValue("playerNamePrefix") @Nullable String playerNamePrefix,
                                                      @QueryValue(value = "offset", defaultValue = "0") @Parameter(required = false) int offset,
                                                      @QueryValue(value = "ipp", defaultValue = "10") @Parameter(required = false) int itemsPerPage,
                                                      Principal principal) {
        return ResponseWrapper.ok(GameListResponse.of(Lists.newArrayList(), Pagination.of(0, offset, itemsPerPage)));
    }

    /**
     * Returns play statistics.
     * @return play statistics.
     */
    @Get("/statistics")
    public ResponseWrapper<Map<GameOptionFilter, Map<GameStatusParameter, Map<GameOwner, Integer>>>> getStatistics(Principal principal) {
        Map<GameOptionFilter, Map<GameStatusParameter, Map<GameOwner, Integer>>> statistics =
                ImmutableMap.<GameOptionFilter, Map<GameStatusParameter, Map<GameOwner, Integer>>>builder()
                        .put(GameOptionFilter.game_4x6, ImmutableMap.<GameStatusParameter, Map<GameOwner, Integer>>builder()
                                .put(GameStatusParameter.running, ImmutableMap.<GameOwner, Integer>builder()
                                        .put(GameOwner.my, 3)
                                        .put(GameOwner.other, 7)
                                        .build())
                                .put(GameStatusParameter.finished, ImmutableMap.<GameOwner, Integer>builder()
                                        .put(GameOwner.my, 20)
                                        .put(GameOwner.other, 700)
                                        .build())
                                .build())
                        .put(GameOptionFilter.game_3x5, ImmutableMap.<GameStatusParameter, Map<GameOwner, Integer>>builder()
                                .put(GameStatusParameter.running, ImmutableMap.<GameOwner, Integer>builder()
                                        .put(GameOwner.my, 0)
                                        .put(GameOwner.other, 3)
                                        .build())
                                .put(GameStatusParameter.finished, ImmutableMap.<GameOwner, Integer>builder()
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
                                                            Principal principal) {
        return ResponseWrapper.ok(Lists.newArrayList());
    }
}
