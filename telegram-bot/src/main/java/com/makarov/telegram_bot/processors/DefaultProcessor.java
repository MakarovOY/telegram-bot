package com.makarov.telegram_bot.processors;

import com.makarov.telegram_bot.dto.Update;
import com.makarov.telegram_bot.utils.*;
import com.makarov.telegram_bot.utils.Status;
import com.makarov.telegram_bot.utils.TgClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProcessor implements Processor {
    public final static List<String> BUTTONS = List.of(Buttons.SOLVE_EQ, Buttons.SEND_IMG);

    private final TgClient tgClient;

    @Override
    public Status getHandledStatus() {
        return Status.DEFAULT;
    }

    @Override
    public ChatState process(ChatPayload payload, Update update) {
        String responseText = update.getMessage().getText();
        switch (responseText) {
            case Buttons.SOLVE_EQ:
                tgClient.sendMessage(
                        "Hello!\nPlease enter A: ",
                        update.getMessage().getChat().getId()
                );
                return new ChatState(Status.ENTER_A, new ChatPayload());
            case Buttons.SEND_IMG:
                tgClient.sendImage("/home/dmitrii/Programming/Java/rm/hexlet-tg-bot/src/main/resources/lena.png",
                        update.getMessage().getChat().getId(),
                        BUTTONS);
                return new ChatState(Status.DEFAULT, new ChatPayload());
            default:
                throw new RuntimeException("Неизвестная команда");
        }

    }
}
