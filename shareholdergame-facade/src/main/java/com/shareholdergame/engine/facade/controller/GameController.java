package com.shareholdergame.engine.facade.controller;

import com.shareholdergame.engine.facade.dto.GameListResponse;
import com.shareholdergame.engine.facade.dto.GameOptionFilter;
import com.shareholdergame.engine.facade.dto.game.Game;
import com.shareholdergame.engine.facade.dto.game.GameStatus;
import com.shareholdergame.engine.common.support.ResponseWrapper;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.Principal;

@Controller("/games")
@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Game")
public class GameController {

    /**
     * Returns game report.
     * @param gameId game identifier.
     * @param principal user principal.
     * @return game object.
     */
    @Get("/game/{gameId}")
    public ResponseWrapper<Game> gameById(@NotBlank String gameId, Principal principal) {
        return ResponseWrapper.ok(new Game());
    }

    /**
     * Returns list of games filtered by parameters.
     * @param gameStatus game status.
     * @param gameOptionFilter game option.
     * @param playerNamePrefix player name prefix. At least 3 symbols required.
     * @param offset pagination parameter offset (not required).
     * @param itemsPerPage pagination parameter number of items per page (not required).
     * @return list of games.
     */
    @Get("/{gameStatus}/{gameOptionFilter}")
    public ResponseWrapper<GameListResponse> getGames(@NotNull GameStatus gameStatus,
                                                      @NotNull GameOptionFilter gameOptionFilter,
                                                      @QueryValue("playerNamePrefix") String playerNamePrefix,
                                                      @QueryValue(value = "offset", defaultValue = "0") @Parameter int offset,
                                                      @QueryValue(value = "ipp", defaultValue = "10") @Parameter int itemsPerPage,
                                                      Principal principal) {
        return ResponseWrapper.ok(new GameListResponse());
    }
}
