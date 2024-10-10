package com.makarov.telegram_bot.repositoties;

import com.makarov.telegram_bot.utils.ChatPayload;
import com.makarov.telegram_bot.utils.ChatState;
import com.makarov.telegram_bot.utils.Status;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ChatStateRepository {
    private final Map<Long, ChatState> states = new ConcurrentHashMap<>();

    public ChatState getState(Long chat) {
        return states.getOrDefault(chat, new ChatState(Status.DEFAULT, new ChatPayload()));
    }

    public void updateState(Long chat, ChatState state) {
        states.put(chat, state);
    }
}
