package com.makarov.telegram_bot.processors;

import com.makarov.telegram_bot.dto.Update;
import com.makarov.telegram_bot.utils.ChatPayload;
import com.makarov.telegram_bot.utils.ChatState;
import com.makarov.telegram_bot.utils.Status;

public interface Processor {
    Status getHandledStatus();
    ChatState process(ChatPayload payload, Update update);
}
