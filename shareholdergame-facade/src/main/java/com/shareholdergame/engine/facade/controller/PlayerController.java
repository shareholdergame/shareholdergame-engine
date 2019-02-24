package com.shareholdergame.engine.facade.controller;

import com.shareholdergame.engine.common.support.ResponseWrapper;
import com.shareholdergame.engine.facade.dto.Filter;
import com.shareholdergame.engine.facade.dto.GameOptionFilter;
import com.shareholdergame.engine.facade.dto.Pagination;
import com.shareholdergame.engine.facade.dto.PlayerAchievements;
import com.shareholdergame.engine.facade.dto.PlayerAchievementsResponse;
import com.shareholdergame.engine.facade.dto.PlayerListResponse;
import com.shareholdergame.engine.facade.dto.player.PlayerProfile;
import com.shareholdergame.engine.facade.dto.player.PlayerWithLocation;
import com.shareholdergame.engine.facade.mock.MockDataProvider;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Players achievements controller.
 *
 * @author Aliaksandr Savin
 */
@Controller("/player")
@Secured(SecurityRule.IS_ANONYMOUS)
@Validated
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Player")
public class PlayerController {

    /**
     * Returns player profile.
     *
     * @param playerName name of player.
     * @return player profile.
     */
    @Get("/profile/{playerName}")
    public ResponseWrapper<PlayerProfile> playerProfile(@NotBlank String playerName) {
        List<PlayerAchievements> playerAchievementsList = MockDataProvider.playerAchievements();
        PlayerAchievements playerAchievements = playerAchievementsList.stream().filter(pa -> pa.player.name.equalsIgnoreCase(playerName))
                .findFirst().orElse(null);

        if (null == playerAchievements) {
            throw new HttpStatusException(HttpStatus.NOT_FOUND, playerName);
        }

        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.player = playerAchievements.player;
        playerProfile.location = playerAchievements.location;
        playerProfile.personalInfo = MockDataProvider.getPersonalInfo();

        return ResponseWrapper.ok(playerProfile);
    }

    /**
     * Returns list of players with their achievements for specified game option.
     *
     * @param gameOptionFilter game option. Possible values: game_3x5, game_4x6, custom (required).
     * @param offset pagination parameter offset (not required).
     * @param itemsPerPage pagination parameter number of items per page (not required).
     * @return list of players with their achievements.
     */
    @Get("/achievements/{gameOptionFilter}")
    public ResponseWrapper<PlayerAchievementsResponse> allPlayersAchievements(GameOptionFilter gameOptionFilter,
                                                                              @QueryValue(value = "offset", defaultValue = "0") @Parameter(required = false) int offset,
                                                                              @QueryValue(value = "ipp", defaultValue = "10") @Parameter(required = false) int itemsPerPage) {
        List<PlayerAchievements> playerAchievementsList = MockDataProvider.playerAchievements();

        if (playerAchievementsList.size() == 0) {
            return ResponseWrapper.ok(PlayerAchievementsResponse.of(Filter.of(gameOptionFilter, null),
                    Pagination.of(playerAchievementsList.size(), 0, itemsPerPage), Collections.emptyList()));
        }

        int itemsCount = playerAchievementsList.size();
        int fromIndex = offset < 0 || offset >= itemsCount ? 0 : offset;
        int toIndex = offset + itemsPerPage >= itemsCount ? itemsCount : offset + itemsPerPage;

        return ResponseWrapper.ok(PlayerAchievementsResponse.of(Filter.of(gameOptionFilter, null),
                Pagination.of(playerAchievementsList.size(), fromIndex, itemsPerPage), playerAchievementsList.subList(fromIndex, toIndex)));
    }

    /**
     * Returns achievements of player [playerName].
     *
     * @param playerName player name.
     * @param gameOptionFilter game option. Possible values: game_3x5, game_4x6, custom (required).
     * @param offset pagination parameter offset (not required).
     * @param itemsPerPage pagination parameter number of items per page (not required).
     * @return achievements of player.
     */
    @Get("/achievements/{gameOptionFilter}/{playerName}")
    public ResponseWrapper<PlayerAchievementsResponse> singlePlayerAchievements(@NotBlank String playerName,
                                                                                GameOptionFilter gameOptionFilter,
                                                                                @QueryValue(value = "offset", defaultValue = "0") @Parameter(required = false) int offset,
                                                                                @QueryValue(value = "ipp", defaultValue = "10") @Parameter(required = false) int itemsPerPage) {
        List<PlayerAchievements> playerAchievementsList = MockDataProvider.playerAchievements();

        if (playerAchievementsList.size() == 0) {
            return ResponseWrapper.ok(PlayerAchievementsResponse.of(Filter.of(gameOptionFilter, playerName),
                Pagination.of(playerAchievementsList.size(), 0, itemsPerPage),
                    Collections.emptyList()));
        }
        List<PlayerAchievements> filteredList = playerAchievementsList.stream()
                .filter(playerAchievements -> !playerAchievements.player.name.equalsIgnoreCase(playerName)).collect(Collectors.toList());

        int itemsCount = filteredList.size();
        int fromIndex = offset < 0 || offset >= itemsCount ? 0 : offset;
        int toIndex = offset + itemsPerPage >= itemsCount ? itemsCount : offset + itemsPerPage;
        return ResponseWrapper.ok(PlayerAchievementsResponse.of(Filter.of(gameOptionFilter, playerName),
            Pagination.of(playerAchievementsList.size(), fromIndex, itemsPerPage),
                playerAchievementsList.subList(fromIndex, toIndex)));
    }

    /**
     * Lists players filtered by specified parameters.
     *
     * @param playerNamePrefix player name prefix (at least first 3 letters or full name).
     * @param offset pagination parameter offset (not required).
     * @param itemsPerPage pagination parameter number of items per page (not required).
     * @return players list filtered by specified parameters.
     */
    @Get
    public ResponseWrapper<PlayerListResponse> searchPlayer(@QueryValue(value = "playerNamePrefix") @Nullable String playerNamePrefix,
                                                            @QueryValue("online") @Nullable Boolean online,
                                                            @QueryValue("friend") @Nullable Boolean friend,
                                                            @QueryValue(value = "offset", defaultValue = "0") @Parameter(required = false) int offset,
                                                            @QueryValue(value = "ipp", defaultValue = "10") @Parameter(required = false) int itemsPerPage) {
        List<PlayerAchievements> playerAchievementsList = MockDataProvider.playerAchievements();

        List<PlayerAchievements> filteredList = playerAchievementsList.stream()
            .filter(playerAchievements -> playerNamePrefix == null || StringUtils.startsWithIgnoreCase(playerAchievements.player.name, playerNamePrefix))
            .collect(Collectors.toList());

        int itemsCount = filteredList.size();
        int fromIndex = offset < 0 || offset >= itemsCount ? 0 : offset;
        int toIndex = offset + itemsPerPage >= itemsCount ? itemsCount : offset + itemsPerPage;

        List<PlayerWithLocation> playerWithLocations = filteredList.stream()
            .map(playerAchievements -> {
                PlayerWithLocation pl = new PlayerWithLocation();
                pl.player = playerAchievements.player;
                pl.location = playerAchievements.location;
                return pl;
            })
            .collect(Collectors.toList()).subList(fromIndex, toIndex);

        PlayerListResponse playerListResponse = new PlayerListResponse();
        playerListResponse.pagination = Pagination.of(playerWithLocations.size(), offset, itemsPerPage);
        playerListResponse.players = playerWithLocations;

        return ResponseWrapper.ok(playerListResponse);
    }
}
