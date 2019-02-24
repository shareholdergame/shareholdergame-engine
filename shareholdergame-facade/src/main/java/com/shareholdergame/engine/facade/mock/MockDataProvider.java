package com.shareholdergame.engine.facade.mock;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.shareholdergame.engine.account.model.GamerAccount;
import com.shareholdergame.engine.account.model.AccountStatus;
import com.shareholdergame.engine.account.model.AccountWithPassword;
import com.shareholdergame.engine.account.model.Profile;
import com.shareholdergame.engine.common.exception.ApplicationException;
import com.shareholdergame.engine.facade.dto.Achievements;
import com.shareholdergame.engine.facade.dto.Location;
import com.shareholdergame.engine.facade.dto.PlayerAchievements;
import com.shareholdergame.engine.facade.dto.player.Player;
import com.shareholdergame.engine.facade.dto.player.PlayerPersonalInfo;
import com.shareholdergame.engine.facade.dto.player.PlayerSession;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 10/05/2018
 *
 * @author Aliaksandr Savin
 */
public final class MockDataProvider {

    private static final ArrayList<AccountWithPassword> ACCOUNT_WITH_PASSWORDS = Lists.newArrayList(
            AccountWithPassword.builder()
                    .account(
                            GamerAccount.builder().withId(1L)
                                    .withUserName("sergeychernyshev")
                                    .withEmail("player1@shareholdergame.com")
                                    .withStatus(AccountStatus.ACTIVE)
                                    .withCreationDate(LocalDate.of(2015, 8, 1))
                                    .withLanguage("EN")
                                    .build())
                    .password("123456").build(),
            /*AccountWithPassword.builder()
                    .account(
                            Account.builder().withId(1L)
                                    .withUserName("Admin")
                                    .withEmail("player2@shareholdergame.com")
                                    .withStatus(AccountStatus.ACTIVE)
                                    .withCreationDate(LocalDate.of(2015, 8, 1))
                                    .withLanguage("EN")
                                    .build())
                    .password("123456").build(),*/
            AccountWithPassword.builder()
                    .account(
                            GamerAccount.builder().withId(1L)
                                    .withUserName("Зырянов")
                                    .withEmail("player3@shareholdergame.com")
                                    .withStatus(AccountStatus.ACTIVE)
                                    .withCreationDate(LocalDate.of(2015, 8, 1))
                                    .withLanguage("RU")
                                    .build())
                    .password("123456").build()
    );

    private static ObjectMapper mapper = new ObjectMapper();

    private static TypeReference<List<PlayerAchievements>> userStatTypeRef = new TypeReference<List<PlayerAchievements>>() { };

    private MockDataProvider() {
    }

    public static List<PlayerAchievements> playerAchievements() {
        try {
            URL url = MockDataProvider.class.getResource("/mockdata/players.json").toURI().toURL();
            JsonNode rootNode = mapper.readTree(url);
            JsonNode userStatNode = rootNode.get("userStatistics");
            if (userStatNode.isArray()) {
                List<PlayerAchievements> playerAchievementsList = new ArrayList<>(userStatNode.size());
                for (JsonNode item : userStatNode) {
                    JsonNode userNode = item.get("user");

                    String userName = userNode.get("userName").asText();
                    Player p = new Player();
                    p.id = userName;
                    p.name = userName;
                    p.online = userNode.get("online").asBoolean();
                    p.removed = userNode.get("removed").asBoolean();

                    PlayerSession ps = new PlayerSession();
                    ps.lastPlay = item.get("daysAfterLastPlay").asLong();
                    ps.lastVisit = item.get("daysAfterLastVisit").asLong();

                    JsonNode profileNode = userNode.get("profile");
                    Location pp = new Location();
                    pp.setCountry(profileNode.has("country") ? profileNode.get("country").asText() : "");
                    pp.setCity(profileNode.has("city") ? profileNode.get("city").asText() : "");

                    Achievements a = new Achievements(
                            item.get("gameSeriesCount").asLong(),
                            item.get("gameSeriesWinsCount").asLong(),
                            item.get("firstOrderWinsCount").asLong(),
                            item.get("secondOrderWinsCount").asLong(),
                            item.get("drawsCount").asLong(),
                            item.get("drawsCount").asLong(),
                            item.get("gameSeriesCount").asLong() - item.get("drawsCount").asLong() - item.get("gameSeriesWinsCount").asLong(),
                            item.get("bankruptsCount").asLong(),
                            item.get("winsRatio").asDouble(),
                            item.get("maxTotal").asLong(),
                            item.get("maxDiff").asLong(),
                            item.get("totalWinned").asLong()
                    );

                    PlayerAchievements pa = new PlayerAchievements();
                    pa.player = p;
                    pa.location = pp;
                    pa.playerSession = ps;
                    pa.achievements = a;

                    playerAchievementsList.add(pa);
                }
                return playerAchievementsList;
            } else {
                throw new ApplicationException("Wrong json structure");
            }
        } catch (IOException | URISyntaxException e ) {
            throw new ApplicationException(e);
        }
    }

    public static PlayerPersonalInfo getPersonalInfo() {
        try {
            URL url = MockDataProvider.class.getResource("/mockdata/player-personal-info.json").toURI().toURL();
            return mapper.readValue(url, PlayerPersonalInfo.class);
        } catch (URISyntaxException | IOException e) {
            throw new ApplicationException(e);
        }
    }

    public static List<AccountWithPassword> getAccountWithPasswordList() {
        return ACCOUNT_WITH_PASSWORDS;
    }

    public static List<Profile> getProfiles() {
        return Lists.newArrayList(
                Profile.builder()
                        .withCity("New York")
                        .withCountry("US")
                        .withStateProvince("NY")
                        .withAbout("I like play cards")
                        .withBirthday(LocalDate.of(1977, 12,12))
                        .build()
        );
    }
}
