package com.makarov.telegram_bot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseMessage {
    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("text")
    private String text;

}
