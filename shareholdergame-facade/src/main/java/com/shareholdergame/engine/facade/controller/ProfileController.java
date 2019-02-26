package com.shareholdergame.engine.facade.controller;

import com.shareholdergame.engine.common.http.ErrorBody;
import com.shareholdergame.engine.common.http.ResponseWrapper;
import com.shareholdergame.engine.facade.converter.Converters;
import com.shareholdergame.engine.facade.dto.FriendRequestAction;
import com.shareholdergame.engine.facade.dto.FriendsResponse;
import com.shareholdergame.engine.facade.dto.Pagination;
import com.shareholdergame.engine.facade.dto.PlayerAchievements;
import com.shareholdergame.engine.facade.dto.player.ProfileDetails;
import com.shareholdergame.engine.facade.dto.player.ProfileUpdate;
import com.shareholdergame.engine.facade.mock.MockDataProvider;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.multipart.StreamingFileUpload;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.reactivestreams.Publisher;

import javax.validation.constraints.NotBlank;
import java.io.File;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/profile")
@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Profile")
public class ProfileController {

    @Value("${facade.avatar.base.path:./}")
    private String basePath;

    /**
     * Returns user's profile.
     * @param principal user principal.
     * @return user's profile details.
     */
    @Get
    public ResponseWrapper<ProfileDetails> getProfile(Principal principal) {
        return ResponseWrapper.ok(Converters.convert(MockDataProvider.getProfiles().get(0)));
    }

    /**
     * Updates profile.
     * @param profileUpdate updated profile.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Post("/update")
    public ResponseWrapper<?> updateProfile(@Body ProfileUpdate profileUpdate, Principal principal) {
        return ResponseWrapper.ok();
    }

    /**
     * Uploads avatar.
     * @param file image file (jpg or png).
     * @return response.
     */
    @Post(value = "/avatar", consumes = MediaType.MULTIPART_FORM_DATA)
    public Single<ResponseWrapper<?>> upload(StreamingFileUpload file) {
        File tempFile = new File(basePath + file.getFilename());
        Publisher<Boolean> uploadPublisher = file.transferTo(tempFile);
        return Single.fromPublisher(uploadPublisher)
                .map(success -> success ? ResponseWrapper.ok() : ResponseWrapper.error(ErrorBody.of("Avatar upload failed")));
    }

    /**
     * Returns list of friends.
     * @param friendRequest if true method returns list of friend requests.
     * @param offset pagination parameter offset (not required).
     * @param itemsPerPage pagination parameter number of items per page (not required).
     * @param principal user principal.
     * @return list of friends.
     */
    @Get("/friends")
    public ResponseWrapper<FriendsResponse> getFriends(@QueryValue("request") Boolean friendRequest,
                                                       @QueryValue(value = "offset", defaultValue = "0") @Parameter int offset,
                                                       @QueryValue(value = "ipp", defaultValue = "10") @Parameter int itemsPerPage,
                                                       Principal principal) {
        List<PlayerAchievements> playerAchievements = MockDataProvider.playerAchievements();

        int itemsCount = playerAchievements.size();
        int fromIndex = offset < 0 || offset >= itemsCount ? 0 : offset;
        int toIndex = offset + itemsPerPage >= itemsCount ? itemsCount : offset + itemsPerPage;

        FriendsResponse friendsResponse = new FriendsResponse();
        friendsResponse.setPagination(Pagination.of(itemsCount, offset, itemsPerPage));
        friendsResponse.setPlayers(playerAchievements.subList(fromIndex, toIndex).stream().map(pa -> pa.player).collect(Collectors.toList()));

        return ResponseWrapper.ok(friendsResponse);
    }

    /**
     * Perform specified action on friend request.
     * @param action friend request action.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Post("/friends/{playerName}")
    public ResponseWrapper<?> performRequestAction(@NotBlank String playerName,
                                                   @QueryValue("action") FriendRequestAction action, Principal principal) {
        return ResponseWrapper.ok();
    }

    /**
     * Sends request to player to add him as friend.
     * @param playerName player name.
     * @param principal user principal.
     * @return empty response if ok.
     */
    @Put("/friends/{playerName}")
    public ResponseWrapper<?> addFriend(@NotBlank String playerName, Principal principal) {
        return ResponseWrapper.ok();
    }
}
