package com.makarov.telegram_bot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UpdateResponse {
    private boolean ok;
    private List<Update> result;
}
