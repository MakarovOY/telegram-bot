package com.makarov.telegram_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableKafka
public class TelegramBotApplication {


	public static void main(String[] args) {
		SpringApplication.run(TelegramBotApplication.class, args);
	}

}
