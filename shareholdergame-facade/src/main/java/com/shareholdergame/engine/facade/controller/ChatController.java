package com.shareholdergame.engine.facade.controller;

import com.google.common.collect.Lists;
import com.shareholdergame.engine.common.support.ResponseWrapper;
import com.shareholdergame.engine.facade.dto.Chat;
import com.shareholdergame.engine.facade.dto.Duration;
import com.shareholdergame.engine.facade.dto.NewChatMessage;
import io.micronaut.http.MediaType;
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

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.Collection;

@Controller("/chat")
@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Chat")
public class ChatController {

    @Put("/send")
    public ResponseWrapper<?> sendChatMessage(@Body NewChatMessage newChatMessage, @NotNull Principal principal) {
        return ResponseWrapper.ok();
    }

    @Post(value = "/markasread", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    public ResponseWrapper<?> markAsRead(@QueryValue("messageIds") String[] messageIds) {
        return ResponseWrapper.ok();
    }

    @Get("/history/{duration}")
    public ResponseWrapper<?> chatHistory(@NotNull Duration duration) {
        return ResponseWrapper.ok();
    }

    @Get
    public ResponseWrapper<Collection<Chat>> getChats(@QueryValue(value = "unreadonly", defaultValue = "false") boolean unreadonly,
                                                      @QueryValue(value = "offset", defaultValue = "0") @Parameter(required = false) int offset,
                                                      @QueryValue(value = "ipp", defaultValue = "10") @Parameter(required = false) int itemsPerPage,
                                                      @NotNull Principal principal) {
        return ResponseWrapper.ok(Lists.newArrayList());
    }
}
