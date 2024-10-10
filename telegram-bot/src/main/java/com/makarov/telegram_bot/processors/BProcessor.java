package com.makarov.telegram_bot.processors;

import com.makarov.telegram_bot.dto.Update;
import com.makarov.telegram_bot.utils.ChatPayload;
import com.makarov.telegram_bot.utils.ChatState;
import com.makarov.telegram_bot.utils.Status;
import com.makarov.telegram_bot.utils.TgClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BProcessor implements Processor {
    private final TgClient tgClient;

    @Override
    public Status getHandledStatus() {
        return Status.ENTER_B;
    }

    @Override
    public ChatState process(ChatPayload payload, Update update) {
        int b = Integer.parseInt(update.getMessage().getText());
        var newPayload = new ChatPayload();
        newPayload.setA(payload.getA());
        newPayload.setB(b);
        tgClient.sendMessage("Hello!\nPlease enter C: ", update.getMessage().getChat().getId());
        return new ChatState(Status.ENTER_C, newPayload);
    }
}
