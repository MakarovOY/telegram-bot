package com.makarov.telegram_bot.processors;

import com.makarov.telegram_bot.dto.Update;
import com.makarov.telegram_bot.utils.ChatPayload;
import com.makarov.telegram_bot.utils.ChatState;
import com.makarov.telegram_bot.utils.Status;
import com.makarov.telegram_bot.utils.TgClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ErrorProcessor implements Processor{

    private final TgClient tgClient;

    @Override
    public Status getHandledStatus() {
        return Status.ERROR;
    }

    @Override
    public ChatState process(ChatPayload payload, Update update) {
        tgClient.sendMessage(
                "Произошла ошибка. \nВведите что-нибудь",
                update.getMessage().getChat().getId(),
                DefaultProcessor.BUTTONS);
        return new ChatState(Status.DEFAULT, new ChatPayload());
    }
}
