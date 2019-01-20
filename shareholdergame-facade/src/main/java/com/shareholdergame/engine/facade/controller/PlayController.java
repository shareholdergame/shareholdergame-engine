package com.shareholdergame.engine.facade.controller;

import com.shareholdergame.engine.common.support.ResponseWrapper;
import com.shareholdergame.engine.facade.dto.InvitationAction;
import com.shareholdergame.engine.facade.dto.NewGame;
import com.shareholdergame.engine.facade.dto.game.Game;
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
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.Principal;

@Controller("/game")
@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Play Game")
public class PlayController {

    /**
     * Initiates new game.
     * @param newGame object with game options and invited users.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Put("/new")
    public ResponseWrapper<?> startGame(@NotNull @Body NewGame newGame,
                                        Principal principal) {
        return ResponseWrapper.ok();
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
                                                      @NotNull Principal principal) {
        return ResponseWrapper.ok();
    }

    /**
     * Returns game report.
     * @param gameId game identifier.
     * @param principal user principal.
     * @return game object.
     */
    @Get("/{gameId}")
    public ResponseWrapper<Game> gameById(@NotBlank String gameId, Principal principal) {
        return ResponseWrapper.ok(new Game());
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
}
