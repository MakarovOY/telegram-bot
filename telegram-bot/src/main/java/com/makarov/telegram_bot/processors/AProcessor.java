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
public class AProcessor implements Processor {
    private final TgClient tgClient;

    @Override
    public Status getHandledStatus() {
        return Status.ENTER_A;
    }

    @Override
    public ChatState process(ChatPayload payload, Update update) {
        int a = Integer.parseInt(update.getMessage().getText());
        var newPayload = new ChatPayload();
        newPayload.setA(a);
        tgClient.sendMessage("Hello!\nPlease enter B: ", update.getMessage().getChat().getId());
        return new ChatState(Status.ENTER_B, newPayload);
    }
}
