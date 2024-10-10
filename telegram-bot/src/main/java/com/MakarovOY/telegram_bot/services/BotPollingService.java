package com.MakarovOY.telegram_bot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BotPollingService {

    private final RestTemplate tgClient;

    @Scheduled(fixedDelay = 2000)
    public void poll() {
        ResponseEntity<String> updates = tgClient.getForEntity("/getUpdates", String.class);
        System.out.println(updates);
    }

}
