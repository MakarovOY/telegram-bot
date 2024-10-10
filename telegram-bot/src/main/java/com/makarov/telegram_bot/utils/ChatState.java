package com.makarov.telegram_bot.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChatState {
    private Status status;
    private ChatPayload payload;
}
