package com.shareholdergame.engine.account.service;

import com.shareholdergame.engine.account.dao.AccountDao;
import com.shareholdergame.engine.account.dao.FriendDao;
import com.shareholdergame.engine.account.dao.ProfileDao;
import com.shareholdergame.engine.account.model.Friend;
import com.shareholdergame.engine.account.model.Profile;
import com.shareholdergame.engine.api.profile.ProfileService;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Singleton
public class ProfileServiceImpl implements ProfileService {

    @Inject
    private AccountDao accountDao;

    @Inject
    private ProfileDao profileDao;

    @Inject
    private FriendDao friendDao;

    @Override
    public Profile getProfile(@NotBlank Long gamerId) {
        return profileDao.findById(gamerId);
    }

    @Override
    public void createFriendRequest(Long gamerId, Long friendId) {
        Friend friend = Friend.builder().gamerId(gamerId).friendId(friendId).requestedDate(LocalDateTime.now()).build();
        friendDao.insertFriend(friend);
        // todo - notify friend
    }
}
